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


<script type="text/javascript">
	function display(id) {
		var element = document.getElementById(id);
		var element1 = document.getElementById('content1');
		var element2 = document.getElementById('content2');
		var element3 = document.getElementById('content3');
		var element4 = document.getElementById('content4');
		var element5 = document.getElementById('content5');
		var element6 = document.getElementById('content6');
		var element7 = document.getElementById('content7');
	
		if (element == element1) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
		} else if (element == element2) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element1.style.display = 'none';
			element3.style.display = 'none';
			element4.style.display = 'none';
		} else if (element == element3) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element1.style.display = 'none';
			element2.style.display = 'none';
			element4.style.display = 'none';
		} else if (element == element4) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element1.style.display = 'none';
			element2.style.display = 'none';
			element3.style.display = 'none';
		} else if (element == element5) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element6.style.display = 'none';
			element7.style.display = 'none';
			
		} else if (element == element6) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element5.style.display = 'none';
			element7.style.display = 'none';
			
		} else if (element == element7) {
			element.style.display = element.style.display == 'none' ? 'block'
					: 'none';
			element5.style.display = 'none';
			element6.style.display = 'none';
			
		}
	}
	
</script>

<style>
body {
	font-family: "malgun gothic";
	font-size: 1.2em;
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
article.tabs section, article.tabs section h2 {
	-webkit-transition: all 500ms ease;
	-moz-transition: all 500ms ease;
	-ms-transition: all 500ms ease;
	-o-transition: all 500ms ease;
	transition: all 500ms ease;
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
									<li><a href="/seriveceform">서비스 소개</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">고객센터 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">공지사항</a></li>
									<li><a href="components.html">자주묻는 질문</a></li>
									<li><a href="#">서비스 오류 신고</a></li>
								</ul></li>
							<%
								if (request.getSession().getAttribute("mid") != null) {
							%>
							<li class="dropdown"><a href="#" class="dropdown-toggle "
								data-toggle="dropdown" data-hover="dropdown" data-delay="0"
								data-close-others="false">마이 페이지 <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/baseInfoPage">My정보</a></li>
									<li><a href="/alramMgr_View">서비스 관리</a></li>
									<li><a href="/teamMemberListPage">나의 팀 관리</a></li>
								</ul></li>
							<%
								} else {
							%>
							<li><a href="#">로그인</a></li>
							<li><a href="#">회원가입</a></li>
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
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<h3>
							<strong>기능소개</strong>
						</h3>
						<article class="tabs">
							<section id="tab1"
								style="padding-top: 25px; padding-bottom: 5px; padding-left: 25px; height: 320px; width: 840px; float: left;">
								<h2>
									<a href="#tab1"><strong>개인용</strong></a>
								</h2>
								<ul class="nav nav-tabs">
									<button class="btn" id="btn" type="submit">
										<img class="btn-img" src="resources/main/img/main/add199.png"
											onclick="display('content1');">
									</button>
									<button class="btn" id="btn" type="submit">
										<img class="btn-img"
											src="resources/main/img/main/calendar68.png"
											onclick="display('content2');">

									</button>
									<button class="btn" id="btn" type="submit">
										<img class="btn-img" src="resources/main/img/main/edit26.png"
											onclick="display('content3');">

									</button>
									<button class="btn" id="btn" type="submit">
										<img class="btn-img"
											src="resources/main/img/main/black218.png"
											onclick="display('content4');">

									</button>
									<div id="content1" style="display: block;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <strong>이웃관리</strong><br>
										<br> <strong>누구에게 추천?</strong> &nbsp; 개별적으로 보유한 인맥정보를 한
										곳에 모아 함께 관리하고 싶으신 분 <br> <strong>기능 소개</strong> &nbsp;
										&nbsp; &nbsp; &nbsp; - 이메일 주소를 통해 친구맺기 및 친구 끊기 신청을 할 수 있습니다.<br>
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp;
									</div>
									<div id="content2" style="display: none;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <strong>
											일정공유 </strong><br> <br> <strong>누구에게 추천?</strong> &nbsp;
										개인일정 뿐만 아니라, 팀원 전체 일정이 함꼐 보여, 일정조정에 유리합니다.<br> <strong>기능
											소개</strong> &nbsp; &nbsp; &nbsp; &nbsp; - 반복 일정 등록으로, 정기적인 일정에 대한 관리가
										간편합니다.<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 한 번의 등록으로 여러 팀에 함께 공유할 수
										있어, 별도로 관리해야 하는 수고를 덜어줍니다.<br> &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 중요한
										이벤트는 메모로 팀 전체가 함께 공유할 수 있습니다.<br>

									</div>
									<div id="content3" style="display: none;">
										&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; <strong> 메모 </strong> <br> <br> <strong>누구에게
											추천?</strong> &nbsp; 할 일이 있을 때마다 종이 혹은 메모장에 기록하셔서, 제대로 관리하지 못하시는 분<br>
										<strong>기능 소개</strong> &nbsp; &nbsp; &nbsp; &nbsp; - 간단히
										처리해야하는 것들이나 메모 등을 손쉽게 기록할 수 있습니다 <br>
									</div>
									<div id="content4" style="display: none;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp;&nbsp; &nbsp; &nbsp; <strong> 쪽지 </strong> <br> <br>
										<strong>누구에게 추천?</strong> &nbsp; 진행하는 업무에 대한 변경사항을 실시간으로 편하게
										전달받도 싶으신 분<br> <strong>기능 소개</strong> &nbsp; &nbsp;
										&nbsp; &nbsp; - 업무, 프로젝트, 보고서 등 진행하는 업무의 변경사항을 실시간으로 전달받을 수
										있습니다. <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 주고받은 모든 쪽지와 보낸 문자는 항시 저장되어
										보관됩니다.
									</div>
								</ul>

								<p class="tabnav">
									<a href="#tab2"></a>
								</p>
							</section>

							<section id="tab2"
								style="padding-top: 25px; padding-bottom: 5px; padding-left: 25px; height: 320px; width: 840px; float: left;">
								<h2>
									<a href="#tab2"><strong>팀용</strong></a>
								</h2>
								<ul class="nav nav-tabs">
									<button class="btn" id="btn" type="submit">
										<img class="btn-img" src="resources/main/img/main/file98.png"
											onclick="display('content5');">
									</button>
									<button class="btn" id="btn" type="submit">
										<img class="btn-img"
											src="resources/main/img/main/calendar68.png"
											onclick="display('content6');">

									</button>
									<button class="btn" id="btn" type="submit">
										<img class="btn-img" src="resources/main/img/main/edit26.png"
											onclick="display('content7');">

									</button>
									
									<div id="content5" style="display: block;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <strong>프로젝트</strong><br>
										<br> <strong>누구에게 추천?</strong> &nbsp; 보다 간편한 프로젝트 관리 툴이
										필요하신 분 <br> <strong>기능 소개</strong> &nbsp; &nbsp; &nbsp;
										&nbsp; - 진행하는 프로젝트에 대한 전체적인 설계가 가능하며, 한 눈에 해야 할 일을 순차적으로 확인할 수
										있습니다. <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 보다 심플한 설계구조로 누구나 쉽게 시작이
										가능합니다 <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 프로젝트 작업을 업무로 연결하여 심층적인 업무
										진행이 이루어집니다.
									</div>
									<div id="content6" style="display: none;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <strong>
											공유게시 </strong><br> <br> <strong>누구에게 추천?</strong> &nbsp; 팀
										내와 공유해야 할 게시판이 필요하신 분.<br> <strong>기능 소개</strong> &nbsp;
										&nbsp; &nbsp; &nbsp; - 팀 내에서 공유해야할 중요한 글을 팀 공지 기능을 통해 쉽게 확인할 수
										있습니다. <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;- 게시글 하나하나에 대한 의견교환이 가능하기
										때문에, 의견이 필요한 중요건에 대한 처리가 보다 용이해집니다. <br>

									</div>
									<div id="content7" style="display: none;">
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
										 <strong> 자료실 </strong> <br> <br>
										<strong>누구에게 추천?</strong> &nbsp; 팀 내와 공유해야 할 자료실이 필요하신 분<br>
										<strong>기능 소개</strong> &nbsp; &nbsp; &nbsp; &nbsp; - 나의 파일 뿐만
										아니라 팀 내의 모든 파일을 함께 공유할 수 있어, 자료 공유에 탁월합니다 <br> &nbsp;
										&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp;
									</div>

								</ul>
							</section>
						</article>


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
					</div>
				</div>
			</div>


		</section>
		<div style="height: 110px;"></div>

		<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading">Get in touch with us</h5>
							<address>
								<strong>Moderna company Inc</strong><br> Modernbuilding
								suite V124, AB 01<br> Someplace 16425 Earth
							</address>
							<p>
								<i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
								<i class="icon-envelope-alt"></i> email@domainname.com
							</p>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading">Pages</h5>
							<ul class="link-list">
								<li><a href="#">Press release</a></li>
								<li><a href="#">Terms and conditions</a></li>
								<li><a href="#">Privacy policy</a></li>
								<li><a href="#">Career center</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="widget">
							<h5 class="widgetheading">Latest posts</h5>
							<ul class="link-list">
								<li><a href="#">Lorem ipsum dolor sit amet, consectetur
										adipiscing elit.</a></li>
								<li><a href="#">Pellentesque et pulvinar enim. Quisque
										at tempor ligula</a></li>
								<li><a href="#">Natus error sit voluptatem accusantium
										doloremque</a></li>
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
			<div id="sub-footer">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="copyright">
								<p>
									<span>&copy; Moderna 2014 All right reserved. By </span><a
										href="http://bootstraptaste.com" target="_blank">Bootstraptaste</a>
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