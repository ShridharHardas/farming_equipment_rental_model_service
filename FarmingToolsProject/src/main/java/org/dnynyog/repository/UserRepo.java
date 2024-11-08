package org.dnynyog.repository;

import java.util.List;
import java.util.Optional;

import org.dnynyog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	//Optional<User> findByEmailAndPassword(String email,String password);
	//List<User> findByEmailAndPassword(String email,String password);
	public User findByEmailAndPassword(String email,String password);
}
