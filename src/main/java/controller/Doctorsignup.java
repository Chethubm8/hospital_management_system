package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;
import dto.Doctor;

@WebServlet("/doctorsignup")
public class Doctorsignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Mydao dao = new Mydao();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		Date dob=Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String qualification = req.getParameter("qualification");
		String specilization = req.getParameter("specilization");

		int age = Period.between(dob.toLocalDate(),LocalDate.now()).getYears();

		if (dao.fetchDoctor(mobile) == null && dao.fetchByEmail(email) == null
				&& dao.fetchByMobile(mobile) == null && dao.fetchByEmail(email) == null) {
			Doctor doctor = new Doctor();
			doctor.setName(name);
			doctor.setDob(dob);
			doctor.setMobile(mobile);
			doctor.setEmail(email);
			doctor.setPassword(password);
			doctor.setQualification(qualification);
			doctor.setSpecilization(specilization);
			doctor.setGender(gender);

			dao.saveDoctor(doctor);
			resp.getWriter().print("<h1>doctot account created successfully,wait for admin approval</h1>");
			resp.getWriter().print("<h1>your doctorid is:" + doctor.getId() + "</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);

		}

		else {
			resp.getWriter().print("<h1>Mobile number or email invalid</h1>");
			req.getRequestDispatcher("doctor_signup.html").include(req, resp);
		}

	}

}
