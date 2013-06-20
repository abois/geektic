package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Audit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AuditDao {

	@PersistenceContext
	private EntityManager em;
	
	public AuditDao() {
		super();
	}
	
	@Transactional
	public void persist(Audit audit) {
		em.persist(audit);
	}
}
