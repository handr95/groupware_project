package com.dt.J.GC;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.dt.B.PJ.Project;

@Controller
public class ErrorReportSv {

	private ModelAndView mav;
	@Autowired
	private MainDao mainDao;
	@Autowired
	private HttpServletRequest session;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, ErrorReport errorReport) {
		sessionmid = (String) session.getSession().getAttribute("sessionmid");
		grade1 = (String) session.getSession().getAttribute("grade1");
		sessionteam = (String) session.getSession().getAttribute("sessionteam");
		grade2 = (String) session.getSession().getAttribute("grade2");
		sessionnickname = (String) session.getSession().getAttribute(
				"sessionnickname");

		if (grade1 == null)
			grade1 = "";
		mav = new ModelAndView();
		switch (type) {
		case 1:
			errorReport();
			break;
		case 2:
			errorReportInsert(errorReport);
			break;
		case 3:
			errorReportform(errorReport);
			break;
		case 4:
			errorReportDetailform(errorReport);
			break;
		case 5:
			errorReportReplyform(errorReport);
			break;
		case 6:
			errorReportReply(errorReport);
			break;
		default:
			break;

		}
		return mav;
	}

	private void errorReport() {

		mav.setViewName("main/errorReport");
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			mav.addObject("admin", makebuttonhtml());
		}
	}

	private String makebuttonhtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append("<td colspan='5'>");
		sb.append("<input type='button' value='오류신고리스트' onclick=\"location.href='/errorReportform'\">");
		sb.append("</td>");
		sb.append("</tr>");

		return sb.toString();
	}

	private void errorReportInsert(ErrorReport errorReport) {
		if (mainDao.ErrorReportInsert(errorReport)) {
			mav.setViewName("main/main");
		} else {
			mav.setViewName("main/errorReport");
		}

	}

	private void errorReportform(ErrorReport errorReport) {
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			mav.setViewName("main/errorReportList");
			List<ErrorReport> errorReportform = mainDao
					.errorReportform(errorReport);
			mav.addObject("errorReportform", errorReporthtml(errorReportform));
		} else {
			mav.setViewName("main/main");
		}
	}

	private String errorReporthtml(List<ErrorReport> errorReportform) {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'>");
		sb.append("<table class='table'>");
		// sb.append("<table style='margin:auto;'>");
		sb.append("<tr><td><b>NO</b></td><td><b>제목</b></td><td><b>내용</b></td><td><b>작성자</b></td><td><b>등록일</b></td></tr>");
		for (ErrorReport errorReport : errorReportform) {
			sb.append("<tr><td>" + errorReport.getEr_num() + "</td>");
			sb.append("<td><a href='/errorReportDetailform?er_code="
					+ errorReport.getEr_code() + "'>"
					+ errorReport.getEr_title() + "</a></td>");
			sb.append("<td>" + errorReport.getEr_content()
					+ "</td>");
			sb.append("<td>" + errorReport.getEr_name() + "</td>");
			sb.append("<td>" + errorReport.getEr_since() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		return sb.toString();

	}

	private void errorReportDetailform(ErrorReport errorReport) {

		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			mav.setViewName("main/errorReportDetail");

			List<ErrorReport> errorReportDetail = mainDao.errorReportDetail(errorReport);			
			mav.addObject("admin", errorReportDetailhtml(errorReportDetail));			
			mav.addObject("errorReply", errorReportReply_HTML(errorReportDetail));
			
		} else {
			mav.setViewName("main/errorReportDetail");
		}
	}

	private String errorReportDetailhtml(List<ErrorReport> errorReportDetail) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table class='table'>");		
		sb.append("<tr>");	

		for (ErrorReport errorReport : errorReportDetail) {
			sb.append("<a href='/errorReportform?er_code="
					+ errorReport.getEr_code()
					+ "'><input type='button' value='오류신고 목록' onclick=\"location.href='/errorReportDetailform'\" class='sgwline2' style='right:90px'></a><br/>");
			sb.append("<tr style= 'text-align: center' class='sgwline1'><td>"
					+ errorReport.getEr_num() + "</td><td>"
					+ errorReport.getEr_title() + "</td><td>"
					+ errorReport.getEr_email() + "</td><td>"
					+ errorReport.getEr_since() + "</td></tr>");
			sb.append("<tr><td colspan='4' class='sgwline1'><br><br><br><br><br><br><br><br>"
					+ errorReport.getEr_content()
					+ "</br></br></br></br></br></br></br></br></td></tr>");
			sb.append("<tr><td style=padding-left:300px colspan='2'><input type='textarea' name='er_reply' id='er_reply'/>");
			sb.append("<input type='button' value='답변' onclick=\"errorReply('"+errorReport.getEr_code()+"','"+errorReport.getEr_email()+"')\" ></td></tr>");							
		}		
	
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
	
		return sb.toString();
	}
