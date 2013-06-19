package tdd;

import static org.junit.Assert.assertEquals;
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
	private List<Geek> geeks;
	private final Geek geek1 = new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false);
	private final Geek geek2 = new Geek(1L, "Ariane", "Dupond", "ad@orange.fr", false);
	private final Interest interest1 = new Interest(1L, "Python");
	private final List<Interest> interests = new ArrayList<Interest>();
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
		geeks = new ArrayList<Geek>();
		interests.add(interest1);
		geek2.setInterests(interests);
	}
	
	@Test
	public void testFeelLuckyWhenDbIsEmpty() {
		try {
			when(mockedGeekDao.findAll()).thenReturn(null);
			Geek result = geekService.feelLucky();
			assertEquals(result, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFeelLuckyWhenDbContainsOneGeek() {
		geeks.add(geek1);
		try {
			when(mockedGeekDao.findAll()).thenReturn(geeks);
			Geek result = geekService.feelLucky();
			assertEquals(result, geek1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFeelLuckyWithInterests() {
		geeks.add(geek1);
		geeks.add(geek2);
		try {
			when(mockedGeekDao.findAll()).thenReturn(geeks);
			Geek result = geekService.feelLucky();
			assertEquals(result, geek2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
