package com.douzone.guestbook01.daotest;

import java.util.List;

import com.douzone.guestbook01.dao.GuestBook01Dao;
import com.douzone.guestbook01.vo.GuestBook01Vo;


public class GuestBook01DaoTest {

	public static void main(String[] args) {
		//insertTest();
		deleteTest();
		findAllTest();
	}
	
	private static void insertTest() {
		GuestBook01Vo vo = null;
		GuestBook01Dao dao = new GuestBook01Dao();
	
		vo = new GuestBook01Vo();
        vo.setName("강건마");
        vo.setPassword("2312");
        vo.setMessage("더이상 설명은 생략한다");
        vo.setRegDate("2021-10-08");
		dao.insert(vo);


	}
	
	private static void findAllTest() {
		List<GuestBook01Vo> list = new GuestBook01Dao().findAll();
		
		for(GuestBook01Vo vo : list) {
		   	System.out.println(vo);
		}
	}
	
	private static void deleteTest() {
		GuestBook01Vo vo = null;
		GuestBook01Dao dao = new GuestBook01Dao();
	
		vo = new GuestBook01Vo();
		vo.setNo(5L);
	    vo.setPassword("1234");
	    
	    dao.delete(vo);
	}


}
