/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-06-21 10:00:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class tableTest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"/assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/src/bootstrap-table.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"docs.css\">\r\n");
      out.write("\r\n");
      out.write("    <script src=\"/assets/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"/assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"/docs/examples.js\"></script>\r\n");
      out.write("    <script src=\"/src/bootstrap-table.js\"></script>\r\n");
      out.write("    <script src=\"docs.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function(){\r\n");
      out.write("            //调用函数，初始化表格\r\n");
      out.write("            initTable();\r\n");
      out.write("        });\r\n");
      out.write("        function initTable() {\r\n");
      out.write("            //先销毁表格\r\n");
      out.write("            $('#tablelist').bootstrapTable('destroy');\r\n");
      out.write("            //初始化表格,动态从服务器加载数据\r\n");
      out.write("            $(\"#tablelist\").bootstrapTable({\r\n");
      out.write("                // method: \"POST\",  //使用get请求到服务器获取数据\r\n");
      out.write("                url: \"/target/queryDailyTarget.do\", //获取数据的Servlet地址\r\n");
      out.write("                striped: true,  //表格显示条纹\r\n");
      out.write("                pagination: true, //启动分页\r\n");
      out.write("                pageSize: 10,  //每页显示的记录数\r\n");
      out.write("                pageNumber:1, //当前第几页\r\n");
      out.write("                pageList: [10, 25, 50, 100],  //记录数可选列表\r\n");
      out.write("                search: false,  //是否启用查询\r\n");
      out.write("                showColumns: false,  //显示下拉框勾选要显示的列\r\n");
      out.write("                showRefresh: true,  //显示刷新按钮\r\n");
      out.write("                showExport: true,\r\n");
      out.write("                sidePagination: \"server\", //表示服务端请求\r\n");
      out.write("                toolbar: '#toolbar',\r\n");
      out.write("                exportDataType: \"all\",\r\n");
      out.write("                height : 550, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度\r\n");
      out.write("                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder\r\n");
      out.write("                //设置为limit可以获取limit, offset, search, sort, order\r\n");
      out.write("                queryParamsType : \"undefined\",\r\n");
      out.write("                columns:[\r\n");
      out.write("                    {\r\n");
      out.write("                        title:'全选',\r\n");
      out.write("                        field:'select',\r\n");
      out.write("                        //复选框\r\n");
      out.write("                        checkbox:true,\r\n");
      out.write("                        width:25,\r\n");
      out.write("                        align:'center',\r\n");
      out.write("                        valign:'middle'\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        title:'ID',\r\n");
      out.write("                        field:'id',\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        title:'店铺',\r\n");
      out.write("                        field:'storename',\r\n");
      out.write("                        sortable:true\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        title:'日期',\r\n");
      out.write("                        field:'date',\r\n");
      out.write("                        sortable:true,\r\n");
      out.write("                        editable:true\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        title:'计划数',\r\n");
      out.write("                        field:'payment',\r\n");
      out.write("                        editable:true\r\n");
      out.write("                    }\r\n");
      out.write("                ],\r\n");
      out.write("                queryParams: function queryParams(param) {   //设置查询参数\r\n");
      out.write("                    var param = {\r\n");
      out.write("                        page:this.pageNumber,\r\n");
      out.write("                        limit:this.pageSize,\r\n");
      out.write("                    };\r\n");
      out.write("                    return param;\r\n");
      out.write("                },\r\n");
      out.write("                onLoadError: function(){  //加载失败时执行\r\n");
      out.write("                    alert(\"加载数据失败\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<a class=\"sr-only\" href=\"#content\">Skip to main content</a>\r\n");
      out.write("<header class=\"navbar navbar-inverse navbar-fixed-top bs-docs-nav\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.html\">\r\n");
      out.write("                Bootstrap Table\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <nav class=\"collapse navbar-collapse bs-navbar-collapse\" role=\"navigation\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"getting-started.html\">Getting started</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"documentation.html\">Documentation</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"active\">\r\n");
      out.write("                    <a href=\"examples.html\">Examples</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("<div class=\"bs-header\" id=\"content\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Examples</h1>\r\n");
      out.write("        <p>The examples of bootstrap table.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-3\">\r\n");
      out.write("            <div class=\"bs-sidebar\" role=\"complementary\">\r\n");
      out.write("                <ul class=\"nav bs-sidenav\">\r\n");
      out.write("                    <li><a href=\"#basic-table\">Basic Table</a></li>\r\n");
      out.write("                    <li><a href=\"#transform-table\">Transform Table</a></li>\r\n");
      out.write("                    <li><a href=\"#classes-table\">Table Style</a></li>\r\n");
      out.write("                    <li><a href=\"#sort-table\">Sort Table</a></li>\r\n");
      out.write("                    <li><a href=\"#custom-sort-table\">Custom Sort Table</a></li>\r\n");
      out.write("                    <li><a href=\"#radio-table\">Radio Table</a></li>\r\n");
      out.write("                    <li><a href=\"#checkbox-table\">Checkbox Table</a></li>\r\n");
      out.write("                    <li><a href=\"#pagination-table\">Pagination Table</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-9\" role=\"main\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <div class=\"page-header\">\r\n");
      out.write("                    <h1 id=\"pagination-table\">Pagination Table</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("             \r\n");
      out.write("                <div class=\"highlight\"><pre><code class=\"language-html\"></code></pre></div>\r\n");
      out.write("            </div>\r\n");
      out.write("           <table class=\"table table-hover\" id=\"tablelist\"  \r\n");
      out.write("       data-pagination=\"true\"  \r\n");
      out.write("       data-show-refresh=\"true\"  \r\n");
      out.write("       data-show-toggle=\"true\"  \r\n");
      out.write("       data-showColumns=\"true\">  \r\n");
      out.write("       <tbody>  \r\n");
      out.write("       </tbody>  \r\n");
      out.write("</table>     \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
