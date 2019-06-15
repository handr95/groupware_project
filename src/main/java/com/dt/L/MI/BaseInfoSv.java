package com.dt.L.MI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class BaseInfoSv {

	private ModelAndView mav;
	@Autowired
	private MyPageDao MyPageDao;
	@Autowired
	private HttpServletRequest request;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, Member member) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");
		mav = new ModelAndView();
		
		switch (type) {
		case 1:
			MemberInfo(member);
			break;
		case 2:
			IsName(member);
			break;
		case 3:
			IsNick(member);
			break;

		default:
			break;
		}
		return mav;
	}

	private void MemberInfo(Member member) {
		//mav = new ModelAndView();
		//sessionmid = "kek@naver.com";
		member.setM_Email(sessionmid);
		System.out.println("service");
		System.out.println(MyPageDao.MyInfo(member).size());
		System.out.println(MyPageDao.MyInfo(member).get(0).getM_Email());
		mav.addObject("myInfo", MemberInfoHTML(MyPageDao.MyInfo(member)));
		mav.setViewName("service/myInfo");
	}

	private String MemberInfoHTML(List<Member> memberlist) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr><td>아이디</td><td>닉네임</td><td>");
		for (Member member : memberlist) {
			sb.append("<tr><td>" + member.getM_Email() + "</td>");
			sb.append("<td>" + member.getM_Nickname() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");

		return sb.toString();
	}

	private void IsName(Member member) {
		mav = new ModelAndView();
		//////////////////////////////

	}

	private String IsNameHTML(List<Member> memberlist) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr><td>아이디</td><td>");
		for (Member member : memberlist) {
			sb.append("<tr><td>" + member.getM_Email() + "</td></tr>");

		}
		sb.append("</table>");

		return sb.toString();
	}

	private void IsNick(Member member) {
		mav = new ModelAndView();
		///////////////////////////////////////
	}
	
	private void updateNick(Member member) {
		mav = new ModelAndView();
		
	}

}
