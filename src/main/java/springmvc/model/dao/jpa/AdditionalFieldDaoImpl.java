package springmvc.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Additionalfield;
import springmvc.model.dao.AdditionalFieldDao;

@Repository
public class AdditionalFieldDaoImpl implements  AdditionalFieldDao

{
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	@Override
	@Transactional
	public Additionalfield saveAddfield(Additionalfield Addfield) 
	
	{
	
		return entityManager.merge(Addfield);
	}
	@Override
	@Transactional
	public void removeAddfield(Additionalfield Addfield) 
	
	{
		 entityManager.remove(Addfield);	
	}
	@Override
	@Transactional
	public Additionalfield getAdditionalfield(Integer Addfield) {
		
		return entityManager.find(Additionalfield.class,Addfield);
	}
	
}
