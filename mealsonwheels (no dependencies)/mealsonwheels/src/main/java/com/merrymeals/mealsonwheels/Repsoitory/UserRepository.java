package com.merrymeals.mealsonwheels.Repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
