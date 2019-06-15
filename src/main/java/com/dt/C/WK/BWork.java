package com.dt.C.WK;

import java.sql.Date;


public class BWork {
	private String bw_Code; //업무 코드
	private String t_Code; //팀코드
	private String pj_Code; //프로젝트 코드
	private String bw_Share; //공개 유무
	private String bw_Progress; //진행사항
	private String bw_Email; //작성자
	private String bw_Title; 
	private String bw_Content;
	private String bw_Owner; //책임자
	private Date bw_Start; //시작일
	private Date bw_Limit; //마감일
	private Date bw_Final; //완료일
	
	public String getBw_Code() {
		return bw_Code;
	}
	public void setBw_Code(String bw_Code) {
		this.bw_Code = bw_Code;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getPj_Code() {
		return pj_Code;
	}
	public void setPj_Code(String pj_Code) {
		this.pj_Code = pj_Code;
	}
	public String getBw_Share() {
		return bw_Share;
	}
	public void setBw_Share(String bw_Share) {
		this.bw_Share = bw_Share;
	}
	public String getBw_Progress() {
		return bw_Progress;
	}
	public void setBw_Progress(String bw_Progress) {
		this.bw_Progress = bw_Progress;
	}
	public String getBw_Email() {
		return bw_Email;
	}
	public void setBw_Email(String bw_Email) {
		this.bw_Email = bw_Email;
	}
	public String getBw_Title() {
		return bw_Title;
	}
	public void setBw_Title(String bw_Title) {
		this.bw_Title = bw_Title;
	}
	public String getBw_Content() {
		return bw_Content;
	}
	public void setBw_Content(String bw_Content) {
		this.bw_Content = bw_Content;
	}
	public Date getBw_Start() {
		return bw_Start;
	}
	public void setBw_Start(Date bw_Start) {
		this.bw_Start = bw_Start;
	}
	public Date getBw_Limit() {
		return bw_Limit;
	}
	public void setBw_Limit(Date bw_Limit) {
		this.bw_Limit = bw_Limit;
	}
	public Date getBw_Final() {
		return bw_Final;
	}
	public void setBw_Final(Date bw_Final) {
		this.bw_Final = bw_Final;
	}
	

	public String getBw_Owner() {
		return bw_Owner;
	}
	public void setBw_Owner(String bw_Owner) {
		this.bw_Owner = bw_Owner;
	}
	
	
	
	
}
