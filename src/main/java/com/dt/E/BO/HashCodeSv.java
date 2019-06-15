package com.dt.E.BO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HashCodeSv {
	@Autowired
	private BoardDao bDao;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, Hash hashcodebean) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		switch (type) {
		case 1:
			findHash(hashcodebean);
			break;
		case 2:
			viewHash(hashcodebean);
			break;
		default:
		}

		return mav;
	}
	
	private void findHash(Hash hashcodebean){
		mav=new ModelAndView();
		
	}
	private void viewHash(Hash hashcodebean){
		mav=new ModelAndView();
		
	}
	
	
}

