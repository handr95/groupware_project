<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Moderna  - Bootstrap 3 flat corporate template</title>
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
<link href="resources/main/skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<script type="text/javascript">
	function display(id) {
		var element = document.getElementById(id);	
		element.style.display = element.style.display == 'none' ? 'block' : 'none';
	}
	function logincheck(){		
		var m_Email = document.getElementsByName("m_Email")[0];
		var m_PWD = document.getElementsByName("m_PWD")[0];				
		if(m_Email.value==""){
			alert("이메일 입력");
			m_Email.focus();
			return false;
		}else if(m_PWD.value==""){
			alert("비밀번호 입력");
			m_PWD.focus();
			return false;
		}	
		return true;
	}
	function logoutcheck(){		
		alert("로그아웃");	
		return true;
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
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/"><span>S</span>gw</a>
                </div>  
                <div id="loginform"  style="display: none; ">
					<form action="/login" method="post" onsubmit="return logincheck(this);">
						<table style="float:left;">
							<tr>
								<td><input type="text" name="m_Email" placeholder="이메일"></td>
								<td><input type="password" name="m_PWD" placeholder="비밀번호"></td>
							</tr>
							<tr>
								<td><a>비밀번호 찾기</a></td>
								<td><input type="submit" value="로그인"></td>
							</tr>
						</table>
					</form>
				</div>              
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="dropdown" class="active">
                            <a href="index.html" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">서비스 소개 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/storyform">스토리</a></li>
                                <li><a href="/serviceform">서비스 소개</a></li>
                            </ul>
                        </li>
                                   
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">고객센터 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                               <li><a href="/noticeform">공지사항</a></li>
                                <li><a href="/questform">자주묻는 질문</a></li>
								<li><a href="/errorReportInsertform">서비스 오류 신고</a></li>
                            </ul>
                        </li>
                        <%if(request.getSession().getAttribute("sessionmid")!=null){ %>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">마이 페이지 <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/baseInfoPage">My정보</a></li>
                                <li><a href="/alramMgr_View">서비스 관리</a></li>
								<li><a href="/teamMemberListPage">나의 팀 관리</a></li>
                            </ul>
                        </li>
                       <li class="dropdown">
								<a href="/logOut">로그아웃</a>
							</li>
                        <%} else{ %>                        
                        <li><a href="#" onclick="display('loginform')">로그인</a></li>
                        <li><a href="/joinform">회원가입</a></li>
                        <%} %>
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
	<section class="callaction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="big-cta">
					<div class="cta-text">
						<h2><span>SGW</span> 개인 및 팀 일정관리</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	
	<div class="container" >
		<div class="row">
			<div class="col-lg-12">
				<div class="row">	
					<div class="col-lg-3"><!-- col-lg-숫자:숫자에 따라서 행의 길이가 적용됨 -->
					</div>			
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>개인</h4>
								<div class="icon">
								<i class="fa fa-edit fa-3x"></i>
								</div>
								<p>
								 개인 일정 관리 및 업무 관리
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="testhome">바로가기</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="box">
							<div class="box-gray aligncenter">
								<h4>팀</h4>
								<div class="icon">
								<i class="fa fa-code fa-3x"></i>
								</div>
								<p>
								 팀 일정 관리 및 프로젝트 관리
								</p>
									
							</div>
							<div class="box-bottom">
								<a href="testteamhome">바로가기</a>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
					</div>
				</div>
			</div>
		</div>
		<!-- divider -->
		<div class="row">
			<div class="col-lg-12">
				<div class="solidline">
				</div>
			</div>
		</div>
		<!-- end divider -->
		<!-- Portfolio Projects -->
		<div class="row">
			<div class="col-lg-12">
				<h4 class="heading">최근 업데이트</h4>
				<div class="row">
					<section id="projects">
					<ul id="thumbs" class="portfolio">
						<!-- Item Project and Filter Name -->
						<li class="col-lg-3 design" data-id="id-0" data-type="web">
						<p><a href="#">1월5일 일정 등록</a></p>
						<p><a href="#">1월2일 일정 수정</a></p>
						<p><a href="#">12월 26일 업무 종료</a></p>
						<p><a href="#">12월 24일 업무 수정</a></p>
						<p><a href="#">12월 22일 프로젝트 시작</a></p>
						<div class="item-thumbs">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Work 1" href="main/img/works/1.jpg">
						<span class="overlay-img"></span>
						<span class="overlay-img-thumb font-icon-plus"></span>
						</a>
						<!-- Thumb Image and Description -->
						</div>
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 design" data-id="id-1" data-type="icon">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Work 2" href="main/img/works/2.jpg">
						<span class="overlay-img"></span>
						<span class="overlay-img-thumb font-icon-plus"></span>
						</a>
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 photography" data-id="id-2" data-type="illustrator">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Work 3" href="main/img/works/3.jpg">
						<span class="overlay-img"></span>
						<span class="overlay-img-thumb font-icon-plus"></span>
						</a>
						<!-- Thumb Image and Description -->
						</li>
						<!-- End Item Project -->
						<!-- Item Project and Filter Name -->
						<li class="item-thumbs col-lg-3 photography" data-id="id-2" data-type="illustrator">
						<!-- Fancybox - Gallery Enabled - Title - Full Image -->
						<a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Work 4" href="main/img/works/4.jpg">
						<span class="overlay-img"></span>
						<span class="overlay-img-thumb font-icon-plus"></span>
						</a>
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