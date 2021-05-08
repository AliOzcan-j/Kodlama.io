package ECommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerce.dataAccess.abstracts.UserDao;
import ECommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	public static List<User> uList = new ArrayList<>();
	
	public HibernateUserDao() {
		uList.add(new User("","","",""));
	}

	@Override
	public Boolean AddUser(User user) {
		if(CheckifUserExists(user) == true) {
			uList.add(user);
			System.out.println("You've signed up! "+ user.getName()+" "+ user.getSurname());
			System.out.println("To complete your account creation accept the confirmation email");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public void GetAll() {
		for(User user:uList) {
			if(!user.getName().contentEquals("")) {
			System.out.println(user.toString());
			}
		}
	}
	
	@Override
	public Boolean GetUser(User user) {
		for(User _user:uList) {
			if((user.getEmail() == _user.getEmail()) && (user.getPassword() == _user.getPassword())) {
				return true;
			}
		}
			return false;
	}
	
	public boolean CheckifUserExists(User user) {
		for(User _user:uList) {
			if(user.getEmail() == _user.getEmail()) {
				System.out.println("user already exists");
				return false;
			}
		}
		return true;
	}
}
