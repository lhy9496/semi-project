<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap,
				java.util.ArrayList" %>
<%@ page import="com.pss.member.model.vo.Member,
				com.pss.member.model.vo.UserPhysicalInfo,
				com.pss.member.model.vo.UserPicture,
				com.pss.diet.model.vo.UserDietRecord,
				com.pss.exercise.model.vo.ExerciseRecord" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	HashMap<String, Object> searchUserTotalInfoMap = (HashMap<String, Object>)request.getAttribute("searchUserTotalInfoMap");

	Member member = (Member)(searchUserTotalInfoMap.get("searchUserInfo"));
	UserPhysicalInfo userPhysicalInfo = (UserPhysicalInfo)(searchUserTotalInfoMap.get("searchUserPhysicalInfo"));
	UserPicture userPicture = (UserPicture)(searchUserTotalInfoMap.get("searchUserPicture"));
	ArrayList<UserDietRecord> userdietRecord = (ArrayList<UserDietRecord>)(searchUserTotalInfoMap.get("searchUserdietRecord"));
	ArrayList<ExerciseRecord> exerciseRecord = (ArrayList<ExerciseRecord>)(searchUserTotalInfoMap.get("searchUserExerciseRecord"));
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Physical S</title>
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

    .previousTear{
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

</style>
</head>
<body>
    <jsp:include page="../common/menubar.jsp" /> 


    <div class="bodyofbody">
        <div class="top box" style="height: 50px; padding-left: 5px;">
            <div class="previousTear"><b>2023</b>gold</div>
            <div class="previousTear"><b>2022</b>silver</div>
            <div class="previousTear"><b>2021</b>bronze</div>
        </div>
        <div class="flex-box">
            <div class="box" style="width: 25%; height: 1800px;">
                <div class="box flex-box" style="height: 200px;">
                    <div class="box flex-box" style="width: 40%; height: 100%;">
                        <div class="box profile flex-box">프사</div>
                    </div>
                    <div class="box" style="width: 60%; height: 100%;">
                        <div class="box" style="height: 55%; text-align: center; padding-top: 60px; padding-right: 70px;">
                            <h1><%=member.getUserName() %></h1>
                        </div>
                        <div class="box" style="height: 45%; text-align: center; padding-right: 70px;">
                            <h3><%=member.getAge() %> / <%=member.getGender() %></h3>
                        </div>
                    </div>
                </div>
                <div class="box flex-box" style="height: 150px;">
                    <div class="box bodybox row-flex-box">
                        <div class="box flex-box" style="height: 100%; width: 35%;">
                            <div class="box flex-box" style="width: 100px; height: 100px; background: #D9D9D9;;">휘장이미지</div>
                        </div>
                        <div class="box" style="height: 100%; width: 65%;">
                            <div class="flex-box centeralign" style="height: 100%;">
                                <div>
                                    <h1>Gold 3</h1>
                                    <h4>46p</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box flex-box" style="height: 500px;">
                    <div class="box bodybox">
                        <div class="box titlearea" style="height: 10%;">
                            <h2>신체정보</h2>
                            <a>수정버튼</a>
                        </div>
                        <div class="box" style="height: 90%;">
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>키</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemHeight() %></div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>체중</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemWeight() %></div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>체지방률</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemBep() %></div>
                                </div>
                            </div>
                            <div class="box flex-box" style="height: 25%;">
                                <div class="box spac">
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><b>골격근량</b></div>
                                    <div class="box flex-box" style="width: 50%; height: 100%;"><%=userPhysicalInfo.getMemSmm() %></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box" style="width: 75%; height: 1800px;">
                <div class="box flex-box" style="height: 200px;">
                    <div class="box stat">그래프</div>
                </div>
                
                <div id="totalUserInfoBox"></div>
                <script>
                    const sibal = document.getElementById("totalUserInfoBox");
                    for (let i = 1; i <= 10; i++) {
                        sibal.innerHTML += 
                        `
                    <div class="wrap" style="height: 150px;">
                        <div class="box stat row-flex-box">
                            <div class="box leftro" style="width: 95%; height:100%; background: black;">
                                <div class="left-flex-box box" style="width: 100%; height: 100%;">
                                    <div class="box flex-box" style="width: 20%; height: 100%;">
                                        <div style="color: white;">
                                            <h1>날짜</h1>
                                            총 2000Kcal 섭취
                                        </div>
                                    </div>
                                    <div class="box downbox" style="width: 15%; height: 100%;">
                                        <div style="color: white; width: 80%; height: 80%;">
                                            <div class="flex-box" style="background: white; color: black; width: 100%; height: 100%;">사진</div>
                                        </div>
                                        <div style="color: white; height: 20%;">벤치프레스</div>
                                    </div>
                                    <div class="box downbox" style="width: 15%; height: 100%;">
                                        <div style="color: white; width: 80%; height: 80%;">
                                            <div class="flex-box" style="background: white; color: black; width: 100%; height: 100%;">사진</div>
                                        </div>
                                        <div style="color: white; height: 20%;">벤치프레스</div>
                                    </div>
                                    <div class="box downbox" style="width: 15%; height: 100%;">
                                        <div style="color: white; width: 80%; height: 80%;">
                                            <div class="flex-box" style="background: white; color: black; width: 100%; height: 100%;">사진</div>
                                        </div>
                                        <div style="color: white; height: 20%;">벤치프레스</div>
                                    </div>
                                    <div class="box downbox" style="width: 15%; height: 100%;">
                                        <div style="color: white; width: 80%; height: 80%;">
                                            <div class="flex-box" style="background: white; color: black; width: 100%; height: 100%;">사진</div>
                                        </div>
                                        <div style="color: white; height: 20%;">벤치프레스</div>
                                    </div>
                                </div>
                            </div>
                            <div class="box rightro end" style="width: 5%; height:100%; background: #464646; color: white;">버튼</div>
                        </div>
                    </div>
                    `
                    }
                    
                </script>
            </div>
        </div>
    </div>
</body>
</html>