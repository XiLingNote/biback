$(function() {
	$("input[name='datetype']:last").attr("checked", true);
	//	json.series[1].tooltip.valueSuffix = 'k';
	//		json.series[2].tooltip.valueSuffix = 'k';
	var begin;
	var end;
	var datetype = "DAY";
	var store;
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
		datetype = $("input[name='datetype']:checked").val();
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
});