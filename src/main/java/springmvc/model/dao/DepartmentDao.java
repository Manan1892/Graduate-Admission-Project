package springmvc.model.dao;

import java.util.List;

import springmvc.model.Department;
import springmvc.model.Programs;
import springmvc.model.Users;



public interface DepartmentDao 

{
	Department saveDepartment(Department department);
	
	 Department getDept(Integer department_id);
	 
	 List<Programs> getCoursesByDepartmentId(Integer departmentId);
	 
	 List<Department> getDept();
	
	
}
