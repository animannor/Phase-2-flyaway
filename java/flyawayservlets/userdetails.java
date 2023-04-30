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

import hibernatesetup.dbfunctions;




@WebServlet(description = "access userdatabase", urlPatterns = { "/userdetails" })

public class userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public userdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String Rpassword = request.getParameter("password");
		
		
		try {
		 if(email!=null)
		   {
		    flyaway.models.userdetails info = dbfunctions.getuserdetailsById(email);
		        
		    
		        if( email.equals(info.getEmail()) && Rpassword.equals(info.getPassword()))
		             {
		        	  if (email.equals("admin@flyaway.com"))
		        	    {
				       session.setAttribute("email", email);
				       response.sendRedirect("adminhome.html");
				        return;
		                }
		               else 
		                {
		            	 out.println("Login sucessful");
		            	 response.setContentType("text/jsp");
		            	 session.setAttribute("email", email);
		        	     response.sendRedirect("index.jsp");
     				     				     
		                }
		             }
		        
		        else {
		        	  out.println("Login unsucessful, wrong credentials entered");
		        	  RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        	  response.setContentType("text/jsp");
		        	  dispatcher.include(request, response);
				     }
		    }
		        
		        
		        else {
		        	  out.println("Email cannot be blank");
		        	  RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        	  response.setContentType("text/jsp");
		        	  dispatcher.include(request, response);
				     } 
		 
		             }catch (Exception e) {
							e.printStackTrace();
							out.println("something went wrong, please");
				            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				            response.setContentType("text/jsp");
				            dispatcher.include(request, response);
						  
						}
	}
		
		
	// post is used to save	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Pragma", "0");
		
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		String Npassword = request.getParameter("newpassword");
		
		flyaway.models.userdetails info = new flyaway.models.userdetails();
		
		 
		try {
			if(email!=null && password!=null &&  Npassword!=null)
			   {
								
				if(email=="admin@flyway.com" )
				   {
					//flyaway.models.userdetails admininfo = dbfunctions.getuserdetailsById(email);
					
					  info = dbfunctions.getuserdetailsById(email);
				         if (password.equals(info.getPassword()))
					         {
						       info.setPassword(Npassword);
						       dbfunctions.updateuserdetails(info);
						       RequestDispatcher dispatcher = request.getRequestDispatcher("adminchpassword.html");
					           response.setContentType("text/html");
					           
					           dispatcher.include(request, response);
						       out.println("Password successfully update");
						     }
					     else
					         {
					    	 RequestDispatcher dispatcher = request.getRequestDispatcher("adminchpassword.html");
					         response.setContentType("text/html");
					         out.println("Password Password mismatch");
					         dispatcher.include(request, response);
						     
						     }
					  
				   }
			     
				 else 
				      {
				          if (password.equals(Npassword))
				              {
					   	       info.setPassword(Npassword);
					   	       info.setEmail(email);
					   	       dbfunctions.saveuserdetails(info);
					   	       response.setContentType("text/html");
					           session.setAttribute("email", email);
						       out.println("Sign-in succesful, Welcome   "+ email);
						       RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						       dispatcher.include(request, response);
							  }
						  else
						     {
							  out.println("Password  mismatch, please enter the same password");
							  response.setContentType("text/html");
					          RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					          dispatcher.include(request, response);
					           
						     
							   
							  
						     }
					   }
			         }
				
					       
					    
		      
			else
		       {
				out.println("Non of the fields can be emtpy");
				  response.setContentType("text/html");
		          RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		          dispatcher.include(request, response);
			 }
			
			 } catch (Exception e) {
			e.printStackTrace();
			
		    out.println("Something went wrong, please contact the admin");
            response.setContentType("text/html");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
	        dispatcher.include(request, response);
		    }
	    }
}
