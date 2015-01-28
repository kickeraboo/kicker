package facebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.Role;
import bll.User;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

/**
 * Servlet implementation class CallbackServlet
 */
@WebServlet("/facebookcb")
public class CallbackServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public CallbackServlet()
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
      Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

      String oauthCode = request.getParameter("code");

      try
      {
         facebook.getOAuthAccessToken(oauthCode);
      }
      catch (FacebookException e)
      {
         throw new ServletException(e);
      }

      try
      {
         String action = request.getParameter("action");

         // selects the user information
         String query = "SELECT email, username, name, uid  FROM user WHERE uid=me()";
         JSONArray jsonArray = facebook.executeFQL(query);

         if (jsonArray != null && jsonArray.length() > 0)
         {
            JSONObject jsonUser = jsonArray.getJSONObject(0);

            String email = (String) jsonUser.get("email");
            String facebookId = (String) jsonUser.get("uid");
            String username = (String) jsonUser.get("username");
            String fullname = (String) jsonUser.get("name");
            User tmpUser = null;

            if (!facebookId.isEmpty())
            {
               // if we get something here,
               // it means the user already existed regardless
               // of the action. Simply log user in...
               tmpUser = User.getUserByFacebookId(facebookId);
               
               // check the action. If the user is signing up, simply
               // redirect to login with the information filled, but
               // we do not insert the user
               if (tmpUser == null)
               {

                     tmpUser = new User(0, email, facebookId, username, fullname, Role.getRoleByName("User").getRoleID() , true);
                     tmpUser = User.createUser(tmpUser);
                     
                     if (tmpUser != null)
                     {
                        request.getSession().setAttribute("LoggedUser", tmpUser);
                     }
                     response.sendRedirect(request.getContextPath() + "/");

               }
               else
               {
                  // user exists put him in session
                  request.getSession().setAttribute("LoggedUser", tmpUser);
                  response.sendRedirect(request.getContextPath() + "/");
               }
            }
         }
      }
      catch (FacebookException | JSONException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
