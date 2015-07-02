<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp" %>
<h3 style="padding: 0px 40px;line-height: 35px;">${article.title }</h3>
<br/>
<div class="wap_article_content">
    ${article.content }
</div>
<br/>
<script src="<%=basePath %>Resources/js/highlight.min.js"></script>
<script >hljs.initHighlightingOnLoad();</script>
<script>
    $(function(){
        var windowWidth = $(window).width();
        $("img").each(function(){//如果有很多图片，我们可以使用each()遍历
            var img_w = $(this).width();//图片宽度
            var img_h = $(this).height();//图片高度
            if(img_w >= windowWidth || img_w > (windowWidth-80) ){//如果图片宽度超出容器宽度--要撑破了
                var height = ((windowWidth-80)*img_h)/img_w; //高度等比缩放
                $(this).css({"width":(windowWidth-80),"height":height});//设置缩放后的宽度和高度
            }
        });
    });
</script>
</body>
</html>