/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-06-21 10:24:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class monthlySales_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>shopSale</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"/css/bootstrap/bootstrap-datetimepicker.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("<script src=\"/js/jquery-1.12.3.js\"></script>\r\n");
      out.write("<script src=\"/js/highcharts2.js\"></script>\r\n");
      out.write("<script src=\"/js/drilldown.js\"></script>\r\n");
      out.write("<script src=\"/js/style.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- <script src=\"/js/bootstrap/bootstrap-datetimepicker.zh-CN.js\"></script> -->\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("<script src=\"/js/Highchartstheme.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction getData(type) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//set arrayList\r\n");
      out.write("\t\t$.post(\"/store/month.do\",{\"type\":type}, function(data) {\r\n");
      out.write("\t\t\tjson.series[0].data.length = 0;\r\n");
      out.write("\t\t\tjson.drilldown.series.length = 0;\r\n");
      out.write("\t\t\tif (data) {\r\n");
      out.write("\t\t\t\tvar obj = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tvar set = obj.set;\r\n");
      out.write("\t\t\t\tvar arrayList = obj.arrayList;\r\n");
      out.write("\t\t\t\t$.each(set, function(name, value) {\r\n");
      out.write("\t\t\t\t\tvar shop = decodeURI(value.shopName);\r\n");
      out.write("\t\t\t\t\tvar id = value.id;\r\n");
      out.write("\t\t\t\t\tvar options = {\r\n");
      out.write("\t\t\t\t\t\tname : 2,\r\n");
      out.write("\t\t\t\t\t\ty : 3,\r\n");
      out.write("\t\t\t\t\t\tdrilldown: 'Safari'\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\toptions.name = shop;\r\n");
      out.write("\t\t\t\t\toptions.drilldown = shop;\r\n");
      out.write("\t\t\t\t\tvar mount =  value.amount.toFixed(0);\r\n");
      out.write("\t\t\t\t\tvar amount = eval('(' + mount + ')');\r\n");
      out.write("\t\t\t\t\t\toptions.y =amount;\r\n");
      out.write("\t\t\t\t\tjson.series[0].data.push(options);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tjson.yAxis.title.text = type;\r\n");
      out.write("\t\t\t\tjson.series[0].name =type;\r\n");
      out.write("\t\t\t\t$.each(arrayList, function(name, value) {\r\n");
      out.write("\t\t\t\t\tvar options = {\r\n");
      out.write("\t\t\t\t\t\tname : 'Opera',\r\n");
      out.write("\t\t\t\t\t\tid : 'Opera',\r\n");
      out.write("\t\t\t\t\t\tdata : []\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tvar name = decodeURI(value.shopName);\r\n");
      out.write("\t\t\t\t\tvar id = value.id;\r\n");
      out.write("\t\t\t\t\toptions.id = name;\r\n");
      out.write("\t\t\t\t\toptions.name = name;\r\n");
      out.write("\t\t\t\t\tvar list = value.list;\r\n");
      out.write("\t\t\t\t\t$.each(list, function(name, value) {\r\n");
      out.write("\t\t\t\t\t\tvar da = [];\r\n");
      out.write("\t\t\t\t\t\tda.push(value.datetime);\r\n");
      out.write("\t\t\t\t\t\tif (type == \"Alipay\") {\r\n");
      out.write("\t\t\t\t\t\t\tvar ali =  value.alipay.toFixed(0);\r\n");
      out.write("\t\t\t\t\t\t\tvar alipay = eval('(' + ali + ')');\r\n");
      out.write("\t\t\t\t\t\t\tda.push(alipay);\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tvar gm =  value.gmv.toFixed(0);\r\n");
      out.write("\t\t\t\t\t\t\tvar gmv = eval('(' + gm + ')');\r\n");
      out.write("\t\t\t\t\t\t\tda.push(gmv);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tda.push(value.amount);\r\n");
      out.write("\t\t\t\t\t\toptions.data.push(da);\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tjson.drilldown.series.push(options);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"查询失败\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\".contentl\").highcharts(json);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar b = true;\r\n");
      out.write("\tvar time = 10000;\r\n");
      out.write("\tfunction date() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (b) {\r\n");
      out.write("\t\t\tgetData(\"Alipay\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tgetData(\"GMV\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tb = !b;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar json = {\r\n");
      out.write("\t\tchart : {\r\n");
      out.write("\t\t\ttype : 'column'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ttitle : {\r\n");
      out.write("\t\t\ttext : '当月销售排行'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tsubtitle : {\r\n");
      out.write("\t\t\ttext : 'Month Sales Rank'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\txAxis : {\r\n");
      out.write("\t\t\ttype : 'category'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tyAxis : {\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : 'GMV'\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tlegend : {\r\n");
      out.write("\t\t\tenabled : false\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tplotOptions : {\r\n");
      out.write("\t\t\tseries : {\r\n");
      out.write("\t\t\t\tborderWidth : 0,\r\n");
      out.write("\t\t\t\tdataLabels : {\r\n");
      out.write("\t\t\t\t\tenabled : true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\ttooltip : {\r\n");
      out.write("\t\t\tshared : true,\r\n");
      out.write("\t\t\tstyle : { //提示框内容的样式\r\n");
      out.write("\t\t\t\tcolor : 'pink',\r\n");
      out.write("\t\t\t\tpadding : '10px', //内边距 (这个会常用到)\r\n");
      out.write("\t\t\t\tfontSize : '9pt',\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tseries : [ {\r\n");
      out.write("\t\t\tname : 'GMV',\r\n");
      out.write("\t\t\t//颜色\r\n");
      out.write("\t\t\t//\t\t\tcolorByPoint : true,\r\n");
      out.write("\t\t\tdata : [/*  {\r\n");
      out.write("\t\t\t\t\t\t\tname : 'Firefox',\r\n");
      out.write("\t\t\t\t\t\t\ty : 10.38,\r\n");
      out.write("\t\t\t\t\t\t\tdrilldown : 'Firefox'\r\n");
      out.write("\t\t\t\t\t\t} */]\r\n");
      out.write("\t\t} ],\r\n");
      out.write("\t\tdrilldown : {\r\n");
      out.write("\t\t\tseries : [ /* {\r\n");
      out.write("\t\t\t\t\t\tname : 'Firefox',\r\n");
      out.write("\t\t\t\t\t\tid : 'Firefox',\r\n");
      out.write("\t\t\t\t\t\tdata : [ [ 'v35', 2.76 ], [ 'v36', 2.32 ], [ 'v37', 2.31 ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'v34', 1.27 ], [ 'v38', 1.02 ], [ 'v31', 0.33 ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'v33', 0.22 ], [ 'v32', 0.15 ] ]\r\n");
      out.write("\t\t\t\t\t}  */]\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t/*定时器*/\r\n");
      out.write("\t\t   var timmer = setInterval(date, time);  \r\n");
      out.write("\t\t // Alipay  GMV\r\n");
      out.write("\t\t \r\n");
      out.write("\t\tgetData(\"GMV\");\r\n");
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
      out.write("\t<div class=\"contentl\"\r\n");
      out.write("\t\tstyle=\"width: 80%; height: 600px; position: relative; top: 10%; left: 15%; background: #5b5b5b\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
