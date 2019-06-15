package com.dt.F.ME;


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

import com.dt.I.AD.AddressBean;
import com.dt.I.AD.AddressSv;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Memo_Controller {
	
	@Autowired
	private MemoSv memoSv;

	private static final Logger logger = LoggerFactory.getLogger(Memo_Controller.class);
		
	
	@RequestMapping(value = "/memoform", method = RequestMethod.GET)
	public ModelAndView mymemoform(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(1, memobean);	
		return mav;
	}
	@RequestMapping(value = "/memoHamChoice", method = RequestMethod.GET)
	public ModelAndView memoHamChoice(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(2, memobean);	
		return mav;
	}
	@RequestMapping(value = "/memoInsert", method = RequestMethod.GET)
	public ModelAndView mymemoInsertform(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(3, memobean);	
		return mav;
	}
	@RequestMapping(value = "/memoUpdate", method = RequestMethod.GET)
	public ModelAndView memoUpdate(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(4, memobean);	
		return mav;
	}
	@RequestMapping(value = "/memoDelete", method = RequestMethod.GET)
	public ModelAndView memoDelete(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(5, memobean);	
		return mav;
	}
	@RequestMapping(value = "/memoUpdateForm", method = RequestMethod.GET)
	public ModelAndView memoUpdateForm(@ModelAttribute MemoBean memobean) {		
		ModelAndView mav = memoSv.excute(6, memobean);	
		return mav;
	}
	
}

