<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar">
			<div class="text-center demoblog_title" id="title">
				<a href="${url }index.html">${siteName }</a>
			</div>
			<div class="list-group">
			  <div class="list-group-item">
<!-- 			  <div class="row"> -->
				  　<form action="searchByKeyword.do" style="margin-top:-20px;margin-bottom:0px;">
				  	 搜　　索　
				  	<input type="text" class="form-control" name="keyword">
				  </form>
<!-- 			  </div> -->
			  </div>
			  <c:forEach var="category" items="${categories }">
			  	<a href="${url }category/${category.title }.html" class="list-group-item">${category.title }</a>
			  </c:forEach>
			  
<!-- 			  <a href="#" class="list-group-item">个人开发</a> -->
<!-- 			  <a href="#" class="list-group-item">编程语言</a> -->
<!-- 			  <a href="#" class="list-group-item">资源分享</a> -->
<!-- 			  <a href="#" class="list-group-item">操作系统</a> -->
<!-- 			  <a href="#" class="list-group-item">建站资源</a> -->
<!-- 			  <a href="#" class="list-group-item">网　　摘</a> -->
<!-- 			  <a href="#" class="list-group-item">留　　言</a> -->
<!-- 			  <a href="#" class="list-group-item">关　　于</a> -->
			</div>
		</div>