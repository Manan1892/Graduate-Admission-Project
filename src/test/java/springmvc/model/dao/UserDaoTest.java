package springmvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.Programs;
import springmvc.model.Users;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	UserDao userDao;

	@Autowired
	ApplicationDao ApplicationDao;

	@Autowired
	DepartmentDao DepartmentDao;

	@Autowired
	ProgramDao ProgramDao;

/*	@Test
	public void getDepts() {
		assert DepartmentDao.getDept().size() == 2;
	}
*/
	/*@Test
	public void getdep()

	{
		int counter = 0;
		List<Department> departments = DepartmentDao.getDept();

		for (Department department : departments)

		{
			List<Programs> programs = department.getProgram();

			for (Programs program : programs)

			{
				if (program.getApplication() != null) {

					if (program.getApplication().getTerm().equals("Fall2016")) {
						counter++;
					}

				}
			}

			assert counter == 1;
		}

	}

	@Test
	public void userApplication() {
		List<Users> users = userDao.getUsers();
		int count = 0;
		for (Users user : users) {
			if (user.getEmail().equals("student1@localhost.localdomain"))
				count= user.getApplications().size();
		}
		assert count == 1;
	}
*/
}