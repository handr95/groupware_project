package com.dt.K.M;

import java.util.Random;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class Join_MemberSV {
	@Autowired
	private MemberDao mDao;
	@Autowired
	private HttpServletRequest session;
	@Autowired
	private JavaMailSender mailSender;

	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;

	public ModelAndView excute(int type, Member member) {
		mav = new ModelAndView();
		switch (type) {
		case 1:
			System.out.println("excute1");
			join(member);
			break;
		case 2:
			System.out.println("excute2");
			isId(member);
			break;
		case 3:
			System.out.println("excute3");
			isNickname(member);
			break;
		case 4:
			System.out.println("excute4");
			emailconfirm(member);
			break;
		case 5:
			System.out.println("excute5");
			transfer(member);
			break;
		case 6:
			System.out.println("excute6");
			logincheck(member);
			break;
		default:
			break;

		}

		return mav;
	}

	private void logincheck(Member member) {
		System.out.println("logincheck");
		if (mDao.logincheck(member)) {
			mav.addObject("message", "Y");
			mav.setViewName("/main/main");
		} else {
			mav.addObject("message", "N");
			mav.setViewName("/main/main");
		}
	}
	


	private void join(Member member) {
		System.out.println("join");
		
		
		if (member.getM_GRType() == null)
			member.setM_GRType("MS");
		
		if (mDao.logincheck(member)) {
			if (!mDao.isId(member)) {
				if (!mDao.isNickName(member)) {
					if (!mDao.confirmDel(member)) {
						if (mDao.join(member)) {
							mav.addObject("message_join", "회원가입 성공");
							
							mav.setViewName("/main/main");
						} else {
							mav.setViewName("/main/join");
							System.out.println("5안돼");
						}
					} else {
						System.out.println("1안돼");
						mav.setViewName("/main/join");
					}
				} else {
					System.out.println("2안돼");
					mav.setViewName("/main/join");
				}
			} else {
				System.out.println("3안돼");
				mav.setViewName("/main/join");
			}
		} else {
			System.out.println("4안돼");
			mav.setViewName("/main/join");
		}
		
		mDao.emNumberDelete(member);

	}

	
	
	
	
	
	
	private void isId(Member member) {
		
		System.out.println("usId");
		
		if (mDao.isId(member)) {
			mav.addObject("message_id", "'" + member.getM_Email()
					+ "'는 사용중인 이메일 입니다");
		} else {
			mav.addObject(
					"message_id",
					"'"
							+ member.getM_Email()
							+ "'는 사용 가능한 이메일 입니다<br>"
							+ "<input type='button' id='confirm' value='이메일 인증번호 전송' onclick=\"alarm('"
							+ member.getM_Email() + "')\" >");
		}
		mav.setViewName("/main/messagepage");
	}

	
	
	
	private void isNickname(Member member) {
		
		System.out.println("isNickname");
		
		if (mDao.isNickName(member)) {
			mav.addObject("message_Nickname", "'" + member.getM_Nickname()
					+ "'는 사용중인 닉네임 입니다");
		} else {
			System.out.println("isNickname"+member.getM_Nickname());
			mav.addObject("message_Nickname", "'" + member.getM_Nickname()
					+ "'는 사용 가능한 닉네임 입니다");
		}
		mav.setViewName("/main/messagepage");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public static String getRandomPassword(int length) {
		
		System.out.println("getRandom");
		
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

	private void emailconfirm(Member member) {
		
		//System.out.println("emailconfirm");
		
		member.setEm_code(getRandomPassword(8));
		
		mDao.emNumberinsert(member);
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");
			messageHelper.setTo(member.getM_Email());
			messageHelper.setText("http://192.168.0.119/transfer?em_code="
					+ member.getEm_code() + "&m_Email=" + member.getM_Email());
			messageHelper.setFrom("handr95@gmail.com");
			messageHelper.setSubject("sgw 인증번호"); // 메일제목은 생략이 가능하다

			MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
	        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	        CommandMap.setDefaultCommandMap(mc);
			
			mailSender.send(message);
			System.out.println("언제 보내지징");
						
		} catch (Exception e) {
			System.out.println(e);
		}
		mav.setViewName("/main/join");
	}

	private void transfer(Member member) {

		System.out.println("transfer");
		
		mDao.emNumberUpdate(member);
		
		mav.setViewName("/main/mailconfirmalarm");
	}

}
