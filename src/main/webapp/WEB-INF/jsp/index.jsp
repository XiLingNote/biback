<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>index</title>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/css/bootstrap/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- <script src="/js/jquery-1.12.3.js"></script> -->
<script src="/js/jquery-1.8.3.min.js"></script>
<script src="/js/highcharts.js"></script>
<script src="/js/style.js"></script>
<script src="/js/scientific.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/bootstrap/bootstrap-datetimepicker.js"></script>
<script src="/js/Highchartstheme.js"></script>
<script>
	var unit = 1000;
	function value() {
		$('#s1>input[name = begin ]').val(null);
		$('#s1>input[name = end ]').val(null);
		$('#s2>input[name = begin ]').val(null);
		$('#s2>input[name = end ]').val(null);
		$('#s3>input[name = begin ]').val(null);
		$('#s3>input[name = end ]').val(null);

	}
	//"begin" : begin, "end" : end, "type" : type,  "department" : department
	function getDate(datetype, begin, end, department, type) {
		var unitE = null;
		if (datetype == "DAY") {
			unit = 1000;
			unitE = 'K';
			json.yAxis[0].labels.format = '{value}k';
			json.series[1].tooltip.valueSuffix = 'K';
			json.series[2].tooltip.valueSuffix = 'K';
		} else if (datetype == "MONTH") {
			unit = 1000000;
			unitE = 'M';
			json.yAxis[0].labels.format = '{value}M';
			json.series[1].tooltip.valueSuffix = 'M';
			json.series[2].tooltip.valueSuffix = 'M';
		} else {
			unit = 1000000000;
			unitE = 'G';
			json.yAxis[0].labels.format = '{value}G';
			json.series[1].tooltip.valueSuffix = 'G';
			json.series[2].tooltip.valueSuffix = 'G';
		}
		json.title.text = type;

		$.post("/overall/sale.do", {
			"datetype" : datetype,
			"begin" : begin,
			"end" : end,
			"department" : department
		}, function(data) {
			var amounts = [];
			var targets = [];
			var categories = [];
			var completion = [];
			var gc = 0.0;
			var gt = 0.0;

			var ac = 0.0;
			var at = 0.0;

			var lastgrate = 0.0;

			var lastarate = 0.0;

			if (data) {
				var obj = eval('(' + data + ')');
				var pojo = obj.treeSet;
				var last = obj.last;
				if (last) {
					lastgrate = ((last.gmv / last.target) * 100).toFixed(1);
					lastarate = ((last.alipay / last.alipayTarget) * 100)
							.toFixed(1);
				}

				$
						.each(pojo,
								function(name, value) {
									if (type == "Alipay") {
										gc = gc + value.gmv;
										gt = gt + value.target;
										ac = ac + value.alipay;
										at = at + value.alipayTarget;
										var amount = eval('('
												+ (value.alipay / unit)
														.toFixed(1) + ')');
										amounts.push(amount);
										categories.push(value.datetime);
										var target = eval('('+ (value.alipayTarget / unit).toFixed(1) + ')');

										targets.push(target);
										var com = value.alipayCompleteness;
										var comp = eval('('+(com * 100).toFixed(2)+ ')');
										completion.push(comp);

									} else {
										gc = gc + value.gmv;
										ac = ac + value.alipay;
										gt = gt + value.target;
										at = at + value.alipayTarget;
										var amoun = value.gmv;
										var amount = eval('('+ (amoun / unit).toFixed(2)+ ')');
										amounts.push(amount);
										categories.push(value.datetime);
										var target = eval('('+ (value.target / unit)
														.toFixed(2) + ')');
										targets.push(target);
										var com = value.completeness;
										var comp = eval('('+(com * 100).toFixed(2)+ ')');
										completion.push(comp);
									}
								});
				if (categories.length > 60) {
					json.xAxis[0].tickInterval = 6;
				} else if (categories.length > 30) {
					json.xAxis[0].tickInterval = 3;
				} else if (categories.length > 15) {
					json.xAxis[0].tickInterval = 2;
				}

				json.xAxis[0].categories = categories;
				// 完成率 ，目标  完成
				json.series[0].data = completion;
				json.series[1].data = targets;
				json.series[2].data = amounts;
				
				
				gc = eval('(' + (gc / unit).toFixed(0) + ')');
				var showgc = formatNum(gc);
				//		gc = eval('(' + (gc / unit).toFixed(0) + ')');
				$("#gc").text(showgc);
				var showgt = formatNum(gt);
				//			gt = eval('(' + (gt / unit).toFixed(0) + ')');
				$("#gt").text(showgt);
				var grate;
				if (gt > 0) {

					grate = (gc / gt * 100).toFixed(1);
					if (grate) {
						$("#grate").text(grate + '%');
					}

				}

				if (lastgrate) {
					if (lastgrate / grate > 1) {
						$("#gy2").removeAttr("hidden");
						$("#gy1").attr("hidden", "true");
						$("#gys").text(
								"↓（" + (lastgrate - grate).toFixed(1) + "％)");
					}

					if (lastgrate / grate < 1) {
						$("#gy1").removeAttr("hidden");
						$("#gy2").attr("hidden", "true");
						$("#gya").text(
								"↑" + (grate - lastgrate).toFixed(1) + "％");

					}
				}

				ac = eval('(' + (ac / unit).toFixed(0) + ')');
				var showac = formatNum(ac);
				$("#ac").text(showac+unitE);

				var showat = formatNum(at+unitE);
				$("#at").text(showat);
				var arate;
				if (at > 0) {
					arate = (ac / at * 100).toFixed(1);
					if (arate) {
						$("#arate").text(arate + '%');
					}
				}

				if (lastarate) {
					if (lastarate / arate > 1) {
						$("#ay2").removeAttr("hidden");
						$("#ay1").attr("hidden", "true");
						$("#ays").text(
								"↓（" + (lastarate - arate).toFixed(1) + "％)");
					}

					if (lastarate / arate < 1) {
						$("#ay1").removeAttr("hidden");
						$("#ay2").attr("hidden", "true");
						$("#aya").text(
								"↑" + (arate - lastarate).toFixed(1) + "％");

					}
				}

			} else {
				alert("参数错误");
			}
			$(".contentl").highcharts(json);
		});

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
	};

	var json = {
		chart : {
			zoomType : 'xy'
		},
		title : {
			text : 'ＧMV'
		},
		subtitle : {
			text : '数据来源：ＢＩ'
		},
		xAxis : [ { // Ajax后台数据  X轴数据
			categories : [],
			crosshair : true,
			//X轴每隔几个显示一个
			tickInterval : 1,
			floor : 3
		/*   labels: {
		  	rotation: -30
		  } */
		} ],
		yAxis : [ { // Primary yAxis
			labels : {
				format : '{value}M',
				style : {
					color : Highcharts.getOptions().colors[6]
				}
			},
			title : {
				text : '金额',
				style : {
					color : Highcharts.getOptions().colors[6]
				}
			}
		}, { // Secondary yAxis
			title : {
				text : '完成率',
				style : {
					color : Highcharts.getOptions().colors[4]
				}
			},
			labels : {
				format : '{value} ％',
				style : {
					color : Highcharts.getOptions().colors[0]
				}
			},
			opposite : true
		} ],
		tooltip : {
			shared : true,
			style : { //提示框内容的样式
				color : 'pink',
				padding : '10px', //内边距 (这个会常用到)
				fontSize : '9pt',
			}
		},
		legend : {
			layout : 'vertical',
			align : 'left',
			x : 120,
			verticalAlign : 'top',
			floating : true,
			y : 100,
			floating : true
		}, // Ajax后台数据 
		series : [ { // 内部有个List集合（）
			name : '完成率',
			type : 'spline',
			yAxis : 1,
			data : [],
			tooltip : {
				valueSuffix : '％'
			}
		}, {
			name : '目标',
			type : 'areaspline',
			color : '#66cdaa',
			data : [],
			tooltip : {
				valueSuffix : ''
			}
		}, {
			name : '完成',
			color : '#7F7876',
			type : 'areaspline',
			data : [],
			tooltip : {
				valueSuffix : ''
			}
		} ]
	};

	$(function() {
		$("input[name='datetype']:last").attr("checked", true);
		json.series[1].tooltip.valueSuffix = 'k';
		json.series[2].tooltip.valueSuffix = 'k';
		var begin;
		var end;
		var datetype = "DAY";
		var department;
		getDate(datetype, begin, end, department, "GMV");

		/*  $(".content_top").mouseenter(function() {
		 getDate(datetype, begin, end, department, "GMV");
		 });

		 $(".content_bottom").mouseenter(function() {
		 getDate(datetype, begin, end, department, "Alipay");
		 });  */

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
			var type = $("input[name='datetype']:checked").val();
			if (type == "YEAR") {
				$("#s1").removeAttr("hidden");
				$("#s2").attr("hidden", true);
				$("#s3").attr("hidden", true);
			}
			if (type == "MONTH") {
				$("#s2").removeAttr("hidden");
				$("#s1").attr("hidden", true);
				$("#s3").attr("hidden", true);
			}
			if (type == "DAY") {
				$("#s3").removeAttr("hidden");
				$("#s2").attr("hidden", true);
				$("#s1").attr("hidden", true);
			}
		});

		$("#go").click(function() {
			department = $('.sort option:selected').val();//选中的值
			var type = $('.sort1 option:selected').val();//选中的值
			datetype = $("input[name='datetype']:checked").val();
			if (!type) {
				alert("请选择查询的是GMV还是Alipay!");
				return;
			}

			if (!department) {
				alert("部门不能为空!");
				return;
			}
			if (!datetype) {

				alert("请选择日期类型!");
				return;
			}

			getDate(datetype, begin, end, department, type);

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

.body {
	color: #2a2a2b
}
</style>
<body>
	<jsp:include page="/page/top.do"></jsp:include>
	<jsp:include page="/page/left.do"></jsp:include>


	<select class="sort" name="department">
		<option></option>
		<option value="All">All</option>
		<option value="Bag">Bag</option>
		<option value="Shoes">Shoes</option>
		<option value="Dress">Dress</option>
		<option value="TMhk">TMhk</option>
		<option value="ACC">ACC</option>
	</select>

	<select class="sort1">
		<option></option>
		<option value="GMV">GMV</option>
		<option value="Alipay">Alipay</option>
	</select>
	<!------

------------------->
	<div class="container">
		<form action="" class="form-horizontal" role="form">

			<div id="ff"
				style="position: absolute; top: 10%; left: 28%; width: 30%">
				<div id="s1" hidden='true'>
					<input name="begin" style="height: 40px; width: 40%" /> <input
						name="end" style="height: 40px; width: 40%" />
				</div>

				<div id="s2" hidden='true'>
					<input name="begin" style="height: 40px; width: 40%" /> <input
						name="end" style="height: 40px; width: 40%" />
				</div>

				<div id="s3">
					<input name="begin" style="height: 40px; width: 40%" /> <input
						name="end" style="height: 40px; width: 40%" />
				</div>

			</div>
		</form>

		<div class="an" style="position: absolute; left: 15%">
			<input type="radio" name="datetype" value="YEAR" />y <input
				type="radio" name="datetype" value="MONTH" /> m <input type="radio"
				name="datetype" value="DAY" /> d
		</div>
	</div>
	<input type="button" id="go" value="查询" />
	<!--------以下数据框----------->
	<div
		style="width: 15%; height: 600px; background: #696969; position: absolute; top: 20%; left: 12%">
		<div class="content_top"
			style="width: 100%; height: 50%; background: #898989; position: absolute">
			<div style="height: 20%; background: #3e3e40;">
				<span style="color: #FFF8DC; font-size: 20px">
					&nbsp;&nbsp;GMV </span>
			</div>
			<div style="height: 20%; background: #3e3e40;">

				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Completeness:</span>
				<span id="gc" style="color: #FFF8DC"></span>
			</div>
			<div style="height: 20%; background: #3e3e40;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Target:</span> <span
					id="gt" style="color: #FFF8DC"> </span>
			</div>
			<div style="height: 20%; background: #3e3e40;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Completion
					rate: </span> <span id="grate" style="color: #FFF8DC"> </span>
			</div>

			<div id="gy1" style="height: 20%; background: #3e3e40;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;YoY:</span> <span
					id="gya" style="color: green"></span>
			</div>
			<div id="gy2" style="height: 20%; background: #3e3e40;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;YoY:</span> <span
					id="gys" style="color: red"></span>
			</div>

		</div>
		<div class="content_bottom"
			style="width: 100%; height: 50%; background: #66cdaa; position: absolute; top: 50%">
			<div style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC; font-size: 20px">
					&nbsp;&nbsp;Alipay </span>
			</div>
			<div style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Completeness:</span>
				<span id="ac" style="color: #FFF8DC"></span>
			</div>
			<div style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Target:</span> <span
					id="at" style="color: #FFF8DC"></span>
			</div>
			<div style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;Completion
					rate: </span> <span id="arate" style="color: #FFF8DC"></span>
			</div>
			<div id="ay1" hidden="true" style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;YoY:</span> <span
					id="aya" style="color: green"></span>
			</div>
			<div id="ay2" style="height: 20%; background: #2a2a2b;">
				<span style="color: #FFF8DC">&nbsp;&nbsp;&nbsp;YoY:</span> <span
					id="ays" style="color: red"></span>
			</div>
		</div>
	</div>

	<div class="contentl"
		style="width: 65%; height: 600px; position: relative; top: 20%; left: 27%; background: #5b5b5b">
	</div>
</body>



</html>