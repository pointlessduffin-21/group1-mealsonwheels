package com.merrymeals.mealsonwheels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="SELECT * FROM user WHERE email = :email AND password = :password",
			nativeQuery = true)
	public User loginUser(String email, String password);

	@Query(value="SELECT * FROM user WHERE address = :address",
			nativeQuery = true)
	public User findUserByAddress(String address);

	@Query(value="SELECT * FROM user WHERE name = :name",
			nativeQuery = true)
	public User findUserByName(String name);
	User findByEmail(String email);
}
