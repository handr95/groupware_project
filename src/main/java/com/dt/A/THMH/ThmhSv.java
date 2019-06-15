package com.dt.A.THMH;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dt.N.TI.Team;
import com.dt.N.TI.TeamInfoDao;

@Service
public class ThmhSv {
	
	private ModelAndView mav;
	
	@Autowired
	private ThmhDao thmhdao;	
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TeamInfoDao TIDao;
	
	private String sessionmid;
	private String sessionnickname;	
	private String grade1;
	private String sessionteam;
	private String grade2;	
	
	private int i = 0;

	public ModelAndView excute(int type, Board board){
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");	
		mav = new ModelAndView();
		switch(type){
		case 1:
			find_hash(board);
			break;
		case 2:
			Detailfind_hash(board);
			break;
		case 3:
			hashBoardDetail(board);
			break;
		case 4:
			
			break;
		case 5:
			break;
		default :	
			break;
			
	}
	
		return mav;
	}
	

	
	
	public ModelAndView my_home(Board board){
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		request.getSession().setAttribute("sessionteam", sessionmid);	
		System.out.println(sessionmid);
		//개인은 등급처리하기가 좀 힘듬		
		List<Hash> todayCal;
		mav = new ModelAndView();
		Calendar cal = new Calendar();
		
		
		Date date = new Date();
		  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		java.util.Calendar cal1 = java.util.Calendar.getInstance();
		
		cal1.setTime(date);
		
		String today = sdf.format(cal1.getTime()); 
		System.out.println("1"+today);
		cal.setEmail(sessionmid);
	    cal.setCurrent(today);
	      
	    List<Calendar> mycallist1 = thmhdao.todayCal(cal);
	    
	    
	    cal1.setTime(date);
	    cal1.add(java.util.Calendar.DATE, +1);
	    today = sdf.format(cal1.getTime());  
	    cal.setCurrent(today);
	    List<Calendar> mycallist2 = thmhdao.todayCal(cal);
	    System.out.println("2"+today);
	    
	    cal1.setTime(date);
	    cal1.add(java.util.Calendar.DATE, +2);
	    today = sdf.format(cal1.getTime());  
	    cal.setCurrent(today);
	    List<Calendar> mycallist3 = thmhdao.todayCal(cal);
	    System.out.println("3"+today);
		
		if(sessionmid==null)
			mav.setViewName("/main/main");
		else
			mav.addObject("myTodayCal1", myTodayCal_HTML(mycallist1));
			mav.addObject("myTodayCal2", myTodayCal_HTML(mycallist2));
			mav.addObject("myTodayCal3", myTodayCal_HTML(mycallist3));
			mav.setViewName("/my/myhome");
		//List<Board> hashlist = thmhdao.findHash(board);
		//mav.addObject("testhash", findHash_HTML(hashlist));	
		return mav;
	}
	
	private String myTodayCal_HTML(List<Calendar> callist){
		System.out.println(callist.get(0).getEmail());
		  StringBuffer sb = new StringBuffer();
		  Date d = new Date();
		  sb.append("<center><table><tr>");
		  sb.append("<td rowspan="+callist.size()+">"+(d.getMonth()+1)+"월"+(d.getDate()+i)+"일</td>");
		  for(Calendar cal : callist){
			  sb.append("<td>"+cal.getC_Title());
			  sb.append(cal.getC_Start());
			  sb.append(cal.getC_Limit()+"</td></tr>");
		  }
		  sb.append("<table></center>");
		  
		  i++;
		  
		  return sb.toString();
	}
	
	
	private void find_hash(Board board){	
		mav.setViewName("my/hashtagSearch");
	}
	
