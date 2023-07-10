package com.Group1.MealsOnWheels.service;

import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.RoleRepository;
import com.Group1.MealsOnWheels.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));

        userRepository.save(user);

        return "User saved successfully";
    }

    public User findLoginUser(String username) {

        return userRepository.findByUserName(username);

    }

    public List<User> showAllUser(){

        return userRepository.findAll();
    }

    public void update(User user) {

        userRepository.save(user);

    }

    public String findRoleByUid(long uid) {
    	return userRepository.findRoleByUid(uid);
    }

    public Optional<User> getUserInfo(long uid){

        return userRepository.findById(uid);

    }

    public void deleteUser(long uid) {

        userRepository.deleteById(uid);
    }

    public void assignNewRole(User user, String role) {

        user.getRoles().clear();
        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(role)));
        userRepository.save(user);
    }



}
