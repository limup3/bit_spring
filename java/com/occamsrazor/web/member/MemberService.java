package com.occamsrazor.web.member;

public interface MemberService {

	public Member[] list();
	public Member detail(Member member);
	public Member[] SearchByName(String name);
	public int count();
	public int count(String name);
	public Member login(Member member);
	public void update(Member member);
	public void delete(Member member);
	public void add(Member member);
	
}
