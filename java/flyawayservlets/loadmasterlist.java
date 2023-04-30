package flyawayservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flyaway.models.airlinedetails;
import flyaway.models.masterlist;
import flyaway.models.routeinfo;
import hibernatesetup.dbfunctions;


@WebServlet("/loadmasterlist")
public class loadmasterlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loadmasterlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
	 
		
		response.sendRedirect("adminloadmasterlist.html");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("adminloadmasterlist.html");
		PrintWriter out = response.getWriter();
		String flightindex = request.getParameter("flightindex");
		String routeindex = request.getParameter("routeindex");
		String airlineindex = request.getParameter("airlineindex");
		String flightprice = request.getParameter("flightprice");
		String dday = request.getParameter("dday");
		String dhour = request.getParameter("dhour");
		masterlist info =new masterlist();
		 airlinedetails Adata= new airlinedetails();
		 routeinfo Fdata=null;
		 
	try { 
		 if(airlineindex!=null && routeindex!=null && airlineindex!=null && flightprice!=null && dday!=null && dhour!=null)
		     
			  try {
			  Adata = dbfunctions.getairlinedetailsById(airlineindex);
			      } catch (Exception e) {
					e.printStackTrace();
					
					out.println(" The inputed airlineindex doesnot exit, load airlineindex and flight details before loading flight list");
					response.sendRedirect("adminloadmasterlist.html");
		            return;
				    }
		       
		      try {
			     Fdata =dbfunctions.getrouteinfoById(routeindex);
			      } catch (Exception e) {
					e.printStackTrace();
					out.println(" The inputed route index doesnot exit, load airlineindex and flight details before loading flight list");
					response.sendRedirect("adminloadmasterlist.html");
		            return;
				    }
		 
			 	 int sc = Adata.getSeatingcapacity();
			 	 double price = Double.parseDouble(flightprice);
			 	 
			 	
			 	  info.setFlightindex(flightindex);
			 	  info.setAvaiableseats(sc);
			 	  info.setDday(dday);
			 	  info.setDhour(dhour);
			 	  info.setFlightprice(price);
			 	  info.setDeparture(Fdata.getDepartre());
			 	  info.setDestination(Fdata.getDestination());
			 	  info.setAircrafttype(Adata.getAirlinetype());
			 	  info.setAirlinename(Adata.getAirlinename());
			 	   	
			    	
			 	
			 	  dbfunctions.savemasterlist(info);
			 	  System.out.println("Flight details successfully loaded in master list");
			 	  out.println(" Flight details successfully loaded in master list");
			 	  
			 	  
			 	   } catch (Exception e) {
					e.printStackTrace();
					out.println("Something went wrong, it's likely entered details exist in database");
					response.setContentType("text/html");
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminloadmasterlist.html");
					dispatcher.include(request, response);
				    }
	}
	
	}
	        
			    	 
	
		
	
	



