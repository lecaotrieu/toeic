<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="editUserUrl" value="/ajax-admin-user-edit">
    <c:param name="urlType" value="url_edit"/>
</c:url>
<c:choose>
    <c:when test="${not empty messageResponse}">
        ${messageResponse}
    </c:when>
    <c:otherwise>
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <c:if test="${not empty item.pojo.userId}">
                        <h4 class="modal-title"><fmt:message key="label.user.edit" bundle="${lang}"/></h4>
                    </c:if>
                    <c:if test="${empty item.pojo.userId}">
                        <h4 class="modal-title"><fmt:message key="label.user.add" bundle="${lang}"/></h4>
                    </c:if>
                </div>
                <div class="modal-body">
                    <form action="${editUserUrl}" method="POST" id="editUserForm">
                        <div class="form-group">
                            <input class="form-control" value="${item.pojo.name}"
                                   placeholder="<fmt:message key='label.user.name' bundle='${lang}'/> "
                                   id="name" name="pojo.name" type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control"
                                   placeholder="<fmt:message key='label.user.fullname' bundle='${lang}'/>"
                                   value="${item.pojo.fullName}" name="pojo.fullName" type="text">
                        </div>
                        <div class="form-group">
                            <input class="form-control"
                                   placeholder="<fmt:message key='label.user.password' bundle='${lang}'/>"
                                   id="password" name="pojo.password" type="password" value="${item.pojo.password}">
                        </div>
                        <div class="form-group">
                            <select class="form-control" name="roleId" id="role">
                                <c:choose>
                                    <c:when test="${not empty item.pojo.userId}">
                                        <option value="${item.pojo.roleDTO.roleId}">${item.pojo.roleDTO.name}</option>
                                        <c:forEach items="${item.roles}" var="itemRole">
                                            <c:if test="${item.pojo.roleDTO.roleId != itemRole.roleId}">
                                                <option value="${itemRole.roleId}">${itemRole.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <option><fmt:message key="label.option.role" bundle="${lang}"/></option>
                                        <c:forEach items="${item.roles}" var="itemRole">
                                        <option value="${itemRole.roleId}">${itemRole.name}</option>
                                    </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                        <c:if test="${not empty item.pojo.userId}">
                            <input type="hidden" name="pojo.userId" value="${item.pojo.userId}"/>
                        </c:if>
                        <input type="hidden" name="crudaction" id="crudactionEdit"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <fmt:message key="label.close" bundle='${lang}'/>
                    </button>
                    <button type="button" id="btnSave" class="btn btn-primary">
                        <fmt:message key="label.save" bundle="${lang}"/>
                    </button>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

