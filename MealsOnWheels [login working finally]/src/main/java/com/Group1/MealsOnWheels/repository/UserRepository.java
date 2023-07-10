package com.Group1.MealsOnWheels.repository;

import com.Group1.MealsOnWheels.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserName(String name);

    @Query(value="SELECT * FROM user WHERE user_name = :email AND password = :password",
            nativeQuery = true)
    public User loginUser(String email, String password);

    @Query(value="SELECT role.name FROM user JOIN user_role ON user.u_id = user_role.user_id JOIN role ON user_role.role_id = role.id WHERE user.u_id = :uid",
            nativeQuery = true)
    public String findRoleByUid(Long uid);

}

