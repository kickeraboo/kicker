package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   if (request.getSession().getAttribute("LoggedUser") == null)
      {
         response.sendRedirect("index.jsp");
      }

      String action = (String) request.getParameter("action");

      if (!action.isEmpty())
      {
         PrintWriter writer = response.getWriter();
         
         switch (action.toLowerCase())
         {
            case "getcitiesbystateid":
               int stateId = Integer.parseInt(request.getParameter("stateid"));
               String partialName = (String)request.getParameter("term");
               
               if (stateId > 0 && !partialName.isEmpty())
               {
                  writer.write(CityService.getCitiesByStateIdAndPartialName(stateId, partialName));
               }
               break;
         }
      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
