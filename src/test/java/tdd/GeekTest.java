package tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.Geek;
import model.Interest;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekTest {

	private GeekService geekService;
	private GeekDao mockedGeekDao;
	private List<Geek> geeks = new ArrayList<Geek>();
	private final Geek geek1 = new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false);
	private final Geek geek2 = new Geek(2L, "Ariane", "Dupond", "ad@orange.fr", true);
	private final Geek geek3 = new Geek(3L, "Martine", "Dupond", "md@orange.fr", true);
	private final List<Geek> geekPythonResults = new ArrayList<Geek>();
	private final Interest interest1 = new Interest(1L, "Python");
	private final Interest interest2 = new Interest(2L, "Java");
	private final List<Interest> pythonJavaInterests = new ArrayList<Interest>();
	private final List<Interest> pythonInterests = new ArrayList<Interest>();
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
		/* Geek in DB */
		geeks.add(geek1);
		geeks.add(geek2);
		geeks.add(geek3);
		/* 2nd Geek */
		geek2.setInterests(pythonJavaInterests);
		pythonJavaInterests.add(interest1);
		pythonJavaInterests.add(interest2);
		/* 3eme Geek */
		geek2.setInterests(pythonInterests);
		pythonInterests.add(interest1);
		/* Geeks ayant pour interet python */
		geekPythonResults.add(geek2);
		geekPythonResults.add(geek3);
	}
	
	@Test
	public void testFeelLuckyWhenDbIsEmpty() {
		when(mockedGeekDao.findAll()).thenReturn(null);
		when(mockedGeekDao.findByInterests(pythonInterests)).thenReturn(null);
		Geek result = geekService.feelLucky(pythonInterests);
		assertNull(result);
	}
	
	@Test
	public void testFeelLuckyWhenGeekWithoutInterests() {
		when(mockedGeekDao.findAll()).thenReturn(geeks);
		when(mockedGeekDao.findByInterests(pythonInterests)).thenReturn(null);
		Geek result = geekService.feelLucky(pythonInterests);
		assertNull(result);
	}
	
	@Test
	public void testFeelLuckyWithInterests() {
		when(mockedGeekDao.findAll()).thenReturn(geeks);
		when(mockedGeekDao.findByInterests(pythonInterests)).thenReturn(geekPythonResults);
		Geek result = geekService.feelLucky(pythonInterests);
		assertEquals(result.getId(), geek2.getId());
	}
	/*
	@Test
	public void testFeelLuckyTwiceInARowDontReturnTheSameGeek() {
		geeks.add(geek1);
		geeks.add(geek2);
		geeks.add(geek3);
		when(mockedGeekDao.findByInterests(interests)).thenCallRealMethod();
		Geek result1 = geekService.feelLucky(interests);
		Geek result2 = geekService.feelLucky(interests);
		System.out.println(result1.getId() + " " + result2.getId());
		assertFalse(result1.getId() == result2.getId());
	}*/
	
}
