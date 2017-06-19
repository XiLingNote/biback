<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo5</title>
<script src="/js/jquery-1.12.3.js"></script>

<script>
	var option = [];
	var optiond = [];
	var a = "ss";
	var _div2 = "div";
	function add() {
		var length = option.length;
		if (length >= 10) {
			return;
		}
		a = a + "b";
		$("#" + _div2).attr("hidden", true);

		option.push(a);
		_div2 = _div2 + '0';
		optiond.push(_div2);
		var bb = "<span id="+a+">"
				+ "<div style='width: 100px;height: 100px;background: #ffffff;float: right'> ss</div>"
				+ "</span>";

		var _tab = $("#tab div:first-child").clone(true);

		$(bb).appendTo($(".dd"));
		$(_tab).appendTo($(".parent"));
		$(".parent div:last-child").attr('id', _div2);
		$(".parent div:last-child").removeAttr("hidden");

		/* var length =option.length;

		for(var i = 0; i<=length;i++){

		} */

		$.each(option, function(i, value) {

			$("#" + value).bind("click", function() {
				$("#" + option[i]).remove();
				$("#" + optiond[i]).remove();

			});
		});

	}
	$(function() {

	});
</script>
</head>
<body>
	<div class="dd">
		<span id="a">a</span>
	</div>
	<input type="button" value="aa" onclick="add()">
	<div class="parent" style="position: absolute;"></div>
	<div id="tab">
		<div hidden="true">
			<table border='1' cellspacing='0' cellpadding='0'
				style='width: 100%;' id='table1'>
				<tbody id='table2'>
					<tr
						style='background: #e0be67; color: #FFFFFF; border-color: #ffffff; text-align: center; height: 50px;'>
						<td style='width: 3%'></td>
						<td style='width: 10%'>订单号</td>
						<td style='width: 8%'>下单时间</td>
						<td style='width: 8%'>支付时间</td>
						<td style='width: 3%'>收货人</td>
						<td style='width: 13%'>店铺</td>
						<td>已付款</td>
						<td>昵称</td>
						<td>客户留言</td>
						<td>商家备注</td>
						<td>状态</td>
						<td>配送</td>
						<td>支付</td>
						<td>锁定</td>
						<td>配货</td>
						<td>回写</td>
						<td>操作</td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='width: 50px; color: #f0ad4e;'>问题单</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='width: 50px; color: #f0ad4e;'>问题单</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr
						style='background: #e0be67; color: #FFFFFF; border-color: #ffffff; text-align: center; height: 50px;'>
						<td style='width: 3%'></td>
						<td style='width: 10%'>订单号</td>
						<td style='width: 8%'>下单时间</td>
						<td style='width: 8%'>支付时间</td>
						<td style='width: 3%'>收货人</td>
						<td style='width: 13%'>店铺</td>
						<td>已付款</td>
						<td>昵称</td>
						<td>客户留言</td>
						<td>商家备注</td>
						<td>状态</td>
						<td>配送</td>
						<td>支付</td>
						<td>锁定</td>
						<td>配货</td>
						<td>回写</td>
						<td>操作</td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr
						style='background: #e0be67; color: #FFFFFF; border-color: #ffffff; text-align: center; height: 50px;'>
						<td style='width: 3%'></td>
						<td style='width: 10%'>订单号</td>
						<td style='width: 8%'>下单时间</td>
						<td style='width: 8%'>支付时间</td>
						<td style='width: 3%'>收货人</td>
						<td style='width: 13%'>店铺</td>
						<td>已付款</td>
						<td>昵称</td>
						<td>客户留言</td>
						<td>商家备注</td>
						<td>状态</td>
						<td>配送</td>
						<td>支付</td>
						<td>锁定</td>
						<td>配货</td>
						<td>回写</td>
						<td>操作</td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
					<tr style='border-color: #2a3542; text-align: center; height: 50px'>
						<td style='color: #ff7885;'>缺货</td>
						<td>17841582098209404</td>
						<td>2017-05-21 16:34</td>
						<td>2017-05-21 16:34</td>
						<td>高*</td>
						<td>PANDORA潘多拉官方旗舰店(测试店)</td>
						<td>2394.00</td>
						<td>t_1487564268677_0978</td>
						<td>尽快发货哦，颜色款式...</td>
						<td>20188211825234676退货</td>
						<td>未确认</td>
						<td>未发货</td>
						<td>已付款</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href='tank.html'>查看</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div style="position: relative;">
		<span style="margin-left: 100px; width: 80px;height: 25px;overflow: hidden;">
			<select style="width: 125px; height: 25px; margin-left: -100px"
			onchange="this.parentNode.nextSibling.value=this.value">
				<option value="德国">德国</option>
				<option value="挪威">挪威</option>
				<option value="瑞士">瑞士</option>
		</select>
		</span><input name="box"
			style="width: 100px; height: 19px; position: absolute; left: 0px;">
	</div>

<br>
<br>
<br>
<br>
	<select id="select" onkeydown="Select.del(this,event)"
		onkeypress="Select.write(this,event)">
		<option value=""></option>
		<option value="aaa">aaa</option>
		<option value="bbb">bbb</option>
		<option value="ccc">ccc</option>
	</select>
	<input type="button" value="获取选择值" id="test" onclick="test();" />
	<script>
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
				opt.text = opt.value += String.fromCharCode(e.charCode
						|| e.which || e.keyCode);
			}
		}
		function test() {
			alert(document.getElementById("select").value);
		}
	</script>
	<br />


</body>
</html>