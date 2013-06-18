package service;

import java.util.List;

import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InterestDao;

@Service
public class InterestService {
	
	@Autowired
	private InterestDao interestDao;
	
	public InterestService() {
		super();
	}
	
	public List<Interest> list() {
		return interestDao.findAll();
	}
	
	public Interest find(Long id) {
		return interestDao.findById(id);
	}
	
	public List<Interest> listByIds(Long [] ids) {
		return interestDao.findByIds(ids);
	}
}
