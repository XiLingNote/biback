/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-06-19 03:03:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class inputExcel_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("  \r\n");
  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  

      out.write("  \r\n");
      out.write("<html>  \r\n");
      out.write("  <head>  \r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">  \r\n");
      out.write("\t<script src=\"/js/jquery-1.12.3.js\"></script> \r\n");
      out.write("    <title>My JSP 'index.jsp' starting page</title>  \r\n");
      out.write("    <script type=\"text/javascript\">  \r\n");
      out.write("            //ajax 方式上传文件操作  \r\n");
      out.write("             $(document).ready(function(){  \r\n");
      out.write("                $('#btn').click(function(){  \r\n");
      out.write("                    if(checkData()){  \r\n");
      out.write("                        $('#form1').ajaxSubmit({    \r\n");
      out.write("                            url:'uploadExcel/ajaxUpload.do',  \r\n");
      out.write("                            dataType: 'text',  \r\n");
      out.write("                            success: resutlMsg,  \r\n");
      out.write("                            error: errorMsg  \r\n");
      out.write("                        });   \r\n");
      out.write("                        function resutlMsg(msg){  \r\n");
      out.write("                            alert(msg);     \r\n");
      out.write("                            $(\"#upfile\").val(\"\");  \r\n");
      out.write("                        }  \r\n");
      out.write("                        function errorMsg(){   \r\n");
      out.write("                            alert(\"导入excel出错！\");      \r\n");
      out.write("                        }  \r\n");
      out.write("                    }  \r\n");
      out.write("                });  \r\n");
      out.write("             });  \r\n");
      out.write("               \r\n");
      out.write("             //JS校验form表单信息  \r\n");
      out.write("             function checkData(){  \r\n");
      out.write("                var fileDir = $(\"#upfile\").val();  \r\n");
      out.write("                var suffix = fileDir.substr(fileDir.lastIndexOf(\".\"));  \r\n");
      out.write("                if(\"\" == fileDir){  \r\n");
      out.write("                    alert(\"选择需要导入的Excel文件！\");  \r\n");
      out.write("                    return false;  \r\n");
      out.write("                }  \r\n");
      out.write("                if(\".xls\" != suffix && \".xlsx\" != suffix ){  \r\n");
      out.write("                    alert(\"选择Excel格式的文件导入！\");  \r\n");
      out.write("                    return false;  \r\n");
      out.write("                }  \r\n");
      out.write("                return true;  \r\n");
      out.write("             }  \r\n");
      out.write("    </script>   \r\n");
      out.write("  </head>  \r\n");
      out.write("    \r\n");
      out.write("  <body>  \r\n");
      out.write("  <div>1.通过简单的form表单提交方式，进行文件的上</br> 2.通过jquery.form.js插件提供的form表单一步提交功能 </div></br>  \r\n");
      out.write("    <form method=\"POST\"  enctype=\"multipart/form-data\" id=\"form1\" action=\"uploadExcel/upload.do\">  \r\n");
      out.write("        <table>  \r\n");
      out.write("         <tr>  \r\n");
      out.write("            <td>上传文件: </td>  \r\n");
      out.write("            <td> <input id=\"upfile\" type=\"file\" name=\"upfile\"></td>  \r\n");
      out.write("         </tr>  \r\n");
      out.write("        <tr>  \r\n");
      out.write("            <td><input type=\"submit\" value=\"提交\" onclick=\"return checkData()\"></td>  \r\n");
      out.write("            <td><input type=\"button\" value=\"ajax方式提交\" id=\"btn\" name=\"btn\" ></td>  \r\n");
      out.write("         </tr>  \r\n");
      out.write("        </table>    \r\n");
      out.write("    </form>  \r\n");
      out.write("      \r\n");
      out.write("  </body>  \r\n");
      out.write("</html>  ");
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