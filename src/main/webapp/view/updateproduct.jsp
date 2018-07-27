<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="product" methed="get">
	<input type="hidden" name = "operation"  value="3" />
	<table>
	<tr>
			<td>请输入要修改的商品ID</td>
			<td><input type="text" name="id" /></td>		
		</tr>
		<tr>
			<td>修改后的商品名字</td>
			<td><input type="text" name="name" /></td>		
		</tr>
		<tr>
			<td>修改后的商品信息</td>
			<td><input type="text" name="detail" /></td>	
		</tr>
		<tr>
			<td>修改后商品价格</td>
			<td><input type="text" name="price" /></td>	
		</tr>		
		<tr>
			<td>修改后商品图片</td>
			<td><input type="text" name="image" /></td>	
		</tr>					
		<tr>
			<td><input type="submit" value="修改商品"/></td>
		</tr>
	
	</table>
	</form>

</body>
</html>