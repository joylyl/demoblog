<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="header.jsp" %>
<div class="row">
	<div class="col-sm-1"  >
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
        <c:if test="${categoryName!=null }">
            <div class="demoblog_articleBody">
                <div class="demoblog_articleTitle">
                    <span class="text-success">"
                     ${categoryName }
                    "</span>
                    分类下的文章
                </div>
            </div>
        </c:if>
            <c:if test="${tagName!=null }">
            <div class="demoblog_articleBody">
                <div class="demoblog_articleTitle">
                    <span class="text-success">"
                     ${tagName }
                    "</span>
                    标签下的文章
                </div>
            </div>
            </c:if>

	<c:if test="${categoryOrTagName != null && fn:length(articles)==0 }">
		<div class="demoblog_articleBody">
				<div class="demoblog_articleTitle">
					当前分类下没有文章
				</div>
			</div>
	</c:if>
	
	<c:forEach var="article" items="${articles }">
		<div class="demoblog_articleBody">
			<div class="demoblog_articleTitle">
				<a href="<%=basePath %>info/${article.staticurl }.html">
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
					
					<c:forEach var="tag" items="${article.tagList }" varStatus="loop">
						<%-- 如果是最后一个 --%>
						<c:choose>
							<c:when test="${fn:length(article.tagList ) == loop.index+1 }">
								<a href="<%=basePath %>tag/${tag.alias}.html">${tag.name }</a>&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<a href="<%=basePath %>tag/${tag.alias}.html">${tag.name }</a>&nbsp;、&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					 &nbsp;
				</div>
			</div>
		</div>
	</c:forEach>
<span id="demoblog_footer"></span>
            <script type="text/javascript">
                $(function(){
                    var pageNo = 1;
                    $(document).scroll(function(){
                        var obj = document.getElementById("demoblog_footer");
                        var is = visibility(obj);
                        if(is){
                            $.ajax({
                                type: "POST",
                                url: "ajaxGetArticles.do",
                                async: true,
                                data: {"pageNo":pageNo,"pageSize":20},
                                beforeSend: function(){
                                    if($("#loading").length < 1){
                                        var busy ="<div class='demoblog_articleBody' id='loading'><div class='alert alert-info' id='alertbusy' style='margin-bottom: 0px;color:#676666'>&nbsp;<img id='loadingImg' src='<%=basePath %>Resources/images/loading.gif' alt='正在加载'>&nbsp;&nbsp;正在加载</div></div>";
                                        $(".demoblog_articleBody").last().after(busy);
                                    }
                                },
                                success: function(data){
                                    var articles = $.parseJSON(data);
                                    if(articles.length == 0){
                                        $("#alertbusy").html("<span class='glyphicon glyphicon-ok'></span>&nbsp;所有文章加载完毕");
                                        return ;
                                    }else{
                                        pageNo++;
                                        $("#loading").remove();
                                    }
                                    for(var i = 0; i< articles.length ; i++){
                                        var tags = "";
                                        for(var j = 0; j< articles[i].tagList.length ; j++){
                                            if(j>0){
                                                tags+="、"+articles[i].tagList[j];
                                            }else
                                                tags+=articles[i].tagList[j].name;
                                        }
                                        var articleBody ="<div class='demoblog_articleBody'>"+
                                                "<div class='demoblog_articleTitle'><a href='<%=basePath %>info/"+articles[i].staticurl+".html'>"+articles[i].title+"</a></div>"+
                                                "<div class='demoblog_articleContent articleDescription' id='"+articles[i].id+"'>"+articles[i].description+"</div>"+
                                                "<div class='demoblog_articleInfo'><div class='demoblog_articleInfo_spans'>"+
                                                "<span class='glyphicon glyphicon-calendar'> </span>&nbsp; "+articles[i].createtime+" &nbsp;"+
                                                "<span class='glyphicon glyphicon-paperclip'> </span> &nbsp;"+articles[i].category.title+" &nbsp;"+
                                                "<span class='glyphicon glyphicon-tags'> </span>&nbsp;"+tags+"&nbsp;</div></div></div>";
                                        $(".demoblog_articleBody").last().after(articleBody);
                                    }
                                }
                            });
                        }
                    });
                });
            </script>
<%@ include file="footer.jsp" %>

