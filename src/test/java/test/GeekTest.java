package test;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.GeekService;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import dao.GeekDao;


public class GeekTest {

	private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
	
	@Before
    public void prepare() throws Exception {
        Operation operation =
            sequenceOf(
                CommonOperations.DELETE_ALL,
                insertInto("GEEK")
                    .columns("ID", "FIRSTNAME", "LASTNAME", "EMAIL", "GENDER")
                    .values(1L, "Jean", "Dupond", "jd@orange.fr", 0)
                    .build());
        	DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:hsqldb:hsql://localhost/geektic", "sa", ""), operation);
        	dbSetupTracker.launchIfNecessary(dbSetup);
    }

	@Test
	public void testFindAllGeeks() {
		 dbSetupTracker.skipNextLaunch();
		 GeekDao geekDao = new GeekDao();
		 assertEquals(geekDao.findAll().size(), 1);
	}
	
	
	
	/*@Test
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
	}*/
	

}
