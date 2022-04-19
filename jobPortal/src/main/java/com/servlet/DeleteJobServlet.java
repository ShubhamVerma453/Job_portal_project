package com.servlet;

import java.io.IOException;

import com.dao.JobDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f = dao.deleteJobById(id);
			
			HttpSession session = req.getSession();
			
			if (f) {
				session.setAttribute("succMsg", "Job delete Succ....");
				resp.sendRedirect("view_jobs.jsp");

			} else {
				session.setAttribute("succMsg", "Somthing went wrong");
				resp.sendRedirect("view_jobs.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
