<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>登入</title>

<link rel="stylesheet" href="<c:url value='/front-end/member/Sam_CSS/style_login.css'/>">

</head>

<body>
	<header>
		<a href="" id="title">Le Goûter</a>
	</header>
	<section id="middle-section">
		<aside id="left-side"></aside>
		<section id="login-section-outer">
			<section class="space"></section>

			<section id="login-section-inner-o">
				<section class="inner-space"></section>
				<section id="login-section-inner">
					<p id="member-login-p">會員登入</p>
					<c:if test="${errorMsgs != null}">
						<font style="color: red">${errorMsgs}</font>
					</c:if>
					<c:if test="${register != null}">
						<font style="color: green">${register}</font>
					</c:if>
					<c:if test="${pleaseLogin != null}">
						<font style="color: red">${pleaseLogin}</font>
					</c:if>
					<form action="/CHA101_LeGouter/member/login" method="post"
						id="login-form">
						<div id="account-div">
							<label for="username">帳號:</label> <input type="text"
								id="username" name="username" placeholder="Accout">
						</div>


						<div id="password-div">
							<label for="password">密碼:</label> <input type="password"
								id="password" name="password" placeholder="Password">
						</div>


						<div id="option-div">
							<input type="submit" value="登入"> 
							<input type="button" value="註冊" onclick="window.location.href='<c:url value='/front-end/member/Register.jsp'/>'">
							<a href="" id="forget-a">忘記密碼?</a>
						</div>

						<hr>

						<div id="social-div">
							<a class="social-button" href="https://line.me/" target="_blank">Line</a>
							<a class="social-button" href="https://www.google.com/"
								target="_blank">G</a> <a class="social-button"
								href="https://www.facebook.com/" target="_blank">FB</a>
						</div>


					</form>
				</section>
				<section class="inner-space"></section>
			</section>
			<section class="space"></section>
		</section>
		<aside id="right-side"></aside>
	</section>
	<footer> Le Goûter </footer>
	
	
</body>

</html>