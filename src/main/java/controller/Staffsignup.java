package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Staff;
@WebServlet("/staffsignup")
public class Staffsignup  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("dob"));
		String gender=req.getParameter("gender");
		
		
//		int age=LocalDate.now().getYear()-dob.toLocalDate().getYear();(tocalculatte only the year based)
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Mydao dao=new Mydao();
		if(dao.fetchByMobile(mobile)==null&&dao.fetchByEmail(email)==null){
		Staff staff=new Staff();
		staff.setName(name);
		staff.setMobile(mobile);
		staff.setEmail(email);
		staff.setPassword(password);
		staff.setDob(dob);
		staff.setPassword(password);
        staff.setAge(age);
        
        
        dao.saveStaff(staff);
        
        resp.getWriter().print("<h1>staff account created successfully,wait for admin approval</h1>");
        resp.getWriter().print("<h1>your staffid is:"+staff.getId()+"</h1>");
        req.getRequestDispatcher("Login.html").include(req, resp);
        }
		else{
			resp.getWriter().print("<h1>MobileNumber or email already exist</h1>");
			req.getRequestDispatcher("staff_Signup.html").include(req, resp);
		}
}
	
}