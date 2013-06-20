package tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekDrinkTonightTest {

	private GeekService geekService;
	private GeekDao mockedGeekDao;
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
	}
	
	@Test
	public void testDrinkTonightDayDAt10am() {
		//when(mockedGeekDao.findDrinkTonight()).thenReturn(false);
		boolean result = geekService.drinkTonight();
		assertEquals(result, true);
	}
}
