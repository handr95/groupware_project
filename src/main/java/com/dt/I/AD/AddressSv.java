package com.dt.I.AD;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


@Service
public class AddressSv {
	@Autowired
	private AddressDAO ADDAO;
	@Autowired
	private HttpServletRequest request;
	private ModelAndView mav;
	private String sessionmid;
	private String grade1;
	private String sessionteam;
	private String grade2;
	private String sessionnickname;
	
	
	public ModelAndView excute(int type, AddressBean addressbean) {
		sessionmid = (String)request.getSession().getAttribute("sessionmid");
		grade1 = (String)request.getSession().getAttribute("grade1");
		sessionteam= (String)request.getSession().getAttribute("sessionteam");
		grade2= (String)request.getSession().getAttribute("grade2");
		sessionnickname = (String)request.getSession().getAttribute("sessionnickname");		
		if(sessionmid==null)
			return new ModelAndView("/main/main");	
		if(sessionteam==null)
			return new ModelAndView("/main/main");
		mav=new ModelAndView();
		switch (type) {
		case 1:
			addressform(addressbean);
			break;
		case 2:
			addressSearch(addressbean);
			break;
		case 3:
			addressMyInsert(addressbean);
			break;
		case 4:
			addressInsertAll(addressbean);
			break;
		case 5:
			addressDelete(addressbean);
			break;
		case 6:
			addressMyAllow(addressbean);
			break;
		case 7:
			addressMyRefuse(addressbean);
			break;
		
		default:

		}

		return mav;
	}
	private void addressform(AddressBean addressbean){
		//mav=new ModelAndView();		
		//sessionmid =request.getSession().getAttribute("mid");
		//sessionmid ="hdr@naver.com";
		System.out.println("ddd");
		addressbean.setAb_MyMemail(sessionmid);
		List<AddressBean> addresslist = ADDAO.getAddressList(addressbean);
		System.out.println(addressbean.getAb_MyMemail());
		mav.setViewName("my/FriendList");
		mav.addObject("addressform",addrBook_View(addresslist));
		
		/* 주소록에 있는 친구의 정보를 다 가져온다.
		 * getAddressList */
		
	}
	private void addressSearch(AddressBean addressbean){
		//mav=new ModelAndView();
		System.out.println(addressbean.getAb_MEMAIL());
		List<Member> memberSearch = ADDAO.addressSearchList(addressbean);
		System.out.println(memberSearch.size());
		mav.setViewName("my/FriendList");
		if(memberSearch.size()==0){
			mav.addObject("addressSearch","아이디를 확인해주세요");
		}else{
			//sessionmid ="hdr@naver.com";
			addressbean.setAb_MyMemail(sessionmid);
			List<AddressBean> addresslist = ADDAO.getAddressList(addressbean);
			for(AddressBean addr : addresslist){
				if(addr.getAb_MyMemail().equals(addressbean.getAb_MyMemail()) &&
					addr.getAb_MEMAIL().equals(addressbean.getAb_MEMAIL())){
					mav.addObject("addressSearch",memberSearch(memberSearch,"T"));
					return;
				}
			}
			mav.addObject("addressSearch",memberSearch(memberSearch,"F"));
		}
		
		/* 친구검색
		 *  addressSearchList */
		
	}
	private void addressMyInsert(AddressBean addressbean){
		//mav=new ModelAndView();
		//sessionmid ="hdr@naver.com";
		System.out.println(addressbean.getAb_MEMAIL());
		
		addressbean.setAb_MyMemail(sessionmid);
		if(ADDAO.addressMyInsert(addressbean)) {
			ADDAO.addressYouInsert(addressbean);
		}else{
			mav.addObject("addressbean","등록에 실패했습니다.");
		}
		
		/* 검색한 친구를 주소록에 추가 (실질적인 친구추가)
		 * addressInsert
		 * */
		addressform(addressbean);
		
	}
		
	
	private void addressInsertAll(AddressBean addressbean){
		mav=new ModelAndView();
	
	
		
		
	}
	private void addressDelete(AddressBean addressbean){
		//mav=new ModelAndView();
		//sessionmid = "hdr@naver.com";
		addressbean.setAb_MyMemail(sessionmid);
		if(ADDAO.addressDelete(addressbean)) {
			mav.addObject("addressbean","삭제되었습니다");
		}
		addressform(addressbean);
		/* 주소록에 등록된 친구를 삭제 
		 * addressDelete */
	}
	private void addressMyAllow(AddressBean addressbean){
		//mav=new ModelAndView();
		//sessionmid ="hdr@naver.com";
		addressbean.setAb_MyMemail(sessionmid);
		if(ADDAO.addressMyAllow(addressbean)) {
			ADDAO.addressYouAllow(addressbean);
		}else{
			mav.addObject("addressbean");
		}
		
		/* 친구요청 허락 
		 * addressAllow */
		addressform(addressbean);
	}
	
