package com.stu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.mapper.StudentMapper;
import com.stu.po.Student;
@Service
public class StuService implements StuServiceInf {
	
	private StudentMapper studentMapper;
	
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}
    @Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public List<Student> displaystudent() {
		List<Student> stu=new ArrayList<Student>();
		stu=studentMapper.selectByAll();
		return stu;
	}
	@Override
	public boolean insertStudent(String name,String sex,int age,String sclass) {
		Map stu =new HashMap();
		stu.put("name", name);
		stu.put("sex", sex);
		stu.put("age", age);
		stu.put("sclass", sclass);
		
		int i=this.studentMapper.insertStudent(stu);
		
		return i != 0 ? true:false;
	}
	@Override
	public boolean deleteStudent(int id) {
		int a;
		a = this.studentMapper.deleteStudentById(id);
		if(a==0){
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public boolean updateStudent(Student student) {
		int a;
		
		/*Map stu=new HashMap();
		stu.put("id", id);
		stu.put("name", name);
		stu.put("sex", sex);
		stu.put("age", age);
		stu.put("sclass", sclass);*/
		a=this.studentMapper.updateStudentById(student);
		System.out.println(student.getName()+student.getAge());
		if(a==0){
			return false;
		}else {
			return true;
		}
		
	}

}
