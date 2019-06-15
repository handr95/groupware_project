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
<style type="text/css">
	#addmember.open {display:block; border:3px solid yellow;}
	#addmember.close {display:none;}
</style>
<script type="text/javascript">
	function memberaddform(){		
		$('#addmember').addClass('open');	
		$('#addmember').removeClass('close');
	}
	/*
	function memberadd(){
		
		var email = [];
		$('input[name=tm_memail2]:checkbox:checked').each(function(i) {
			email.push($(this).val());
		 });
		alert(email);
		$.ajax({type:'post', 
			url:'teamAddMembers', 
			data:({tm_memail2:email}),
			success:function(data){
				//$('#addmemberlist').html(data);
			}
		});
	}
	*/
	function memberadd(){
		var x = $('#tcode').val();
		document.getElementsByName("t_code")[0].value=x;		
		document.addm.submit();
	}
	function memberaddclose(){
		$('#addmember').addClass('close');	
		$('#addmember').removeClass('open');
	}
	function findmember(){	
		var x = $('#tcode').val();
		var email = $('input[name=m_Email]:text').val();
		
		if(email==""){
			alert("입력창이 비어있습니다.");
		}else{
			$.ajax({type:'post', 
				url:'searchaddmember', 
				data:({t_code:x,
					t_memail:email
					}),
				success:function(data){
					$('#addmemberlist').html(data);
				}
			});
		}
	}
	function dropTeammember(){	
		var x = $('#tcode').val();
		var t_memail = $('input[name=t_memail]:radio:checked').val();	
		
			$.ajax({type:'post', 
				url:'teamDropMembers', 
				data:({t_code:x,
					t_memail:t_memail
					}),
				success:function(data){										
					document.repage.action="/teamMemberListPage?t_code="+x;					
					document.repage.submit();
				},error:function(data){
					alert("팀장이 아닙니다.");
				}
			});
		
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
		<section id="featured">
			<!-- start slider -->
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						 <div class="row">
							<div class="col-lg-6">
								${teammemberList}
							</div>
							<div class="col-lg-6 close" id="addmember">
								<div id="addmemberlist"></div>
								<input type="text" name="m_Email" >
								<input type="button" value="검색" onclick="findmember()">
								<input type="button" value="등록" onclick="memberadd()">								
								<input type="button" value="닫기" onclick="memberaddclose()">
								
							</div>
							<div><form name='repage' method='get'></form></div>
						</div>
					</div>
				</div>
			</div>
		</section>
	<footer style="background-color: #68A4C4;">
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