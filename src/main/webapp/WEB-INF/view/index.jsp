<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="header.jsp" %>
<div class="row">
	<div class="col-sm-2" >
		<%@ include file="sidebar.jsp" %>
	</div>
	<div class="col-sm-10">
	<c:if test="${searchKeyWord!=null }">
			<div class="demoblog_articleBody">
				<div class="demoblog_articleTitle">
					Keyword <span class="text-success">"
					 ${searchKeyWord } 
					"</span>
					  search Result  	
				</div>
			</div>
		</c:if>
	<c:if test="${categoryName != null && fn:length(articles)==0 }">
		<div class="demoblog_articleBody">
				<div class="demoblog_articleTitle">
					当前分类下没有文章
				</div>
			</div>
	</c:if>
	
	<c:forEach var="article" items="${articles }">
		
		<div class="demoblog_articleBody">
			<div class="demoblog_articleTitle">
				<a href="info/${article.staticurl }.html">
					${article.title }
				</a>
			</div>
			<div class="demoblog_articleContent articleDescription" id="${article.id }">
				${article.description }
			</div>
			<div class="demoblog_articleInfo">
				<div class="demoblog_articleInfo_spans">
					<span class="glyphicon glyphicon-calendar"> </span>&nbsp; ${article.createtime } &nbsp;
					<span class="glyphicon glyphicon-paperclip"> </span> &nbsp;${article.category.title } &nbsp;
					<span class="glyphicon glyphicon-tags"> </span>
					&nbsp; 
					
					<c:forEach var="tag" items="${article.tagList }">
						${tag.name }&nbsp;、&nbsp;  
					</c:forEach>
					
					 &nbsp;
				</div>
			</div>
		</div>
	</c:forEach>
	
<%@ include file="footer.jsp" %>