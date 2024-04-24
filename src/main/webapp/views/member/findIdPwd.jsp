<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    .signup-frame{
        width: 450px;
        height: max-content;
        margin-left: auto;
        margin-right: auto;
    }
    .top-line, .middle-line, .bottom-line, .middle-line1, .middle-line2{
        width: 450px ;
        height: 55px;
        display: flex;
        flex-wrap: wrap;
        border: 1px solid ;
    }
    .top-line{
        margin-top: 30px;
        border-bottom: 0px;
        border-radius: 15px 15px 0px 0px
    }
    .middle-line{
        border-bottom: 0px;
    }
    .bottom-line{
        border-radius: 0px 0px 15px 15px
    }
    .logo-space{
        margin-top: 55px;
    }
    .icon-space{
        width: 80px;
        align-content: center;
        padding-left: 20px;
        padding-right: 0px;
    }
    .input-space{
        display: flex;
        width: 320px;
        border: none;
        border-radius: 20px;
        font-size: 16px;
        outline: none;
    }
    .submit-space{
        width: 300px;
        height: 48px;
        margin-top: 32px;
        margin-left: auto;
        margin-right: auto;
    }
    .submit-button{
        width: 300px;
        height: 48px;
        border-radius: 10px;
        border: 0px;
        background-color: rgb(224, 15, 26); 
        color: white;
        font-size: 24px;
    }

</style>
</head>
<body>
    <div class="signup-frame">
        <div class="logo-space">
            <a href="${contextPath}"><img src="/pss/resources/logo/psslogoenroll.png"  alt="로고 이미지"></a>
        </div>

        <br>
        <h2>이메일</h2>

        <form action="findId.me" id="findId-form" method="post">
            <div class="top-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/person_icon.png" alt="인물 이미지">
                </div>
                <div class="input-space">
                    <input type="text" class="input-space" name="userName" placeholder="이름" required>
                </div>
            </div>
            <div class="bottom-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/person_icon.png" alt="인물 이미지">
                </div>
                <div class="input-space">
                    <input type="text" class="input-space" name="userNickname" placeholder="닉네임" required>
                </div>
            </div>
            <div class="submit-space">
                <button type="submit" class="submit-button" id="enroll-button"><b>이메일 찾기</b></button>
            </div>
        </form>

        <br>
        <h2>PW</h2>

        <form action="findPwd.me" id="findPwd-form" method="post">
            <div class="top-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/email_icon.png" alt="이메일 이미지">
                </div>
                <div class="input-space">
                    <input type="text" name="userEmail" id="email" class="input-space" placeholder="이메일" required>
                </div>
            </div>
            <div class="middle-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/person_icon.png" alt="인물 이미지">
                </div>
                <div class="input-space">
                    <input type="text" class="input-space" name="userName" placeholder="이름" required>
                </div>
            </div>
            <div class="bottom-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/person_icon.png" alt="인물 이미지">
                </div>
                <div class="input-space">
                    <input type="text" class="input-space" name="userNickname" placeholder="닉네임" required>
                </div>
            </div>
            <div class="submit-space">
                <button type="submit" class="submit-button" id="enroll-button"><b>PW 찾기</b></button>
            </div>
        </form>
    </div>
</body>
</html>