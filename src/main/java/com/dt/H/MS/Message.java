package com.dt.H.MS;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Message {
	private String msg_code;
	private String msg_getmemail;
	private String[] msg_getmemail2; //그냥 스트링배열 전용 재탕
	private String msg_sendmemail;
	private String msg_content;
	private Date msg_time;
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	
	public String getMsg_getmemail() {
		return msg_getmemail;
	}
	public void setMsg_getmemail(String msg_getmemail) {
		this.msg_getmemail = msg_getmemail;
	}
	public String[] getMsg_getmemail2() {
		return msg_getmemail2;
	}
	public void setMsg_getmemail2(String[] msg_getmemail2) {
		this.msg_getmemail2 = msg_getmemail2;
	}
	public String getMsg_sendmemail() {
		return msg_sendmemail;
	}
	public void setMsg_sendmemail(String msg_sendmemail) {
		this.msg_sendmemail = msg_sendmemail;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Date msg_time) {
		this.msg_time = msg_time;
	}
	
	
}
