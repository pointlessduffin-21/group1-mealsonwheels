package com.merrymeals.mealsonwheels.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.merrymeals.mealsonwheels.Entity.Role;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repository.UserRepository;

import javax.transaction.TransactionScoped;

import javax.transaction.Transactional;

@TransactionScoped
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

	
	
	 @Autowired 
	 private PasswordEncoder passwordEncoder;
	 
	 

    public UserDetailsServiceImpl() {
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	
        User user = userRepository.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("user " + userName + " does not exist. Do you?.");
        }
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
        
        String[] roleNames= user.getRoles().stream().map(Role::getName).toArray(String[]::new);
        
        System.out.println("Role Name is "+roleNames);
        
        return userBuilder.username(user.getUserName())
                        .password(user.getPassword())
                        .roles(roleNames)
                        //.passwordEncoder(passwordEncoder::encode)
                        .build();
    }
}
