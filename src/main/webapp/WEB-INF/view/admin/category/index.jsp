<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="../../header.jsp" %>
<div class="row">
                <div class="col-sm-1" >
                    <%--<%@ include file="../../sidebar.jsp" %>--%>
                </div>
                <div class="col-sm-10">

                    <%@ include file="../header.jsp" %>

                <div class="row">
                    <div class="col-sm-4">
                        <form action="add.do" method="post" id="form">
                            <div class="panel panel-default">
                                <div class="panel-heading">添加分类信息</div>
                                <div class="panel-body">
                                    <div class="input-group">
                                        <span class="input-group-addon">名称</span>
                                        <input type="text" class="form-control" id="title" name="title">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">别名</span>
                                        <input type="text" class="form-control" id="alias" name="alias">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">父级</span>
                                        <select class="form-control" id="parentId" name="parentId">
                                            <option value="-1">无父级</option>
                                            <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}">${category.title}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <hr/>
                                    <input type="submit" class="btn btn-primary pull-right  "/>
                                </div>
                                <div class="panel-footer"></div>
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-8">
                        <table class="table table-cell table-responsive table-bordered table-row-cell table-hover table-condensed table-striped table-bordered">
                            <tr>
                                <td>编号</td>
                                <td>名称</td>
                                <td>别名</td>
                                <td>父级</td>
                                <td>操作</td>
                            </tr>
                            <c:forEach var="category" items="${categories}">
                                <tr>
                                    <td>${category.id}</td>
                                    <td>${category.title}</td>
                                    <td>${category.alias}</td>

                                    <c:choose>
                                        <c:when test="${category.parent != null }">
                                            <td id="${category.parentId}">  ${category.parent.title}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td id="-1">无父级</td>
                                        </c:otherwise>
                                    </c:choose>

                                    <td>
                                        <span class="glyphicon glyphicon-pencil updateThis" style="cursor: pointer;" ></span>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="delete.do?id=${category.id}">
                                            <span class="glyphicon glyphicon-remove deleteThis" style="cursor: pointer;" ></span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>

            <script>
                $(function(){
                    //修改
                    $(".updateThis").click(function(){
                        $("#cateId").remove();
                        var id = $(this).parent().prev().prev().prev().prev().text();
                        var title = $(this).parent().prev().prev().prev().text();
                        var alias = $(this).parent().prev().prev().text();
                        var parent = $(this).parent().prev().text();

                        console.info(parent);
                        $("#title").val(title);
                        $("#alias").val(alias);
                        var id = "<input type='hidden' name='id' id='cateId' value='"+id+"'>";
                        $("form").append(id);
                        $("form").attr("action","update.do");
                        $("#parentId").find("option:selected").removeAttr("selected");
                        $("#parentId").find("option[value='"+parent+"']").attr("selected","selected");

                    });

                });
            </script>

<%@ include file="../../footer.jsp" %>