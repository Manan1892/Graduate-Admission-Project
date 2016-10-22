package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Application;
import springmvc.model.dao.ApplicationDao;
@Repository
public class ApplicationDaoImpl implements ApplicationDao

{
	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Override
	public Application getApp(Integer applicant_id) 
	
	{
		
		return entityManager.find (Application.class,applicant_id);
	}

	@Override
	public List<Application> getApp() 
	
	{
		
		return entityManager.createQuery("from Application order by applicant_id ",Application.class ).getResultList();
		
	}

	@Override
	@Transactional
	public Application saveApplication(Application application)
	
	{
		
		return entityManager.merge(application);
	}

	
	
	
}
