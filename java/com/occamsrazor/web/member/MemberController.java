package com.occamsrazor.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/member") // com.occamsrazor.web.member
public class MemberController {
	@Autowired MemberService memberService;
	//new 역할을 하고있음
	public int count;
	
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
//		인터넷에 연결하는부분
		int current = memberService.count();
		memberService.add(member);
//		int count = memberService.count();
//		Messager result = null;
//		if(count == 1) {
//			result = Messager.SUCCESS;
//		}else {
//			result = Messager.FAIL;
//		}
		return (memberService.count() == (current+1))?Messenger.SUCCESS:Messenger.FAIL;
	}
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		//String은 반환불가(자바에서만 가능) 객체로 보내야된다
//		boolean loginOk = memberService.login(member);
//		String message = "";
//		if(!loginOk) {
//			message = "SUCCESS";
//		}else {
//			message = "FAIL";
//		}
//		(memberService.login(member))?"SUCCESS" : "FAIL"
		
		
		return  (memberService.login(member))?Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public Member[] list() {
		Member[] returnMembers = new Member[5];
		memberService.list();
		return returnMembers;
	}
	
	@GetMapping("/detail")
	public Member detail(@RequestBody Member member) {
		Member returnMember = new Member();
		memberService.detail(returnMember);
		return returnMember;
	}
	
	@GetMapping("/count")
	public int count() {
		count = 0;
		memberService.count();
		return count;
	}
}
