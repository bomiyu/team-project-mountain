<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<style type="text/css">
.address-form #sample3_address {
	width: 370px;
}

.address-form #sample3_detailAddress {
	width: none;
}

#wrap {
	width: 350px;
	height: 450px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container-sm mt-3">
		<div class="row">
			<div class="col-1 col-md-2"></div>
			<div class="col-10 col-md-8">
				<form action="${root }/restaurant/register" method="post">
					<div class="form-group">
						<label for="input1">산</label> <select name="mname"
							class="custom-select my-1 mr-sm-2 bd-highlight"
							id="input1">
							<option>북한산</option>
							<option>도봉산</option>
							<option>수락산</option>
							<option>인왕산</option>
							<option>아차산</option>
							<option>관악산</option>
						</select>
					</div>
					<div class="form-group">
						<label for="input2">상호</label> <input type="text"
							class="form-control" id="input2" name="rname">
					</div>
					<div class="form-group address-form">
						<label for="input3">지역</label>
						<p>
							<input type="hidden" id="sample3_postcode" placeholder="우편번호">
							<input type="text" name="address1" id="sample3_address"
								placeholder="주소"> <input type="text" name="address2"
								id="sample3_detailAddress" placeholder="상세주소"> <input
								type="hidden" name="address3" id="sample3_extraAddress"
								placeholder="참고항목"> <input type="button"
								onclick="sample3_execDaumPostcode()" value="검색" id="input3"><br>
						</p>
						<div id="wrap"
							style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
							<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
								id="btnFoldWrap"
								style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
								onclick="foldDaumPostcode()" alt="접기 버튼">
						</div>
						<script
							src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
						<script type="text/javascript"
							src="${root }/resources/js/restaurant/addressAPI.js"></script>
					</div>
					<div class="form-group">
						<label for="input4">연락처</label> <input type="text"
							class="form-control" id="input4" name="contact">
					</div>
					<div class="form-group">
						<label for="input5">메뉴</label> <input type="text"
							class="form-control" id="input5" name="menu">
					</div>
					<div class="form-group">
						<label for="input6">설명</label><textarea class="form-control" name="description" id="input6"
						rows="6" ></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div class="col-1 col-md-2"></div>
		</div>
	</div>

</body>
</html>