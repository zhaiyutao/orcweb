<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="//cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/picUpload.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>我知道这是一个很垃圾的东西</h1>
			<p>甚至它不能被称为程序</p>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<h3>图片展示区</h3>
				<form method="POST" enctype="multipart/form-data" action="/upload"
					target="posthere">
					<div style="border: 2px dashed red;">
						<p>
							图片上传前预览： <input type="file" name="file" id="xdaTanFileImg"
								onchange="xmTanUploadImg(this)" />
						</p>
						<img id="xmTanImg" />
						<div id="xmTanDiv"></div>
					</div>
					<input type="submit" value="上传" />
				</form>
				<hr />
			</div>
			<div class="col-sm-6">
				<h3>复制前请核对</h3>
				<div id='returnDiv'>
					<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>