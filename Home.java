package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class Home extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] c=req.getCookies();
		boolean flag=false;
		for(Cookie cookie:c)
		{
			if(cookie.getName().equals("x")){
				flag=true;
				break;
			}
		}
	
	if(flag)
	{
	resp.getWriter().print("<h1> This is Home</h1>");
	resp.getWriter().print("<h1><a href='settings'><button>click here for settings</button></a></h1>");
	resp.getWriter().print("<h1><a href='login'><button>logout</button></a></h1>");
	}
	else{
		resp.getWriter().print("<h1>First login</h1>");
		req.getRequestDispatcher("login").include(req, resp);
	}
	}
	}
