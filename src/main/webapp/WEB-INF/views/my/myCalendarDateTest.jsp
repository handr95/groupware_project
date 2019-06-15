<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />

<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/home/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/home/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/home/css/templatemo_misc.css">
<link rel="stylesheet" href="resources/home/css/templatemo_style.css">

<link rel='stylesheet' href='resources/CA/lib/cupertino/jquery-ui.min.css' />
<link href='resources/CA/fullcalendar.css' rel='stylesheet' />
<link href='resources/CA/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='resources/CA/lib/moment.min.js'></script>
<script src='resources/CA/lib/jquery.min.js'></script>
<script src='resources/CA/fullcalendar.min.js'></script>

<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.1.1/dojo/dojo.xd.js "></script> 
<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.1.1/dojo/dojo.xd.js.uncompressed.js"></script>   

<script>

	$(document).ready(function() {
		${ca}
		/*
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: null,
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				*/
				/*
				var title = prompt('Event Title:');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
				*/
				/*
				var start1 = (start.format("YYYY-MM-DD"));
				var end1 = (end.format("YYYY-MM-DD"));
				$('#articleView_layer2').addClass('open');
				$('#c_Start1').val(start1);
				$('#c_Limit1').val(end1);
				*/
				/*
	        	$.ajax({
	    			type : 'post',
	    			url : 'calInsertform_Test',
	    			data : ({c_Start: start,
	    					c_Limit: end	    				
	    			}),//파라미터(bnum)에 따른 데이터(idx)이려나?
	    			success : function(data) {//성공하면
	    				$('#articleView_layer2').addClass('open');
	    				$('#calInsertform').html(data);		   				
	    			}
	    		});
	        	*/
	        /*
			},
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			*/
			/*
			eventClick: function(event) {
				// opens events in a popup window
				window.open(event.url, 'gcalevent', 'width=700,height=600');
				return false;
			},
			*/
			
			
			/*
			events: [
				{
					title: 'All Day Event',
					start: '2014-11-01'
				},
				{
					title: 'Long Event',
					start: '2014-11-07',
					end: '2014-11-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-11-09T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-11-16T16:00:00'
				},
				{
					title: 'Conference',
					start: '2014-11-11',
					end: '2014-11-13'
				},				
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2014-11-28'
				}
			]
			*/
			/*
		});
		*/
	});

</script>
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
		/*
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
        */
        
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
	</script>
<style>

	#main-content {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
<script src="resources/home/js/date_picker.js"></script>
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
	
		
		<!-- JavaScripts -->	
	<div id="main-content">
		<div id="templatemo">					
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">	
							<div id='calendar'></div>
							
							<div id="articleView_layer2">
								<div class="bg_layer"></div>							
								<div id="calInsertform">
									<form action='/calInsert_Test' method='post'>
									 제목 : <input type='text' name='c_Title' /><br/>
									 내용 : <input type='text' name='c_Comment' /><br/>									 
									 시작일 : <input type='text' id='c_Start1' name='c_Start' />									
									 <input type='button' value='달력보기' onClick="datePicker(event,'c_Start')"><br/>
									 마감일 : <input type='text' id='c_Limit1' name='c_Limit' />							
									 <input type='button' value='달력보기' onClick="datePicker(event,'c_Limit')"><br/>
									 장소 : <input type='text' name='c_Loc' /><br/>
									 "<input type='submit' value='일정 등록' />
									 </form>
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
		<!-- /#sTop -->
	</div>
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
