package com.stu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stu.po.Student;
import com.stu.service.StuService;
import com.stu.service.StuServiceInf;

@Controller
public class StudentController {
	@Resource
	private StuServiceInf stuServiceInf;
	
	public StuServiceInf getStuServiceInf() {
		return stuServiceInf;
	}
	@Autowired
	public void setStuServiceInf(StuServiceInf stuServiceInf) {
		this.stuServiceInf = stuServiceInf;
	}
	
	@RequestMapping("/displayStudent.do")
	@ResponseBody
	public List<Student> displayStudent(Model model,HttpServletRequest request){
		
		List<Student> stu=new ArrayList<Student>();
		stu=this.stuServiceInf.displaystudent();
		/*for (Student student : stu) {
			System.out.println(student.getName());
		}
		request.setAttribute("stu",stu);*/
		/*model.addAttribute("stu",stu);
		*/
		return stu;
	}
	@RequestMapping("/addStudent.do")
	public String addStudent(String name,String sex,int age,String sclass,HttpServletRequest request){
		boolean a;
		if(name!=null || sex!=null || age!=0 || sclass!=null){
			
			a=this.stuServiceInf.insertStudent(name, sex, age, sclass);
			if(a=false){
				request.setAttribute("ref", "添加失败,请重新操作!");
			}else {
				request.setAttribute("ref", "添加成功！");
			}
		}else{
			request.setAttribute("ref", "请输入学生信息！");
		}
		
		return "WEB-INF/main";
	}
	
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(int id,HttpServletRequest request){
		System.out.println(id);
		boolean a;
		a=this.stuServiceInf.deleteStudent(id);
		if(a=false){
			request.setAttribute("ref", "删除失败，请重新操作！");
		}else {
			request.setAttribute("ref", "删除成功！");
		}
		return "WEB-INF/main";
	}
	@RequestMapping("/changepage.do")
	@ResponseBody
	public Map changepage(String id,String name,String sex,int age,String sclass,HttpServletRequest request){
		
		Map stu=new HashMap();
		stu.put("id", id);
		stu.put("name", name);
		stu.put("sex", sex);
		stu.put("age", age);
		stu.put("sclass", sclass);
		
/*		System.out.println(id);
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);
		System.out.println(sclass);*/
		
		request.setAttribute("stu", stu);
		return stu;
	
		
	}
	@RequestMapping("/updateStudent.do")
	public String updateStudent(Student student,HttpServletRequest request){
		
		System.out.println("name="+student.getName());
		boolean a=this.stuServiceInf.updateStudent(student);
		if (a==false) {
			request.setAttribute("ref", "修改失败，请重新修改！");
			return "WEB-INF/main";
		}else {
			request.setAttribute("ref", "修改成功！");
			return "WEB-INF/main";
		}
		
	}
	
}
