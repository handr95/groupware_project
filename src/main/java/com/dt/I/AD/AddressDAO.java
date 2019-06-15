package com.dt.I.AD;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {
	@Autowired
	private SqlSession session;
	
	
	public boolean intConvert(int value){
		return (value!=0)?true:false;
	}
	
	public List<AddressBean> getAddressList(AddressBean addressbean){
		return session.selectList("AddrBook.getAddressList", addressbean);
	}
	public List<Member> addressSearchList(AddressBean addressbean){
		return session.selectList("AddrBook.addressSearchList", addressbean);
	}
	
	public boolean addressMyInsert(AddressBean addressbean){
		return intConvert(session.insert("AddrBook.addressMyInsert", addressbean));
	}
	public boolean addressYouInsert(AddressBean addressbean){
		return intConvert(session.insert("AddrBook.addressYouInsert", addressbean));
	}
	public boolean addressInsertAll(AddressBean addressbean){
		return intConvert(session.insert("AddrBook.addressInsertAll", addressbean));
		
		
		
	}
	public boolean addressDelete(AddressBean addressbean){
		return intConvert(session.delete("AddrBook.addressDelete", addressbean));
	}
	public boolean addressMyAllow(AddressBean addressbean){
		return intConvert(session.update("AddrBook.addressMyAllow", addressbean));
	}
	public boolean addressYouAllow(AddressBean addressbean){
		return intConvert(session.update("AddrBook.addressYouAllow", addressbean));
	}
	public boolean addressMyRefuse(AddressBean addressbean){
		return intConvert(session.update("AddrBook.addressMyRefuse", addressbean));
	}
	public boolean addressYouRefuse(AddressBean addressbean){
		return intConvert(session.update("AddrBook.addressYouRefuse", addressbean));
	}
}
