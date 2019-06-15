package com.dt.I.AD;



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
public class Addr_Controller {
	@Autowired
	private AddressSv AddressSv;
	private static final Logger logger = LoggerFactory.getLogger(Addr_Controller.class);
		
	
	
	@RequestMapping(value = "/addressform", method = RequestMethod.GET)
	public ModelAndView addressform(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(1, addressBean);	
		return mav;
	}	

	@RequestMapping(value = "/addressSearch", method = RequestMethod.GET)
	public ModelAndView addressSearch(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(2, addressBean);	
		return mav;
	}	
	@RequestMapping(value = "/addressMyInsert", method = RequestMethod.GET)
	public ModelAndView addressMyInsert(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(3, addressBean);	
		return mav;
	}
	
		
	@RequestMapping(value = "/addressInsertAll", method = RequestMethod.POST)
	public ModelAndView addressInsertAll(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(4, addressBean);	
		return mav;
	}	
	@RequestMapping(value = "/addressDelete", method = RequestMethod.GET)
	public ModelAndView addressDelete(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(5, addressBean);	
		return mav;
	}	
	@RequestMapping(value = "/addressAllow", method = RequestMethod.GET)
	public ModelAndView addressAllow(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(6, addressBean);	
		return mav;
	}	
	@RequestMapping(value = "/addressRefuse", method = RequestMethod.GET)
	public ModelAndView addressRefuse(@ModelAttribute AddressBean addressBean) {		
		ModelAndView mav = AddressSv.excute(7, addressBean);	
		return mav;
	}	
	
}

