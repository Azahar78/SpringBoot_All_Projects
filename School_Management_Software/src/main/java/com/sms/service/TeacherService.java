package com.sms.service;

import java.util.List;

import com.sms.entity.Teacher;

public interface TeacherService {

	Boolean postTeacher(Teacher teacher);
	Teacher updateTeacher(Teacher teacher,Integer teacherlId);
	Teacher getTeacher(Integer teacherlId)throws Exception;
	List<Teacher> getAllTeachers();
}
