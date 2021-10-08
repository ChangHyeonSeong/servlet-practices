<%@page import="java.time.LocalDateTime"%>
<%@page import="com.douzone.guestbook01.vo.GuestBook01Vo"%>
<%@page import="com.douzone.guestbook01.dao.GuestBook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String message = request.getParameter("message");
    String regDate = LocalDateTime.now().toString();
    
    GuestBook01Vo vo = new GuestBook01Vo();
    vo.setName(name);
    vo.setPassword(password);
    vo.setMessage(message);
    vo.setRegDate(regDate);
    
    new GuestBook01Dao().insert(vo);
    
    response.sendRedirect("/guestbook01");
%>   
