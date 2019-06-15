package com.dt.H.MS;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;



@Service
public class MessageSv {

	@Autowired
	private MessageDAO msgDao;
	@Autowired
	private HttpServletRequest session;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;	
	
	public ModelAndView excute(int type, Message message) {
		sessionmid = (String)session.getSession().getAttribute("sessionmid");
		grade1 = (String)session.getSession().getAttribute("grade1");
		sessionteam= (String)session.getSession().getAttribute("sessionteam");
		grade2= (String)session.getSession().getAttribute("grade2");
		sessionnickname = (String)session.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");	
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav=new ModelAndView();
		switch(type){
		case 1:
			messageSendform(message);
			break;
		case 2:
			messageInsert(message);
			break;
		case 3:
			messageDelete(message);
			break;
		case 4:
			messageReciveform(message);
			break;
		case 5:
			messageAnswer(message);
			break;
		default :	
			
	}
	

		return mav;
	}
	
	private void messageAnswer(Message message) {
		message.setMsg_sendmemail(sessionmid);
		if(msgDao.messageInsert(message))//메시지 보내졌으면
			msgDao.messageResiveInsert(message);
		messageReciveform(message);
	}

	/*
	sessionmid = (String)session.getSession().getAttribute("mid");
	grade1 = (String)session.getSession().getAttribute("grade1");
	sessionteam= (String)session.getSession().getAttribute("teamcode");
	grade2= (String)session.getSession().getAttribute("grade2");
	*/
	private void messageSendform(Message message){	
		//sessionmid = "ljs@naver.com";//로그인했을때 로그인단에서 session에 아이디 저장했다고 가정		
		//sessionteam = sessionmid;
		message.setMsg_sendmemail(sessionmid);
		List<AddressBean> addrlist = msgDao.getaddrList(message);	
		List<Team> teamlist=msgDao.getTeamList(message);		
		if(sessionteam.indexOf("@")!=-1){
			mav.addObject("myaddrlist", makeSendmylistHtml(addrlist));
			mav.addObject("myteamlist", makeSendteamlistHtml(teamlist));
			mav.setViewName("/my/MyMessage");
		}else{
			mav.addObject("myaddrlist", makeSendmylistHtml(addrlist));
			mav.addObject("myteamlist", makeSendteamlistHtml(teamlist));
			mav.setViewName("/team/message");
		}
		
		
	}
	private void messageInsert(Message message){
		//sessionmid = "ljs@naver.com";//로그인했을때 로그인단에서 session에 아이디 저장했다고 가정
		Message messagebean = new Message();
		messagebean.setMsg_sendmemail(sessionmid);
		messagebean.setMsg_content(message.getMsg_content());
		String[] msg_getmemail= message.getMsg_getmemail2();		
		for(int i=0;i<msg_getmemail.length;i++){
			messagebean.setMsg_getmemail(msg_getmemail[i]);
			System.out.println("머나오나"+msg_getmemail[i]);
			if(!msg_getmemail[i].equals("")){
				msgDao.messageInsert(messagebean);
				msgDao.messageResiveInsert(messagebean);
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				} 
			}
		}
		messageSendform(message);
		
	}
	private void messageDelete(Message message){
		//sessionmid = "ljs@naver.com";//로그인했을때 로그인단에서 session에 아이디 저장했다고 가정		
		String[] code = message.getMsg_getmemail2();
		System.out.println("delete");		
		if(code != null){
			
			System.out.println(code.length);
			
			for(int i=0;i<code.length;i++){
				System.out.println(code[i]);
				if(!code[i].equals("")){
					//하나만 넘어오면 String으로 신식 뒤에 공백을 인식 안함,공백 보완
					if(code.length==1){
						int cnt = code[i].length();
						for(int j=0;j<30-cnt;j++){
							code[i]=code[i]+" ";
						}
					}
					//받은 메시지 삭제
					message.setMsg_code(code[i]);
					if(code[i].indexOf("MSGR")!=-1){
						System.out.println("받은");
						message.setMsg_getmemail(sessionmid);						
						msgDao.messageResiveDelete(message);						
					//보낸 메시지 삭제
					}else{
						System.out.println("보낸");
						message.setMsg_sendmemail(sessionmid);
						msgDao.messageDelete(message);
					}
				}
			}
			
		}
		messageReciveform(message);
	}
	private void messageReciveform(Message message){
		//sessionmid = "ljs@naver.com";//로그인했을때 로그인단에서 session에 아이디 저장했다고 가정
		//sessionteam =sessionmid;
		message.setMsg_sendmemail(sessionmid);
		List<Message> messageSlist = msgDao.getSendMessageList(message);
		List<Message> messageRlist = msgDao.getReciveMessageList(message);
		//System.out.println(messageRlist.size());
		//System.out.println(messageRlist.get(0).getMsg_sendmemail());
		if(sessionteam.indexOf("@")!=-1){
			mav.addObject("sendmessageham", makeReciveSHtml(messageSlist));
			mav.addObject("recivemessageham", makeReciveRHtml(messageRlist));
			mav.setViewName("/my/MyMessageham");
		}else{
			mav.addObject("sendmessageham", makeReciveSHtml(messageSlist));
			mav.addObject("recivemessageham", makeReciveRHtml(messageRlist));
			mav.setViewName("/team/Messageham");
		}
		
		
	}
	private String makeSendmylistHtml(List<AddressBean> addrlist){
		//개인 체크박스
		StringBuffer buf = new StringBuffer();		
		buf.append("<label>--내이웃--</label><br/>");
		for(AddressBean addressbean:addrlist){			
			buf.append("&nbsp;&nbsp;<label><input type='checkbox' name='msg_getmemail2' value='"+addressbean.getAb_MEMAIL()+"' />"+addressbean.getAb_MNICKNAME()+"</label><br/>");						
		}	
		return buf.toString();
		
	}
	private String makeSendteamlistHtml(List<Team> teamlist){
		//팀 체크박스
		StringBuffer buf = new StringBuffer();
		String tcode="";
		int i=0;
		buf.append("<label>--내팀--</label><br/>");//현제 팀만 확인 됨,미완성
		for(Team team:teamlist){
			if(!(tcode.equals(team.getT_code()))){			
				buf.append("<label>"+team.getT_name()+"</label><br/>");
				for(Team team1:teamlist){
					if(team.getT_code().equals(team1.getT_code()))
					buf.append("&nbsp;&nbsp;<label><input type='checkbox' name='msg_getmemail2' value='"+team1.getTm_memail()+"' />"+team1.getTm_mnickname()+"</label><br/>");
				}
			}
			if(!(tcode.equals(team.getT_code())))
				i++;
			tcode=team.getT_code();			
		}		
		return buf.toString();
	}
	private String makeReciveSHtml(List<Message> smessage){
		StringBuffer buf = new StringBuffer();
		buf.append("<form name='send' method='post'>");
		buf.append("<div style='width:inherit; height:280px; overflow-y:auto;'>");
		buf.append("<table style='width:inherit; overflow-y:auto;' >");
		buf.append("<colgroup><col width='30%'><col width='35%'><col width='35%'></colgroup>");		
		buf.append("<thead>");
		buf.append("<tr>");		
		buf.append("<th>받은이</th>");		
		buf.append("<th>받은시각</th>");		
		buf.append("<th>내용</th>");		
		buf.append("</tr>");
		buf.append("</thead>");
		buf.append("<tfoot>");
		int i=1;
		for(Message message : smessage){
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("<input type='checkbox' name='msg_getmemail2' value='"+message.getMsg_code()+"'>");
			buf.append(message.getMsg_getmemail());
			buf.append("</td>");
			buf.append("<td>");	
			buf.append((message.getMsg_time().getYear()+1900)
					+":"+(message.getMsg_time().getMonth()+1)
					+":"+message.getMsg_time().getDate()
					+":"+message.getMsg_time().getHours()
					+":"+message.getMsg_time().getMinutes()
					+":"+message.getMsg_time().getSeconds());
			buf.append("</td>");
			buf.append("<td>");	
			buf.append("<a onclick=\"display('content"+i+"');\">"+message.getMsg_content()+"</a>");
			buf.append("<div id=\"content"+i+"\" style=\"display: none; position:absolute; width:100px; height:150px; \">");			
			buf.append("<textarea rows='5' cols='20' style='resize:none; overflow-y:scroll;'>"+message.getMsg_content()+"</textarea><br/>");			
			buf.append("</div>");			
			buf.append("</td>");
			buf.append("</tr>");
			i++;
		}
		buf.append("<tr><td></td><td>");	
		
		buf.append("</td></tr>");
		buf.append("</tfoot>");
		buf.append("</table>");
		buf.append("</div>");
		buf.append("<input type='button' value='삭제' onclick='messagedelete1()'>");
		buf.append("</form>");
		return buf.toString();
		
	}
	private String makeReciveRHtml(List<Message> rmessage){
		StringBuffer buf = new StringBuffer();
		buf.append("<form name='receive' method='post'>");
		buf.append("<div style='width:inherit; height:280px; overflow-y:auto;'>");
		buf.append("<table style='width:inherit; overflow-y:auto;' >");
		buf.append("<colgroup><col width='30%'><col width='35%'><col width='35%'></colgroup>");		
		buf.append("<thead>");
		buf.append("<tr>");		
		buf.append("<th>보낸이</th>");		
		buf.append("<th>받은시각</th>");		
		buf.append("<th>내용</th>");		
		buf.append("</tr>");
		buf.append("</thead>");
		buf.append("<tfoot>");
		int i=1;
		for(Message message : rmessage){
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("<input type='checkbox' name='msg_getmemail2' value='"+message.getMsg_code()+"'>");
			buf.append(message.getMsg_sendmemail());
			buf.append("</td>");
			buf.append("<td>");	
			buf.append((message.getMsg_time().getYear()+1900)
					+":"+(message.getMsg_time().getMonth()+1)
					+":"+message.getMsg_time().getDate()
					+":"+message.getMsg_time().getHours()
					+":"+message.getMsg_time().getMinutes()
					+":"+message.getMsg_time().getSeconds());
			buf.append("</td>");
			buf.append("<td>");	
			buf.append("<a onclick=\"display('rcontent"+i+"');\">"+message.getMsg_content()+"</a>");
			buf.append("<div id=\"rcontent"+i+"\" style=\"display: none; position:absolute; width:100px; height:150px;\">");
			buf.append("<input type='hidden' id='code"+i+"' value='"+message.getMsg_sendmemail()+"'>");
			buf.append("<textarea id='resend"+i+"' rows='5' cols='20' style='resize:none;  overflow-y:scroll;'></textarea><br/>");
			buf.append("<input type='button' value='답장' onclick=\"resend('resend"+i+"','code"+i+"');\">");
			buf.append("</div>");
			buf.append("</td>");
			buf.append("</tr>");
			i++;
		}
		buf.append("<tr><td></td><td>");	
		
		buf.append("</td></tr>");	
		buf.append("</tfoot>");
		buf.append("</table>");
		buf.append("</div>");
		buf.append("<input type='button' value='삭제' onclick='messagedelete2()'>");
		buf.append("<input type='hidden' name='msg_getmemail' >");
		buf.append("<input type='hidden' name='msg_content' >");		
		buf.append("</form>");
		return buf.toString();
		
	}


}
