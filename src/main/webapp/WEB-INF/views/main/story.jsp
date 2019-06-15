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


<style>
.container1 {
	padding-left: 140px;
	padding-right: 140px;
	padding-top: 40px;
}

body {
	font-family: "malgun gothic";
	font-size: 1.3em;
}

a {
	font-family: "malgun gothic";
	font-size: 1.0em;
}

p {
	font-family: "malgun gothic";
	font-size: 1.6em;
}

article.tabs {
	position: relative;
	display: block;
	width: 40em;
	height: 15em;
	margin-top: 50px;
}

article.tabs section {
	position: absolute;
	display: block;
	top: 1.8em;
	left: 0;
	height: 12em;
	padding: 10px 20px;
	background-color: #ddd;
	border-radius: 5px;
	z-index: 0;
	width: 37em;
}

article.tabs section:first-child {
	z-index: 1;
}

/* =============탭 메뉴 스타일 (S) =================*/
article.tabs section h2 {
	position: absolute;
	font-size: 1em;
	font-weight: normal;
	width: 120px;
	height: 1.8em;
	top: -1.8em;
	left: 0px;
	padding: 0;
	margin: 0;
	color: #ddd;
	background-color: #999;
	border-radius: 5px 5px 0 0;
}

/* Tab2(두번째 section의 h2) 메뉴의 위치를 지정*/
article.tabs section:nth-child(2) h2 {
	left: 121px; /*첫번째 메뉴의 leff(10px) + width(120px) + 여백 */
}

article.tabs section h2 a {
	display: block;
	width: 100%;
	line-height: 1.8em;
	text-align: center;
	text-decoration: none;
	color: inherit; /* 부모요소 스타일에 따라 변함*/
	outline: 0 none;
}

/* =============탭 메뉴 스타일 (E) =================*/

/* 클릭했을때 해당 section 영역 스타일 
           , z-index를 수정함으로써 위로 보이게 함*/
article.tabs section:target, article.tabs section:target h2 {
	color: black;
	background-color: #ddd;
	z-index: 2;
}

/* 전환효과 */
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
</style>

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
		<section id="featured">
			<!-- start slider -->
			<div class="container" style="padding-left: 840px;">
				<div id="articleView_layer">
					<div class="bg_layer"></div>
					<div id="pwdajax"></div>
				</div>

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
			<div class="container1">

				<p>
					<img src="resources/main/img/main/laptop112.png"
						class="img-responsive" alt="Responsive image" align="left"
						style="padding-right: 10px";><em><strong>prologue</strong></em>
				</p>
				<br /> 여러분은 하루에 몇 가지 업무를, 몇명의 사람들과 진행하시나요?<br> 쌓여만 가는 다양한 업무를
				효과적으로 진행하지 못하면, 시간 관리가 허술하게 되고, 이는 업무의 지연을 가져오게 됩니다.<br> 그러므로
				올바른 "업무관리"는 팀원에게도, 또한 여러 명의 팀원 업무를 함께 관리해야 하는 팀장에게 매우 큰 이슈입니다.<br>
				그렇다면, 더욱 효과적인 업무관리 방법은 무엇일까요? SGW는 이러한 궁금증/필요에 의해 만들어졌습니다.<br>
				업무 시작부터 완료될 때까지 업무진행에 필요한 모든 기능을 제공하여, 더욱 효과적인 업무 관리가 가능합니다.<br>
				머리로만 기억하는 업무 진행상황에 의존하지 마시고, 간단히 기록하고, 전달하여 본인의 업무관리 능력을 한 층 높여보시기
				바랍니다.
				<article class="tabs">
					<section id="tab1"
						style="padding-top: 25px; padding-bottom: 5px; padding-left: 25px; height: 200px; width: 840px; float: left;">
						<h2>
							<a href="#tab1"><strong>개인을 위한 SGW</strong></a>
						</h2>
						SGW에서는 간단한 일이라도 기한을 정해 용이하기 관리할 수 있고, 놓치기 쉬운 업무 상황을 보다 쉽게 파악할 수
						있습니다.<br> 특정 업무와 관련된 보고서와 자료가 순차적으로 정리되어 있어, 차후 필요시 업무접근이
						쉽습니다.<br> 본인의 업무와 일정을 다른 공료와 공유하고, 다른 동료의 업무와 일정도 참고가 가능하여
						협업을 위한 기본적 틀을 제공합니다.<br> 특히, 피드백 기능은 이러한 동료와의 협업을 부담없이 진행할 수
						있도록 SGW 곳곳에 묻어져 있는 고영양 기능입니다.

						<p class="tabnav">
							<a href="#tab2"> </a>
						</p>
					</section>

					<section id="tab2"
						style="padding-top: 25px; padding-bottom: 5px; padding-left: 25px; height: 200px; width: 840px; float: left;">
						<h2>
							<a href="#tab2"><strong>팀을 위한 SGW</strong></a>
						</h2>

						SGW에서는 팀원들의 업무진행 상황을 보다 쉽게 파악할 수 있습니다.<br> 변경사항이 있을 때 마다 실시간
						알림으로 즉각적인 확인이 가능하며, 팀원이 보고한 내용이 코멘트로 피드백을 달 수 있습니다.<br> 이 모든
						것이 실시간으로 진행되기 때문에 스피드한 팀 관리가 가능해져 팀 업무 효율성을 높여주는 계기를 만들어 냅니다.<br>
						더불어 팀원들의 업무가 팀 자산으로써 한 곳에 공유되고 저장되기 되어 별도의 서비스가 필요없이 단 하나로 관리가
						가능합니다.

					</section>
				</article>

			</div>

			<!-- Slider -->
			<!-- 
        <div id="main-slider" class="flexslider">
            <ul class="slides">
              <li>
                <img src="main/simg/lides/1.jpg" alt="" />
                <div class="flex-caption">
                    <h3>Modern Design</h3> 
					<p>Duis fermentum auctor ligula ac malesuada. Mauris et metus odio, in pulvinar urna</p> 
					<a href="#" class="btn btn-theme">Learn More</a>
                </div>
              </li>
              <li>
                <img src="main/img/slides/2.jpg" alt="" />
                <div class="flex-caption">
                    <h3>Fully Responsive</h3> 
					<p>Sodales neque vitae justo sollicitudin aliquet sit amet diam curabitur sed fermentum.</p> 
					<a href="#" class="btn btn-theme">Learn More</a>
                </div>
              </li>
              <li>
                <img src="main/img/slides/3.jpg" alt="" />
                <div class="flex-caption">
                    <h3>Clean & Fast</h3> 
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit donec mer lacinia.</p> 
					<a href="#" class="btn btn-theme">Learn More</a>
                </div>
              </li>
            </ul>
        </div>
         -->
			<!-- end slider -->


		</section>
		<div style="height: 82px;"></div>

		<footer style=" margin-top: 50px;">
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