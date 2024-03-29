<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//안쓰는거니 신경안써도 됨
	//String pagefile=request.getParameter("page");
	//if(pagefile==null) pagefile="includeTest1.jsp";				
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sonic Responsive Template</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
<!-- 
Sonic Template 
http://www.templatemo.com/preview/templatemo_394_sonic 
-->
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">
    
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="resources/home/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/home/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/home/css/templatemo_misc.css">
	<link rel="stylesheet" href="resources/home/css/templatemo_style.css">
	<!-- 다운 스크롤 test 시작-->
	<link href="resources/main/css/bootstrap.min.css" rel="stylesheet" />
	<link href="resources/main/css/fancybox/jquery.fancybox.css" rel="stylesheet">
	<link href="resources/main/css/jcarousel.css" rel="stylesheet" />
	<link href="resources/main/css/flexslider.css" rel="stylesheet" />
	<link href="resources/main/css/style.css" rel="stylesheet" />
	<!-- 다운 스크롤 test 끝-->
</head>
<body>
	
	<!-- This one in here is responsive menu for tablet and mobiles -->
    <div class="responsive-navigation visible-sm visible-xs">
        <a href="#" class="menu-toggle-btn">
            <i class="fa fa-bars fa-2x"></i>
        </a>
        <div class="navigation responsive-menu">
            <ul>
                <li class="home"><a href="/team_homeform"">홈</a></li>
	            <li class="about"><a href="/projectform">프로젝트</a></li>
	            <li class="services"><a href="/bworkform">업무</a></li>
	            <li class="portfolio"><a href="/boardForm">게시판</a></li>
	            <li class="contact"><a href="/memoform">메모</a></li>
	        	<li class="contact2"><a href="/calendarform">캘린더</a></li>	
	        	<li class="contact3"><a href="/messageSendform">쪽지</a></li>
	        	<li class="contact4"><a href="/dataCommform">자료실</a></li>
            </ul> <!-- /.main_menu -->
        </div> <!-- /.responsive_menu -->
    </div> <!-- /responsive_navigation -->

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo" style="background-color: #68A4C4">
			<a href="/"><h1>SGW</h1></a> <span>팀 홈</span>
		</div>  <!-- /.logo -->

		<div class="navigation">
	        <ul class="main-menu">
	            <li class="home"><a href="/team_homeform">홈</a></li>
	            <li class="about"><a href="/projectform">프로젝트</a></li>
	            <li class="services"><a href="/bworkform">업무</a></li>	            
	            <li class="portfolio"><a href="/boardForm">게시판</a></li>
	            <li class="contact"><a href="/memoform">메모</a></li>
	        	<li class="contact2"><a href="/calendarform">캘린더</a></li>	
	        	<li class="contact3"><a href="/messageSendform">쪽지</a></li>
	        	<li class="contact4"><a href="/dataCommList">자료실</a></li>
	        </ul>
		</div> <!-- /.navigation -->

	</div> <!-- /#main-sidebar -->
	<div id="main-content">
		<div id="templatemo">					
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">	
							${workUpdate}
						</div>
					</div>
				</div>
			</div>			
		</div>
		<!-- /#sTop -->
	</div>
	<!-- /#main-content -->
	<!-- JavaScripts -->
	<script src="resources/home/js/jquery-1.10.2.min.js"></script>
	<script src="resources/home/js/jquery.singlePageNav.js"></script>
	<script src="resources/home/js/jquery.flexslider.js"></script>
	<script src="resources/home/js/jquery.prettyPhoto.js"></script>
	<script src="resources/home/js/custom.js"></script>
	<script>
		$(document).ready(function(){
			$("a[data-gal^='prettyPhoto']").prettyPhoto({hook: 'data-gal'});
		});

        function initialize() {
          var mapOptions = {
            zoom: 13,
            center: new google.maps.LatLng(40.7809919,-73.9665273)
          };

          var map = new google.maps.Map(document.getElementById('map-canvas'),
              mapOptions);
        }

        function loadScript() {
          var script = document.createElement('script');
          script.type = 'text/javascript';
          script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' +
              'callback=initialize';
          document.body.appendChild(script);
        }

        window.onload = loadScript;
    </script>
<!-- templatemo 394 sonic -->
</body>
</html>
