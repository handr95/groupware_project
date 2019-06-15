package com.dt.N.TI;

import java.util.Date;

public class Team {
	private String t_code;
	private String t_memail;
	private String t_name;
	private String tm_memail;
	private String[] tm_memail2;//혹시 몰라서	
	private String tm_mnickname;
	private String tm_grtype;
	private String tm_grname;
	private String tm_name;
	private Date t_since;
	private Date tm_litime;
	
	
	
	public String getTm_name() {
		return tm_name;
	}
	public void setTm_name(String tm_name) {
		this.tm_name = tm_name;
	}
	public String getT_code() {
		return t_code;
	}
	public void setT_code(String t_code) {
		this.t_code = t_code;
	}
	public String getT_memail() {
		return t_memail;
	}
	public void setT_memail(String t_memail) {
		this.t_memail = t_memail;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	public String getTm_memail() {
		return tm_memail;
	}
	public void setTm_memail(String tm_memail) {
		this.tm_memail = tm_memail;
	}
	public String[] getTm_memail2() {
		return tm_memail2;
	}
	public void setTm_memail2(String[] tm_memail2) {
		this.tm_memail2 = tm_memail2;
	}
	public String getTm_mnickname() {
		return tm_mnickname;
	}
	public void setTm_mnickname(String tm_mnickname) {
		this.tm_mnickname = tm_mnickname;
	}
	public String getTm_grtype() {
		return tm_grtype;
	}
	public void setTm_grtype(String tm_grtype) {
		this.tm_grtype = tm_grtype;
	}
	public String getTm_grname() {
		return tm_grname;
	}
	public void setTm_grname(String tm_grname) {
		this.tm_grname = tm_grname;
	}
	public Date getT_since() {
		return t_since;
	}
	public void setT_since(Date t_since) {
		this.t_since = t_since;
	}
	public Date getTm_litime() {
		return tm_litime;
	}
	public void setTm_litime(Date tm_litime) {
		this.tm_litime = tm_litime;
	}
	
	
}
