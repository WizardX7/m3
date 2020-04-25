package com.capg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op1=Integer.parseInt(request.getParameter("op1"));
		int op2=Integer.parseInt(request.getParameter("op2"));
		int add=op1+op2;
        response.setContentType("text/html");
        int sub=op1-op2;
        response.setContentType("text/html");
		int mul=op1*op2;
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<P>Addtion is:"+add+"</p>");
		out.println("<P>Subtraction is:"+sub+"</p>");
		out.println("<P>Multiplication is:"+mul+"</p>");
		out.println("</body></html>");
		out.close();
	}
}
		
