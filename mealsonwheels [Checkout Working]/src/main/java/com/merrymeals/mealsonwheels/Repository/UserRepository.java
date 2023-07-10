package com.merrymeals.mealsonwheels.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="SELECT * FROM user WHERE user_name = :email AND password = :password",
			nativeQuery = true)
	public User loginUser(String email, String password);
	
	@Query(value="SELECT * FROM user WHERE email = :email",
			nativeQuery = true)
	public User findByEmail(String email);

	@Query(value="SELECT * FROM user WHERE address = :address",
			nativeQuery = true)
	public User findUserByAddress(String address);

	@Query(value="SELECT * FROM user WHERE name = :name",
			nativeQuery = true)
	public User findUserByName(String name);
	

	/*
	 * @Query(value="SELECT * FROM user WHERE user.user_name = :userName",
	 * nativeQuery = true)
	 */

	@Query(value="SELECT * FROM user JOIN user_role ON user.u_id = user_role.u_id JOIN role ON user_role.r_id = role.id WHERE role.name = :role",
			nativeQuery = true)
	public List<User> findUsersByRole(String role);
	
	User findByUserName(String userName);

	@Query(value="SELECT role.name FROM user JOIN user_role ON user.u_id = user_role.u_id JOIN role ON user_role.r_id = role.id WHERE user.u_id = :uid",
			nativeQuery = true)
	public String findRoleByUid(Long uid);
}
