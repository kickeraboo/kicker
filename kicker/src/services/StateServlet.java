package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StateServlet
 */
@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public StateServlet()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
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
            case "getall":
               writer.write(StateService.getAllStates());
               break;
         }
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      // TODO Auto-generated method stub
   }

}
