<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<% 
	String myctx=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>homepage</title>
    <!-- layout.css파일을 참조하세요 -->
    <link rel="stylesheet" type="text/css" href="<%=myctx%>/css/layout.css">
    <!-- http://localhost:9090/css/layout.css -->
    <!-- "webapps/ROOT" ===>"/" -->
    
</head>
<body>
    <div id="wrap">
        <!-- 헤더: 로고이미지, 검색폼, 목차 등 -->
        <header>
            <!-- header -->
            <a href="<%=myctx%>/index.do">
                <img src="<%=myctx%>/images/logo.png">
            </a>
        </header>
        <div class="cls"></div>
        <!-- 네비게이션바: 메뉴 -->
        <nav>
            <!-- nav -->
            <ul>
                <li><a href="<%=myctx%>/index.do">HOME</a></li>
                
                
                	<li><a href="<%=myctx%>/join.do">Signup</a></li>
               		 <li><a href="<%=myctx%>/login.do">Signin</a></li>
                
                	<li><a href="<%=myctx%>/logout.do">Logout</a></li>
               
                <li><a href="<%=myctx%>/user/boardForm.do">Board 쓰기</a></li>
                
                <li><a href="<%=myctx%>/boardList.do">Board 목록</a></li>
                
                <li style="background-color:#19376D;border-radius:5px">
                <a href="#" style='color:white'>a 님 로그인 중</a>
                
            </ul>
        </nav>
        <div class="cls"></div>
        <!-- article : 주로 컨텐츠가 들어감 -->
        <article>