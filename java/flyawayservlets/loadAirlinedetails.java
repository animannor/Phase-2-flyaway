package flyawayservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flyaway.models.airlinedetails;
import hibernatesetup.dbfunctions;


@WebServlet("/loadAirlinedetails")
public class loadAirlinedetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loadAirlinedetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminloadairline.html");
			PrintWriter out = response.getWriter();
			String airlineindex = request.getParameter("airlineindex");
			String airlinename = request.getParameter("airlinename");
			String airlinetype = request.getParameter("airlinetype");
			String seatingcapacity = request.getParameter("seatingcapacity");
			
			 flyaway.models.airlinedetails info = new airlinedetails();
			 			 
			  
			
			  out.println("Kinly check inputs, it cannot be empty");
			
			  try {
					if(airlineindex!=null && airlinename!=null && seatingcapacity!=null && airlinetype!=null) 
					{			      					  
					  info.setAirlineindex(airlineindex);
					  info.setAirlinename(airlinename);
					  info.setAirlinetype(airlinetype);
					  info.setSeatingcapacity(Integer.valueOf(seatingcapacity));
				       
				       dbfunctions.saveairlinedetails(info);
				        
				        
				        out.println("Air details successfully loaded");
				        
				        
				        response.sendRedirect("adminloadairline.html");
				        return;
				     }
					
					else
					  out.println("Kinly check inputs, it cannot be empty");
					
					
			       }  catch (Exception e) {
					e.printStackTrace();
					out.println("Something went wrong, it's likely entered details exist in database");
		            dispatcher.include(request, response);
				    }
			  
			         response.sendRedirect("adminloadairline.html");
			    }
			  
			
		
		


	}


