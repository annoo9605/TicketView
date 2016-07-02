package challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ArrayList<HashMap<String, Object>> ticketList = null;
	HashMap<String, Object> map = new HashMap<String, Object>();
	
	public void init() throws ServletException {
		
	}
	
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
	
		try {
			JSONArray list = dao.getTicketList();
			request.setAttribute("result",list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(list);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	}
	
	
