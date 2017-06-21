<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<html>
<head>
<base href="<%=basePath%>">
</head>
<body>

 <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/bootstrap-table.css">
    <link rel="stylesheet" href="docs.css">

    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/docs/examples.js"></script>
    <script src="/src/bootstrap-table.js"></script>
    <script src="docs.js"></script>
    <script>
        $(document).ready(function(){
            //调用函数，初始化表格
            initTable();
        });
        function initTable() {
            //先销毁表格
            $('#tablelist').bootstrapTable('destroy');
            //初始化表格,动态从服务器加载数据
            $("#tablelist").bootstrapTable({
                // method: "POST",  //使用get请求到服务器获取数据
                url: "/target/queryDailyTarget.do", //获取数据的Servlet地址
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


    </script>
</head>
<body>
<a class="sr-only" href="#content">Skip to main content</a>
<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">
                Bootstrap Table
            </a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li>
                    <a href="getting-started.html">Getting started</a>
                </li>
                <li>
                    <a href="documentation.html">Documentation</a>
                </li>
                <li class="active">
                    <a href="examples.html">Examples</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
<div class="bs-header" id="content">
    <div class="container">
        <h1>Examples</h1>
        <p>The examples of bootstrap table.</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="bs-sidebar" role="complementary">
                <ul class="nav bs-sidenav">
                    <li><a href="#basic-table">Basic Table</a></li>
                    <li><a href="#transform-table">Transform Table</a></li>
                    <li><a href="#classes-table">Table Style</a></li>
                    <li><a href="#sort-table">Sort Table</a></li>
                    <li><a href="#custom-sort-table">Custom Sort Table</a></li>
                    <li><a href="#radio-table">Radio Table</a></li>
                    <li><a href="#checkbox-table">Checkbox Table</a></li>
                    <li><a href="#pagination-table">Pagination Table</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9" role="main">
            <div>
                <div class="page-header">
                    <h1 id="pagination-table">Pagination Table</h1>
                </div>
             
                <div class="highlight"><pre><code class="language-html"></code></pre></div>
            </div>
           <table class="table table-hover" id="tablelist"  
       data-pagination="true"  
       data-show-refresh="true"  
       data-show-toggle="true"  
       data-showColumns="true">  
       <tbody>  
       </tbody>  
</table>     
        </div>
    </div>
</div>

</body>
</html>
