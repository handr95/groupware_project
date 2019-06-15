package com.dt.D.DC;

import java.io.File;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class DataComm_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(DataComm_Controller.class);
	
	@Autowired
	private DataCommSv dataCommSv;
	//자료실테이블을 사용한 서비스
	
	@Autowired
	private DCCRSv DCCRSv;
	//댓글답글 테이블을 사용한 서비스
	
	@RequestMapping(value = "/dataCommList", method = RequestMethod.GET)
	public ModelAndView dataCommform(@ModelAttribute DataComm dataComm) {		
		ModelAndView mav = dataCommSv.excute(1, dataComm);
		return mav;
	}	//자료실 첫 페이지
	
	@RequestMapping(value = "/dataInsertform", method = RequestMethod.GET)
	public ModelAndView dataInsertform(@ModelAttribute DataComm dataComm) {		
		ModelAndView mav = dataCommSv.excute(2, dataComm);
		return mav;
	}	//자료실 등록 페이지
	
//	@RequestMapping(value = "/dataInsert", method = RequestMethod.GET)
//	public ModelAndView dataInsert(@ModelAttribute DataComm dataComm) {		
//		ModelAndView mav = dataCommSv.excute(3, dataComm);
//		return mav;
//	}	자료실 등록
	
	@RequestMapping(value = "/dataDetail", method = RequestMethod.GET)
	public ModelAndView dataDetail(@ModelAttribute DataComm dataComm) {
		ModelAndView mav = dataCommSv.excute(4, dataComm);
		return mav;
	}	//자료실 글 클릭실 보이는것
	
	@RequestMapping(value = "/dataUpdateform", method = RequestMethod.GET)
	public ModelAndView dataUpdateform(@ModelAttribute DataComm dataComm) {		
		ModelAndView mav = dataCommSv.excute(5, dataComm);
		return mav;
	}	//현재 글의 정보가 들어간 수정 페이지로 이동
	
	@RequestMapping(value = "/dataUpdate", method = RequestMethod.POST)
	public ModelAndView dataUpdate(@ModelAttribute DataComm dataComm) {		
		ModelAndView mav = dataCommSv.excute(6, dataComm);
		return mav;
	}	
	
	@RequestMapping(value = "/dataAddAfter", method = RequestMethod.POST)
	public ModelAndView dataAddAfter(@ModelAttribute DataComm dataComm,MultipartHttpServletRequest mRequest) {
		ModelAndView mav = dataCommSv.excute(1, dataComm, mRequest);
		return mav;
	}
	
	@RequestMapping(value = "/dataDelete", method = RequestMethod.GET)
	public ModelAndView dataDelete(@ModelAttribute DataComm dataComm) {		
		ModelAndView mav = dataCommSv.excute(7, dataComm);
		return mav;
	}
	
	@RequestMapping(value = "/dataCommentInsert", method = RequestMethod.GET)
	public ModelAndView dataCommentInsert(@ModelAttribute Comment comment) {		
		ModelAndView mav = DCCRSv.excute(1, comment);
		return mav;
	}	
	
	@RequestMapping(value = "/dataCommentUpdate", method = RequestMethod.GET)
	public ModelAndView dataCommentUpdate(@ModelAttribute Comment comment) {		
		ModelAndView mav = DCCRSv.excute(2, comment);
		return mav;
	}	
	
	@RequestMapping(value = "/dataCommentDelete", method = RequestMethod.GET)
	public ModelAndView dataCommentDelete(@ModelAttribute Comment comment) {		
		ModelAndView mav = DCCRSv.excute(3, comment);
		return mav;
	}	
	
	@RequestMapping(value="/dataDownload", method=RequestMethod.GET)
    public ModelAndView download(@ModelAttribute DataComm dataComm) {
        String realFolder = "D:/java/workspace/sgw/src/main/webapp/resources/upload";
       ModelAndView mav = new ModelAndView();
       mav.addObject("fileName", new File(realFolder + dataComm.getD_Path()));
       mav.setViewName("dataDownloadView");
       return mav;
    }
	
	/*
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	 public String fileUpload(Model model, MultipartRequest multipartRequest) throws IOException{
	  MultipartFile file = multipartRequest.getFile("upload");   //뷰에서 form으로 넘어올 때 name에 적어준 이름입니다.
	  Calendar cal = Calendar.getInstance();
	  String fileName = file.getOriginalFilename();
	  String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
	  String replaceName = cal.getTimeInMillis() + fileType;  //파일 이름의 중복을 막기 위해서 이름을 재설정합니다.
	  
	  String path = "C:/Users/Snow/Desktop/upload";   //제 바탕화면의 upload 폴더라는 경로입니다. 자신의 경로를 쓰세요.
	  FileUpload.fileUpload(file, path, replaceName);
	  return "redirect:/";
	 }
	*/

}

