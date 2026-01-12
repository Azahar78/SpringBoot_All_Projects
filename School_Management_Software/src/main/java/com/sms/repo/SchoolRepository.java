package com.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

}
