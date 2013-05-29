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
	
	public List<Geek> list() {
		return geekDao.findAll();
	}
	

}
