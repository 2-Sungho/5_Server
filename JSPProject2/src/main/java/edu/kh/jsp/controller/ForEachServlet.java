package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/forEach")
public class ForEachServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Person> pList=new ArrayList<>();
		
		pList.add(new Person("홍길동", 25, "서울시 중구"));
		pList.add(new Person("우동현", 28, "서울시 강서구"));
		pList.add(new Person("이성호", 25, "경기도 군포시"));
		pList.add(new Person("김석환", 26, "서울시 강남구"));
		pList.add(new Person("이지형", 27, "서울시 강동구"));
		
		req.setAttribute("pList", pList); // request에 값 세팅
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/views/forEach.jsp");
		
		dispatcher.forward(req, resp);
	}
}
