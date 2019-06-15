package com.dt.E.BO;

public class BoardPost {

	private String bp_Code;
	private String bp_Email;
	private String t_Code;
	private String bp_Share;
	private String bp_Title;
	private String bp_Content;
	
	private String ms_Code;
	private String ms_Mpcode;
	private String ms_Memail;
	private String[] ms_Content;
	
	
	
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
