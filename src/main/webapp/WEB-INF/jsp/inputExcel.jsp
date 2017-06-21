<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/page/top.do"></jsp:include>
	<jsp:include page="/page/left.do"></jsp:include>
</head>
<script src="//rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js"></script>
<link href="/css/bootstrap/bootstrap-editable.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
<link href="/css/bootstrap/bootstrap-table.css" rel="stylesheet" type="text/css"> 
    
</head>
<body>
<div style="margin-left: 10%">
<div>
  <form method="POST"  enctype="multipart/form-data" id="form1" action="uploadExcel/upload.do">  
        <table>  
         <tr>  
            <td>上传文件: </td>  
            <td> <input id="upfile" type="file" name="upfile"></td>  
         </tr>  
        <tr>  
            <td><input type="submit" value="提交" onclick="return checkData()"></td>  
            <td><input type="button" value="ajax方式提交" id="btn" name="btn" ></td>  
         </tr>  
        </table>    
    </form> 
    
    <form method="POST"  enctype="multipart/form-data" id="form2" action="target/exportDailyTarget.do">  
        <table>  
        <tr>  
            <td><input type="submit" value="导出" onclick="sub()"></td>  
         </tr>  
        </table>    
    </form> 
    </div>
<table class="table table-hover" id="cusTable"  
       data-pagination="true"  
       data-show-refresh="true"  
       data-show-toggle="true"  
       data-showColumns="true"> 
</table>  
</div>
</body>
   <script src="/js/jquery-1.8.3.min.js"></script>  
<script src="/js/jquery.form-3.51.0.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>  
<script src="/js/bootstrap/bootstrap-table.min.js"></script>  
<script  src="/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<script src="/js/bootstrap/bootstrap-editable.js"></script>
<script src="/js/bootstrap/bootstrap-table-editable.js"></script>
<script>
        $(document).ready(function(){
        	initTable();
        	 $('#btn').click(function(){  
        		 
        		 if(checkData()){  
                     $('#form1').ajaxSubmit({    
                         url:'target/uploadDailyTarget.do',  
                         dataType: 'text',  
                         success: resutlMsg,  
                         error: errorMsg  
                     });   
                     function resutlMsg(msg){  
                         alert(msg);     
                         $("#upfile").val("");  
                     }  
                     function errorMsg(){   
                         alert("导入excel出错！");      
                     }  
                 }  
             });  
            //调用函数，初始化表格
           
        });
        function initTable() {
            //先销毁表格
            $('#cusTable').bootstrapTable('destroy');
            //初始化表格,动态从服务器加载数据
            $("#cusTable").bootstrapTable({
                // method: "POST",  //使用get请求到服务器获取数据
                url: "target/queryDailyTarget.do", //获取数据的Servlet地址
                striped: true,  //表格显示条纹
                pagination: true, //启动分页
                pageSize: 10,  //每页显示的记录数
                pageNumber:1, //当前第几页
                pageList: [10, 25, 50, 100],  //记录数可选列表
                search: false,  //是否启用查询
                showColumns: false,  //显示下拉框勾选要显示的列
                showRefresh: true,  //显示刷新按钮
                showExport: true,
                sidePagination: "server", //表示服务端请求
                exportDataType: "all",
                height : 550, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                queryParamsType : "undefined",
                columns:[
                    {
                        title:'全选',
                        field:'select',
                        //复选框
                        checkbox:true,
                        width:25,
                        align:'center',
                        valign:'middle'
                    },
                    {
                        title:'ID',
                        field:'id',
                    },
                    {
                        title:'店铺',
                        field:'storename',
                        sortable:true
                    },
                    {
                        title:'日期',
                        field:'date',
                        sortable:true,
                        editable:true
                    },
                    {
                        title:'计划数',
                        field:'payment',
                        editable:true
                    }
                ],
                queryParams: function queryParams(param) {   //设置查询参数
                    var param = {
                        page:this.pageNumber,
                        limit:this.pageSize,
                    };
                    return param;
                },
                onLoadError: function(){  //加载失败时执行
                    alert("加载数据失败");
                }
            });
        }

      //JS校验form表单信息  
        function checkData(){  
           var fileDir = $("#upfile").val();  
           var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
           if("" == fileDir){  
               alert("选择需要导入的Excel文件！");  
               return false;  
           }  
           if(".xls" != suffix && ".xlsx" != suffix ){  
               alert("选择Excel格式的文件导入！");  
               return false;  
           }  
           return true;  
        }  
      function sub(){
    		alert();
    	  $("#form2").submit();
      }
    </script>
</html>
