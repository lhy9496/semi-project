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
<style>
    body{
        margin-top: 0px;
        background-color: rgb(225, 15, 26);
    }
    .update-frame{
        width: 720px;
        height: max-content;
        margin-left: auto;
        margin-right: auto;
    }
    .logo-space{
        margin-top: 55px;
        width: 252px;
        margin-left: auto;
        margin-right: auto;
    }
    .input-background{
        margin-top: 35px;
        width: 720px;
        height: 480px;
        background-color: white;
        border-radius: 15px;
        box-shadow: 0px 5px 5px;
        position: relative;
        padding-top: 80px;
    }
    .top-line, .middle-line, .bottom-line, .middle-line1, .middle-line2{
        width: 450px ;
        height: 55px;
        display: flex;
        flex-wrap: wrap;
        border: 1px solid;
        margin-left: auto;
        margin-right: auto;
    }
    .top-line{
        margin-top: 30px;
        border-bottom: 0px;
        border-radius: 15px 15px 0px 0px
    }
    .bottom-line{
        border-top: 0px;
        border-radius: 0px 0px 15px 15px
    }
    .middle-line1{
        border-bottom: 0px;
    }
    .icon-space{
        width: 40px;
        align-content: center;
        padding-left: 20px;
        padding-right: 20px;
        padding: auto;
    }
    .input-describe{
        width: 80px;
        align-content: center;
        padding-left: 5px;
        padding-right: 5px;
        padding: auto;
        font-size: 20px;
        font-weight: 700;
    }
    .input-space{
        display: flex;
        width: 270px;
        border: none;
        border-radius: 15px;
        font-size: 16px;
        outline: none;
    }
    .subit-space{
        width: 450px;
        height: 64px;
        border-radius: 10px;
        position: absolute;
        left: 0px;
        right: 0px;
        bottom: 60px;
        margin: auto;
        box-shadow: 0px 2px 3px;
    }
    .subit-button{
        width: 450px;
        height: 64px;
        border-radius: 10px;
        border: 0px;
        background-color: rgb(224, 15, 26); 
        color: white;
        font-size: 36px;
    }
    .submit-line{
    width: 450px;
    display: flex;
    margin-left: auto;
    margin-right: auto;
    margin-top: 60px;
    }
    .submit-space{
        width: 200px;
        height: 40px;
        margin: auto;
    }
    .submit-button{
        width: 100%;
        height: 40px;
        border: 3px solid rgb(224, 15, 26);
        border-radius: 15px;
        background: rgba(255, 255, 255);
        font-size: 16px;
        font-weight: 600;
    }
    .submit-button:hover{
        cursor: pointer;
    }
</style>
</head>
<body>
    <form action="update.me" id="update-form" method="POST">
        <input type="hidden" name="redirectLastPage" value="">
        <div class="update-frame">
            <div class="logo-space">
                <a href="${contextPath}"><img src="/pss/resources/logo/psslogologin.png" alt="로고 이미지"></a>
            </div>
            <div class="input-background">
                <form action="findPwd.me" id="findPwd-form" method="post">
                    <div class="top-line">
                        <div class="icon-space">
                            <img src="/pss/resources/logo/height_icon.png" alt="키 이미지">
                        </div>
                        <div class="input-describe">키</div>
                        <div class="input-space">
                            <input type="text" name="memHeight" id="email" class="input-space" value="키" required>
                        </div>
                    </div>
                    <div class="middle-line1">
                        <div class="icon-space">
                            <img src="/pss/resources/logo/weight_icon.png" alt="체중 이미지">
                        </div>
                        <div class="input-describe">체중</div>
                        <div class="input-space">
                            <input type="text" class="input-space" name="memWeight" value="몸무게" required>
                        </div>
                    </div>
                    <div class="middle-line2">
                        <div class="icon-space">
                            <img src="/pss/resources/logo/fat_icon.png" alt="체지방률 이미지">
                        </div>
                        <div class="input-describe">체지방률</div>
                        <div class="input-space">
                            <input type="text" class="input-space" name="memBfp" value="체지방률" required>
                        </div>
                    </div>
                    <div class="bottom-line">
                        <div class="icon-space">
                            <img src="/pss/resources/logo/muscle_icon.png" alt="골격근량 이미지">
                        </div>
                        <div class="input-describe">골격근량</div>
                        <div class="input-space">
                            <input type="text" class="input-space" name="memSmm" value="골격근량" required>
                        </div>
                    </div>
                    <div class="submit-line">
                        <div class="submit-space">
                            <a href="update.me"><button type="submit" class="submit-button">정보 수정</button></a>
                        </div>
                        <div class="submit-space">
                            <a href="menuToUserPage.me"><button type="button" class="submit-button">취소</button></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </form>
    </body>
</html>