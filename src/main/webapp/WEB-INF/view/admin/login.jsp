<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="../header.jsp" %>
<div class="row">
	<div class="col-sm-1" >
		</div>
		<div class="col-sm-10">
            <div class="row">
                <div class="demoblog_articleBody">
                    <div class="demoblog_articleTitle">管理员登录</div>
                    <div class="demoblog_articleContent articleDescription">
                        <form action="login.do" method="post">
                            <div class="row">
                                <div class="col-sm-6 col-sm-offset-3">
                                    <c:if test="${msg!=null}">
                                        <div class="alert alert-danger">${msg}</div>
                                    </c:if>
                                    <div class="input-group">
                                        <span class="input-group-addon">用户名</span>
                                        <input type="text" class="form-control" placeholder="username" name="username">
                                    </div>
                                    <br/>
                                    <div class="input-group">
                                        <span class="input-group-addon">密　码</span>
                                        <input type="password" class="form-control" placeholder="password" name="password">
                                    </div>
                                    <br/>
                                    <input type="submit" class="btn btn-primary btn-sm pull-right" value="登录"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="demoblog_articleInfo">

                    </div>
                </div>
            </div>
<%@ include file="../footer.jsp" %>