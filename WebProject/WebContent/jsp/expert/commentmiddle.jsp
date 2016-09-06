<%@ page import="com.hibernate.beans.Intermediateinspection" %>
<%@ page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中期检查评审</title>
	
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/themes/gray/easyui.css"/>
<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
	
	<%Intermediateinspection ii=(Intermediateinspection) request.getAttribute("ii"); %>
<style type="text/css">
	
	.persional{
		width:100%;
		position:relative;
		height:600px;
		background-color:#F7F7F7;
		border-collapse:collapse;
		border-color:#DEE5EA;
		color:#5F6467;
	}
	
	.prodTab{
		width:100%;
		height:100%;
		position:relative;
		border-collapse:collapse;
	
	}
	.prodTab td{
	
	     height:25px;
	     text-align:center;
	     text-indent:10;
	     font-size:14px;
	     border-color:#DEE5EA;
	     color:#5F6467;
	}
	
		
	#tabtitle{
		height:30px;
		background-color:#CDE8F9;
		font-weight:bolder;
		border:0;
		font-size:14px;
		color:#2C3E4B;
	}
	
	#tabtitle1{
		border:1;
		width:15.1%;
		height:400px;
		background-color:#F2F2F2;
		font-size:16px;
	}		
	.tdname{height:35px;text-align:center;background-color:#F2F2F2;width:15%;}
	.tdcontent1{width:35%;text-align:center;}
	.tdcontent2{text-align:center;}
	.mydatebox{width:220px;}
	.tdcontent3{padding-top:20px;height:100%;padding-bottom:20px;}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var stime="<%=ii.getP5() %>";
	var etime="<%=ii.getP6() %>";
	var ctime="<%=ii.getP7() %>";
	$("#stime").datebox("setValue", stime); 
	$("#etime").datebox("setValue", etime);
	$("#ctime").datebox("setValue", ctime); 
});
function save(){
	if(confirm("确认保存检查意见？")){
		document.getElementById("sort").value="save";
		return true;
	}
	else{
		return false;
	}
}
function sub(){
	var stime=$("#stime").datebox("getValue");
	var etime=$("#etime").datebox("getValue");
	var ctime=$("#ctime").datebox("getValue");
	var presention=document.getElementById("presention").value;
	var advice=document.getElementById("advice").value;
	if(stime==""){
		alert("提示：\n\n请填写项目启动时间！");
		return false;
	}
	if(etime==""){
		alert("提示：\n\n请填写项目截止时间！");
		return false;
	}
	if(ctime==""){
		alert("提示：\n\n请填写评审日期！");
		return false;
	}
	if(presention==""){
		alert("提示：\n\n请填写检查情况评述！");
		return false;
	}
	if(advice==""){
		alert("提示：\n\n请填写问题及意见！");
		return false;
	}
	if(confirm("确认提交回复？")){
		document.getElementById("sort").value="submit";
		return true;
	}
	else{
		return false;
	}
}
</script>
	
</head>

<body>

 <div class="commonPage">
 
     <div class="topnav"  >
	   <div  class="path" >
	      <span ><font>当前位置:</font></span>
	      <span ><font >项目评审&nbsp;&nbsp; &gt;&nbsp;&nbsp; 企业项目评审</font></span>
	   </div>
     </div> 
		 
    <div class="context">
       <div class="titlebox"><span class="title">项目中期检查意见</span></div>
	   <div>
	   	<form action="<%=request.getContextPath() %>/intermediateinspection.do" name="Form1" id="Form1">
	   	<input type="hidden" name="sort" id="sort">
	   	<table class="persional" align="center" border="1" cellpadding="0" cellspacing="0" bordercolor="#DEE5EA">
                <tr >
                    <td class="tdname">项目名称：</td>                    
                    <td class="tdcontent1">
                      <%=ii.getP1() %>
                    </td>
                    <td class="tdname">承担单位：</td>
                    <td class="tdcontent2">
                       <%=ii.getP2()%>
                    </td>
                </tr>
                <tr >
                    <td class="tdname">计划文号：</td>
                    <td class="tdcontent1">
                       <%=ii.getP3()%>
                    </td>
                    <td class="tdname">项目编号：</td>
                    <td class="tdcontent2">
                       <%=ii.getP4()%>
                    </td>                    
                </tr>
                <tr>
                    <td class="tdname">项目启动时间：</td>
                    <td class="tdcontent1">
                      <input class="easyui-datebox mydatebox" type="text" name="stime" id="stime" editable="false" panelHeight="260" panelWidth="200" >
                    </td>
                    <td class="tdname">评审日期：</td>
                    <td class="tdcontent2">
                      <input class="easyui-datebox mydatebox" type="text" name="ctime" id="ctime" editable="false" panelHeight="260" panelWidth="200" >
                    </td>
                </tr>
                <tr>
                    <td class="tdname">项目截止时间：</td>
                    <td class="tdcontent1">
                      <input class="easyui-datebox mydatebox" type="text" name="etime" id="etime" editable="false" panelHeight="260" panelWidth="200" >
                    </td>
                    <td style="background-color:#F2F2F2;width:15%"colspan="2" >
                   	 <div align="center" ><a href="#" class="easyui-linkbutton button" style="width:120px;height:25px">相关附件下载</a></div></td>                    
                </tr>      
             <tr>             
             	 <td  id="tabtitle1"  align="center" >中期检查情况评述</td>
            	 <td  align="center" height="400px" colspan="3">
	            	 <div class="tdcontent3">
		               <textarea id="presention" name="presention" cols="40" rows="12" style="width:90%;height:100%;"><%=ii.getP8() %></textarea>
		             </div>
             </tr>
             
             <tr>
             	 <td  id="tabtitle1" align="center" >主要问题及建议</td>
            	 <td  align="center" height="400px" colspan="3">
	            	 <div class="tdcontent3">
		               <textarea id="advice" name="advice" cols="40" rows="12" style="width:90%;height:100%;"><%=ii.getP9() %></textarea>
		             </div> 
             </td>
             </tr>
             
             <tr>
	             <td align="center" colspan="4">
	             	<div style="margin-top:20px;margin-left:auto;margin-right:auto; margin-bottom:20px" ><a href="javascript:void(document.Form1.submit())" style="height:35px;width:70px;font-size:16px;" class="easyui-linkbutton button" onclick="return sub();">提&nbsp;&nbsp;交</a>
	             	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		            <a href="javascript:void(document.Form1.submit())" style="height:35px;width:70px;font-size:16px" class="easyui-linkbutton button" onclick="return save();">保&nbsp;&nbsp;存</a></div>
		        </td>
	        </tr>
	        
           </table>
          </form>
	   	</div>
	
   </div>   
 	     
 </div>
</body>
</html>