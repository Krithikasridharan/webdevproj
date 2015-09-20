package com.tcs.ilp.tsi.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.tsi.dao.LoginDAO;
import com.tcs.ilp.tsi.vo.LoginVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs=null;
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("pwd");
		LoginVO vo=new LoginVO();
		LoginDAO dao=new LoginDAO();
		
		
		try
		{
			response.setHeader("Cache-Control","no-store"); 
		    response.setHeader("Pragma","no-cache"); 
		    response.setDateHeader ("Expires", 0); 
		    
		    response.setContentType("text/html");
			vo.setUser_name(name);
			vo.setPassword(pass);
			rs=dao.loginPage(vo);
			
			if(rs.next())
			{
				
				String tname=rs.getString("user_name");
				
				String tpwd=rs.getString("password");
				if(name.equalsIgnoreCase(tname)&&pass.equalsIgnoreCase(tpwd))
				{
					HttpSession session = null;
					request.getSession().setAttribute("name",name);
					response.sendRedirect("jsp/home.jsp");
				}
				
			}
			else
			{
				String message="Username or Password is incorrect. ";
				response.sendRedirect("jsp/index.jsp?error="+message);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
