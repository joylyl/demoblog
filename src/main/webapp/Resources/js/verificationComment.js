var checkUserName = false ;
var checkEmail = false ;
var checkContent = false ;
var checkLink = false ;

var userName = $("#userName").val();
var email =$("#email").val();
var link = $("#link").val();
var content = $("#comment_content").val();

$("#userName").blur(function(){

    var userName = $(this).val();
    if(isNaN(userName) || userName.length<3) {
        $("#userNameInfo").text("用户名不能是长度小于3的字符或者数字");
        $("#userNameInfo").attr("class","text-danger");
        checkUserName = false;
    }
    else {
        $("#userNameInfo").text("用户名正确性已一步到位");
        $("#userNameInfo").attr("class","text-success");
        checkUserName = true;
    }
});

$("#email").blur(function(){

    var email = $(this).val();
    //邮箱正则
    var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;

    if(!emailReg.test(email)){
        $("#emailInfo").text("没有这个格式的邮箱地址");
        $("#emailInfo").attr("class","text-danger");
        checkEmail = false;
    }
    else {
        $("#emailInfo").text("邮箱地址正确性已一步到位");
        $("#emailInfo").attr("class","text-success");
        checkEmail = true;
    }
});


$("#commentContent").blur(function(){

    alert("dhdfh");
    var content = $(this).val();

    if(isNaN(content)||content.length<5) {
        $("#contentInfo").text("评论内容是长度不能小于5或者数字");
        $("#contentInfo").attr("class","text-danger");
        checkContent = false;
    }
    else {
        $("#contentInfo").text("正文内容正确性已一步到位");
        $("#contentInfo").attr("class","text-success");
        checkContent = true;
    }

});


$("#link").blur(function(){

    var link = $(this).val();
    var linkReg = /((http|ftp|https|file):\/\/([\w\-]+\.)+[\w\-]+(\/[\w\u4e00-\u9fa5\-\.\/?\@\%\!\&=\+\~\:\#\;\,]*)?)/;

    //可以为空,但不能非法
    if(isNaN(link)||linkReg.test(link)) {
        $("#linkInfo").text("链接地址格式不正确(可以为空)");
        $("#linkInfo").attr("class","text-danger");
        checkLink = false;
    }
    else {
        $("#linkInfo").text("链接地址正确性已一步到位");
        $("#linkInfo").attr("class","text-success");
        checkLink = true;
    }

});

$("from").submit(function(){
    if(checkUserName&&checkEmail&&checkLink){
        return true;
    }
    return false;
});

//留言
$("#addComment").click(function(){

    //alert($("#demoblog_articleContent > form").serialize());
    //if(checkUserName&&checkEmail&&checkLink){
    //    $.post("addcomment.do",{"userName":userName , "userEmail":email , "content":content , "userLink":link},function(data){
    //        $("#alertInfo").text(data);
    //    });
    //}else
    //    $("#alertInfo").text("我没上过学,不要骗我");
});