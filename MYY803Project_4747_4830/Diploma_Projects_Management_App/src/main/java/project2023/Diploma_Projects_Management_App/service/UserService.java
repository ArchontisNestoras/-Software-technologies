package project2023.Diploma_Projects_Management_App.service;

import org.springframework.stereotype.Service;

import project2023.Diploma_Projects_Management_App.model.User;

@Service
public interface UserService {

	public void saveUser(User user);
	
    public boolean isUserPresent(User user);
	
	public User findById(int theId);

}
