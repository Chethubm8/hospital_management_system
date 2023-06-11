package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.getWriter().print("<h1> <a href='home'>Home<button></button></a></h1>");
		Cookie cookie=new Cookie("x", "1");
		cookie.setMaxAge(10);
		resp.addCookie(cookie);
		resp.getWriter().print("<h1><a href='home'><button>clic here for home page</button></a></h1>");
	}

}
