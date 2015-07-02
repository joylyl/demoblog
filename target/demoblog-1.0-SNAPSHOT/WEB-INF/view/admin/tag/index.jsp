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
                                <div class="panel-heading">添加标签信息 <div class="pull-right"><a  id="clearBox" class="label label-primary" style="cursor: pointer;"> 清空 </a></div> </div>
                                <div class="panel-body">
                                    <div class="input-group">
                                        <span class="input-group-addon">名称</span>
                                        <input type="text" class="form-control" id="name" name="name">
                                    </div>
                                    <hr/>
                                    <div class="input-group">
                                        <span class="input-group-addon">别名</span>
                                        <input type="text" class="form-control" id="alias" name="alias">
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
                                <td>操作</td>
                            </tr>
                            <c:forEach var="tag" items="${tags}">
                                <tr>
                                    <td>${tag.id}</td>
                                    <td>${tag.name}</td>
                                    <td>${tag.alias}</td>
                                    <td>
                                        <span class="glyphicon glyphicon-pencil updateThis" style="cursor: pointer;" ></span>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="delete.do?id=${tag.id}">
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

<%@ include file="../../footer.jsp" %>