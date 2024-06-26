<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.pss.member.model.vo.Member,
				com.pss.member.model.vo.UserPhysicalInfo,
				com.pss.member.model.vo.UserPicture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	HashMap<String, Object> searchUserTotalInfoMap = (HashMap<String, Object>)request.getAttribute("searchUserTotalInfoMap");

	Member member = (Member)(searchUserTotalInfoMap.get("searchUserInfo"));
	UserPhysicalInfo userPhysicalInfo = (UserPhysicalInfo)(searchUserTotalInfoMap.get("searchUserPhysicalInfo"));
	UserPicture userPicture = (UserPicture)(searchUserTotalInfoMap.get("searchUserPicture"));
    String tier = (String)(searchUserTotalInfoMap.get("searchUserTier"));
    String nickname = member.getUserNickname();
%>
 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8"> 
<title>Physical S</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <script>

    $(document).ready(function() {

        let nickname = '<%= nickname %>';
        let dietList, exerciseList;

        $.ajax({
            url: "dietRecord.me",
            data : {
                userNickname : nickname
            },
            success: function(response) {
                dietList = response;
                drawMainView(dietList, exerciseList);
            },
            error: function() {

                console.log("AJAX 오류 발생");
            }
        });

        $.ajax({
            url: "exerciseRecord.me",
            data : {
                userNickname : nickname
            },
            success: function(response) {
                exerciseList = response;
                drawMainView(dietList, exerciseList);
            },
            error: function() {
                console.log("AJAX 오류 발생");
            }
        });



    });

    function drawMainView(dietList, exerciseList){
        if (!dietList || !exerciseList)
            return;
        
        let transDataList = {};

        const toDay = new Date();
        toDay.setDate(toDay.getDate() - 9);

        for(let i = 0; i < 10; i++) {
            let day = new Date(toDay);
            day.setDate(day.getDate() + i);
            let year = day.getFullYear();
            let month = ('0' + (day.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 +1 해준 후 두 자리로 포맷팅
            let date = ('0' + day.getDate()).slice(-2); // 일을 두 자리로 포맷팅

            day = year + "-" + month + "-" + date;
            transDataList[day] = {
                "dietList" : [],
                "exerciseList" : []
            }
        }

        for (let data in transDataList){
            for (let diet of dietList) {
                if (data === diet.whenEatDate){
                    transDataList[data].dietList.push(diet);
                }
            }

            for (let exercise of exerciseList) {
                if (data === exercise.exrDate){
                    transDataList[data].exerciseList.push(exercise);
                }
            }
        }

        drawRecords(transDataList);

        console.log("transDataList", transDataList)
    }

    

    </script>

<style>
    *{
        box-sizing: border-box;
    }
    body{
        background: #EBEBEB;
    }
    .bodyofbody{
        margin-left: 200px;
        margin-right: 200px;
        background: #EBEBEB;
    }
    .flex-box{
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
    }

    .row-flex-box{
        display: flex;
        flex-direction: row;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
    }

    .top{
        display: flex;
        justify-content: left;
        align-items: center;
    }

    .top > * {
    margin-right: 5px; /* 자식 요소들의 오른쪽 마진을 5px로 지정하여 요소들 사이에 간격을 줌 */
    }

    .top > *:last-child {
        margin-right: 0; /* 마지막 자식 요소의 오른쪽 마진은 0으로 지정하여 마지막 요소 뒤에는 간격을 주지 않음 */
    }

    /*
    .box{
        border: 1px solid black;
    }
    */

    .previousTier{
        height: 30px;
        width: 120px;
        color: black;
        background: #D9D9D9;
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
        border-radius: 5px;
    }

    .wrap{
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
    }

    .wrapdown{
        display: flex;
        flex-direction: column;
    }

    .stat{
        height: 90%;
        width: 95%;
        color: black;
        background: #D9D9D9;
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
        border-radius: 10px;
    }

    .spac{
        height: 95%;
        width: 95%;
        color: black;
        background: white;
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
        border-radius: 5px;
    }

    .spac{
        height: 90%;
        width: 95%;
        color: black;
        background: #F2EEEE;
        display: flex;
        justify-content: center; /* 가로축 가운데 정렬 */
        align-items: center; /* 세로축 가운데 정렬 */
        border-radius: 5px;
    }

    .bodybox{
        height: 95%; 
        width: 95%;
        background: white;
        border-radius: 10px;
    }

    .titlearea{
        display: flex;
        align-items: flex-end;
        justify-content: space-between;
        padding-left: 15px;
        padding-right: 15px;
    }

    .centeralign{
        text-align: center;
    }

    .leftro{
        border-top-left-radius: 10px;
        border-bottom-left-radius: 10px;
    }
    .rightro{
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;

    }

    .profile{
        height: 120px;
        width: 120px;
        background: white;
        border-radius: 10px;
    }
    
    .downbox{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .left-flex-box{
        display: flex;
        align-items: center;
        justify-content: flex-start;
    }

    .end{
        display: flex;
        justify-content: center;
        align-items: flex-end;
        padding-bottom: 10px;
    }
    #totalUserInfoBox{
        user-select: none;
    }

</style>
</head>
<body>
    <jsp:include page="../common/menubar.jsp" /> 

    <div style="height: 250px;"></div>

    <div class="bodyofbody">
        <div class="flex-box">
            <div class="box" style="width: 25%; height: 1800px;">
                <div class="box flex-box" style="height: 200px;">
                    <div class="box flex-box" style="width: 40%; height: 100%;">
                        <div class="box profile flex-box">
                            <img src="/pss/resources/logo/person_icon.png" alt="프로필사진" width="100" height="100">
                        </div>
                    </div>
                    <div class="box" style="width: 60%; height: 100%;">
                        <div class="box" style="height: 55%; text-align: center; padding-top: 60px; padding-right: 70px;">
                            <h2><%=member.getUserNickname() %></h2>
                        </div>
                        <div class="box" style="height: 45%; text-align: center; padding-right: 70px;">
                            <h3><%=member.getAge() %> / <%=member.getGender() %></h3>
                        </div>
                    </div>
                </div>
                <div class="box flex-box" style="height: 150px;">
                    <div class="box bodybox row-flex-box">
                        <div class="box flex-box" style="height: 100%; width: 35%;">
                            <div class="box flex-box" style="width: 100px; height: 100px;">
                                <img src="/pss/resources/logo/Prize.png" alt="휘장" width="100" height="100">
                            </div>
                        </div>
                        <div class="box" style="height: 100%; width: 65%;">
                            <div class="flex-box centeralign" style="height: 100%;">
                                <div>
                                    <h1><%= tier %></h1>
                                    <h4><%=member.getUserPoint()%> P</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box flex-box" style="height: 500px;">
                    <div class="box bodybox">
                        <div class="box titlearea" style="height: 10%;">
                            <div>신체정보</div>
                            <a href="pupdateform.me">
                                <img src="/pss/resources/logo/edit.png" alt="수정버튼" width="20" height="20">
                            </a>
                        </div>
                        <div class="box" style="height: 90%;">
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>키</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemHeight() %>cm</div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>체중</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemWeight() %>kg</div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>체지방률</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemBep() %>%</div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>골격근량</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemSmm() %>kg</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box" style="width: 75%; height: 1800px;">
                <div class="box flex-box" style="height: 200px;">
                    <div class="box stat">이 자리에 광고해드립니다.</div>
                </div>
                
                <div id="totalUserInfoBox"></div>
                <script>

                    function drawRecords(transDataList) {
                        const htmls = document.getElementById("totalUserInfoBox");

                        for(let date in transDataList) {
                            let sum = 0;
                            if (transDataList[date].dietList.length > 0) {
                                for(let i in transDataList[date].dietList) {
                                    sum += transDataList[date].dietList[i].foodKcal;
                                }
                            }
                            
                            let exList = [];
                            if (transDataList[date].exerciseList.length > 0) {
                                for(let i in transDataList[date].exerciseList) {

                                    let exName = transDataList[date].exerciseList[i].exName;

                                    if (!exList.includes(exName)) {
                                        exList.push(exName);
                                    }
                                }
                            }
                            
                            let exerciseHtml;
                            for(let i = 0; i < exList.length; i++){
                                exerciseHtml +=
                                `
                                <div class="box downbox" style="width: 15%; height: 100%;">
                                    <div style="color: white; width: 80%; height: 80%;">
                                        <div class="flex-box" style="background: white; color: black; width: 100%; height: 100%;  border-radius: 10px;">` + exList[i] + `</div>
                                    </div>
                                </div>
                                `
                            }

                            htmls.innerHTML += 
                            `
                        <div class="wrap" style="height: 150px;">
                            <div class="box stat row-flex-box">
                                <div class="box leftro" style="width: 95%; height:100%; background: black;">
                                    <div class="left-flex-box box" style="width: 100%; height: 100%;">
                                        <div class="box flex-box" style="width: 20%; height: 100%;">
                                            <div style="color: white;">
                                                <h1>` + date.substring(5) + `</h1>
                                                총 ` + sum + `Kcal 섭취
                                            </div>
                                        </div>`
                                        + exerciseHtml +
                                    `</div>
                                </div>
                                <div class="box rightro end" style="width: 5%; height:100%; background: #464646; color: white;"></div>
                            </div>
                        </div>
                        `
                        }
                    };


                    
                    
                </script>
            </div>
        </div>
    </div>
</body>
</html>