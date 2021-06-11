package vn.webtienganh.controller.web;

import vn.webtienganh.command.ExerciseQuestionCommand;
import vn.webtienganh.core.dto.ExerciseDTO;
import vn.webtienganh.core.dto.ExerciseQuestionDTO;
import vn.webtienganh.core.web.common.WebConstant;
import vn.webtienganh.core.web.utils.FormUtil;
import vn.webtienganh.core.web.utils.RequestUtil;
import vn.webtienganh.core.web.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/bai-tap-thuc-hanh","/ajax-bai-tap-dap-an"})
public class ExerciseQuestionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
        getListenExerciseQuetion(command);
        request.setAttribute(WebConstant.LIST_ITEM,command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/exercise/detail.jsp");
        rd.forward(request, response);
    }

    private void getListenExerciseQuetion(ExerciseQuestionCommand command) {
        command.setMaxPageItems(1);
        RequestUtil.initSearchBeanManual(command);
        Object[] objects = SingletonServiceUtil.getExerciseQuestionServiceImpl().findExerciseQuestionByProperties(new HashMap<>(), command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems(),command.getExerciseId());
        command.setListResult((List<ExerciseQuestionDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        command.setTotalPage((int) Math.ceil((double) command.getTotalItems() / command.getMaxPageItems()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
        getListenExerciseQuetion(command);
        for (ExerciseQuestionDTO item : command.getListResult()) {
            if (!command.getAnswerUser().equals(item.getCorrectAnswer())){
                command.setCheckAnswer(true);
            }
        }
        request.setAttribute(WebConstant.LIST_ITEM,command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/exercise/result.jsp");
        rd.forward(request, response);
    }
}
