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
<script type="text/javascript">
		function sWorkDelete() {
			alert("헤헤헤");
			document.sWorkDel.method="get";
			document.sWorkDel.action="/sWorkDelete";
			document.sWorkDel.submit();
		}
	
	</script>

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
	
		<!-- 코멘트 -->
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
	#bwupdate { position:absolute;top:25%;left:40%;
	  	margin:-150px 0 0 -194px;
	   	padding:28px 28px 0 28px;border:3px solid yellow;
	 	   	background:#fff;font-size:12px;
	  	color:#767676;line-height:normal;white-space:normal}
</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript">
	function bwcommentupdateform(code){//
		alert(code);
		 $('#articleView_layer').addClass('open');
		 $.ajax({ type:'get',
			   url:'bworkTCommentUpdateForm',
			   data: ({cm_Code:code }),
			   success:function(data){
				 $('#bwupdate').html(data);				 
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
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript">
function commentinsert() 
{ 	
	
	if($('#cm_Share').is(":checked"))
		var cm_Share = $('#cm_Share').val();
	else
		var cm_Share="";
	$.ajax({ type:'get',
		   url:'bworkTcommectInsert',
		   data: ({cm_Share:cm_Share
		   		,cm_Comment:$('#commentParentText').val()
		   		,m_Menu:$('#m_Menu').val()}),
		   success:function(data){
			 $('#bwcomment').html(data);
			 
		}
	
	});
}
function bwcommentDel(code) 
{ 	
	$.ajax({ type:'get',
		   url:'bworkTcommectDelete',
		   data: ({cm_Code:code
			   ,m_Menu:$('#m_Menu').val()}),
		   success:function(data){
			 $('#bwcomment').html(data);
			 
		}
	
	});
}


function bwcommentupdate(code) 
{
	if($('#cm_Share2').is(":checked"))
		var cm_Share = $('#cm_Share').val();
	else
		var cm_Share="";
	$.ajax({ type:'get',
		   url:'bworkTcommectUpdate',
		   data: ({cm_Code:code
			   ,cm_Share:cm_Share
		   		,cm_Comment:$('#cm_Comment').val()
		   		,m_Menu:$('#m_Menu').val()}),
		   success:function(data){
			 $('#bwcomment').html(data);
			 $('#articleView_layer').removeClass('open');	  	
		}
	
	});
}

</script>
	<!-- 코멘트 -->
	
</head>
<body>
	
	<!-- This one in here is responsive menu for tablet and mobiles -->
    <div class="responsive-navigation visible-sm visible-xs">
        <a href="#" class="menu-toggle-btn">
            <i class="fa fa-bars fa-2x"></i>
        </a>
        <div class="navigation responsive-menu">
            <ul>
                <li class="home"><a href="/team_homeform">홈</a></li>
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
							${workDetail}	
							<br/>
							${wkSWork}
							<div id="bwcomment">
							${bwcoment}							  
							</div>							
							<div id="articleView_layer" >
							   <div class="bg_layer"></div>
							   <div id="bwupdate"></div>
							</div>							
							  <table id="commentTable" class="table table-condensed"></table>
				                    <table class="table table-condensed">
				                        <tr>
				                            <td>
				                                <span class="form-inline" role="form">
				                                    <p>
				                                        <div class="form-group">
				                                            <!-- <button type="button" id="commentParentSubmit" name="commentParentSubmit" class="btn btn-default">확인</button> -->
				                                            <button type="button" class="btn btn-default" onclick="commentinsert()">댓글달기</button>
				                                        </div>
				                                    </p>
				                                    	<input type="checkbox" id="cm_Share" value="NN  ">비공개&nbsp;
				                                        <textarea id="commentParentText" class="form-control col-lg-12" style="width:100%" rows="4"></textarea>
				                                </span>
				                            </td>
				                        </tr>
				                    </table>				                 	
				                    <table class="table table-condensed">
				                        <thead>
				                            <tr>
				                                <td>
				                                    <span style='float:right'>
				                                        <button type="button" id="list" class="btn btn-default">목록</button>
				                                        <button type="button" id="modify" class="btn btn-default">수정</button>
				                                        <button type="button" id="delete" class="btn btn-default">삭제</button>
				                                        <button type="button" id="write" class="btn btn-default">글쓰기</button>
				                                    </span>
				                                </td>
				                            </tr>
				                        </thead>
                   				</table>
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
		
      //여기서부터	
        function now_time() {
			  var time_t = new Date();
			  var s =
				set_standard(time_t .getFullYear(), 4)+'/'+
				set_standard(time_t .getMonth() + 1, 2)+'/'+
				set_standard(time_t .getDate(), 2)+' '+
				set_standard(time_t .getHours(), 2)+':'+
				set_standard(time_t .getMinutes(), 2)+':'+
				set_standard(time_t .getSeconds(), 2);

			  return s;
			}


			function set_standard(time, digits) {
			  var zero = '';
			  time = time.toString();

			  if (time.length < digits) {
				for (i = 0; i < digits - time.length; i++)
				  zero += '0';
			  }
			  return zero + time;
			}
        $(function(){
            
            //제일 하단에 있는 depth1의 댓글을 다는 이벤트
            $("#commentParentSubmit").click(function( event ) {
                   
                //ajax로 저장하고 성공하면 저장한 데이터를 가져와 넣어야 하는데 여기서는 테스트라 그냥 입력값을 가져옴
                var pName = $("#commentParentName");
                var pPassword =$("#commentParentPassword"); //now_time();
                //패스워드를 노출 시켰는데 저장하고 나서 저장한 날짜를 보여줄 예정
                var pText = $("#commentParentText");
                   
                if($.trim(pText.val())==""){
                    alert("내용을 입력하세요.");
                    pText.focus();
                    return;
                }
                   
                var commentParentText = '<tr id="r1" name="commentParentCode">'+
                                            '<td colspan=2>'+
                                                '<strong>'+pName.val()+'</strong> '+pPassword.val()+' <a style="cursor:pointer;" name="pAdd">답글</a> | <a style="cursor:pointer;" name="pDel">삭제</a><p>'+pText.val().replace(/\n/g, "<br>")+'</p>'+
                                            '</td>'+
                                        '</tr>';
                   
                //테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
                if($('#commentTable').contents().size()==0){
                    $('#commentTable').append(commentParentText);
                }else{
                    $('#commentTable tr:last').after(commentParentText);
                }
                   
                $("#commentParentName").val("");
                $("#commentParentPassword").val("");
                $("#commentParentText").val("");
                   
            });
               
            //댓글의 댓글을 다는 이벤트
            $(document).on("click","#commentChildSubmit", function(){
                   
                
                var cText = $("#commentChildText");
                   
                if($.trim(cText.val())==""){
                    alert("내용을 입력하세요.");
                    cText.focus();
                    return;
                }
                   
                var commentChildText = '<tr name="commentChildCode">'+
                                            '<td style="width:1%"><span class="glyphicon glyphicon-arrow-right"></span></td>'+
                                            '<td style="width:99%">'+
                                                '<strong>'+cName.val()+'</strong> '+cPassword.val()+' <a style="cursor:pointer;" name="cAdd">답글</a> | <a style="cursor:pointer;" name="cDel">삭제</a>'+
                                                '<p>'+cText.val().replace(/\n/g, "<br>")+'</p>'+
                                            '</td>'+
                                        '</tr>';
                                           
                //앞의 tr노드 찾기
                var prevTr = $(this).parent().parent().parent().parent().prev();
                //댓글 적는 에디터 삭제
                $("#commentEditor").remove();//여기에서 삭제를 해줘야 에디터tr을 안 찾는다.
                   
                //댓글을 타고 올라가며 부모 tr을 찾음
                while(prevTr.attr("name")!="commentParentCode"){
                    prevTr = prevTr.prev();
                }
                //while를 타는지 체크
                var check = false;
                //다음 노드가 댓글(depth1)의 댓글인지 찾기위해 next
                var nextTr = prevTr.next();
                //뒤에 댓글(depth1)의 댓글(depth2_1)이 없다면 바로 붙인다.
                if(nextTr.attr("name")!="commentChildCode"){
                    prevTr.after(commentChildText);
                }else{
                    //댓글(depth1)의 댓글(depth2_n)이 있는경우 마지막까지 찾는다.
                    while(nextTr.attr("name")=="commentChildCode"){
                        nextTr = nextTr.next();
                        check = true;
                    }
                }
                   
                if(check){//댓글(depth1)의 댓글(depth2_n)이 있다면 그 댓글(depth2_n) 뒤에 댓글(depth2_n+1) 추가
                    nextTr = nextTr.prev();//while문에서 검색하느라 next로 넘거갔던거 다시 앞으로 돌려줌
                    nextTr.after(commentChildText);
                }
                   
            });
               
            //답글링크를 눌렀을때 에디터 창을 뿌려주는 이벤트, 삭제링크를 눌렀을때 해당 댓글을 삭제하는 이벤트
            $(document).on("click","table#commentTable a", function(){//동적으로 버튼이 생긴 경우 처리 방식
                   
                if($(this).attr("name")=="pDel"){
                    if (confirm("답글을 삭제 하시면 밑에 답글도 모두 삭제 됩니다. 정말 삭제하시겠습니까?") == true){    //확인
                           
                        var delComment = $(this).parent().parent();
                        var nextTr = delComment.next();
                        var delTr;
                        //댓글(depth1)의 댓글(depth2_1)이 있는지 검사하여 삭제
                        while(nextTr.attr("name")=="commentCode"){
                            nextTr = nextTr.next();
                            delTr = nextTr.prev();//삭제하고 넘기면 삭제되서 없기 때문에 다음값을 가져오기 어려워 다시 앞으로 돌려서 찾은 다음 삭제
                            delTr.remove();
                        }
                           
                        delComment.remove();
                           
                    }else{   //취소
                        return;
                    }
                }else if($(this).attr("name")=="cDel"){
                    if (confirm("정말 삭제하시겠습니까??") == true){    //확인
                        $(this).parent().parent().remove();
                    }else{   //취소
                        return;
                    }
                }else{
                    //자기 부모의 tr을 알아낸다.
                    var parentElement = $(this).parent().parent();
                    //댓글달기 창을 없앤다.
                    $("#commentEditor").remove();
                    //부모의 하단에 댓글달기 창을 삽입
                    var commentEditor = '<tr id="commentEditor">'+
                                            '<td style="width:1%"> </td>'+
                                            '<td>'+
                                                '<span class="form-inline" role="form">'+
                                                    '<p>'+
                                                        '<div class="form-group">'+
                                                            '<button type="button" id="commentChildSubmit" class="btn btn-default">확인</button>'+
                                                        '</div>'+
                                                    '</p>'+
                                                        '<textarea id="commentChildText" name="commentChildText" class="form-control" style="width:98%" rows="4"></textarea>'+
                                                '</span>'+
                                            '</td>'+
                                        '</tr>';
                                           
                    parentElement.after(commentEditor); 
                }
                   
            });
               
            $( "#list" ).click(function( event ) {
                location.href='/boardDetail';
            });
            $( "#modify" ).click(function( event ) {
                location.href='/community/modify/notice/${community.id}';
            });
            $( "#delete" ).click(function( event ) {
                location.href='/community/delete/notice/${community.id}';
            });
            $( "#write" ).click(function( event ) {
                location.href='/community/notice/edit';
            });
        });
        //여기까지인가
        
        window.onload = loadScript;
    </script>
<!-- templatemo 394 sonic -->
</body>
</html>
