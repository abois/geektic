package service;

import java.util.List;
import java.util.Set;

import model.Geek;
import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Geek> list() {
		return geekDao.findAll();
	}
	
	public Geek find(long id) {
		return geekDao.findById(id);
	}
	
	public List<Geek> findByInterests(List<Interest> interests) {
		return geekDao.findByInterests(interests);
	}
	
	public Geek feelLucky() {
		return geekDao.feelLucky();
	}
	

}
