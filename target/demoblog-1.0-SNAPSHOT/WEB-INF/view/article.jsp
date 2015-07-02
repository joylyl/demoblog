<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<div class="row">
	<div class="col-sm-1" >
		<%@ include file="sidebar.jsp" %>
	</div>
	<div class="col-sm-10">
		<div class="demoblog_articleBody">
			<div class="demoblog_articleTitle">
				${article.title }
			</div>
			<div class="demoblog_articleContent">
				${article.content }
			</div>
			<div class="demoblog_articleInfo">
				<div class="demoblog_articleInfo_spans">
					<span class="glyphicon glyphicon-eye-open"> </span> &nbsp; ${article.view} views &nbsp;
					<span class="glyphicon glyphicon-calendar"> </span> &nbsp; ${article.createtime } &nbsp;
					<span class="pull-right text-success"> 本文地址: <%=basePath %>info/${article.staticurl }.html</span>
				</div>	
			</div>
		</div>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="<%=basePath %>Resources/js/verificationComment.js"></script>
    <script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
<script >hljs.initHighlightingOnLoad();</script>
