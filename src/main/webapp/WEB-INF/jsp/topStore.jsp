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
<link rel="stylesheet" href="/css/jsp.css">
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/highcharts.js"></script>
<script src="/js/style.js"></script>
<script src="/js/scientific.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.js"></script>
<script src="/js/bootstrap/bootstrap-typeahead.js"></script>
<script src="/js/Highchartstheme.js"></script>
<script>
	function getData(datetype, begin, end, stores) {
		$.post("/industry/topStore.do", {
			"datetype" : datetype,
			"begin" : begin,
			"end" : end,
			"stores" : stores
		}, function(data) {
		//	topList
		
			if (data) {
				try {
					var obj = eval('(' + data + ')');
				} catch (e) {
					var response = decodeURI(data);
					alert(response);
					return;
				}

				var obj = eval('(' + data + ')');
				var treeSet = obj.treeSet;

				var categories = [];
				var rates = [];

				var gmvs = [];
				var targets = [];
				var alipays = [];
				var totalGmv = 0.00;
				var totalTarget = 0.00;
				var totalAlipay = 0.00;
				var totalCplR;
				$.each(treeSet, function(i, value) {
					totalGmv = totalGmv + value.gmv;
					totalTarget = totalTarget + value.target;
					totalAlipay = totalAlipay + value.alipay;
					var gmv = value.gmv;
					gmvs.push(gmv);
					var target = value.target;
					targets.push(target);
					//if (target) {
					//	var ra = gmv / target;
						var rate = eval('(' + (value.completeness*100).toFixed(2) + ')');
						rates.push(rate);
					//} else {
					//}

					alipays.push(value.alipay);
					categories.push(value.datetime);
				});
				
				if (categories.length > 60) {
					json.xAxis[0].tickInterval = 6;
				} else if (categories.length > 30) {
					json.xAxis[0].tickInterval = 3;
				} else if (categories.length > 15) {
					json.xAxis[0].tickInterval = 2;
				}
				
				json.xAxis[0].categories = categories;
				json.series[0].data = rates;
				json.series[1].data = gmvs;
				json.series[2].data = targets;
				json.series[3].data = alipays;
				$(".contentl").highcharts(json);
				totalCplR = (totalGmv/totalTarget*100).toFixed(2);
				//gmv alipay target cpl
				var _totalGmv = formatNum(totalGmv);
				var _totalAlipay = formatNum(totalAlipay);
				var _totalTarget = formatNum(totalTarget);
				$("#gmv").html(_totalGmv);
				$("#alipay").html(_totalAlipay);
				$("#target").html(_totalTarget);
				$("#cpl").html(totalCplR+"%");
			} else {
				alert("查询参数无效"); 
			}
		});
	}
	function value() {
		$('#s1>input[name = begin ]').val(null);
		$('#s1>input[name = end ]').val(null);
		$('#s2>input[name = begin ]').val(null);
		$('#s2>input[name = end ]').val(null);
		$('#s3>input[name = begin ]').val(null);
		$('#s3>input[name = end ]').val(null);
	}

	function autoCompletion(store) {
		$.get("/store/name.do", function(data) {
			var storename = eval('(' + data + ')');
			var storenames = [];
			$.each(storename, function(i, value) {
				var name = decodeURI(value);
				storenames.push(name);
			});
			names = storenames;
		});
		
		$.fn.typeahead.Constructor.prototype.blur = function() {
			var that = this;
			setTimeout(function() {
				that.hide()
			}, 250);

		};

		$('.selectstore').typeahead({
			source : function(query, process) {
				return names;
			}
		});
	}

	var b = true;
	var time = 10000;
	
	var json = {
		chart : {
			zoomType : 'xy'
		},
		title : {
			text : 'topstore'
		},
		subtitle : {
			text : 'gmv'
		},
		xAxis : [ {
			categories : [ '201701', '201702', '201703', '201704', '201705'],
			crosshair : true,
			tickInterval : 1
		} ],
		yAxis : [ { // Primary yAxis
			labels : {
				format : '{value}',
				style : {
					color : Highcharts.getOptions().colors[1]
				}
			},
			title : {
				text : '金额',
				style : {
					color : Highcharts.getOptions().colors[1]
				}
			}
		}],
		tooltip : {
			shared : true
		},
		legend : {
			layout : 'vertical',
			align : 'left',
			x : 0,
			verticalAlign : 'top',
			y : 0,
			floating : true,
			backgroundColor : (Highcharts.theme && Highcharts.theme.legendBackgroundColor)
					|| '#FFFFFF'
		},
		series : [ {
			name : 'GMV',
			type : 'areaspline',
			data : [ 18,16,14,32,19 ],
			tooltip : {
				valueSuffix : ''
			}
		},{
			name : 'target',
			type : 'areaspline',
			color : '#66cdaa',
			data : [23,15,43,12,15 ],
			tooltip : {
				valueSuffix : ''
			}
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
	}

	var names = ["aa","bb"];
	
	$(function() {
		$(".contentl").highcharts(json);
		$("input[name='datetype']:last").attr("checked", true);
		//	json.series[1].tooltip.valueSuffix = 'k';
		//		json.series[2].tooltip.valueSuffix = 'k';
		var begin;
		var end;
		/*年日期选项   */
		options.minView = 4;
		options.startView = 4;
		options.format = "yyyy";
		$('#s1>input[name = begin ]').datetimepicker(options);
		$('#s1>input[name = end ]').datetimepicker(options);
		/*月日期选项   */
		options.minView = 3;
		options.startView = 3;
		options.format = "yyyy/MM";
		$('#s2>input[name = begin ]').datetimepicker(options);
		$('#s2>input[name = end ]').datetimepicker(options);
		/*日日期选项   */
		options.minView = 2;
		options.startView = 2;
		options.format = "yyyy/MM/dd";
		$('#s3>input[name = begin ]').datetimepicker(options);
		$('#s3>input[name = end ]').datetimepicker(options);
		
		$('#s1>input[name = begin ]').datetimepicker().on('changeDate',
				function(ev) {
					begin = ev.date;
				});
		$('#s1>input[name = end ]').datetimepicker().on('changeDate',
				function(ev) {
					end = ev.date;
				});
		$('#s2>input[name = begin ]').datetimepicker().on('changeDate',
				function(ev) {
					begin = ev.date;
				});
		$('#s2>input[name = end ]').datetimepicker().on('changeDate',
				function(ev) {
					end = ev.date;
				});
		$('#s3>input[name = begin ]').datetimepicker().on('changeDate',
				function(ev) {
					begin = ev.date;
				});
		$('#s3>input[name = end ]').datetimepicker().on('changeDate',
				function(ev) {
					end = ev.date;
				});

		$("input[name='datetype']").change(function() {
			begin = null;
			end = null;
			// 清空日期选择框的值
			value();
			
			var datetype = $("input[name='datetype']:checked").val();
			
			if (datetype == "YEAR") {
				$("#s1").removeAttr("hidden");
				$("#s2").attr("hidden", true);
				$("#s3").attr("hidden", true);
			}
			if (datetype == "MONTH") {
				$("#s2").removeAttr("hidden");
				$("#s1").attr("hidden", true);
				$("#s3").attr("hidden", true);
			}
			if (datetype == "DAY") {
				$("#s3").removeAttr("hidden");
				$("#s2").attr("hidden", true);
				$("#s1").attr("hidden", true);
			}
		});
		//	getData(datetype, begin, end, store);
		// 加载店铺名称
		autoCompletion();

		$("#go").click(function() {
			var type = $("input[name='datetype']:checked").val();
			var store = $('.selectstore').val();//选中的值

			if (!store) {
				alert("请选择查询的店铺名称!");
				return;
			}

			if (!type) {
				alert("请选择日期类型!");
				return;
			}
			
			getData(type, begin, end, store);
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

	<form action="" class="form-horizontal" role="form">
		<div class="an" style="position: absolute; left: 15%">
			<input type="radio" name="datetype" value="YEAR" />y <input
				type="radio" name="datetype" value="MONTH" /> m <input type="radio"
				name="datetype" value="DAY" /> d
		</div>

		<div id="ff"
			style="position: absolute; top: 10%; left: 28%; width: 30%">
			<div id="s1" hidden='true'>
				<input name="begin" style="height: 40px; width: 40%" readonly="true" />
				<input name="end" style="height: 40px; width: 40%" readonly="true" />

			</div>

			<div id="s2" hidden='true'>
				<input name="begin" style="height: 40px; width: 40%" readonly="true">
				<input name="end" style="height: 40px; width: 40%" readonly="true" />

			</div>

			<div id="s3">
				<input name="begin" style="height: 40px; width: 40%" readonly="true" />
				<input name="end" style="height: 40px; width: 40%" readonly="true" />

			</div>

		</div>

		<div class="storename">
			<span> Store name ：</span>
		</div>
		<input class="selectstore">


	</form>
	<div class="view">
		<div class="topStoreDiv" salesTrendDiv>
			<span class="span">GMV:</span> <br> <span id="gmv" class="span"></span>
		</div>										
		<div class="topStoreDiv" salesTrendDiv>
			<span class="span">Compare:</span> <br> <span id="gmv2" class="span"></span>
		</div>
	</div>

	<input type="button" id="go" value="查询" />

	<div class="contentl"
		style="width: 80%; height: 550px; position: relative; top: 30%; left: 15%">
	</div>
</body>
</html>