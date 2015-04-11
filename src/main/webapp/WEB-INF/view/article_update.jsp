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
				<c:choose>
					<c:when test="${article == null }">
						写新文章
					</c:when>
					<c:otherwise>
						修改文章
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test=""></c:if>
			<div class="demoblog_articleContent">
			<%--如果没有article,那么就执行新增功能 --%>
			<c:choose>
				<c:when test="${article == null }">
					<form action="${url }admin/newarticle.html" method="post">
				</c:when>
				<c:otherwise>
					<form action="${url }admin/updatearticle.do" method="post">
				</c:otherwise>
			</c:choose>
				
				<input type="hidden" name="id" value="${article.id }" />
					<div class="input-group">
					  <span class="input-group-addon">标题</span>
					  <input type="text" class="form-control" value="${article.title }" name="title" placeholder="article title : 例如 世界, 你好!">
					</div>
					<hr/>
					<div class="input-group">
					  <span class="input-group-addon">链接</span>
					  <input type="text" class="form-control" value="${article.staticurl }" name="staticurl" placeholder="static url : 文章别名 例如 helloword ">
					</div>
					<hr/>
					<div class="row">
						<div class="col-sm-5">
							<div class="input-group">
							  <span class="input-group-addon">类别</span>
							 <select name="cateid" id="" class="form-control">
							 	<c:forEach var="category" items="${categories }">
							 		<option value="${category.id}">${category.title }</option>
							 	</c:forEach>
							 </select>
							</div>
						</div>
						<div class="col-sm-4 col-sm-offset-3">
						    <div class="input-group">
						      <span class="input-group-addon">
						        <input type="checkbox" name="isrecover">
						      </span>
						      <input type="text" class="form-control" value="进入回收站 ?(首页不可见)" readonly="readonly">
						    </div>
						</div>		
					</div>
					<hr/>
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
							  <span class="input-group-addon input_tag">标签</span>
							  <div class="tagBox">
							  	<c:forEach var="tag" items="${article.tagList }">
							  		<span class='demoblog_badge' id="${tag.id }">${tag.name }</span>
							  	</c:forEach>
							  </div>
							  <input type="hidden" name="tags" id="tags" value="${article.tags }"/>
							</div>
						</div>
						<div class="col-sm-4">
							 <select name="" id="" class="form-control tagsSelect">
							 	<c:forEach var="tag" items="${tags }">
							  		<option value="${tag.id }">${tag.name }</option>
							  	</c:forEach>
							 </select>
						</div>
					</div>
					<hr/>
					<div class="input-group">
					  <span class="input-group-addon">描述</span>
					  <textarea class="form-control" name="description" placeholder="article description 文章的简要描述" rows="5">${article.description }</textarea>
					</div>
					<hr/>
					<div class="input-group">
					  <span class="input-group-addon">正文</span>
					  <textarea class="form-control" name="content" placeholder="article title  建议使用Markdown格式编写" rows="20">${article.contentSource }</textarea>
					</div>
					<hr/>
					<input type="submit" value="提交" class="form-control btn btn-default">
				</form>
			</div>
		</div>
<script>
	$(function(){
		$(".tagsSelect").change(function(){
			//得到选中的text值
			var text = $(this).find("option:selected").text();
			//检查元素是否存在.存在则不再添加
			if ( $("#"+text).length > 0 ) {
				return ;
			}
			//动态添加
			$(".tagBox").append("<span class='demoblog_badge' id='"+text+"'>" + text + "</span>");
			var tagsVal = $("#tags").val();
			if(tagsVal == "")
				$("#tags").val(text);
			else
				$("#tags").val(tagsVal+","+text);
		});
		//动态设置事件
		$(document).on("click",".demoblog_badge",function(){
			var id = $(this).attr("id");
			$("#"+id).remove();
		});
	});
</script>
<%@ include file="footer.jsp" %>

