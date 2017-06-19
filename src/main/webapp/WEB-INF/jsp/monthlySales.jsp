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
<script src="/js/highcharts2.js"></script>
<script src="/js/drilldown.js"></script>
<script src="/js/style.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<!-- <script src="/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script src="/js/bootstrap/bootstrap-datetimepicker.js"></script>
<script src="/js/Highchartstheme.js"></script>
<script>
	function getData(type) {
		
		//set arrayList
		$.post("/store/month.do",{"type":type}, function(data) {
			json.series[0].data.length = 0;
			json.drilldown.series.length = 0;
			if (data) {
				var obj = eval('(' + data + ')');
				var set = obj.set;
				var arrayList = obj.arrayList;
				$.each(set, function(name, value) {
					var shop = decodeURI(value.shopName);
					var id = value.id;
					var options = {
						name : 2,
						y : 3,
						drilldown: 'Safari'
					}
					options.name = shop;
					options.drilldown = shop;
					var mount =  value.amount.toFixed(0);
					var amount = eval('(' + mount + ')');
						options.y =amount;
					json.series[0].data.push(options);
				});

				json.yAxis.title.text = type;
				json.series[0].name =type;
				$.each(arrayList, function(name, value) {
					var options = {
						name : 'Opera',
						id : 'Opera',
						data : []
					}
					var name = decodeURI(value.shopName);
					var id = value.id;
					options.id = name;
					options.name = name;
					var list = value.list;
					$.each(list, function(name, value) {
						var da = [];
						da.push(value.datetime);
						if (type == "Alipay") {
							var ali =  value.alipay.toFixed(0);
							var alipay = eval('(' + ali + ')');
							da.push(alipay);
						} else {
							var gm =  value.gmv.toFixed(0);
							var gmv = eval('(' + gm + ')');
							da.push(gmv);
						}
						da.push(value.amount);
						options.data.push(da);
					});
					json.drilldown.series.push(options);
				});
			} else {
				alert("查询失败");
			}

			$(".contentl").highcharts(json);
		});
	}

	var b = true;
	var time = 10000;
	function date() {
		
		if (b) {
			getData("Alipay");
		} else {
			getData("GMV");
		}

		b = !b;
	}
	var json = {
		chart : {
			type : 'column'
		},
		title : {
			text : '当月销售排行'
		},
		subtitle : {
			text : 'Month Sales Rank'
		},
		xAxis : {
			type : 'category'
		},
		yAxis : {
			title : {
				text : 'GMV'
			}

		},
		legend : {
			enabled : false
		},
		plotOptions : {
			series : {
				borderWidth : 0,
				dataLabels : {
					enabled : true
				}
			}
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
			name : 'GMV',
			//颜色
			//			colorByPoint : true,
			data : [/*  {
							name : 'Firefox',
							y : 10.38,
							drilldown : 'Firefox'
						} */]
		} ],
		drilldown : {
			series : [ /* {
						name : 'Firefox',
						id : 'Firefox',
						data : [ [ 'v35', 2.76 ], [ 'v36', 2.32 ], [ 'v37', 2.31 ],
								[ 'v34', 1.27 ], [ 'v38', 1.02 ], [ 'v31', 0.33 ],
								[ 'v33', 0.22 ], [ 'v32', 0.15 ] ]
					}  */]
		}
	}
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

	$(function() {
		/*定时器*/
		   var timmer = setInterval(date, time);  
		 // Alipay  GMV
		 
		getData("GMV");
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

	<div class="contentl"
		style="width: 80%; height: 600px; position: relative; top: 10%; left: 15%; background: #5b5b5b">
	</div>

</body>
</html>