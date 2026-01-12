package com.boot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.UserDetail;


public interface UserRepository extends JpaRepository<UserDetail, Integer>{

	Optional<UserDetail> findByUserName(String userName);
}
