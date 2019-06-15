package com.dt.J.GC;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.dt.B.PJ.Project;

@Controller
public class QuestSv {

	private ModelAndView mav;
	@Autowired
	private MainDao mainDao;
	@Autowired
	private HttpServletRequest session;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;

	public ModelAndView execute(int type, Quest quest) {
		mav = new ModelAndView();
		sessionmid = (String) session.getSession().getAttribute("sessionmid");
		grade1 = (String) session.getSession().getAttribute("grade1");
		if (grade1 == null)
			grade1 = "";
		switch (type) {
		case 1:
			Questform(quest);
			break;
		case 2:
			QuestInsertform(quest);
			break;
		case 3:
			questInsertsoption(quest);
			break;
		case 4:
			QuestInsert(quest);
			break;
		case 5:
			QuestUpdateform(quest);
			break;
		case 6:
			QuestUpdate(quest);
			break;
		case 7:
			QuestDelete(quest);
			break;
		default:
			break;
		}
		return mav;
	}

	public ModelAndView execute(int type, BSubClass bSubClass) {
		switch (type) {

		case 1:
			QuestBClassInsertform(bSubClass);
			break;
		case 2:
			QuestBClassInsert(bSubClass);
			break;
		case 3:
			QuestBClassUpdateform(bSubClass);
			break;
		case 4:
			QuestBClassUpdate(bSubClass);
			break;
		case 5:
			QuestBClassDelete(bSubClass);
			break;

		default:
			break;
		}
		return mav;
	}

	public ModelAndView execute(int type, SSubClass sSubClass) {
		switch (type) {

		case 1:
			QuestSClassInsertform(sSubClass);
			break;
		case 2:
			QuestSClassInsert(sSubClass);
			break;
		case 3:
			QuestSClassUpdateform(sSubClass);
			break;
		case 4:
			QuestSClassUpdate(sSubClass);
			break;
		case 5:
			QuestSClassDelete(sSubClass);
			break;

		default:
			break;
		}
		return mav;
	}

