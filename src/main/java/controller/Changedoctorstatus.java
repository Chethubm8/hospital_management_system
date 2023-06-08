package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Doctor;
@WebServlet("/changedoctorstatus")
public class Changedoctorstatus  extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id=Integer.parseInt(req.getParameter("id"));
			Mydao dao=new Mydao();
			Doctor doctor=dao.fetchDoctor(id);
			if(doctor.isStatus())
				doctor.setStatus(false);
			else
				doctor.setStatus(true);
			dao.updateDoctor(doctor);
			resp.getWriter().print("<h1 style:'color:green'>updated successfully</h1>");
			req.setAttribute("list",dao.fetchalldoctor());
			req.getRequestDispatcher("Aprovedoctor.jsp").include(req, resp);
		}
}
