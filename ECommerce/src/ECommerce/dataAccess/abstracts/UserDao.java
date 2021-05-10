package ECommerce.dataAccess.abstracts;

import ECommerce.entities.concretes.User;

public interface UserDao {
	Boolean AddUser(User user);
	void GetAll();
	Boolean GetUser(User user);
}
