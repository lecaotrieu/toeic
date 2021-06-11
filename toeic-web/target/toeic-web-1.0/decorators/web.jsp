<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
        <!-- Bootstrap -->
        <link href="<c:url value='/template/web/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/template/web/css/bootstrap-responsive.css'/>" rel="stylesheet">
        <link href="<c:url value='/template/web/css/style.css'/>" rel="stylesheet">
        <!--Font-->
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600" rel="stylesheet" type="text/css">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->

        <!-- SCRIPT
        ============================================================-->
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
</head>
<body>
<!--header -->
<%@ include file="/common/web/header.jsp"%>
<!-- header -->

<dec:body/>

<!-- footer -->
<%@ include file="/common/web/footer.jsp"%>
<!-- footer -->
</body>
</html>
