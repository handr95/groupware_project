<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//안쓰는거니 신경안써도 됨
	//String pagefile=request.getParameter("page");
	//if(pagefile==null) pagefile="includeTest1.jsp";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<!-- 
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/home/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/home/css/font-awesome.min.css"> 
<link rel="stylesheet" href="resources/home/css/templatemo_misc.css">
<link rel="stylesheet" href="resources/home/css/templatemo_style.css">
	<!-- 캘린더 -->

	<!-- 캘린더 -->
	<link rel="stylesheet" href="resources/css/core.css" type="text/css" />
	<link rel="stylesheet" href="resources/css/cupertino/jquery-ui.cupertino.css" type="text/css" />
		
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>
    <script src="resources/js/jMonthCalendar.js" type="text/javascript"></script>


	
	<style type="text/css" media="screen">
		#jMonthCalendar .Meeting { background-color: #DDFFFF;}
		#jMonthCalendar .Birthday { background-color: #DD00FF;}
		#jMonthCalendar #Event_3 { background-color:#0000FF; }
	</style>
	
	<style type="text/css">
		a:link		{text-decoration:none;}
		a:visited	{text-decoration:none;color:#F361DC;}
		a:hover	{text-decoration:none;color:orange;}
		a:active	{text-decoration:none;color:#F361DC;}
		
		/* table, td, th{border:1px solid gray;} */
		html, body{height:100%;margin:0}
		#articleView_layer1 {
			display:none;position:fixed;
			_position:absolute;top:0;left:0;
			z-index:10000;width:100%;height:100%}
		#articleView_layer2 {
			display:none;position:fixed;
			_position:absolute;top:0;left:0;
			z-index:10000;width:100%;height:100%}	
	  	#articleView_layer1.open {display:block;color:green} 
	/*   	  	.open {display:block;color:green} */
		#articleView_layer1 .bg_layer {
			   position:absolute;top:0;left:0;
			   width:100%;height:100%;background:#000;
			   opacity:.5;filter:alpha(opacity=50)}
		#articleView_layer2.open {display:block;color:green} 
	/*   	  	.open {display:block;color:green} */
		#articleView_layer2 .bg_layer {
			   position:absolute;top:0;left:0;
			   width:100%;height:100%;background:#000;
			   opacity:.5;filter:alpha(opacity=50)}
		#calUpdateform { position:absolute;top:25%;left:40%;
		  	margin:-150px 0 0 -194px;
		   	padding:28px 28px 0 28px;border:3px solid yellow;
		 	   	background:#fff;font-size:12px;
		  	color:#767676;line-height:normal;white-space:normal}
		#calInsertform { position:absolute;top:25%;left:40%;
		  	margin:-150px 0 0 -194px;
		   	padding:28px 28px 0 28px;border:3px solid yellow;
		 	   	background:#fff;font-size:12px;
		  	color:#767676;line-height:normal;white-space:normal}
	</style>
	
	<style type="text/css">
		table {
		width:100%;
		}
	</style>
	<script src="resources/home/js/date_picker.js"></script>
	<script type="text/javascript">
		function calUpdateform(code){//
			 
			 $('#articleView_layer1').addClass('open');
			 $.ajax({ type:'post',
				   url:'calUpdateform',
				   data: ({c_Code:code }),
				   success:function(data){
					 $('#calUpdateform').html(data);				 
				}		
			});
		}

		$(function(){
			 var layerWindow = $('#articleView_layer1');
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
		$(function(){
			 var layerWindow = $('#articleView_layer2');
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
	
    <script type="text/javascript">
        $().ready(function() {
        	
        	var options = {
				onMonthChanging: function(dateIn) {
					//this could be an Ajax call to the backend to get this months events
					//var events = [ 	{ "EventID": 7, "StartDate": new Date(2009, 1, 1), "Title": "10:00 pm - EventTitle1", "URL": "#", "Description": "This is a sample event description", "CssClass": "Birthday" },
					//				{ "EventID": 8, "StartDate": new Date(2009, 1, 2), "Title": "9:30 pm - this is a much longer title", "URL": "#", "Description": "This is a sample event description", "CssClass": "Meeting" }
					//];
					//$.jMonthCalendar.ReplaceEventCollection(events);
					return true;
				},
				onEventLinkClick: function(event) { 
					alert("event link click");
					return true; 
				},
				onEventBlockClick: function(event) { 
					alert("block clicked");
					calUpdateform(code)
					return true; 
				},
				onEventBlockOver: function(event) {
					//alert("event link click1");
					//글에 마우스 가져다 델때
					//alert(event.Title + " - " + event.Description);
					return true;
				},
				onEventBlockOut: function(event) {
					//글에 마우스 가져다 땔때
					//alert("event link click2");
					return true;
				},
				onDayLinkClick: function(date) { 
					//alert("event link click3");
					//날짜의 숫자 클릭시
					alert(date.toLocaleDateString());
					return true; 
				},
				onDayCellClick: function(date) { 
					//alert("event link click4");
					//날짜에 해당하는 박스 클릭시, 날짜의 숫자 클릭시
					alert(date.toLocaleDateString());
					return true; 
				}
			};
			
			
        	${ca}
						
			$.jMonthCalendar.Initialize(options, events);
			
			//var events = [ 	{ "EventID": 1, "StartDateTime": "new Date(2009, 5, 29)", "EndDateTime": "new Date(2009, 6, 3)", "Title": "10:00 pm - EventTitle1", "URL": "#", "Description": "This is a sample event description" },
			//				{ "EventID": 6, "StartDateTime": "new Date(2009, 5, 29)", "EndDateTime": "new Date(2009, 6, 3)", "Title": "10:00 pm - EventTitle6", "URL": "#", "Description": "This is a sample event description" },
			//				{ "EventID": 7, "StartDateTime": new Date(2009, 5, 12), "Title": "10:00 pm - EventTitle7", "URL": "#", "Description": "This is a sample event description" },
			//				{ "EventID": 3, "StartDateTime": "2015-02-11T12:30:00.0000000", "Title": "This is a much longer title", "URL": "#", "Description": "This is a sample event description", "CssClass": "Meeting" },
			//				{ "EventID": 4, "StartDateTime": new Date(2009, 5, 13), "Title": "This is a much longer title", "URL": "#", "Description": "This is a sample event description", "CssClass": "Meeting" },
			//				{ "EventID": 5, "StartDateTime": "2015-02-03", "EndDateTime": "2015-02-14", "Title": "This is a much longer title", "URL": "#", "Description": "This is a sample event description", "CssClass": "Meeting" }
			//];
			
		
			
			var extraEvents = [				];
			
			$("#Button").click(function() {					
				$.jMonthCalendar.AddEvents(extraEvents);
			});
			
			$("#ChangeMonth").click(function() {
				$.jMonthCalendar.ChangeMonth(new Date(2009, 7, 7));
			});
        });
        
        
        
        function calInsertform(){
        	$('#articleView_layer2').addClass('open');
        	$.ajax({
    			type : 'get',
    			url : 'calInsertform',
    			data : ({
    				
    			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
    			success : function(data) {//성공하면
    				
    				$('#calInsertform').html(data);
	   				
    			}
    		});
        	
        }
        
        
		function calInsert(){
			var layerWindow = $('#articleView_layer2');
			
			var c_Title2 = $('input[name=c_Title2]:text').val();
			var c_Comment2 = $('input[name=c_Comment2]:text').val();
			var c_Start2 = $('input[name=c_Start2]:text').val();
			var c_Limit2 = $('input[name=c_Limit2]:text').val();
			var c_Loc2 = $('input[name=c_Loc2]:text').val();
			$.ajax({
    			type : 'post',
    			url : 'calInsert',
    			data : ({
    				c_Title : c_Title2,
    				c_Comment : c_Comment2,
    				c_Start : c_Start2,
    				c_Limit : c_Limit2,
    				c_Loc : c_Loc2
    			}),
    			success : function(data) {//성공하면
    				//alert(c_Loc2);
    				layerWindow.removeClass('open');
	   				}
    		});
			
		}
        
        
    	function calendar(year,month,day){
        	alert(year+'/'+month+'/'+day);
        	$.ajax({
    			type : 'post',
    			url : 'calview',
    			data : ({
    				year : year,
    				month : month,
    				day : day
    			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
    			success : function(data) {//성공하면
    				//alert("dd");
    				var list = data;
    				alert(data);
    				telNo = data;
    				$('#currentcal').html(data);
	   				
    			}
    		});
        	
        };
    	
        
    </script>
  
    
</head>
<body>
	<!-- This one in here is responsive menu for tablet and mobiles -->
	<!-- 
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
		
		</div>
	
	</div>


	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo" style="background-color: #68A4C4">
			<a href="/"><h1>SGW</h1></a> <span>개인 홈</span>
		</div>
		

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
	

	</div>
	 -->
	<!-- /#main-sidebar -->

	<div id="main-content">
		<div id="templatemo">					
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<center>
							<div id="articleView_layer1">
								<div class="bg_layer"></div>
								<div id="calUpdateform"></div>
							</div>

							<div id="articleView_layer2">
								<div class="bg_layer"></div>
								<div id="calInsertform"></div>
							</div>


							<div id="jMonthCalendar"></div>
							<input type="button" value="일정등록" onclick="calInsertform()" />
							<div id="currentcal"></div>

						</center>
					</div>
				</div>
			</div>			
		</div>
		<!-- /#sTop -->
	</div>
	<!-- /#main-content -->

	<!-- JavaScripts -->	
	<!-- <script src="resources/home/js/jquery-1.10.2.min.js"></script>
	 -->
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
