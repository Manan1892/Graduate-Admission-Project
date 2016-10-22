package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Application;
import springmvc.model.Degree;
import springmvc.model.dao.DegreeDao;

@Repository
public class DegreeDaoImpl  implements DegreeDao

{


	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Transactional
	@Override
	
	public Degree saveDegree(Degree degree) 
	
	{
	
		return entityManager.merge(degree);
	}
	
	
     @Transactional
	@Override
	public Degree getDegree(Integer deg) 
     {
		
    	 return entityManager.find (Degree.class,deg);
	 }
     
     
     
    @Transactional
	@Override
	public List<Degree> getDegree()
	{
		
    	 return entityManager.createQuery("from Degree order by degree_id ",Degree.class ).getResultList();
			
	}	
	
}
