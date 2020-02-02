package herald.binaya.car.booking.dao;

import herald.binaya.car.booking.entities.EUser;

public interface UserDao {
	
	public boolean saveUser(EUser user);
	public EUser getUser(String username);

}
