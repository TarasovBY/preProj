package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        boolean userUser = session.getAttribute("user") != null;
        String url = httpRequest.getRequestURI();

        if (userUser && url.contains("admin")) {
            httpServletResponse.sendRedirect("/user");
        }
        else if (session.getAttribute("admin") != null) {
            filterChain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("/login");
        }


    }

    @Override
    public void destroy() {

    }
}
