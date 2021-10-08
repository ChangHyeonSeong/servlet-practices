package com.douzone.emaillist.dao;

import java.util.List;

import com.douzone.emaillist.vo.EmaillistVo;

public class EmaillistDaoTest {

	public static void main(String[] args) {
		//insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for (EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
        EmaillistVo vo = new EmaillistVo();
        vo.setFirstName("마");
        vo.setLastName("마이콜");
        vo.setEmail("michol@gmial.com");
        
        
        new EmaillistDao().insert(vo);
		
	}
	
	

}
