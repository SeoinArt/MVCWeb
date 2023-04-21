<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	String msg=(String)request.getAttribute("msg");
	String loc=(String)request.getAttribute("loc");

	el표현식: ${key값}
--%>
<script>
	alert('${msg}');
	/* request에 저장된 msg키값에 해당하는 value 값을 출력하란의미
	
		sessionScope.msg => 세션에 저장된 msg키에 해당하는 값
	*/
	location.href='${requestScope.loc}';
</script>