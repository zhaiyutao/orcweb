function changeImage() {
	element = document.getElementById('myimage')
	if (element.src.match("bulbon")) {
		element.src = "/images/pic_bulboff.gif";
	} else {
		element.src = "/images/pic_bulbon.gif";
	}
}
//判断浏览器是否支持FileReader接口
if (typeof FileReader == 'undefined') {
    document.getElementById("xmTanDiv").InnerHTML = "<h1>当前浏览器不支持FileReader接口</h1>";
    //使选择控件不可操作
    document.getElementById("xdaTanFileImg").setAttribute("disabled", "disabled");
}

//选择图片，马上预览
function xmTanUploadImg(obj) {
    var file = obj.files[0];
    var pix =file.name.split('.')[1];
    var pixs = ["png","jpg"];
    if(pixs.indexOf(pix)==-1){
    	$("#alert-user").attr("class","alert alert-danger");
    	$("#formInput")[0].reset();
    	document.getElementById("xmTanImg").src="";
    	$('#returnDiv span').html("");
    	$('#srcValue').val("");
    	return;
    }
    $("#alert-user").attr("class","alert alert-danger hidden");
    var reader = new FileReader();

    //读取文件过程方法
    reader.onloadstart = function (e) {
        console.log("开始读取....");
    }
    reader.onprogress = function (e) {
        console.log("正在读取中....");
    }
    reader.onabort = function (e) {
        console.log("中断读取....");
    }
    reader.onerror = function (e) {
        console.log("读取异常....");
    }
    reader.onload = function (e) {
        console.log("成功读取....");

        var img = document.getElementById("xmTanImg");
        img.src = e.target.result;
        $("#srcValue")[0].value=e.target.result;
    }
    reader.readAsDataURL(file)
}
function check(formValue){
	var pic = $("#srcValue")[0].value;
	if(pic){
		$("#alert-user").attr("class","alert alert-danger hidden");
		return true;
	}
	$("#alert-user").attr("class","alert alert-danger");
	return false;
}
$(function(){
	var hidden = $('#hidden')[0].value;
	if(hidden){
		var img = document.getElementById("xmTanImg");
		img.src = $("#srcValue")[0].value;
	}
});
