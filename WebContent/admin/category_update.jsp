<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/admin_forms-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:56:15 GMT -->
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">

<title>My E-mall--Edit category</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/skin/default_skin/css/theme.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/admin-tools/admin-forms/css/admin-forms.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/img/favicon.ico">
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    
    <%@ include file="header.jsp" %>
    <%@ include file="left.jsp" %>
    
    <section id="content_wrapper">
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Edit category</h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="${ pageContext.request.contextPath}/CategoryServlet" method="post">
                    <input type="hiden" name="method" value="update">
                    <input type="hiden" name="cid" value="${category.cid} ">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic information </span>
                        </div>
                        <div class="section row">
                           
                        <div class="section row">
							<div class="col-md-2"></div>
							<div class="col-md-1">
                                <label for="sn" class="field prepend-icon">
                                    <label for="sn" class="field-icon">
										Name
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="sn" class="field">
                                    <input id="sn" name="cname" class="gui-input" placeholder="name" type="text" value="${category.cname }"/>
                                </label>
                            </div>
                        </div>
						
                        <div class="section row">
							<div class="col-md-2"></div>
							<div class="col-md-1">
                                <label for="sn" class="field prepend-icon">
                                    <label for="sn" class="field-icon">
										Description
                                    </label>
                                </label>
                            </div>
							<div class="col-md-6">
								<label for="address" class="field">
									<input id="address" name="cdesc" class="gui-input" placeholder="description" type="text" value="${category.cdesc }"/>
								</label>
							</div>
                        </div>
						
                        <div class="panel-footer text-center">
                            <button type="submit" class="button"> save </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> cancel </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

</section>
</div>
<style>
    /* demo page styles */
    body { min-height: 2300px; }

    .content-header b,
    .admin-form .panel.heading-border:before,
    .admin-form .panel .heading-border:before {
        transition: all 0.7s ease;
    }
    /* responsive demo styles */
    @media (max-width: 800px) {
        .admin-form .panel-body { padding: 18px 12px; }
    }
</style>

<style>
    .ui-datepicker select.ui-datepicker-month,
    .ui-datepicker select.ui-datepicker-year {
        width: 48%;
        margin-top: 0;
        margin-bottom: 0;

        line-height: 25px;
        text-indent: 3px;

        color: #888;
        border-color: #DDD;
        background-color: #FDFDFD;

        -webkit-appearance: none; /*Optionally disable dropdown arrow*/
    }
</style>
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="assets/admin-tools/admin-forms/js/jquery.validate.min.js"></script>
<script src="assets/admin-tools/admin-forms/js/additional-methods.min.js"></script>
<script src="assets/admin-tools/admin-forms/js/jquery-ui-datepicker.min.js"></script>
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
<script type="text/javascript" src="js/pages.js"></script>
<script type="text/javascript" src="js/items.js"></script>
</body>
</html>

