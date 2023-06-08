package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Staff;
@WebServlet("/changestaffstatus")
public class changeStaffstatus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Mydao dao=new Mydao();
		Staff staff=dao.fetchStaff(id);
		if(staff.isStatus())
			staff.setStatus(false);
		else
			staff.setStatus(true);
		dao.updateStaff(staff);
		resp.getWriter().print("<h1 style:'color:green'>updated successfully</h1>");
		req.setAttribute("list",dao.fetchallStaff());
		req.getRequestDispatcher("Aprovestaff.jsp").include(req, resp);
	}
	
	
	
	
}

