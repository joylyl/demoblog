<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="../header.jsp" %>
<div class="row">
	<div class="col-sm-1" >
		<%--<%@ include file="../../sidebar.jsp" %>--%>
		</div>
		<div class="col-sm-10">

           <%@ include file="header.jsp" %>

                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <form action="system.do" method="post" id="form">
                            <div class="panel panel-default">
                                <div class="panel-heading">系统信息管理</div>
                                <div class="panel-body">
                                    <input type="hidden" value="${system.id}" name="id"/>
                                    <div class="input-group">
                                        <span class="input-group-addon">名称</span>
                                        <input type="text" class="form-control" id="title" name="title" value="${system.title}">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">网址</span>
                                        <input type="text" class="form-control" id="url" name="url" value="${system.url}">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">关键字</span>
                                        <input type="text" class="form-control" id="key" name="key" value="${system.key}">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">描述</span>
                                        <input type="text" class="form-control" id="description" name="description" value="${system.description}">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">ICP备案信息</span>
                                        <input type="text" class="form-control" id="icp" name="icp" value="${system.icp}">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">SEO优化信息</span>
                                        <input type="text" class="form-control" id="seo" name="seo" value="${system.seo}">
                                    </div>
                                    <hr/>
                                    <input type="submit" class="btn btn-primary pull-right "/>
                                </div>
                                <div class="panel-footer"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                $(function(){
                    //修改
                    $(".updateThis").click(function(){
                        $("#tagId").remove();
                        var id = $(this).parent().prev().prev().prev().text();
                        var name = $(this).parent().prev().prev().text();
                        var alias = $(this).parent().prev().text();

                        $("#name").val(name);
                        $("#alias").val(alias);
                        var id = "<input type='hidden' name='id' id='tagId' value='"+id+"'>";
                        $("form").append(id);
                        $("form").attr("action","update.do");
                    });

                    $("#clearBox").click(function(){
                        $("#tagId").remove();
                        $("#name").val("");
                        $("#alias").val("");
                    });
                });
            </script>

<%@ include file="../footer.jsp" %>