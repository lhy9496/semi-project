<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
        <%@ include file="../common/menubar.jsp" %>

            <div id="board-enroll-area">
                <form action="">
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
                            <li><a href="#" onclick="">자유</a></li>
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
    
                <script>
                    // 카테고리를 선택했을 때 제목 입력란에 자동으로 설정하는 함수
                    function setCategory(category) {
                        document.getElementById("title").value = category;
                    }
    
                    // 등록 버튼을 눌렀을 때 실행되는 함수
                    function upload() {
                        // 제목과 내용을 가져옴
                        var title = document.getElementById("title").value;
                        var content = document.getElementById("content").value;
    
                        // 제목과 내용이 비어있는지 확인
                        if (title.trim() === "" || content.trim() === "") {
                            alert("제목 또는 내용을 입력하세요.");
                        } else {
                            // 등록 작업 수행
                            // 여기에 등록 작업을 위한 코드를 추가하면 됨
                            alert("게시글이 등록되었습니다.");
                            // 등록 후 페이지 이동 또는 다른 작업 수행 가능
                        }
                    }
                </script>
            </div>
            

    </body>

    </html>