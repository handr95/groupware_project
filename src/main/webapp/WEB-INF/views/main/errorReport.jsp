<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<style>
img {
	vertical-align: bottom;
	border: 0
}

div.error_wrap {
	width: 570px;
	margin: 0 auto;
	padding: 20px 0 40px;
}

div.error_wrap div.form {
	padding: 10px 40px 30px;
	border: 4px solid #becae2
}

div.error_wrap p.cmt {
	text-align: right;
	color: #555555
}

div.error_wrap span.essential {
	color: #2758e5
}

div.error_wrap table.error_list {
	margin-top: 20px;
}

div.error_wrap table.error_list tr:hover {
	background-color: #fff
}

div.error_wrap table.error_list th {
	width: 130px;
	color: #555555;
	font-size: 14px;
	text-align: left;
	vertical-align: top
}

div.error_wrap table.error_list th, div.error_wrap table.error_list td {
	padding: 5px 0
}

div.error_wrap table.error_list td {
	width: 350px;
}

div.error_wrap input.text {
	width: 100%;
	padding: 0;
	border-color: #bcbcbc;
	border-width: 0 0 1px 0;
	background-color: #fff;
}

div.error_wrap textarea {
	width: 100%;
	min-height: 135px;
	_height: 135px;
}

div.error_wrap ul li.on a, div.error_wrap ul li a:hover {
	background-position: 0 -138px;
}

div.error_wrap textarea {
	font-family: malgun gothic;
	font-size: 12px;
	color: #95a0b6;
	background-color: #eff0f2;
	border: 1px solid #D4D4D4
}

div.user_file {
	margin: 0
}

.privacyInfo {
	width: 100%
}

div.privacyInfo div.p_cont {
	border: 1px solid #DDDFE9;
	color: #180902;
	height: 35px;
	letter-spacing: -1px;
	overflow: auto;
	padding: 15px;
}

div.privacyInfo div.p_cont p {
	line-height: 180%;
	color: #555555;
}

div.privacyInfo p.agreecheck {
	background: #eee;
	margin: 10px 0;
	padding: 5px 0;
	text-align: center;
	color: #555555;
}

div.privacyInfo div.agreecheck p.agreecheck_i {
	letter-spacing: -1px;
	line-height: 16px;
	margin: 10px 0 0
}

div.privacyInfo p.p_tit {
	font-weight: bold;
	margin: 20px 0 5px;
	padding: 0;
	color: #555
}

div.btnAction {
	clear: left;
	text-align: center;
	margin-top: 50px
}

div.btnAction a.btn {
	color: #fff;
	font-weight: bold;
	font-family: malgun gothic;
	font-size: 14px;
	padding: 10px 35px;
	background: #348cd6;
	border-radius: 3px;
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



<script type="text/javascript">
	function reportCheck() {
		var er_name = document.getElementsByName("er_name")[0];
		var er_eamil = document.getElementsByName("er_email")[0];
		var er_title = document.getElementsByName("er_title")[0];
		var er_content = document.getElementsByName("er_content")[0];

		if (er_name.value == "") {
			alert("작성자 입력");
			er_name.focus();
			return false;
		} else if (er_eamil.value == "") {
			alert("이메일 입력");
			er_eamil.focus();
			return false;
		} else if (er_title.value == "") {
			alert("제목 입력");
			er_title.focus();
			return false;
		} else if (er_content.value == "") {
			alert("내용 입력");
			er_content.focus();
			return false;
		}
		return true;
	}
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
<style>
body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}
</style>
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
						<a class="navbar-brand" href="/"><span>S</span>GW</a>
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

		<section id="featured" style="background-color: white">
			<!-- start slider -->

			<div class="container" style="padding-left: 840px;">
				<div class="row">
					<div class="col-lg-12">
						<div id="loginform" style="display: none;">
							<form action="/login" method="post"
								onsubmit="return logincheck(this);">
								<table style="float: left;">
									<tr>
										<td><input type="text" name="m_Email" placeholder="이메일">&nbsp;&nbsp;</td>
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
		</section>
		<section class="callaction" style="background-color: white";>
			<div class="container">
				<div class="row" style="margin-bottom: 120px";>
					<div class="col-lg-12">
						<div class="big-cta">
							<form action="/errorReportInsert" method="post"
								onsubmit="return reportCheck(this);">
								<div style="width: 800px; padding-left: 330px";>
									<table>



										<tr>
											<td colspan="2">
												<h4 style="font-family: malgun gothic";>서비스 이용 도중 발생한
													오류로</h4>
												<h3 style="font-family: malgun gothic";>
													<p style="color: #6799FF";>불편을 겪고 계신다면</p>
												</h3>
												<h3 style="font-family: malgun gothic";>
													<p style="color: #003399">신고해주세요</p>
												</h3>
											</td>
											<td colspan="4"><img src="resources/GC/error/그림1.png"
												class="img-responsive" alt="Responsive image"
												style="margin: 10px 0;"></td>
										</tr>
									</table>
								</div>

								<div class="error_wrap">

									<div class="form"
										style="border: 4px solid #68A4C4; padding: 10px 40px 30px; width: 570px; height: 300px;">
										<table class="error_list">

											<tr>
												<th style="color : black; background-color: white;">작성자</th>
												<td colspan="3"><input type="text" name="er_name"
													class="text" placeholder="작성자"></td>
											</tr>
											<tr>
												<th style="color : black; background-color: white;">이메일</th>
												<td colspan="3"><input type="text" name="er_email"
													class="text" placeholder="이메일"></td>
											</tr>
											<tr>
												<th style="color : black; background-color: white;">제목</th>
												<td colspan="3"><input type="text" name="er_title"
													class="text" placeholder="제목"></td>
											</tr>
											<tr>
												<th style="color : black; background-color: white;">내용</th>
												<td colspan="3"><textarea rows="5" cols="20"
														style="width: 354px; height: 137px; resize: none;"
														name="er_content"></textarea></td>
											</tr>

										</table>
									</div>
									<div class="button"
										style="width: 200px; padding-right: 10px; padding: 10px; text-align: left; float: left;">
										${admin}</div>
									<div class="button"
										style="width: 200px; padding-right: 10px; padding: 10px; text-align: right; float: right;">
										<input type="submit" value="신고하기">
									</div>

									<!-- 리스트 페이지 이동 -->

								</div>
							</form>

						</div>
					</div>
				</div>
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