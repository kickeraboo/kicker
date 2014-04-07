package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.Item;
import bll.User;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("LoggedUser") == null) {
			response.sendRedirect("index.jsp");
		}

		int bucketId = Integer.parseInt(request.getParameter("bucketID"));

		String action = (String) request.getParameter("action");

		if (!action.isEmpty()) {
			PrintWriter writer = response.getWriter();

			switch (action.toLowerCase()) {
			case "getitems":
				writer.write(ItemService.getItemsByBucketId(bucketId));
				break;
			}
		}

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
		String name = (String) request.getParameter("txtItemName");
		String description = (String) request.getParameter("txtDescription");

		if (!action.isEmpty()) {
			switch (action) {
			case "create": {

				Item item = new Item(0, name, description);
				System.out.println(item.getItemID() + " " + item.getItemName()
						+ " " + item.getDescription());
				Item it = Item.create(item);
				
				int id = it.getItemID();
				
				
				
				if (it == null) {
					System.out.println("it was null");
					response.sendRedirect("error.jsp");
				}
			}
			case "delete":
				// TODO
			case "update":
				// TODO
			case "addToBucket":
				System.out.println("In addToBucket");
			}
		}
	}

}
