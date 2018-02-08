changeRootFont();
function changeRootFont(){
	document.documentElement.style.fontSize=((window.innerWidth/750)*100)+"px"
}
window.addEventListener("resize",changeRootFont,false);


var a=new Vue({
	el:"#bg",
	data:{
		
	},
	methods:{
		onBlur:function(){
			if($("#userName").val()==""){
				$("#hint").css("display","block");	
			}else{
				$("#hint").css("display","none");
			}
		},	
		onBlur1:function(){
			var str=$("#usePhone").val();
			var re=/^1[34578]\d{9}/;
			if(!re.test(str)){
				$("#hint-1").css("display","block");
			}else{
				$("#hint-1").css("display","none");
			}
		},
		miss:function(){
			$("#bg").css("display","none");
		},
		finish:function(){
			var str=$("#usePhone").val();
			var re=/^1[34578]\d{9}/;
			if($("#userName").val()==""){
				$("#hint").css("display","block");	
			}else{
				$("#hint").css("display","none");
			}
			if(!re.test(str)){
				$("#hint-1").css("display","block");
			}else{
				$("#hint-1").css("display","none");
			}
			if($("#userName").val()!=""&&re.test(str)){
				$.ajax({
					type:"post",
					url:"http://192.168.8.169:8080/saveHandler",
					dataType:"json",
					data:{"userName":$("#userName").val(),"userPhone":$("#usePhone").val()},
					success:function(json1){
						
					},
					error:function(){
						alert("请求失败");	
					},
				});	
//			$("#bg").css("display","none");	
			}
		}
	}
})


$("#search").click(function(){
		window.location.href="search.html";
});

$("#wode").click(function(){
		window.location.href="wode.html";
});
$("#add").click(function(){
	$("#bg").css("display","block");
});

var str="";
var str1="";
var str2="";
var str3="";
var arrs = [];
$(document).ready(function(){
	$.ajax({
	type:"get",
	url:"adminitor.json",
	dataType:"json",
	data:{},
	success:function(json1){
		var cnt = 0;
		for(x in json1){
			cnt++;
		};
		for(y in json1){
			for(var i=0;i<cnt;i++){
			if(y==0){
				console.log(json1[i][1].userName);
				str = "<li class='member1'><img src='"+json1[i][1].userImage+"' class='headPic'/><p  class='name'>"+json1[i][1].userName+"</p></li>";
				$(".admintor1").append(str);
			}else{
//				arrs.push(json1[i][0].userId);
				for(var j=0;j<json1[i].length;j++){
					if(j==0){
						str3 += "<input type='checkbox' name='userName' class='check'/>";
						str2 += "<li class='leader'><img src='img/more-2.png'/><div class='group'>"+json1[i][j].groupId+"</div><div class='headman'><img src='"+json1[i][j].userImage+"' class='headPic'/><p  class='name'>"+json1[i][j].userName+"</p></div></li>";						
					}else{
						str2 += "<li class='member'><img src='"+json1[i][j].userImage+"' class='headPic'/><p  class='name'>"+json1[i][j].userName+"</p></li>";
					}
				}
				$("#vue-app").append("<div class='boxUl'><ul class='admintor'>"+str2+"</ul>"+str3+"</div>");
				str2 = "";
				str3 = "";
			}
		}
		}
		
	},
	error:function(){
		alert("请求失败");	
	},
});

})
	


var b=false;
$("#vue-app").delegate(".leader","click",function(){
		if(b==false){
			$(this).children().eq(0).attr("src","img/more_unfold-2.png");
			$(this).css("display","flex");
			$(this).nextAll().css("display","flex");
			b=true;
		}else{
			$(this).children().eq(0).attr("src","img/more-2.png");
			$(this).css("display","flex");
			$(this).nextAll().css("display","none");
			b=false;
		}
});

var b1 = true;
$("body").delegate("#delete","click",function(){
		if(!b1){
			$(".check").hide();
			$("#finish1").hide();
			
		}else{
			$("#finish1").show();
			$(".check").show();
		}
		b1= !b1;
});


var b2 = true;
$("#plus").click(function(){
	if(!b2){
			$("#add").css("display","none");
			$("#delete").css("display","none");
			
		}else{
			$("#add").css("display","flex");
			$("#delete").css("display","flex");
		}
		b2 = !b2;
});
//var arr = [];
//var arrss = [];
//$("#finish1").click(function(){
//	for(var i=0;i<$(".check").length;i++){
//		if($(".check").eq(i).is(":checked")){
//			arr.push(1);
//		}else{
//			arr.push(0);
//		}
//	};
//	for(var j=0;j<arr.length;j++){
//		if(arr[j]==1){
//			var a = arrs[j];
//		};
//		arrss.push(a);
//	};
//	
//	console.log(arrss);
//		$.ajax({
//			type:"post",
//			url:"http://192.168.8.169:8080/deleteHandler",
//			dataType:"json",
//			data:{"gleaderList":arrss},
//			success:function(json1){
//				
//			},
//			error:function(){
//				alert("请求失败");	
//			},
//		});	
// 		arr = [];
//	$("#finish1").css("display","none");
//	$(".check").css("display","none");
//	b1 = !b1;
//});

		

