package com.servlet;

import java.io.IOException;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String ps = req.getParameter("ps");
			String qua = req.getParameter("qua");
			int id = Integer.parseInt(req.getParameter("id"));
			
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			User u = new User();
			u.setId(id);
			u.setName(name);
			u.setEmail(email);
			u.setPassword(ps);
			u.setQualification(qua);
			
			boolean f = dao.updateProfile(u);
			
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Profile Update Successfull....");
				resp.sendRedirect("user_home.jsp");
				
			} else {
				session.setAttribute("succMsg", "Somthing went wrong");
				resp.sendRedirect("user_home.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
