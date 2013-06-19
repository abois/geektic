package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.Geek;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekTest {

	private GeekService geekService;
	private GeekDao mockedGeekDao;
	private List<Geek> geeks;
	private final Geek geek1 = new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false);
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
		geeks = new ArrayList<Geek>();
	}
	
	@Test
	public void testFeelLuckyWhenDbIsEmpty() {
		try {
			when(mockedGeekDao.feelLucky()).thenReturn(null);
			Geek result = geekService.feelLucky();
			assertEquals(result, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFeelLuckyWhenDbContainsOneGeek() {
		geeks.add(new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false));
		try {
			when(mockedGeekDao.feelLucky()).thenCallRealMethod();
			Geek result = geekService.feelLucky();
			assertEquals(result, geek1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
