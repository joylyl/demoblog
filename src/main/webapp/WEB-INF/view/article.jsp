<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<div class="row">
	<div class="col-sm-2" >
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
					<span class="glyphicon glyphicon-eye-open"> </span>&nbsp; 120 view &nbsp;
					<span class="glyphicon glyphicon-comment"> </span> &nbsp; 90 comment &nbsp;
					<span class="pull-right text-success"> 本文地址: http://www.codeinfo.me/article.html</span>
				</div>	
			</div>
		</div>

		<div class="demoblog_articleBody">
			<div class="demoblog_articleTitle">
				评论
			</div>
			<div class="demoblog_articleContent">
				<form>
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
							  <span class="input-group-addon">用户名</span>
							  <input type="text" class="form-control" placeholder="">
							</div>
						</div>
					</div>
					<br/>
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
							  <span class="input-group-addon">邮　箱</span>
							  <input type="text" class="form-control" placeholder="">
							</div>
						</div>
					</div>
					<br/>
					<div class="row">
						<div class="col-sm-12">
							<div class="input-group">
							  <span class="input-group-addon">内　容</span>
							  <textarea name="" id="" cols="40" rows="5" class="form-control"></textarea>
							</div>
						</div>
					</div>
					<br/>
				</form>
			</div>
		</div>

	
<%@ include file="footer.jsp" %>

<script type="text/javascript">
      $(function(){
     	$('.sidebar').stickUp({});
     });
    </script>
    <script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
<script >hljs.initHighlightingOnLoad();</script>