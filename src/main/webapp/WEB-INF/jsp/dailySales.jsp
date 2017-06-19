<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>shopSale</title>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/css/bootstrap/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/highcharts.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.js"></script>
<script src="/js/Highchartstheme.js"></script>
<script>
	function getData(date, type) {

		$.post("/store/daily.do", {
			"date" : date,
			"type" : type
		}, function(data) {
			
			json.subtitle.text = type;
			
			if (data) {
				var obj = eval('(' + data + ')');
				var set = obj.set;
				var arrayList = obj.arrayList;
				json.series[0].data.length = 0;
				$.each(set, function(name, value) {
					var name = decodeURI(value.shopName);
					var da = [];

					da.push(name);
					da.push(value.amount);
					json.series[0].data.push(da);
				});
			} else {
				alert("查询失败");
			}

			$(".contentl").highcharts(json);
		});
	}
	
	var json = {
		chart : {
			type : 'column'
		},
		title : {
			text : 'daily sales'
		},
		subtitle : {
			text : ''
		},
		xAxis : {
			type : 'category',
			labels : {
				rotation : -45,
				style : {
					fontSize : '13px',
					fontFamily : 'Verdana, sans-serif'
				}
			}
		},
		yAxis : {
			min : 0,
			title : {
				text : 'amount'
			}
		},
		legend : {
			enabled : false
		},
		tooltip : {
			shared : true,
			style : { //提示框内容的样式
				color : 'pink',
				padding : '10px', //内边距 (这个会常用到)
				fontSize : '9pt',
			}
		},
		series : [ {
			name : 'amount',
			data : [ /* [ '上海', 24.25 ]  */],
		/* 	dataLabels : {
				enabled : true,
				rotation : -90,
				color : '#FFFFFF',
				align : 'right',
				format : '{point.y:.1f}', // one decimal
				y : 10, // 10 pixels down from the top
				style : {
					fontSize : '13px',
					fontFamily : 'Verdana, sans-serif'
				}
			} */
		} ]
	};

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
	};

	$(function() {
		var end;
		$("#date").datetimepicker(options);
		$('#date').datetimepicker().on('changeDate', function(ev) {
			end = ev.date;
		});
		getData(null, "GMV");

		$("#go").click(function() {
			var type = $('.selectType option:selected').val();//选中的值
			if (type != "GMV" && type != "Alipay") {
				alert("请选择查询的是GMV还是Alipay!");
				return;
			}
			getData(end, type);
		});
	});
</script>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

a {
	color: #ffffff;
	text-decoration: none;
}
</style>


<body>
	<jsp:include page="/page/top.do"></jsp:include>
	<jsp:include page="/page/left.do"></jsp:include>
	<div class="dailydate">
		<form action="" class="form-horizontal" role="form">

			<select class="selectType" style="position: absolute; top: 10%; left: 45%; width: 10%;height:40px">
				<option></option>
				<option value="GMV">GMV</option>
				<option value="Alipay">Alipay</option>
			</select>

			<div id="ff"
				style="position: absolute; top: 10%; left: 60%; width: 30%">

				<input id="date" style="height: 40px; width: 40%" />

			</div>
		</form>
	</div>

	<input type="button" id="go" value="查询" />

	<div class="contentl"
		style="width: 80%; height: 600px; position: relative; top: 20%; left: 15%; background: #5b5b5b">
	</div>

</body>
</html>