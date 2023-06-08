package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		Mydao dao = new Mydao();
		Doctor doctor = dao.fetchDoctor(id);
		Staff staff = dao.fetchStaff(id);
		if (staff == null && doctor == null && id != 999999)
		{
			resp.getWriter().print("<h1>style='color:red'incorrect Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);

		}
		else
		{
			if (staff != null) 
			{
				if (staff.getPassword().equals(password)) 
				{
					if (staff.isStatus()) 
					{
						resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
						req.getRequestDispatcher("staffhome.html").include(req, resp);
					} 
					else
					{
						resp.getWriter().print("<h1 style='color:red'>wait for admin approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
				}
			
			else 
			{
				resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		if (doctor != null) {
			if (doctor.getPassword().equals(password)) {
				if (doctor.isStatus()) {
					resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
					req.getRequestDispatcher("Doctorhome.html").include(req, resp);
				} 
				else {
					resp.getWriter().print("<h1 style='color:red'>wait for admin approval</h1>");
					req.getRequestDispatcher("Doctorhome.html").include(req, resp);
				}
			}
		 else {
			resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		}
		if (id==999999) {
			if ("999999".equals(password)) {
				resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
				req.getRequestDispatcher("Adminhome.html").include(req, resp);
			} 
			else 
			{
				resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
	}
}
}

