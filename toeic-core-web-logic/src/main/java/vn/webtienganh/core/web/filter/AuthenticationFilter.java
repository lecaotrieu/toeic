package vn.webtienganh.core.web.filter;

import vn.webtienganh.core.common.utils.SessionUtil;
import vn.webtienganh.core.dto.UserDTO;
import vn.webtienganh.core.web.common.WebConstant;
import vn.webtienganh.core.web.utils.SingletonServiceUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith("/admin")) {
            String name = (String) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
            UserDTO userDTO = null;
            if (name != null) {
                userDTO = SingletonServiceUtil.getUserServiceInstance().findByName(name);
            }
            if (userDTO != null) {
                if (userDTO.getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (userDTO.getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                    response.sendRedirect(request.getContextPath() + "/login?action=login&&crudaction=redirect_error");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login&&crudaction=redirect_error");

            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
