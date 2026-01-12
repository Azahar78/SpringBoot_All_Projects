package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Item;

public interface ItemRepo extends JpaRepository<Item,String>{

}
