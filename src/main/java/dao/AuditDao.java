package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Audit;

import org.springframework.stereotype.Repository;

@Repository
public class AuditDao {

	@PersistenceContext
	private EntityManager em;
	
	public AuditDao() {
		super();
	}
	
	public void persist(Audit audit) {
		em.persist(audit);
	}
}
