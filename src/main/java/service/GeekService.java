package service;

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
	
	public Geek findByEmail(String email) {
		return geekDao.findByEmail(email);
	}
	
	public boolean checkCredentials(String email, String password) {
		// Not secure :p
		Geek geek = findByEmail(email);
		return geek.getPassword().equals(password);
	}
	
	/* TDD */
	/*public Geek feelLucky() {
		return geekDao.findAll().get(0);
	}*/
	/* Methode above has changed to during testing */
	public Geek feelLucky(List<Interest> interests) {
		System.out.println(geekDao.findAll());
		if(geekDao.findAll() == null) {
			return null;
		}
		if(interests.isEmpty())
			return null;
		if(geekDao.findByInterests(interests) == null || geekDao.findByInterests(interests).isEmpty())
			return null;
		return geekDao.findByInterests(interests).get(0);
	}
	
	
}
