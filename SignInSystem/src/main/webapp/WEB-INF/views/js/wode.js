changeRootFont();
function changeRootFont(){
	document.documentElement.style.fontSize=((window.innerWidth/750)*100)+"px"
}
window.addEventListener("resize",changeRootFont,false);

$("#inf").click(function(){
		window.location.href="gerenxinxi.html";
});

$("#headpic").click(function(){
		window.location.href="gerenxinxi.html";
});

$("#set").click(function(){
		window.location.href="shezhi.html";
})

