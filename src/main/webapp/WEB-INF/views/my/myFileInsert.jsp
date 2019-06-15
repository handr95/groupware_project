<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//안쓰는거니 신경안써도 됨
	//String pagefile=request.getParameter("page");
	//if(pagefile==null) pagefile="includeTest1.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<title>my home</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- 
Sonic Template 
http://www.templatemo.com/preview/templatemo_394_sonic 
-->
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1">
<script type="text/javascript">
	function aaa() {

	}
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/home/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/home/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/home/css/templatemo_misc.css">
<link rel="stylesheet" href="resources/home/css/templatemo_style.css">

<!-- Theme skin -->
<link href="resources/main/skins/default.css" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<link rel="stylesheet" href="resources/message/css/tab_style.css">

<script type="text/javascript">
	function display(id) {
		var element = document.getElementById(id);
		element.style.display = element.style.display == 'none' ? 'block'
				: 'none';
	}
</script>

</head>
<body>

	<!-- This one in here is responsive menu for tablet and mobiles -->
	<div class="responsive-navigation visible-sm visible-xs">
		<a href="#" class="menu-toggle-btn"> <i class="fa fa-bars fa-2x"></i>
		</a>
		<div class="navigation responsive-menu">
			<ul>
				<li class="home"><a href="/my_homeform">홈</a></li>
				<li class="about"><a href="/boardForm">게시판</a></li>
				<li class="services"><a href="/memoform">메모</a></li>
				<li class="portfolio"><a href="/calendarform">캘린더</a></li>
				<li class="contact"><a href="/addressform">주소록</a></li>
				<li class="contact2"><a href="/messageSendform">쪽지</a></li>
				<li class="contact4"><a href="/dataCommform">자료실</a></li>
			</ul>
			<!-- /.main_menu -->
			<!-- /.main_menu -->
		</div>
		<!-- /.responsive_menu -->
	</div>
	<!-- /responsive_navigation -->

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo" style="background-color: #68A4C4">
			<a href="/"><h1>SGW</h1></a> <span>개인 홈</span>
		</div>
		<!-- /.logo -->

		<div class="navigation">
			<ul class="main-menu">
				<li class="home"><a href="/my_homeform">홈</a></li>
				<li class="about"><a href="/boardForm">게시판</a></li>
				<li class="services"><a href="/memoform">메모</a></li>
				<li class="portfolio"><a href="/calendarform">캘린더</a></li>
				<li class="contact"><a href="/addressform">주소록</a></li>
				<li class="contact2"><a href="/messageSendform">쪽지</a></li>
				<li class="contact4"><a href="/dataCommform">자료실</a></li>
			</ul>
		</div>
		<!-- /.navigation -->

	</div>
	<!-- /#main-sidebar -->

	<div id="main-content">
		<div id="templatemo">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12" style="height: 500px">
							
							<table style="width: inherit; height: inherit;">
								<tr>
									<td><a href="#">sgw</a></td>

								</tr>
								<tr>

									<td>${dataInsert}</td>
								</tr>

							</table>
							
					</div>

				</div>
			</div>
		</div>
		<!-- /#sTop -->
	</div>
	<!-- /#main-content -->

	<!-- JavaScripts -->
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="resources/message/js/checkbox.js"></script>
	<script src="resources/home/js/jquery-1.10.2.min.js"></script>
	<script src="resources/home/js/jquery.singlePageNav.js"></script>
	<script src="resources/home/js/jquery.flexslider.js"></script>
	<script src="resources/home/js/jquery.prettyPhoto.js"></script>
	<script src="resources/home/js/custom.js"></script>
	<script>
		$(document).ready(function() {
			$("a[data-gal^='prettyPhoto']").prettyPhoto({
				hook : 'data-gal'
			});
		});

		function initialize() {
			var mapOptions = {
				zoom : 13,
				center : new google.maps.LatLng(40.7809919, -73.9665273)
			};

			var map = new google.maps.Map(
					document.getElementById('map-canvas'), mapOptions);
		}

		function loadScript() {
			var script = document.createElement('script');
			script.type = 'text/javascript';
			script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&'
					+ 'callback=initialize';
			document.body.appendChild(script);
		}

		window.onload = loadScript;
	</script>
	<!-- templatemo 394 sonic -->
</body>

</html>
