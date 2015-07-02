<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<span id="demoblog_footer"></span>
<div class="demoblog_footer">
			自豪地采用 demoblog
		</div>
	</div>
</div>



</body>
<%--<script type="text/javascript" src="<%=basePath %>Resources/js/stickUp.min.js"></script>--%>
<script type="text/javascript">
     $(function(){
         $(document).scroll(function(){
             var obj = document.getElementById("demoblog_footer");
             var is = visibility(obj);
         });
     });

</script>
</html>