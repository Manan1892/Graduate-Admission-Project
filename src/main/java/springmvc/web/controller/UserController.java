package springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.Users;
import springmvc.model.dao.UserDao;
import springmvc.web.validator.UserValidator;

@Controller
public class UserController

{

	@SuppressWarnings("rawtypes")
	@Autowired
	UserValidator UserValidator;

	@Autowired
	private UserDao userDao;

	@RequestMapping("user/users.html")
	public String users(ModelMap models) {
		models.put("users", userDao.getUsers());
		return "user/users";
	}

	@RequestMapping(value = "/user/register.html", method = RequestMethod.GET)
	public String register(ModelMap models)

	{
		models.put("user", new Users());
		return "user/register";
	}

	@RequestMapping(value = "/user/register.html", method = RequestMethod.POST)
	public String register(@ModelAttribute Users user, BindingResult result) 
	{
		//UserValidator.validate(user, result);
		user.setUsername(null);
		user = userDao.saveUser(user);

		return "redirect:/user/login.html";
	//	return "redirect:/student.html";
	}

	@RequestMapping(value = "/user/login.html", method = RequestMethod.GET)
	public String login(ModelMap models) 
	{
		models.put("user", new Users());
		return "user/login";

	}

	@RequestMapping(value = "/user/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute Users user) 
	
	{
		
		List<Users> lastuser = userDao.getUsers();

		for (int i = 0; i < lastuser.size(); i++) {

			if (userDao.getUsers().get(i).getEmail().equalsIgnoreCase(user.getEmail()))

			{

				if (userDao.getUsers().get(i).getPassword()
						.equals(user.getPassword()))

				{
					if (userDao.getUsers().get(i).getEmail().contains("admin"))

					{
						return "redirect:/admin.html";
					}

					
					else if (userDao.getUsers().get(i).getEmail().contains("staff"))

					{
						return "redirect:/staff/staff.html";
					}
					
					else if (userDao.getUsers().get(i).getEmail().contains("student"))

					{
						return "redirect:/student.html";
					}

				}
			}
		}

		return null;

	}

}

