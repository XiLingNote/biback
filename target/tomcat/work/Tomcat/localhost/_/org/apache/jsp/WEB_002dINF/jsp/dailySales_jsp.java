/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-06-19 01:42:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dailySales_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script src=\"/js/highcharts.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-datetimepicker.zh-CN.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("<script src=\"/js/Highchartstheme.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction getData(date, type) {\r\n");
      out.write("\r\n");
      out.write("\t\t$.post(\"/store/daily.do\", {\r\n");
      out.write("\t\t\t\"date\" : date,\r\n");
      out.write("\t\t\t\"type\" : type\r\n");
      out.write("\t\t}, function(data) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tjson.subtitle.text = type;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (data) {\r\n");
      out.write("\t\t\t\tvar obj = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tvar set = obj.set;\r\n");
      out.write("\t\t\t\tvar arrayList = obj.arrayList;\r\n");
      out.write("\t\t\t\tjson.series[0].data.length = 0;\r\n");
      out.write("\t\t\t\t$.each(set, function(name, value) {\r\n");
      out.write("\t\t\t\t\tvar name = decodeURI(value.shopName);\r\n");
      out.write("\t\t\t\t\tvar da = [];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tda.push(name);\r\n");
      out.write("\t\t\t\t\tda.push(value.amount);\r\n");
      out.write("\t\t\t\t\tjson.series[0].data.push(da);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"查询失败\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\".contentl\").highcharts(json);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar json = {\r\n");
      out.write("\t\tchart : {\r\n");
      out.write("\t\t\ttype : 'column'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ttitle : {\r\n");
      out.write("\t\t\ttext : 'daily sales'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tsubtitle : {\r\n");
      out.write("\t\t\ttext : ''\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\txAxis : {\r\n");
      out.write("\t\t\ttype : 'category',\r\n");
      out.write("\t\t\tlabels : {\r\n");
      out.write("\t\t\t\trotation : -45,\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tfontSize : '13px',\r\n");
      out.write("\t\t\t\t\tfontFamily : 'Verdana, sans-serif'\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tyAxis : {\r\n");
      out.write("\t\t\tmin : 0,\r\n");
      out.write("\t\t\ttitle : {\r\n");
      out.write("\t\t\t\ttext : 'amount'\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tlegend : {\r\n");
      out.write("\t\t\tenabled : false\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\ttooltip : {\r\n");
      out.write("\t\t\tshared : true,\r\n");
      out.write("\t\t\tstyle : { //提示框内容的样式\r\n");
      out.write("\t\t\t\tcolor : 'pink',\r\n");
      out.write("\t\t\t\tpadding : '10px', //内边距 (这个会常用到)\r\n");
      out.write("\t\t\t\tfontSize : '9pt',\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tseries : [ {\r\n");
      out.write("\t\t\tname : 'amount',\r\n");
      out.write("\t\t\tdata : [ /* [ '上海', 24.25 ]  */],\r\n");
      out.write("\t\t/* \tdataLabels : {\r\n");
      out.write("\t\t\t\tenabled : true,\r\n");
      out.write("\t\t\t\trotation : -90,\r\n");
      out.write("\t\t\t\tcolor : '#FFFFFF',\r\n");
      out.write("\t\t\t\talign : 'right',\r\n");
      out.write("\t\t\t\tformat : '{point.y:.1f}', // one decimal\r\n");
      out.write("\t\t\t\ty : 10, // 10 pixels down from the top\r\n");
      out.write("\t\t\t\tstyle : {\r\n");
      out.write("\t\t\t\t\tfontSize : '13px',\r\n");
      out.write("\t\t\t\t\tfontFamily : 'Verdana, sans-serif'\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\t\t} ]\r\n");
      out.write("\t};\r\n");
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
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar end;\r\n");
      out.write("\t\t$(\"#date\").datetimepicker(options);\r\n");
      out.write("\t\t$('#date').datetimepicker().on('changeDate', function(ev) {\r\n");
      out.write("\t\t\tend = ev.date;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tgetData(null, \"GMV\");\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#go\").click(function() {\r\n");
      out.write("\t\t\tvar type = $('.selectType option:selected').val();//选中的值\r\n");
      out.write("\t\t\tif (type != \"GMV\" && type != \"Alipay\") {\r\n");
      out.write("\t\t\t\talert(\"请选择查询的是GMV还是Alipay!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tgetData(end, type);\r\n");
      out.write("\t\t});\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/page/top.do", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/page/left.do", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"dailydate\">\r\n");
      out.write("\t\t<form action=\"\" class=\"form-horizontal\" role=\"form\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<select class=\"selectType\" style=\"position: absolute; top: 10%; left: 45%; width: 10%;height:40px\">\r\n");
      out.write("\t\t\t\t<option></option>\r\n");
      out.write("\t\t\t\t<option value=\"GMV\">GMV</option>\r\n");
      out.write("\t\t\t\t<option value=\"Alipay\">Alipay</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"ff\"\r\n");
      out.write("\t\t\t\tstyle=\"position: absolute; top: 10%; left: 60%; width: 30%\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input id=\"date\" style=\"height: 40px; width: 40%\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<input type=\"button\" id=\"go\" value=\"查询\" />\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"contentl\"\r\n");
      out.write("\t\tstyle=\"width: 80%; height: 600px; position: relative; top: 20%; left: 15%; background: #5b5b5b\">\r\n");
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