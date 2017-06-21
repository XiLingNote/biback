<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/style.css">

<script src="/js/style.js"></script>
<title>left</title>
<script type="text/javascript">
	window.onload = function() {
		$('.list ul li p').clickdown();
		$('.list-se p[class=title]').clickup();
		$('.list>ul>li').ad();
	}
</script>
</head>
<body>
	<div class="list">
		<ul>
			<li>
				<p class="title" style="background: #c12e2a;">
					<a href="/page/index.do" style="color: #ffffff"> <img
						src="/img/index.png"> Sales Overall
					</a>
				</p>
			</li>

			<li class="list-see">
				<p class="title">
					<a href="/page/monthlySales.do"> <img src="/img/shopsale.png">
						Shop Sales
					</a><span style="color: #ffffff; z-index: 10">+</span>
				</p>

				<ul class='list-se' style="padding-top: 10px;">
					<p class="title" style="color: #e9f2ff">
						<a href="/page/monthlySales.do">Shop Sales</a><span
							style="color: #2a6496; z-index: 10">-</span>
					</p>
					<li><p>
							<a href="/page/monthlySales.do">Monthly sales</a>
						</p></li>
					<li><p>
							<a href="/page/dailySales.do">Daily sales</a>
						</p></li>
					<li><p>
							<a href="/page/salesTrend.do">Storesales Trend</a>
						</p></li>
				</ul>
			</li>

			<li class="list-see">

				<p class="title">
				<!-- /page/industry.do -->
					<a href="/page/topStore.do"> <img src="/img/marketcondition.png">
						IndustryData
					</a><span style="color: #ffffff; z-index: 10">+</span>
				</p>
				<ul class='list-se' style="padding-top: 10px;">
					<p class="title" style="color: #e9f2ff">
						<a href="行业大盘.html">市场行情</a><span
							style="color: #2a6496; z-index: 10">-</span>
					</p>
					<li><p>
							<a href="行业大盘.html">行业大盘</a>
						</p></li>
					<li><p>
							<a href="/page/topStore.do">TOP Store</a>
						</p></li>
					<li><p>
							<a href="/page/topBrand.do">TOP Brand</a>
						</p></li>
				</ul>
			</li>
			<li>
				<p class="title">
					<a href="店铺分析（运营）.html"> <img src="/img/shopAnalysis.png">
						店铺分析
					</a><span style="color: #ffffff; z-index: 10">+</span>
				</p>
				<ul class='list-se'>
					<p class="title" style="color: #e9f2ff">
						<a href="店铺分析（运营）.html">店铺分析</a><span
							style="color: #2a6496; z-index: 10">-</span>
					</p>
					<li><p>
							<a href="店铺分析（运营）.html">运营</a>
						</p></li>
					<li><p>
							<a href="粉丝.html">粉丝</a>
						</p></li>
				</ul>
			</li>
			<li>
				<p class="title">
					<a href="商品分析.html"> <img src="/img/commercialAnalysis.png">
						商品分析
					</a>
				</p>
			</li>
			<li>
				<p class="title">
					<a href="#"> <img src="/img/dataFilling.png"> 数据填报
					</a>
				</p>
			</li>
			<li>
				<p class="title" >
					<a href="/page/inputExcel.do"> <img src="/img/dataFilling.png"> 数据导入导出
					</a>
				</p>
			</li>

		</ul>
	</div>
</body>
</html>