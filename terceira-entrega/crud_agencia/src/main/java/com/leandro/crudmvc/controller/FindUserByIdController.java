package com.leandro.crudmvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leandro.crudmvc.model.dao.UserDAO;

@WebServlet("/user")
public class FindUserByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindUserByIdController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var user = UserDAO.findById(Long.parseLong(request.getParameter("userId")));

		request.setAttribute("user", user);
		var view = request.getRequestDispatcher("userDetails.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
