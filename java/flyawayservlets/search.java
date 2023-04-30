package flyawayservlets;

import hibernatesetup.dbfunctions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import flyaway.models.masterlist;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String departure = request.getParameter("departure");
		String destination = request.getParameter("destination");
		String dday = request.getParameter("dday");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
			
		 
		List<masterlist> data = new ArrayList<>();
	
		int t;
		
			 
		
		
		  if (departure!=null && destination!=null && dday!=null )
			  
		    {
			 				 
				 List<masterlist> temp1=dbfunctions.getmasterlist();
			       
				     for (t=0;t<temp1.size();t++)
				          
			              {
					         if(departure.equals(temp1.get(t).getDeparture())  && destination.equals(temp1.get(t).getDestination()) && dday.equals(temp1.get(t).getDday()))
					               {
						
						             data.add(temp1.get(t));
						             System.out.println(temp1.get(t));
						             
						           }   
					         
			              }
			      out.println("<!DOCTYPE html>\n"
							+ "<html>\n"
							+ "<head>\n"
							+ "<meta charset=\"UTF-8\">\n"
							+ "<title>Flyaway/searchresults</title>\n"
							+ "<link\n"
							+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n"
							+ "	rel=\"stylesheet\"\n"
							+ "	integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n"
							+ "	crossorigin=\"anonymous\">\n"
							+ "<style>\n"
							+ "</style>\n"
							+ "</head>\n"
							+ "<body><div class='container'>"
							+"<h3>Search Results   "+email+"</h3>"
							+ "<table class='table'>");
					  out.println("<tr>"
							+ "<th>Departure</th>"
							+ "<th>Destination</th>"
							+ "<th>Airline</th>"
							+ "<th>Airplane Type</th>"
							+ "<th>Fare</th>"
							+ "<th>Available Seat</th>"
							+ "<th>Departure Day</th>"
							+ "<th>Departure Time</th>"
							+ "<th> Book flight</th>"
							+ "</tr>");
					
					  
					  if (data!=null)
			           {
					     int i;
					
					     for(i=0;i<data.size();i++)
					        {
					    
						       String outdeparture= data.get(i).getDeparture();
						       String outDestination= data.get(i).getDestination();
						       String outAirline= data.get(i).getAirlinename();
						       String outAirplaneType= data.get(i).getAircrafttype();
						       double outFare= data.get(i).getFlightprice();	 
			                   int outAvailableSeat= data.get(i).getAvaiableseats();
						       String outDepartureDay= data.get(i).getDday();
						       String outDepartureTime= data.get(i).getDhour();
						       
						 
						 
						 			
				               out.println("<tr>"
				               +"<td>"+outdeparture+"</td>"
				               +"<td>"+outDestination+"</td>"
				               +"<td>"+outAirline+"</td>"
				               +"<td>"+outAirplaneType+"</td>"
				               +"<td>"+outFare+"</td>"
				               +"<td>"+outAvailableSeat+"</td>"
				               +"<td>"+outDepartureDay+"</td>"
				               +"<td>"+outDepartureTime+"</td>"
					           + "<td><td><form action=bookinginput1 method=post>"
					           +"<input type= submit value=book >"
					           + "<input type=hidden id= email name= email value="+ email+ ">"					           
					           + "<input type=hidden id=outflight  name= outflight value="+ data.get(i).getFlightindex()+">"
					           +"</form></td></tr>");
					          }
					            out.println("</table></div></body></html>");
				            }
				
			              
		            }
		          
			       
		      else
		    	 
			       {
				  out.println("<h3>No matching Entry found</h3>"); 
				  out.println("<a href=index.html>Back to home page</a>");
			       }
         }

}
	
