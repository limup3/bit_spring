package com.occamsrazor.web.grade;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Credit;

//import com.occamsrazor.web.util.Credit;

@Service
public class GradeServiceImpl implements GradeService {
	
	private Grade[] grades;
	private int count;
	
	public GradeServiceImpl() {
		grades = new Grade[5];
		count = 0;
	}
	
	@Override
	public void add(Grade grade) {
		
		grades[count] = grade;
		count++;
	}

	@Override
	public Grade[] list() {
		return grades;
	}

	@Override
	public Credit detail(String userid) {
		Credit credit = null;
		switch(avg(userid)/10) {
		case 10: case 9: credit = Credit.A; break;
		case 8: credit = Credit.B; break;
		case 7: credit = Credit.C; break;
		case 6: credit = Credit.D; break;
		case 5: credit = Credit.E; break;
		default : credit = Credit.F; break;
		}
		
		return credit;
	}
	@Override
	public int avg(String userid) {
		return total(userid) / 4;
	}

	private int total(String userid) {
		int total = 0;
		for (int i = 0; i < count; i++) {
			if (userid.equals(grades[i].getUserid())) {
				total = Integer.parseInt(grades[i].getKorean())
						+ Integer.parseInt(grades[i].getEnglish())
						+ Integer.parseInt(grades[i].getMath())
						+ Integer.parseInt(grades[i].getJava());
						
			}
		}
		return total;
	}

	@Override
	public void update(Grade grade) {
		
	}

	@Override
	public void delete(Grade grade) {
		
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int sum(Grade grade) {
		
		int total = Integer.parseInt(grade.getKorean())
				+ Integer.parseInt(grade.getEnglish())
				+ Integer.parseInt(grade.getMath())
				+ Integer.parseInt(grade.getJava()); 
		
		return total;
//		return Integer.parseInt((grade.getKorean() + grade.getEnglish() + grade.getMath() + grade.getJava()));
	}

	@Override
	public int avg(Grade grade) {
		return sum(grade)/4;
	}

	@Override
	public Credit record(Grade grade) {
		Credit result = null;
		
		int avg = avg(grade);
		
		if(avg >= 90) {
			result = Credit.A;
		} else if(avg >= 80 && avg < 90) {
			result = Credit.B;
		} else if(avg >= 70 && avg < 80) {
			result = Credit.C;
		} else if(avg >= 60 && avg < 70) {
			result = Credit.D;
		} else if(avg >= 50 && avg < 60) {
			result = Credit.E;
		} else if( avg < 50) {
			result = Credit.F;
		} else {
			result = Credit.ERROR;
		}
		
		return result;
	}



}
