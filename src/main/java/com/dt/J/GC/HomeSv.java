package com.dt.J.GC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HomeSv {
	@Autowired
	private MainDao mainDao;
	private ModelAndView mav;
	@Autowired
	private HttpServletRequest session;	
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	public ModelAndView excute(int type, Member member){
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(grade1==null)
			grade1="";
		mav = new ModelAndView();
		switch(type){
		case 1:
			homeform(member);
			break;
		case 2:
			joinform(member);
			break;
		case 3:
			serviceform(member);
			break;
		case 4:
			stroyform(member);
			break;
		default:
			break;
		}
		return mav;
	}
	
	private void stroyform(Member member) {
		mav.setViewName("/main/story");
	}

	private void serviceform(Member member) {
		mav.setViewName("/main/service");
	}

	private void homeform(Member member){
		mav.setViewName("/main/main");
	}
	private void joinform(Member member) {
		mav.setViewName("/main/join");	
	}
}
