<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    int categoryNo = (int)session.getAttribute("categoryNo");
%>
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

        #nav li button {
            color: white;
            font-weight: bolder;
            background: rgb(157, 001, 001);
            padding: 5px 15px;
            border-radius: 3px;
            border: 0px;
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
            height: 100%;
            width: 899px;
            margin: 250px auto;
            padding-bottom: 30px;
        }

        .paging-area{
            border: 0px;
            font-size: small;
            display: flex;
            gap: 9px;
            margin-left: auto;
            margin-right: auto;
            cursor: pointer;
            display: flex;
            box-sizing: border-box;
        }

        .paging-area a{
            color: rgb(100, 87, 87);
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
                <form action="searchCategory.bo" id="bdList">
                    <input type="hidden" name="cpage" value="1">
                    <input type="hidden" name="category" value="${categoryNo}">
                    <div id="nav" class="bo">
                        <ul>
                            <li><button type="button" onclick="boCategory(0)" id="category" data-category="all" value="0">전체</button></li>
                            <li><button type="button" onclick="boCategory(10)" id="category" data-category="free" value="10">자유</button></li>
                            <li><button type="button" onclick="boCategory(20)" id="category" data-category="helchang" value="20">헬창</button></li>
                            <li><button type="button" onclick="boCategory(30)" id="category" data-category="helin" value="30">헬린이</button></li>
                            <li><button type="button" onclick="boCategory(40)" Id="category" data-category="qa" value="40">Q / A</button></li>
                        </ul>
                    </div>
                    <script>
                        
                        
                        function boCategory(category){
                            if(category === 0){ // 카테고리 번호 0 = 전체 버튼 누름
                                location.href = "list.bo?cpage=1"; // 기존의 커뮤니티 페이지로 이동
                            }else{ // 카테고리 번호 10~40 = 4가지 카테고리 버튼 중 하나를 누름
                                location.href = "boardCategory.bo?cpage=1&category=" + category; // 카테고리별 페이지로 이동
                            }
                        }
                            
                        
                    </script>

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
                                    <td><b>${b.categoryName}</b></td>
                                    <td><a href="detail.bo?bno=${b.boardNo}" style="color: black;">${b.boardTitle}</a></td>
                                    <td>${b.boardWriter }</td>
                                    <td>${b.createDate }</td>
                                    <td>${b.count }</td>
                                </tr>
                            </c:forEach>
                            <script>

                            </script>

                        </tbody>
                    </table>

                    <div style="display: flex; margin-top: 25px; flex-direction: row;">
                        <!--검색창--> 
                        <div>
                            <select name="condition" id="condition" style="margin-left: 5px;">
                                <option value="title">제목</option>
                                <option value="writer">글쓴이</option>
                                <option value="content">내용</option>
                            </select>
                            <c:if test="${not empty condition}">
                                <script>
                                    window.onload = function(){
                                        const opt = document.querySelector("#condition option[value=${condition}]");
                                        opt.setAttribute("selected", true);
                                    }
                                </script>
                            </c:if>
                            <input type="text" name="keyword" value="${keyword}"
                                style="height: 25px; border-radius: 5px; border: 0px; margin-left: 20px; width: 120px;"
                                placeholder="제목">
                            <button type="submit"
                                style="border-radius: 4px; border: 1px solid rgb(102, 98, 98); height: 25px; width: 60px; margin-left: 10px; background: rgb(214, 212, 212);">검색</button>
                        </div>
                        <!--게시글 페이지 이동-->
                        <div class="paging-area">
                            <c:choose>
                                <c:when test="${empty condition }">
                                    <c:if test="${pi.currentPage ne 1}">
                                        <a href="boardCategory.bo?cpage=${pi.currentPage - 1}&category=${categoryNo}">&lt;이전</a>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${pi.currentPage ne 1}">
                                        <a href="searchCategory.bo?cpage=${pi.currentPage - 1}&category=${categoryNo}&condition=${condition}&keyword=${keyword}">&lt;이전</a>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>

                            <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
                                <c:choose>
                                    <c:when test="${empty condition }">
                                        <c:choose>    
                                            <c:when test="${pi.currentPage ne i}">
                                                <a href="boardCategory.bo?cpage=${i}&category=${categoryNo}">${i}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <b>${i}</b>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>    
                                            <c:when test="${pi.currentPage ne i}">
                                                <a href="searchCategory.bo?cpage=${i}&category=${categoryNo}&condition=${condition}&keyword=${keyword}">${i}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <b>${i}</b>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:choose>
                                <c:when test="${empty condition }">
                                    <c:if test="${pi.currentPage ne pi.maxPage}">
                                        <a href="boardCategory.bo?cpage=${pi.currentPage + 1}&category=${categoryNo}">다음&gt;</a>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${pi.currentPage ne pi.maxPage}">
                                        <a href="searchCategory.bo?cpage=${pi.currentPage + 1}&category=${categoryNo}&condition=${condition}&keyword=${keyword}">&lt;다음</a>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div style=" margin-left: 150px; margin-right: 30px; display: flex; box-sizing: border-box;">
                            <a href="enrollForm.bo" style="color: black;">글쓰기</a>
                        </div>
                    </div>
                </form>
            </div>
    </body>

</html>