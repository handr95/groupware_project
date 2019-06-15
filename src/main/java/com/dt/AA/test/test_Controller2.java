package com.dt.AA.test;

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
public class test_Controller2 {
	
	private static final Logger logger = LoggerFactory.getLogger(test_Controller2.class);
	@Autowired
	private sessionSV1 sessionsv1;
	@Autowired
	private sessionSV2 sessionsv2;
	private ModelAndView mav;

	@RequestMapping(value = "/testSession2", method = RequestMethod.GET)
	public ModelAndView testSession2(@ModelAttribute SessionTestBean sessionbean) {	
		mav = sessionsv2.excute(1, sessionbean);
		return mav;
	}
	
	
}

