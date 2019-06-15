package com.dt.K.M;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dt.K.M.Member;


@Service
public class UpdateNickSv {
	@Autowired
	private MemberDao M_Dao;

	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;
	String m_Nickname;
	String m_Nickname2;
	
	public ModelAndView excute(int type, Member member) {
		sessionnickname=(String)request.getSession().getAttribute("sessionnickname");
		mav = new ModelAndView();
		switch (type) {
		case 1:
			UpdateNickPage(member);
			break;
		case 2:
			UpdateNick(member);
			break;
		case 3:

		default:
			break;
		}

		return mav;
	}

	private void UpdateNick(Member member) {
		sessionmid = "ljs@naver.com";
		member.setM_Email(sessionmid);
		// 비번 체크
		if (M_Dao.isNickName(member)) {
			// 새비번이 공백이 아니면
			if (!(member.getM_PWD().equals(""))) {
				// 새비번 확인란이 공백이 아니면
				if (!(member.getM_GRType().equals(""))) {
					// 새비번 //새비번 확인
					if (member.getM_PWD().equals(member.getM_GRType())) {
						member.setM_Nickname(member.getM_PWD());
						if (M_Dao.UpdateNick(member)) {
							request.getSession().setAttribute("sessionnickname", member.getM_Nickname());
							mav.setViewName("main/main");
							mav.addObject("message", "닉네임이 정상적으로 수정되었습니다.");
							return;
						} else {
							mav.addObject("message", "닉네임 수정에 실패하였습니다.");
						}
					} else {
						mav.addObject("message", "닉네임이 일치하지 않습니다.");

					}
				} else {
					mav.addObject("message", "닉네임 확인란을 입력하세요.");
				}
			} else {
				mav.addObject("message", "닉네임을 입력하세요.");

			}
		} else {
			mav.addObject("message", "현재 닉네임이 틀렸습니다.");

		}
		
		UpdateNickPage(member);
	}



	private void UpdateNickPage(Member member) {
		sessionmid = "ljs@naver.com";
		mav.addObject("UpdateNick", UpdateNickHTML(member));
		mav.setViewName("service/NickUpdate");		
	}
	
	private String UpdateNickHTML(Member member) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/UpdateNick' method='post'>");
		sb.append("<table>");
		sb.append("현재 닉네임 : <input type='text' name='m_Nickname' value='"+sessionnickname+"'/></br>");
		sb.append("신규 닉네임 : <input type='text' name='m_PWD'/></br>");
		sb.append("닉네임 확인 : <input type='text' name='m_GRType'/><br>");
		sb.append("<input type='submit' value='등록'/>");
		sb.append("<input type='button' value='취소'/></form>");
		sb.append("</table>");

		return sb.toString();
	}
}
