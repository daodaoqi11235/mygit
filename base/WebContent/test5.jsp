<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家简介</title>
	

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/gray/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css">
	
	<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/jquery.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/jquery.easyui.min.js" type="text/javascript"></script>
	
	
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/WdatePicker.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/JQuery-formui.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/common1.js" type="text/javascript"></script>
	
<script type="text/javascript">
        $(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/test9.jsp',
                type: 'post',
                dataType : "text",
            	error: function(XMLHttpRequest, textStatus, errorThrown) {
       			 alert(XMLHttpRequest.status);
       			 alert(XMLHttpRequest.readyState);
       			 alert(textStatus);
       			   },
                success: function (msg) {
                	var result = eval("("+msg+")");
					for (var key in result){
 						$("#roleList").datagrid("appendRow",result[key]);
 					}
                    
             
                }
            });
            $('#roleList').datagrid({
            	
                title: '',
                loadMsg: "数据加载中，请稍后……",
                nowrap: false,
                striped: true,
                collapsible: true,
                url:'<%=request.getContextPath()%>/test9.jsp',	
                pageList: [10, 15, 20, 25, 30, 40, 50],
                pageSize: 15,
                sortName: 'RoleSort',
                sortOrder: 'asc',
                remoteSort: false,
                idField: 'RoleCode',
                frozenColumns :[[
					{field : 'ck',checkbox : true}
						]],
				columns: [[ 
				{field : 'CITY', title : '城市',width : 100,align:'center',sortable : true},
				{field : 'GOODS',title : '产品',width : 80,align:'center',sortable : true}, 
				{field : 'AMOUNT',title : '数量',width : 100,align:'center',sortable:true}
              
          ]],
                pagination: true,
                rownumbers: true                                      
            });

     


            
        });

        function getSelections() {
            var ids = [];
            var rows = $('#roleList').datagrid('getSelections');
            for (var i = 0; i < rows.length; i++) {
                ids.push(rows[i].RoleCode);
            }
            return ids.join(',');
        }


        $("#btnQuery").click(function(){			
                $('#roleList').datagrid('options').url = '../ashx/RoleHandler.ashx?RoleName=' + escape($('#txtSearch').val());
                $('#roleList').datagrid("reload");
            });


        
 </script>

<style type='text/css'>
		body{margin:0px;padding:0px;}
	</style>
  </head>  
  <body >
    <!-- 查询条件 -->
	<div id="formdata" class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div style="margin-left:30px;">		
			  选择日期：
			<input id="dateStart" onclick="WdatePicker();" type='text'/>-<input id="dateEnd" onclick="WdatePicker();" type='text'/>
			<a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls: 'icon-search'">查询</a>
		</div>
	</div>
	
	<!-- 显示结果 -->
	<table id="roleList">
    </table>
    <div id="processWindow" class="easyui-window" closed="true" modal="true" title="提示消息"
        style="width: 300px; height: 60px;">
        <div id="windowContent" class="general-font">
            <img src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/gray/images/panel_loading.gif" />
            操作进行中，请稍后...
        </div>
    </div>
    <input type="text" id="txtSearch" title="请输入角色名称" style="display: none;" />
  </body>
</html>

