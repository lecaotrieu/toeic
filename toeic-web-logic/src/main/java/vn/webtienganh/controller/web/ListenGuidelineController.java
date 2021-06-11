package vn.webtienganh.controller.web;

import org.apache.commons.lang.StringUtils;
import vn.webtienganh.command.ListenGuideLineCommand;
import vn.webtienganh.core.dto.ListenGuideLineDTO;
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

@WebServlet(urlPatterns = {"/danh-sach-huong-dan-nghe", "/noi-dung-bai-huong-dan-nghe"})
public class ListenGuidelineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuideLineCommand command = FormUtil.populate(ListenGuideLineCommand.class, request);
        if (command.getPojo().getListenguidelineid() != null) {
            ListenGuideLineDTO existListenGuideline = SingletonServiceUtil.getListenGuidelineServiceInstance().findByListenGuidelineId(command.getPojo().getListenguidelineid());
            request.setAttribute(WebConstant.FORM_ITEM, existListenGuideline);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/listenguideline/detail.jsp");
            rd.forward(request, response);
        } else {
            executeSearchListenGuideline(request, command);
            request.setAttribute(WebConstant.LIST_ITEM,command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/listenguideline/list.jsp");
            rd.forward(request, response);
        }
    }

    private void executeSearchListenGuideline(HttpServletRequest request, ListenGuideLineCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        command.setMaxPageItems(3);
        RequestUtil.initSearchBeanManual(command);
        Object[] objects = SingletonServiceUtil.getListenGuidelineServiceInstance().findListenGuideLineByProperties(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuideLineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        command.setTotalPage((int) Math.ceil((double) command.getTotalItems() / command.getMaxPageItems()));
    }

    private Map<String, Object> buildMapProperties(ListenGuideLineCommand command) {
        Map<String, Object> properties = new HashMap<>();
        if (StringUtils.isNotBlank(command.getPojo().getTitle())) {
            properties.put("title", command.getPojo().getTitle());
        }
        return properties;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
