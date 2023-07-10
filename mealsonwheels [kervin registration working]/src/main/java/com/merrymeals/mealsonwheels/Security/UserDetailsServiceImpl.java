package com.merrymeals.mealsonwheels.Security;

import com.merrymeals.mealsonwheels.Entity.Role;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repository.UserRepository;
import com.merrymeals.mealsonwheels.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		/*
		 * User user = userRepository.findByUserName(userName); if(user == null) { throw
		 * new UsernameNotFoundException("user " + userName +
		 * " is not valid. Please re-enter."); }
		 * org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
		 * org.springframework.security.core.userdetails.User.builder();
		 * 
		 * Long Uid = user.getU_id(); String roleName =
		 * userRepository.findRoleByUid(Uid);
		 * 
		 * System.out.println("Role Name is "+roleName);
		 * 
		 * return userBuilder.username(user.getUserName()) .password(user.getPassword())
		 * .roles(roleName) //.passwordEncoder(passwordEncoder::encode) .build();
		 */
    	
    	User user = userRepository.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("user " + userName + " is not valid. Please re-enter.");
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
