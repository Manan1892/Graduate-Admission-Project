package springmvc.model.dao.jpa;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Applicantstatus;
import springmvc.model.dao.ApplicantstatusDao;

@Repository
public class ApplicantstatusDaoImpl implements ApplicantstatusDao

{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Applicantstatus getApplicantstatus(Integer appstatus) 
	
	{
		
		return entityManager.find(Applicantstatus.class,appstatus);
	}
	
    @Transactional
	@Override
	public Applicantstatus saveApplicantstatus(Applicantstatus applicantstatus)
	
	{
		
		return entityManager.merge(applicantstatus);
	}

}
