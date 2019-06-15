package com.dt.J.GC;

import java.sql.Date;

public class ErrorReport {
	private String er_num;
	private String er_code;
	private String er_name;
	private String er_email;
	private String er_title;
	private String er_content;
	private String er_reply;
	private Date er_since;
	private int er_hits;
	
	
	
	
	
	public String getEr_reply() {
		return er_reply;
	}
	public void setEr_reply(String er_reply) {
		this.er_reply = er_reply;
	}
	public String getEr_num() {
		return er_num;
	}
	public void setEr_num(String er_num) {
		this.er_num = er_num;
	}
	public String getEr_code() {
		return er_code;
	}
	public void setEr_code(String er_code) {
		this.er_code = er_code;
	}
	public String getEr_name() {
		return er_name;
	}
	public void setEr_name(String er_name) {
		this.er_name = er_name;
	}
	public String getEr_email() {
		return er_email;
	}
	public void setEr_email(String er_email) {
		this.er_email = er_email;
	}
	public String getEr_title() {
		return er_title;
	}
	public void setEr_title(String er_title) {
		this.er_title = er_title;
	}
	public String getEr_content() {
		return er_content;
	}
	public void setEr_content(String er_content) {
		this.er_content = er_content;
	}	
	public Date getEr_since() {
		return er_since;
	}
	public void setEr_since(Date er_since) {
		this.er_since = er_since;
	}
	public int getEr_hits() {
		return er_hits;
	}
	public void setEr_hits(int er_hits) {
		this.er_hits = er_hits;
	}	
}
