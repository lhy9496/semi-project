<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet'>

    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"> -->
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="../../resources/css/dietview.css?after">

    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <script src="../../resources/js/calendar.js"></script>
    <script src="../../resources/js/dietview.js"></script>
</head>
<body style="height: 100vh;">
	<c:import url="../../views/common/menubar.jsp" />

    <div id="content-container">
        <div id="left-container">

            <h2>기록하기</h2>
            <br>

            <div id="addMeal">
                <div></div>
                <span style="font-size: 35px;">식사 추가</span>
                <div>
                    <svg width="28" height="28" viewBox="0 0 28 28" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M10.5 0V10.5H0V17.5H10.5V28H17.5V17.5H28V10.5H17.5V0H10.5Z" fill="white" />
                    </svg>
                </div>
            </div>

            <script>
                $(function () {
                    $("#addMeal").on("click", function () {
                        location.href = "${contextPath}/enroll.fo";
                    })
                    })
            </script>

            <div id="meal-container">
                <!-- 음식기록이 없을 경우 -->
                <div class="meal-info" style="background: white;">
                    <div style="font-size: 25px">
                        식사기록이 없습니다.
                    </div>
                </div>

                <!-- 음식기록이 있을 경우 -->
                <div class="meal-info">
                    <div class="meal">
                        <div class="meal-timing">아침식사</div>
                        <div class="meal-kcal">총 500kcal</div>
                    </div>
                    <table class="meal-record">
                        <thead>
                            <tr>
                                <td>음식</td>
                                <td>수량</td>
                                <td>칼로리</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="meal-info">
                    <div class="meal">
                        <div class="meal-timing">점심식사</div>
                        <div class="meal-kcal">총 500kcal</div>
                    </div>
                    <table class="meal-record">
                        <thead>
                            <tr>
                                <td>음식</td>
                                <td>수량</td>
                                <td>칼로리</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="meal-info">
                    <div class="meal">
                        <div class="meal-timing">저녁식사</div>
                        <div class="meal-kcal">총 500kcal</div>
                    </div>
                    <table class="meal-record">
                        <thead>
                            <tr>
                                <td>음식</td>
                                <td>수량</td>
                                <td>칼로리</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="meal-info">
                    <div class="meal">
                        <div class="meal-timing">간식</div>
                        <div class="meal-kcal">총 500kcal</div>
                    </div>
                    <table class="meal-record">
                        <thead>
                            <tr>
                                <td>음식</td>
                                <td>수량</td>
                                <td>칼로리</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                            <tr>
                                <td>라면</td>
                                <td>1</td>
                                <td>500</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>

        <div id="right-container">
            <div id='calendar'></div>

        </div>

    </div>

</body>
</html>