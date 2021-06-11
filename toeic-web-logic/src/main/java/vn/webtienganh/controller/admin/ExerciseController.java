package vn.webtienganh.controller.admin;

import vn.webtienganh.core.common.utils.UploadUtil;
import vn.webtienganh.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = {"/admin-exercise-upload"})
public class ExerciseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exercise/upload.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> valueTitle = new HashSet<>();
        uploadUtil.writeOrUpdateFile(request,valueTitle, WebConstant.EXERCISE);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exercise/upload.jsp");
        rd.forward(request,response);
    }
}
