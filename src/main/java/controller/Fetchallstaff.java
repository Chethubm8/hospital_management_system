package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Staff;
@WebServlet("/fetchallstaff")
public class Fetchallstaff extends HttpServlet {
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Mydao dao=new Mydao();
		List<Staff> list=dao.fetchallStaff();
		if(list.isEmpty()){
			resp.getWriter().print("<h1> no staff has signed up </h1>");
			req.getRequestDispatcher("Adminhome.html").include(req, resp);
	}
		else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("Aprovestaff.jsp").include(req, resp);
		}
	}

}
