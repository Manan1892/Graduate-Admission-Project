package springmvc.web.validator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmvc.model.Users;
import springmvc.model.dao.UserDao;

@Component
public class UserValidator<interger> implements Validator


{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) 
	
	{
		return Users.class.isAssignableFrom(clazz);
	}
	

	public static boolean isValidEmailAddress(String email) {
	    boolean stricterFilter = true; 
	    String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,12}";
	    String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
	    String emailRegex = stricterFilter ? stricterFilterString : laxString;
	    java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
	    java.util.regex.Matcher m = p.matcher(email);
	    return m.matches();
	}
	
	

	@Override
	public void validate(Object target, Errors error)
	
	{
		Users user = (Users) target;
		List<Users> users=userDao.getUsers();
		
		if (!StringUtils.hasText(user.getFirstname()))
		{
			error.rejectValue("firstname","error.field.empty");
		}
		if (!StringUtils.hasText(user.getLastname()))
		{
			error.rejectValue("lastname", "error.field.empty");
		}	
		
		if (!StringUtils.hasText(user.getEmail()))
		{
			error.rejectValue("email", "error.field.empty");
		}	
		

		else if (isValidEmailAddress(user.getEmail()) == false)
		
		{
			error.rejectValue("email", "error.field.email");
		} 
		
		else
		{
			for(int i=0;i< users.size();i++ )
				
			{
				if((userDao.getUsers().get(i).getEmail().equalsIgnoreCase(user.getEmail())))
					
				{
					error.rejectValue("email","error.field.emailexist ");
										
				}
			}
		}
		
		if (!StringUtils.hasText(user.getPassword()))
		{
			error.rejectValue("password","error.field.empty ");
		}
		
		/*if (!StringUtils.hasText(user.getUsername()))
			
		{
			error.rejectValue("username", "error.field.empty");
		}
		
		*/
	           }
	
         }


