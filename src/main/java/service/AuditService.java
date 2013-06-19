package service;

import model.Audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AuditDao;

@Service
public class AuditService {

	@Autowired
	private AuditDao auditDao;
	
	public AuditService() {
		super();
	}
	
	public AuditService(AuditDao auditDao) {
		this.auditDao = auditDao;
	}
	
	@Transactional
	public void create(Audit audit) {
		auditDao.persist(audit);
	}
	
}