	private void Questform(Quest quest) {
		mav.setViewName("main/faq");
		// 대분류,소분류
		List<Quest> questform = mainDao.questform(quest);
		mav.addObject("questList", QuestListHTML(questform));
		// 소분류,faq
		List<Quest> questdform = mainDao.questdform(quest);
		mav.addObject("questDList", QuestDetailListHTML(questdform));
		// 관리자 등록 버튼
		// grade1="GM  ";
		// if(grade1==null)
		// grade1="";
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			mav.addObject("faqbutton", makebuttonhtml());
		}
	}

	private String makebuttonhtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append("<td colspan='5'>");
		sb.append("<input type='button' value='자주묻는 질문 등록' style='margin-left:880px' onclick=\"location.href='/questInsertform'\">");
		sb.append("</td>");
		sb.append("</tr>");

		return sb.toString();
	}

	private String QuestListHTML(List<Quest> questList) {
		StringBuffer sb = new StringBuffer();
		List<Quest> questbnameList = new ArrayList<Quest>();// 대분류 리스트
		String bsname = "";
		for (Quest quest : questList) {
			if (!(quest.getBsc_name().equals(bsname))) { // bean에 저장된 대분류제목과
															// 같지않다면
				questbnameList.add(quest); // 대분류List에 quest추가
			}
			bsname = quest.getBsc_name();
		}
		for (Quest quest_b : questbnameList) {
			sb.append("<font style='display: inline-block;width:80px;'>"
					+ quest_b.getBsc_name() + "</font>");
			for (Quest quest_s : questList) {
				if (quest_s.getBsc_name().equals(quest_b.getBsc_name()))
					sb.append("<a href='#" + quest_s.getSsc_name()
							+ "' style='width:30px;'>" + quest_s.getSsc_name()
							+ "</a>&nbsp;&nbsp;&nbsp;");
			}
			sb.append("</br>");
		}
		sb.append("</br>");
		sb.append("</br>");
		sb.append("</br>");
		return sb.toString();
	}

	private String QuestDetailListHTML(List<Quest> questDList) {

		StringBuffer sb = new StringBuffer();
		List<Quest> questsnameList = new ArrayList<Quest>();// 소분류 리스트
		String ssname = "";
		for (Quest quest : questDList) {
			if (!(quest.getSsc_name().equals(ssname))) {
				questsnameList.add(quest);
			}
			ssname = quest.getSsc_name();
		}
		int i = 0;
		for (Quest quest_b : questsnameList) {

			sb.append("<div id='" + quest_b.getSsc_name() + "'><h4>"
					+ quest_b.getSsc_name() + "</h4></div>");

			for (Quest quest_s : questDList) {
				if (quest_s.getSsc_name().equals(quest_b.getSsc_name())) {

					if (grade1 == null)
						grade1 = "";
					sb.append("<div class='panel panel-default'>");
					sb.append("<div class='panel-heading'>");
					sb.append("<h4 class='panel-title'>");
					sb.append("<a class='accordion-toggle' data-toggle='collapse' data-parent='#accordion' href='#collapse"
							+ i + "'>");
					if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
						sb.append("&nbsp;&nbsp;"
								+ quest_s.getFaq_title()
								+ "<input type='button' value='수정' onclick=\"articleView('"
								+ quest_s.getFaq_code()
								+ "')\"><input type='button' value='삭제' onclick=\"questDel('"
								+ quest_s.getFaq_code() + "')\"><br/>");
					} else {
						sb.append("&nbsp;&nbsp;" + quest_s.getFaq_title()
								+ "<br/>");
					}
					sb.append("</a>");
					sb.append("</h4>");
					sb.append("</div>");
					sb.append("<div id='collapse" + i
							+ "' class='panel-collapse collapse'>");
					sb.append("<div class='panel-body'>");
					sb.append("&nbsp;&nbsp;&nbsp;&nbsp;"
							+ quest_s.getFaq_content() + "<br/>");
					sb.append("</div>");
					sb.append("</div>");
					sb.append("</div>");
					i++;
				}

			}
		}
		return sb.toString();
	}

	private void QuestInsertform(Quest quest) {
		// grade1="GM  ";
		if (grade1.equals("GM  ") || grade1.equals("SM  ")) {
			List<Quest> questlist = mainDao.questform(quest);
			mav.setViewName("main/FAQInsert");
			mav.addObject("QuestInsert1", QuestInsertHTML1(questlist));
			mav.addObject("QuestInsert2",
					QuestInsertHTML2(questlist, quest.getBsc_name()));
			mav.addObject("QuestInsert3", QuestInsertHTML3());
		} else {
			mav.setViewName("main/main");
		}

	}

	private void questInsertsoption(Quest quest) {
		mav.setViewName("main/sscoption");
		List<Quest> questlist = mainDao.questform(quest);
		mav.addObject("QuestInsert2",
				QuestInsertHTML2(questlist, quest.getBsc_name()));

	}

	private void QuestInsert(Quest quest) {
		if (mainDao.questInsert(quest))
			Questform(quest);
		else
			QuestInsertform(quest);
	}

	private String QuestInsertHTML1(List<Quest> questlist) {
		StringBuffer sb = new StringBuffer();

		sb.append("<form action='/questInsert' name='qinsert' method='post'>");
		sb.append("<select name='bsc_name' onChange='chkSel(this);'>");
		sb.append("<option value=''>대분류 선택</option>");
		String name = "";
		for (Quest quest : questlist) {
			if (!(quest.getBsc_name().equals(name))) {
				sb.append("<option value='" + quest.getBsc_name() + "'>"
						+ quest.getBsc_name() + "</option>");
			}
			name = quest.getBsc_name();
		}
		sb.append("</select>&nbsp;&nbsp;<input type='button' value='대분류명 추가' onclick=''>&nbsp;&nbsp;<input type='button' value='대분류명 수정' onclick=''>&nbsp;&nbsp;<input type='button' value='대분류명 삭제' onclick=''><br/>");

		return sb.toString();

	}

	private String QuestInsertHTML2(List<Quest> questlist, String bsc_name) {
		StringBuffer sb = new StringBuffer();
		List<Quest> questbnameList = new ArrayList<Quest>();// 대분류 리스트
		String name = "";
		if (bsc_name == null)
			bsc_name = "";
		/*
		 * for (Quest quest : questlist) { if
		 * (!(quest.getBsc_name().equals(name))) { questbnameList.add(quest); }
		 * name = quest.getBsc_name(); }
		 */
		// 종류별로 만들어볼까?
		sb.append("<select name='ssc_code' >");
		sb.append("<option value=''>소분류 선택</option>");
		for (Quest quest : questlist) { // 전부 돌지만 대분류가 같아야 되는데.
			if (quest.getBsc_name().equals(bsc_name)) {
				sb.append("<option value='" + quest.getSsc_code() + "'>"
						+ quest.getSsc_name() + "</option>");
			}
		}
		sb.append("</select>&nbsp;&nbsp;<input type='button' value='소분류명 추가' onclick=''>&nbsp;&nbsp;<input type='button' value='소분류명 수정' onclick=''>&nbsp;&nbsp;<input type='button' value='소분류명 삭제' onclick=''>");

		return sb.toString();

	}

	private String QuestInsertHTML3() {
		StringBuffer sb = new StringBuffer();
		sb.append("<table  style='margin:auto; width:100px;'>");
		sb.append("<tr>");
		sb.append("<td  colspan='2'>제목 : <input type='text' name='faq_title'/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>내용 : </td><td></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td colspan='2'><textarea rows='8' cols='100' name='faq_content'></textarea></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td><input type='submit' value='자주묻는 질문 등록' class='sgwline3' style='right:310px'/></td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");
		return sb.toString();

	}

	private void QuestUpdateform(Quest quest) {

		mav.setViewName("main/FAQUpdate");
		System.out.println("dddd");
		Quest questform = mainDao.questdSelectOne(quest);
		mav.addObject("QuestUpdate", QuestUpdateHTML(questform));

	}

	private void QuestUpdate(Quest quest) {
		String faq_code = quest.getFaq_code();
		int cnt = faq_code.length();
		for (int i = 0; i < 30 - cnt; i++) {
			faq_code = faq_code + " ";
		}
		quest.setFaq_code(faq_code);
		mainDao.questUpdate(quest);
		Questform(quest);

	}

	private String QuestUpdateHTML(Quest questform) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/questUpdate' method='post'>");
		sb.append("<input type='hidden' name='faq_code' value='"
				+ questform.getFaq_code() + "'/>");
		sb.append("제목:<input type='text' name='faq_title' value='"
				+ questform.getFaq_title() + "'/></br>");
		sb.append("내용:<input type='text' name='faq_content' value='"
				+ questform.getFaq_content() + "'/></br>");
		sb.append("<input type='submit' value='자주묻는 질문 수정'/></form>");
		return sb.toString();
	}

	private void QuestDelete(Quest quest) {
		String faq_code = quest.getFaq_code();
		int cnt = faq_code.length();
		for (int i = 0; i < 30 - cnt; i++) {
			faq_code = faq_code + " ";
		}
		quest.setFaq_code(faq_code);
		if (mainDao.questDelete(quest))
			Questform(quest);
		mav.setViewName("main/FAQUpdate");
	}

	private ModelAndView QuestBClassInsertform(BSubClass bSubClass) {
		return mav;

	}

	private ModelAndView QuestBClassInsert(BSubClass bSubClass) {
		return mav;

	}

	private ModelAndView QuestBClassUpdateform(BSubClass bSubClass) {
		return mav;

	}

	private ModelAndView QuestBClassDelete(BSubClass bSubClass) {
		return mav;

	}

	private ModelAndView QuestBClassUpdate(BSubClass bSubClass) {
		return mav;

	}

	private ModelAndView QuestSClassInsertform(SSubClass sSubClass) {
		return mav;

	}

	private ModelAndView QuestSClassInsert(SSubClass sSubClass) {
		return mav;

	}

	private ModelAndView QuestSClassUpdateform(SSubClass sSubClass) {
		return mav;

	}

	private ModelAndView QuestSClassDelete(SSubClass sSubClass) {
		return mav;

	}

	private ModelAndView QuestSClassUpdate(SSubClass sSubClass) {
		return mav;

	}

	private ModelAndView errorReportInsert(ErrorReport errorReport) {
		return mav;

	}

	private ModelAndView errorReportform(ErrorReport errorReport) {
		return mav;

	}

	private ModelAndView errorReportDetailform(ErrorReport errorReport) {
		return mav;

	}

	private ModelAndView errorReportDelete(ErrorReport errorReport) {
		return mav;

	}
}
