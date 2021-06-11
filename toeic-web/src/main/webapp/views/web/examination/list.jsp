<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:url var="urlList" value="/danh-sach-bai-thi"/>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${urlList}" method="get" id="formUrl">
    <div class="wrap">
        <div class="main">
            <div class="content">
                <div class="col span_2_of_3">
                    <div class="contact-form">
                        <div>
                                <span>
                                    <input name="pojo.name" type="text" class="textbox" value="${items.pojo.name}"/>

                                </span>
                        </div>
                        <div>
                            <button class="btn btn-danger"><fmt:message bundle="${lang}" key="label.search"/> </button>
                        </div>
                    </div>
                </div>
                <c:forEach var="item" items="${items.listResult}">
                    <div class="image group">
                     <%--   <div class="grid images_3_of_1">
                            <img src="<c:url value="/repository/${item.image}"/>" alt=""/>
                        </div>--%>
                        <div class="grid news_desc">
                            <h3>${item.name}</h3>
                            <c:url var="detailUrl" value="/bai-thi-thuc-hanh">
                                <c:param name="examinationId" value="${item.examinationId}"/>
                                <c:param name="page" value="1"/>
                            </c:url>
                            <c:if test="${not empty login_name}">
                                <h4><span><a href="${detailUrl}">Làm bài thi</a></span></h4>
                            </c:if>
                            <c:if test="${empty login_name}">
                                <h4><span><fmt:message bundle="${lang}" key="label.examination.require"/> </span></h4>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
                <ul id="pagination-demo" class="pagination-sm"></ul>
            </div>
        </div>
    </div>
    <input type="hidden" id="page" name="page"/>
</form>
<script type="text/javascript">
    var totalPages = ${items.totalPage};
    var starPage = ${items.page};
    var visiblePages = ${items.maxPageItems};
    $(document).ready(function () {

    });
    $(function () {
        var obj =$('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            startPage: starPage,
            visiblePages: visiblePages,
            onPageClick: function (event, page) {
                if (page!= starPage) {
                    $("#page").val(page);
                    $("#formUrl").submit();
                }
            }
        });
    });

</script>
</body>
</html>