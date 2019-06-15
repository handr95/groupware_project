
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

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
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
	function joincheck2() {
		var m_Email = document.getElementsByName("m_Email")[1];
		var m_Nickname = document.getElementsByName("m_Nickname")[0];
		var m_Name = document.getElementsByName("m_Name")[0];
		var m_PWD = document.getElementsByName("m_PWD")[1];
		var m_PWD2 = document.getElementsByName("m_PWD2")[0];
		var joincheck = document.getElementsByName("joincheck")[0];
		if (m_Email.value == "") {
			alert("이메일 입력");
			m_Email.focus();
			return false;
		} else if (m_Nickname.value == "") {
			alert("닉네임 입력");
			m_Nickname.focus();
			return false;
		} else if (m_Name.value == "") {
			alert("비밀번호 입력");
			m_Name.focus();
			return false;
		} else if (m_PWD.value == "") {
			alert("비밀번호 입력");
			m_PWD.focus();
			return false;
		} else if (m_PWD.value != m_PWD2.value) {
			alert("비밀번호 미일치");
			m_PWD.value = ""
			m_PWD2.value = ""
			m_PWD.focus();
			return false;
		} else if (joincheck.checked == false) {
			alert("약관에 동의해주세요");
			joincheck.focus();
			
			return false;
		}
		
		$("#able").prop("disabled", false);
		
		return true;
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

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: #F361DC;
}

a:hover {
	text-decoration: none;
	color: orange;
}

a:active {
	text-decoration: none;
	color: #F361DC;
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
</style>
<style type="text/css">
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: #F361DC;
}

a:hover {
	text-decoration: none;
	color: orange;
}

a:active {
	text-decoration: none;
	color: #F361DC;
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

.jointable td {
	padding-bottom: 3px;
}
</style>

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

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript">
	function idcheck() {//
		alert($('#m_Email').val());
		$.ajax({
			type : 'post',
			url : 'emailcheck',
			data : ({
				m_Email : $('#m_Email').val()
			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
			success : function(data) {//성공하면
				$('#message').html(data);
			}
		});
	}
	function nicknamecheck() {//		 

		alert($('#m_Nickname').val());
		$.ajax({
			type : 'post',
			url : 'nicknamecheck',
			data : ({
				m_Nickname : $('#m_Nickname').val()
			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
			success : function(data) {//성공하면
				$('#message2').html(data);
			}
		});
	}

	function alarm() {
		$("#confirm").attr("disabled", "disabled");
		$.ajax({
			type : 'post',
			url : 'emailConfirm',
			data : ({
				m_Email : $('#m_Email').val()
			}),
			
			success : function(data) {
				alert("이메일로 인증메일을 보냈습니다.");
				
			}
		});
	}

	function buttonable(m_Email) {//		 
		//$("#able").attr("disabled", "disabled");
		$.ajax({
			type : 'post',
			url : 'logincheck',
			data : ({
				m_Email : m_Email
			}),
			success : function(data) {//성공하면
				$('#message').html(data);
			}
		});
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

	function layer_close() {
		alert("메일로 임시 비밀번호가 발송되었습니다.");
		layerWindow.removeClass('open');
	}
</script>

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
			<div class="container" style="padding-left: 840px">
				<div class="row">
					<div class="col-lg-12"></div>

				</div>
			</div>


		</section>


		<p>
			<strong> 회원 가입</strong>
		</p>



		<section id="content">

			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-3">
								<!-- col-lg-숫자:숫자에 따라서 행의 길이가 적용됨 -->
							</div>





							<div id="articleView_layer">
								<div class="bg_layer"></div>
								<div id="pwdajax"></div>
							</div>




							<div class="col-lg-3"
								style="padding-left: 80px; padding-right: 0px; width: 550px; height: 300px;">
								<div class="box">
									<form action="/joinInsert" method="post"
										onsubmit="return joincheck2(this);">
										<table class="jointable">
											<colgroup>
												<col width="30%">
												<col width="70%">
											</colgroup>

											<tr>
												<td>이메일:</td>
												<td><input type="text" name="m_Email" id="m_Email">&nbsp;&nbsp;<input
													type="button" value="중복확인" onclick="idcheck()"></td>
											</tr>
											<tr>
												<td colspan="2"><div id="message"></div></td>
											</tr>
											<tr>
												<td>닉네임:</td>
												<td><input type="text" name="m_Nickname"
													id="m_Nickname">&nbsp;&nbsp;<input type="button"
													value="중복확인" onclick="nicknamecheck()"></td>
											</tr>
											<tr>
												<td colspan="2"><div id="message2"></div></td>
											</tr>
											<tr>
												<td style="padding-bottom: 5px">이름:</td>
												<td style="padding-bottom: 5px"><input type="text"
													name="m_Name"></td>
											</tr>
											<tr>
												<td style="padding-bottom: 5px">비밀번호:</td>
												<td style="padding-bottom: 5px"><input type="password"
													name="m_PWD"></td>
											</tr>
											<tr>
												<td style="padding-bottom: 5px">비밀번호 확인:</td>
												<td style="padding-bottom: 5px"><input type="password"
													name="m_PWD2"></td>
											</tr>
											<tr>
												<td colspan="2"><input type="checkbox" name="joincheck"
													value="joincheck" style="margin-bottom: 10px"><a
													href="#" onclick="display('provision')">개인정보취급방침,서비스이용약관</a>을
													읽어 보았으며, 내용에 동의합니다.<br />
													<div id="provision" style="display: none;">
														<textarea rows="10" cols="20" style="overflow: auto">
							이용낙관 내용
							</textarea>
													</div></td>
											</tr>
											<tr>
												<td></td>
												<td><input type="submit" id="able"	onclick="buttonable(m_Email)" value="가입하기"
													style="float: right; margin-bottom: 0px; margin-top: 30px; margin-right: 200px;"></td>


											</tr>
										</table>
									</form>
								</div>
							</div>
							<div id="articleView_layer">
								<div class="bg_layer"></div>
								<div id="view_layer"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- divider -->
			<div class="row" style="padding-top: 16px">
				<div class="col-lg-12"></div>
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
