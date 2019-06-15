package com.dt.M.SM;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Service;
@Service
public class AlarmMgrSv {
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
			alramMgrUpdate(sm_member);
			break;

		default:

		}
		return mav;
	}

	private void alramMgrUpdate(SM_Member sm_member) {
		mav.setViewName("service/alarm");
		//List<Alarm> alarm=null;
		mav.addObject("getAlarm",getAlarm(/*alarm*/));
	}
	
	private String getAlarm(/*List<Alarm> alarm*/) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form id='alarm_form' method='post'>");
		sb.append("<table class='alarm_setting'>");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th class='menu'>분류</th>");
		sb.append("<th class='part'>영역</th>");
		sb.append("<th class='memo'>쪽지</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		sb.append("<tr>");
		sb.append("<td class='menu' rowspan='5'>프로젝트</td>");
		sb.append("<td class='part'><span class='all'>전체</span></td>");
		sb.append("<td class='memo'><input type='checkbox' class='P_memo' id='P_memo'</td>");
		sb.append("</tr>");
		sb.append("</table>");
		return sb.toString();
		
	}
}
