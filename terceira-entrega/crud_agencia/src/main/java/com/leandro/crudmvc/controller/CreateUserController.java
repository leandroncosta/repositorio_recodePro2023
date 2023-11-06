package com.leandro.crudmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leandro.crudmvc.model.UserModel;
import com.leandro.crudmvc.model.dao.UserDAO;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
@WebServlet("/user/create")
public class CreateUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String root = "/crud_agencia";

	public CreateUserController() {
		super();

	};

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var view = request.getRequestDispatcher("/register.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var email2 = request.getParameter("email2");
		var type = request.getParameter("type");
		var password = request.getParameter("password");
		var part = request.getPart("file");

		String fileName = part.getSubmittedFileName();
		String path = request.getServletContext().getRealPath("") + "upload";

		try {
			File file = new File(path);
			part.write(path + File.separator + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}

		var imagePath = "upload/" + fileName;

		UserModel user = new UserModel(name, email, email2, type, imagePath, password);

		UserDAO.save(user);

		response.sendRedirect("../users");

	}

}
