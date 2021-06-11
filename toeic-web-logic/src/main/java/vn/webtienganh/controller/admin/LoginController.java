package vn.webtienganh.controller.admin;

import org.apache.log4j.Logger;
import vn.webtienganh.command.UserCommand;
import vn.webtienganh.core.common.utils.SessionUtil;
import vn.webtienganh.core.dto.CheckLogin;
import vn.webtienganh.core.dto.UserDTO;
import vn.webtienganh.core.web.common.WebConstant;
import vn.webtienganh.core.web.utils.FormUtil;
import vn.webtienganh.core.web.utils.SingletonServiceUtil;
import vn.webtienganh.core.web.utils.WebCommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        String action = request.getParameter("action");
        if (action != null && action.equals(WebConstant.LOGOUT)) {
            SessionUtil.getInstance().removeValue(request, WebConstant.LOGIN_NAME);
            response.sendRedirect("/trang-chu");
        } else if (action != null && action.equals(WebConstant.LOGIN)) {
            if (command.getCrudaction()!=null) {
                Map<String, String> mapMessage = new HashMap<>();
                mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("label.message.error"));
                WebCommonUtil.addRedirectMessage(request,command.getCrudaction(),mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin checkLogin = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if (checkLogin.isUserExist()) {
                SessionUtil.getInstance().putValue(request, WebConstant.LOGIN_NAME, pojo.getName());
                if (checkLogin.getRoleName().equals(WebConstant.ROLE_ADMIN)) {
                    response.sendRedirect("/admin-home");
                } else if (checkLogin.getRoleName().equals(WebConstant.ROLE_USER)) {
                    response.sendRedirect("/trang-chu");
                }
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.name.password.wrong"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request, response);
            }
        }
    }
}
