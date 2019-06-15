package com.dt.N.TI;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class TeamMemberListSv {

	@Autowired
	private TeamInfoDao TeamInfoDao;
	@Autowired
	private HttpServletRequest session;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	public ModelAndView excute(int type, Member member) {
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");			
		if(sessionmid==null){
			return new ModelAndView("/main/main");
		}
		mav = new ModelAndView();		
		switch (type) {
		case 1:
			teamCreditform(member);
			break;
		case 2:
			
			break;
		default:
			break;
		}
		return mav;

	}

	

	public ModelAndView excute(int type, Team team) {
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");			
		if(sessionmid==null){
			return new ModelAndView("/main/main");
		}
		if(sessionteam==null)
			sessionteam="";
		mav = new ModelAndView();
		switch (type) {
			case 1:
				teamCredit(team);
				break;	
			case 2:
				teamList(team);
				break;
				
			case 3:
				teammemberListDetail(team);
				break;
			
			case 4:
				teamInfo(team);
				break;		
					
			case 5:
				teamInfoUpdate(team);
				break;
			case 6:
				teamMemberAdd();
				break;
			case 7:
				isTeamName(team);
				break;			
			case 8:
				searchaddmember(team);				
				break;
			case 9:
				teamAddMembers(team);				
				break;				
			case 10:
				teamDropMembers(team);				
				break;	
			default:
				break;
			}
				
		return mav;

	}






	private void teamCreditform(Member member) {		
		mav.setViewName("main/teamCredit");	
		System.out.println();
		member.setM_Email(sessionmid);
		Member memberinfo = TeamInfoDao.memberInfo(member);
		mav.addObject("teamCredit", teamCreditHTML(memberinfo));

	}
		
	private String teamCreditHTML(Member member) {
		StringBuffer sb = new StringBuffer();	
		
		sb.append("<form action='/teamCredit' method='post' onsubmit=\"return teamCreditcheck(this);\">");
		sb.append("<table>");		
		/*
		sb.append("<colgroup>");
		sb.append("<col width ='30%'>");
		sb.append("<col width ='45%'>");
		sb.append("<col width ='15%'>");
		sb.append("</colgroup>");
		*/				
		sb.append("<tbody id='teammembers'>");		
		sb.append("<tr>");
		sb.append("<td>팀 마스터 :</td><td><input type='text' value='"+member.getM_Nickname()+"("+member.getM_Email()+")' readonly='readonly'/><td><td></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>팀 이름 :</td><td><input type='text' name='t_name'/></td><td><input type='button' value='팀이름체크' onclick='teamNameCheck()'/></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>팀 멤버 :</td><td><input type='text' name='tm_memail2'/></td><td></td>");
		sb.append("</tr>");		
		sb.append("</tbody>");				
		sb.append("<tfoot>");
		sb.append("<tr>");
		sb.append("<td></td><td colspan='2'><input type='button' value='+팀원 추가' onclick='addmember()'/><input type='submit' value='+팀 만들기'/></td>");		
		sb.append("</tr>");
		sb.append("</tfoot>");
		sb.append("</table>");
		sb.append("</form>");		
		return sb.toString();
	}
	
	private void teamCredit(Team team) {				
		team.setT_memail(sessionmid);
		if(TeamInfoDao.teamInsert(team)){
			String tcode=TeamInfoDao.getTeamCode(team);
			Team teamMember = new Team();
			teamMember.setT_code(tcode);
			String[] tm_memail = team.getTm_memail2();
			for(int i=0;i<tm_memail.length;i++){				
				if(!tm_memail[i].equals("")){
					teamMember.setTm_memail(tm_memail[i]);
					teamMember.setTm_grtype("TS");
					TeamInfoDao.teamMemberInsert(teamMember);
				}
			}
			teamMember.setTm_memail(sessionmid);			
			teamMember.setTm_grtype("TM");
			TeamInfoDao.teamMemberInsert(teamMember);			
			mav.setViewName("main/main");
			//팀정보 출력
		}else{			
			mav.setViewName("main/teamCredit");
		}
	}
	
	private void teamList(Team team){
		//mav = new ModelAndView();
		mav.setViewName("service/teamList");
		System.out.println(sessionmid);
		team.setTm_memail(sessionmid);
		List<Team> teamList = TeamInfoDao.teamList(team);
		mav.addObject("teamList", teamList_HTML(teamList));
	}
	
	private String teamList_HTML(List<Team> teamlist){
		
	
		StringBuffer sb = new StringBuffer();
		int index=0;
		for (Team team : teamlist){
			if(index==0){
				sb.append("<div onclick=\"location.href='/team_homeform?t_code="+team.getT_code()+"'\"  class='teamlist' style='width: 66%;height:	400px; '>");
			}else{
				sb.append("<div onclick=\"location.href='/team_homeform?t_code="+team.getT_code()+"'\" class='teamlist'>");
			}
			//sb.append("<div class='teamlist2' onMouseOver=\"this.className='pOver'\" onMouseOut=\"this.className='teamlist2'\">");
			sb.append("<div class='teamlist2' id='div"+index+"' onMouseOver=\"pOver2('#div"+index+"','bt"+index+"')\" onMouseOut=\"pOut2('#div"+index+"','bt"+index+"')\">");
			if(index==0){
			sb.append("<div style='height : 100px; background-color : #C2D8F5; text-align : center;'>"+"<div style='padding-top : 35px; font-size : 70px;'>"+team.getT_name()+"</div></div>");
			}else{
				sb.append("<div style='height : 70px; background-color : #C2D8F5; text-align : center;'>"+"<div style='padding-top: 22px; font-size : 15px;'>"+team.getT_name()+"</div></div>");
			}
			sb.append("팀 개설일 : "+team.getT_since()+"<br/>");
			System.out.println(team.getT_since());
			sb.append("멤버 : ");
			sb.append(teamMemberList(team)+" "+"<br/>");
			sb.append(TeamInfoDao.teamListCount(team)+"명<br/>");
			sb.append("<div id='bt"+index+"' style='display:none; margin-bottom : 20px;'><a href='/teamMemberListPage?t_code="+team.getT_code()+"'><input type='button' value='환경설정'></a></div>");
			sb.append("</div>");
			sb.append("</div>");
			index++;
		}
	
		return sb.toString();
	}
	
	private String teamMemberList(Team team){
		StringBuffer sb = new StringBuffer();
		List<Team> teammemberList = TeamInfoDao.teammemberList(team);
		int cnt = teammemberList.size();
		int i =1;
		for (Team team2 : teammemberList){
			sb.append(team2.getTm_mnickname());
			if(i<cnt)
			sb.append(", ");
			i++;
		}
		
		return sb.toString();
	}
	

	private void teammemberListDetail(Team team){
		//mav = new ModelAndView();
		//팀코드 추가
		String tcode ="";
		if(team.getT_code()==null){
			tcode = sessionteam;
			System.out.println(tcode);
		}else{
			tcode = team.getT_code();
		}
		int cnt =  tcode.length();
		for(int i = 0 ; i<30-cnt;i++)
			tcode = tcode+" ";
		team.setT_code(tcode);		
		//팀코드랑 팀내등급을 넣어줄 필요가 있을듯.
		session.getSession().setAttribute("sessionteam",tcode);
		List<Team> teamlist = TeamInfoDao.teammemberList(team);		
		for(Team t : teamlist){
			if(t.getTm_memail().equals(sessionmid))
				//팀내등급  세션에 저장
				session.getSession().setAttribute("grade2",t.getTm_grtype());
		}
		mav.setViewName("service/teamMemberList");
		List<Team> teammemberList = TeamInfoDao.teammemberList(team);
		mav.addObject("teammemberList", teammemberList_HTML(teammemberList));
	}
	
	private String teammemberList_HTML(List<Team> teamlist){
		StringBuffer sb = new StringBuffer();
		sb.append("멤버 목록 <br/><hr/><br/>");		
		sb.append("<input type='hidden' id='tcode' value='"+teamlist.get(0).getT_code()+"'>");		
		sb.append("<table><tr><td>선택</td> <td>이름</td> <td>연락처</td> <td>최종 접속일</td></tr>");
		for (Team team : teamlist){
			sb.append("<tr><td><input type='radio' name='t_memail' value='"+team.getTm_memail()+"'></td>");
			sb.append("<td>"+team.getTm_mnickname()+"</td>");
			
			sb.append("<td>"+team.getTm_memail()+"</td>");
			if(team.getTm_litime()!=null){
			sb.append("<td>"+(team.getTm_litime().getYear()+1900)+"/"+team.getTm_litime().getMonth()+1+"/"+team.getTm_litime().getDate()+" "
					+team.getTm_litime().getHours()+":"+team.getTm_litime().getMinutes()+":"+team.getTm_litime().getSeconds()+"</td>");
			}else{
				sb.append("<td>미접</td>");
			}
			sb.append("</tr>");
		}
		sb.append("</table><input type=button value='멤버추가' onclick='memberaddform()'/><input type=button value='멤버삭제' onclick='dropTeammember()'/>");
		return sb.toString();
	}
	
	private void teamInfo(Team team){
		//mav = new ModelAndView();
		team.setT_code(sessionteam);
		mav.setViewName("service/teamInfo");
		List<Team> teamInfo = TeamInfoDao.teamDetail(team);
		mav.addObject("teamInfo", teamInfo_HTML(teamInfo));
	}
	
	
	private String teamInfo_HTML(List<Team> teamInfo){
		StringBuffer sb = new StringBuffer();
		for (Team team : teamInfo){
			sb.append("<form action='/teamInfoUpdate' method='post'>");
			sb.append("팀 생성일 : "+team.getT_since()+"</br>");
			sb.append("팀 이름 : <input type='text' name='t_name' value="+team.getT_name()+"></br>");
			sb.append("<input type='submit' value='팀 이름 변경'/></form>");
		}
		return sb.toString();
	}
	
	private void teamInfoUpdate(Team team){
		//mav = new ModelAndView();
		team.setT_code(sessionteam);
		//mav.setViewName("service/teamInfo");
		TeamInfoDao.teamInfoUpdate(team);
		teamInfo(team);
	}

	public void teamMemberAdd() {
		//mav = new ModelAndView();
		mav.addObject("teamMemberadd", addmemberlist()); 
		mav.setViewName("/main/teamCreditMember");		
	}

	private String addmemberlist() {
		StringBuffer sb = new StringBuffer();	
			sb.append("<tr>");
			sb.append("<td></td>");
			sb.append("<td><input type='text' name='tm_memail2'/></td>");
			sb.append("</tr>");	
		return sb.toString();
	}
	
	private void isTeamName(Team team) {
		if(TeamInfoDao.isTeamName(team)){
			//이미 있는 팀명
			System.out.println("사용중인 이름");		
			mav.setViewName("main/teamCredit");
		}else{
			//사용 가능한 팀명
			System.out.println("사용가능한 이름");
			
		}
		
	}
	
	private void searchaddmember(Team team) {
		System.out.println(team.getT_code());
		List<Member> memberlist = TeamInfoDao.searchaddmember(team);
		if(memberlist.size()==0){
			mav.addObject("searchaddmember", "존재하지 않는 이메일입니다.");
		}else{
			mav.addObject("searchaddmember", memberhtml(memberlist));
		}
		mav.setViewName("my/myboComment");		
	}

	private String memberhtml(List<Member> memberlist) {
		StringBuffer sb = new StringBuffer();
		sb.append("<form name='addm' action='/teamAddMembers' method='post'>");		
		sb.append("<input type='hidden' name='t_code'>");
		sb.append("<table>");
		for(Member member:memberlist){
			sb.append("<tr>");
			sb.append("<td><input type='checkbox' name='tm_memail2' value='"+member.getM_Email()+"'/></td>");
			sb.append("<td>"+member.getM_Email()+"</td>");
			sb.append("<td>("+member.getM_Nickname()+")</td>");
			sb.append("</tr>");		
		}		
		sb.append("</table>");
		sb.append("</form>");
		
	return sb.toString();
	}
	
	//팀원추가
	private void teamAddMembers(Team team) {
		System.out.println(team.getT_code());
		String[] email = team.getTm_memail2();
		if(grade2.equals("TM  ")){//팀장이면
			for(String m : email){
				team.setTm_memail(m);
				team.setTm_grtype("TS");
				TeamInfoDao.teamMemberInsert(team);
			}
		teammemberListDetail(team);
		}
	}
	
	private void teamDropMembers(Team team) {
		System.out.println(grade2);
		System.out.println(team.getT_code());
		System.out.println(team.getT_memail());
		if(grade2.equals("TM  ")){//팀장이면
			if(TeamInfoDao.dropteammember(team)){
			mav.setViewName("/main/main");
			}
		}
	}
}
