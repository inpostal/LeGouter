<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="myVar" value="Hello, World!" scope="application" />


<!DOCTYPE html>
<html lang="en">

<head>
    <title>會員專區</title>
    <link rel="stylesheet" href="<c:url value='/front-end/member/Sam_CSS/style_member_data.css'/>">
</head>

<body>

	<%@ include file="/front-end/Header.jsp" %>

    <section id="main-container">
        <aside id="left-side">
            <p id="left-side-title">會員專區</p>
            <hr id="left-side-hr">
            <ul id="ul">
                <li class="list">會員資料</li>
                <li class="list" id="dessert">甜點專區</li>
                <ul id="subUl1" class="hide">
                    <li class="subList">甜點追蹤清單</li>
                    <li class="subList">甜點訂單</li>
                </ul>
                <li class="list" id="member-class">課程專區</li>
                <ul id="subUl2" class="hide">
                    <li class="subList">觀看課程</li>
                    <li class="subList">課程訂單</li>
                    <li class="subList">收藏的課程</li>
                </ul>
                <li class="list" id="member-group">團購專區</li>
                <ul id="subUl3" class="hide">
                    <li class="subList">團購訂單</li>
                </ul>
                <li class="list">優惠券列表</li>
            </ul>
        </aside>

        <!-- 以下是右邊欄位放資訊用的 -->
        <section id="msg-container">
            <section id="msg-container-title">
                <p id="msg-container-title-p">會員資料</p>
            </section>
            <hr id="msg-container-hr">
            <section id="msg-container-main">
                <table id="member-data-table">
                    <tr>
                        <th>資訊</th>
                        <th>內容</th>
                    </tr>
                    <tr>
                        <td>會員分類</td>
                        <td>一般會員</td>
                    </tr>
                    <tr>
                        <td>會員姓名</td>
                        <td>${memberName}</td>
                    </tr>
                    <tr>
                        <td>帳號</td>
                        <td>${memberAcount}</td>
                    </tr>
                    <tr>
                        <td>密碼</td>
                        <td>${memberPassword}</td>
                    </tr>
                    <tr>
                        <td>性別</td>
                        <td>${gender}</td>
                    </tr>
                    <tr>
                        <td>電話</td>
                        <td>${memberPhone}</td>
                    </tr>
                    <tr>
                        <td>信箱</td>
                        <td>${memberMail}</td>
                    </tr>
                    <tr>
                        <td>地址</td>
                        <td>${memberAddress}</td>
                    </tr>
                    <tr>
                        <td>生日</td>
                        <td>${memberBirthday}</td>
                    </tr>
                    <tr>
                        <td>註冊時間</td>
                        <td>${memberRegisterDate}</td>
                    </tr>
                </table>
                <button type="text" id="update">修改會員資料</button>
            </section>
        </section>
    </section>
    
    <%@ include file="/front-end/Footer.jsp" %>

    <script>
        window.onload = function () {
            // 側邊欄位動畫
            function leftSide(liid, subUlid) {
                document.getElementById(liid).addEventListener("click", function () {
                    var subUl = document.getElementById(subUlid);
                    if (subUl.getAttribute("class") === "hide") {
                        subUl.setAttribute("class", "show");
                    } else {
                        subUl.setAttribute("class", "hide");
                    }
                });
            }
            leftSide("dessert", "subUl1");
            leftSide("member-class", "subUl2");
            leftSide("member-group", "subUl3");
        };
    </script>
</body>

</html>