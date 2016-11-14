package ensa.livraison.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<IdStatObject> listofStat;
   
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		listofStat =parse(getData());
		request.setAttribute("listofStat", listofStat);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/livraison.jsp");
		dispatcher.forward(request, response);
		
	}
	public ArrayList<IdStatObject>parse(String data){
		try {
			   JSONObject obj = new JSONObject(getData());
			  //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
				JSONArray arr = obj.getJSONArray("cartItem");
				ArrayList<IdStatObject>list =new ArrayList<IdStatObject>();
				for (int i = 0; i < arr.length(); i++)
				{
				    String id = arr.getJSONObject(i).getString("id");
				    String stateOfOrder =arr.getJSONObject(i).getString("stateOfOrder");
				    list.add(new IdStatObject(id, stateOfOrder));
				}
				return list;
		} catch (Exception e) {
			 	return null;
		}
	}
	public String getData(){
		String output ;
		try {

			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/Atlas01/rest/AllOrders");
			ClientResponse response = webResource.type("application/json")
			   .get(ClientResponse.class);
			 output = response.getEntity(String.class);
		  } catch (Exception e) {
			
			e.printStackTrace();
			output=-1+"";
		  }
		return output ;
		
	}
	public void updateOrder(String id ,String state){
		
			try {
				Client client = Client.create();
				WebResource webResource = client
				   .resource("http://localhost:8080/Atlas01/rest/OrderState?id="+id+"&state="+state);
				ClientResponse response = webResource.type("application/json")
				   .get(ClientResponse.class);
				 String output = response.getEntity(String.class);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state=request.getParameter("action");
		String id=request.getParameter("id");
		updateOrder(id,state);
		listofStat =parse(getData());
		request.setAttribute("listofStat", listofStat);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/livraison.jsp");
		dispatcher.forward(request, response);
		
	}
 }
