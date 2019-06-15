package com.dt.A.THMH;

import java.util.Date;

import org.springframework.stereotype.Component;


public class AddressBean {
	private String ab_MEMAIL;
	private String ab_MyMemail;
	private String ab_MNICKNAME;
	private String ab_CHECK;
	private Date ab_LTIME;
	private String cl_Comment;
	public String getAb_MEMAIL() {
		return ab_MEMAIL;
	}
	public void setAb_MEMAIL(String ab_MEMAIL) {
		this.ab_MEMAIL = ab_MEMAIL;
	}
	public String getAb_MyMemail() {
		return ab_MyMemail;
	}
	public void setAb_MyMemail(String ab_MyMemail) {
		this.ab_MyMemail = ab_MyMemail;
	}
	public String getAb_MNICKNAME() {
		return ab_MNICKNAME;
	}
	public void setAb_MNICKNAME(String ab_MNICKNAME) {
		this.ab_MNICKNAME = ab_MNICKNAME;
	}
	public String getAb_CHECK() {
		return ab_CHECK;
	}
	public void setAb_CHECK(String ab_CHECK) {
		this.ab_CHECK = ab_CHECK;
	}
	public Date getAb_LTIME() {
		return ab_LTIME;
	}
	public void setAb_LTIME(Date ab_LTIME) {
		this.ab_LTIME = ab_LTIME;
	}
	public String getCl_Comment() {
		return cl_Comment;
	}
	public void setCl_Comment(String cl_Comment) {
		this.cl_Comment = cl_Comment;
	}
	
	
}
