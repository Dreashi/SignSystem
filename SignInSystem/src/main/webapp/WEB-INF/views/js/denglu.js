  changeRootFont();
 function changeRootFont() {
         document.documentElement.style.fontSize = ((window.innerWidth / 750) * 100) + 'px';
          } 
         window.addEventListener('resize', changeRootFont, false)
var b =true;         
new Vue({
	el:"#vue-user",
	data:{
		
	},
	methods:{
            onBlur:function(){
		      	      var str=$("#username").val();
					      	var re=/^1[34578]\d{9}/;
					      	if(!re.test(str)){
							      		$("#prompt").css("display","block");
							      		b=false;
							      		return false;
					      	}else{
					      		    $("#prompt").css("display","none");
					      		    b=true;
					      	}
            },
			      tiaozhuan:function(){
			      	    window.location.href="id-code.html";
			      },
			      submit:function(){
			      	   if($("#username").val().length==0||$("#password").val().length==0){
			      	    	alert("手机号/密码不能为空");
			      	   }else if(b==false){
			      	   	  ;
			      	   }else{
			      	    	$.ajax({
										      		type:"post",
										      		url:"http://127.0.0.1:8080/shiro/login",
										      		dataType:"json",
										      		data:{"userPhone":$("#username").val(),"userPassword":$("#password").val()},
										      		success:function(data){
										      			console.log(data);
										      			window.location.href="gerenxinxi.html"
										      		},
										      		error:function(){
										      			alert("请求失败");
										      		}
						      	      });
			      	   }
			            
			      }
	
},
	
	computed:{
		
	}
})
