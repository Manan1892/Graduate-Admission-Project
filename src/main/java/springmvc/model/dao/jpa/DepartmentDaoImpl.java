package springmvc.model.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Department;
import springmvc.model.Programs;
import springmvc.model.dao.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao

{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Department getDept(Integer department_id)

	{

		return entityManager.find(Department.class, department_id);
	}

	@Override
	public List<Department> getDept()

	{

		return entityManager.createQuery(
				"from Department order by department_id ", Department.class)
				.getResultList();
	}

	@Transactional
	@Override
	public Department saveDepartment(Department department)

	{

		return entityManager.merge(department);
		
	
	}

	@Transactional
	@Override
	public List<Programs> getCoursesByDepartmentId(Integer departmentId) {
		// TODO Auto-generated method stub
		
		return entityManager.createNativeQuery("select * from program_id where department_department_id=" + departmentId, Programs.class).getResultList();
		
	
	}

	
	
}
