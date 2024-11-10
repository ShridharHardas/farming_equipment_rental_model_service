package org.dnynyog.repository;

import java.util.List;
import java.util.Optional;

import org.dnynyog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByEmailAndPassword(String email,String password);
	
	public User findByEmail(String email);
}
