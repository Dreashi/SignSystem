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
			if($("#btn").val()==""){
				$("#hint").css("display","block");	
			}else{
				$("#hint").css("display","none");
			}
		},	
		onBlur1:function(){
			var str=$("#btn1").val();
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
			var str=$("#btn1").val();
			var re=/^1[34578]\d{9}/;
			if($("#btn").val()==""){
				$("#hint").css("display","block");	
			}else{
				$("#hint").css("display","none");
			}
			if(!re.test(str)){
				$("#hint-1").css("display","block");
			}else{
				$("#hint-1").css("display","none");
			}
			if($("#btn").val()!=""&&re.test(str)){
//				$.ajax({
//				type:"post",
//				url:"/logbyemail",
//				async:true,
//				data:{ "userName": '$("#btn").val()', "userPhone": '$("#btn2").val()'},
//			    dataType:"json",
//			    success:function(data){
//					if(data.userId==-1024){
//						alert("登陆失败");
//					}else{
//						alert(data.userId);
//					}
//			    }, 
//			    error:function(){
//					alert("请求失败");	
//			    },
//			});
			$("#bg").css("display","none");	
			}
		}
	}
});


$("#search").click(function(){
		window.location.href="search.html";
});

$("#wode").click(function(){
		window.location.href="wode.html";
});
$("#backzumiaoshu").click(function(){
	$("#bg1").css("display","none");
});



var str="";
var str1="";
$.ajax({
	type:"get",
	url:"member.json",
	dataType:"json",
	success:function(json1){
		str="<li class='leader'><img src='img/more-2.png'/><div class='group'>1</div><div class='headman'><img src='"+json1.list[0].userImage+"' class='headPic'/><p  class='name'>"+json1.list[0].userName+"</p></div></li>"
		for(var i=1;i<json1.list.length;i++){
			str1+="<li class='member'><img src='"+json1.list[i].userImage+"' class='headPic'/><p  class='name'>"+json1.list[i].userName+"</p><input type='checkbox' class='check' /></li>"
		}
		$(".admintor").append(str);
		$(".admintor").append(str1);
	},
	error:function(){
		alert("请求失败");	
	},
})

var b1 = false;
$("body").delegate(".admintor","click",function(){
	if(!b1){
		$(".admintor").children().eq(0).children().eq(0).attr("src","img/more_unfold-2.png");
		$(".admintor").children().css("display","flex");
		$(".admintor").children().eq(0).css("display","flex");
	}else{
		$(".admintor").children().eq(0).children().eq(0).attr("src","img/more-2.png");
		$(".admintor").children().css("display","none");
		$(".admintor").children().eq(0).css("display","flex");
	}
	b1 = !b1;
});
	
var b = true;
$("body").delegate("#delete","click",function(){
		if(!b){
			$(".check").css("display","none");
			$("#finish2").css("display","none");
		}else{
			$(".check").css("display","block");
			$("#finish2").css("display","block");
		}
		b = !b;
});

var b2 = true;
$("#plus").click(function(){
	if(!b2){
			$("#add").css("display","none");
			$("#delete").css("display","none");
			$("#describe").css("display","none");
			
		}else{
			$("#add").css("display","flex");
			$("#delete").css("display","flex");
			$("#describe").css("display","flex");
		}
		b2 = !b2;
});

$("#add").click(function(){
	$("#bg").css("display","block");
});

$("#describe").click(function(){
	$("#bg1").css("display","block");
});

$("#finish2").click(function(){
		$("#finish2").css("display","none");
		$(".check").css("display","none");
		b = !b;
});