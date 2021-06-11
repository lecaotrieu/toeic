package vn.webtienganh.controller.web;

import vn.webtienganh.command.ExaminationQuestionCommand;
import vn.webtienganh.core.common.utils.SessionUtil;
import vn.webtienganh.core.dto.ExaminationQuestionDTO;
import vn.webtienganh.core.dto.ExerciseQuestionDTO;
import vn.webtienganh.core.dto.ResultDTO;
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

@WebServlet(urlPatterns = {"/bai-thi-thuc-hanh","/bai-thi-dap-an"})
public class ExaminationQuestionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExaminationQuestionCommand command = FormUtil.populate(ExaminationQuestionCommand.class, request);
        getExaminationQuestion(command);
        request.setAttribute(WebConstant.LIST_ITEM, command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/examination/detail.jsp");
        rd.forward(request, response);
    }

    private void getExaminationQuestion(ExaminationQuestionCommand command) {
        Object[] objects = SingletonServiceUtil.getExaminationQuestionServiceImpl().findExaminationQuestionByProperties(new HashMap<>(), command.getSortExpression(), command.getSortDirection(), null, null, command.getExaminationId());
        command.setListResult((List<ExaminationQuestionDTO>) objects[1]);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExaminationQuestionCommand command = new ExaminationQuestionCommand();
        Integer examinationId = Integer.parseInt(request.getParameter("examinationId"));
        command.setExaminationId(examinationId);
        getExaminationQuestion(command);
        for (ExaminationQuestionDTO item: command.getListResult()) {
            if (request.getParameter("answerUser["+item.getExaminationQuestionId()+"]") != null) {
                item.setAnswerUser(request.getParameter("answerUser["+item.getExaminationQuestionId()+"]"));
            }
        }
        String userName = (String) SessionUtil.getInstance().getValue(request,WebConstant.LOGIN_NAME);
        ResultDTO resultDTO = SingletonServiceUtil.getResultServiceImpl().saveResult(userName, examinationId,command.getListResult());
        command.setListenScore(resultDTO.getListenScore());
        command.setReadingScore(resultDTO.getReadingScore());
        request.setAttribute(WebConstant.LIST_ITEM,command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/examination/result.jsp");
        rd.forward(request, response);
    }
}
