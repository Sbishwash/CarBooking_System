package herald.binaya.car.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import herald.binaya.car.booking.entities.EUser;

@Repository
public class UserDaoImpl implements UserDao {

	
	@PersistenceContext
	private EntityManager manager;

	
	public boolean saveUser(EUser user) {
		// TODO Auto-generated method stub
		try {
			manager.persist(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public EUser getUser(String username) {
		 Query q =manager.createQuery("SELECT u FROM EUser u WHERE u.username = :login");
		 q.setParameter("login",username);
		 List<EUser> users=q.getResultList();
		 if(users==null || users.size()==0)
			 return null;
		 return users.get(0);
	}

}
