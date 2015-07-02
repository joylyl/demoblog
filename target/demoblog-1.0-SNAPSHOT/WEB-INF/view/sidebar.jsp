<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="sidebar" id="sidebar">
			<div class="text-center demoblog_title" id="title">
				<a href="<%=basePath %>index.html">${system.title }</a>
			</div>
			<div class="list-group">
			  <div class="list-group-item">
<!-- 			  <div class="row"> -->
				  　<form action="<%=basePath %>search.do" style="margin-top:-20px;margin-bottom:0px;">
                  搜　　索　
                  <input type="text" class="form-control" name="keyword">
              </form>
<!-- 			  </div> -->
			  </div>
			  <c:forEach var="category" items="${categories }">
			  	<a href="<%=basePath %>category/${category.alias }.html" class="list-group-item">${category.title }</a>
			  </c:forEach>

			</div>
		</div>