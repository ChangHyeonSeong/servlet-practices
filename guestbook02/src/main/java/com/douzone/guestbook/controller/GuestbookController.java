package com.douzone.guestbook.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;



public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		String action = request.getParameter("a");
		
		if("deleteform".equals(action)) {
			String no = request.getParameter("no");
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp?no=" + no);
			rd.forward(request, response);
			
		} else if("add".equals(action)) {
			String name = request.getParameter("name");
		    String password = request.getParameter("password");
		    String message = request.getParameter("message");
		    String regDate = LocalDateTime.now().toString();
		    
		    GuestBookVo vo = new GuestBookVo();
		    vo.setName(name);
		    vo.setPassword(password);
		    vo.setMessage(message);
		    vo.setRegDate(regDate);
		    
		    new GuestBookDao().insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
		} else if("delete".equals(action)) {
			    String no = request.getParameter("no");
			    String password = request.getParameter("password");
			    
			    
			    GuestBookVo vo = new GuestBookVo();
			    vo.setNo(Long.parseLong(no));
			    vo.setPassword(password);
			    
			    
			    new GuestBookDao().delete(vo);
			    
			    response.sendRedirect("/guestbook02/gb");
		} else {
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.findAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
