package com.dt.AA.test;

import javax.servlet.http.HttpServletRequest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class sessionSV2 {
	private ModelAndView mav;
	@Autowired
	private HttpServletRequest session;
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
		System.out.println("sessiontest2:"+session.getSession().getAttribute("mid"));
		mav = new ModelAndView("templte/sessionTest");
	}
}
