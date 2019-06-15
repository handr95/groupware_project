package com.dt.K.M;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class Member_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Member_Controller.class);
	private static boolean token = false;
	@Autowired
	private LoginSv LoginSv;
	@Autowired
	private Join_MemberSV Join_MemberSv;
	@Autowired
	private UpdateNickSv upNickSv;
	
	
	private ModelAndView mav;
	//GuestCenter_Controller에 있는거 사용하기로 하고 지움(joinform)	
	
	@RequestMapping(value = "/joinInsert", method = RequestMethod.POST)
	public ModelAndView joinInsert(@ModelAttribute Member member) {		
		System.out.println("sss");
		if(token == false){
			mav = Join_MemberSv.excute(1, member);
			token = true;
		}else{
			System.out.println("메인페이지");
			mav = new ModelAndView("main/main");
		}
		
		return mav;
	}
	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST)
	public ModelAndView emailcheck(@ModelAttribute Member member) {		
		//System.out.println("con2"+member.getM_Nickname());
		mav = Join_MemberSv.excute(2, member);	
		return mav;
	}
	@RequestMapping(value = "/nicknamecheck", method = RequestMethod.POST)
	public ModelAndView nicknamecheck(@ModelAttribute Member member) {
		System.out.println("con1"+member.getM_Nickname());
		mav = Join_MemberSv.excute(3, member);	
		return mav;
	}
	//GuestCenter_Controller에 있는거 사용하기로 하고 지움(findPWDform)		
	
			
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Member member) {
		mav = LoginSv.excute(1, member);	
		return mav;
	}
	
	@RequestMapping(value = "/findPWD", method = RequestMethod.POST)
	public ModelAndView findPWD(@ModelAttribute Member member) {		
		ModelAndView mav = LoginSv.excute(2, member);	
		return mav;
	}
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public ModelAndView logOut(@ModelAttribute Member member) {
		ModelAndView mav = LoginSv.excute(3, member);	
		return mav;
	}
	
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.POST)
	public ModelAndView emainconfirm(@ModelAttribute Member member) {
		ModelAndView mav = Join_MemberSv.excute(4, member);	
		return mav;
	}
	
	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public ModelAndView transfer(@ModelAttribute Member member) {
		ModelAndView mav = Join_MemberSv.excute(5, member);	
		return mav;
	}
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public ModelAndView logincheck(@ModelAttribute Member member) {
		ModelAndView mav = Join_MemberSv.excute(6, member);	
		return mav;
	}
	
	@RequestMapping(value = "/findPWDAjax", method = RequestMethod.POST)
	public ModelAndView findPWDAjax(@ModelAttribute Member member) {

		ModelAndView mav = LoginSv.excute(4, member);		
		return mav;
	}
	
	@RequestMapping(value = "/alterPWD", method = RequestMethod.POST)
	public ModelAndView alterPWD(@ModelAttribute Member member) {

		ModelAndView mav = LoginSv.excute(5, member);	
		
		return mav;
	}
	
	@RequestMapping(value = "/UpdateNickPage", method = RequestMethod.GET)
	public ModelAndView UpdateNickPage(@ModelAttribute Member member) {
		ModelAndView mav = upNickSv.excute(1, member);	
		return mav;
	}
	
	@RequestMapping(value = "/UpdateNick", method = RequestMethod.POST)
	public ModelAndView UpdateNick(@ModelAttribute Member member) {
		ModelAndView mav = upNickSv.excute(2, member);	
		return mav;
	}
	
}

