package com.dt.D.DC;

import java.sql.Date;

public class DataComm {
	private String d_Code;	//자료실 코드
	private String m_Email; //누가 올린지 알아 보기 위함(팀), 누구의 개인 것인지 알기 위함(개인)
	private String c_Class; //공개유무
	private String d_Content; //자료실 내용
	private Date d_Since; //자료실 만든 날짜
	private String d_Title; //자료실 이름
	private String t_Code; //팀 코드
	private String d_Path; //경로 
	private String d_Data; // 파일?
	public String getD_Code() {
		return d_Code;
	}
	public void setD_Code(String d_Code) {
		this.d_Code = d_Code;
	}
	public String getM_Email() {
		return m_Email;
	}
	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
	}
	public String getC_Class() {
		return c_Class;
	}
	public void setC_Class(String c_Class) {
		this.c_Class = c_Class;
	}
	public String getD_Content() {
		return d_Content;
	}
	public void setD_Content(String d_Content) {
		this.d_Content = d_Content;
	}
	public Date getD_Since() {
		return d_Since;
	}
	public void setD_Since(Date d_Since) {
		this.d_Since = d_Since;
	}
	public String getD_Title() {
		return d_Title;
	}
	public void setD_Title(String d_Title) {
		this.d_Title = d_Title;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getD_Path() {
		return d_Path;
	}
	public void setD_Path(String d_Path) {
		this.d_Path = d_Path;
	}
	public String getD_Data() {
		return d_Data;
	}
	public void setD_Data(String d_Data) {
		this.d_Data = d_Data;
	}
	
}
