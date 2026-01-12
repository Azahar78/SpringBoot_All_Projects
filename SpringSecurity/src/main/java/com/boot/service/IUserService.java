package com.boot.service;

import java.util.List;

import com.boot.entity.UserDetail;



public interface IUserService {

     Integer createUser(UserDetail details);
     UserDetail getUserById(Integer id);
     List<UserDetail> getAll();
     String updateUser(Integer id,UserDetail details);
     String removeUser(Integer id);
}
