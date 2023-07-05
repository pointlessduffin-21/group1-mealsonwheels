package com.merrymeals.mealsonwheels.Repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{

	@Query(value="SELECT * FROM partner WHERE email = :email AND password = :password",
			 nativeQuery = true)
		public Partner loginPartner(String email, String password);
	
	@Query(value="SELECT * FROM partner WHERE address = :address",
			 nativeQuery = true)
		public Partner findPartnerByAddress(String address);
	
	@Query(value="SELECT * FROM partner WHERE name = :name",
			 nativeQuery = true)
		public Partner findPartnerByName(String name);
}		
