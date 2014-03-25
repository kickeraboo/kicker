package facebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

/**
 * Servlet implementation class CallbackServlet
 */
@WebServlet("/CallbackServlet")
public class CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CallbackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Facebook facebook = (Facebook) request.getSession().getAttribute(
				"facebook");
		String oauthCode = request.getParameter("code");
		try {
			facebook.getOAuthAccessToken(oauthCode);
		} catch (FacebookException e) {
			throw new ServletException(e);
		}

		try {
			// Single FQL
			String query = "SELECT email FROM user WHERE uid=me()";
			JSONArray jsonArray;

			jsonArray = facebook.executeFQL(query);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				System.out.println(jsonObject.get("email"));

			}
		} catch (FacebookException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
