<%@page import="com.douzone.guestbook01.vo.GuestBook01Vo"%>
<%@page import="com.douzone.guestbook01.dao.GuestBook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
    String no = request.getParameter("no");
    String password = request.getParameter("password");
    
    
    GuestBook01Vo vo = new GuestBook01Vo();
    vo.setNo(Long.parseLong(no));
    vo.setPassword(password);
    
    
    new GuestBook01Dao().delete(vo);
    
    response.sendRedirect("/guestbook01");
%>