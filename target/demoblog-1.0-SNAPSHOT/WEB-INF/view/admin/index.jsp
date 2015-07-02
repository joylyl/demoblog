<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../header.jsp" %>
<div class="row">
	<div class="col-sm-1" >
		<%--<%@ include file="../sidebar.jsp" %>--%>
		</div>
		<div class="col-sm-10">
            <div class="demoblog_articleBody_transparent">
                <a href="<%= basePath%>admin/index.html" class="btn btn-primary">后台首页</a>
                <a href="<%= basePath%>admin/article/add.html" class="btn btn-primary">撰写文章</a>
                <a href="<%= basePath%>admin/tag/index.html" class="btn btn-primary">添加标签</a>
                <a href="<%= basePath%>admin/category/index.html" class="btn btn-primary">添加类别</a>
                <a href="<%= basePath%>admin/updateCache.do" class="btn btn-primary">更新缓存</a>
                <a href="<%= basePath%>admin/logout.do" class="btn btn-primary pull-right">帐号退出</a>
            </div>

			<div class="demoblog_articleBody">
				<div class="row">
					<div class="col-sm-6">
						<div class="panel-primary" style="border:1px solid #000">
							<div class="panel-heading">热门 top 10</div>
							<div class="panel-body">
								<ul class="list-group">
									<c:forEach var="m" items="${max}">
										<li class="list-group-item"> <a href="<%= basePath%>info/${m.staticurl}.html">${m.title}</a> </li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-6 ">
						<div class="panel-primary" style="border:1px solid #000">
							<div class="panel-heading">最新 top 10</div>
							<div class="panel-body">
								<ul class="list-group">
									<c:forEach var="m" items="${orderby}">
										<li class="list-group-item"> <a href="<%= basePath%>/info/${m.staticurl}.html">${m.title}</a> </li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

                <br/>

                <div class="demoblog_articleBody" style="padding:0px 15px;">
                    <div class="row">
                        <table class="table table-bordered table-cell table-responsive table-view">
                            <tr style="border-bottom: 1px solid #CCC">
                                <td>编号</td>
                                <td>标题</td>
                                <td>标签</td>
                                <td>分类</td>
                                <td>View</td>
                                <td>操作</td>
                            </tr>
                            <c:forEach var="article" items="${articles}">
                                <tr>
                                    <td>${article.id}</td>
                                    <td>${article.title}</td>
                                    <td>
                                        <c:forEach var="tag" items="${article.tagList}">
                                            ${tag.name}&nbsp;&nbsp;
                                        </c:forEach>
                                    </td>
                                    <td>${article.category.title}</td>
                                    <td>${article.view}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${article.isrecover == 1}">
                                                <a href="article/notrash.do?id=${article.id}" data-toggle="tooltip" data-placement="top" title="从回收站恢复" style="text-decoration: none">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="article/trash.do?id=${article.id}" data-toggle="tooltip" data-placement="top" title="移动到回收站(在首页将不可见)" style="text-decoration: none">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="article/${article.id}/update.html">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>


<%@ include file="../footer.jsp" %>