package com.dt.L.MI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberDropSv {

	
	private ModelAndView mav;
	@Autowired
	private MyPageDao MyPageDao;
	@Autowired
	private HttpServletRequest session;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	public ModelAndView execute(int type, Member member){
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");		
		mav = new ModelAndView();
		switch(type){
		case 1:
			memberDropPage(member);
			break;
		case 2:
			memberDrop(member);
			break;	
		default:
			break;
		}
		return mav;
	}
	private void memberDropPage(Member member){
		mav = new ModelAndView();
		mav.setViewName("/service/myDrop");
		
	}
	
	private void memberDrop(Member member){
		mav = new ModelAndView();
		//sessionmid ="hmm@naver.com";
		member.setM_Email(sessionmid);
		MyPageDao.memberDrop(member);
		mav.setViewName("/main/main");
	}
	
}
