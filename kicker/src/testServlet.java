
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.User;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;
   
   /**
    * @see HttpServlet#HttpServlet()
    */
   public testServlet()
   {
      super();
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException
   {
      // TODO Auto-generated method stub
      List<User> users = User.getAll();
      
      System.out.println(users.get(0).getEmail());
   }
   
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException
   {
      // TODO Auto-generated method stub
   }
   
}
