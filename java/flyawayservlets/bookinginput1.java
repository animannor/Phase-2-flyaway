package flyawayservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flyaway.models.masterlist;
import hibernatesetup.dbfunctions;

@WebServlet("/bookinginput1")
public class bookinginput1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookinginput1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		String outflight = request.getParameter("outflight");
		String email = request.getParameter("email");
		
		//String psgname ;
		
		
		System.out.println("email is : "+ email+" outfight is  :"+ outflight );
		
		try {
			
		masterlist finfo =dbfunctions.getmasterlistById(outflight);
		
		
		int availseat =finfo.getAvaiableseats();
		
		
		
		if (availseat>1)
	     	{
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
					+"<h3> Hello "+ email+"      thanks for choosing us</h3>"
					+"<h3>Please enter name of passenger </h3>");
		       
		 
		
		 
			  
			  out.println("<form action=bookinginput2 method=post>"
					   +"<label> Note current available seats is/are  :  "+ availseat+" </label><br> "
					   
			           + "<input type=hidden id= email name= email value="+ email+ ">"					           
			           + "<input type=hidden id= outflight name= outflight value="+ outflight+">"
			           + "<input type=hidden id= paymentamount name= paymentamount value="+ finfo.getFlightprice()+">"
			           + "<input type=text  name= psgname  >"
			           + "<input type= submit value=submit >"
			           +"</form></div></body></html>\"");
			          }
		
		else {
			out.println("The flight is currently fully booked , please book another flight");
			response.setContentType("text/html");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.include(request, response);
			
		}
		
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			out.println("Could not access database, please contact the admin or try again");
			response.setContentType("text/html");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.include(request, response);
		}
		
			            
		          
	}

}
