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

    <link rel="stylesheet" href="resources/css/foodenroll.css">

</head>

<body>
    <c:import url="../../views/common/menubar.jsp" />

    <div id="mealenroll-area">
        <h2 align="center" style="font-size: 50px; margin: 20px;">식사내용을 입력해주세요</h2>

        <select name="meal_timing" id="meal_select">
            <option value="1">아침</option>
            <option value="2">점심</option>
            <option value="3">저녁</option>
            <option value="4">간식</option>
        </select>
        <div id="food-list">
            <table class="table">
                <thead>
                    <tr>
                        <td>음식이름</td>
                        <td>kcal</td>
                        <td>수량</td>
                        <td>체크해주세요</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="food" items="${foodList }">
                        <tr class="food">
                            <td class="food_name" name="food_name" data-foodNo=${food.foodNo}>${food.foodName }</td>
                            <input type="hidden" class="foodNo" value=${food.foodNo}>
                            <td class="food_kcal" name="food_kcal">${food.foodKcal }</td>
                            <td><input type="number" style="border-width: 0 0 1px;" class="food_amount"
                                    name="food_amount"></td>
                            <td class="food_check"><input type="checkbox" name="workout" class="workout_chkbox"
                                    style="zoom: 2.0;"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4">
                            <button type="button" style="margin: auto;" id="btn-meal-enroll">식사등록하기</button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>


    </div>
    <script>
        $(function () {
            $('#btn-meal-enroll').on('click', function () {
                let mealRecord = [];
                $('.food').each(function () {
                    if ($(this).find('input[type=checkbox]').prop('checked')) {

                        // let mealTiming = $('#meal_select :selected').text();
                        let mealTimingNo = $('#meal_select :selected').val();
                        // console.log(mn);
                        let foodNo = $(this).find('.foodNo').val();
                        let amount = $(this).find('.food_amount').val();

                        if (amount === "") {
                            alert("음식개수를 입력해주세요")
                        } else {
                            mealRecord.push({
                                mealTimingNo: mealTimingNo,
                                foodNo: foodNo,
                                amount: amount
                            });
                        }
                    }
                });
                console.log(mealRecord);
                sendMealRecord(mealRecord);
            })

            function sendMealRecord(mealRecord) {
                $.ajax({
                    url: 'insert.mr',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(mealRecord),
                    success: function (res) {
                        alert("성공적으로 식사를 기록하였습니다.");
                        location.href = "${contextPath}/info.mr"
                    },
                    error: function () {
                        console.log('식사 기록에 실패하였습니다.')
                    }
                })
            }
        })
    </script>
</body>

</html>