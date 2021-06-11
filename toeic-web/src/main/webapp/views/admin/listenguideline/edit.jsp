<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:url var="formUrl" value="/admin-guideline-listen-edit"/>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></title>
    <style>
        .error {
            color: red;
        }
    </style>
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
                <li class="active"><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <a href="${formUrl}" type="button">Thêm bài hd</a>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <br>
                    <br>
                    <form action="${listenGuidelineAddAndEditUrl}" method="post" enctype="multipart/form-data" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                    key="label.guideline.title" bundle="${lang}"/>
                            </label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.title" id="title" value="${item.pojo.title}"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                    key="label.grammarguideline.upload.image" bundle="${lang}"/>
                            </label>
                            <div class="col-sm-9">
                                <input type="file" name="file" id="uploadImg"/>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                    key="label.grammarguideline.upload.image.view" bundle="${lang}"/>
                            </label>
                            <div class="col-sm-9">
                                <c:if test="${not empty item.pojo.image}">
                                    <c:set var="image" value="/repository/${item.pojo.image}"/>
                                </c:if>
                                <img src="${image}" id="viewImage" width="150px" height="150px">
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"><fmt:message
                                    key="label.guideline.content" bundle="${lang}"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <c:if test="${not empty item.pojo.content}">
                                <c:set var="content" value="${item.pojo.content}"/>
                            </c:if>
                            <div class="col-sm-12">
                                <textarea id="ListenGuidelineContent" name="pojo.content" cols="80" rows="10">${content}</textarea>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="submit" class="btn btn-while btn-warning btn-bold"
                                       value="<fmt:message key="label.done" bundle="${lang}"/>">
                            </div>
                        </div>
                        <c:if test="${not empty item.pojo.listenguidelineid}">
                            <input type="hidden" name="pojo.listenguidelineid" value="${item.pojo.listenguidelineid}"/>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var listenGuidelineId = '';
    <c:if test="${not empty item.pojo.listenguidelineid}">
        listenGuidelineId = ${item.pojo.listenguidelineid};
    </c:if>
   $(document).ready(function () {
       var editor = CKEDITOR.replace('ListenGuidelineContent');
       CKFinder.setupCKEditor( editor, '/ckfinder/' );
       validateData();
       $('#uploadImg').change(function () {
           readURL(this, "viewImage");
       })
   });
   function validateData() {
       $('#formEdit').validate({
           ignore: [],
           rules: [],
           messages: []
       });
       $('#title').rules("add",{
           required: true,
           messages: {
               required: '<fmt:message key="label.notempty" bundle="${lang}"/> '
           }
       });
       if (listenGuidelineId =='') {
           $('#uploadImg').rules("add",{
               required: true,
               messages: {
                   required: '<fmt:message key="label.notempty" bundle="${lang}"/> '
               }
           });
       }

       $('#ListenGuidelineContent').rules("add",{
           required: function () {
               CKEDITOR.instances.ListenGuidelineContent.updateElement();
           },
           messages: {
               required: '<fmt:message key="label.notempty" bundle="${lang}"/> '
           }
       });
   }
   function readURL(input, imageId) {
       if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function (e) {
               $('#' + imageId).attr('src', reader.result);
           }
           reader.readAsDataURL(input.files[0]);
       }
   }
</script>
</body>
</html>
