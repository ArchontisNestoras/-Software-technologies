package project2023.Diploma_Projects_Management_App.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	public User findById(int theId);
	
	Optional<User> findByUsername(String username);

}
