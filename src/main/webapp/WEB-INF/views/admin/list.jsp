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
				
				var actionForm = $("#actionForm");
				$(".pagination a").click(
						function(e) {
							e.preventDefault();

							actionForm.find("[name='pageNo']").val(
									$(this).attr('href'));

							actionForm.submit();
						});
				

</script>
<style>
tr th {
	color: white;
}
</style>

<title>산산산</title>
</head>
<body>
<div class="container-sm">
   <div class="row">
      <div class="col-12 col-sm-6 offset-sm-3">
      				<form action="${root }/admin/list" id="searchForm" class="form-inline my-2 my-lg-0 d-flex bd-highlight mb-3">
      						<select name="type" class="custom-select my-1 mr-sm-2 bd-highlight"
						id="inlineFormCustomSelectPref">
						<option value="ICN">id+별명+이름</option>
					</select> <input class="form-control mr-sm-2 p-2 bd-highlight" type="search"
						name="keyword" value="${page.cri.keyword }" placeholder="Search"
						aria-label="Search" required="required"> <input
						type="hidden" name="pageNo" value="1" /> <input type="hidden"
						name="amount" value="${page.cri.amount }" />

					<button class="btn btn-outline-info my-2 my-sm-0 p-2 bd-highlight"
						type="submit">검색</button>
      				</form>
      	<table class="table table-sm mt-2">
  <thead>
    <tr>
      <th scope="col" width="10%" class="text-center bg-secondary">userno</th>
      <th scope="col" width="15%" class="text-center bg-secondary">id</th>
      <th scope="col" width="20%" class="text-center bg-secondary">password</th>
        <th scope="col" width="55%" class="text-center bg-secondary">email</th>

      </tr>
      <tr>
      <th scope="col" width="10%" class="text-center bg-secondary"></th>
       <th scope="col" width="15%" class="text-center bg-secondary">name</th>
      <th scope="col" width="20%" class="text-center bg-secondary">nicname</th>
      <th scope="col" width="55%" class="text-center bg-secondary">loc</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${memberList }" var="memberList">

    <tr>
      <td rowspan="2" class="text-center" style="vertical-align: middle;">${memberList.no }</td>
      <td>${memberList.id }</td>
      <td>${memberList.password }</td>
       <td>${memberList.email }</td>

      </tr>
      <tr>
      <td>${memberList.name }</td>
      <td>${memberList.nickname }</td>
      <td colspan="2">${memberList.loc }</td>
    </tr>
   </c:forEach>
  </tbody>
</table>
			<div class="container-sm mt-3">
				<div class="row justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<c:if test="${page.prev }">
								<c:url value="/admin/list" var="prevLink">
									<c:param value="${page.startPage -1 }" name="pageNo" />
									<c:param value="${page.cri.amount }" name="amount" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item">
									<a class="page-link" href="${prevLink }">Previous</a>
								</li>
							</c:if>

							<c:forEach var="num" begin="${page.startPage }"
								end="${page.endPage }">
								<c:url value="/admin/list" var="pageLink">
									<c:param name="pageNo" value="${num }" />
									<c:param name="amount" value="${page.cri.amount }" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item ${page.cri.pageNo eq num ? 'active' : '' }">
										<a class="page-link" href="${pageLink }">${num }</a>
								</li>
							</c:forEach>

							<c:if test="${page.next }">
								<c:url value="/admin/list" var="nextLink">
									<c:param name="pageNo" value="${page.endPage +1 }" />
									<c:param name="amount" value="${page.cri.amount }" />
									<c:param name="type" value="${page.cri.type }" />
									<c:param name="keyword" value="${page.cri.keyword }" />
								</c:url>
								<li class="page-item">
										<a class="page-link" href="${nextLink }">Next</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>