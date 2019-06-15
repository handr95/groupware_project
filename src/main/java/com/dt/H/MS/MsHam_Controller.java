package com.dt.H.MS;




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
public class MsHam_Controller {
	private static boolean token=false; 
	
	@Autowired
	 private MessageSv messageSv;
	private ModelAndView mav; 
	private static final Logger logger = LoggerFactory.getLogger(MsHam_Controller.class);
		
	@RequestMapping(value = "/messageSendform", method = RequestMethod.GET)
	public ModelAndView messageSendform(@ModelAttribute Message message) {		
		if(token == true){
			token = false;
		}mav = messageSv.excute(1, message);	
		return mav;
	}	
	
	@RequestMapping(value = "/messageInsert")
	public ModelAndView messageInsert(@ModelAttribute Message message) {		
		if(token == false){
			mav = messageSv.excute(2, message);
			token = true;
		}else{
			mav = messageSv.excute(1, message);
		}
		return mav;
	}	
	
	@RequestMapping(value = "/messageDelete")
	public ModelAndView messageDelete(@ModelAttribute Message message) {		
		if(token == false){
			mav = messageSv.excute(3, message);
			token = true;
		}else{
			mav = messageSv.excute(4, message);
		}
			
		return mav;
	}	
	
	@RequestMapping(value = "/messageReciveform")
	public ModelAndView messageReciveform(@ModelAttribute Message message) {		
		if(token == true){
			token = false;
		}mav = messageSv.excute(4, message);	
		return mav;
	}
	
	@RequestMapping(value = "/messageAnswer", method = RequestMethod.POST)
	public ModelAndView messageAnswer(@ModelAttribute Message message) {
		if(token == false){
			mav = messageSv.excute(5, message);
			token = true;
		}else{
			mav = messageSv.excute(4, message);
		}		
		return mav;
	}

}

