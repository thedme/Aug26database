package com.servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animalsinthezoo.Animal;
import com.animalsinthezoo.DAO;

/**
 * Servlet implementation class AddToDb
 */
@WebServlet("/AddToDb")
public class AddToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
Animal addTodb = new Animal();
		
		addTodb.setSpecies(request.getParameter("species"));
		addTodb.setType_of_cage(request.getParameter("Type_of_cage"));
		addTodb.setFood(request.getParameter("food"));
		addTodb.setName(request.getParameter("name"));
		addTodb.setWeight(request.getParameter("weight"));
		
		DAO.writeToDB(addTodb);
		
		//doGet(request, response);
	}

}
