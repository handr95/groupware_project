package com.dt.E.BO;



import java.sql.Date;



public class Board {
	
	

	private String bd_Code;
	private String bp_Code;
	
	private String t_Code;
	private String bd_Email;
	
	private String bd_Title;
	private String bd_Writter;
	private Date bd_Since;
	private String bd_Content;
	private String bd_Share;
	

	private String ms_Code;
	private String ms_Mpcode;
	private String ms_Memail;
	private String[] ms_Content;
	private String ms_Content2;
	
	
	
	
	public String getMs_Content2() {
		return ms_Content2;
	}
	public void setMs_Content2(String ms_Content2) {
		this.ms_Content2 = ms_Content2;
	}
	public String getMs_Code() {
		return ms_Code;
	}
	public void setMs_Code(String ms_Code) {
		this.ms_Code = ms_Code;
	}
	public String getMs_Mpcode() {
		return ms_Mpcode;
	}
	public void setMs_Mpcode(String ms_Mpcode) {
		this.ms_Mpcode = ms_Mpcode;
	}
	public String getMs_Memail() {
		return ms_Memail;
	}
	public void setMs_Memail(String ms_Memail) {
		this.ms_Memail = ms_Memail;
	}
	public String[] getMs_Content() {
		return ms_Content;
	}
	public void setMs_Content(String[] ms_Content) {
		this.ms_Content = ms_Content;
	}
	public String getBd_Code() {
		return bd_Code;
	}
	public void setBd_Code(String bd_Code) {
		this.bd_Code = bd_Code;
	}
	public String getT_Code() {
		return t_Code;
	}
	public void setT_Code(String t_Code) {
		this.t_Code = t_Code;
	}
	public String getBd_Email() {
		return bd_Email;
	}
	public void setBd_Email(String bd_Email) {
		this.bd_Email = bd_Email;
	}
	public String getBd_Title() {
		return bd_Title;
	}
	public void setBd_Title(String bd_Title) {
		this.bd_Title = bd_Title;
	}
	public String getBd_Writter() {
		return bd_Writter;
	}
	public void setBd_Writter(String bd_Writter) {
		this.bd_Writter = bd_Writter;
	}
	public Date getBd_Since() {
		return bd_Since;
	}
	public void setBd_Since(Date bd_Since) {
		this.bd_Since = bd_Since;
	}
	public String getBd_Content() {
		return bd_Content;
	}
	public void setBd_Content(String bd_Content) {
		this.bd_Content = bd_Content;
	}
	
	
	

	public String getBp_Code() {
		return bp_Code;
	}
	public void setBp_Code(String bp_Code) {
		this.bp_Code = bp_Code;
	}
	public String getBd_Share() {
		return bd_Share;
	}
	public void setBd_Share(String bd_Share) {
		this.bd_Share = bd_Share;
	}
	
}
