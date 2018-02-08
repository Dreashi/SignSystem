// JavaScript Document

function $( v ){
	if( typeof v === 'function' ){
		window.onload = v;
	} else if ( typeof v === 'string' ) {
		return document.getElementById(v);
	} else if ( typeof v === 'object' ) {
		return v;
	}
}

function getStyle( obj, attr ){
	return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle( obj )[attr];
}

function addZero( num ){
	return num<10 ? "0"+num : ""+num;
}

function doMove(obj,end,dr,attr,endFn){
	dr = end>parseInt(getStyle(obj,attr)) ? dr : -dr;
	clearInterval(obj.timer);
	obj.timer = setInterval(function (){
		var nextVal = parseInt(getStyle(obj,attr))+dr;
		if(nextVal>=end&&dr>0||dr<0&&nextVal<=end){
			nextVal = end;
		}
		obj.style[attr] = nextVal  + "px";
		if(parseInt(getStyle(obj,attr))==end){
			clearInterval(obj.timer);
			endFn && endFn();
		}
	},30)
}

function shake(obj,attr,endFn){
	if(obj.b){
		obj.b = false;
		var arr = [];
		for(var i=16;i>0;i-=2){
			arr.push(i,-i);
		}
		arr.push(0);
		var oldAttr = parseInt(getStyle(obj,attr));
		var i = 0;
		clearInterval(obj.timer);
		obj.timer = setInterval(function (){
			obj.style[attr] = oldAttr+arr[i]+"px";
			i++;
			if(i==arr.length){
				clearInterval(obj.timer);
				obj.b = true;
				endFn&&endFn();
			}
		},30)
	}
}

function getPosition(obj,attr){
	var iAttr = 0;
	while(obj){
		iAttr +=obj[attr];
		obj=obj.offsetParent;
	}
	return iAttr;
}

function inBefore(oP,oC){
	oP.children[0] ? oP.insertBefore(oC,oP.children[0]) : oP.appendChild(oC);
}

//通过class获取元素
function getElementsByClassName(parent,tagName,className){
	if(parent.getElementsByClassName){
		return parent.getElementsByClassName(className);
	}else{
		var aEls = parent.getElementsByTagName(tagName);
		var arr = [];
		for(var i=0;i<aEls.length;i++){
			var arr1 = aEls[i].className.split(" ");
			for(var j=0;j<arr1.length;j++){
				if(arr1[j] == className){
					arr.push(aEls[i]);
					break;
				}
			}
		}
		return arr;	
	}
}

//从元素上删除某个class方法
function removeClass(obj,aClass){
	var arr = obj.className.split(" ");
	if(arrIndexOf(arr,aClass)!=-1){
		arr.splice(arrIndexOf(arr,aClass),1);
		obj.className = arr.join(" ");
	}
}
function arrIndexOf(arr,aClass){
	for(var i=0;i<arr.length;i++){
		if(arr[i]==aClass){
			return i;
		}
	}
	return -1;
}

//给元素上添加某个class方法
function addClass(obj,aClass){
	var arr1 = obj.className.split(" ");
	if(arrIndexOf(arr1,aClass)==-1){
		obj.className += " "+aClass;
	}
}
function arrIndexOf(arr,aClass){
	for(var i=0;i<arr.length;i++){
		if(arr[i]==aClass){
			return i;
		}
	}
	return -1;
}

//事件绑定
function bind(obj,evname,fn){
	if(obj.addEventListener){
		obj.addEventListener(evname,fn,false)
	}else{
		obj.attachEvent('on'+evname,function(){
fn.call(obj);})
	}
}

//鼠标滚轮事件
function mouseScroll(obj,fnup,fndown){
	if(window.navigator.userAgent.indexOf("Firefox")>=0){//window.navigator.userAgent得到的是字符串
		obj.addEventListener("DOMMouseScroll" ,function(ev){
			ev=ev||event;
			howwheel(ev,fnup,fndown);
			ev.preventDefault();
		},false)
	}else{
		obj.onmousewheel=function(ev){
			ev=ev||event;
		    howwheel(ev,fnup,fndown);
			return false;
		}
	}
}
function howwheel(ev,fnup,fndown){
	var b = true;
	if(ev.wheelDelta){
		b=ev.wheelDelta>0?true:false;
	}else{
		b= ev.detail<0?true:false;
	} 
	b?fnup():fndown();
}

//封装一个获取cookie值的方法
function getCookie(key){
	var arr1 = document.cookie.split('; ');
	for(var i=0;i<arr1.length;i++){
		var arr2 = arr1[i].split('=');
		if(arr2[0]==key){return decodeURI(arr2[1]);
		}
	}
}
//封装一个删除cookie的方法
function removeCookie(key){
	setCookie(key,'',-1);
}
//封装一个存储cookie
function setCookie(key,value,t){
	var oDate = new Date();
	oDate.setDate(oDate.getDate()+t);
	document.cookie=key+'='+value+';expires='+oDate.toGMTString();
}

function ajax(url,fnSucc,fnFaild){
	//参数：1、连接服务器的地址；2、成功时函数；3、失败时函数
	//1、创建Ajax对象
	var oAjax = null;
	if(window.XMLHttpRequest){
		oAjax = new XMLHttpRequest(); //ie6及以下不兼容
	}else{
		oAjax = new ActiveXObjext("Microsoft.XMLHTTP");
	}
	
	//2、连接服务器
	oAjax.open('GET',url,true);
	
	//3、发送请求
	oAjax.send();
	
	//4、接收服务器的返回
	oAjax.onreadystatechange = function(){
		if(oAjax.readyState ==4){  //完成
			if(oAjax.status ==200){
				//alert('成功： '+oAjax.responseText);
				fnSucc(oAjax.responseText);
			}else{
				//alert('失败');
				if(fnFaild){
					fnFaild();
				}
			}
		}
	}
}

//继承
function inherits(Child, Parent) { 
var F = function () {}; 
F.prototype = Parent.prototype; 
Child.prototype = new F(); 
Child.prototype.constructor = Child; 
}