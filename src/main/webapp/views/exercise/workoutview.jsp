<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>PhysicalS - 운동기록</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet'>

    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"> -->
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="resources/css/workoutbody.css?after">

    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                height: "100%"
            });
            calendar.render();
        });
    </script>

    <link rel="stylesheet" href="resources/css/calendar.css">
</head>

<body>
    <c:import url="../../views/common/menubar.jsp" />

    <div class="content-container">
        <div class="left-container">

            <h2>기록하기</h2>
            <br>

            <div class="addWorkout">
                <div></div>
                <span style="font-size: 35px;">운동 추가</span>
                <div>
                    <svg width="28" height="28" viewBox="0 0 28 28" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M10.5 0V10.5H0V17.5H10.5V28H17.5V17.5H28V10.5H17.5V0H10.5Z" fill="white" />
                    </svg>
                </div>
            </div>

            <div id="workout-container">
                <c:forEach var="exercise" items="${list}" varStatus="loop">
                    <c:if test="${loop.first || !exercise.exName.equals(list[loop.index - 1].exName)}">
                        <!-- 처음으로 나타나는 운동명이거나, 이전 운동명과 다른 경우에만 출력 -->
                        <div class="workout-info">
                            <div class="workout">
                                <div class="workout-name">${exercise.exName}</div>
                                <div class="workout-bodypart">${exercise.exBodyPartName}</div>
                            </div>
                            <table class="workout-record">
                                <thead>
                                    <tr>
                                        <td>세트</td>
                                        <td>중량</td>
                                        <td>횟수</td>
                                    </tr>
                                </thead>
                                <tbody>
                    </c:if>
                                <tr>
                                    <td>${exercise.exRecordSet}</td>
                                    <td>${exercise.exRecordWeight}</td>
                                    <td>${exercise.exRecordCount}</td>
                                </tr>
                    <c:if test="${loop.last || !exercise.exName.equals(list[loop.index + 1].exName)}">
                        <!-- 마지막으로 나타나는 운동명이거나, 다음 운동명과 다른 경우에만 tbody를 닫음 -->
                                </tbody>
                                </table>
                        </div>
                    </c:if>
                </c:forEach>
            <!-- <c:forEach var="exercise" items="${list }">
                	<div class="workout-info">
                	
                		<div class="workout">
	                        <div class="workout-name">${exercise.exName }</div>
	                        <div class="workout-bodypart">${exercise.exBodyPartName }</div>
                    	</div>
	                    <table class="workout-record">
	                        <thead>
	                            <tr>
	                                <td>세트</td>
	                                <td>중량</td>
	                                <td>횟수</td>
	                            </tr>
	                        </thead>
	                        <tbody>  
	                        	
	                            <tr>
	                                <td>${exercise.exRecordSet }</td>
	                                <td>${exercise.exRecordWeight }</td>
	                                <td>${exercise.exRecordCount }</td>
	                            </tr>	  
	                                         
	                        </tbody>
	                    </table>
                	</div>
				</c:forEach> -->
        </div>

    </div>

    <div class="right-container">
        <div id='calendar'></div>
    </div>
    </div>
    <script>
        $(function () {
            $(".addWorkout").on("click", function () {
                location.href = "${contextPath}/enroll.wo";
            })
        })
    </script>
</body>

</html>