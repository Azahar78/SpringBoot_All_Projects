package com.sms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Teacher;
import com.sms.repo.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher updateTeacher(Teacher teacher, Integer teacherlId) {

		try {
			Teacher updatedTeacher = getTeacher(teacherlId);

		} catch (Exception e) {
			System.out.println(" Error" + e.getMessage());
		}

		return null;
	}

	@Override
	public Teacher getTeacher(Integer teacherlId) throws Exception {
		teacherRepository.findById(teacherlId).orElseThrow(() -> new Exception("Not availble.."));
		return null;
	}

	@Override
	public List<Teacher> getAllTeachers() {

		return teacherRepository.findAll();
	}

	@Override
	public Boolean postTeacher(Teacher teacher) {

	     LocalDate joinDate = LocalDate.parse(teacher.getDateOfJoin() + "",
	     DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	     teacher.setDateOfJoin(joinDate);	     
		 Teacher teacherId = teacherRepository.save(teacher);
		return teacherId.getTeacherId()!=null;
	}

}
