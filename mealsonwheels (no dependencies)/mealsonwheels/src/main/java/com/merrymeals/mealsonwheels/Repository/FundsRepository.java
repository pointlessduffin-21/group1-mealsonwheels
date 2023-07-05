package com.merrymeals.mealsonwheels.Repository;

import com.merrymeals.mealsonwheels.Entity.Funds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundsRepository extends JpaRepository<Funds, Long> {

}
