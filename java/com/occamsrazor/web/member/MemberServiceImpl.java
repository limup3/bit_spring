package com.occamsrazor.web.member;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	private Member[] members;
	private int count;
	
	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	
	}
	
	@Override
	public Member[] list() {
		return members;
	}

	@Override
	public Member detail(Member member) {
		Member returnMember = null;
		
		for (int i = 0; i < count; i++) {
			
			if(member.getUserid().equals(members[i].getUserid())) {
				returnMember = new Member();
				returnMember = members[i];	
			}
			
			
		}
		
		return returnMember;
	}

	@Override
	public Member[] SearchByName(String name) {
		Member[] returnMembers =null;
		int searchcount = 0;
		
		if(searchcount != 0) {
			returnMembers = new Member[count(name)];
			int j = 0;
			for (int i = 0; i < count; i++) {
				if(name.equals(members[i].getName())) {
					returnMembers[j] = members[i];
					j++;	
					if(searchcount == 0) {
						break;
					}
				}
				
			}
			
			
		}
		return returnMembers;
	}
	
	@Override
	public void add(Member member) {	
		members[count] = member;
		count++;
	}
	

	@Override
	public int count() {
		return count;
	}

	@Override
	public int count(String name) {

		int returnCount = 0;
		
		for (int i = 0; i < count; i++) {
			if(name.equals(members[i].getName())) {
				returnCount++;
			}
			
		}
		
		
		
		return returnCount;
	}

	@Override
	public boolean login(Member member) {
		
		boolean ok = false;
		
		for (int i = 0; i < count; i++) {
			if(member.getUserid().equals(members[i].getUserid()) &&
					member.getPasswd().equals(members[i].getPasswd())) {
				ok = true;
				break;
			}
		}
		return ok;
		
	}

	@Override
	public void update(Member member) {
		
		for (int i = 0; i < count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPasswd(member.getPasswd());
				break;
			}
		}

		
		
	}

	@Override
	public void delete(Member member) {
for (int i = 0; i < count; i++) {
			
			if(member.getUserid().equals(members[i].getUserid()) &&
					member.getPasswd().equals(members[i].getPasswd())) {
				
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
				
				
			}
		}
		}


	

}
