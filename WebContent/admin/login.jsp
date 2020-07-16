<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome to my E-mall</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/img/favicon.ico">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1>my E-mall</h1>
                    <p class="lead">Welcome to use my E-mall management system</p>
                    <font color="red">${msg}</font>
                </div>
                <div class="panel mt30 mb25">
                    <form method="post" action="${pageContext.request.contextPath}/UserServlet" id="contact">
                    <input type="hidden" name="method" value="login">
                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="sn" class="field-label text-muted fs18 mb10">Username</label>
                                <label for="sn" class="field prepend-icon">
                                    <input type="text" name="username" id="username" class="gui-input" placeholder="Please type in your username...">
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password" class="field-label text-muted fs18 mb10">Password</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="Please type in your password...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div> 
                        <div class="panel-footer clearfix text-center">
							<button type="submit" class="button btn-primary mr10"> log in </button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </section>
</div>
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>
