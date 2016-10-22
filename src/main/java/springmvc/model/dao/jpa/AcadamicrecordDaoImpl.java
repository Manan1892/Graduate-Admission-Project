package springmvc.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Acadamicrecord;
import springmvc.model.dao.AcadamicrecordDao;
@Repository
public class AcadamicrecordDaoImpl implements AcadamicrecordDao 

{
	
	@PersistenceContext
	private EntityManager entityManager;
	
    @Transactional
	@Override
	public Acadamicrecord saveAcadamicrecord(Acadamicrecord aca) 

     {
		return entityManager.merge(aca);
	}
    
    @Transactional
	@Override
	public Acadamicrecord getAcadamicrecord(Integer aca)

    {	
	return entityManager.find(Acadamicrecord.class,aca);
	}

}
