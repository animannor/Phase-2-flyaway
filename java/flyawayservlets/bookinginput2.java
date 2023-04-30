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

/**
 * Servlet implementation class bookinginput2
 */
@WebServlet("/bookinginput2")
public class bookinginput2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bookinginput2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			String outflight = request.getParameter("outflight");
			String email = request.getParameter("email");
			String psgname = request.getParameter("psgname");
			String paymentamount = request.getParameter("paymentamount");
			
			
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
						+"<h3> Hello "+ email+" thanks for choosing us</h3>");
						
			       
			 
			
			out.println("<h2> Kindly make payment of $  "+ paymentamount + "   for passenger "+ psgname +"</h2>" );
			
			
			out.println("<form action=booking method=post>"
					     +"<label> click on the button to make payment </label><br> "
					     +"<input type=hidden id= email name= email value="+ email+ ">"
			             + "<input type=hidden id= outflight name= outflight value="+ outflight+">"
			             + "<input type=hidden id= psgname name= psgname value="+ psgname +">"
			             + "<br /><br /> <input type=submit value= Make_Payment>"
			             + "</form></div></body></html>\"");
			
			

}

}