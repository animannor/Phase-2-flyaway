package flyawayservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flyaway.models.masterlist;
import flyaway.models.reservation;
import hibernatesetup.dbfunctions;


@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public booking() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				
		PrintWriter out = response.getWriter();
		
		
		
		String email = request.getParameter("email");
		String flightindex = request.getParameter("outflight");
		String psgname = request.getParameter("psgname");
		
		
		System.out.println(flightindex);
		System.out.println(email);
		System.out.println(psgname);
		
		HttpSession session = request.getSession();
		
		
		reservation Rinfo = new reservation();
		
		
	
		try {
			System.out.println(flightindex);
			
			masterlist finfo =dbfunctions.getmasterlistById(flightindex);
			
			
			if (finfo.getAvaiableseats()< 0)
			  {
				 out.println("Sorrythe flight is fully booked , can search for another flight");
				 dispatcher.include(request, response);
				 return;
			  }
			
			else
			{
				int newseat=finfo.getAvaiableseats()-1;
				
				System.out.println(newseat);
				finfo.setAvaiableseats(newseat);
				
				//System.out.println(finfo);
				
				  dbfunctions.updatemasterlist(finfo);
				  Rinfo.setFlightindex(flightindex);
                  Rinfo.setPassengername(psgname);
                  int seatnum=dbfunctions.savereservation(Rinfo);
				  
				  
			   
				  session.setAttribute("email", email);
				  session.setAttribute("psgname", psgname);
				  session.setAttribute("finfo", finfo);
				  session.setAttribute("seatnum", seatnum);
				  
				  				  
				  response.sendRedirect("bookingout.jsp");
				 
				 
			     }
				
				
		       }  catch (Exception e) {
				e.printStackTrace();
				out.println("Booking unsuccessfull, something want wrong , try again or contact site admin (admin@flyaway,com)");
				session.setAttribute("email", email);
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("index.jsp");
			    dispatcher1.include(request, response);
				
			    }
		    }
		  
		   }


                  
                 

	      








