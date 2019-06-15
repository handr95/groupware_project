package com.dt.J.GC;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.dt.B.PJ.BWork;
import com.dt.B.PJ.Project;
import com.dt.I.AD.AddressBean;

@Controller
public class NoticeSv {

	private ModelAndView mav;

	@Autowired
	private MainDao mainDao;
	@Autowired
	private HttpServletRequest request;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, Notice notice) {
		sessionmid = (String) request.getSession().getAttribute("sessionmid");
		grade1 = (String) request.getSession().getAttribute("grade1");
		sessionteam = (String) request.getSession().getAttribute("sessionteam");
		grade2 = (String) request.getSession().getAttribute("grade2");
		sessionnickname = (String) request.getSession().getAttribute(
				"sessionnickname");

		if (grade1 == null)
			grade1 = "";
		mav = new ModelAndView();
		switch (type) {
		case 1:
			noticeform(notice);
			break;
		case 2:
			noticeInsert(notice);
			break;
		case 3:
			noticeInsertform(notice);
			break;
		case 4:
			noticeUpdateform(notice);
			break;
		case 5:
			noticeUpdate(notice);
			break;
		case 6:
			noticeDetail(notice);
			break;
		case 7:
			noticeDelete(notice);
		default:
			break;
		}
		return mav;
	}

	private ModelAndView noticeform(Notice notice) {
		mav.setViewName("main/notice");
		sessionmid = "hdr@naver.com";
		notice.setNt_memail(sessionmid);
		List<Notice> noticelist = mainDao.noticeform(notice);
		mav.addObject("noticelist", noticeform_HTML(noticelist));
		return mav;

	}

	private String noticeform_HTML(List<Notice> noticelist) {

		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'>");
		sb.append("<table class='table'>");
		// tr style= 'text-align: center
		sb.append("<tr><td><b>No</b></td><td><b>제목</b></td><td><b>작성자</b></td><td><b>등록일</b></td></tr>");
		for (Notice notice : noticelist) {
			if (notice.getNt_Cltype().equals("SN  ")) {
				sb.append("<tr>");
				sb.append("<td><b>공지</b></td>");
				sb.append("<td><b><a href='/noticeDetail?nt_Code="
						+ notice.getNt_Code() + "'>" + notice.getNt_Title()
						+ "</a></b></td>");
				sb.append("<td>" + notice.getNt_memail() + "</td>");
				sb.append("<td>" + notice.getNt_since() + "</td>");
				sb.append("</tr>");
			}
		}
		for (Notice notice : noticelist) {
			if (notice.getNt_Cltype().equals("NN  ")) {
				sb.append("<tr><td>" + notice.getNt_num() + "</td>");
				sb.append("<td><a href='/noticeDetail?nt_Code="
						+ notice.getNt_Code() + "'>" + notice.getNt_Title()
						+ "</a></td>");

				sb.append("<td>" + notice.getNt_memail() + "</td>");
				sb.append("<td>" + notice.getNt_since() + "</td>");
				sb.append("</tr>");
			}
		}
		sb.append("</table>");
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			sb.append("<div style=' text-align:right;'><a href='/noticeInsertform'><input type='button' value='공지사항 등록' class='sgwline4'></a></div>");
		}

		return sb.toString();
	}

	private ModelAndView noticeDetail(Notice notice) {
		mav.setViewName("main/noticeDetail");
		String nt_code = notice.getNt_Code();
		int cnt = nt_code.length();
		for (int i = 0; i < 30 - cnt; i++) {
			nt_code = nt_code + " ";
		}
		System.out.println(nt_code);
		notice.setNt_Code(nt_code);
		List<Notice> noticeDetail = mainDao.noticeDetail(notice);
		mav.addObject("noticeDetail", noticeDetail_HTML(noticeDetail));

		// BWork bwork = new BWork();
		// bwork.setPj_Code(project.getPj_Code());
		// List<BWork> pjBWork = PJDao.pjBWork_View(bwork);
		// mav.addObject("pjBWork", projectBW_HTML(pjBWork));

		return mav;

	}

	private String noticeDetail_HTML(List<Notice> noticeDetail) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table class='table'>");

		for (Notice notice : noticeDetail) {
			sb.append("<a href='/noticeform?nt_Code="
					+ notice.getNt_Code()
					+ "'><input type='button' value='목록보기' class='sgwline2' style='right:90px'></a><br/>");
			sb.append("<tr style= 'text-align: center' class='sgwline1'><td>"
					+ notice.getNt_num() + "</td><td><b>"
					+ notice.getNt_Title() + "</b></td><td>"
					+ notice.getNt_memail() + "</td><td>"
					+ notice.getNt_since() + "</td></tr>");
			sb.append("<tr><td colspan='4' class='sgwline1'><br><br><br><br><br><br><br><br>"
					+ notice.getNt_content()
					+ "</br></br></br></br></br></br></br></br></td></tr>");
			sb.append("<tr><td colspan='8'><a href='/noticeUpdateform?nt_Code="
					+ notice.getNt_Code()
					+ "'>"
					+ "<input type='button' value='수정' class='sgwline3'  style='right:135px'/> </a>"
					+ "<a href='/noticeDelete?nt_Code="
					+ notice.getNt_Code()
					+ "'>"
					+ "<input type='button' value='삭제' class='sgwline3'  style='right:90px'/></a></td></tr>");

		}
		sb.append("</table>");
		return sb.toString();
	}

	private ModelAndView noticeInsert(Notice notice) {
		sessionmid = "이재선@naver.com";
		notice.setNt_memail(sessionmid);
		if (notice.getNt_Cltype() == null) {
			notice.setNt_Cltype("NN  ");
		}
		mainDao.noticeInsert(notice);
		return mav;
	}

	private void noticeInsertform(Notice notice) {
		mav.setViewName("main/noticeInsert");
		mav.addObject("noticeInsert", noticeInsert_HTML(notice));
	}

	private String noticeInsert_HTML(Notice notice) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/noticeInsert' method='post' onsubmit='return noticecheck(this)'>");
		sb.append("<table  style='margin:auto; width:800px;'>");
		sb.append("<tr>");
		sb.append("<td  colspan='2'>제목 : <input type='text' name='nt_Title'/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>내용 :</td><td></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td colspan='2'><textarea rows='8' cols='100' name='nt_content'/></textarea></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td  colspan='2'>공지사항 설정 : <input type='checkbox' name='nt_Cltype' value='SN  '/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td></td><td><input type='submit' value='등록'  class='sgwline3' style='right:310px;'/><td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");
		return sb.toString();
	}

	private ModelAndView noticeUpdateform(Notice notice) {
		mav.setViewName("main/noticeUpdate");
		System.out.println(11 + notice.getNt_Code());
		String nt_code = notice.getNt_Code();
		int cnt = nt_code.length();
		for (int i = 0; i < 30 - cnt; i++) {
			nt_code = nt_code + " ";
		}
		notice.setNt_Code(nt_code);
		List<Notice> noticeDetail = mainDao.noticeDetail(notice);
		mav.addObject("noticeUpdate", noticeUpdateform_HTML(noticeDetail));
		return mav;
	}

	private void noticeUpdate(Notice notice) {
		if (notice.getNt_Cltype() == null) {
			System.out.println("비공개");
			notice.setNt_Cltype("NN  ");
		}
		mainDao.noticeUpdate(notice);
		noticeDetail(notice);
	}

	private String noticeUpdateform_HTML(List<Notice> noticeUpdate) {

		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/noticeUpdate' method='get'>");
		for (Notice notice : noticeUpdate) {
			sb.append("<table  style='margin:auto; width:800px;'>");
			sb.append("<tr>");
			sb.append("<td  colspan='2'>제목 : <input type='text' name='nt_Title' value='"
					+ notice.getNt_Title() + "'/></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td>내용 : </td><td></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='2'><textarea rows='8' cols='100' name='nt_content'/>"
					+ notice.getNt_content() + "</textarea></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			if (notice.getNt_Cltype().equals("SN  ")) {
				sb.append("<td  colspan='2'>공지사항 설정 : <input type='checkbox' name='nt_Cltype' checked='checked' value='SN  '/></br>");

			} else {
				sb.append("<td  colspan='2'>공지사항 설정 : <input type='checkbox' name='nt_Cltype' value='SN  '/></br>");
			}
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<input type='hidden' name='nt_Code' value='"
					+ notice.getNt_Code() + "'/>");

		}
		sb.append("<td></td><td><input type='submit' value='수정'  class='sgwline3' style='right:310px'/><td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");

		return sb.toString();
	}

	private ModelAndView noticeDelete(Notice notice) {
		String nt_code = notice.getNt_Code();
		int cnt = nt_code.length();
		for (int i = 0; i < 30 - cnt; i++) {
			nt_code = nt_code + " ";
		}
		notice.setNt_Code(nt_code);
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			if (mainDao.noticeDelete(notice)) {
				System.out.println(notice.getNt_Code() + 3);
				noticeform(notice);
			}
		} else {
			noticeDetail(notice);
		}
		return mav;
	}

}
