package flyawayservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernatesetup.dbfunctions;
import flyaway.models.routeinfo;
/**
 * Servlet implementation class loadrouteinfo
 */
@WebServlet("/loadrouteinfo")
public class loadrouteinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadrouteinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminrouteinfo.html");
		PrintWriter out = response.getWriter();
		String routeindex = request.getParameter("routeindex");
		String departure = request.getParameter("departure");
		String destination = request.getParameter("destination");
		 flyaway.models.routeinfo info = new routeinfo();
		 //String S=null;
		
		
		  try {
			  
				if(routeindex!=null && departure!=null && destination!=null ) 
				{
			  System.out.println("routeindex : "+ routeindex+"   departure : "+departure+"   destination : "+destination);
					System.out.println("Not equal to Null in IF conditions ");
				 {			      					  
				  info.setDepartre(departure);
				  info.setDestination(destination);
				  info.setRouteindex(routeindex);
			       
			       
			        dbfunctions.saverouteinfo(info);
			        System.out.println("Route details saved successfully");
			        
			        out.println("Route details successfully loaded");
			        response.sendRedirect("adminrouteinfo.html");
			        return;
			     }
				
				}
				else 
			       out.println("Kinly check inputs, it cannot be null");
			
		       }  catch (Exception e) {
				e.printStackTrace();
				out.println("Something went wrong, it's likely entered details exist in database");
	            dispatcher.include(request, response);
			    }
		    }
	
		
	
	}


