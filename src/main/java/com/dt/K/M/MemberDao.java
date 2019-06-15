package com.dt.K.M;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;




@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}
	
	public boolean join(Member member){
		return intConvert(session.insert("Members.join", member));
	}	
	public boolean isId(Member member){
		return intConvert((Integer)session.selectOne("Members.isId", member));
	}
	public boolean isNickName(Member member){
		System.out.println("dddd"+member.getM_Nickname());
		return intConvert((Integer)session.selectOne("Members.isNickName", member));
	}
	public boolean logIn(Member member){
		return intConvert((Integer)session.selectOne("Members.logIn", member));
	}
	public boolean findPw(Member member){
		return session.selectOne("Members.findPw", member);
	}
	
	public boolean alterPWD(Member member){
		System.out.println(member.getM_PWD());
		return intConvert(session.update("Members.alterPWD", member));
	}
	
	public boolean ismember(Member member){
		return intConvert((Integer)session.selectOne("Members.ismember", member));
	}
	
	public Member memberinfo(Member member){
		return session.selectOne("Members.memberinfo", member);
	}
	
	public boolean emNumberinsert(Member member){
		System.out.println(member.getEm_code());
		return intConvert(session.insert("Members.emNumberinsert", member));
	}
	public boolean UpdateNick(Member member) {
		return intConvert(session.update("Members.UpdateNick", member));
	}
	//로그인내역 입력
	public boolean loginInsert(Member member){
		return intConvert(session.insert("Members.loginInsert", member));
	}
	
	
	public boolean emNumberUpdate(Member member){
		return intConvert(session.update("Members.emNumberupdate", member));
	}
	
	public boolean logincheck(Member member){
		return intConvert((Integer)session.selectOne("Members.logincheck", member));
	}
	
	public boolean confirmDel(Member member){
		return intConvert(session.delete("Members.confirmDel", member));
	}
	
	public String alterPWDpw(Member member){
		return session.selectOne("Members.alterPWDpw", member);
	}
	
	public boolean emNumberDelete(Member member){
		return intConvert(session.delete("Members.emNumberDelete", member));
	}
	

}
