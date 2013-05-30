import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.Geek;
import model.Interest;

import org.junit.Test;

import service.GeekService;
import dao.GeekDao;

public class GeekTest {

	
	@Test
	public void testFeelLucky() {
		Geek geek = new Geek(1l, "Jean", "Dupond", "jd@orange.fr");
		Interest i1 = new Interest(1l, "python");
		
		geek.getInterests().add(i1);
		
		GeekDao mockedGeekDao = mock(GeekDao.class);
		GeekService service = new GeekService(mockedGeekDao);
		try {
			when(mockedGeekDao.feelLucky()).thenReturn(geek);
			Long id = 1l;
			Geek result = service.feelLucky();
			assertEquals(result, geek);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
