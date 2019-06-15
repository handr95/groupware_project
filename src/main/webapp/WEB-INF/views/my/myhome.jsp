<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
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
<style type="text/css">
	a:link		{text-decoration:none;}
	a:visited	{text-decoration:none;color:#F361DC;}
	a:hover	{text-decoration:none;color:orange;}
	a:active	{text-decoration:none;color:#F361DC;}
	
	/* table, td, th{border:1px solid gray;} */
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
	#detailhash { position:absolute;top:25%;left:40%;
	  	margin:1px 0 0 1px;
	   	padding:28px 28px 0 28px;border:3px solid yellow;
	 	   	background:#fff;font-size:12px;
	  	color:#767676;line-height:normal;white-space:normal}
</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function findhashform(code){//	
		 $('#articleView_layer').addClass('open');
		 $.ajax({ type:'post',
			   url:'findHashDetailform',
			   data: ({hs_Title:hs_Title}),
			   success:function(data){
				 $('#findHashDetail').html(data);				 
			}		
		});
	}

	$(function(){
		 var layerWindow = $('#articleView_layer');
		 // ESC Event
		 $(document).keydown(function(event){
		  		if(event.keyCode != 27) return true;
		  		if (layerWindow.hasClass('open')) {
		   			layerWindow.removeClass('open');}
		  		return false;
		 		});

		 // Hide Window
		 layerWindow.find('.bg_layer').mousedown(function(event){
		 			layerWindow.removeClass('open');
		  			return false;
		 		});
	});
</script>
	<!-- ajax시작 -->
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
function hashfind() 
{ 	
	$.ajax({ type:'post',
		   url:'findHashDetailform',
		   data: ({hs_Title:$('#mp_Title').val()
		   }),
		   success:function(data){
			 $('#findHashDetail').html(data);
			 //$("#mp_Title").val("");
		}
	
	});
}

function hashfind2(hs_Title) 
{ 	
	$.ajax({ type:'post',
		   url:'findHashDetailform',
		   data: ({
				hs_Title:hs_Title
		   }),
		   success:function(data){
			 $('#articleView_layer').removeClass('open');	
			 $('#findHashDetail').html(data);
			 $("#mp_Title").val(hs_Title);
		}
	
	});
}


function detailhash(mp_Code) 
{
	$('#articleView_layer').addClass('open');
	$.ajax({ type:'post',
		   url:'hashBoardDetail',
		   data: ({
			   mp_Code:mp_Code
		   }),
		   success:function(data){
			 $('#detailhash').html(data);
			   	
		}
	
	});
}
</script>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/home/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/home/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/home/css/templatemo_misc.css">
<link rel="stylesheet" href="resources/home/css/templatemo_style.css">
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
				<li class="services"><a href="/memoform">방명록</a></li>
				<li class="portfolio"><a href="/calendarform">캘린더</a></li>
				<li class="contact"><a href="/addressform">주소록</a></li>
				<li class="contact2"><a href="/messageSendform">쪽지</a></li>
				<li class="contact4"><a href="/dataCommform">자료실</a></li>	        	
            </ul> <!-- /.main_menu -->
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
				<li class="services"><a href="/memoform">방명록</a></li>
				<li class="portfolio"><a href="/calendarform" onclick="window.open(this.href, '_blank', 'width=1100,height=1000,toolbars=no,scrollbars=no'); return false;">캘린더</a></li>
				<li class="contact"><a href="/addressform">주소록</a></li>
				<li class="contact2"><a href="/messageSendform">쪽지</a></li>
				<li class="contact4"><a href="/dataCommform">자료실</a></li>
			</ul>
		</div>
		<!-- /.navigation -->

	</div>
	<!-- /#main-sidebar -->
			<div id="articleView_layer" >
					   <div class="bg_layer"></div>
					   <div id="detailhash"></div>
			</div>	
	<div id="main-content">
		<div id="templatemo">					
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">	
							일정관리<br/>${myTodayCal1}<hr/>${myTodayCal2}<hr/>${myTodayCal3}<br/><br/><br/>
							
							<input type="text" id="mp_Title"/>
							<button type="button" onclick="hashfind()">해시찾기</button>
							<div id="findHashDetail"></div>
							
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
