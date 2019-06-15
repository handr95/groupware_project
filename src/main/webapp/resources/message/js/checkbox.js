/**
 * 
 */
$(document).ready(function(){
	$("#check_all_AB").click(function() {	
		if($(this).is(":checked"))
			$("input[name=mycheck]:checkbox").attr("checked",true);
		else
			$("input[name=mycheck]:checkbox").attr("checked",false);
	});
	$("#check_all_T").click(function() {	
		if($(this).is(":checked"))
			$("input[name=mycheck]:checkbox").attr("checked",true);
		else
			$("input[name=mycheck]:checkbox").attr("checked",false);
	});
	$("#check_all").click(function() {	
		if($(this).is(":checked"))
			$("input[name=msg_getmemail2]:checkbox").attr("checked",true);
		else
			$("input[name=msg_getmemail2]:checkbox").attr("checked",false);
	});
	
});

