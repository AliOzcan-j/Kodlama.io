package ECommerce;

import java.util.ArrayList;
import java.util.List;
import ECommerce.*;
import ECommerce.business.concretes.UserManager;
import ECommerce.dataAccess.concretes.HibernateUserDao;
import ECommerce.entities.concretes.User;
import ECommerce.dataAccess.abstracts.UserDao;

public class main {

	public static void main(String[] args) {
		
//					     User(name, surName, email, password)
		User user1 = new User("Tekin","Beyhan","gwongwp@mail.com","ggagnnp");		//Doğru
		User user2 = new User("Ali", "Özcan", "gwongwgwefp@gmail.com","gwepjpgw");	//Doğru gmail
		User user3 = new User("d","gg","kkkkk@hhh.com","omğğmğmon");				//Yanlış İsim
		User user4 = new User("Berrin","Parlak","aaaaaagmail.com","ııjıjıjoo");		//Yanlış email
		User user5 = new User("kk","yy","wefwe@mail.com","yyyy");					//Yanlış şifre
		
		UserDao userDao = new HibernateUserDao();
		UserManager userManager = new UserManager(userDao);
		
		userManager.AddNewUser(user1);
		userManager.AddNewUser(user2);
		userManager.AddNewUser(user3);
		userManager.AddNewUser(user4);
		userManager.AddNewUser(user5);
		userDao.GetAll();
		
		userManager.LoginUser(user2);
	}

}
