package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/search","/booking","/loadAirlinedetails","/loadmasterlist","/loadrouteinfo"})
public class Authentication extends HttpFilter implements Filter {
       
   
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		response.setContentType("text/html");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
         if(email==null)
        	  {
        	   
        	   resp.sendRedirect("login.jsp");
        	   
              }
         else
		  chain.doFilter(request, response);
	    }


	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
