<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<%
    String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    body{
        min-height: 100%;
        margin: 0;
        background-color: rgb(225, 15, 26);
    }
    .account-space{
        width: 575px;
        height: 145px;
        position: relative;
        margin-left: auto;
        margin-right: 0px;
    }        
    .account-button{
        width: 135px;
        height: 45px;
        font-size: 20px;
        font-weight: 600;
        color: white;
        background-color: rgb(225, 15, 26);
        border: 1px solid rgb(157, 1, 1);
        border-radius: 5px;
        box-shadow: 0px 3px 5px 0px rgb(157, 1, 1);
        position: absolute;
        top: 50px;
    }
    .login-account-space{
        width: 250px;
        height: 40px;
        font-size: 25px;
        position: absolute;
        left: 60px;
        top: 50px;
    }
    .index-frame{
        width: 720px;
        height: 100%;
        margin-left: auto;
        margin-right: auto;
        
    }
    .logo-space{
        margin-top: 70px;
        width: 385px;
        margin-left: auto;
        margin-right: auto;
    }
    .search-space{
        width: 100%;
        height: 75px;
        margin-top: 60px;
        border-radius: 15px;
        background-color: white;
        position: relative;
    }
    .search-input{
        text-align: center;
        font-size: 36px;
        font-weight: 500;
        width: 400px;
        border: none;
        outline: none;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    .search-button{
        width: 135px;
        height: 45px;
        font-size: 20px;
        font-weight: 600;
        color: white;
        background-color: rgb(225, 15, 26);
        border: 1px solid rgb(157, 1, 1);
        border-radius: 5px;
        box-shadow: 0px 3px 5px 0px rgb(157, 1, 1);
        position: absolute;
        right: 15px;
        top: 15px;
    }
    </style>
</head>
<body>
    <% if(alertMsg != null){ %>
		<script>
			alert("<%=alertMsg%>")
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>
    
    <c:choose>
        <c:when test="${empty loginUser }">
            <!-- 로그인을 안한 상태 -->
            <div class="account-space">
                <button type="button" class="account-button" onclick="location.href='loginForm.me'" style="left: 60px;">로그인</button>
                <button type="button" class="account-button" onclick="location.href='enrollForm.me'" style="left: 220px;">회원가입</button>
                <button type="button" class="account-button" onclick="location.href='list.bo?cpage=1'" style="right: 60px;">커뮤니티</button>
            </div>
        </c:when>
        <c:otherwise>
            <div class="login-account-space">
                <img src="/pss/resources/logo/person_icon.png" alt="유저 아이콘">${loginUser.userNickname}
            </div>
                <!-- 로그인을 한 상태 -->
            <div class="account-space">
                <button type="button" class="account-button" onclick="location.href='logout.me'" style="left: 60px;">로그아웃</button>
                <button type="button" class="account-button" onclick="location.href='menuToUserPage.me'" style="left: 220px;">마이페이지</button>
                <button type="button" class="account-button" onclick="location.href='list.bo?cpage=1'" style="right: 60px;">커뮤니티</button>
            </div>
        </c:otherwise>
    </c:choose>
    
    <div class="index-frame">
        <div class="logo-space">
            <img src="resources/logo/psslogomainmenu.png" alt="로고 이미지">
        </div>
        <form action="search.me" method="GET">
            <div class="search-space">
                <input type="text" class="search-input" name="userNickname" placeholder="유저 닉네임">
                <button type="submit" class="search-button">검색</button>
            </div>
        </form>
    </div>        
</body>
</html>