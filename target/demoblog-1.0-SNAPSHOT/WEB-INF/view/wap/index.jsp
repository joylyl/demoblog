<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ include file="../header.jsp" %>
<ul class="list-group">
    <c:forEach var="article" items="${articles }">
        <li class="wap_article_title">
            <a href="<%=basePath %>info/${article.staticurl }.html">${article.title }</a>
            <br/>
                ${article.description}
        </li>
    </c:forEach>
</ul>
<span id="demoblog_footer"></span>
</body>
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
                            var busy ="<div class='alert alert-info' id='loading' style='margin-bottom: 0px;color:#676666;text-align: center;'>&nbsp;<img id='loadingImg' src='<%=basePath %>Resources/images/loading.gif' alt='正在加载'>&nbsp;&nbsp;正在加载</div>";
                            $("ul").after(busy);
                        }
                    },
                    success: function(data){
                        var articles = $.parseJSON(data);
                        if(articles.length == 0){
                            $("#loading").html("<span class='glyphicon glyphicon-ok'></span>&nbsp;所有文章加载完毕");
                            return ;
                        }else{
                            pageNo++;
                            $("#loading").remove();
                        }
                        for(var i = 0; i< articles.length ; i++){
                            var li = " <li class='wap_article_title'><a href='<%=basePath %>info/"+articles[i].staticurl+".html'>"+articles[i].title+"</a><br/>"+articles[i].description+"</li>";
                            $("ul").append(li);
                        }
                    }
                });
            }
        });
    });
</script>

</html>