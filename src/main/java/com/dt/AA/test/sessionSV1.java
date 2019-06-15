package com.dt.AA.test;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class sessionSV1 {
	private ModelAndView mav;
	@Autowired
	private HttpServletRequest session;
	private String sessionmid; 
	private String grade1;
	private String sessionteam;
	private String grade2;	
	public ModelAndView excute(int type, SessionTestBean sessionbean) {

		switch(type){
		case 1:
			sessiontest(sessionbean);
			break;
		default :	
			
	}
		return mav;
	}
	private void sessiontest(SessionTestBean sessionbean) {
		System.out.println("파라미터"+sessionbean.getMid());
		session.getSession().setAttribute("mid", sessionbean.getMid());
		System.out.println("sessiontest1:"+session.getSession().getAttribute("mid"));
		mav = new ModelAndView("templte/sessionTest");
	}
}
