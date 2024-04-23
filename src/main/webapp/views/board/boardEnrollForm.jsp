<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style>
            .outer {
                padding: 30px;
                background: rgb(157, 001, 001);
                margin-top: 30px;
                border-radius: 10px;
            }
            li a {
                text-decoration: none;
                color: rgb(146, 146, 146);
            }
            #nav {
                padding: 20px 0px;
            }
            #nav>ul {
                display: flex;
            }
            
            #nav li a {
                font-weight: bolder;
                background: rgb(224, 223, 223);
                padding: 5px 15px;
                border-radius: 3px;
                
            }
            #title {
                width: 100%;
                height: 30px;
                background: rgb(224, 223, 223);
                border: 0px;
                color: black;
                border-radius: 3px;
                box-sizing: border-box;
                padding: 15px;
            }
            #content {
                margin-top: 30px;
                margin-bottom: 30px;
                width: 100%;
                height: auto;
                background: rgb(224, 223, 223);
                border: 0px;
                border-radius: 3px;
                color: black;
                resize: none;
                box-sizing: border-box;
                padding: 15px;
            }

            #board-enroll-area {
                margin: 300px auto;
                width: 955px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="../common/menubar.jsp" />

            <div id="board-enroll-area" >
                <form action="" action="" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="userNo" value="${m.loginUser}">
                <div class="outer">
                    <div style="font-size: xx-large; font-weight: bold; color: white;">커뮤니티 글쓰기</div>
                    <div align="right">
                        <button onclick="uplode()"
                            style="width: 90px; height: 30px; margin: auto; cursor: pointer;">등록</button>
                    </div>
                </div>
                
                    <input type="hidden" name="userNo" value="">
                    <div id="nav" class="bo">
                        <ul style="gap: 10px; list-style: none;">
                            <li><a href="#">자유</a></li>
                            <li><a href="#">헬창</a></li>
                            <li><a href="#">헬린이</a></li>
                            <li><a href="#">Q / A</a></li>
                        </ul>
                    </div>
                
                <div>
                    <div>
                        <input id="title" type="text" name="title" placeholder="제목을 입력하세요." required>
                    </div>
                    <div>
                        <textarea id="content" name="content" rows="10" placeholder="내용을 입력하세요." required></textarea>
                    </div>
                </div>
            </div>
            <jsp:include page="../common/.jsp" />
            <script>
                // HTML 문서가 로드될 때 실행될 함수
                document.addEventListener("DOMContentLoaded", function() {
                    // 카테고리 링크를 선택
                    var categoryLinks = document.querySelectorAll("#nav li a");
            
                    // 각 링크에 이벤트 리스너 추가
                    categoryLinks.forEach(function(link) {
                        // 링크가 클릭되었을 때 실행될 함수
                        link.addEventListener("click", function(event) {
                            // 링크의 텍스트(카테고리 이름)를 가져와 제목 필드에 할당
                            var categoryName = event.target.textContent;
                            document.getElementById("title").value = categoryName;
                        });
                    });
                });
            </script>

    </body>

    </html>