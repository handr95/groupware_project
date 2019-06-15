package com.dt.C.WK;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dt.N.TI.Team;
import com.dt.N.TI.TeamInfoDao;

@Service
public class WorkSv {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletRequest session;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	@Autowired
	private WorkDao workDao;
	@Autowired
	private WKCRDao WKCRDao;
	@Autowired
	private TeamInfoDao teminfoDao;
	
	public ModelAndView excute(int type, BWork bwork){
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav = new ModelAndView();
		mav = new ModelAndView();
		switch(type){
			case 1:
				workList(bwork);
				break;
			case 2:
				workDetail(bwork);
				break;
			case 3:
				workInsertform(bwork);
				break;
			case 4:
				workInsert(bwork);
				break;
			case 5:
				workUpdateform(bwork);
				break;
			case 6:
				workUpdate(bwork);
				break;
			case 7:
				workDelete(bwork);
				break;
			case 8: 
				workCList(bwork);
				break;
			case 9:
				workCInsert(bwork);
				break;
			case 10:
				UnConnect(bwork);
				break;
			default:
				break;
		}
		return mav;
	}
	
	private void workDelete(BWork bwork) {
		
	}

	public ModelAndView excute(int type, SWork swork){		
		//sessionmid="ljs@naver.com";	
		switch(type){
			case 1:
				sWorkInsert(swork);
				break;
			case 2:
				sWorkInsertform(swork);
				break;
			case 3:
				sWorkDelete(swork);
				break;
			default:
				
		}
		return mav;
	}
	
	

	private void workList(BWork bwork){
		
		mav.setViewName("team/work");
		bwork.setT_Code(sessionteam);
		List<BWork> workList = workDao.workList(bwork); 
		mav.addObject("workList", workList_HTML(workList));
		
	}
	
