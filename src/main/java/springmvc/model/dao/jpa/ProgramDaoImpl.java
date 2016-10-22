package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Programs;
import springmvc.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao

{	
	@PersistenceContext
	 private EntityManager entityManager;
	@Override
	public Programs getProg(Integer program_id) 
	{
		
		return entityManager.find(Programs.class,program_id);
	}
	@Override
	public List<Programs> getProg() 
	{
		
		return entityManager.createQuery("from Programs order by program_id ",Programs.class).getResultList();
	}
	@Override
	@Transactional
	public Programs saveProgram(Programs program) 
	{	
	return entityManager.merge(program);
	}
	@Override
	@Transactional
	public void removeProgram(Programs program)
	{
		entityManager.remove(program);
	}
}
