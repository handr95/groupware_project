package com.dt.E.BO;

import java.sql.Date;

public class BoardDetail {
	private String mpb_Owner;
	private String mpb_Title;
	private String mpb_Code;
	private String mp_Code;
	private String mp_Title;
	private String mp_Writter;
	private Date mp_Since;
	private String mp_Connent;
	private String hd_Title;
	
	
	public String getMpb_Title() {
		return mpb_Title;
	}
	public void setMpb_Title(String mpb_Title) {
		this.mpb_Title = mpb_Title;
	}
	public String getMp_Title() {
		return mp_Title;
	}
	public void setMp_Title(String mp_Title) {
		this.mp_Title = mp_Title;
	}
	
	public String getMp_Writter() {
		return mp_Writter;
	}
	public void setMp_Writter(String mp_Writter) {
		this.mp_Writter = mp_Writter;
	}
	public Date getMp_Since() {
		return mp_Since;
	}
	public void setMp_Since(Date mp_Since) {
		this.mp_Since = mp_Since;
	}
	public String getMp_Connent() {
		return mp_Connent;
	}
	public void setMp_Connent(String mp_Connent) {
		this.mp_Connent = mp_Connent;
	}
	public String getHd_Title() {
		return hd_Title;
	}
	public void setHd_Title(String hd_Title) {
		this.hd_Title = hd_Title;
	}
	
	public String getMp_Code() {
		return mp_Code;
	}
	public void setMp_Code(String mp_Code) {
		this.mp_Code = mp_Code;
	}
	

	public String getMpb_Code() {
		return mpb_Code;
	}
	public void setMpb_Code(String mpb_Code) {
		this.mpb_Code = mpb_Code;
	}
	public String getMpb_Owner() {
		return mpb_Owner;
	}
	public void setMpb_Owner(String mpb_Owner) {
		this.mpb_Owner = mpb_Owner;
	}
}
