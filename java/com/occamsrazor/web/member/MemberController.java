package com.occamsrazor.web.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	public MemberService memberService;
	
	
	@PostMapping("/join")
	public String add(@RequestBody Member member) {
		System.out.println(">>>>");
		System.out.println(member.toString());
//		인터넷에 연결하는부분
		memberService = new MemberServiceImpl();
		memberService.add(member);
		
		return member.getName();
	}
}
