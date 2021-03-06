<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
<div class="container">

    <!--Carousel
    ==================================================-->

    <div id="myCarousel" class="carousel slide">
        <div class="carousel-inner">

            <div class="active item">
                <div class="container">
                    <div class="row">

                        <div class="span6">

                            <div class="carousel-caption">
                                <h1>${people}</h1>
                                <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                            </div>

                        </div>

                        <div class="span6"> <img src="<c:url value='/template/web/img/slide/slide1.jpg'/>"></div>

                    </div>
                </div>




            </div>

            <div class="item">

                <div class="container">
                    <div class="row">

                        <div class="span6">

                            <div class="carousel-caption">
                                <h1>Example headline</h1>
                                <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <a class="btn btn-large btn-primary" href="#">Sign up today</a>
                            </div>

                        </div>

                        <div class="span6"> <img src="<c:url value='/template/web/img/slide/slide2.jpg'/>"></div>

                    </div>
                </div>

            </div>





        </div>
        <!-- Carousel nav -->
        <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

    </div>
    <!-- /Carousel -->



    <!-- Feature
      ==============================================-->


    <div class="row feature-box">
        <div class="span12 cnt-title">
            <h1>At vero eos et accusamus et iusto odio dignissimos</h1>
            <span>Contrary to popular belief, Lorem Ipsum is not simply random text.</span>
        </div>

        <div class="span4">
            <img src="<c:url value='/template/web/img/icon3.png'/>">
            <h2><fmt:message bundle="${lang}" key="label.guideline.listen"/> </h2>
            <p>
            </p>

            <a href="<c:url value="/danh-sach-huong-dan-nghe"/> "><fmt:message bundle="${lang}" key="label.guideline.listen"/> </a>

        </div>

        <div class="span4">
            <img src="<c:url value='/template/web/img/icon2.png'/>">
            <h2><fmt:message bundle="${lang}" key="label.exercise.paractice"/> </h2>
            <p>
            </p>
            <c:url value="/danh-sach-bai-tap" var="ListExercise">
                <c:param name="pojo.type" value="listening"/>
            </c:url>
            <a href="${ListExercise}"><fmt:message bundle="${lang}" key="label.exercise.paractice"/> </a>
        </div>

        <div class="span4">
            <img src="<c:url value='/template/web/img/icon1.png'/>">
            <h2><fmt:message bundle="${lang}" key="label.examination"/></h2>
            <p>
            </p>
            <c:url value="/danh-sach-bai-thi" var="ListExamination">
            </c:url>
            <a href="${ListExamination}"><fmt:message bundle="${lang}" key="label.examination"/> </a>
        </div>
    </div>


    <!-- /.Feature -->

    <div class="hr-divider"></div>

    <!-- Row View -->


    <div class="row">
        <div class="span6"><img src="<c:url value='/template/web/img/responsive.png'/>"></div>

        <div class="span6">
            <img class="hidden-phone" src="<c:url value='/template/web/img/icon4.png'/>" alt="">
            <h1>Fully Responsive</h1>
            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>
            <a href="#">Read More →</a>
        </div>
    </div>


</div>
</body>
</html>
