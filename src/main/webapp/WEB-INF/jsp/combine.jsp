<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<title>Insert title here</title>
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/bootstrap/bootstrap-typeahead.js"></script>
<script type="text/javascript">
	function autoCompletion(store) {
		$.post("/store/name.do", function(data) {
			var storename = eval('(' + data + ')');
			var storenames = [];
			$.each(storename,
					function(i, value) {
						var name = decodeURI(value);
						var _options = "<option value='"+name+"'>" + name
								+ "</option>";
						$(_options).appendTo($("#sel"));
						storenames.push(name);
					});
			names = storenames;
		});
	}
	var names = [ "aa", "bb" ];
	var Select = {
		del : function(obj, e) {
			if ((e.keyCode || e.which || e.charCode) == 8) {
				var opt = obj.options[0];
				opt.text = opt.value = opt.value.substring(0,
						opt.value.length > 0 ? opt.value.length - 1 : 0);
			}
		},
		write : function(obj, e) {
			if ((e.keyCode || e.which || e.charCode) == 8)
				return;
			var opt = obj.options[0];
			opt.selected = "selected";
			opt.text = opt.value += String.fromCharCode(e.charCode || e.which
					|| e.keyCode);
		}
	}
	function test() {
		alert(document.getElementById("select").value);
	}

	var names = [ "aa", "bb" ];

	$(function() {
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
		$('.name').typeahead({
			source : function(query, process) {
				return names;
			}
		});

	});
</script>

</head>
<body>

	<div style="position: relative;">
		<span
			style="margin-left: 100px; width: 80px; height: 25px; overflow: hidden;">
			<select id="sel"
			style="width: 200px; height: 25px; margin-left: -100px"
			onchange="this.parentNode.nextSibling.value=this.value">
		</select>

		</span><input class="name" name="box"
			style="width: 175px; height: 25px; position: absolute; left: 0px;">
	</div>
	<br>

</body>
</html>