/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-06-19 01:40:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>index</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"/css/bootstrap/bootstrap-datetimepicker.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("<!-- <script src=\"/js/jquery-1.12.3.js\"></script> -->\r\n");
      out.write("<script src=\"/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("<script src=\"/js/highcharts.js\"></script>\r\n");
      out.write("<script src=\"/js/style.js\"></script>\r\n");
      out.write("<script src=\"/js/scientific.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-datetimepicker.zh-CN.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("<script src=\"/js/Highchartstheme.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tvar unit = 1000;\r\n");
      out.write("\tfunction value() {\r\n");
      out.write("\t\t$('#s1>input[name = begin ]').val(null);\r\n");
      out.write("\t\t$('#s1>input[name = end ]').val(null);\r\n");
      out.write("\t\t$('#s2>input[name = begin ]').val(null);\r\n");
      out.write("\t\t$('#s2>input[name = end ]').val(null);\r\n");
      out.write("\t\t$('#s3>input[name = begin ]').val(null);\r\n");
      out.write("\t\t$('#s3>input[name = end ]').val(null);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//\"begin\" : begin, \"end\" : end, \"type\" : type,  \"department\" : department\r\n");
      out.write("\tfunction getDate(datetype, begin, end, department, type) {\r\n");
      out.write("\t\tvar unitE = null;\r\n");
      out.write("\t\tif (datetype == \"DAY\") {\r\n");
      out.write("\t\t\tunit = 1000;\r\n");
      out.write("\t\t\tunitE = 'K';\r\n");
      out.write("\t\t\tjson.yAxis[0].labels.format = '{value}k';\r\n");
      out.write("\t\t\tjson.series[1].tooltip.valueSuffix = 'K';\r\n");
      out.write("\t\t\tjson.series[2].tooltip.valueSuffix = 'K';\r\n");
      out.write("\t\t} else if (datetype == \"MONTH\") {\r\n");
      out.write("\t\t\tunit = 1000000;\r\n");
      out.write("\t\t\tunitE = 'M';\r\n");
      out.write("\t\t\tjson.yAxis[0].labels.format = '{value}M';\r\n");
      out.write("\t\t\tjson.series[1].tooltip.valueSuffix = 'M';\r\n");
      out.write("\t\t\tjson.series[2].tooltip.valueSuffix = 'M';\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tunit = 1000000000;\r\n");
      out.write("\t\t\tunitE = 'G';\r\n");
      out.write("\t\t\tjson.yAxis[0].labels.format = '{value}G';\r\n");
      out.write("\t\t\tjson.series[1].tooltip.valueSuffix = 'G';\r\n");
      out.write("\t\t\tjson.series[2].tooltip.valueSuffix = 'G';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjson.title.text = type;\r\n");
      out.write("\r\n");
      out.write("\t\t$.post(\"/overall/sale.do\", {\r\n");
      out.write("\t\t\t\"datetype\" : datetype,\r\n");
      out.write("\t\t\t\"begin\" : begin,\r\n");
      out.write("\t\t\t\"end\" : end,\r\n");
      out.write("\t\t\t\"department\" : department\r\n");
      out.write("\t\t}, function(data) {\r\n");
      out.write("\t\t\tvar amounts = [];\r\n");
      out.write("\t\t\tvar targets = [];\r\n");
      out.write("\t\t\tvar categories = [];\r\n");
      out.write("\t\t\tvar completion = [];\r\n");
      out.write("\t\t\tvar gc = 0.0;\r\n");
      out.write("\t\t\tvar gt = 0.0;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar ac = 0.0;\r\n");
      out.write("\t\t\tvar at = 0.0;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar lastgrate = 0.0;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar lastarate = 0.0;\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (data) {\r\n");
      out.write("\t\t\t\tvar obj = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tvar pojo = obj.treeSet;\r\n");
      out.write("\t\t\t\tvar last = obj.last;\r\n");
      out.write("\t\t\t\tif (last) {\r\n");
      out.write("\t\t\t\t\tlastgrate = ((last.gmv / last.target) * 100).toFixed(1);\r\n");
      out.write("\t\t\t\t\tlastarate = ((last.alipay / last.alipayTarget) * 100)\r\n");
      out.write("\t\t\t\t\t\t\t.toFixed(1);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$\r\n");
      out.write("\t\t\t\t\t\t.each(pojo,\r\n");
      out.write("\t\t\t\t\t\t\t\tfunction(name, value) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (type == \"Alipay\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgc = gc + value.gmv;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgt = gt + value.target;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tac = ac + value.alipay;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tat = at + value.alipayTarget;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar amount = eval('('\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ (value.alipay / unit)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t.toFixed(1) + ')');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tamounts.push(amount);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcategories.push(value.datetime);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar target = eval('('+ (value.alipayTarget / unit).toFixed(1) + ')');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttargets.push(target);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar com = value.alipayCompleteness;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar comp = eval('('+(com * 100).toFixed(2)+ ')');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcompletion.push(comp);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgc = gc + value.gmv;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tac = ac + value.alipay;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgt = gt + value.target;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tat = at + value.alipayTarget;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar amoun = value.gmv;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar amount = eval('('+ (amoun / unit).toFixed(2)+ ')');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tamounts.push(amount);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcategories.push(value.datetime);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar target = eval('('+ (value.target / unit)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t.toFixed(2) + ')');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttargets.push(target);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar com = value.completeness;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar comp = eval('('+(com * 100).toFixed(2)+ ')');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcompletion.push(comp);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\tif (categories.length > 60) {\r\n");
      out.write("\t\t\t\t\tjson.xAxis[0].tickInterval = 6;\r\n");
      out.write("\t\t\t\t} else if (categories.length > 30) {\r\n");
      out.write("\t\t\t\t\tjson.xAxis[0].tickInterval = 3;\r\n");
      out.write("\t\t\t\t} else if (categories.length > 15) {\r\n");
      out.write("\t\t\t\t\tjson.xAxis[0].tickInterval = 2;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tjson.xAxis[0].categories = categories;\r\n");
      out.write("\t\t\t\t// 完成率 ，目标  完成\r\n");
      out.write("\t\t\t\tjson.series[0].data = completion;\r\n");
      out.write("\t\t\t\tjson.series[1].data = targets;\r\n");
      out.write("\t\t\t\tjson.series[2].data = amounts;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tgc = eval('(' + (gc / unit).toFixed(0) + ')');\r\n");
      out.write("\t\t\t\tvar showgc = formatNum(gc);\r\n");
      out.write("\t\t\t\t//\t\tgc = eval('(' + (gc / unit).toFixed(0) + ')');\r\n");
      out.write("\t\t\t\t$(\"#gc\").text(showgc);\r\n");
      out.write("\t\t\t\tvar showgt = formatNum(gt);\r\n");
      out.write("\t\t\t\t//\t\t\tgt = eval('(' + (gt / unit).toFixed(0) + ')');\r\n");
      out.write("\t\t\t\t$(\"#gt\").text(showgt);\r\n");
      out.write("\t\t\t\tvar grate;\r\n");
      out.write("\t\t\t\tif (gt > 0) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tgrate = (gc / gt * 100).toFixed(1);\r\n");
      out.write("\t\t\t\t\tif (grate) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#grate\").text(grate + '%');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (lastgrate) {\r\n");
      out.write("\t\t\t\t\tif (lastgrate / grate > 1) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#gy2\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#gy1\").attr(\"hidden\", \"true\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#gys\").text(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"↓（\" + (lastgrate - grate).toFixed(1) + \"％)\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (lastgrate / grate < 1) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#gy1\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#gy2\").attr(\"hidden\", \"true\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#gya\").text(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"↑\" + (grate - lastgrate).toFixed(1) + \"％\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tac = eval('(' + (ac / unit).toFixed(0) + ')');\r\n");
      out.write("\t\t\t\tvar showac = formatNum(ac);\r\n");
      out.write("\t\t\t\t$(\"#ac\").text(showac+unitE);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar showat = formatNum(at+unitE);\r\n");
      out.write("\t\t\t\t$(\"#at\").text(showat);\r\n");
      out.write("\t\t\t\tvar arate;\r\n");
      out.write("\t\t\t\tif (at > 0) {\r\n");
      out.write("\t\t\t\t\tarate = (ac / at * 100).toFixed(1);\r\n");
      out.write("\t\t\t\t\tif (arate) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#arate\").text(arate + '%');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (lastarate) {\r\n");
      out.write("\t\t\t\t\tif (lastarate / arate > 1) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#ay2\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#ay1\").attr(\"hidden\", \"true\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#ays\").text(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"↓（\" + (lastarate - arate).toFixed(1) + \"％)\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (lastarate / arate < 1) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#ay1\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#ay2\").attr(\"hidden\", \"true\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#aya\").text(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"↑\" + (arate - lastarate).toFixed(1) + \"％\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"参数错误\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\".contentl\").highcharts(json);\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\tweekStart : 1,\r\n");
      out.write("\t\ttodayBtn : 1,\r\n");
      out.write("\t\tautoclose : 1,\r\n");
      out.write("\t\ttodayHighlight : 1,\r\n");
      out.write("\t\tstartView : 2,\r\n");
      out.write("\t\tminView : 2,\r\n");
      out.write("\t\tlanguage : 'zh-CN',\r\n");
      out.write("\t\tformat : 'dd/MM/yyyy',\r\n");
      out.write("\t\tforceParse : 0\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tvar json = {\r\n");
      out.write("\t\tchart : {\r\n");
      out.write("\t\t\tzoomType : 'xy'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ttitle : {\r\n");
      out.write("\t\t\ttext : 'ＧMV'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tsubtitle : {\r\n");
      out.write("\t\t\ttext : '数据来源：ＢＩ'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\txAxis : [ { // Ajax后台数据  X轴数据\r\n");
      out.write("\t\t\tcategories : [],\r\n");
      out.write("\t\t\tcrosshair : true,\r\n");
      out.write("\t\t\t//X轴每隔几个显示一个\r\n");
      out.write("\t\t\ttickInterval : 1,\r\n");
      out.write("\t\t\tfloor : 3\r\n");
      out.write("\t\t/*   labels: {\r\n");
      out.write("\t\t  \trotation: -30\r\n");
      out.write("\t\t  } */\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t\tyAxis : [ { // Primary yAxis\r\n");
      out.write("\t\t\tlabels : {\r\n");
      out.write("\t\t\t\tformat : '{value}M',\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tcolor : Highcharts.getOptions().colors[6]\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : '金额',\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tcolor : Highcharts.getOptions().colors[6]\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, { // Secondary yAxis\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : '完成率',\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tcolor : Highcharts.getOptions().colors[4]\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tlabels : {\r\n");
      out.write("\t\t\t\tformat : '{value} ％',\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tcolor : Highcharts.getOptions().colors[0]\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\topposite : true\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t\ttooltip : {\r\n");
      out.write("\t\t\tshared : true,\r\n");
      out.write("\t\t\tstyle : { //提示框内容的样式\r\n");
      out.write("\t\t\t\tcolor : 'pink',\r\n");
      out.write("\t\t\t\tpadding : '10px', //内边距 (这个会常用到)\r\n");
      out.write("\t\t\t\tfontSize : '9pt',\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tlegend : {\r\n");
      out.write("\t\t\tlayout : 'vertical',\r\n");
      out.write("\t\t\talign : 'left',\r\n");
      out.write("\t\t\tx : 120,\r\n");
      out.write("\t\t\tverticalAlign : 'top',\r\n");
      out.write("\t\t\tfloating : true,\r\n");
      out.write("\t\t\ty : 100,\r\n");
      out.write("\t\t\tfloating : true\r\n");
      out.write("\t\t}, // Ajax后台数据 \r\n");
      out.write("\t\tseries : [ { // 内部有个List集合（）\r\n");
      out.write("\t\t\tname : '完成率',\r\n");
      out.write("\t\t\ttype : 'spline',\r\n");
      out.write("\t\t\tyAxis : 1,\r\n");
      out.write("\t\t\tdata : [],\r\n");
      out.write("\t\t\ttooltip : {\r\n");
      out.write("\t\t\t\tvalueSuffix : '％'\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tname : '目标',\r\n");
      out.write("\t\t\ttype : 'areaspline',\r\n");
      out.write("\t\t\tcolor : '#66cdaa',\r\n");
      out.write("\t\t\tdata : [],\r\n");
      out.write("\t\t\ttooltip : {\r\n");
      out.write("\t\t\t\tvalueSuffix : ''\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tname : '完成',\r\n");
      out.write("\t\t\tcolor : '#7F7876',\r\n");
      out.write("\t\t\ttype : 'areaspline',\r\n");
      out.write("\t\t\tdata : [],\r\n");
      out.write("\t\t\ttooltip : {\r\n");
      out.write("\t\t\t\tvalueSuffix : ''\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} ]\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"input[name='datetype']:last\").attr(\"checked\", true);\r\n");
      out.write("\t\tjson.series[1].tooltip.valueSuffix = 'k';\r\n");
      out.write("\t\tjson.series[2].tooltip.valueSuffix = 'k';\r\n");
      out.write("\t\tvar begin;\r\n");
      out.write("\t\tvar end;\r\n");
      out.write("\t\tvar datetype = \"DAY\";\r\n");
      out.write("\t\tvar department;\r\n");
      out.write("\t\tgetDate(datetype, begin, end, department, \"GMV\");\r\n");
      out.write("\r\n");
      out.write("\t\t/*  $(\".content_top\").mouseenter(function() {\r\n");
      out.write("\t\t getDate(datetype, begin, end, department, \"GMV\");\r\n");
      out.write("\t\t });\r\n");
      out.write("\r\n");
      out.write("\t\t $(\".content_bottom\").mouseenter(function() {\r\n");
      out.write("\t\t getDate(datetype, begin, end, department, \"Alipay\");\r\n");
      out.write("\t\t });  */\r\n");
      out.write("\r\n");
      out.write("\t\t/*年日期选项   */\r\n");
      out.write("\t\toptions.minView = 4;\r\n");
      out.write("\t\toptions.startView = 4;\r\n");
      out.write("\t\toptions.format = \"yyyy\";\r\n");
      out.write("\t\t$('#s1>input[name = begin ]').datetimepicker(options);\r\n");
      out.write("\t\t$('#s1>input[name = end ]').datetimepicker(options);\r\n");
      out.write("\t\t/*月日期选项   */\r\n");
      out.write("\t\toptions.minView = 3;\r\n");
      out.write("\t\toptions.startView = 3;\r\n");
      out.write("\t\toptions.format = \"yyyy/MM\";\r\n");
      out.write("\t\t$('#s2>input[name = begin ]').datetimepicker(options);\r\n");
      out.write("\t\t$('#s2>input[name = end ]').datetimepicker(options);\r\n");
      out.write("\t\t/*日日期选项   */\r\n");
      out.write("\t\toptions.minView = 2;\r\n");
      out.write("\t\toptions.startView = 2;\r\n");
      out.write("\t\toptions.format = \"yyyy/MM/dd\";\r\n");
      out.write("\t\t$('#s3>input[name = begin ]').datetimepicker(options);\r\n");
      out.write("\t\t$('#s3>input[name = end ]').datetimepicker(options);\r\n");
      out.write("\r\n");
      out.write("\t\t$('#s1>input[name = begin ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tbegin = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$('#s1>input[name = end ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tend = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$('#s2>input[name = begin ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tbegin = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$('#s2>input[name = end ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tend = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$('#s3>input[name = begin ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tbegin = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$('#s3>input[name = end ]').datetimepicker().on('changeDate',\r\n");
      out.write("\t\t\t\tfunction(ev) {\r\n");
      out.write("\t\t\t\t\tend = ev.date;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"input[name='datetype']\").change(function() {\r\n");
      out.write("\t\t\tbegin = null;\r\n");
      out.write("\t\t\tend = null;\r\n");
      out.write("\t\t\t// 清空日期选择框的值\r\n");
      out.write("\t\t\tvalue();\r\n");
      out.write("\t\t\tvar type = $(\"input[name='datetype']:checked\").val();\r\n");
      out.write("\t\t\tif (type == \"YEAR\") {\r\n");
      out.write("\t\t\t\t$(\"#s1\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t$(\"#s2\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t\t$(\"#s3\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (type == \"MONTH\") {\r\n");
      out.write("\t\t\t\t$(\"#s2\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t$(\"#s1\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t\t$(\"#s3\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (type == \"DAY\") {\r\n");
      out.write("\t\t\t\t$(\"#s3\").removeAttr(\"hidden\");\r\n");
      out.write("\t\t\t\t$(\"#s2\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t\t$(\"#s1\").attr(\"hidden\", true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#go\").click(function() {\r\n");
      out.write("\t\t\tdepartment = $('.sort option:selected').val();//选中的值\r\n");
      out.write("\t\t\tvar type = $('.sort1 option:selected').val();//选中的值\r\n");
      out.write("\t\t\tdatetype = $(\"input[name='datetype']:checked\").val();\r\n");
      out.write("\t\t\tif (!type) {\r\n");
      out.write("\t\t\t\talert(\"请选择查询的是GMV还是Alipay!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (!department) {\r\n");
      out.write("\t\t\t\talert(\"部门不能为空!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!datetype) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\talert(\"请选择日期类型!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tgetDate(datetype, begin, end, department, type);\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".body {\r\n");
      out.write("\tcolor: #2a2a2b\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/page/top.do", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/page/left.do", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<select class=\"sort\" name=\"department\">\r\n");
      out.write("\t\t<option></option>\r\n");
      out.write("\t\t<option value=\"All\">All</option>\r\n");
      out.write("\t\t<option value=\"Bag\">Bag</option>\r\n");
      out.write("\t\t<option value=\"Shoes\">Shoes</option>\r\n");
      out.write("\t\t<option value=\"Dress\">Dress</option>\r\n");
      out.write("\t\t<option value=\"TMhk\">TMhk</option>\r\n");
      out.write("\t\t<option value=\"ACC\">ACC</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\r\n");
      out.write("\t<select class=\"sort1\">\r\n");
      out.write("\t\t<option></option>\r\n");
      out.write("\t\t<option value=\"GMV\">GMV</option>\r\n");
      out.write("\t\t<option value=\"Alipay\">Alipay</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<!------\r\n");
      out.write("\r\n");
      out.write("------------------->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<form action=\"\" class=\"form-horizontal\" role=\"form\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"ff\"\r\n");
      out.write("\t\t\t\tstyle=\"position: absolute; top: 10%; left: 28%; width: 30%\">\r\n");
      out.write("\t\t\t\t<div id=\"s1\" hidden='true'>\r\n");
      out.write("\t\t\t\t\t<input name=\"begin\" style=\"height: 40px; width: 40%\" /> <input\r\n");
      out.write("\t\t\t\t\t\tname=\"end\" style=\"height: 40px; width: 40%\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"s2\" hidden='true'>\r\n");
      out.write("\t\t\t\t\t<input name=\"begin\" style=\"height: 40px; width: 40%\" /> <input\r\n");
      out.write("\t\t\t\t\t\tname=\"end\" style=\"height: 40px; width: 40%\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"s3\">\r\n");
      out.write("\t\t\t\t\t<input name=\"begin\" style=\"height: 40px; width: 40%\" /> <input\r\n");
      out.write("\t\t\t\t\t\tname=\"end\" style=\"height: 40px; width: 40%\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"an\" style=\"position: absolute; left: 15%\">\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"datetype\" value=\"YEAR\" />y <input\r\n");
      out.write("\t\t\t\ttype=\"radio\" name=\"datetype\" value=\"MONTH\" /> m <input type=\"radio\"\r\n");
      out.write("\t\t\t\tname=\"datetype\" value=\"DAY\" /> d\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<input type=\"button\" id=\"go\" value=\"查询\" />\r\n");
      out.write("\t<!--------以下数据框----------->\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"width: 15%; height: 600px; background: #696969; position: absolute; top: 20%; left: 12%\">\r\n");
      out.write("\t\t<div class=\"content_top\"\r\n");
      out.write("\t\t\tstyle=\"width: 100%; height: 50%; background: #898989; position: absolute\">\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC; font-size: 20px\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;GMV </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Completeness:</span>\r\n");
      out.write("\t\t\t\t<span id=\"gc\" style=\"color: #FFF8DC\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Target:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"gt\" style=\"color: #FFF8DC\"> </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Completion\r\n");
      out.write("\t\t\t\t\trate: </span> <span id=\"grate\" style=\"color: #FFF8DC\"> </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"gy1\" style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;YoY:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"gya\" style=\"color: green\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"gy2\" style=\"height: 20%; background: #3e3e40;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;YoY:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"gys\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"content_bottom\"\r\n");
      out.write("\t\t\tstyle=\"width: 100%; height: 50%; background: #66cdaa; position: absolute; top: 50%\">\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC; font-size: 20px\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;Alipay </span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Completeness:</span>\r\n");
      out.write("\t\t\t\t<span id=\"ac\" style=\"color: #FFF8DC\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Target:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"at\" style=\"color: #FFF8DC\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;Completion\r\n");
      out.write("\t\t\t\t\trate: </span> <span id=\"arate\" style=\"color: #FFF8DC\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"ay1\" hidden=\"true\" style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;YoY:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"aya\" style=\"color: green\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"ay2\" style=\"height: 20%; background: #2a2a2b;\">\r\n");
      out.write("\t\t\t\t<span style=\"color: #FFF8DC\">&nbsp;&nbsp;&nbsp;YoY:</span> <span\r\n");
      out.write("\t\t\t\t\tid=\"ays\" style=\"color: red\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"contentl\"\r\n");
      out.write("\t\tstyle=\"width: 65%; height: 600px; position: relative; top: 20%; left: 27%; background: #5b5b5b\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}