<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../header.jsp" %>
<div class="row">
	<div class="col-sm-1" >
		<%@ include file="../../sidebar.jsp" %>
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

			<div class="demoblog_articleContent">
			<%--如果没有article,那么就执行新增功能 --%>
			<c:choose>
				<c:when test="${article == null }">
					<form action="<%=basePath %>admin/article/add.do" method="post">
				</c:when>
				<c:otherwise>
					<form action="<%=basePath %>admin/article/execUpdate.do" method="post">
				</c:otherwise>
			</c:choose>

             <c:if test="${article != null }">
                 <input type="hidden" name="id" value="${article.id }" />
             </c:if>
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
						        <input type="checkbox" name="isrecover" value="0">
						      </span>
						      <input type="text" class="form-control" id="checkIsRecover" value="进入回收站 ?(首页不可见)" readonly="readonly">
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
							 <select class="form-control tagsSelect">
                                 <option value="-1">请选择</option>
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
            var id =  $(this).find("option:selected").val();
            console.info(text);
			//检查元素是否存在.存在则不再添加
			if ( $("#"+id).length > 0 ) {
				return ;
			}
			//动态添加
			$(".tagBox").append("<span class='demoblog_badge' id='"+id+"'>" + text + "</span>");
			var tagsVal = $("#tags").val();
			if(tagsVal == "")
				$("#tags").val(id);
			else
				$("#tags").val(tagsVal+","+id);
		});

		//动态设置事件
		$(document).on("click",".demoblog_badge",function(){
			var id = $(this).attr("id");
			$("#"+id).remove();
            var tags = $("#tags").val();
            var splitvals = tags.split(",");
            for(var i = 0 ; i< splitvals.length ; i++){
                if(id == splitvals[i]){
                    splitvals.splice(i,1);
                }
            }
            var ids = splitvals.join(",");
            $("#tags").val(ids);
		});

        $("input[name='isrecover']").change(function(){
            var value = $(this).val();
            if(value=="1"){
                $(this).val("0");
            }else
                $(this).val("1");
        });
	});
</script>
<%@ include file="../../footer.jsp" %>

