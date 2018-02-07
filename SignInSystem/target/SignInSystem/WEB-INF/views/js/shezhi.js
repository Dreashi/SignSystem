changeRootFont();
function changeRootFont(){
	document.documentElement.style.fontSize=((window.innerWidth/750)*100)+"px"
}
window.addEventListener("resize",changeRootFont,false);


$("#back").click(function(){
		window.location.href="wode.html";
})

