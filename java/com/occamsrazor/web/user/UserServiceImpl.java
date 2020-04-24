package com.occamsrazor.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private Map<String, Object> map; 
	private int count ;
	//Map의 키값은 String , 상수풀에 있어야 빨리찾는다
	//<> 엔트리 배열
	public UserServiceImpl() {
		map = new HashMap<>();
		count = 0;
	}
	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}
	@Override
	public int count() {
		
		return map.size();
	}
	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPasswd().equals(u.getPasswd())) {
				returnUser = u;
				
			}
		}
		return returnUser;
	}
	@Override
	public User detail(String userid) {
		System.out.println("id"+userid);
		User t = (User) map.get(userid);
		System.out.println("map"+t);
		return (User) map.get(userid);
	}
	@Override
	public boolean update(User user) {
		
		map.replace(user.getUserid(), user);
		return true;
	}
	@Override
	public boolean remove(String userid) {
		
		map.remove(userid);
		
		return true;
	}
	
	
}
