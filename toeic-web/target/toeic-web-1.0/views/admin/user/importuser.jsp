<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:url var="validateExcel" value="/admin-user-import-validate"/>
<c:url var="importExcel" value="/admin-user-import"/>

<html>
<head>
    <title><fmt:message key="label.user.import.excel" bundle="${lang}"/></title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.user.import.excel" bundle="${lang}"/></li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${validateExcel}" method="post" enctype="multipart/form-data" id="formImport">
                        <div class="form-group">
                            <div class="col-sm-9">
                                <input type="file" name="file"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                        id="validateData">
                                    <fmt:message key="label.file.validate.import" bundle="${lang}"/>
                                </button>
                            </div>
                        </div>
                        <c:if test="${not empty items.userImportDTOS}">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <fmt:bundle basename="ApplicationResources">
                                            <display:table id="tableList" name="items.userImportDTOS" partialList="true" size="${items.totalItems}" pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                           style="margin: 3em 0 1.5em;">

                                                <display:column headerClass="text-left" property="userName" titleKey="label.user.name"/>
                                                <display:column headerClass="text-left" property="fullName" titleKey="label.user.fullname"/>
                                                <display:column headerClass="text-left" property="password" titleKey="label.user.password"/>
                                                <display:column headerClass="text-left" property="roleName" titleKey="label.user.fullname"/>
                                                <display:column headerClass="text-left" property="error" titleKey="label.import.error"/>
                                            </display:table>
                                        </fmt:bundle>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="importData">
                                <fmt:message key="label.user.import" bundle="${lang}"/>
                            </button>
                        </c:if>
                        <input type="hidden" name="urlType" value="" id="urlType"/>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#validateData').click(function () {
            $('#urlType').val("read_excel");
            $('#formImport').submit();
        });
        $('#importData').click(function () {
            $('#urlType').val("import_data");
            $('#formImport').prop("enctype",false);
            $('#formImport').attr("action",'${importExcel}');
            $('#formImport').submit();
        });
    })
</script>
</body>
</html>
