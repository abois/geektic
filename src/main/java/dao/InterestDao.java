package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Geek;
import model.Interest;

import org.springframework.stereotype.Repository;

@Repository
public class InterestDao {

	@PersistenceContext
	private EntityManager em;

	public InterestDao() {
		super();
	}
	
	public List<Interest> findAll() {
		String jpql = "select i from Interest i";
		return em.createQuery(jpql, Interest.class).getResultList();
	}

}
