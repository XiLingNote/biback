<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BI-index-Demo</title>
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.js"></script>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/css/bootstrap/bootstrap-datetimepicker.min.css">
<script>
var options = {
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		language : 'zh-CN',
		format : 'dd/MM/yyyy',
		forceParse : 0
	}
	
	$(function(){
		options.minView=4;
		options.startView=4;
		options.format="yyyy";
		$('#s1>input[name = begin ]').datetimepicker(options);
		$('#s1>input[name = end ]').datetimepicker(options);
		
		options.minView=3;
		options.startView=3;
		options.format="yyyy/MM";
		$('#s2>input[name = begin ]').datetimepicker(options);
		$('#s2>input[name = end ]').datetimepicker(options);
		
		options.minView=2;
		options.startView=2;
		options.format="yyyy/MM/dd";
		$('#s3>input[name = begin ]').datetimepicker(options);
		$('#s3>input[name = end ]').datetimepicker(options);
	var begin;	
	var end;	
 		$('#s1>input[name = begin ]').datetimepicker().on('changeYear',
				function(ev) {
			alert(ev.date);
					end = ev.date;
			$('#s1>input[name = begin ]').attr("value",end);
				});
		$('#s1>input[name = end ]').datetimepicker().on('changeYear',
				function(ev) {
			alert(ev.date);
					end = ev.date;
				});
		$('#s2>input[name = begin ]').datetimepicker().on('changeMonth',
				function(ev) {
			alert(ev.date);
					end = ev.date;
				});
		$('#s2>input[name = end ]').datetimepicker().on('changeMonth',
				function(ev) {
			alert(ev.date);
					end = ev.date;
				});
		$('#s3>input[name = begin ]').datetimepicker().on('changeDate',
				function(ev) {
			alert(ev.date);
					end = ev.date;
				});
		$('#s3>input[name = end ]').datetimepicker().on('changeDate',
				function(ev) {
					end = ev.date;
				}); 
		
		$("input[name='type']").change(function(){
				$("#ff").empty();
			var type = $("input[name='type']:checked").val();
			if (type == "YEAR") {
				$("#s1").removeAttr("hidden");
				$("#s2").attr("hidden",true);
				$("#s3").attr("hidden",true);
				
			}
			if (type == "MONTH") {
				$("#s2").removeAttr("hidden");
				$("#s1").attr("hidden",true);
				$("#s3").attr("hidden",true);
			}
			if (type == "DAY") {
				$("#s3").removeAttr("hidden");
				$("#s2").attr("hidden",true);
				$("#s1").attr("hidden",true);
			}
		});	
	
 });
 
</script>
</head>
<body>
<div class="container">
    <form action="" class="form-horizontal"  role="form">
 
     <div id = "s1" hidden='true'>
   		 <input name="begin"/>
         <input name="end"/>
    </div>
    
    <div id = "s2" hidden='true'>
   		 <input name="begin"/>
         <input name="end"/>
    </div>
    
    <div id = "s3" >
   		 <input name="begin"/>
         <input name="end"/>
    </div>
    
    </form>            
			<div class="an">
				<input type="radio" name="type" value="YEAR" />年
				<input type="radio" name="type" value="MONTH" /> 月 
				<input type="radio" name="type" value="DAY" /> 日
			</div>
   
</div>

<div id="container" style="height: 400px; width: 500px"></div>

</body>
</html>