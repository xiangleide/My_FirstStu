package com.stu.service;

import java.util.List;
import java.util.Map;

import com.stu.po.Student;

public interface StuServiceInf {

	public List<Student> displaystudent();
	public boolean insertStudent(String name,String sex,int age,String sclass);
	public boolean deleteStudent(int id);
	public boolean updateStudent(Student student);
}
