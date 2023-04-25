<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/top.jsp"/>


<c:if test="${board==null}">
	<script> alert('존재하지 않는 글입니다.'); history.back();</script>
</c:if>

<c:if test="${board!=null}">
	<div class="container">
		<h1>Board 글 보기</h1>
		<br>
		
		<a href ="user/boardForm.do">글쓰기</a>
		<a href ="boardList.do">글목록</a>
		<br>
		
		<table border = "1" id="userTable">
			<!-- 1행 -->
			<tr>
				<td width="20"><b>글번호</b></td>
				<td width="30">${board.num}</td>
				<td width="20"><b>작성일</b></td>
				<td width="30">
					<fmt:formatDate value="${board.wdate}" pattern="yy-MM-dd hh:mm:ss"/>
				</td>
			</tr>
			
			<!-- 2행 -->
			<tr>
				<td width="20"><b>글쓴이 </b></td>
				<td width="30">${board.userid}</td>
				<td width="20"><b>첨부파일</b></td>
				<td width="30">
					<c:if test="${board.filename!=null}">
						<a href="upload/${board.filename}" download ><img src ="image/attach.png" width="20px">
							${board.filename}
						</a>
							[${board.filesize}bytes]
					</c:if>
				</td>
			</tr>
			
			<!-- 3행 -->
			<tr>
				<td width="20%"><b>제목</b></td>
				<td colspan="3" style="text-align:left">${board.subject}</td>
			</tr>
			
			<!-- 4행 -->
			<tr>
				<td width="20%" style="height:300px" ><b>글내용</b></td>
				<td colspan="3" style="text-align:left">${board.content}</td>
			</tr>
			
			<!-- 5행 -->
			<tr>
				<td colspan="4">
					<a href="boardList.do">글목록</a>
					<a href="#" onclick="goEdit()">수정</a>
					<a href="#" onclick="goDel()">삭제</a>
				</td>
			</tr>
		</table>
		<!-- 수정 또는 삭제를 위한 form -->
		<form name ="bf" id ="bf">
			<input type = "hidden" name ='num' id='num' value='${board.num}'>
		
		</form>
	</div>
</c:if>
	<script type="text/javascript">
		const goEdit=function(){
			bf.action='user/boardEditForm.do';
			bf.method='post';
			bf.submit();
		}
		const goDel=function(){
			bf.action='user/boardDel.do';
			bf.method='post';
			bf.submit();
		}
	</script>
	
	
	
<jsp:include page="/foot.jsp"/>