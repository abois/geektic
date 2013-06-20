package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import model.Geek;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekDrinkTonightTest {

	private GeekService geekService;
	private GeekDao mockedGeekDao;
	private Geek geek1;
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
		geek1 = new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false);
	}
	
	@Test
	public void testDrinkTonightSettedDayDAt10am() {
		boolean result = geekService.drinkTonight(geek1);
		assertEquals(result, true);
	}
}
