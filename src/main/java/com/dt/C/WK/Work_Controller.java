package com.dt.C.WK;


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

import com.dt.B.PJ.Project;
import com.dt.B.PJ.ProjectSv;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Work_Controller {
	
	@Autowired
	private WorkSv workSv;
	
	@Autowired
	private WKCRSv wkcrsv;
	

	private ModelAndView mav;
	@Autowired
	private ProjectSv pjSv;
	private static boolean token=false; 
	
	private static final Logger logger = LoggerFactory.getLogger(Work_Controller.class);
		
	@RequestMapping(value = "/bworkform", method = RequestMethod.GET)
	public ModelAndView bworkform(@ModelAttribute BWork bwork) {		
		if(token == true){
			token = false;
		}mav = workSv.excute(1, bwork);	
		return mav;
	}
	
	@RequestMapping(value = "/bworkCform", method = RequestMethod.GET)
	public ModelAndView bworkCform(@ModelAttribute BWork bwork) {		
		if(token == true){
			token = false;
		}ModelAndView mav = workSv.excute(8, bwork);	
		return mav;
	}
	
	@RequestMapping(value = "/workCInsert", method = RequestMethod.GET)
	public ModelAndView workCInsert(@ModelAttribute BWork bwork) {		
		if(token == false){
			ModelAndView mav = workSv.excute(9, bwork);
			Project project = new Project(); 
			project.setPj_Code(bwork.getPj_Code());
			mav = pjSv.excute(2, project);
			token = true;
		}else{
			Project project = new Project(); 
			project.setPj_Code(bwork.getPj_Code());
			mav = pjSv.excute(2, project);	
		}			
		return mav;
	}
	
	@RequestMapping(value="/UnConnect" ,method = RequestMethod.GET) 
	public ModelAndView UnConnect(@ModelAttribute BWork bwork) {
		if(token == false){
			mav = workSv.excute(10, bwork);
			Project project = new Project();
			project.setPj_Code(bwork.getPj_Code());
			mav = pjSv.excute(2, project);
			token = true;
		}else{
			Project project = new Project();
			project.setPj_Code(bwork.getPj_Code());
			mav = pjSv.excute(2, project);	
		}		
		return mav;
		
	}

	
	@RequestMapping(value = "/bworkInsertform", method = RequestMethod.GET)
	public ModelAndView bworkInsertform(@ModelAttribute BWork bwork) {		
		if(token == true){
			token = false;
		}mav = workSv.excute(3, bwork);	
		return mav;
	}	
	
	@RequestMapping(value = "/bworkInsert", method = RequestMethod.POST)
	public ModelAndView bworkInsert(@ModelAttribute BWork bwork) {		
		if(token == false){
			mav = workSv.excute(4, bwork);
			token = true;
		}else{
			mav = workSv.excute(1, bwork);	
		}
			
		return mav;
	}	
	
	@RequestMapping(value = "/bworkDetailform", method = RequestMethod.GET)
	public ModelAndView bworkDetailform(@ModelAttribute BWork bwork) {		
		if(token == true){
			token = false;
		}mav = workSv.excute(2, bwork);	
		return mav;
	}
	
	@RequestMapping(value = "/bworkUpdateform", method = RequestMethod.GET)
	public ModelAndView bworkUpdateform(@ModelAttribute BWork bwork) {		
		if(token == true){
			token = false;
		}mav = workSv.excute(5, bwork);	
		return mav;
	}	
	
	@RequestMapping(value = "/bworkUpdate", method = RequestMethod.POST)
	public ModelAndView bworkUpdate(@ModelAttribute BWork bwork) {		
		if(token == false){
			mav = workSv.excute(6, bwork);
			token = true;
		}else{
			mav = workSv.excute(2, bwork);	
		}	
		return mav;
	}
	
	@RequestMapping(value = "/bworkDelete", method = RequestMethod.GET)
	public ModelAndView bworkDelete() {		
		return new ModelAndView("home");
	}	
	
	@RequestMapping(value = "/sworkConnectform", method = RequestMethod.GET)
	public ModelAndView sworkConnectform() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/sworkUnconnectform", method = RequestMethod.GET)
	public ModelAndView sworkUnconnectform() {		
		return new ModelAndView("home");
	}
	// get으로 바꾸면 post가 아니라고 하고 post로 하면 400 뜸			 
	@RequestMapping(value = "/sWorkInsert", method = RequestMethod.POST)
	public ModelAndView sWorkInsert(@ModelAttribute SWork swork) {		
		if(token == false){
			mav = workSv.excute(1, swork);
			token = true;
		}else{
			BWork bwork = new BWork();
			bwork.setBw_Code(swork.getBw_Code());
			mav = workSv.excute(2, bwork);	
		}
				
		return mav;
	}
	@RequestMapping(value = "/sWorkInsertform", method = RequestMethod.GET)
	public ModelAndView sworkInsertform(@ModelAttribute SWork swork) {
		System.out.println("ddd");
		if(token == true){			
			token = false;
		}ModelAndView mav = workSv.excute(2, swork);	
		return mav;
	}
	@RequestMapping(value = "/sWorkDelete", method = RequestMethod.GET)
	public ModelAndView sWorkDelete(@ModelAttribute SWork swork) {		
		System.out.println("컨트롤러");
		if(token == false){
			ModelAndView mav = workSv.excute(3, swork);
			token = true;
		}else{
			BWork bwork = new BWork();
			bwork.setBw_Code(swork.getBw_Code());
			System.out.println(swork.getBw_Code());
			mav = workSv.excute(2, bwork);	
		}
			
		
		return mav;
	}
	
	@RequestMapping(value = "/bworkTcommectInsert", method = RequestMethod.GET)
	public ModelAndView bworkTcommectInsert(@ModelAttribute Comment comment) {		
		mav = wkcrsv.excute(1, comment);
		return mav;
	}
	
	@RequestMapping(value = "/bworkTcommectUpdate", method = RequestMethod.GET)
	public ModelAndView bworkTcommectUpdate(@ModelAttribute Comment comment) {		
		mav = wkcrsv.excute(2, comment);
		return mav;
	}
	
	@RequestMapping(value = "/bworkTcommectDelete", method = RequestMethod.GET)
	public ModelAndView bworkTcommectDelete(@ModelAttribute Comment comment) {		
		mav = wkcrsv.excute(3, comment);
		return mav;
	}
	
	@RequestMapping(value = "/bworkTCommentUpdateForm", method = RequestMethod.GET)
	public ModelAndView bworkTCommentUpdateForm(@ModelAttribute Comment comment) {		
		mav = wkcrsv.excute(4, comment);
		return mav;
	}
	
	@RequestMapping(value = "/bworkTCommentSel", method = RequestMethod.GET)
	public ModelAndView bworkTCommentSel(@ModelAttribute Comment comment) {		
		mav = wkcrsv.excute(5, comment);
		return mav;
	}
	
	@RequestMapping(value = "/bworkTreplyInsert", method = RequestMethod.GET)
	public ModelAndView bworkTreplyInsert() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/bworkTreplyUpdate", method = RequestMethod.GET)
	public ModelAndView bworkTreplyUpdate() {		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/bworkTreplyDelete", method = RequestMethod.GET)
	public ModelAndView bworkTreplyDelete() {		
		return new ModelAndView("home");
	}
}

