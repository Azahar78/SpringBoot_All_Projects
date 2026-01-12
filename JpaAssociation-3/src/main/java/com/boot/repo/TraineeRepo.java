package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Integer>{

}
