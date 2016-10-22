package springmvc.model.dao;
import java.util.List;

import springmvc.model.Users;


public interface UserDao 

  {
        Users saveUser(Users user);
	
	  	Users getUser( Integer user_id );

	    List<Users> getUsers();
	    
	    Users getUserByName(String name);

	
  }
