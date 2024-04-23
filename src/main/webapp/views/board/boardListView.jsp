<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <style>
                li {
                    list-style: none;
                    margin-bottom: 30px;
                }

                li a {
                    text-decoration: none;
                    color: black;
                }

                #nav {
                    margin: 30px auto;
                    padding: 30px;


                }

                #nav>ul {
                    display: flex;
                    text-align: center;

                }

                #nav>ul>li {
                    width: 100%;

                }

                #nav li a {
                    color: white;
                    font-weight: bolder;
                    background: rgb(157, 001, 001);
                    padding: 5px 15px;
                    border-radius: 3px;
                }

                .list-area {
                    color: white;
                    text-align: center;
                    width: 100%;
                    padding: 30px;
                    margin-top: -35px;
                    border-collapse: collapse;
                }

                .list-area>tbody>tr:hover {
                    background: rgb(224, 223, 223);
                    cursor: pointer;
                }

                thead th {
                    background: rgb(224, 015, 026);
                    height: 35px;
                    border-radius: px;
                }

                #bdList {
                    background: rgb(235, 235, 235);
                    height: 650px;
                    width: 899px;
                    margin: 250px auto;
                }

                .paging-area{
                    border: 0px;
                    font-size: small;
                    display: flex;
                    gap: 3px;
                    margin: 0px 75px;
                    background: rgb(189, 186, 186);
                    cursor: pointer;
                }
         
                tr {
                    border: 5px solid rgb(235, 235, 235);
                    background: white;
                    color: black;
                }
            </style>
            </head>

            <body>
                <jsp:include page="../common/menubar.jsp" />
                    <div id="menubar-space">
                        <form action="" id="bdList">
                            <input type="hidden" name="cpage" value="1">
                            <div id="nav" class="bo">
                                <ul>
                                    <li><a href="#">전체</a></li>
                                    <li><a href="#">자유</a></li>
                                    <li><a href="#">헬창</a></li>
                                    <li><a href="#">헬린이</a></li>
                                    <li><a href="#">Q / A</a></li>
                                </ul>
                            </div>
                            <table class="list-area" align="center">
                                <thead>
                                    <th width="40" style="border-radius: 15px 0px 0px 15px;">글번호</th>
                                    <th width="50">말머리</th>
                                    <th width="300">제목</th>
                                    <th width="100">글쓴이</th>
                                    <th width="100">날짜</th>
                                    <th width="50" style="border-radius: 0px 15px 15px 0px;">조회</th>
                                </thead>
                                
                                <tbody>
                                    <c:forEach var="b" items="${list}">
                                        <tr>
                                            <td>${b.boardNo}</td>
                                            <td><b>헬창</b></td>
                                            <td><a href="detail.bo?bno=${b.boardNo}">${b.boardTitle}</a></td>
                                            <td>${b.boardWriter }</td>
                                            <td>${b.createDate }</td>
                                            <td>${b.count }</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                            <div style="display: flex; margin-top: 25px; flex-direction: row;">
                                <!--검색창--> 
                                <div>
                                    <input type="text" name="keyword" value="${keyword}"
                                        style="height: 25px; border-radius: 5px; border: 0px; margin-left: 20px; width: 120px;"
                                        placeholder="제목">
                                    <button type="submit"
                                        style="border: 1px solid rgb(102, 98, 98); height: 25px; width: 60px; margin-left: 10px; background: rgb(214, 212, 212);">검색</button>
                                </div>
                                <!--게시글 페이지 이동-->
                                <div class="paging-area">
                                    <c:if test="${pi.currentPage ne 1}">
                                        <a href="list.bo?cpage=${pi.currentPage - 1}">&lt;이전</a>
                                    </c:if>

                                    <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
                                        <c:choose>
                                            <c:when test="${empty condition }">
                                                <a href="list.bo?cpage=${i}">${i}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a
                                                    href="search.bo?cpage=${i}&condition=${condition}&keyword=${keyword}">${i}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:if test="${pi.currentPage ne pi.maxPage}">
                                        <a href="list.bo?cpage=${pi.currentPage + 1}">다음&gt;</a>
                                    </c:if>
                                </div>
                            </div>
                        </form>
                    </div>
            </body>

        </html>