package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Geek;
import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.GeekDao;

@Service
public class GeekService {
	
	@Autowired
	private GeekDao geekDao;
	
	public GeekService() {
		super();
	}
	
	public GeekService(GeekDao geekDao) {
		this.geekDao = geekDao;
	}
	
	@Transactional
	public List<Geek> list() {
		return geekDao.findAll();
	}
	
	@Transactional
	public Geek find(long id) {
		return geekDao.findById(id);
	}
	
	@Transactional
	public void create(Geek geek) {
		geekDao.persist(geek);
	}
	
	@Transactional
	public List<Geek> search(List<Interest> interests, List<Boolean> genders) {
		System.out.println("interest : " + interests.isEmpty());
		System.out.println("interest : " + genders.isEmpty());
		if(interests.isEmpty())
			return geekDao.findByGender(genders);
		List<Geek> geeks = geekDao.findByInterests(interests);
		if(!genders.isEmpty())
			geeks.retainAll(geekDao.findByGender(genders));
		return geeks;
	}
	
	@Transactional
	public Geek findByEmail(String email) {
		return geekDao.findByEmail(email);
	}
	
	@Transactional
	public boolean checkCredentials(String email, String password) {
		// Not secure :p
		Geek geek = findByEmail(email);
		return geek.getPassword().equals(password);
	}
	
	/* TDD */
	/*public Geek feelLucky() {
		return geekDao.findAll().get(0);
	}*/
	/* List that save the last returned geeks by feel lucky */
	private static boolean _tried = false;
	private static List<Geek> _geeks;
	
	/* Methode above has changed to during testing */
	@Transactional
	public Geek feelLucky(List<Interest> interests) {
		Geek _geek = null;
		if(geekDao.findAll() == null) {
			return _geek;
		}
		if(interests.isEmpty())
			return _geek;
		
		List<Geek> geeks = geekDao.findByInterests(interests);
		if(geeks == null || geeks.isEmpty())
			return _geek;
		
		/* Return a different geek each time this function is called */
		if(_tried == false) {
			_geeks = geeks;
			_tried = true;
		}
		System.out.println(_geeks);
		_geek = _geeks.get(0);
		System.out.println(_geek);
		_geeks.remove(0);
		_geeks.add(_geek);
		return _geek;
	}
	
	
}