	private void addressMyRefuse(AddressBean addressbean){
		//mav=new ModelAndView();
		//sessionmid ="hdr@naver.com";
		
		addressbean.setAb_MyMemail(sessionmid);
		if(ADDAO.addressMyRefuse(addressbean)) {
			ADDAO.addressYouRefuse(addressbean);
		}else{
			mav.addObject("addressbean");
		}
		
		/* 친구요청 거절 
		 * addressRefuse */
		addressform(addressbean);	
	}
	
	private String addrBook_View(List<AddressBean> addressBean){
		StringBuffer sb = new StringBuffer();
		for(int index=0; index<addressBean.size(); index++){
			if(!addressBean.get(index).getAb_MyMemail().equals(addressBean.get(index).getAb_MEMAIL())){			
				sb.append(addressBean.get(index).getAb_MNICKNAME()+"&nbsp;");
				sb.append(addressBean.get(index).getCl_Comment()+"&nbsp;");
				sb.append(addressBean.get(index).getAb_LTIME()+"&nbsp;");
				if(addressBean.get(index).getAb_CHECK().equals("DF  ")) {
					System.out.println(addressBean.get(index).getAb_CHECK());
					sb.append("<input type='button' value='수락' onclick='location.href=\"/addressAllow?ab_MEMAIL="+addressBean.get(index).getAb_MEMAIL()+"\"'>");
					sb.append("<input type='button' value='거절' onclick='location.href=\"/addressRefuse?ab_MEMAIL="+addressBean.get(index).getAb_MEMAIL()+"\"'>");
				}
				sb.append("<input type='button' value='끊기' onclick='location.href=\"/addressDelete?ab_MEMAIL="+addressBean.get(index).getAb_MEMAIL()+"\"'><br/>");
			}
		}
		
		return sb.toString();
	}
	private String memberSearch(List<Member> member,String type) {
		StringBuffer sb = new StringBuffer();
		if(type.equals("T")){
			for(int index=0; index<member.size(); index++) {
				System.out.println(index);
				sb.append(member.get(index).getM_EMAIL());
				sb.append(member.get(index).getM_NICKNAME());
				sb.append("이미 신청 혹은 등록한 친구입니다.");
				//sb.append("<a href='/addressMyInsert?ab_MEMAIL="+member.get(index).getM_EMAIL()+"'><input type='button' value='등록'></a>");
			}
		}else if(type.equals("F")){
			System.out.println(member.get(0).getM_EMAIL());
			for(int index=0; index<member.size(); index++) {
				System.out.println(index);
				sb.append(member.get(index).getM_EMAIL());
				sb.append(member.get(index).getM_NICKNAME());
				
				sb.append("<a href='/addressMyInsert?ab_MEMAIL="+member.get(index).getM_EMAIL()+"'><input type='button' value='등록'></a>");
			}
		}		
		return sb.toString();
		
	}

}
