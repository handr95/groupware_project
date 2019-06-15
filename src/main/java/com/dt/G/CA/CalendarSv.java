package com.dt.G.CA;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CalendarSv {
	@Autowired
	private CalendarDAO caDao;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;

	public ModelAndView excute(int type, Calendar calendar) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		switch (type) {
			case 1:
				calview(calendar);
				break;
			case 2:
				calUpdateform(calendar);
				break;
			case 3:
				calUpdate(calendar);
				break;
			case 4:				 
				calInsertform();
				break;
			case 5:			
				calInsert(calendar);
				break;
			case 6:				
				allcal(calendar);
				break;
			case 7:
	
				break;
			case 8:
	
				break;
			default:

		}

		return mav;
	}
	 
	 
	 /*
	 public ModelAndView callist(Calendar calendar){		
		 mav.setViewName("my/myCalendarDate");
		 mav.addObject("callist2", callist2(calendar));		
		 return mav;
	 }
	 
	 
	 public String callist2(Calendar calendar){
		 StringBuffer sb = new StringBuffer();
		 
		 List<Calendar> callist =  caDao.calList(calendar);
		 
		 for(Calendar calendar2:callist){
		 	sb.append("</br>"+calendar2.getC_Title());
		 	sb.append(calendar2.getC_Comment());
		 	sb.append(calendar2.getC_Email());
		 	sb.append(calendar2.getC_Start());
		 	sb.append(calendar2.getC_Limit());
		 	sb.append(calendar2.getC_Loc()+"</br>");
		 }
		 
		 return sb.toString();
	 }
	 */
	 public void calview(Calendar calendar){
		calendar.setCurrent(calendar.getYear()+"/"+calendar.getMonth()+"/"+calendar.getDay());
		//System.out.println(calendar.getCurrent());
		//System.out.println("1"+calendar.getC_Title());
		if(sessionteam.indexOf("@")!=-1){//개인
		mav.setViewName("my/calist");
		//System.out.println("1"+calendar.getC_Title());		
		List<Calendar> callist = caDao.currentCal(calendar);		
		//System.out.println("2"+calendar.getC_Title());
		mav.addObject("currentcal",calview_HTML(callist));
		}else{
			 
		 }
		
	 }
	 
	 public String calview_HTML(List<Calendar> callist){
		 StringBuffer sb = new StringBuffer();
		 
		 sb.append("<table><tr><td>제목</td> <td>내용</td> <td>작성자</td> <td>시작일</td> <td>마감일</td> <td>장소</td> <td>수정</td></tr>");
		 
		 for(Calendar calendar2:callist){
			//System.out.println("3"+calendar2.getC_Title());
		 	sb.append("<tr><td>"+calendar2.getC_Title()+"</td>");
		 	sb.append("<td>"+calendar2.getC_Comment()+"</td>");
		 	sb.append("<td>"+calendar2.getC_Email()+"</td>");
		 	sb.append("<td>"+calendar2.getC_Start()+"</td>");
		 	sb.append("<td>"+calendar2.getC_Limit()+"</td>");
		 	sb.append("<td>"+calendar2.getC_Loc()+"</td>");
		 	sb.append("<td><input type='button' value='수정' onclick=\"calUpdateform('"+calendar2.getC_Code()+"')\"></td></tr>");
		 }
		 sb.append("</table>");
		 return sb.toString();
	 }
	 
	 
	 public void calUpdateform(Calendar calendar){
		 System.out.println(calendar.getC_Code());
		 mav.setViewName("my/myboCommentUpdate");
		 if(sessionteam.indexOf("@")!=-1){//개인
			Calendar calupdate = caDao.currentUpdatesel(calendar);//개인		 
		 	mav.setViewName("my/myboCommentUpdate");		
		 	mav.addObject("calupdate", calUpdateform_HTML(calupdate));
		 }else{
			 
		 }
	 }
	 
	 public String calUpdateform_HTML(Calendar calupdate){
		 StringBuffer sb = new StringBuffer();
		 sb.append("<form action='/calUpdate' method='post'>");
		 sb.append("제목 : <input type='text' name='c_Title' value='"+calupdate.getC_Title()+"'/><br/>");
		 sb.append("내용 : <input type='text' name='c_Comment' value='"+calupdate.getC_Comment()+"'/><br/>");
		 
		 sb.append("시작일 : <input type='text' name='c_Start' value='"+calupdate.getC_Start()+"'/>");
		
		 sb.append("<input type='button' value='달력보기' onClick=\"datePicker(event,'c_Start')\"><br/>");
		 sb.append("마감일 : <input type='text' name='c_Limit' value='"+calupdate.getC_Limit()+"'/>");

		 sb.append("<input type='button' value='달력보기' onClick=\"datePicker(event,'c_Limit')\"><br/>");
		 sb.append("장소 : <input type='text' name='c_Loc' value='"+calupdate.getC_Loc()+"'/><br/>");
		 sb.append("<input type='hidden' name='c_Code' value='"+calupdate.getC_Code()+"'/><br/>");
		 sb.append("<input type='submit' value='수정'/><br/>");
		 return sb.toString();
	 }
	 
	 public void calUpdate(Calendar calendar){
		 System.out.println(calendar.getC_Code());		 
		 
		 if(sessionteam.indexOf("@")!=-1){//개인
			 caDao.currentUpdate(calendar);
			 allcal(calendar);
		 }else{
			 
		 }
		//mav.setViewName("my/myboCommentUpdate");
		//System.out.println("얍"+calendar.getC_Code());
		 		 
	 }
	 
	 public void calInsertform(){
		
		 mav.setViewName("my/calInsertform");
		 if(sessionteam.indexOf("@")!=-1){//개인
		 mav.addObject("calInsertform", calInsertform_HTML());
		 }else{
			 
		 }
	 }
	 
	 public String calInsertform_HTML(){
		 StringBuffer sb = new StringBuffer();
		 //sb.append("<form action='/calInsert' method='post'>");
		 sb.append("제목 : <input type='text' name='c_Title2'/><br/>");
		 sb.append("내용 : <input type='text' name='c_Comment2'/><br/>");
		 
		 sb.append("시작일 : <input type='text' name='c_Start2'/>");
		
		 sb.append("<input type='button' value='달력보기' onClick=\"datePicker(event,'c_Start2')\"><br/>");
		 sb.append("마감일 : <input type='text' name='c_Limit2'/>");

		 sb.append("<input type='button' value='달력보기' onClick=\"datePicker(event,'c_Limit2')\"><br/>");
		 sb.append("장소 : <input type='text' name='c_Loc2'/><br/>");
		 
		 sb.append("<input type='button' onclick=\"calInsert()\" value='일정 등록' />");
		 //sb.append("<input type='submit' value='수정'/><br/>");
		 
		 return sb.toString();
		 }
	 
	 public void calInsert(Calendar calendar){
		System.out.println("sss");
		//mav.setViewName("templte/Demo");
		calendar.setT_Code(sessionteam);
		if(sessionteam.indexOf("@")!=-1){//개인
			caDao.currentInsert(calendar);		
			allcal(calendar);//등록후 캘린더로
		}else{
			allcal(calendar);
		}
	 }
	 
	 
	 public void allcal(Calendar calendar){	
		 calendar.setT_Code(sessionteam);
		 if(sessionteam.indexOf("@")!=-1){//개인
			 
			 List<Calendar> calall =  caDao.allcal(calendar);//개인
			 mav.addObject("ca", allcal_HTML(calall));
			 mav.setViewName("my/myCalendarDate");			 
		 }else{			
			 List<Calendar> calall =  caDao.allteamcal(calendar);//개인		 
			 mav.addObject("ca", allcal_HTML(calall));
			 mav.setViewName("team/calendardate");
				
				
		}
	 }
	 
	 public String allcal_HTML(List<Calendar> calall){
		 StringBuffer sb = new StringBuffer();
		 int cnt = calall.size();
		 int i=1;
		 sb.append("var events = [");
		 for(Calendar calendar : calall){

			 sb.append("{\"EventID\": "+i+", ");
			 sb.append("\"StartDateTime\": \""+calendar.getC_Start()+"\",");
			 sb.append("\"EndDateTime\": \""+calendar.getC_Limit()+"\", ");
			 sb.append("\"Title\": \""+calendar.getC_Title()+"\",");
			 sb.append("\"URL\": \"#\",");
			 sb.append("\"Description\": \""+calendar.getC_Comment()+"\",");
			 sb.append("\"CssClass\": \""+calendar.getC_Loc()+"\" }");
		 	if(i<cnt){
		 	 sb.append(",");
		 	}
		 	i++;
		 }
		 sb.append("];");
		 return sb.toString();
	 }
}
