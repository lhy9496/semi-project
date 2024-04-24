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

    <link rel="stylesheet" href="resources/css/dietview.css?after">

    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
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

            <div id="date-div"></div>

            <div id="meal-container">
                <!-- 식사기록이 없을 경우 -->
                <c:choose>
                	<c:when test="${empty mealRecordList }">
                		<div class="meal-info" style="background: white;">
		                    <div style="font-size: 25px">
		                        식사기록이 없습니다.
		                    </div>
                		</div>
                	</c:when>
                	<c:otherwise>
                		<!-- 식사기록이 있을 경우 -->
                		<c:set var="totalKcal" value="0"/>
                		
                		<c:forEach var="meal" items="${mealRecordList }" varStatus="loop">
                			<c:if test="${!meal.mealTimingName.equals(mealRecordList[loop.index-1].mealTimingName)}">
                                
                				<div class="meal-info">
				                    <div class="meal">
				                        <div class="meal-timing">${meal.mealTimingName }</div>
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
                			</c:if>
                						<tr>
                							<td>${meal.foodName }</td>
                							<td>${meal.amount }</td>
                							<c:set var="foodKcal" value="${meal.foodKcal * meal.amount }"/>
                							<td><c:out value="${foodKcal }" /></td>
                							<c:set var="totalKcal" value="${totalKcal + foodKcal}"></c:set>
                                            
                						</tr>
                			<c:if test="${!meal.mealTimingName.equals(mealRecordList[loop.index+1].mealTimingName)}">
                                <tr>
                                    <td style="background-color: aliceblue; font-weight: bold;">총 칼로리</td>
                                    <td colspan="3" style="background-color: aliceblue; font-weight: bold;"><c:out value="${totalKcal}" /> kcal</td>
                                    <c:set var="totalKcal" value="0"></c:set>
                                </tr>
                				</tbody>
                				</table>
                				</div>
                			</c:if>
                		</c:forEach>

                	</c:otherwise>
                </c:choose>
            </div>
        </div>
        <div id="right-container">
            <div id='calendar'></div>
        </div>
    </div>

    <script>
        $(function () {
            getTodayDate();
            $("#addMeal").on("click", function () {
                location.href = "${contextPath}/enroll.mr";
            })
        })

        function getTodayDate() {
            let today = new Date();
            let year = today.getFullYear();
            let month = ('0' + (today.getMonth() + 1)).slice(-2);
            let day = ('0' + today.getDate()).slice(-2);

            let dateString = year + '-' + month + '-' + day;
            const date = document.querySelector('#date-div');
            date.innerHTML=dateString;
        }

        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
              initialView: 'dayGridMonth',
              height: "100%",
              selectable:true,
              dateClick: function(info) {
                let clickedDate = info.dateStr;
                let date_div = document.querySelector("#date-div");

                date_div.innerHTML="";
                date_div.innerHTML=clickedDate;
                $.ajax({
                    url: 'cinfo.mr',
                    data: {
                        clickedDate: clickedDate
                    },
                    success: function(res) {
                        let mealRecordList = mealRecordFormat(res);
                        drawMealRecordTable(mealRecordList);
                    },

                    error: function() {
                        console.log("식사기록 조회 실패");
                    }
                })
              }
            });
            calendar.render();
          });
        
          function mealRecordFormat(list) {
            let mealRecordList = {};
            for(let record of list) {
                if(mealRecordList[record.mealTimingName]) {
                    mealRecordList[record.mealTimingName].push(record);
                } else {
                    mealRecordList[record.mealTimingName] = [record];
                }
            }
            return mealRecordList;
          }

          function drawMealRecordTable(list) {
            $('#meal-container').empty();

            if(Object.keys(list).length === 0) {
                let str = `<div class="meal-info" style="background: white;">
		                    <div style="font-size: 25px">
		                        식사기록이 없습니다.
		                    </div>
                		</div>`;
                $('#meal-container').append(str);
            }

            for (let key in list ){
                let str = `<div class="meal-info">`;
                
                let recordList = list[key];
                let totalKcal = 0;
                recordList.forEach(function(meal, index) {
                    if(index === 0) {
                        str += `<div class="meal">
				                        <div class="meal-timing">`+meal.mealTimingName+`</div>
				                    </div>
				                    <table class="meal-record">
				                        <thead>
				                            <tr>
				                                <td>음식</td>
				                                <td>수량</td>
				                                <td>칼로리</td>
				                            </tr>
				                        </thead>
                                        <tbody>`;
                    }
                    str += `
                            <tr>
                                <td>`+meal.foodName+`</td>
                                <td>`+meal.amount +`</td>`
                    let foodKcal = meal.foodKcal * meal.amount;            
                    str += `    
                            <td>`+foodKcal+`</td>`
                    totalKcal += foodKcal;
                    str += `</tr>
                            </tbody>`;
                    if(index === recordList.length - 1) {
                        str += `<tr>
                                    <td style="background-color: aliceblue; font-weight: bold;">총 칼로리</td>
                                    <td colspan="3" style="background-color: aliceblue; font-weight: bold;">`+totalKcal+` kcal</td>
                                    <c:set var="totalKcal" value="0"></c:set>
                                </tr>
                                </tbody>`;
                    }
                })
                str += `</div>`;
                $('#meal-container').append(str);
            }
          }
    </script>

</body>
</html>