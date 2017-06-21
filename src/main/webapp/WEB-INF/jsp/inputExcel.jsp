<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<html>
<head>
<base href="<%=basePath%>">
<!-- bootstrap -->
<link href="/css/bootstrap/bootstrap-back.css" rel="stylesheet" />
<link href="/css/bootstrap/bootstrap-editable.css" rel="stylesheet" />
<link href="/css/bootstrap/bootstrap-overrides.css" type="text/css"
	rel="stylesheet" />
<!-- this page specific styles -->
<link rel="stylesheet" href="/css/tables.css" type="text/css"
	media="screen" />
<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<div>
		1.通过简单的form表单提交方式，进行文件的上</br> 2.通过jquery.form.js插件提供的form表单一步提交功能
	</div>
	</br>
	<form method="POST" enctype="multipart/form-data" id="form1"
		action="uploadExcel/upload.do">
		<table style="margin-left: 10%">
			<tr>
				<td>上传文件:</td>
				<td><input id="upfile" type="file" name="upfile"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"
					onclick="return checkData()"></td>
				<td><input type="button" value="ajax方式提交" id="btn" name="btn"></td>
			</tr>
		</table>
	</form>
<link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">  
<link href="/css/bootstrap/bootstrap-table.css" rel="stylesheet" type="text/css">  
<!-- <script src="/js/bootstrap/bootstrap-table-zh-CN.js"></script>   
 -->  
<table class="table table-hover" id="cusTable"  
       data-pagination="true"  
       data-show-refresh="true"  
       data-show-toggle="true"  
       data-showColumns="true">  
  
       </thead>  
       <tbody>  
       </tbody>  
</table>  
</body>
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/jquery.form-3.51.0.js"></script>
<script src="/js/jquery-1.8.3.min.js"></script>  
<script src="/js/bootstrap/bootstrap.min.js"></script>  
<script src="/js/bootstrap/bootstrap-table.js"></script>  
<script  src="/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<script src="/js/bootstrap/bootstrap-editable.js"></script>
<script src="/js/bootstrap/bootstrap-table-editable.js"></script>
<script src="/js/bootstrap/bootstrap-table-export.js"></script>
<script src="//rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js"></script>
<script type="text/javascript">  
            //ajax 方式上传文件操作  
             $(document).ready(function(){  
            	//调用函数，初始化表格  
            	 initTable();  
                 $("#search").bind("click", initTable);  

                $('#btn').click(function(){  
                    if(checkData()){ 
                        $('#form1').ajaxSubmit({   
                        	type:'post',
                            url:'target/uploadDailyTarget.do',  
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
             });  
               
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
                     showColumns: true,  //显示下拉框勾选要显示的列  
                     showRefresh: true,  //显示刷新按钮  
                     showExport: true,
                     sidePagination: "server", //表示服务端请求  
                     toolbar: '#toolbar',
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
           function initTable2(){
        		$('#cusTable').bootstrapTable({
        			url : 'target/queryDailyTarget.do', // 请求后台的URL（*）
        			//method : 'post', // 请求方式（*）
        			toolbar : '#toolbar', // 工具按钮用哪个容器
        			striped : true, // 是否显示行间隔色
        			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        			pagination : true, // 是否显示分页（*）
        			sortable : false, // 是否启用排序
        			sortOrder : "asc", // 排序方式
        			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
        			pageNumber : 1, // 初始化加载第一页，默认第一页
        			pageSize : 10, // 每页的记录行数（*）
        			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
        			queryParams : {
        				page:this.pageNumber,limit:(this.pageNumber-1)*this.pageSize
        				
        			},// 传递参数（*）
        			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        			strictSearch : true,
        			showColumns : true, // 是否显示所有的列
        			showRefresh : true, // 是否显示刷新按钮
        			minimumCountColumns : 2, // 最少允许的列数
        			clickToSelect : true, // 是否启用点击选中行
        			height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        			uniqueId : "ID", // 每一行的唯一标识，一般为主键列
        			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
        			cardView : false, // 是否显示详细视图
        			detailView : false, // 是否显示父子表
        			columns :[{
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
                        sortable:true
                    },
                    {
                        title:'计划数',
                        field:'payment',
                    },
                    {
                        title:'状态',
                        field:'Attribute',
                        align:'center',
                        //列数据格式化
                    }
                ],
        		});
        	}
           function ShowTheObject(obj){  
        	   var des = "";  
        	     for(var name in obj){  
        	     des += name + ":" + obj[name] + ";";  
        	      }  
        	  return des;
        	 }   
    </script>
</html>
