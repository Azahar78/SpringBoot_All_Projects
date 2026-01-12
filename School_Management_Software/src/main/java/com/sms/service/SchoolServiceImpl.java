package com.sms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.School;
import com.sms.entity.Teacher;
import com.sms.repo.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	

	@Override
	public Boolean createSchool(School school) {

	//	String dateString = "2024-11-15"; // Example date in yyyy-MM-dd format
		
		LocalDate establishedAt = LocalDate.parse(school.getEstablishedAt() + "",
				DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		System.out.println(establishedAt);
		school.setEstablishedAt(establishedAt);
		
		List<Teacher> teachers = school.getTeachers();
		
		for(Teacher tech :teachers) {
			
		LocalDate dateOfJoin = LocalDate.parse(tech.getDateOfJoin()+"",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		tech.setDateOfJoin(dateOfJoin);
		}
		
		
		School save = schoolRepository.save(school);

		if (save != null)
			return true;
		else
			return false;

	}

	@Override
	public School updateSchool(School school, Integer schoolId) throws Exception {
		
		 School schoolUpdated = schoolRepository.findById(schoolId)
		 .orElseThrow(()->new Exception(" School Not available with respect to id "));
		 
			  
			  
			  schoolUpdated.setSchoolName(school.getSchoolName()); 
			  schoolUpdated.setSchoolAddress(school.getSchoolAddress());
			  schoolUpdated.setSchoolHours(school.getSchoolHours());
			  schoolUpdated.setHolidays(school.getHolidays());
			  schoolUpdated.setPhoneNo(school.getPhoneNo());
			  schoolUpdated.setEmailId(school.getEmailId());
		
		 
		 
		 
		return schoolUpdated;
	}

	@Override
	public School getSchool(Integer schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeSchool(Integer schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
