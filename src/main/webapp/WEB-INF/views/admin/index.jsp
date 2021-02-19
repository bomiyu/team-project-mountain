<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.15.2/js/all.js" data-auto-replace-svg="nest"></script>
<link rel="stylesheet" type="text/css" href="root/resources/css/font.css">
<script>
$(document).ready(function() {
	$(".nav-link").click(function() {
		var link = $(this).attr("data-href");
		console.log(link);
		$("#iframe-link").attr("src", link);
	});
	
});

</script>
</head>
<body>
<u:topNav/>
<div class="container-sm">
   <div class="row">
      <div class="col-12 col-sm-6 offset-sm-3">
	<header>
	총방문 : ${sessionScope.totalCnt }
	오늘 방문 : ${sessionScope.todayCnt }
	<ul class="nav nav-tabs">
  <li class="nav-item">
   <button class="nav-link" data-href="${root }/notice/register">공지 등록</button>
  </li>
  <li class="nav-item">
    <button class="nav-link" data-href="${root }/board/register">산정보 등록</button>
  </li>
  <li class="nav-item">
    <button class="nav-link" data-href="${root }/festival/register">축제 등록</button>
  </li>
    <li class="nav-item">
    <button class="nav-link" data-href="${root }/place/register">명소 등록</button>
  </li>
    <li class="nav-item">
    <button class="nav-link" data-href="${root }/restaurant/register">맛집 등록</button>
  </li>
</ul>
	</header>
	<section>
		<div class="mt-2" id="container_box">
		<iframe src="" id="iframe-link" width="100%" height="900px" 
		frameborder="0" framespacing="0" marginheight="0" marginwidth="0" vspace="0"></iframe>
		</div>
	</section>
      </div>
   </div>
</div>
</body>
</html>