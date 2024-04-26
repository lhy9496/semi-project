<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <style>
                #db {
                    max-width: 900px;
                    margin: 0px auto;
                    padding-top: 300px;
                }

                #db #area1 {

                    background: rgb(224, 015, 026);
                    font-size: large;
                    text-align: left;
                    font-size: small;
                    border-radius: 5px 5px 0px 0px;
                    margin-top: -1px;
                    padding: 30px;
                }

                #db div>ul {
                    background: rgb(224, 223, 223);
                    height: 100%;
                    width: 100%;
                    box-sizing: border-box;
                    padding: 150px;
                    margin-top: 250px;

                }

                #db .date1 {
                    height: auto;
                    width: 100%;
                    background: rgb(250, 243, 243);
                    border-radius: 0px 0px 5px 5px;
                    box-sizing: border-box;

                }

                #db #com {
                    background: rgb(207, 200, 200);
                    height: auto;
                    border-radius: 10px;
                    text-align: left;
                    width: 100%;
                }

                #db .wr {
                    background: rgb(207, 200, 200);
                    height: 150px;
                    width: 100%;
                    margin-top: -30px;
                    display: flex;
                    flex-direction: row;

                }

                #db #user1 {
                    con: '';
                    display: block;
                    border-bottom: 1px solid black;
                    margin-bottom: 10px;
                }

                #db #combt {
                    width: 150px;
                    text-align: center;
                    margin-left: 30px;
                }

                #db .bt>button:hover {
                    background: rgb(122, 87, 87);
                    cursor: pointer;
                }

                #db #con {
                    width: 80%;
                    resize: none;
                    background: rgb(207, 200, 200);
                    color: black;
                    padding: 30px;
                    border: 0px;
                }
                #com td{
                    padding-left: 30px;
                }
                #reply-content{
                    width: 500px;
                }
            </style>
        </head>

        <body>
            <%@ include file="../common/menubar.jsp" %>
                <div id="menubar-space">
                    <form action="">
                        <div id="db">
                            <ul>
                                <div id="area1">
                                    <table align="center">
                                        <tr>
                                            <th>&lt;${ b.categoryName }&gt;</th>
                                            <th></th>
                                            <th></th>
                                            <th width="550px">&lt;${ b.boardTitle }&gt;</th>
                                        </tr>
                                        <tr>
                                            <th colspan="7" style="text-align: right;">
                                                ${ b.boardWriter }
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>&lt;글번호&gt;</th>
                                            <th>${ b.boardNo }</th>
                                            <th>|</th>
                                            <th>
                                                ${ b.createDate }
                                            </th>
                                            <th>&lt;조회&gt;${ b.count }</th>
                                            <th>|</th>
                                            <th>&lt;리플&gt;</th>
                                        </tr>
                                    </table>
                                </div>
                                <table class="date1">
                                    <tr>
                                        <th>
                                            <p style="font-size: medium; margin: 30px; text-align: left;">
                                                ${ b.boardContent }
                                            </p>
                                        </th>
                                    </tr>
                                </table>

                                <div id="area1" style="padding: 10px;">&lt;댓글&gt;(${list.size()})</div>
                                <div class="date1" style="padding: 30px;">
                                    <table id="com" style="padding: 40px;">
                                    <c:forEach var="reply" items="${rlist }">
                                       
                                     </c:forEach>
                                     <tbody>
                                     	
                                     </tbody>   
                                    </table>
                                </div>

                                <div class="date1" style="padding: 30px;">
                                    <div class="wr">
                                        <textarea id="con" name="con" rows="10" placeholder="내용을 입력하세요."
                                            required></textarea>

                                        <div style="width: 10px; background: rgb(250, 243, 243);"></div>
										<c:if test="${not empty loginUser }">
											<div class="bt" style="margin: auto; ">
                                            <button type="button" onclick="insertReply()"
                                                style="background: rgb(207, 200, 200); border: 0px; ">등록</button>
                                        </div>
										</c:if>
                                        <c:if test="${empty loginUser }">
                                        	<div class="bt" style="margin: auto; ">
                                            <button type="button" 
                                                style="background: rgb(207, 200, 200); border: 0px; " disabled>등록</button>
                                        </div>
                                        </c:if>
                                    </div>
                                </div>

                            </ul>
                        </div>
                    </form>
                </div>
		<script>
			$(function(){
                selectReplyList();
			})
			
			function selectReplyList() {
				$.ajax({
                    type: "POST",
					url: "rlist.bo",
					data : {
						bno : ${b.boardNo}
					},
					success: function(res) {
						console.log(res);
						let str = "";
                        for(let reply of res){
                            str += ("<tr>"+
                                    "<td>" + reply.replyWriter + "</td>" +
                                    "<td id='reply-content'>" + reply.replyContent + "</td>" +
                                    "<td>" + reply.createDate + "</td>" +
                                    "</tr>")
                        }
                        
                        document.querySelector("#com tbody").innerHTML = str;
					},
					
					error: function() {
						
					}
				})
			}
			
			
            function insertReply(){
                let replyContent = $('#con').val();
                let boardNo = ${b.boardNo};
                console.log(boardNo);
                console.log(replyContent);

                $.ajax({
                        url : "rinsert.bo",
                        data : {
                            bno : boardNo,
                            content : replyContent
                        },
                        type : "POST",
                        success : function(res){
                            document.querySelector("#con").value = "";
                            selectReplyList();
                        }, 
                        error : function(){
                            console.log("댓글 작성중 ajax통신 실패")
                            alert("글자수 제한을 초과하였습니다.")
                        }
                    })	
            }

           
		
		</script>
        </body>

        </html>