 package com.dt.B.PJ;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dt.N.TI.Team;
import com.dt.N.TI.TeamInfoDao;

@Service
public class ProjectSv {
	
	@Autowired
	private ProjectDao PJDao;
	
	@Autowired
	private PJCRDao PJCRDao;
	
	@Autowired
	private TeamInfoDao teminfoDao;
	
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;	
	
	public ModelAndView excute(int type, Project project){	
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav=new ModelAndView();
		switch(type){
			case 1:
				System.out.println(sessionmid+"야호"+sessionteam);
				projectList(project);
				break;
			case 2:
				projectDetail(project);
				break;
			case 3:
				projectInsertform(project);
				break;
			case 4:
				projectInsert(project);
				break;
			case 5:
				projectUpdateform(project);
				break;
			case 6:
				projectUpdate(project);
				break;
			default:
				break;
		}
		return mav;
	}


	private void projectList(Project project){
		//sessionmid="ljs@naver.com";	
		System.out.println(" 리스트");
		mav.setViewName("team/project");
		String code = sessionteam;
		int cnt =  code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		project.setT_Code(code);
		List<Project> projectList = PJDao.projectList(project); 
		mav.addObject("projectList", projectList_HTML(projectList));
	}
	
	private String projectList_HTML(List<Project> projectlist){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'>");
		sb.append("<table class='table'>");
		sb.append("<tr><td>상태</td><td>책임자</td><td>프로젝트명</td><td>시작일</td><td>기한일</td></tr>");
		for (Project project : projectlist){
			sb.append("<tr>");
			sb.append("<td>");
			if(project.getPj_Progress().equals("SB  ")){
				sb.append("대기");
			}else if(project.getPj_Progress().equals("PG  ")){
				sb.append("진행");
			}else if(project.getPj_Progress().equals("CP  ")){
				sb.append("완료");
			}
			sb.append("</td>");
			sb.append("<td>"+project.getPj_Owner()+"</td>");
			sb.append("<td><a href='/projectDetailform?pj_Code="
			+project.getPj_Code()+"'>"
			+project.getPj_Title()+"</a></td>");
			sb.append("<td>"+project.getPj_Start()+"</td>");
			sb.append("<td>"+project.getPj_Limit()+"</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("<a href='/projectInsertform'><input type='button' value='프로젝트 등록'></a>");
		return sb.toString();
	}	
	
	//댓글 추가중
	private void projectDetail(Project project){
		//sessionmid="ljs@naver.com";	
		System.out.println("Sv1"+project.getPj_Code());
		mav = new ModelAndView();
		mav.setViewName("team/projectDetail");	
		List<Project> projectDetail = PJDao.projectDetail_View(project);
		mav.addObject("projectDetail", projectDetail_HTML(projectDetail));

		BWork bwork = new BWork();
		bwork.setPj_Code(project.getPj_Code());
		List<BWork> pjBWork  = PJDao.pjBWork_View(bwork);
		mav.addObject("pjrate", projectPJrate_HTML(pjBWork, project.getPj_Code()));
		mav.addObject("pjBWork", projectBW_HTML(pjBWork,project.getPj_Code()));
		//댓글
		mav.addObject("pjcoment", pjComment_HTML(project));
		
	}
	
	private String projectDetail_HTML(List<Project> projectDetail){
		StringBuffer sb = new StringBuffer();
		sb.append("<table style = 'margin-left : 300px;'>");
		sb.append("<input type='hidden' id='m_Menu' value='"+projectDetail.get(0).getPj_Code()+"'>");//프로젝트코드
		for (Project project : projectDetail){				
			sb.append("상태 : ");					
			if(project.getPj_Progress().equals("SB  ")){
				sb.append("대기");
			}else if(project.getPj_Progress().equals("PG  ")){
				sb.append("진행");
			}else if(project.getPj_Progress().equals("CP  ")){
				sb.append("완료");
			}
			sb.append("<br/>");
			sb.append("프로젝트명 : "+project.getPj_Title()+"<br/>");
			sb.append("등록자 : "+project.getPj_Email()+"<br/>");
			sb.append("책임자 : "+project.getPj_Owner()+"<br/>");
			sb.append("기한일 : "+project.getPj_Start()+"~"+project.getPj_Limit()+"<br/>");
			sb.append("프로젝트 설명 : "+project.getPj_Content()+"<br/>");
		}
		sb.append("</table>");
		return sb.toString();
	}
	
	private String projectBW_HTML(List<BWork> pjBWork, String pj_Code){
		StringBuffer sb = new StringBuffer();
		sb.append("<form name='worklist'>");
		sb.append("<table class='table table-bordered'>");
		sb.append("<tr><td>선택</td><td>작업상태</td><td>작업제목</td><td>담당자</td>"
				+ "<td>시작일</td><td>기한일</td><td>완료일</td></tr>");
		sb.append("<input type='hidden' name='pj_Code' value='"+pj_Code+"'>");
		for(int index=0; index<pjBWork.size(); index++){
			sb.append("<tr><td><input type='radio' name='bw_Code' value='"+pjBWork.get(index).getBw_Code()+"'></td>");
			sb.append("<td><input type='button' value='");			
			if(pjBWork.get(index).getBw_Progress().equals("SB  ")){
				sb.append("대기");
			}else if(pjBWork.get(index).getBw_Progress().equals("PG  ")){
				sb.append("진행");
			}else if(pjBWork.get(index).getBw_Progress().equals("CP  ")){
				sb.append("완료");
			}
			sb.append("'></td>");
			sb.append("<td>"+pjBWork.get(index).getBw_Title()+"</td>");
			sb.append("<td>"+pjBWork.get(index).getBw_Email()+"</td>");
			sb.append("<td>"+pjBWork.get(index).getBw_Start()+"</td>");
			sb.append("<td>"+pjBWork.get(index).getBw_Limit()+"</td>");
			sb.append("<td>"+pjBWork.get(index).getBw_Final()+"</td></tr>");
			
		}
		sb.append("</table>");
		sb.append("</form>");
		sb.append("<table style = 'margin-left : 300px;' >");
		sb.append("<tr><td colspan='7'></td></tr>");		
		sb.append("<tr><td><a href='/bworkInsertform?pj_Code="+pj_Code+"'><input type='button' value='업무 등록'><a/></td>"
				+ "<td colspan='3'></td>"
				+ "<td> </td>"
				+ "<td><a href='/bworkCform?pj_Code="+pj_Code+"'><input type='button' value='업무 연결'></td>"
				+ "<td><input type='button' value='업무 해제' onclick='workUn()'></td><tr>");
		sb.append("</table>");
		return sb.toString();
	}
	private String projectPJrate_HTML(List<BWork> pjBWork, String pj_Code){
		StringBuffer sb = new StringBuffer();
		int cnt =0;
		int total =pjBWork.size();
		int rate = 0;
		if(total==0){
			rate=0;
		}else{
			for(int i=0;i<total;i++){
				if(pjBWork.get(i).getBw_Progress().equals("CP  ")){
					cnt++;
				}
			}
			rate = cnt/total;
		}
		 System.out.println(rate);
		 sb.append("진행률 : "+rate+"%");
		 sb.append("<div><a href='/projectUpdateform?pj_Code="
					+pj_Code+"'><input type='button' value='프로젝트 수정'></a><input type='button' value='프로젝트 삭제'></div>");
		return sb.toString();
	}
		
	
	
	
	private String projectCM_View(List<Comment> comment){
		StringBuffer sb = new StringBuffer();
		for(int index=0; index<comment.size(); index++){
			sb.append(comment.get(index).getCm_Comment());
			sb.append(comment.get(index).getCm_Witter());
			sb.append(comment.get(index).getCm_Since());
		}		
		return sb.toString();
	}

	private String projectRE_View(List<Reply> reply){
		StringBuffer sb = new StringBuffer();
		for(int index=0; index<reply.size(); index++){
			sb.append(reply.get(index).getR_Comment());
			sb.append(reply.get(index).getR_Witter());
			sb.append(reply.get(index).getR_Since());
		}
		
		return sb.toString();
	}
	
	
	
	private void projectInsertform(Project project){
		//sessionmid="ljs@naver.com";	
		mav.setViewName("team/projectInsert");			
		mav.addObject("projectInsert", projectInsert_HTML());
	}
	
	private String projectInsert_HTML(){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		team.setT_code(sessionteam);
		List<Team> teammemberList = teminfoDao.teammemberList(team);
		
		sb.append("<form action='/projectInsert' method='post'>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>제목 : <input type='text'  name='pj_Title'/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>책임자 : <input type='text'  name='pj_Owner'/>");
		sb.append("<select onChange='chkSel(this);'>");
		sb.append("<option value=''>팀원</option>");
		
		for(Team t:teammemberList){		
		sb.append("<option value='"+t.getTm_memail()+"'>"+t.getTm_mnickname()+"</option>");
		}
		sb.append("</select>");
		sb.append("</td></tr>");
		sb.append("<tr>");
		sb.append("<td>기한일 : <input type='text'  name='pj_Start'/> <input type='button' value='달력보기' onClick=\"datePicker(event,'pj_Start')\">"
				+ " - <input type='text' name='pj_Limit'/><input type='button' value='달력보기' onClick=\"datePicker(event,'pj_Limit')\"></tr></td>");
		sb.append("<tr><td>설명 : <input type='textarea'  name='pj_Content'/></br>");
		sb.append("<input type='submit' value='프로젝트 등록'/></tr></td></form>");
		sb.append("</table>");
		return sb.toString();
	}
	
	private void projectInsert(Project project){
		//sessionmid="ljs@naver.com";
		project.setPj_Email(sessionmid);
		project.setT_Code(sessionteam);
		PJDao.projectInsert(project);
		projectList(project);
		
	}	
	
	private void projectUpdateform(Project project){		
		mav.setViewName("team/projectUpdate");			
		List<Project> projectDetail = PJDao.projectDetail_View(project);
		mav.addObject("projectUpdate", projectUpdate_HTML(projectDetail));
	}
	
	
	private String projectUpdate_HTML(List<Project> projectDetail){
		StringBuffer sb = new StringBuffer();
		Team team = new Team();
		team.setT_code(sessionteam);
		List<Team> teammemberList = teminfoDao.teammemberList(team);
		sb.append("<form action='/projectUpdate' method='post'>");
		for (Project project : projectDetail){
			sb.append("제목 : <input type='text' class='form-control' name='pj_Title' value='"+project.getPj_Title()+"'/></br>");
			sb.append("책임자 : <input type='text' class='form-control' name='pj_Owner' value='"+project.getPj_Owner()+"'/>");
			sb.append("<select onChange='chkSel(this);'>");
			sb.append("<option value=''>팀원</option>");
			for(Team t:teammemberList){
			sb.append("<option value='"+t.getTm_memail()+"'");
			if(t.getTm_memail().equals(project.getPj_Owner())){
				sb.append("selected='selected'");
			}
			sb.append(">"+t.getTm_mnickname()+"</option>");
			}
			sb.append("</select></br>");
			sb.append("기한일 : <input type='text' class='form-control' name='pj_Start' value='"+project.getPj_Start()+"'/> <input type='button' value='달력보기' onClick=\"datePicker(event,'pj_Start')\">"
					+ " - <input type='text' class='form-control' name='pj_Limit' value='"+project.getPj_Limit()+"'/><input type='button' value='달력보기' onClick=\"datePicker(event,'pj_Limit')\"></br>");
			sb.append("설명 : <input type='text' class='form-control' name='pj_Content' value='"+project.getPj_Content()+"'/></br>");
			sb.append("<input type='hidden' name='pj_Code' value='"+project.getPj_Code()+"'/></br>");
			sb.append("<input type='submit' value='프로젝트 수정'/>");
		}
		sb.append("</form>");

		return sb.toString();
	}
	
	
	private void projectUpdate(Project project){		
		//sessionmid="ljs@naver.com";	
		PJDao.projectUpdate(project);
		projectDetail(project);
	}
		
	private void projectDelete(Project project){
		//sessionmid="ljs@naver.com";	
		PJDao.projectDelete(project);
		mav.setViewName("team/project");
	}
	
	
	
	public ModelAndView excute(int type, BWork bwork){
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

		switch(type){
			case 1:
				bworkConnectform(bwork);
				break;
			case 2:
				bworkConnect(bwork);
				break;
			case 3:
				bworkUnconnectform(bwork);
				break;
			case 4:
				bworkInsert(bwork);
				break;
			default:
				break;
		}
		return mav;
	}
	
	private void bworkConnectform(BWork bwork){
			
	}
	private void bworkConnect(BWork bwork){
		
	}
	private void bworkUnconnectform(BWork bwork){
		
	}
	private void bworkInsert(BWork bwork){
		
	}
	
	private String pjComment_HTML(Project project){
		StringBuffer sb = new StringBuffer();
		Comment comment = new Comment();
		String code = project.getPj_Code();//프로젝트코드 
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setM_Menu(code);//프로젝트코드 입력
		System.out.println("dd"+code);
		System.out.println(comment.getM_Menu());
		List<Comment> commentlist = new ArrayList<Comment>(); 	
		commentlist = PJCRDao.commentSelect(comment);
		int i = 1;		
		for(Comment comm:commentlist){					
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				sb.append("<a href='#' onclick=\"pjcommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"pjcommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}
		}		
		return sb.toString();
	}

}
