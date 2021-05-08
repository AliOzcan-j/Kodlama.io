package ECommerce.business.concretes;

import ECommerce.business.abstracts.UserService;
import ECommerce.core.abstracts.AuthorizeService;
import ECommerce.core.concretes.adapters.GoogleAuthorizeManagerAdapter;
import ECommerce.dataAccess.abstracts.UserDao;
import ECommerce.entities.concretes.User;
import ECommerce.googleAuth.GoogleAuthorizeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class UserManager implements UserService{
	
	UserDao userDao;
	AuthorizeService googleAuthorizeService;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		this.googleAuthorizeService = new GoogleAuthorizeManagerAdapter(new GoogleAuthorizeManager());
	}
	
	public UserManager() {}
	
	@Override
	public void LoginUser(User user) {
		if(!user.getEmail().equals("") && !user.getPassword().equals("")) {
			if(userDao.GetUser(user) == true) {
				System.out.println("Logged in! Welcome "+ user.getName() + " "+ user.getSurname());
			}
			else {
				System.out.println("Email or Password is wrong");
			}
		}
		else {
			System.out.println("Please fill the Email and Password fields");
		}
		
	}

	@Override
	public void AddNewUser(User user) {
		if(user.getEmail()!=null && user.getPassword()!=null
				&& user.getName()!=null && user.getSurname()!=null) {
			if(CheckPasswordLenght(user.getPassword()) == true) {
				if(CheckIfTrueEmailPattern(user.getEmail(),0) == true) {
					if(CheckUserName(user) == true) {
						if(userDao.AddUser(user) == true) {
							if(SendConfirmationEmail(user.getEmail(), 0)==true) {
								System.out.println("Your account has been created, Welcome! "+ user.getName() + " "+ user.getSurname());
								System.out.println(" ");
							}
						}
					}
				}
			}
		}
		else {
			System.out.println("Fields can not be empty, please fill the required information to sign up");
		}
	}
	
	public boolean CheckPasswordLenght(String password) {
		
		if(password.length()>=6) {
			return true;
		}
		else {
			System.out.println("Password lenght should be atleast 6 character");
			return false;
		}
	}
	
	public boolean CheckIfTrueEmailPattern(String email, int v) {
		
		Boolean checker;
		
		if(Pattern.compile("@gmail.com").matcher(email).find() == true) {
			return googleAuthorizeService.AuthrizeUser();
		}
		else if(Pattern.compile("@").matcher(email).find() == true) {
			String[] temp = email.split("@");
			checker = CheckIfTrueEmailPattern(temp[1],1);
			return checker;
		}
		else if(v == 1 && Pattern.compile("[.]com").matcher(email).find() == true) {
			return true;
		}
		else {
			System.out.println("Please enter a valid email");
			return false;
		}
	}
	
	public boolean CheckUserName(User user) {
		if(user.getName().length()>=2 && user.getSurname().length()>=2) {
			return true;
		}
		else {
			System.out.println("Name and Surname should be atleast 2 characters");
			return false;
		}
	}
	
	public Boolean SendConfirmationEmail(String email, int confirmation) {
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("Do you accept the confirmation? Y/N");
		input = sc.nextLine();
		if(input.contentEquals("Y")) {
			confirmation = 1;
			return true;
		}
		else if(input.contentEquals("N")) {
			return false;
		}
		else if(confirmation==0 && Pattern.matches("[A-Z&&[^YN]]", input)){
			System.out.println("Please Enter a valid response");
			SendConfirmationEmail(email,0);
			return true;
		}
		else {
			return false;
		}
	}

}
