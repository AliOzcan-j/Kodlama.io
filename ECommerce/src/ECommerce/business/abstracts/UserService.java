package ECommerce.business.abstracts;

import ECommerce.entities.concretes.User;

public interface UserService {
	void AddNewUser(User user);
	void LoginUser(User user);
}
