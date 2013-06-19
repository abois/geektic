package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.Geek;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekTest {

	private GeekService geekService;
	private GeekDao mockedGeekDao;
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
	}
	
	@Test
	public void testFeelLuckyWhenDbIsEmpty() {
		try {
			when(mockedGeekDao.feelLucky()).thenCallRealMethod();
			Long id = 1l;
			Geek result = geekService.feelLucky();
			assertEquals(result, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