	private String workList_HTML(List<BWork> worklist){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='table-responsive'>");
		sb.append("<table class='table'>");
		sb.append("<tr><td>상태</td><td>책임자</td><td>업무명</td><td>시작일</td><td>기한일</td></tr>");
		for (BWork bwork : worklist){
			if(!bwork.getBw_Progress().equals("NP  ")){			
				sb.append("<tr><td>");		
				if(bwork.getBw_Progress().equals("SB  ")){
					sb.append("대기");
				}else if(bwork.getBw_Progress().equals("PG  ")){
					sb.append("진행");
				}else if(bwork.getBw_Progress().equals("CP  ")){
					sb.append("완료");
				}else if(bwork.getBw_Progress().equals("SP  ")){
					sb.append("공개");
				}else if(bwork.getBw_Progress().equals("NP  ")){
					sb.append("비공개");
				}
				sb.append("</td>");
				sb.append("<td>"+bwork.getBw_Owner()+"</td>");
				sb.append("<td><a href='/bworkDetailform?bw_Code="
				+bwork.getBw_Code()+"'>"
				+bwork.getBw_Title()+"</a></td>");
				sb.append("<td>"+bwork.getBw_Start()+"</td>");
				sb.append("<td>"+bwork.getBw_Limit()+"</td>");
				sb.append("</tr>");
			}else{
				if(bwork.getBw_Owner().equals(sessionmid)){
					sb.append("<tr><td>");		
					if(bwork.getBw_Progress().equals("SB  ")){
						sb.append("대기");
					}else if(bwork.getBw_Progress().equals("PG  ")){
						sb.append("진행");
					}else if(bwork.getBw_Progress().equals("CP  ")){
						sb.append("완료");
					}else if(bwork.getBw_Progress().equals("SP  ")){
						sb.append("공개");
					}else if(bwork.getBw_Progress().equals("NP  ")){
						sb.append("비공개");
					}
					sb.append("</td>");
					sb.append("<td>"+bwork.getBw_Owner()+"</td>");
					sb.append("<td><a href='/bworkDetailform?bw_Code="
					+bwork.getBw_Code()+"'>"
					+bwork.getBw_Title()+"</a></td>");
					sb.append("<td>"+bwork.getBw_Start()+"</td>");
					sb.append("<td>"+bwork.getBw_Limit()+"</td>");
					sb.append("</tr>");
				}
			}
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("<a href='/bworkInsertform'><input type='button' value='업무 등록'></a>");
		return sb.toString();
	}
	
	private void workCList(BWork bwork){
		mav.setViewName("team/workC");
		List<BWork> workCList = workDao.workcList(bwork); 
		mav.addObject("workCList", workCList_HTML(workCList, bwork.getPj_Code()));
	}

	private void workCInsert(BWork bwork) {
		System.out.println(bwork.getBw_Code());
		String bw_Code=bwork.getBw_Code();
		int cnt=bw_Code.length();
		for(int i=0; i<30-cnt; i++) {
			bw_Code= bw_Code+" ";
		}
		bwork.setBw_Code(bw_Code);
		workDao.workCInsert(bwork);
		
	}
	
	private String workCList_HTML(List<BWork> workCList, String pj_Code) {
		StringBuffer sb = new StringBuffer();
		//sessionteam ="T20150122151932               ";
		
		for (BWork bwork : workCList){
			if(bwork.getBw_Progress().equals("SB  ")) {
			sb.append("<form action='/workCInsert' method='get'>");
			sb.append("<table>");
			sb.append("<tr><td>상태</td><td>책임자</td><td>업무명</td><td>시작일</td><td>기한일</td></tr>");
			sb.append("<tr><td>");		
			if(bwork.getBw_Progress().equals("SB  ")){
				sb.append("대기");
			}else if(bwork.getBw_Progress().equals("PG  ")){
				sb.append("진행");
			}else if(bwork.getBw_Progress().equals("CP  ")){
				sb.append("완료");
			}else if(bwork.getBw_Progress().equals("SP  ")){
				sb.append("공개");
			}else if(bwork.getBw_Progress().equals("NP  ")){
				sb.append("비공개");
			}
			sb.append("</td>");
			sb.append("<td>"+bwork.getBw_Owner()+"</td>");
			sb.append("<td><a href='/bworkDetailform?bw_Code="
			+bwork.getBw_Code()+"'>"
			+bwork.getBw_Title()+"</a></td>");
			sb.append("<td>"+bwork.getBw_Start()+"</td>");
			sb.append("<td>"+bwork.getBw_Limit()+"</td>");
			sb.append("<td><input type='button' value='업무 연결하기' onclick=\"location.href='/workCInsert?pj_Code="+pj_Code+"&bw_Code="
			+bwork.getBw_Code()+"'\"></td>");
			sb.append("</tr>");
			}
		}
		sb.append("</table></form>");
		return sb.toString();
	}

	private void workDetail(BWork bwork){
		//sessionmid="ljs@naver.com";	
		mav.setViewName("team/workDetail");	
		
		List<BWork> workDetail = workDao.workDetail_View(bwork);
		mav.addObject("workDetail", workDetail_HTML(workDetail));
		
		//System.out.println(bwork.getBw_Title());
		SWork swork = new SWork();
		swork.setBw_Code(bwork.getBw_Code());
		List<SWork> wkSWork  = workDao.wkSWork_View(swork);
		System.out.println("Detail"+bwork.getBw_Title());
		mav.addObject("wkSWork", workSW_HTML(wkSWork, bwork.getBw_Code()));			
		//댓글추가
		mav.addObject("bwcoment", bwComment_HTML(bwork));
	}
	
	private String workDetail_HTML(List<BWork> workDetail){
		StringBuffer sb = new StringBuffer();
		sb.append("<input type='hidden' id='m_Menu' value='"+workDetail.get(0).getBw_Code()+"'>");//업무코드
		for (BWork bwork : workDetail){
			if(!bwork.getBw_Progress().equals("NP  ")){		
				sb.append("<a href='/bworkUpdateform?bw_Code="
				+bwork.getBw_Code()+"'><input type='button' value='업무 수정'></a><br/>");		
				sb.append("상태 : ");			
				if(bwork.getBw_Progress().equals("SB  ")){
					sb.append("대기");
				}else if(bwork.getBw_Progress().equals("PG  ")){
					sb.append("진행");
				}else if(bwork.getBw_Progress().equals("CP  ")){
					sb.append("완료");
				}else if(bwork.getBw_Progress().equals("SP  ")){
					sb.append("공개");
				}else if(bwork.getBw_Progress().equals("NP  ")){
					sb.append("비공개");
				}
				sb.append("<br/>");
				sb.append("업무명 : "+bwork.getBw_Title()+"<br/>");
				sb.append("등록자 : "+bwork.getBw_Email()+"<br/>");
				sb.append("책임자 : "+bwork.getBw_Owner()+"<br/>");
				sb.append("기한일 : "+bwork.getBw_Start()+"~"+bwork.getBw_Limit()+"<br/>");
				sb.append("업무 설명 : "+bwork.getBw_Content()+"<br/>");
			}else{
				   if(bwork.getBw_Owner().equals(sessionmid)){
					   sb.append("<a href='/bworkUpdateform?bw_Code="
								+bwork.getBw_Code()+"'><input type='button' value='업무 수정'></a><br/>");		
					   sb.append("상태 : ");			
						if(bwork.getBw_Progress().equals("SB  ")){
							sb.append("대기");
						}else if(bwork.getBw_Progress().equals("PG  ")){
							sb.append("진행");
						}else if(bwork.getBw_Progress().equals("CP  ")){
							sb.append("완료");
						}else if(bwork.getBw_Progress().equals("SP  ")){
							sb.append("공개");
						}else if(bwork.getBw_Progress().equals("NP  ")){
							sb.append("비공개");
						}
						sb.append("<br/>");
						sb.append("업무명 : "+bwork.getBw_Title()+"<br/>");
						sb.append("등록자 : "+bwork.getBw_Email()+"<br/>");
						sb.append("책임자 : "+bwork.getBw_Owner()+"<br/>");
						sb.append("기한일 : "+bwork.getBw_Start()+"~"+bwork.getBw_Limit()+"<br/>");
						sb.append("업무 설명 : "+bwork.getBw_Content()+"<br/>");
					}
				}
		}
		return sb.toString();
	}
	
	private String workSW_HTML(List<SWork> wkSWork, String bw_Code){
		//System.out.println("HTML"+wkSWork.get(0).getSw_Title());
		StringBuffer sb = new StringBuffer();
		sb.append("<form name='sWorkDel'>");
		sb.append("<input type='hidden' name='bw_Code' value='"+bw_Code+"'>");
		sb.append("<table class='table table-bordered'>");
		sb.append("<tr><td>선택</td><td>작업상태</td><td>작업제목</td><td>담당자</td>"
				+ "<td>시작일</td><td>기한일</td><td>완료일</td></tr>");
		for(int index=0; index<wkSWork.size(); index++){
			if(!wkSWork.get(index).getSw_Progress().equals("NP  ")){	
			sb.append("<tr><td><input type='radio' name='sw_Code' value='"+wkSWork.get(index).getSw_Code()+"'></td>");
			System.out.println(wkSWork.get(index).getSw_Code().length());
			sb.append("<td><input type='button' value='");			
			if(wkSWork.get(index).getSw_Progress().equals("SB  ")){
				sb.append("대기");
			}else if(wkSWork.get(index).getSw_Progress().equals("PG  ")){
				sb.append("진행");
			}else if(wkSWork.get(index).getSw_Progress().equals("CP  ")){
				sb.append("완료");
			}else if(wkSWork.get(index).getSw_Progress().equals("SP  ")){
				sb.append("공개");
			}else if(wkSWork.get(index).getSw_Progress().equals("NP  ")){
				sb.append("비공개");
			}
			sb.append("'></td>");
			sb.append("<td>"+wkSWork.get(index).getSw_Title()+"</td>");
			sb.append("<td>"+wkSWork.get(index).getSw_Email()+"</td>");
			sb.append("<td>"+wkSWork.get(index).getSw_Start()+"</td>");
			sb.append("<td>"+wkSWork.get(index).getSw_Limit()+"</td>");
			sb.append("<td>"+wkSWork.get(index).getSw_Final()+"</td></tr>");
			}else{
				   if(wkSWork.get(index).getSw_Email().equals(sessionmid)){
					   sb.append("<tr><td><input type='radio' name='sw_Code' value='"+wkSWork.get(index).getSw_Code()+"'></td>");
						System.out.println(wkSWork.get(index).getSw_Code().length());
						sb.append("<td><input type='button' value='");			
						if(wkSWork.get(index).getSw_Progress().equals("SB  ")){
							sb.append("대기");
						}else if(wkSWork.get(index).getSw_Progress().equals("PG  ")){
							sb.append("진행");
						}else if(wkSWork.get(index).getSw_Progress().equals("CP  ")){
							sb.append("완료");
						}else if(wkSWork.get(index).getSw_Progress().equals("SP  ")){
							sb.append("공개");
						}else if(wkSWork.get(index).getSw_Progress().equals("NP  ")){
							sb.append("비공개");
						}
						sb.append("'></td>");
						sb.append("<td>"+wkSWork.get(index).getSw_Title()+"</td>");
						sb.append("<td>"+wkSWork.get(index).getSw_Email()+"</td>");
						sb.append("<td>"+wkSWork.get(index).getSw_Start()+"</td>");
						sb.append("<td>"+wkSWork.get(index).getSw_Limit()+"</td>");
						sb.append("<td>"+wkSWork.get(index).getSw_Final()+"</td></tr>");			
					}
				}
			
		}
		sb.append("</table>");
		sb.append("</form>");
		sb.append("<table style = 'margin-left : 300px;' >");
		sb.append("<tr><td colspan='7'></td></tr>");
		System.out.println("detail"+bw_Code);
		sb.append("<tr><td><a href='/sWorkInsertform?bw_Code="+bw_Code+"'><input type='button' value='하위 업무 등록'></a></td>"
				+ "<td colspan='3'></td>"
				+ "<td> </td>"
				+ "<td><input type='button' value='하위 업무 삭제' onclick='sWorkDelete()'></td><tr>");
		sb.append("</table>");
		return sb.toString();
	}
	
	//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
	private void sWorkDelete(SWork swork) {
		System.out.println("0번");
		swork.getSw_Code();
		System.out.println(swork.getSw_Code());
		workDao.sWorkDelete(swork);
		BWork bwork = new BWork();
		bwork.setBw_Code(swork.getBw_Code());
		System.out.println(swork.getBw_Code());
		workDetail(bwork);
		System.out.println("1번");
		
	}
	
	
	private void workInsertform(BWork bwork){
		//sessionmid="ljs@naver.com";	

		mav.setViewName("team/workInsert");	
		
		mav.addObject("workInsert", workInsert_HTML(bwork.getPj_Code()));
	}
	
	private String workInsert_HTML(String pj_Code){
		StringBuffer sb = new StringBuffer();
		//sessionteam ="T20150122151932               ";
		Team team = new Team();
		team.setT_code(sessionteam);
		List<Team> teammemberList = teminfoDao.teammemberList(team);
		sb.append("<form action='/bworkInsert' method='post'>");
		sb.append("제목 : <input type='text' name='bw_Title'/></br>");
		sb.append("책임자 : <input type='text' name='bw_Owner'/>");
		sb.append("<select onChange='chkSel(this);'>");
		sb.append("<option value=''>팀원</option>");
		for(Team t:teammemberList){		
		sb.append("<option value='"+t.getTm_memail()+"'>"+t.getTm_mnickname()+"</option>");
		}
		sb.append("</select>");		
		sb.append("</br>");
		sb.append("공개 설정 : <input type='radio' name='bw_Share' value='SP'checked/> 공개"
				+ "<input type='radio' name='bw_Share' value='NP'/> 비공개</br>");
		sb.append("기한일 : <input type='text' name='bw_Start'/><input type='button' value='달력보기' onClick=\"datePicker(event,'bw_Start')\">"
				+ " - <input type='text' name='bw_Limit'/><input type='button' value='달력보기' onClick=\"datePicker(event,'bw_Limit')\"></br>");
		sb.append("설명 : <input type='text' name='bw_Content'/></br>");
		sb.append("<input type='hidden' name='pj_Code' value='"+pj_Code+"' /></br>");
		sb.append("<input type='submit' value='업무 등록'/></form>");
		
		return sb.toString();
	}
	
	private String sWorkInsert_HTML(String bw_Code) {
		StringBuffer sb = new StringBuffer();
		//sessionmid="ljs@naver.com";
		//sessionteam ="T20150122151932               ";
		Team team = new Team();
		team.setT_code(sessionteam);
		List<Team> teammemberList = teminfoDao.teammemberList(team);
		sb.append("<form action='/sWorkInsert' method='post'>");
		sb.append("제목 : <input type='text' name='sw_Title'/></br>");
		sb.append("담당자 : <input type='text' name='sw_Email'/>");
		sb.append("<select onChange='chkSel(this);'>");
		sb.append("<option value=''>팀원</option>");
		for(Team t:teammemberList){		
		sb.append("<option value='"+t.getTm_memail()+"'>"+t.getTm_mnickname()+"</option>");
		}
		sb.append("</select>");
		sb.append("</br>");
		sb.append("기한일 : <input type='text' name='sw_Start'/><input type='button' value='달력보기' onClick=\"datePicker(event,'sw_Start')\">"
				+ " - <input type='text' name='sw_Limit'/><input type='button' value='달력보기' onClick=\"datePicker(event,'sw_Limit')\"></br>");
		sb.append("<input type='hidden' name='bw_Code' value='"+bw_Code+"'/></br>");
		sb.append("<input type='submit' value='하위 업무등록'/></form>");
		return sb.toString();
	}
	
	private void sWorkInsert(SWork swork) {
		System.out.println(swork.getBw_Code());
		String code = swork.getBw_Code();//프로젝트코드 
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		swork.setBw_Code(code);
		//sessionteam ="T20150122151932               ";
		System.out.println("ss");
		swork.setT_Code(sessionteam);
		System.out.println(swork.getBw_Code());
		System.out.println(swork.getSw_Title());
		System.out.println(swork.getSw_Email());
		System.out.println(swork.getSw_Start());
		System.out.println(swork.getSw_Limit());
		System.out.println(swork.getSw_Progress());
		System.out.println(swork.getT_Code());
		workDao.sWorkInsert(swork);
		
		BWork bwork = new BWork();
		bwork.setBw_Code(swork.getBw_Code());
		workDetail(bwork);
	}
	
	private void sWorkInsertform(SWork swork){
		mav.setViewName("team/sWork");	
		System.out.println(swork.getBw_Code());
		mav.addObject("sWorkInsert", sWorkInsert_HTML(swork.getBw_Code()));
	}
	
	
	private void workInsert(BWork bwork){
		//sessionmid="ljs@naver.com";
		bwork.setT_Code(sessionteam);
		bwork.setBw_Email(sessionmid);
		workDao.workInsert(bwork);
		workList(bwork);
		
	}
	
	private void UnConnect(BWork bwork)	{
		bwork.getBw_Code();
		workDao.UnConnect(bwork);
		
		
	}
	
	
	
	private void workUpdateform(BWork bwork){
		//sessionmid="ljs@naver.com";	

		mav.setViewName("team/workUpdate");	
		
		List<BWork> workDetail = workDao.workDetail_View(bwork);
		System.out.println("44");
		mav.addObject("workUpdate", workUpdate_HTML(workDetail));
	}
	
	
	private String workUpdate_HTML(List<BWork> workDetail){
		StringBuffer sb = new StringBuffer();
		sb.append("<form action='/bworkUpdate' method='post'>");
		for (BWork bwork : workDetail){
			sb.append("제목 : <input type='text' name='bw_Title' value='"+bwork.getBw_Title()+"'/></br>");
			sb.append("책임자 : <input type='text' name='bw_Owner' value='"+bwork.getBw_Owner()+"'/></br>");
			sb.append("공개 설정 : <input type='radio' name='bw_Share' value='SP'/> 공개"
					+ "<input type='radio' name='bw_Share' value='NP'/> 비공개</br>");
			sb.append("기한일 : <input type='text' name='bw_Start' value='"+bwork.getBw_Start()+"'/>"
					+ " - <input type='text' name='bw_Limit' value='"+bwork.getBw_Limit()+"'/></br>");
			sb.append("설명 : <input type='text' name='bw_Content' value='"+bwork.getBw_Content()+"'/></br>");
			sb.append("<input type='hidden' name='bw_Code' value='"+bwork.getBw_Code()+"'/></br>");
			sb.append("<input type='submit' value='업무 수정'/>");
		}
		sb.append("</form>");

		return sb.toString();
	}
	
	
	private void workUpdate(BWork bwork){
		//sessionmid="ljs@naver.com";	

		workDao.workUpdate(bwork);
		workDetail(bwork);
	}
	
	private String bwComment_HTML(BWork bwork){
		StringBuffer sb = new StringBuffer();
		Comment comment = new Comment();
		String code = bwork.getBw_Code();//프로젝트코드 
		int cnt = code.length();
		for(int i = 0 ; i<30-cnt;i++)
			code = code+" ";
		comment.setM_Menu(code);//프로젝트코드 입력
		System.out.println("dd"+code);
		System.out.println(comment.getM_Menu());
		List<Comment> commentlist = new ArrayList<Comment>(); 	
		commentlist = WKCRDao.commentSelect(comment);
		int i = 1;		
		for(Comment comm:commentlist){			
			if(comm.getCm_Witter().equals(sessionmid)){
				if(comm.getCm_Witter().equals(sessionmid))
				sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				sb.append("<a href='#' onclick=\"bwcommentupdateform('"+comm.getCm_Code()+"')\">수정</a>&nbsp;");
				sb.append("<a href='#' onclick=\"bwcommentDel('"+comm.getCm_Code()+"')\">삭제</a><br>");
			}else{
				if(!comm.getCm_Share().equals("NN  ")){
					sb.append("코드:"+comm.getCm_Code()+"<br>작성자:"+comm.getCm_Witter()+"<br>시간:"+comm.getCm_Since()+"<br>내용:"+comm.getCm_Comment()+"<br>");
				}
			}
		}		
		return sb.toString();
	}
}
	
	
	
	