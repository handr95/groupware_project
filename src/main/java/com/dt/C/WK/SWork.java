package com.dt.C.WK;

import java.sql.Date;

public class SWork {
	private String sw_Code; //하위업무 코드
	private String t_Code; //팀코드
	private String bw_Code; //업무 코드
	private String sw_Progress; //진행사항
	private String sw_Email; //작성자
	private String sw_Title; 
	private String sw_Content;
	private Date sw_Start; //시작일
	private Date sw_Limit; //마감일
	private Date sw_Final; //완료일
	
	public String getSw_Code() {
		return sw_Code;
	}
	
	public void setSw_Code(String sw_Code) {
		this.sw_Code = sw_Code;
	}

	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getBw_Code() {
		return bw_Code;
	}
	public void setBw_Code(String bw_Code) {
		this.bw_Code = bw_Code;
	}
	public String getSw_Progress() {
		return sw_Progress;
	}
	public void setSw_Progress(String sw_Progress) {
		this.sw_Progress = sw_Progress;
	}
	public String getSw_Email() {
		return sw_Email;
	}
	public void setSw_Email(String sw_Email) {
		this.sw_Email = sw_Email;
	}
	public String getSw_Title() {
		return sw_Title;
	}
	public void setSw_Title(String sw_Title) {
		this.sw_Title = sw_Title;
	}
	public String getSw_Content() {
		return sw_Content;
	}
	public void setSw_Content(String sw_Content) {
		this.sw_Content = sw_Content;
	}
	public Date getSw_Start() {
		return sw_Start;
	}
	public void setSw_Start(Date sw_Start) {
		this.sw_Start = sw_Start;
	}
	public Date getSw_Limit() {
		return sw_Limit;
	}
	public void setSw_Limit(Date sw_Limit) {
		this.sw_Limit = sw_Limit;
	}
	public Date getSw_Final() {
		return sw_Final;
	}
	public void setSw_Final(Date sw_Final) {
		this.sw_Final = sw_Final;
	}
	
	
}
