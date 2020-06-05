package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try{
            if (session.getAttribute("role").equals("admin")) {
                filterChain.doFilter(request, response);
            } else {
                httpServletResponse.sendRedirect("/login");
            }
        }
        catch (Exception e) {
            httpServletResponse.sendRedirect("/login");
        }


    }

    @Override
    public void destroy() {

    }
}
