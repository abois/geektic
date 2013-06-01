package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Interest;

import org.springframework.stereotype.Repository;

@Repository
public class InterestDao {

	@PersistenceContext
	private EntityManager em;

	public InterestDao() {
		super();
	}

}
