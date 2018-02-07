changeRootFont();
function changeRootFont(){
	document.documentElement.style.fontSize=((window.innerWidth/750)*100)+"px"
}
window.addEventListener("resize",changeRootFont,false);

$("#back").click(function(){
		window.location.href="wode.html";
})

$(document).ready(function(){
	$.ajax({
	type:"post",
	url:"http://127.0.0.1:8080/personCenter/getUserInf",
	dataType:"json",
	data:{"userPhone":"13943827777"},
	success:function(data){
		console.log(data);
		var imageurl = data.userImage;
		$("#name>span").text(data.userName);
		$("#head>span>img").attr("src",imageurl);
		$("#sex>span").text(data.userSex);
		$("#birthday>span").text(data.userBirthday);
		$("#qq>span").text(data.userQQ);
		$("#phone>span").text(data.userPhone);
	},
	error:function(){
		alert("用户名请求失败");
	}
 });	
})