package com.dt.J.GC;

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
public class GuestCenter_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestCenter_Controller.class);
	private static boolean token=false; 
	
		
	@Autowired
	private NoticeSv noticeSv;
	
	@Autowired 
	private QuestSv questSv;
	
	@Autowired
	private ErrorReportSv errorReportSv;
	
	@Autowired
	private HomeSv homeSv;
	
	private ModelAndView mav;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeform(@ModelAttribute Member member) {		
		mav =  homeSv.excute(1, member);
		return mav;
		
	}

	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public ModelAndView joinform(@ModelAttribute Member member) {	
		if(token == true){
			token = false;
		}mav =  homeSv.excute(2, member);
		return mav;	
	
	}
	@RequestMapping(value = "/findPWDform", method = RequestMethod.GET)
	public ModelAndView  findPWDform(){		
		return new ModelAndView("home");   // --------------------------
	}
	@RequestMapping(value = "/findPWD", method = RequestMethod.GET)
	public ModelAndView findPWD() {		
		return new ModelAndView("home");	
	
	}
	
	
	@RequestMapping(value = "/storyform", method = RequestMethod.GET)
	public ModelAndView storyform(@ModelAttribute Member member) {		
		mav= homeSv.excute(4, member);
		return mav;
	
	}
	
	@RequestMapping(value = "/serviceform", method = RequestMethod.GET)
	public ModelAndView serviceform(@ModelAttribute Member member) {		
		mav =homeSv.excute(3, member);
		
		return mav;
	
	}
	/*
	@RequestMapping(value = "/mh_form", method = RequestMethod.GET)
	public ModelAndView mh_form() {		
		return new ModelAndView("home");	
	
	}
	*/
	@RequestMapping(value = "/team_manager", method = RequestMethod.GET)
	public ModelAndView team_manager() {		
		return new ModelAndView("home");	
	
	}	
		
	@RequestMapping(value = "/noticeform", method = RequestMethod.GET)
	public ModelAndView noticeform(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(1, notice);		
		return mav;

	}	
	
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public ModelAndView noticeDetail(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(6, notice);
		return mav;
	}
	
	@RequestMapping(value = "/noticeInsertform", method = RequestMethod.GET)
	public ModelAndView noticeInsertform(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(3, notice);
		if(token==true)
			token=false;
		return mav;	
	
	}
	@RequestMapping(value = "/noticeInsert", method = RequestMethod.POST)
	public ModelAndView noticeInsert(@ModelAttribute Notice notice) {		
		if(token==false){
			mav = noticeSv.excute(2, notice);
			token=true;
		}		
		return noticeform(notice);	
	
	}
	
	@RequestMapping(value = "/noticeUpdateform", method = RequestMethod.GET)
	public ModelAndView noticeUpdateform(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(4, notice);
		return mav;		
	
	}
	@RequestMapping(value = "/noticeUpdate", method = RequestMethod.GET)
	public ModelAndView noticeUpdate(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(5, notice);
		return mav;		
	
	}
	//공지 삭제
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.GET)
	public ModelAndView noticeDelete(@ModelAttribute Notice notice) {		
		mav = noticeSv.excute(7, notice);
		return mav;		
	
	}

	@RequestMapping(value = "/questform", method = RequestMethod.GET)
	public ModelAndView questform(@ModelAttribute Quest quest) {	
		mav =  questSv.execute(1, quest);
		return mav;					

	}
	@RequestMapping(value = "/questInsertform", method = RequestMethod.GET)
	public ModelAndView questInsertform(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(2, quest);
		return mav;
	
	}
	
	@RequestMapping(value = "/questInsertsoption", method = RequestMethod.GET)
	public ModelAndView questInsertsoption(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(3, quest);
		return mav;
	
	}
	@RequestMapping(value = "/questInsert", method = RequestMethod.POST)
	public ModelAndView questInsert(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(4, quest);
		return mav;	
	
	}
	@RequestMapping(value = "/questUpdateform", method = RequestMethod.POST)
	public ModelAndView questUpdateform(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(5, quest);
		return mav;
	}
	@RequestMapping(value = "/questUpdate", method = RequestMethod.POST)
	public ModelAndView questUpdate(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(6, quest);
		return mav;
	
	}
	
	@RequestMapping(value = "/questDelete", method = RequestMethod.GET)
	public ModelAndView questDelete(@ModelAttribute Quest quest) {		
		mav =  questSv.execute(7, quest);
		return mav;	
	
	}
	@RequestMapping(value = "/questBClassInsertform", method = RequestMethod.GET)
	public ModelAndView questBClassInsertform(@ModelAttribute BSubClass bSubClass) {		
		mav =  questSv.execute(1, bSubClass);
		return mav;	
	
	}
	@RequestMapping(value = "/questBClassInsert", method = RequestMethod.GET)
	public ModelAndView questBClassInsert(@ModelAttribute BSubClass bSubClass) {		
		mav =  questSv.execute(2, bSubClass);
		return mav;	
	}
	
	@RequestMapping(value = "/QuestBClassUpdateform", method = RequestMethod.GET)
	public ModelAndView QuestBClassUpdateform(@ModelAttribute BSubClass bSubClass) {		
		mav =  questSv.execute(3, bSubClass);
		return mav;	
	}
	
	@RequestMapping(value = "/questBClassDelete", method = RequestMethod.GET)
	public ModelAndView questBClassDelete(@ModelAttribute BSubClass bSubClass) {		
		mav =  questSv.execute(4, bSubClass);
		return mav;	
	}
	
	@RequestMapping(value = "/questBClassUpdate", method = RequestMethod.GET)
	public ModelAndView questBClassUpdate(@ModelAttribute BSubClass bSubClass) {		
		mav =  questSv.execute(5, bSubClass);
		return mav;	
	}
	
	@RequestMapping(value = "/questSClassInsertform", method = RequestMethod.GET)
	public ModelAndView questSClassInsertform(@ModelAttribute SSubClass sSubClass) {		
		mav =  questSv.execute(1, sSubClass);
		return mav;	
	}
	@RequestMapping(value = "/questSClassUpdateform", method = RequestMethod.GET)
	public ModelAndView questSClassUpdateform(@ModelAttribute SSubClass sSubClass) {		
		mav =  questSv.execute(2, sSubClass);
		return mav;	
	}
	@RequestMapping(value = "/questSClassDelete", method = RequestMethod.GET)
	public ModelAndView questSClassDelete(@ModelAttribute SSubClass sSubClass) {		
		mav =  questSv.execute(3, sSubClass);
		return mav;	
	
	}
	@RequestMapping(value = "/questSClassUpdate", method = RequestMethod.GET)
	public ModelAndView questSClassUpdate(@ModelAttribute SSubClass sSubClass) {		
		mav =  questSv.execute(4, sSubClass);
		return mav;	
	}	
	

	@RequestMapping(value = "/noticeDetailform", method = RequestMethod.GET)
	public ModelAndView noticeDetailform() {		
		return new ModelAndView("home");	
	
	}

	
	
	
	
	@RequestMapping(value = "/errorReportInsertform", method = RequestMethod.GET)
	public ModelAndView errorReportInsertform(@ModelAttribute ErrorReport errorReport) {		
		ModelAndView mav = errorReportSv.excute(1, errorReport);		
		return mav;		
	
	}
	
	@RequestMapping(value = "/errorReportInsert", method = RequestMethod.POST)
	public ModelAndView errorReportInsert(@ModelAttribute ErrorReport errorReport) {		
		ModelAndView mav = errorReportSv.excute(2, errorReport);		
		return mav;		

	}
	//에러 리스트
	@RequestMapping(value = "/errorReportform", method = RequestMethod.GET)
	public ModelAndView errorReportform(@ModelAttribute ErrorReport errorReport) {
		ModelAndView mav = errorReportSv.excute(3, errorReport);		
		return mav;	
	
	}
	//에러 상세
	@RequestMapping(value = "/errorReportDetailform", method = RequestMethod.GET)
	public ModelAndView errorReportDetailform(@ModelAttribute ErrorReport errorReport) {		
		ModelAndView mav = errorReportSv.excute(4, errorReport);		
		return mav;	
	
	}
	
	@RequestMapping(value = "/errorReportReplylform", method = RequestMethod.GET)
	public ModelAndView errorReportReplyform(@ModelAttribute ErrorReport errorReport) {		
		ModelAndView mav = errorReportSv.excute(5, errorReport);		
		return mav;	
	
	}	

	@RequestMapping(value = "/errorReportReply", method = RequestMethod.GET)
	public ModelAndView errorReportReply(@ModelAttribute ErrorReport errorReport) {		
		ModelAndView mav = errorReportSv.excute(6, errorReport);		
		return mav;	
	
	}	
	
	
	@RequestMapping(value = "/errorReportDelete", method = RequestMethod.GET)
	public ModelAndView errorReportDelete() {		
		return new ModelAndView("home");	
	
	}
	
	
	

}

