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
	private List<Geek> geeks;
	private final Geek geek1 = new Geek(1L, "Jean", "Dupond", "jd@orange.fr", false);
	private final Geek geek2 = new Geek(2L, "Ariane", "Dupond", "ad@orange.fr", true);
	private final Geek geek3 = new Geek(3L, "Martine", "Dupond", "md@orange.fr", true);
	private final Interest interest1 = new Interest(1L, "Python");
	private final Interest interest2 = new Interest(2L, "Java");
	private final Interest interest3 = new Interest(3L, "C++");
	private final List<Interest> interests = new ArrayList<Interest>();
	private final List<Interest> interests2 = new ArrayList<Interest>();
	
	@Before
	public void setUp() {
		mockedGeekDao = mock(GeekDao.class);
		geekService = new GeekService(mockedGeekDao);
		geeks = new ArrayList<Geek>();
		interests.add(interest1);
		geek2.setInterests(interests);
		interests2.add(interest1);
		interests2.add(interest2);
		interests2.add(interest3);
		geek3.setInterests(interests2);
	}
	
	@Test
	public void testFeelLuckyWhenDbIsEmpty() {
		when(mockedGeekDao.findByInterests(interests)).thenCallRealMethod();
		Geek result = geekService.feelLucky(interests);
		assertNull(result);
	}
	
	/*@Test
	public void testFeelLuckyWhenDbContainsOneGeek() {
		geeks.add(geek1);
		when(mockedGeekDao.findByInterests(interests)).thenReturn(geeks);
		Geek result = geekService.feelLucky(interests);
		assertEquals(result.getId(), geek1.getId());
	}
	
	@Test
	public void testFeelLuckyWithInterests() {
		geeks.add(geek1);
		geeks.add(geek2);
		when(mockedGeekDao.findByInterests(interests)).thenCallRealMethod();
		Geek result = geekService.feelLucky(interests);
		assertEquals(result.getId(), geek2.getId());
	}
	
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
