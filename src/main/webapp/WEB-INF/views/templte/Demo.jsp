<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title>jMonthCalendar Sample</title>

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

	<center>
		<div id= "articleView_layer1">
			<div class="bg_layer"></div>
			<div id="calUpdateform"></div>
		</div>
		
		<div id= "articleView_layer2">
			<div class="bg_layer"></div>
			<div id="calInsertform"></div>
		</div>
			
			
		<div id="jMonthCalendar"></div>
		<input type="button" value="일정등록" onclick="calInsertform()"/>
		<div id="currentcal"></div>
		
	</center>

</body>
</html>