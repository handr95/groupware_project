package com.dt.G.CA;

import java.sql.Date;



public class Calendar {
	private String c_Code;
	private String c_Title;
	private Date c_Start;
	private Date c_Limit;
	private String c_Loc;
	private String c_Comment;
	private String c_Class;
	private String c_Email;
	private String t_Code;
	private String[] c_Admin;
	private String year;
	private String month;
	private String day;
	private String current;
	
	
	
	
	
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getC_Code() {
		return c_Code;
	}
	public void setC_Code(String c_Code) {
		this.c_Code = c_Code;
	}
	public String getC_Title() {
		return c_Title;
	}
	public void setC_Title(String c_Title) {
		this.c_Title = c_Title;
	}
	public Date getC_Start() {
		return c_Start;
	}
	public void setC_Start(Date c_Start) {
		this.c_Start = c_Start;
	}
	public Date getC_Limit() {
		return c_Limit;
	}
	public void setC_Limit(Date c_Limit) {
		this.c_Limit = c_Limit;
	}
	public String getC_Loc() {
		return c_Loc;
	}
	public void setC_Loc(String c_Loc) {
		this.c_Loc = c_Loc;
	}
	public String getC_Comment() {
		return c_Comment;
	}
	public void setC_Comment(String c_Comment) {
		this.c_Comment = c_Comment;
	}
	public String getC_Class() {
		return c_Class;
	}
	public void setC_Class(String c_Class) {
		this.c_Class = c_Class;
	}
	public String getC_Email() {
		return c_Email;
	}
	public void setC_Email(String c_Email) {
		this.c_Email = c_Email;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String[] getC_Admin() {
		return c_Admin;
	}
	public void setC_Admin(String[] c_Admin) {
		this.c_Admin = c_Admin;
	}

	
}