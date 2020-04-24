package com.occamsrazor.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Credit;
import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
//	public GradeService gradeService;
	public int count;
	
	@PostMapping("/register")
	public Messenger register(@RequestBody Grade grade) {
		int current = gradeService.count();
		gradeService.add(grade);
		System.out.println(grade+"add");
		
		
		return(gradeService.count() == (current+1))?Messenger.SUCCESS:Messenger.FAIL;
		
	
	}
	@GetMapping("/record/{userid}")//상수풀에 존재
	public Credit record(@PathVariable String userid) {
		return gradeService.detail(userid);
//		gradeService.sum(grade);
//		gradeService.avg(grade);
//		System.out.println(grade+"record");
//		System.out.println(gradeService.avg(grade)+"avg");
//		return gradeService.record(grade);
	}
	
	
}
