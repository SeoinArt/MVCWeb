<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>
	<div class="container m2">
		<h1>파일 업로드 테스트</h1>
		<br><br>
<!-- 
			파일 업로드 주의사항!!
	  	[1] method : post
	  	[2] post방식일 경우 인코딩방식(enctype)이 2가지 존재
	  		- application/x-www-form-urlencoded (default) => 첨부파일명만 서버에 전송된다. 
	  		- multipart/form-data => 첨부파일명과 첨부파일 데이터가 서버에 전송된다.
-->
		<form name="f" id="f" method="post" enctype="multipart/form-data" action="uploadEnd.do">
			<label>올 린 이: </label>
			<input type="text" name="writer"><br><br>
			<lable>첨부 파일: </lable>
			<input type="file" name="fname"><br><br>
			<button>Upload</button>
			
		</form>
	</div>
<jsp:include page="/foot.jsp"/>