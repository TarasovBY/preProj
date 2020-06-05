package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            if (session.getAttribute("role").equals("admin")) {
                httpResponse.sendRedirect("/admin");
            } else if (session.getAttribute("role").equals("user")) {
                httpResponse.sendRedirect("/user");
            } else {
                filterChain.doFilter(request, response);
            }
        }
        catch (Exception e) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
