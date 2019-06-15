package com.dt.L.MI;

import java.sql.Date;

public class BoardPost {

	private String bp_Code;
	private String bp_Email;
	private String t_Code;
	private String bp_Share;
	private String bp_Title;
	private String bp_Content;
	private Date bp_Since;
	private String[] tm_memail2;
	private String bp_Cltype;
	private String cl_Comment;
	

	public String getCl_Comment() {
		return cl_Comment;
	}
	public void setCl_Comment(String cl_Comment) {
		this.cl_Comment = cl_Comment;
	}
	public String getBp_Cltype() {
		return bp_Cltype;
	}
	public void setBp_Cltype(String bp_Cltype) {
		this.bp_Cltype = bp_Cltype;
	}
	public String[] getTm_memail2() {
		return tm_memail2;
	}
	public void setTm_memail2(String[] tm_memail2) {
		this.tm_memail2 = tm_memail2;
	}
	public Date getBp_Since() {
		return bp_Since;
	}
	public void setBp_Since(Date bp_Since) {
		this.bp_Since = bp_Since;
	}
	public String getBp_Code() {
		return bp_Code;
	}
	public void setBp_Code(String bp_Code) {
		this.bp_Code = bp_Code;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getBp_Title() {
		return bp_Title;
	}
	public void setBp_Title(String bp_Title) {
		this.bp_Title = bp_Title;
	}
	public String getBp_Content() {
		return bp_Content;
	}
	public void setBp_Content(String bp_Content) {
		this.bp_Content = bp_Content;
	}
	public String getBp_Email() {
		return bp_Email;
	}
	public void setBp_Email(String bp_Email) {
		this.bp_Email = bp_Email;
	}
	public String getBp_Share() {
		return bp_Share;
	}
	public void setBp_Share(String bp_Share) {
		this.bp_Share = bp_Share;
	}
	
	
	
}
