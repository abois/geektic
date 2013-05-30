package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Geek;

import org.springframework.stereotype.Repository;

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
	
	public List<Geek> findByInterests() {
		String jpql = "select geek from Geek geek join geek.interests";
		return em.createQuery(jpql, Geek.class).getResultList();
	}
	
	public void persist(Geek geek) {
		em.persist(geek);
	}
	
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}
	
	public Geek feelLucky() {
		List<Geek> geeks = findAll();
		if(geeks == null) {
			return null;
		} else {
			return geeks.get(0);
		}
	}
	
	/*public List<Geek> findByArtiste(String artiste) {
		String jpql = 
			"select spectacle from Spectacle spectacle"
			+ " where lower(spectacle.artiste) like :artiste"
			+ " order by spectacle.titre";
		return em.createQuery(jpql, Geek.class)
				 .setParameter("artiste", "%" + artiste.toLowerCase() + "%")
				 .getResultList();
	}*/
}