/*
			sb.append("작성자 : "+errorReport.getEr_name()+"<br/>");
			sb.append("E-mail : "+errorReport.getEr_email()+"<br/>");
			sb.append("제목 : "+errorReport.getEr_title()+"<br/>");
			sb.append("내용 : "+errorReport.getEr_content()+"<br/>");
		
			
		}

	*/	
	private void errorReportReplyform(ErrorReport errorReport) {
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			mav.setViewName("main/errorReportReply");
			List<ErrorReport> errorReportReply = mainDao
					.errorReportReplyform(errorReport);
			mav.addObject("errorReportReplyform", errorReportReplyhtml(errorReportReply));
		} else {
			mav.setViewName("main/errorReportList");
		}
	}


	private String errorReportReplyhtml(List<ErrorReport> errorReportReply) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append("<td colspan='5'>");

		for (ErrorReport errorReport : errorReportReply) {
			System.out.println(errorReport.getEr_code());
			sb.append("<input type='button' value='답변' onclick=\"\"><br/>");		
				sb.append("제목 : "+errorReport.getEr_title()+"<br/>");
				sb.append("내용 : "+errorReport.getEr_content()+"<br/>");
				sb.append("답변 : <input type='text' name='er_reply'><br/>");
			

			sb.append("<a href='/errorReportReplyform?er_code="
					+ errorReport.getEr_code()
					+ "'><input type='button' value='답변'></a><br/>");
			sb.append("제목 : " + errorReport.getEr_title() + "<br/>");
			sb.append("내용 : " + errorReport.getEr_content() + "<br/>");
		}
		sb.append("<input type='button' value='답변 리스트' onclick=\"location.href='/errorReportReplyform'\">");
		sb.append("</td>");
		sb.append("</tr>");
		
		return sb.toString();
	}
	

	private void errorReportReply(ErrorReport errorReport) {
		
		System.out.println(errorReport.getEr_code());
		System.out.println(errorReport.getEr_reply());
		
		if (mainDao.errorReportReply(errorReport)) {
			
			System.out.println("211"+errorReport.getEr_code());
			System.out.println("123"+errorReport.getEr_email());
			try {
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setTo(errorReport.getEr_email());
				messageHelper.setText(errorReport.getEr_reply());
				messageHelper.setFrom("handr95@gmail.com");
				messageHelper.setSubject("sgw 답변");	// 메일제목은 생략이 가능하다
				
				mailSender.send(message);
			} catch(Exception e){
				System.out.println(e);
			}			
			List<ErrorReport> reply = mainDao.errorReportDetail(errorReport);
			mav.addObject("errorReply", errorReportReply_HTML(reply));
			mav.setViewName("main/errorReply");		
		} else {
			mav.setViewName("main/errorReportReply");
		}
	}	
	
	
	private String errorReportReply_HTML(List<ErrorReport> reply){
		StringBuffer sb = new StringBuffer();
		
		for(ErrorReport errorReport:reply)
			if(errorReport.getEr_reply()!=null){
				sb.append("<center>");
				sb.append("<tr>");
				sb.append("<td colspan='5'>");
				sb.append("답변 : "+errorReport.getEr_reply());
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</center>");
			}
		
		return sb.toString();
	}
	
	private void errorReportdelete(ErrorReport errorReport) {
		
	}

}
