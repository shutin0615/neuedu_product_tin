<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示单件商品</title>

</head>
<body>
<table>

	<tr>
		<th>商品id </th>
		<td> ${product.id}  </td>
	</tr>	
	<tr>
		<th>商品名称 </th>
		<td> ${product.name}  </td>
	</tr>	
	<tr>
		<th>商品信息 </th>
		<td> ${product.detail}  </td>
	</tr>	
	<tr>
		<th>商品图片 </th>
		<td> ${product.image}  </td>
	</tr>	
	<tr>
		<th>商品库存 </th>
		<td> ${product.stock}  </td>
	</tr>	
	<tr>
		<th>商品价格 </th>
		<td> ${product.price}  </td>
	</tr>	
	

</table>

<form action="cartservlet" methed="get">
	<input type="hidden" name = "operation"  value="1"/>
	<input type ="hidden" name ="id" value="${product.id}"> 
	
	<table border="2" cellspacing="0" cellpadding="5" style="width: 700px;">
	
		<tr>
			<td>输入要购买的商品数量</td>
			<td><input type="text" name="num" /></td>		
		</tr>					
		<tr>
			<td><input type="submit" value="提交"/></td>
		</tr>
	
	</table>
	</form>


</body>
</html>