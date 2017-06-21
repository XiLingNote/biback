<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- bootstrap -->
<link href="/css/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />



<!-- this page specific styles -->
<link rel="stylesheet" href="/css/tables.css" type="text/css" media="screen" />
<script src="/js/jquery-latest.js"></script>
<script src="/js/theme.js"></script>
<script src="/js/jquery-1.12.3.js"></script>
<script src="/js/jquery.form-3.51.0.js"></script>
<jsp:include page="/page/top.do"></jsp:include>
	<jsp:include page="/page/left.do"></jsp:include>
<body style="margin-left: 10%">
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
<div class="table-wrapper products-table section" style="border-left:10% " >
    <div class="row-fluid head">
        <div class="span12">
            <h4>Products</h4>
        </div>
    </div>

    <div class="row-fluid">
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="span3">
                    <input type="checkbox" />
                    Product
                </th>
                <th class="">
                    <span class=""></span>Description
                </th>
                <th class="span3">
                    <span class=""></span>Status
                </th>
            </tr>
            </thead>
            <tbody>
            <!-- row -->
            <tr class="first">
                <td>
                    <input type="checkbox" />
                    <div class="img">
                        <img src="img/table-img.png" />
                    </div>
                    <a href="#" class="">Generate Lorem </a>
                </td>
                <td class="description">
                    if you are going to use a passage of Lorem Ipsum.
                </td>
                <td>
                    <span class="label label-success">Active</span>
                    <ul class="actions">
                        <li><a href="#">Edit</a></li>
                        <li class="last"><a href="#">Delete</a></li>
                    </ul>
                </td>
            </tr>
            <!-- row -->
            <tr>
                <td>
                    <input type="checkbox" />
                    <div class="img">
                        <img src="img/table-img.png" />
                    </div>
                    <a href="#" class="">Internet tend</a>
                </td>
                <td class="description">
                    There are many variations of passages.
                </td>
                <td>
                    <ul class="actions">
                        <li><a href="#">Edit</a></li>
                        <li class="last"><a href="#">Delete</a></li>
                    </ul>
                </td>
            </tr>
            <!-- row -->
            <tr>
                <td>
                    <input type="checkbox" />
                    <div class="img">
                        <img src="img/table-img.png" />
                    </div>
                    <a href="#" class="">Generate Lorem </a>
                </td>
                <td class="description">
                    if you are going to use a passage of Lorem Ipsum.
                </td>
                <td>
                    <ul class="actions">
                        <li><a href="#">Edit</a></li>
                        <li class="last"><a href="#">Delete</a></li>
                    </ul>
                </td>
            </tr>
            <!-- row -->
            <tr>
                <td>
                    <input type="checkbox" />
                    <div class="img">
                        <img src="img/table-img.png" />
                    </div>
                    <a href="#" class="">Internet tend</a>
                </td>
                <td class="description">
                    There are many variations of passages.
                </td>
                <td>
                    <span class="label label-info">Standby</span>
                    <ul class="actions">
                        <li><a href="#">Edit</a></li>
                        <li class="last"><a href="#">Delete</a></li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" />
                    <div class="img">
                        <img src="img/table-img.png" />
                    </div>
                    <a href="#" class="">Generate Lorem </a>
                </td>
                <td class="description">
                    if you are going to use a passage of Lorem Ipsum.
                </td>
                <td>
                    <span class="label label-success">Active</span>
                    <ul class="actions">
                        <li><a href="#">Edit</a></li>
                        <li class="last"><a href="#">Delete</a></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">  
            //ajax 方式上传文件操作  
             $(document).ready(function(){  
                $('#btn').click(function(){  
                    if(checkData()){ 
                        $('#form1').ajaxSubmit({   
                        	type:'post',
                            url:'/target/uploadDailyTarget.do',  
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
    </script>
</html>