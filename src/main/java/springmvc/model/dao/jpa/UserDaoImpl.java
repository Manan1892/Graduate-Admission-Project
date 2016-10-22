package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Users;
import springmvc.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao 

{

	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public Users getUser( Integer user_id )
    {
        return entityManager.find( Users.class, user_id );
    }

    @Override
    public List<Users> getUsers()
    {
        return entityManager.createQuery( "from Users order by user_id", Users.class )
            .getResultList();
    }

    public Users getUserByName(String name)
    
    {
    	Users user=null;
		List<Users> user1=getUsers() ;
		for(int i=0; i<=user1.size();i++)
		{
			if (user1.get(i).getFirstname().equalsIgnoreCase(name))
			{
				user= user1.get(i);
				break;
			}
			
			}
		return user;
    }
    
    @Transactional
	@Override
	public Users saveUser(Users user) 
	
	{

		return entityManager.merge(user);
	}
	
	
}
