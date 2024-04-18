<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="com.pss.board.model.vo.Board" %>
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

            .paging-area button {
                border: 0px;
                font-size: small;
                


            }

            .paging-area>button:hover {
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
            <%@ include file="../common/menubar.jsp" %>
                <div id="menubar-space">
                    <form action="" id="bdList">
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
                                <th width="40" style="border-radius: 15px 0px 0px 15px;">번호</th>
                                <th width="50">말머리</th>
                                <th width="300">제목</th>
                                <th width="100">글쓴이</th>
                                <th width="100">날짜</th>
                                <th width="50" style="border-radius: 0px 15px 15px 0px;">조회</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                                <tr>
                                    <td>127</td>
                                    <td><b>헬창</b></td>
                                    <td>안녕하세요 운동좀 물어볼게요</td>
                                    <td>흑드라군</td>
                                    <td>2024/04/04</td>
                                    <td>27</td>
                                </tr>
                            </tbody>
                        </table>

                        <div style="display: flex; margin-top: 25px; flex-direction: row;">
                            <div>
                                <input type="text"
                                    style="height: 25px; border-radius: 5px; border: 0px; margin-left: 20px; width: 120px;"
                                    placeholder="제목">
                                <button
                                    style="border: 1px solid rgb(102, 98, 98); height: 25px; width: 60px; margin-left: 10px; background: rgb(214, 212, 212);">검색</button>
                            </div>
                            <div class="paging-area"
                                style="display: flex; gap: 3px; margin: 0px 75px;">

                                <button onclick="prevPage()">&lt;이전</button>
                                <button disabled>1</button>
                                <button onclick="">2</button>
                                <button onclick="">3</button>
                                <button onclick="">4</button>
                                <button onclick="">5</button>
                                <button onclick="">6</button>
                                <button onclick="">7</button>
                                <button onclick="">8</button>
                                <button onclick="">9</button>
                                <button onclick="">10</button>
                                <button onclick="nextPage()">다음&gt;</button>

                            </div>
                        </div>
                    </form>
                </div>
                <script>
                    // 말머리를 클릭하면 해당 말머리로 이동
                    document.querySelectorAll('#nav a').forEach(anchor => {
                        anchor.addEventListener('click', function (e) {
                            e.preventDefault();

                            const target = document.querySelector(this.getAttribute('href'));
                            target.scrollIntoView({
                                behavior: 'smooth'
                            });
                        });
                    });

                    // 글 제목을 클릭하면 해당 글로 이동
                    document.querySelectorAll('.list-area tbody a').forEach(anchor => {
                        anchor.addEventListener('click', function (e) {
                            e.preventDefault();

                            const target = document.querySelector(this.getAttribute('href'));
                            target.scrollIntoView({
                                behavior: 'smooth'
                            });
                        });
                    });

                    function prevPage() {
                        // 이전 페이지로 이동하는 로직을 여기에 추가
                        alert('이전 페이지로 이동합니다.');
                    }

                    function nextPage() {
                        // 다음 페이지로 이동하는 로직을 여기에 추가
                        alert('다음 페이지로 이동합니다.');
                    }

                    function goToPage(pageNumber) {
                        // 해당 페이지로 이동하는 로직을 여기에 추가
                        alert('페이지 ' + pageNumber + '로 이동합니다.');
                    }
                    function search() {
                        // 검색어 입력란에서 입력된 값을 가져옴
                        var keyword = document.getElementById("searchInput").value.trim();

                        // 검색어가 비어있는 경우 알림창을 띄움
                        if (keyword === "") {
                            alert("검색어를 입력하세요.");
                            return;
                        }

                </script>

        </body>

    </html>