package com.stu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.service.LoginService;
import com.stu.service.LoginServiceInf;
import com.sun.xml.internal.ws.resources.HttpserverMessages;

@Controller
public class LoginController {
	private LoginServiceInf loginServiceInf;
	
	public LoginServiceInf getLoginServiceInf() {
		return loginServiceInf;
	}
	@Autowired
	public void setLoginServiceInf(LoginServiceInf loginServiceInf) {
		this.loginServiceInf = loginServiceInf;
	}

	@RequestMapping("/login.do")
	public String login(String username,String pasword,HttpServletRequest request){
		boolean a=this.loginServiceInf.login(username , pasword);
		if(a){
			return "WEB-INF/main";
		}else{
			request.setAttribute("inf", "用户名密码错误，请重新输入！");
			return "login";
		}
		
	}
}
