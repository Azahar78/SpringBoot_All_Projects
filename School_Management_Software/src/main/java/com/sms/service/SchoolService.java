package com.sms.service;

import java.util.List;

import com.sms.entity.School;

public interface SchoolService {

	Boolean createSchool(School school);
	School updateSchool(School school,Integer schoolId)throws Exception;
	School getSchool(Integer schoolId);
	List<School> getAllSchool();
	Boolean removeSchool(Integer schoolId);
	
}
