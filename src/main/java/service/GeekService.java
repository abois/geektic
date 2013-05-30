package service;

import java.util.List;

import model.Geek;

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
	
	public Geek feelLucky() {
		return geekDao.feelLucky();
	}
	

}
