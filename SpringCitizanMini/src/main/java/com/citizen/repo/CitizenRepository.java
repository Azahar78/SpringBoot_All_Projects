package com.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citizen.entity.CitizenPlan;

public interface CitizenRepository extends JpaRepository<CitizenPlan, Integer>{

	@Query(" select Distinct(planName) from CitizenPlan ")
	List<String>findDistinctPlanName();
	
	@Query(" select Distinct(planStatus) from CitizenPlan ")
	List<String> findDistinctPlanStatus();
	
	
}
