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
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
    .signup-frame{
        width: 720px;
        height: max-content;
        margin-left: auto;
        margin-right: auto;
    }
    .top-line, .middle-line, .bottom-line{
        width: 720px ;
        height: 55px;
        display: flex;
        flex-wrap: wrap;
        border: 1px solid ;
    }
    .top-line{
        margin-top: 30px;
        border-bottom: 0px;
        border-radius: 15px 15px 0px 0px;
    }
    .bottom-line{
        border-top: 0px;
        border-radius: 0px 0px 15px 15px;
    }
    .bottom-line2{
        border-radius: 0px 0px 15px 15px;
    }
    .gender-line{
        width: 720px;
        height: 75px;
        border: 1px solid;
        border-top: 0px;
        border-radius: 0px 0px 15px 15px;
        display: flex;
        margin-left: auto;
        margin-right: auto;
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
    .gender-space{
        width: 250px;
        height: 40px;
        margin: auto;
        border-radius: 10px;
    }
    .gender-button{
        width: 100%;
        height: 40px;
        border: 1px solid;
        border-radius: 15px;
        background: rgba(255, 255, 255);
        font-size: 16px;
        font-weight: 600;
    }
    .gender-button:hover{
        border: 2px solid rgb(224, 15, 26);
    }
    .btn{
        display: none;
    }
    .submit-space{
        width: 450px;
        height: 64px;
        margin-top: 64px;
        margin-left: auto;
        margin-right: auto;
    }
    .submit-button{
        width: 450px;
        height: 64px;
        border-radius: 10px;
        border: 0px;
        background-color: rgb(224, 15, 26); 
        color: white;
        font-size: 36px;
    }
    #checkId, #resetId, #checkNickname, #resetNickname{
        width: 160px;
        height: 33px;
        color: white;
        background-color: rgb(224, 15, 26);
        border: 0px;
        border-radius: 10px;
    }
    .checkbox{
        display: none;
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
    <form action="update.me" id="enroll-form" method="POST">
        <input type="hidden" name="userEmail" value="${loginUser.userEmail}">
        <div class="signup-frame">
            <!-- 로고 -->
            <div class="logo-space">
                <a href="${contextPath}"><img src="/pss/resources/logo/psslogoenroll.png"  alt="로고 이미지"></a>
            </div>
            <!-- 비밀번호 수정 -->
            <div class="top-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/pwd_icon.png" alt="비번 이미지">
                </div>
                <div class="input-space">
                    <input type="password" name="formerPwd" id="formerPwd" class="input-space" placeholder="기존의 비밀번호" required>
                </div>
            </div>
            <div class="middle-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/pwd_icon.png" alt="비번 이미지">
                </div>
                <div class="input-space">
                    <input type="password" name="userPwd" id="pwd" class="input-space" placeholder="신규 비밀번호" required>
                </div>
                <div style="margin: auto; font-size: 13px;" id="pwdMsg"></div>
            </div>
            <div class="bottom-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/pwd_icon.png" alt="비번 이미지">
                </div>
                <div class="input-space">
                    <input type="password" name="userPwdCheck" id="pwdChk" class="input-space" placeholder="비밀번호 확인" onkeyup="pwdCheck(pwdResult)" required>
                </div>
                <div style="margin: auto; font-size: 13px;" id="pwdResult"></div>
                <input type="checkbox" id="checkboxPwd" class="checkbox">
            </div>

            
            <!-- 이름, 나이 수정 -->
            <div class="top-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/person_icon.png" alt="인물 이미지">
                </div>
                <div class="input-space">
                    <input type="text" class="input-space" name="userName" placeholder="이름" value="${loginUser.userName}" required>
                </div>
            </div>
            <div class="middle-line">
                <div class="icon-space">
                    <img src="/pss/resources/logo/calendar_icon.png" alt="달력 이미지">
                </div>
                <div class="input-space">
                    <input type="number" min="0" max="150" class="input-space" name="age" placeholder="나이(숫자 입력)" value="${loginUser.age}" required>
                </div>
            </div>
            <div class="gender-line">
                <div class="gender-space">
                    <button type="button" class="gender-button" id="MArea" onclick="genderSelect(M), genderColor(MArea, FArea)">
                        <input type="radio" class="btn" id="M" name="gender" value="M">남자
                    </button>
                </div>
                <div class="gender-space">
                    <button type="button" class="gender-button" id="FArea" onclick="genderSelect(F), genderColor(FArea, MArea)">
                        <input type="radio" class="btn" id="F" name="gender" value="F">여자
                    </button>
                </div>
                <input type="checkbox" id="checkboxGender" class="checkbox">
            </div>

            <!-- 회원정보 수정 -->
            <div class="submit-space">
                <button type="button" class="submit-button" id="enroll-button" onclick="allchecked();"><b>회원정보 수정</b></button>
            </div>
        </div>
    </form>

    <script>
        
        // 성별 선택 스크립트
        function genderSelect(gender){
            gender.checked = true;
            const checkboxGender = document.querySelector("#checkboxGender");
            checkboxGender.checked = true;
        }
        function genderColor(genArea1, genArea2){
            genArea1.style.background = "rgb(224, 15, 26)";
            genArea1.style.color = "white";
            genArea2.style.background = "white";
            genArea2.style.color = "black";
        }

        // 비번 관련 스크립트
        const pwd = document.getElementById("pwd");
        const pwdMsg = document.getElementById("pwdMsg");
        const pwdChk = document.getElementById("pwdChk");
        const pwdResult = document.getElementById("pwdResult");
        const checkboxPwd = document.querySelector("#checkboxPwd");
        
        const pwdNotice = function() {
            pwdChk.value = "";
            pwdResult.innerHTML = "";
            checkboxPwd.checked = false;
            if (pwd.value == ""){
                pwdMsg.innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 5~15자";
            } else {
                pwdMsg.innerHTML = "";
            }
        }
        pwd.onfocus = pwdNotice;
        pwd.onkeyup = pwdNotice;

        pwd.onblur = function(){
            pwdMsg.innerHTML = "";
        }

        function pwdCheck(pwdResult){
            if(pwdChk.value == ""){
                pwdResult.innerHTML = "";
            } else if (pwd.value == pwdChk.value){
                pwdResult.style.color = "green"; 
                pwdResult.innerHTML = "비밀번호가 일치합니다.";
                checkboxPwd.checked = true;
            } else {
                pwdResult.style.color = "red";
                pwdResult.innerHTML = "비밀번호가 일치하지 않습니다.";
                checkboxPwd.checked = false;
            }
        }

        const formerPwd = document.querySelector("#formerPwd");

        function checkFormerPwd(callback){
            //비밀번호 확인용 ajax 코드
            $.ajax({
                    type : "GET",
                    url : "pwdCheck.me",
                    data: {
                        checkPwd : formerPwd.value
                    },
                    success: function(result){
                        console.log(result)
                        // 기존 비밀번호와 일치.
                        if(result === "NNNNN"){
                            callback(true);
                        }else{
                            // 기존 비밀번호와 불일치.
                            callback(false);
                        }
                    },
                    error: function(err){
                        console.log("실패 : ", err)
                        callback(false)
                    }
                })
        }
        function allchecked(){
           
            checkFormerPwd(function(checked){
                if(checked){
                    console.log(checked)
                    if (checkboxPwd.checked != true){
                        alert("신규 비밀번호가 일치하지 않습니다.");
                        pwd.focus();
                    } else if (checkboxGender.checked != true){
                        console.log("성별 미선택");
                        alert("성별을 선택해주세요.");
                    }else {
                        console.log("성공")
                        document.querySelector("#enroll-form").submit();
                    }
                } else {
                    console.log(checked)
                    alert("기존의 비밀번호를 틀렸거나 오류가 발생했습니다.")
                    formerPwd.focus();
                }
            })
        }
        
    </script>
</body>
</html>