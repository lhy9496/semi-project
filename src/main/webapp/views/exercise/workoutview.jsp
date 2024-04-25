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
    <link rel="stylesheet" href="resources/css/calendar.css?after">

    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>


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

            <div id="date-div"></div>

            <div id="workout-container">
                <c:if test="${empty list}">
                    <div class="workout-info" style="background: white;">
                        <div style="font-size: 25px">
                            운동기록이 없습니다.
                        </div>
                    </div>
                </c:if>

                <c:forEach var="exercise" items="${list}" varStatus="loop">
                    <c:if test="${!exercise.exName.equals(list[loop.index - 1].exName)}">
                        <!-- 이전 운동명과 다른 경우에만 출력 -->
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
                    <c:if test="${!exercise.exName.equals(list[loop.index + 1].exName)}">
                        <!-- 다음 운동명과 다른 경우에만 tbody를 닫음 -->
                        </tbody>
                        </table>
            </div>
            </c:if>
            </c:forEach>
        </div>
    </div>

    <div class="right-container">
        <div id='calendar'></div>
    </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            let calendarEl = document.getElementById('calendar');
            let calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                height: "100%",
                selectable: true,
                dateClick: function (info) {
                    let clickedDate = info.dateStr;

                    drawDate(clickedDate);

                    // 달력에 클릭한 날짜에 대한 운동기록 조회하기
                    $.ajax({
                        url: 'cinfo.wo',
                        data: {
                            clickedDate: clickedDate
                        },
                        success: function (res) {
                            let exerciseRecordList = exerciseRecordFormat(res);
                            drawExerciseRecordTable(exerciseRecordList);
                        },
                        error: function () {
                            console.log("운동기록 조회실패");
                        }
                    })
                }
            });
            calendar.render();

        });

        function drawDate(date) {
            let date_div = document.querySelector("#date-div");

            date_div.innerHTML = "";
            date_div.innerHTML = date;
        }

        function drawExerciseRecordTable(list) {
            $("#workout-container").empty();
            // 만약 Object배열 길이가 0이면 운동기록 없다고하자

            if (Object.keys(list).length === 0) {
                let str = `<div class="workout-info" style="background: white;">
                                <div style="font-size: 25px">
                                    운동기록이 없습니다.
                                </div>
                            </div>`;
                $("#workout-container").append(str);
            }

            for (let key in list) {

                let str = `<div class="workout-info">`;

                let recodeList = list[key]
                recodeList.forEach(function (exercise, index) {
                    if (index === 0) {
                        str += `      
                                            <div class="workout">
                                                <div class="workout-name">`+ exercise.exName + `</div>
                                                <div class="workout-bodypart">`+ exercise.exBodyPartName + `</div>
                                            </div>
                                            <table class="workout-record">
                                                <thead>
                                                    <tr><td>세트</td><td>중량</td><td>횟수</td></tr>
                                                </thead>`
                    }
                    str += `<tbody>
                                                <tr>
                                                    <td>`+ exercise.exRecordSet + `</td>
                                                    <td>`+ exercise.exRecordWeight + `</td>
                                                    <td>`+ exercise.exRecordCount + `</td>
                                                </tr>
                                            </tbody>`

                    if (index === recodeList.length - 1) {
                        str += `</table>`;
                    }
                });

                str += `</div>`;
                $("#workout-container").append(str);
            }
        }

        function exerciseRecordFormat(list) {
            let exerciseRecordList = {};
            for (let recode of list) {
                if (exerciseRecordList[recode.exName]) {
                    exerciseRecordList[recode.exName].push(recode);
                } else {
                    exerciseRecordList[recode.exName] = [recode];
                }
            }

            return exerciseRecordList;
        }
        $(function () {
            getTodayDate();
            $(".addWorkout").on("click", function () {
                location.href = "${contextPath}/enroll.wo";
            })
        })

        function getTodayDate() {
            let today = new Date();
            let year = today.getFullYear();
            let month = ('0' + (today.getMonth() + 1)).slice(-2);
            let day = ('0' + today.getDate()).slice(-2);

            let dateString = year + '-' + month + '-' + day;
            const date = document.querySelector('#date-div');
            date.innerHTML = dateString;
        }
    </script>
</body>

</html>