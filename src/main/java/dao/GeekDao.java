package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Geek;
import model.Interest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GeekDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public GeekDao() {
		super();
	}
	
	public List<Geek> findAll() {
		String jpql = "select geek from Geek geek";
		return em.createQuery(jpql, Geek.class).getResultList();
	}
	
	public List<Geek> findByInterests(List<Interest> interests) {
		String jpql = "select distinct geek from Geek geek join geek.interests as i where i in (:interests)";
		return em.createQuery(jpql, Geek.class).setParameter("interests", interests).getResultList();
	}
	
	public List<Geek> findByGender(List<Boolean> genders) {
		String jpql = "select geek from Geek geek where geek.gender in (:genders)";
		return em.createQuery(jpql, Geek.class).setParameter("genders", genders).getResultList();
	}
	
	public void persist(Geek geek) {
		em.persist(geek);
	}
	
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}
	
	public Geek findByEmail(String email) {
		String jpql = "select geek from Geek geek where email=:email";
		Geek geek = em.createQuery(jpql, Geek.class).setParameter("email", email).getSingleResult();
		System.out.println(geek.getFirstname());
		return geek;
	}
	
	/* TDD */
	/*public Geek feelLucky() {
		List<Geek> geeks = findAll();
		if(geeks == null) {
			return null;
		} else {
			return geeks.get(0);
		}
	}*/
	@Transactional
	public void update(Geek geek) {
		em.merge(geek);
	}
}
