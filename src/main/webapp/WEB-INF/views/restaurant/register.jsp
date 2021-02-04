<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-sm">
		<div class="row">
			<div class="col-1 col-md-2"></div>
			<div class="col-10 col-md-8">
				<form action="${root }/restaurant/register" method="post" enctype="multipart/form-data">
				<input type="hidden" name="mountain_no" value="7">
  <div class="form-group">
    <label for="input1">상호</label>
    <input type="text" class="form-control" id="input1" name="rname">
  </div>
  <div class="form-group">
    <label for="input2">지역</label>
    <input type="text" class="form-control" id="input2" name="rloc">
  </div>
    <div class="form-group">
    <label for="input3">연락처</label>
    <input type="text" class="form-control" id="input3" name="contact">
  </div>
      <div class="form-group">
    <label for="input4">메뉴</label>
    <input type="text" class="form-control" id="input4" name="menu">
  </div>
        <div class="form-group">
    <label for="input5">설명</label>
    <input type="text" class="form-control" id="input5" name="description">
  </div>
<div class="inputArea">
 <label for="gdsImg">이미지</label>
 <input type="file" id="gdsImg" name="file" />
 <div class="select_img"><img src="" /></div>
 
 <script>
  $("#gdsImg").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(300);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
 </script>
</div>
<%= request.getRealPath("/") %>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
			</div>
			<div class="col-1 col-md-2"></div>
			</div>
			</div>
			
</body>
</html>