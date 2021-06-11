package vn.webtienganh.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import vn.webtienganh.command.ListenGuideLineCommand;
import vn.webtienganh.core.common.utils.UploadUtil;
import vn.webtienganh.core.dto.ListenGuideLineDTO;
import vn.webtienganh.core.service.ListenGuidelineService;
import vn.webtienganh.core.service.impl.ListenGuidelineServiceImpl;
import vn.webtienganh.core.web.common.WebConstant;
import vn.webtienganh.core.web.utils.FormUtil;
import vn.webtienganh.core.web.utils.RequestUtil;
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
import java.util.*;

@WebServlet(urlPatterns = {"/admin-guideline-listen-list", "/admin-guideline-listen-edit"})
public class ListenGuideLineController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuideLineCommand command = FormUtil.populate(ListenGuideLineCommand.class, request);
        request.setAttribute(WebConstant.LIST_ITEM, command);
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<>();
                for (String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getListenGuidelineServiceInstance().delete(ids);
                if (result != ids.size()) {
                    command.setCrudaction(WebConstant.REDIRECT_ERROR);
                }

            }
            executeSearchListenGuideline(request, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buildMapRedirectMessage(bundle);
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            request.setAttribute(WebConstant.LIST_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (command.getPojo() != null && command.getPojo().getListenguidelineid() != null) {
                command.setPojo(SingletonServiceUtil.getListenGuidelineServiceInstance().findByListenGuidelineId(command.getPojo().getListenguidelineid()));
            }
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
    }

    private Map<String, String> buildMapRedirectMessage(ResourceBundle bundle) {
        Map<String, String> mapMessage = new HashMap<>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, bundle.getString("label.listenguideline.message.add.success"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, bundle.getString("label.listenguideline.message.update.success"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, bundle.getString("label.listenguideline.message.delete.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("label.message.error"));
        return mapMessage;
    }

    private void executeSearchListenGuideline(HttpServletRequest request, ListenGuideLineCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getListenGuidelineServiceInstance().findListenGuideLineByProperties(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuideLineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String, Object> buildMapProperties(ListenGuideLineCommand command) {
        Map<String, Object> properties = new HashMap<>();
        if (StringUtils.isNotBlank(command.getPojo().getTitle())) {
            properties.put("title", command.getPojo().getTitle());
        }
        return properties;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadUtil uploadUtil = new UploadUtil();
        ListenGuideLineCommand command = new ListenGuideLineCommand();
        Set<String> valueTitle = buildSetValueListenGuideline();
        Object[] objects = uploadUtil.writeOrUpdateFile(request, valueTitle, WebConstant.LISTENGUIDELINE);
        boolean checkStatusUploadImage = (Boolean) objects[0];
        if (!checkStatusUploadImage) {
            response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_error");
        } else {
            ListenGuideLineDTO dto = command.getPojo();
            if (StringUtils.isNotBlank(objects[2].toString())) {
                dto.setImage(objects[2].toString());
            }
            Map<String, String> mapValue = (Map<String, String>) objects[3];
            dto = returnValueOfDTO(dto, mapValue);
            if (dto != null) {
                if (dto.getListenguidelineid() != null) {
                    try {
                        ListenGuideLineDTO listenGuideLineDTO = SingletonServiceUtil.getListenGuidelineServiceInstance().findByListenGuidelineId(dto.getListenguidelineid());
                        if (dto.getImage() == null) {
                            dto.setImage(listenGuideLineDTO.getImage());
                        }
                        dto.setCreatedDate(listenGuideLineDTO.getCreatedDate());
                        dto = SingletonServiceUtil.getListenGuidelineServiceInstance().updateListenGuideline(dto);
                        if (dto != null) {
                            response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_update");
                        } else {
                            response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_error");
                        }
                    } catch (ObjectNotFoundException e) {
                        log.error(e.getMessage(), e);
                        response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_error");
                    }
                } else {
                    try {
                        SingletonServiceUtil.getListenGuidelineServiceInstance().saveListenGuideline(dto);
                        response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_insert");
                    } catch (ConstraintViolationException e) {
                        log.error(e.getMessage(), e);
                        response.sendRedirect("/admin-guideline-listen-edit?urlType=url_list&&crudaction=redirect_error");
                    }

                }
            }
        }
    }

    private ListenGuideLineDTO returnValueOfDTO(ListenGuideLineDTO dto, Map<String, String> mapValue) {
        for (Map.Entry<String, String> item : mapValue.entrySet()) {
            if (item.getKey().equals("pojo.title")) {
                dto.setTitle(item.getValue());
            } else if (item.getKey().equals("pojo.content")) {
                dto.setContent(item.getValue());
            } else if (item.getKey().equals("pojo.listenguidelineid")) {
                dto.setListenguidelineid(Integer.parseInt(item.getValue().toString()));
            }
        }
        return dto;
    }

    private Set<String> buildSetValueListenGuideline() {
        Set<String> returnValue = new HashSet<>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.content");
        returnValue.add("pojo.listenguidelineid");
        return returnValue;
    }
}