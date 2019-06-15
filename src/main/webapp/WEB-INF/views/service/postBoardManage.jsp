<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//안쓰는거니 신경안써도 됨
	//String pagefile=request.getParameter("page");
	//if(pagefile==null) pagefile="includeTest1.jsp";
%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>MGR Templete</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />
<!-- css -->
<link href="resources/main/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/main/css/fancybox/jquery.fancybox.css"
	rel="stylesheet">
<link href="resources/main/css/jcarousel.css" rel="stylesheet" />
<link href="resources/main/css/flexslider.css" rel="stylesheet" />
<link href="resources/main/css/style.css" rel="stylesheet" />


<!-- Theme skin -->
<link href="resources/skins/main/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<script type="text/javascript">
	function boardPostDelte() {
		var code = $('input[name=bp_Code]:radio:checked').val();
		alert(code);
		//document.action="/aa";
		//document.submit();
	}
</script>


<style type="text/css">
body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}

p {
	font-family: "malgun gothic";
	font-size: 1.6em;
	padding-left: 140px;
	padding-top: 50px;
}



/* table, td, th{border:1px solid gray;} */
th {
	background-color: gray;
	color: green;
}

html, body {
	height: 100%;
	margin: 0
}

#articleView_layer {
	display: none;
	position: fixed;
	_position: absolute;
	top: 0;
	left: 0;
	z-index: 10000;
	width: 100%;
	height: 100%
}

#articleView_layer.open {
	display: block;
	color: green
}
/*   	  	.open {display:block;color:green} */
#articleView_layer .bg_layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50)
}

#ownerChange {
	position: absolute;
	top: 25%;
	left: 40%;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 3px solid yellow;
	background: #fff;
	font-size: 12px;
	color: #767676;
	line-height: normal;
	white-space: normal
}

</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript">
	
	$(function() {
		var layerWindow = $('#articleView_layer');
		// ESC Event
		$(document).keydown(function(event) {
			if (event.keyCode != 27)
				return true;
			if (layerWindow.hasClass('open')) {
				layerWindow.removeClass('open');
			}
			return false;
		});
	
		// Hide Window
		layerWindow.find('.bg_layer').mousedown(function(event) {
			layerWindow.removeClass('open');
			return false;
		});
	});


	function ownerchange() {//
		//alert($('#m_Email').val());
		var a = $("input[type=radio][name=bp_Code]:checked").val();
		$.ajax({
			type : 'post',
			url : 'teamboardpostownerchangeView',
			data : ({
				bp_Code : a
			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
			success : function(data) {//성공하면
				$('#articleView_layer').addClass('open');
				$('#ownerChange').html(data);
			}
		});
	}
</script>


<style>
body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}

p {
	font-family: "malgun gothic";
	font-size: 1.6em;
}

.sgwline3 {
	position: absolute;
	right: 110px;
	bottom: 0;
}
</style>
</head>
<body>
	<div id="wrapper">

	
		<!-- start header -->
		<header>
			<div class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/"><span>S</span>GW</a>
					</div>
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li class="dropdown "><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">My정보 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/baseInfoPage">기본정보</a></li>
									<li><a href="/UpdatePwdPage">비밀번호 변경</a></li>
									<li><a href="/memberDropPage">회원 탈퇴</a></li>
									<li><a href="/myPostList">게시판 관리</a></li>
									<li><a href="/MyMemoHamList">방명록 관리</a></li>
								</ul></li>
							<li class="dropdown "><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">서비스 관리 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/alramMgr_View">알림 관리</a></li>
									<li><a href="/logOutOption">로그아웃 설정</a></li>
								</ul></li>
							<li class="dropdown "><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">나의 팀 관리<b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/teamMemberListPage">멤버 목록</a></li>
									<li><a href="/teamDrop">팀 삭제</a></li>
									<li><a href="/teamInfoPage">팀 정보 관리</a></li>
									<li><a href="/boardPostListform">게시판 관리</a></li>
									<li><a href="/TeamMemoHamList">메모함 관리</a></li>
									<li><a href="#">접속내역 관리</a></li>
								</ul></li>
						</ul>
					</div>
				</div>

			</div>
		</header>
		<!-- end header -->

			<div id="articleView_layer" >
					   <div class="bg_layer"></div>
					   <div id="ownerChange"></div>
			</div>	



		<section id="inner-headline" style="background-color: white">
			<div class="container">
				<div class="row">

					<div class="col-lg-12"></div>
				</div>
			</div>
		</section>

		<!-- 밑에 지원도 됨 기호에 맞춰서 지우거나 남기거나 하면 됨-->
		<!-- 밑에 지우면 딱 위에 영역까지만 잡혀있고 늘리는 만큼 늘어남 -->
		<section id="content">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<ul class="portfolio-categ filter">
							${teamboardpostlist}
						</ul>
						<div class="clearfix"></div>
						<div class="row">
							<section id="projects">
								<ul id="thumbs" class="portfolio">
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 design" data-id="id-0"
										data-type="web">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 design" data-id="id-1"
										data-type="icon">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 photography" data-id="id-2"
										data-type="graphic">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 design" data-id="id-0"
										data-type="web">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 photography" data-id="id-4"
										data-type="web">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 photography" data-id="id-5"
										data-type="icon">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<li class="item-thumbs col-lg-3 design" data-id="id-0"
										data-type="web">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
									<!-- Item Project and Filter Name -->
									<li class="item-thumbs col-lg-3 design" data-id="id-0"
										data-type="graphic">
										<!-- Fancybox - Gallery Enabled - Title - Full Image --> <!-- Thumb Image and Description -->
									</li>
									<!-- End Item Project -->
								</ul>
							</section>
						</div>
					</div>
				</div>
			</div>
		</section>
		<footer style="background-color: #68A4C4">
			<div class="container">
				<div class="row">
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading"></h5>


						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading"></h5>

						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading"></h5>
							<ul class="link-list">

							</ul>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget">

							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<div id="sub-footer" style="margin-top: 50px;">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="copyright"></div>
						</div>
						<div class="col-lg-6"></div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!-- javascript

    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/main/js/jquery.js"></script>
	<script src="resources/main/js/jquery.easing.1.3.js"></script>
	<script src="resources/main/js/bootstrap.min.js"></script>
	<script src="resources/main/js/jquery.fancybox.pack.js"></script>
	<script src="resources/main/js/jquery.fancybox-media.js"></script>
	<script src="resources/main/js/google-code-prettify/prettify.js"></script>
	<script src="resources/main/js/portfolio/jquery.quicksand.js"></script>
	<script src="resources/main/js/portfolio/setting.js"></script>
	<script src="resources/main/js/jquery.flexslider.js"></script>
	<script src="resources/main/js/animate.js"></script>
	<script src="resources/main/js/custom.js"></script>
</body>
</html>