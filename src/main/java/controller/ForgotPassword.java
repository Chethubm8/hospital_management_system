package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Mydao;
import dto.Doctor;
import dto.Staff;
@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		String Password = req.getParameter("password");

		Mydao dao = new Mydao();

		Doctor doctor = dao.fetchDoctor(id);
		Staff staff = dao.fetchStaff(id);

		if (doctor == null && staff == null)
		{
			resp.getWriter().print("<h1 style='color:red'>Invalid Id</h1>");
			req.getRequestDispatcher("ForgotPassword.html").include(req, resp);
		} 
		else 
		{
			if (doctor != null) {
				if (doctor.getName().equals(name) && doctor.getMobile() == mobile && doctor.getDob().equals(dob)) 
				{
					doctor.setPassword(Password);
					dao.update(doctor);
					resp.getWriter().print("<h1 style='color:green'>Password reset sucessfully</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}

				else {
					resp.getWriter().print("<h1 style='color:red'>Invalid Details Can not set new Password</h1>");
					req.getRequestDispatcher("ForgotPassword.html").include(req, resp);
				}
			} 
			else {
				if (staff.getName().equals(name) && staff.getMobile() == mobile && staff.getDob().equals(dob))
				{
					staff.setPassword(Password);
					dao.updateStaff(staff);
					resp.getWriter().print("<h1 style='color:green'>Password reset sucessfully</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			
				else {
					resp.getWriter().print("<h1 style='color:red'>Invalid Details Can not set new Password</h1>");
					req.getRequestDispatcher("ForgotPassword.html").include(req, resp);
				}
			}

		}
	}
}