	private void Detailfind_hash(Board board){	

		//sessionmid="ljs@naver.com";

		AddressBean add = new AddressBean();
		
		add.setAb_MyMemail(sessionmid);
		
		mav.setViewName("my/resultHash");
		//System.out.println("s"+board.getHs_Title());
		List<Board> boardList = thmhdao.findHash(board);
		mav.addObject("hashdetail", Detailfind_hashHTML(boardList));
		
	}
	
	
	private String Detailfind_hashHTML(List<Board> hashlist){
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr><td>게시글 제목</td><td>게시글 등록자</td><td>등록일</td></tr>");
		for (Board board : hashlist){
			sb.append("<tr><td><a href='#' onclick=\"detailhash('"+board.getMp_Code()+"')\">"+board.getMp_Title()+"</a></td>");
			sb.append("<td>"+board.getMp_Memail()+"</td>");
			sb.append("<td>"+board.getMp_Since()+"</td></tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}
	
	
	private void hashBoardDetail(Board board){
	    
		mav.setViewName("my/hashboard");
		List<Board> boardList = thmhdao.findHashBoard(board);
		mav.addObject("hashdetail", hashBoardDetail_HTML(boardList));
	}
	
	private String hashBoardDetail_HTML(List<Board> boardList){
		StringBuffer sb = new StringBuffer();
		
		
			sb.append("게시판 제목 : "+boardList.get(0).getMpb_Title()+"<br/>");
			sb.append("게시글 제목 : "+boardList.get(0).getMp_Title()+"<br/>");
			sb.append("게시글 등록자 : "+boardList.get(0).getMp_Memail()+"<br/>");
			sb.append("게시글 등록일 : "+boardList.get(0).getMp_Since()+"<br/>");
			sb.append("게시글 내용 : "+boardList.get(0).getMp_Content()+"<br/>");
			sb.append("해시태그 : ");
			for (Board board : boardList){
				sb.append("<a href='#' onclick=\"hashfind2('"+board.getHs_Title()+"')\">"+board.getHs_Title()+"</a>");
			}
			
		
		
	    
		return sb.toString();
	}
	
	
	
	public String m_today_View(ArrayList<Calendar> todayCal){
		StringBuffer sb = new StringBuffer();
		for(int index=0; index<todayCal.size(); index++){
			sb.append(todayCal.get(index).getC_Limit());
			sb.append(todayCal.get(index).getC_Title());
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	public ModelAndView team_Home(Team team){
		sessionmid = (String)request.getSession().getAttribute("sessionmid");		
		//팀코드 세션에 추가
		sessionteam = (String)request.getSession().getAttribute("sessionteam");
		String code ="";
		System.out.println(team.getT_code());
		if(team.getT_code()!=null){
			code=team.getT_code();
		}else if(sessionteam==null){
			sessionteam="";
			code =team.getT_code();
		}else{
			code =sessionteam;
		}			 
			int cnt = code.length();
			for(int i = 0 ; i<30-cnt;i++)
				code = code+" ";		
			request.getSession().setAttribute("sessionteam",code);
			team.setT_code(code);
			System.out.println(team.getT_code());
			List<Team> teamlist = TIDao.teammemberList(team);		
			for(Team t : teamlist){
				if(t.getTm_memail().equals(sessionmid))
					//팀내등급  세션에 저장
					request.getSession().setAttribute("grade2",t.getTm_grtype());
			}
		
		mav=new ModelAndView();
		Board board = new Board();
	
		List<Board> boardList = thmhdao.thnotice(board); 
		mav.addObject("teamnotice", notice_HTML(boardList));
		mav.setViewName("/team/teamHome");
		return mav;
		/* 보드페이지를 봤을때 나오는 정보를 출력 */
	}
	
	
	private String notice_HTML(List<Board> notice){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<class='table-responsive'>");
		sb.append("<table class='table'>");
		sb.append("<tr><td>공지사항</tr></td>");
		for (Board boardnotice : notice){
			sb.append("<tr><td><a href='/boardDetailForm?mp_Code="+boardnotice.getMp_Code()+"'>제목 :&nbsp&nbsp"+boardnotice.getMp_Title()+"&nbsp&nbsp작성자 : &nbsp&nbsp"+boardnotice.getMp_Memail()+"&nbsp&nbsp작성일 : &nbsp&nbsp"+boardnotice.getMp_Since()+"</a></tr></td>");
		}
		
		sb.append("<tr><td><a href='/boardInsertForm'>게시글 등록 페이지로 이동</a></tr></td>");
		sb.append("</table></div>");
		return sb.toString();

	}
	
	
	public String notice(){
		StringBuffer sb = new StringBuffer();
		
		
		return sb.toString();
	}
	
	public void t_today_View(){
		mav = new ModelAndView();
	}
	
	public void bnotice_View(){
		mav = new ModelAndView();
	}
	
	public void myDo_View(){
		mav = new ModelAndView();
	}
	
	public void myTeamUpdate_View(){
		mav = new ModelAndView();
	}
}
