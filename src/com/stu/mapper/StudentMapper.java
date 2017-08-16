package com.stu.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.stu.po.Student;

public interface StudentMapper {

	public int insertStudent(Map map);
	public int deleteStudentById(int id);
	public List<Student> selectByAll();
	public int updateStudentById(Student student);
}
