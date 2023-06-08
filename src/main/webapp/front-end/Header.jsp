<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<link rel="preconnect" href="https://fonts.googleapis.com/">
	<link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin="">
	<link href="<c:url value='/front-end/member/static/css/css2.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/all.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/bootstrap-icons.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/animate.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/owl.carousel.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/front-end/member/static/css/style.css'/>" rel="stylesheet">
</head>

<body>
	<div id="spinner"
		class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary" role="status"></div>
	</div>


	<div class="container-fluid top-bar bg-dark text-light px-0 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="row gx-0 align-items-center d-none d-lg-flex">
			<div class="col-lg-6 px-5 text-start">
				<ol class="breadcrumb mb-0">
					<!-- <li class="breadcrumb-item"><a class="small text-light" href="#">Home</a></li>
                    <li class="breadcrumb-item"><a class="small text-light" href="#">Career</a></li>
                    <li class="breadcrumb-item"><a class="small text-light" href="#">Terms</a></li>
                    <li class="breadcrumb-item"><a class="small text-light" href="#">Privacy</a></li> -->
				</ol>
			</div>
			<div class="col-lg-6 px-5 text-end">
				<small>Follow us:</small>
				<div class="h-100 d-inline-flex align-items-center">
					<a class="btn-lg-square text-primary border-end rounded-0" href=""><i
						class="fab fa-facebook-f"></i></a> <a
						class="btn-lg-square text-primary border-end rounded-0" href=""><i
						class="fab fa-twitter"></i></a> <a
						class="btn-lg-square text-primary border-end rounded-0" href=""><i
						class="fab fa-linkedin-in"></i></a> <a
						class="btn-lg-square text-primary pe-0" href=""><i
						class="fab fa-instagram"></i></a>
				</div>
			</div>
		</div>
	</div>

	<!-- 導覽列 -->
	<nav
		class="navbar navbar-expand-lg navbar-dark fixed-top py-lg-0 px-lg-5 wow fadeIn"
		data-wow-delay="0.1s">
		<a href="" class="navbar-brand ms-4 ms-lg-0">
			<h1 class="text-primary m-0">Le Goûter</h1>
		</a>
		<button type="button" class="navbar-toggler me-4"
			data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav mx-auto p-4 p-lg-0">
				<a href="<c:url value='/front-end/FrontIndex.jsp'/>"class="nav-item nav-link">首頁</a> 
				<c:choose>
  					<c:when test="${isLogin == null}">
    					<a href="<c:url value='/front-end/member/Login.jsp'/>" class="nav-item nav-link">會員登入</a>
  					</c:when>
  					<c:otherwise>
    					<a href="<c:url value='/member/memberLogout'/>"class="nav-item nav-link">登出</a> 
  					</c:otherwise>
				</c:choose>
				<a href=""class="nav-item nav-link">最新消息</a> 
				<a href=""class="nav-item nav-link">關於我們</a> 
				<a href=""class="nav-item nav-link">甜點商城</a> 
				<a href=""class="nav-item nav-link">課程專區</a> 
				<a href=""class="nav-item nav-link">團購專區</a> 
				<a href="<c:url value='/member/memberData'/>"class="nav-item nav-link">會員專區</a> 
				<a href=""class="nav-item nav-link">優惠券專區</a>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"data-bs-toggle="dropdown">其他</a>
					<div class="dropdown-menu m-0">
						<a href="" class="dropdown-item">FAQ</a> <a href=""class="dropdown-item">聯絡客服</a>
					</div>
				</div>
			</div>
			<div class=" d-none d-lg-flex">
				<div
					class="flex-shrink-0 btn-lg-square border border-light rounded-circle">
					<i class="fa fa-phone text-primary"></i>
				</div>
				<div class="ps-3">
					<small class="text-primary mb-0">聯絡我們</small>
					<p class="text-light fs-5 mb-0">0912345678</p>
				</div>
			</div>
		</div>
	</nav>
	
	<script data-cfasync="false" src="<c:url value='/front-end/member/static/js/email-decode.min.js'/>"></script>
    <script src="<c:url value='/front-end/member/static/js/jquery-3.4.1.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/bootstrap.bundle.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/wow.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/easing.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/waypoints.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/counterup.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/owl.carousel.min.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/main.js'/>" type="0080e6b992b21508d4c0eeae-text/javascript"></script>
    <script src="<c:url value='/front-end/member/static/js/rocket-loader.min.js'/>" data-cf-settings="0080e6b992b21508d4c0eeae-|49" defer=""></script>
</body>