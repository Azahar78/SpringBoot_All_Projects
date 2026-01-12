package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Model;

public interface ModelRepo extends JpaRepository<Model, Integer> {

}
