package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.entity.UserDetail;
import com.boot.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail userDetail = repository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(" User name not Found..."));

		List<SimpleGrantedAuthority> authorities = userDetail.getRoles().stream()
				.map(roles -> new SimpleGrantedAuthority(roles)).collect(Collectors.toList());

		return new User(userDetail.getUserName(), encoder.encode(userDetail.getUserPwd()), authorities);
	}

     */
     
	@Override
	public String removeUser(Integer id) {
		repository.deleteById(id);

		boolean isIdExist = repository.existsById(id);

		return !isIdExist ? " Deleted SuccessFully" : " Issue In Delete Opreation";
	}

	@Override
	public Integer createUser(UserDetail details) {

		boolean present = repository.findByUserName(details.getUserName()).isPresent();

		if (!present) {
			
			details.setUserPwd(encoder.encode(details.getUserPwd()));
			
			UserDetail detail = repository.save(details);
			return detail.getUserId();
		}

		return -1;
	}

	@Override
	public String updateUser(Integer id, UserDetail details) {

		UserDetail user = repository.findById(id).get();
		user.setUserAddress(details.getUserAddress());
		user.setRoles(details.getRoles());

		UserDetail userDetail = repository.save(user);

		return "User '" + userDetail.getUserId() + "' Updated Successfully...";
	}

	@Override
	public UserDetail getUserById(Integer id) {
		UserDetail userDetail = repository.findById(id).get();
		return userDetail;
	}

	@Override
	public List<UserDetail> getAll() {

		return repository.findAll();
	}

}
