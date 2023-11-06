package com.leandro.crudmvc.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leandro.crudmvc.model.dao.UserDAO;

@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var id = request.getParameter("userId");

		if (id == null) {
			return;
		}

		UserDAO.deleteById(Long.parseLong(id));

		response.sendRedirect("../users");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
