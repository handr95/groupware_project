package com.dt.L.MI;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MI_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(MI_Controller.class);
		
	@Autowired
	private BaseInfoSv baseInfoSv;
	
	@Autowired
	private UpdatePwdSv UpdatePwdSv;
	
	@Autowired
	private MemberDropSv memberDropSv;	
	
	@Autowired
	private MyMemoHamSv mymemoHamSv;
	
	@Autowired
	private MyBoardPanSv myboardSv;
	
	private ModelAndView mav;
	private static boolean token=false; 
	@RequestMapping(value = "/baseInfoPage", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView baseInfoPage(@ModelAttribute Member member) {
		mav =  baseInfoSv.excute(1,member);
		return mav;
	}	
	@RequestMapping(value = "/memberInfoPage", method = RequestMethod.GET)
	public ModelAndView memberInfoPage(@ModelAttribute Member member) {	
		mav = baseInfoSv.excute(2,member);
		return mav;
	}	

	@RequestMapping(value = "/UpdatePwdPage", method = RequestMethod.GET)
	public ModelAndView UpdatePwdPage(@ModelAttribute Member member) {		
		mav = UpdatePwdSv.excute(1,member);
		return mav;
	}	
	@RequestMapping(value = "/UpdatePwd", method = RequestMethod.POST)
	public ModelAndView UpdatePwd(@ModelAttribute Member member) {		
		mav = UpdatePwdSv.excute(2,member);
		return mav;
	}	
	
	
	@RequestMapping(value = "/memberDropPage", method = RequestMethod.GET)
	public ModelAndView memberDropPage(@ModelAttribute Member member) {		
		mav = memberDropSv.execute(1, member);
		return mav;
	}	
	@RequestMapping(value = "/memberDrop", method = RequestMethod.GET)
	public ModelAndView memberDrop(@ModelAttribute Member member) {
		mav = memberDropSv.execute(2, member);
		return mav;
	}	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/MyMemoHamList", method = RequestMethod.GET)
	public ModelAndView MyMemoHamList(@ModelAttribute MyMemoHam memoham) {		
		mav = mymemoHamSv.excute(1, memoham);
		return mav;
	}
	
	@RequestMapping(value = "/MyMemoHamInsertForm", method = RequestMethod.GET)
	public ModelAndView MyMemoHamInsertForm(@ModelAttribute MyMemoHam memoham) {		
		mav = mymemoHamSv.excute(2, memoham);
		return mav;
	}
	
	@RequestMapping(value = "/MyMemoHamInsert", method = RequestMethod.POST)
	public ModelAndView MyMemoHamInsert(@ModelAttribute MyMemoHam memoham) {		
		mav = mymemoHamSv.excute(3, memoham);
		return mav;
	}
	
	@RequestMapping(value = "/MymemohamUpdateform", method = RequestMethod.GET)
	public ModelAndView MymemohamUpdateform(@ModelAttribute MyMemoHam memoham) {		
		mav = mymemoHamSv.excute(4, memoham);
		return mav;
	}
	
	@RequestMapping(value = "/MymemohamUpdate", method = RequestMethod.POST)
	public ModelAndView MymemohamUpdate(@ModelAttribute MyMemoHam memoham) {		
		mav = mymemoHamSv.excute(3, memoham);
		return mav;
	}
	

	
	
	
	
	
	
	
	
	@RequestMapping(value = "/myPostList", method = RequestMethod.GET)
	public ModelAndView myPostList(@ModelAttribute BoardPost boardpost) {		
		if(token == true){
			token = false;
		}mav = myboardSv.excute(1, boardpost);
		return mav;
	}
	
	@RequestMapping(value = "/myPostInsertForm", method = RequestMethod.GET)
	public ModelAndView myPostInsertForm(@ModelAttribute BoardPost boardpost) {		
		if(token == true){
			token = false;
		}mav = myboardSv.excute(2, boardpost);
		return mav;
	}
	
	@RequestMapping(value = "/myPostInsert", method = RequestMethod.POST)
	public ModelAndView myPostInsert(@ModelAttribute BoardPost boardpost) {		
		if(token == false){
			mav = myboardSv.excute(3, boardpost);
		}else{
			mav = myboardSv.excute(2, boardpost);
		}
		return mav;
	}
	
	@RequestMapping(value = "/myPostUpdateform", method = RequestMethod.GET)
	public ModelAndView myPostUpdateform(@ModelAttribute BoardPost boardpost) {		
		if(token == true){
			token = false;
		}mav = myboardSv.excute(4, boardpost);
		return mav;
	}
	
	@RequestMapping(value = "/myPostUpdate", method = RequestMethod.POST)
	public ModelAndView myPostUpdate(@ModelAttribute BoardPost boardpost) {		
		if(token == false){
			mav = myboardSv.excute(3, boardpost);
		}else{
			mav = myboardSv.excute(4, boardpost);
		}
		return mav;
	}
	
	
}

