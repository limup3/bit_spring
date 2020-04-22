package com.occamsrazor.web.grade;

import com.occamsrazor.web.util.Credit;

public interface GradeService {

	public void add(Grade grade);
	public Grade[] list();
	public Credit detail(String userid);
	public void update(Grade grade);
	public void delete(Grade grade);
	public int count();
	public int sum(Grade grade);
	public int avg(Grade grade);
	public int avg(String userid);
	public Credit record(Grade grade);
}
