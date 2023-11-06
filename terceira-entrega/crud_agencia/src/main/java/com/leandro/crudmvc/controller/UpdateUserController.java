package com.leandro.crudmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leandro.crudmvc.model.dao.UserDAO;

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var id = request.getParameter("userId");

		if (id == null) {
			return;
		}

		var user = UserDAO.findById(Long.parseLong(id));
		System.out.println(user.toString());

		request.setAttribute("user", user);
		RequestDispatcher view = request.getRequestDispatcher("/userUpdate.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var id = request.getParameter("id");
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var email2 = request.getParameter("email2");
		var type = request.getParameter("type");

		var user = UserDAO.findById(Long.parseLong(id));

		user.setNome(name);
		user.setEmail(email);
		user.setEmailSecundario(email2);
		user.setTipo(type);

		UserDAO.update(user);

		response.sendRedirect("../users");
	}

}
