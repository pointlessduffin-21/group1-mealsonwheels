package com.merrymeals.mealsonwheels.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Role;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repository.RoleRepository;
import com.merrymeals.mealsonwheels.Repository.UserRepository;

@Service
@Transactional
public class RoleService {
	

	@Autowired
	public RoleRepository roleRepo;

	public Role findByRId(Long RId) {
		return roleRepo.findByRId(RId);
	}
	
	public String findRoleByRId(Long RId) {
		return roleRepo.findRoleByRId(RId);
	}
}
