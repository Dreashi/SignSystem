  changeRootFont();
 function changeRootFont() {
         document.documentElement.style.fontSize = ((window.innerWidth / 750) * 100) + 'px';
          } 
         window.addEventListener('resize', changeRootFont, false);
var b=true;       
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
					      		b = true;
				      	}
			      },
      zhuce:function(){
      	window.location.href="zhuce.html";
      },
      
      submit:function(){
      	if($("#username").val().length==0||$("#code").val().length==0){
			      	    	alert("手机号/密码不能为空");
			      	   }else if(b==false){
			      	   	  ;
			      	   }else{
			      	    	$.ajax({
										      		type:"get",
										      		url:"",
										      		dataType:"json",
										      		data:{},
										      		success:function(){
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
$("#btn-number").click(function(){
	window.location.href="denglu.html";
});
var timer = null;
var number = 60;
var bOnOff = true;
$("#id").click(function(){
	  if(b==true&&$("#username").val().length!=0){
	  	if(bOnOff){
	  	  bOnOff = false;
			  timer = setInterval(function(){
				  if(number>0){
					   number--;
					   $("#id").val(number+" s");
				  }else{
					   clearInterval(timer);
					   $("#id").val("获取验证码");
					   number = 60;
					   bOnOff = !bOnOff;
				  }
		    },1000);
	  }
	  	$.ajax({
	  	type:"get",
	  	url:"",
	  	dataType:"json",
	  	data:{},
	  	success:function(){
	  	},
	  	error:function(){
	  		alert("请求失败")
	  	}
	  });
	  }else{
	  	alert("请填写正确的手机号");
	  }
	  
});

