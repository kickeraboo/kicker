package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.Bucket;
import bll.User;

/**
 * Servlet implementation class BucketServlet
 */
@WebServlet("/BucketServlet")
public class BucketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BucketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(BucketService.getBucketsByUserId(16));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("LoggedUser") == null) {
			response.sendRedirect("index.jsp");
		}

		User usr = (User) request.getSession().getAttribute("LoggedUser");

		String action = (String) request.getParameter("action");

		// get data from post
		String name = (String) request.getParameter("name");
		int cityID = Integer.parseInt(request.getParameter("cityID"));
		String description = (String) request.getParameter("description");

		if (!action.isEmpty()) {
			switch (action) {
			case "create": {
				Bucket bucket = Bucket.CreateBucket(usr.getUserID(), name,
						description, cityID);
				if (bucket == null) {
					response.sendRedirect("error.jsp");
				}
			}
			case "delete":
				// TODO
			case "update":
				// TODO
			}
		}

	}

}
