package com.dt.M.SM;

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
public class ServiceMng_Controller {

	private static final Logger logger = LoggerFactory.getLogger(ServiceMng_Controller.class);

	@Autowired
	private AlarmMgrSv alramMgrSv;
	
	@Autowired
	private LogOutMgrSv logoutMgrSv;
	
	@RequestMapping(value = "/alramMgr_View", method = RequestMethod.GET)
	public ModelAndView alramMgr_View(@ModelAttribute SM_Member sm_member) {
		ModelAndView mav = alramMgrSv.excute(1, sm_member);
		return mav;
	}
	
	@RequestMapping(value = "/alramMgrUpdate", method = RequestMethod.GET)
	public ModelAndView alramMgrUpdate() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/logOutOption", method = RequestMethod.GET)
	public ModelAndView logOutOption(@ModelAttribute SM_Member sm_member) {
		ModelAndView mav = logoutMgrSv.excute(1, sm_member);
		return mav;
	}
	
	@RequestMapping(value = "/logOutTimeSet", method = RequestMethod.GET)
	public ModelAndView logOutTimeSet() {
		return new ModelAndView("home");
	}

}
