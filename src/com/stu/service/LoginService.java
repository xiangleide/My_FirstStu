package com.stu.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stu.mapper.LoginMapper;
import com.stu.po.User;


@Service
public class LoginService implements LoginServiceInf {

	private LoginMapper loginMapper;
	
	public LoginMapper getLoginMapper() {
		return loginMapper;
	}
	@Autowired
	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	@Override
	public boolean login(String username, String pwd) {
		Map map=new HashMap();
		map.put("username",username);
		map.put("pasword",pwd);
		int u=this.loginMapper.selectUser(map);
		/*boolean s;
		if (user != null){
			s=true;
		}else {
			s=false;
		}
		return s;*/
		return u!=0 ? true:false;
		
	}

	

}
