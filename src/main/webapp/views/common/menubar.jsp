<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<%
    String alertMsg = (String)session.getAttribute("alertMsg");
    String redirectUrl = (String)session.getAttribute("redirectUrl");
    String contextPath = request.getContextPath();
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
    ul, ol, li{
        margin: 0px;
        padding: 0px;
    }
    #menubar-header {
        width: 100%;
        height: 250px;
        background-color: rgb(225, 15, 26);
        position: fixed;
        top: 0px;
        z-index: 10;
    }
    #menubar-header #menubar-space{
        width: 100%;
        height: max-content;
        margin-top: 250px;
    }
    #menubar-header .loginout-space{
        margin-top: 20px;
        margin-left: 30px;
        margin-right: 30px;
        height: 40px;
        font-size: 25px;
        text-align: right;
    }
    #login, #logout, #updateform{
        background-color: black;
        color: white;
        width: 85px;
        height: 40px;
        border: 0px;
        border-radius: 5px;
        font-size: 15px;
    }
    #updateform{
        width: 110px;
    }
    .logo-search-space{
        width: 1100px;
        height: 125px;
        display: flex;
        margin: 0 auto;
    }
    .logo-space{
        width: 240px;
        height: 100%;
        text-align: center;
    }
    .search-space-out{
        width: 860px;
        margin: 0 auto;
    }
    .search-space-in{
        width: 620px;
        height: 60px;
        border-radius: 15px;
        text-align: center;
        margin: 0 auto;
        margin-top: 30px;
        background-color: white;
        position: relative;
    }
    .search-input{
        text-align: center;
        font-size: 25px;
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
        width: 120px;
        height: 40px;
        font-size: 20px;
        font-weight: 600;
        color: white;
        background-color: rgb(225, 15, 26);
        border: 1px solid rgb(157, 1, 1);
        border-radius: 5px;
        box-shadow: 0px 3px 5px 0px rgb(157, 1, 1);
        position: absolute;
        right: 15px;
        top: 10px;
    }
    #menubar-nav{
        width: 100%;
        margin: 0 auto;
    }
    #menubar-nav ul, #menubar-nav ul li, #menubar-nav ul li a{
        height: 60px;
        text-align: center;
    }

    #menubar-nav ul {
        min-width: 300px;
        margin-left: 50px;
        flex-wrap: nowrap;
    }

    #menubar-nav ul li{
        min-width: 100px;
        margin-right: 60px;
        /* white-space: nowrap; */
    }

    #menubar-nav ul li a {
        min-width: 100px;
        font-size: 24px;
        white-space: nowrap;
        color: white;
    }
    #menubar-nav ul li a:hover{
        scale: 1.1;
        font-weight: bold;
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
    <% if(redirectUrl != null){ %>
        <% session.removeAttribute("redirectUrl"); %>
    <% }%>
        <div id="menubar-header">
            <div class="loginout-space">
            <c:choose>
            	<c:when test="${empty loginUser }">
                    <button id="login" onclick="location.href='${contextPath}/loginForm.me?redirectUrl=' + window.location.href">로그인</button>
                </c:when>
                <c:otherwise>
                    <img src="/pss/resources/logo/person_icon.png" alt="유저 아이콘">${loginUser.userNickname}
                    <button id="logout" onclick="location.href='${contextPath}/logout.me'">로그아웃</button>
                    <button id="updateform" onclick="location.href='${contextPath}/updateForm.me?redirectUrl=' + window.location.href">회원정보수정</button>
                </c:otherwise>
            </c:choose>
            </div>
            <div id="logo-search-container">
                <div class="logo-search-space">
                    <div class="logo-space">
                        <a href="${contextPath}">
                            <img src="/pss/resources/logo/psslogomenubar.png" alt="로고">
                        </a>
                    </div>
                    <form action="search.me" method="GET">
	                    <div class="search-space-out" >
	                        <div class="search-space-in">
	                            <input type="text" class="search-input" name="userNickname" placeholder="유저 닉네임">
	                            <button type="submit" class="search-button">검색</button>
	                        </div>
	                    </div>
                    </form>
                </div>
                
            </div>
            <c:choose>
            	<c:when test="${empty loginUser }">
                    <div id="menubar-nav">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" href="list.bo?cpage=1">커뮤니티</a>
                            </li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="menubar-nav">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" href="menuToUserPage.me">마이페이지</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="info.wo">운동기록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="info.mr">식단기록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="list.bo?cpage=1">커뮤니티</a>
                            </li>
                            </ul>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
</body>
</html>