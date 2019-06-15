<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<link href="resources/main/css/fancybox/jquery.fancybox.css" rel="stylesheet">
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
<div id="wrapper">

	<!-- start header -->
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                  <a class="navbar-brand" href="/"><span>S</span>GW</a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                         <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">My정보 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/baseInfoPage">기본정보</a></li>
                                <li><a href="/UpdatePwdPage">비밀번호 변경</a></li>
                                <li><a href="/memberDropPage">회원 탈퇴</a></li>
                                <li><a href="/myPostList">게시판 관리</a></li>
                                <li><a href="/MyMemoHamList">방명록 관리</a></li>
                            </ul>
                        </li>
                        <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">서비스 관리 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/alramMgr_View">알림 관리</a></li>
                                <li><a href="/logOutOption">로그아웃 설정</a></li>
                            </ul>
                        </li>
                        <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">나의 팀 관리<b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/teamMemberListPage">멤버 목록</a></li>
                                <li><a href="/teamDrop">팀 삭제</a></li>
                                <li><a href="/teamInfoPage">팀 정보 관리</a></li>                                
                                <li><a href="/boardPostListform">게시판 관리</a></li>
                                <li><a href="/TeamMemoHamList">메모함 관리</a></li>
                                <li><a href="#">접속내역 관리</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
	</header>
	<!-- end header -->
	
	
	<section id="inner-headline" style="background-color: white">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
			</div>
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
					<h3>로그아웃 설정</h3>
				</ul>
				<div class="clearfix">
				</div>
				<div class="row">
					<section id="projects">
					<ul id="thumbs" class="portfolio">
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 design" data-id="id-0" data-type="web">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 design" data-id="id-1" data-type="icon">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 photography" data-id="id-2" data-type="graphic">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 design" data-id="id-0" data-type="web">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 photography" data-id="id-4" data-type="web">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 photography" data-id="id-5" data-type="icon">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<li class="item-thumbs col-lg-3 design" data-id="id-0" data-type="web">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 design" data-id="id-0" data-type="graphic">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<!-- Thumb Image and Description -->
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
	<!-- 밑에 지원도 됨  끝부분-->	
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