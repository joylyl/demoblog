<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
    
<html>
<head>
<meta charset="utf-8">
<title>
    <c:if test="${article != null}">${article.title} - </c:if>
${system.title} - ${system.key}</title>
<!-- 网页的描述以及关键字 -->
<meta name="description" content="${system.description}">
    <meta name="keywords" content="${system.key}">
    <meta name="title" content="${system.title}">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<%=basePath %>Resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>Resources/css/style.css" />
<script src="<%=basePath %>Resources/js/jquery.1.11.1.min.js" type="text/javascript"></script>
<script src="<%=basePath %>Resources/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>Resources/css/monokai_sublime.min.css" />
    <script src="<%=basePath %>Resources/js/isVisibility.js" type="text/javascript"></script>
</head>
<body>
<%--<br/>--%>
<%--<div class="row">--%>
    <%--<div class="col-sm-3"></div>--%>
    <%--<div class="col-sm-6">--%>
        <%--<div class="row">--%>
            <%--<div class="col-sm-5"><span style="font-size: 80px">${system.title}</span></div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-sm-3"></div>--%>
<%--</div>--%>
<%--<div class="row">--%>
    <%--<div class="col-sm-7"></div>--%>
    <%--<div class="col-sm-4"><input type="text" class="form-control" size="20"/></div>--%>
    <%--<div class="col-sm-1"></div>--%>
<%--</div>--%>