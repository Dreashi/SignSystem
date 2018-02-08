changeRootFont();
function changeRootFont(){
	document.documentElement.style.fontSize=((window.innerWidth/750)*100)+"px"
}
window.addEventListener("resize",changeRootFont,false);

var str="";
var a=new Vue({
	el:"#vue-app",
	data:{
		seen:false
	},
	methods:{
		changeStatic:function(){
			this.seen=!this.seen;
			if(this.seen==false){$("#arrow").attr("src","img/more-2.png")}
			if(this.seen==true){$("#arrow").attr("src","img/more_unfold-2.png")}
			if(this.seen==true){
				$.ajax({
					type:"get",
					url:"member.json",
					dataType:"json",
					success:function(json1){
						for(var i=0;i<json1.list.length;i++){
							str+="<li><img src='"+json1.list[i].userImage+"'/><p  class='er'>"+json1.list[i].userName+"</p></li>";
							
						}
						$("#member").html(str);
					},
					error:function(){
							alert("请求失败");	
					   },
					});
			var str="";
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

		



