<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Moderna - Bootstrap 3 flat corporate template</title>
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
<link href="resources/main/skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

li {
	list-style-type: none;
}

.menu li a {
	display: inline-block;
	background: #c00;
	color: #ddf;
	width: 100px;
	height: 23px;
	padding-top: 10px;
	text-align: center;
}

.menu li a:hover {
	background: #abcdef;
	color: #000;
}
</style>
<style type="text/css">
body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: #68A4C4;
}

a:hover {
	text-decoration: none;
	color: #68A4C4;
}

a:active {
	text-decoration: none;
	color: #68A4C4;
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

#view_layer {
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

p {
	font-family: "malgun gothic";
	font-size: 1.6em;
	padding-left: 135px;
	padding-top: 50px;
}

body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}

th{ background-color:gray; color:green;}
	html, body{height:100%;margin:0}
	#articleView_layer {
		display:none;position:fixed;
		_position:absolute;top:0;left:0;
		z-index:10000;width:100%;height:100%}
  	#articleView_layer.open {display:block;color:green} 
/*   	  	.open {display:block;color:green} */
	#articleView_layer .bg_layer {
		   position:absolute;top:0;left:0;
		   width:100%;height:100%;background:#000;
		   opacity:.5;filter:alpha(opacity=50)}
#pwdajax {
	position: absolute;
	top: 25%;
	left: 40%;
	margin: 1px 0 0 1px;
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
	function articleView(idx) {//
		$('#articleView_layer').addClass('open');
		$.ajax({
			type : 'post',
			url : 'questUpdateform',
			data : ({
				faq_code : idx
			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
			success : function(data) {//성공하면
				$('#view_layer').html(data);
			}
		});
	}

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

	function questDel(code) {
		$.ajax({
			type : 'get',
			url : 'questDelete',
			data : ({
				faq_code : code
			}),
			success : function(data) {//성공하면
				alert("삭제되었습니다");
				$('#faqcontent').html(data);
			}
		});
	}
</script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<script type="text/javascript">

	function findhashform(code) {//	
		$('#articleView_layer').addClass('open');
		$.ajax({
			type : 'post',
			url : 'findHashDetailform',
			data : ({
				hs_Title : hs_Title
			}),
			success : function(data) {
				$('#findHashDetail').html(data);
			}
		});
	}


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
</script>
<script type="text/javascript">
	function display(id) {
		var element = document.getElementById(id);
		element.style.display = element.style.display == 'none' ? 'block'
				: 'none';
	}
	function logincheck() {
		var m_Email = document.getElementsByName("m_Email")[0];
		var m_PWD = document.getElementsByName("m_PWD")[0];
		if (m_Email.value == "") {
			alert("이메일 입력");
			m_Email.focus();
			return false;
		} else if (m_PWD.value == "") {
			alert("비밀번호 입력");
			m_PWD.focus();
			return false;
		}
		return true;
	}
	function logoutcheck() {
		alert("로그아웃");
		return true;
	}
	function pwdajax() {//		 
		$.ajax({
			type : 'post',
			url : 'findPWDAjax',
			data : ({
				
			}),
			success : function(data) {//성공하면
				$('#articleView_layer').addClass('open');
				$('#pwdajax').html(data);
			}
		});
	}
</script>
</head>
<body>
	<div id="wrapper">
	<div id="articleView_layer">
                        <div class="bg_layer"></div>
                        <div id="pwdajax"></div>
                     </div>
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
						<a class="navbar-brand" href="/"><span>S</span>gw</a>
					</div>

					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li class="dropdown" class="active"><a href="index.html"
								class="dropdown-toggle " data-toggle="dropdown"
								data-hover="dropdown" data-delay="0" data-close-others="false">서비스
									소개 <b class=" icon-angle-down"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="/storyform">스토리</a></li>
									<li><a href="/serviceform">서비스 소개</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">고객센터 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/noticeform">공지사항</a></li>
									<li><a href="/questform">자주묻는 질문</a></li>
									<li><a href="/errorReportInsertform">서비스 오류 신고</a></li>
								</ul></li>
							<%
								if (request.getSession().getAttribute("sessionmid") != null) {
							%>
							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">마이 페이지 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/baseInfoPage">My정보</a></li>
									<li><a href="/alramMgr_View">서비스 관리</a></li>
									<li><a href="/teamMemberListPage">나의 팀 관리</a></li>
								</ul></li>
							<li class="dropdown"><a href="/logOut">로그아웃</a></li>
							<%
								} else {
							%>
							<li><a href="#" onclick="display('loginform')">로그인</a></li>
							<li><a href="/joinform">회원가입</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<!-- end header -->
		<section id="featured"  style="background-color: white">
			<!-- start slider -->
			<div class="container"
				style="background-color: white; padding-left: 842px;">
				<div class="row">
					<div class="col-lg-12">
						<div id="loginform" style="display: none;">
							<form action="/login" method="post"
								onsubmit="return logincheck(this);">
								<table style="float: left;">
									<tr>
										<td><input type="text" name="m_Email" placeholder="이메일">&nbsp;&nbsp;&nbsp;</td>
										<td><input type="password" name="m_PWD"
											placeholder="비밀번호">&nbsp;&nbsp;</td>
									</tr>
									<tr>
									<td><a href="#" onclick="pwdajax()">비밀번호 찾기</a></td>
										<td><input type="submit" value="로그인"></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>


			</div>
			<p>
				<strong>자주 묻는 질문</strong>
			</p>
		</section>
		<section id="content">
			<div class="container">

				<div class="row">
					<div class="col-lg-12">

						<div class="row">

							<div class="col-lg-12">
								<!-- col-lg-숫자:숫자에 따라서 행의 길이가 적용됨 -->

								<form action="" name="faqform" method="post" style="padding-left:70px; padding-right:70px;">

									<table style="width: 100%">
										<colgroup>
											<col width="20%">
											<col width="20%">
											<col width="20%">
											<col width="20%">
											<col width="20%">
										</colgroup>

										<!-- 리스트 페이지 이동 -->

										${questList}
										<div class="panel-group" id="accordion">${questDList}</div>
										${faqbutton}

									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- divider -->
				<div class="row">
					<div class="col-lg-12"></div>
				</div>
				<!-- end divider -->
				<!-- Portfolio Projects -->

			</div>
		</section>
		<footer>
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
							<ul class="link-list">
							</ul>
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
							<h5 class="widgetheading"></h5>
							<div class="flickr_badge">
								
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<div id="sub-footer">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="copyright">
								<p>
									<span></span><a></a>
								</p>
							</div>
						</div>
						<div class="col-lg-6"></div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<div id="articleView_layer">
		<div class="bg_layer"></div>
		<div id="view_layer"></div>
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