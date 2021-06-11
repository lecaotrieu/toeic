<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header-row">
    <div class="container">
        <div class="row">
            <!--LOGO-->
            <div class="span3"><a class="brand" href="#"><img src="<c:url value='/template/web/img/logo.png'/>"></a></div>
            <!-- /LOGO -->

            <!-- MAIN NAVIGATION -->
            <div class="span9">
                <div class="navbar  pull-right">
                    <div class="navbar-inner">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav">
                                <li class="active"><a href="index.html">Home</a></li>

                                <li class="dropdown">
                                    <a href="about.html" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Company</a></li>
                                        <li><a href="#">History</a></li>
                                        <li><a href="#">Team</a></li>
                                    </ul>

                                </li>

                                <li><a href="#">Services</a></li>
                                <c:if test="${not empty login_name}">
                                    <li><a>Xin chào ${login_name}</a></li>
                                    <li><a href="<c:url value='/login?action=logout'/>"><fmt:message bundle="${lang}" key="label.logout"/></a></li>
                                </c:if>
                                <c:if test="${empty login_name}">
                                    <li><a href="<c:url value='/login?action=login'/>"><fmt:message bundle="${lang}" key="label.login"/></a></li>
                                </c:if>

                            </ul>
                        </div>

                    </div>
                </div>
            </div>
            <!-- MAIN NAVIGATION -->
        </div>
    </div>
</div>