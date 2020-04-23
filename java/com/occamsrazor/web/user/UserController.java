package com.occamsrazor.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messager;

@RestController
@RequestMapping("/user") // com.occamsrazor.web.member
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping("/join")
	public Messager join(@RequestBody User user) {
		Messager messager = null;
		int count = userService.count();
		userService.add(user);
		
		return (userService.count() == count + 1)? Messager.SUCCESS:Messager.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String,Object> login(@RequestBody User user) {
		Map<String,Object> returnMap = new HashMap<>();
		User loginedUser = userService.login(user);
		if(loginedUser != null) {
			returnMap.put("user", loginedUser);
			returnMap.put("messenger", Messager.SUCCESS);
		}else {
			returnMap.put("messenger", Messager.FAIL);
		}
		return returnMap;
	}
}
