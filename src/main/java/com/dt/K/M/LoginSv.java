package com.dt.K.M;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginSv {
	@Autowired
	private MemberDao M_Dao;
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JavaMailSender mailSender;

	private ModelAndView mav;
	private String sessionmid;
	private String sessionnickname;
	private String grade1;
	private String sessionteam;
	private String grade2;

	public ModelAndView excute(int type, Member member) {
		mav = new ModelAndView();
		switch (type) {
		case 1:
			logIn(member);
			break;
		case 2:
			findPWD(member);
			break;
		case 3:
			logOut(member);
			break;
		case 4:
			findPWDAjax(member);
		case 5:
			alterPWD(member);
		default:
			break;
		}

		return mav;
	}


	
	private void logIn(Member member){
		if(M_Dao.isId(member)){
			if(M_Dao.logIn(member)){
				//로그인 성공
				member=M_Dao.memberinfo(member);
				M_Dao.loginInsert(member);
				request.getSession().setAttribute("sessionmid",member.getM_Email());
				request.getSession().setAttribute("sessionnickname",member.getM_Nickname());
				request.getSession().setAttribute("grade1",member.getM_GRType());
				
				member=null;
				
				mav.setViewName("/main/main");				
			} else {
				// 패스워드 불일치
				mav.addObject("message", "존재하지 않는 패스워드");
				mav.setViewName("/main/main");
			}

		} else {
			// 아이디 불일치
			mav.addObject("message", "존재하지 않는 아이디");
			mav.setViewName("/main/main");
		}
	}

	private void findPWD(Member member) {
		mav = new ModelAndView();
		if (member.getM_GRType() == null)
			member.setM_GRType("MS");
		if (M_Dao.findPw(member)) {

		} else {
			System.out.println("3안돼");
		}
	}

	private void findPWDAjax(Member member) {
		mav = new ModelAndView();

		mav.setViewName("main/pwconfirm");
		mav.addObject("pwajax", findPWD_HTML(member));
	}

	private String findPWD_HTML(Member member) {
		StringBuffer sb = new StringBuffer();

		sb.append("<form action='/alterPWD' method='post'>");
		sb.append("이메일 : <input type='text' name='m_Email'>");
		sb.append("이름 : <input type='text' name='m_Name'>");
		sb.append("닉네임 : <input type='text' name='m_Nickname'>");
		sb.append("<input type='submit' value='임시 비밀번호 발송'>");
		sb.append("</form>");

		return sb.toString();
	}

	private void logOut(Member member) {
		request.getSession().invalidate();
		mav.addObject("message", "로그아웃");
		mav.setViewName("/main/main");
	}

	public static String getRandomPassword(int length) {
		char[] charaters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9' };
		StringBuilder sb = new StringBuilder("");
		Random rn = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(charaters[rn.nextInt(charaters.length)]);
		}
		return sb.toString();
	}

	private void alterPWD(Member member) {
		member.setM_PWD(getRandomPassword(8));
		StringBuffer sb = new StringBuffer();

		if (M_Dao.ismember(member)) {
			if (M_Dao.alterPWD(member)) {
				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(
							message, true, "UTF-8");
					messageHelper.setTo(member.getM_Email());
					messageHelper
							.setText("임시 비밀번호는" + M_Dao.alterPWDpw(member));
					messageHelper.setFrom("handr95@gmail.com");
					messageHelper.setSubject("sgw 인증번호"); // 메일제목은 생략이 가능하다

					mailSender.send(message);
					System.out.println("언제 보내지징");
				} catch (Exception e) {
					System.out.println(e);
				}
				
				
				
				mav.setViewName("main/join");
				System.out.println("성공");
			}else{
				System.out.println("1실패");
				//mav.setViewName("main/join");
			}
		}else{
			//mav.setViewName("main/join");
		}

	}

}
