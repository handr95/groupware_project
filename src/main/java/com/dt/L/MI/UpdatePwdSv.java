package com.dt.L.MI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UpdatePwdSv {

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
	private String m_pwd1;
	private String m_pwd2;

	public ModelAndView excute(int type, Member member) {
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		switch (type) {
		case 1:
			UpdatePwdPage(member);
			break;
		case 2:
			UpdatePwd(member);
			break;
		case 3:

		default:
			break;
		}

		return mav;
	}

	private void UpdatePwdPage(Member member) {
		//sessionmid = "ljs@naver.com";

		member.setM_Email(sessionmid);

		mav.addObject("UpdatePwd", UpdatePwdHTML(member));
		mav.setViewName("service/pwdUpdate");

	}

	private String UpdatePwdHTML(Member member) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/UpdatePwd' method='post'>");
		sb.append("<table>");
		sb.append("현재 비밀번호 : <input type='text' name='m_PWD'/></br>");
		sb.append("신규 비밀번호 : <input type='text' name='m_Nickname'/></br>");
		sb.append("비밀번호 확인 : <input type='text' name='m_GRType'/><br>");
		sb.append("<input type='submit' value='등록'/>");
		sb.append("<input type='button' value='취소'/></form>");
		sb.append("</table>");

		return sb.toString();
	}

	private void UpdatePwd(Member member) {
		//sessionmid = "ljs@naver.com";
		member.setM_Email(sessionmid);
		// 비번 체크
		if (MyPageDao.isPWD(member)) {
			// 새비번이 공백이 아니면
			if (!(member.getM_Nickname().equals(""))) {
				// 새비번 확인란이 공백이 아니면
				if (!(member.getM_GRType().equals(""))) {
					// 새비번 //새비번 확인
					if (member.getM_Nickname().equals(member.getM_GRType())) {
						member.setM_PWD(member.getM_Nickname());
						if (MyPageDao.UpdatePwd(member)) {
							mav.addObject("message", "비밀번호가 정상적으로 수정되었습니다.");
						} else {
							mav.addObject("message", "비밀번호 수정에 실패하였습니다.");
						}
					} else {
						mav.addObject("message", "비번이 일치하지 않습니다.");

					}
				} else {
					mav.addObject("message", "비밀번호확인란을 입력하세요.");
				}
			} else {
				mav.addObject("message", "비밀번호를 입력하세요.");

			}
		} else {
			mav.addObject("message", "현재 비번이 틀렸습니다.");

		}
		mav.setViewName("service/pwdUpdate");
		UpdatePwdPage(member);
	}

}
