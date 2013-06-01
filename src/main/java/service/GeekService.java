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
	public List<Geek> findByInterests(List<Interest> interests) {
		return geekDao.findByInterests(interests);
	}
	
	@Transactional
	public void create(Geek geek) {
		geekDao.persist(geek);
	}
	
	public Geek feelLucky() {
		return geekDao.feelLucky();
	}
	

}
