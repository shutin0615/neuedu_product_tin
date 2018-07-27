<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="CategoryServlet" methed="get">
	<input type="hidden" name = "operation"  value="1" />
	<table>
		<tr>
			<td>父类ID</td>
			<td>
			
			<select  name="parent_id" >
			<option value="12">12</option>
			<option value="22">22</option>
			<option value="33">33</option>
			<option value="44">44</option>
			</select>
				
			</td>		
		</tr>
		<tr>
			<td>类别名称</td>
			<td><input type="text" name="name" /></td>	
		</tr>
		<tr>
			<td>类别状态</td>
			<td><input type="text" name="status" /></td>	
		</tr>		
		<tr>
			<td>排序编号</td>
			<td><input type="text" name="sort_order" /></td>	
		</tr>	
		
							
		<tr>
			<td><input type="submit" value="提交"/></td>
		</tr>
	
	</table>
	</form>
</body>
</html>