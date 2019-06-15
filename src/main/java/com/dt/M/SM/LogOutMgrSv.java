package com.dt.M.SM;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LogOutMgrSv {
	@Autowired
	private ServiceDao serviceDao;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	
public ModelAndView excute(int type, SM_Member sm_member) {
		
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		switch (type) {
		
		case 1:
			logOutOption(sm_member);
			break;
		case 2:
			logOutTimeSet(sm_member);
			break;
		
		default:

		}

		return mav;
	}
	
	
	public void logOutOption(SM_Member sm_member){
		mav.setViewName("service/logoutSet");
	}
	
	public void logOutTimeSet(SM_Member sm_member){
		
	}
}
