package com.dt.G.CA;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Calandar_Controller {
	@Autowired
	private CalendarSv calendarSv;
	private ModelAndView mav;
	private static boolean token=false; 
	private static final Logger logger = LoggerFactory.getLogger(Calandar_Controller.class);
		
	
	 
	@RequestMapping(value = "/calendarform", method = RequestMethod.GET)
	public ModelAndView cal2(@ModelAttribute Calendar calndar) {
		if(token == true){
			token = false;
		}
		mav = calendarSv.excute(6,calndar);
		return mav;
	}
	 
	
	@RequestMapping(value = "/calview", method = RequestMethod.POST)
	public ModelAndView cal3(@ModelAttribute Calendar calndar) {
		mav = calendarSv.excute(1,calndar);
		if(token == true){
			token = false;
		}
		return mav;
		
	}
	 	 
	
	@RequestMapping(value = "/calUpdateform", method = RequestMethod.POST)
	public ModelAndView calUpdateform(@ModelAttribute Calendar calndar) {
		if(token == false){
			mav = calendarSv.excute(2,calndar);
			token = true;
		}else{
			mav = calendarSv.excute(6,calndar);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/calUpdate", method = RequestMethod.POST)
	public ModelAndView calUpdate(@ModelAttribute Calendar calndar) {		
		if(token == false){
			mav = calendarSv.excute(3,calndar);
			token = true;
		}else{
			mav = calendarSv.excute(6,calndar);
		}
		
		
		return mav;
	}
	
	@RequestMapping(value = "/calInsertform", method = RequestMethod.GET)
	public ModelAndView calInsertform(@ModelAttribute Calendar calndar) {
		if(token == true){
			token = false;
		}ModelAndView mav = calendarSv.excute(4,calndar);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/calInsert", method = RequestMethod.POST)
	public ModelAndView calInsert(@ModelAttribute Calendar calndar) {
		System.out.println("service");
		if(token == false){
			mav = calendarSv.excute(5,calndar);
			token = true;
		}else{
			mav = calendarSv.excute(6,calndar);
		}		
		return mav;
	}
	
	
	
	

}

