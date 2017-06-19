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
<script src="/js/Highchartstheme.js"></script>

<script>
	function autoCompletion(store) {
		$.post("/store/name.do", function(data) {
			var storename = eval('(' + data + ')');
			var storenames = [];
			$.each(storename, function(i, value) {
				var name = decodeURI(value);
				storenames.push(name);
			});
			names = storenames;
		});
	}




	var names = ["aa","bb"];
	
	$(function() {
		//	getData(datetype, begin, end, store);
		// 加载店铺名称
		autoCompletion();



		$.fn.typeahead.Constructor.prototype.blur = function() {
			var that = this;
			setTimeout(function() {
				that.hide()
			}, 250);

		};

		/* $(".selectstore").on('input', function() {
			var name = this.value;
			var storename = [];
			storename.push(this.value);
			names = storename;
		}); */

		$('.selectstore').typeahead({
			source : function(query, process) {
				return names;
			}
		});

	});
</script>
</head>


<body>


		<div class="storename">
			<span> Store name ：</span>
		</div>
		<input class="selectstore">

		<!-- <select class="selectstore">
			<option value="cpu旗舰">cpu旗舰</option>
			<option value="jeep服饰旗舰店">jeep服饰旗舰店</option>
			<option value="watchstation旗舰店">watchstation旗舰店</option>
		</select> -->

	</form>

</body>
</html>