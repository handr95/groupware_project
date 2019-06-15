package com.dt.B.PJ;

import java.sql.Date;



public class Project {
	private String pj_Code;
	private String t_Code;
	private String pj_Email;
	private String pj_Owner;
	private String pj_Title;
	private Date pj_Start;
	private Date pj_Limit;
	private String pj_Content;
	private String pj_Progress;
	private Date pj_Final;
	
	public String getPj_Code() {
		return pj_Code;
	}
	public void setPj_Code(String pj_Code) {
		this.pj_Code = pj_Code;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getPj_Email() {
		return pj_Email;
	}
	public void setPj_Email(String pj_Email) {
		this.pj_Email = pj_Email;
	}
	
	public String getPj_Owner() {
		return pj_Owner;
	}
	
	public void setPj_Owner(String pj_Owner) {
		this.pj_Owner = pj_Owner;
	}
	
	public String getPj_Title() {
		return pj_Title;
	}
	
	public void setPj_Title(String pj_Title) {
		this.pj_Title = pj_Title;
	}
	
	
	public Date getPj_Start() {
		return pj_Start;
	}
	public void setPj_Start(Date pj_Start) {
		this.pj_Start = pj_Start;
	}
	public Date getPj_Limit() {
		return pj_Limit;
	}
	public void setPj_Limit(Date pj_Limit) {
		this.pj_Limit = pj_Limit;
	}
	public Date getPj_Final() {
		return pj_Final;
	}
	public void setPj_Final(Date pj_Final) {
		this.pj_Final = pj_Final;
	}
	public String getPj_Content() {
		return pj_Content;
	}
	public void setPj_Content(String pj_Content) {
		this.pj_Content = pj_Content;
	}
	public String getPj_Progress() {
		return pj_Progress;
	}
	public void setPj_Progress(String pj_Progress) {
		this.pj_Progress = pj_Progress;
	}
	
	
}
