package news;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SystemFiter
 */
@WebFilter(filterName = "/SystemFiter",urlPatterns = {"/SYSTEM/*",})
public class SystemFiter implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1=(HttpServletRequest)request;
		HttpSession session=request1.getSession();
		if(session.getAttribute("name")!=null&&session.getAttribute("pass")!=null) {
			chain.doFilter(request, response);
			return;
		}
		else {
			request1.getRequestDispatcher("/login.jsp").forward(request1, response);
		
		}
		
	}
	   /**
     * Default constructor. 
     */
    public SystemFiter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
