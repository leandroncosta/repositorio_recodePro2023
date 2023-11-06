package com.leandro.crudmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leandro.crudmvc.model.dao.UserDAO;

@WebServlet("/users")
public class FindUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindUserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var search = request.getParameter("search");

		if (search == null) {
			search = "";
		}

		var users = UserDAO.findAll(search);

		request.setAttribute("users", users);
		RequestDispatcher view = request.getRequestDispatcher("users.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
