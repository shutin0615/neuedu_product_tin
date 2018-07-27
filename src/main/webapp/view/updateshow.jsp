<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>修改商品</h1>

	<form  action="product" methed="get"  >
	<input type="hidden" name = "operation"  value="3" />
	<input type="hidden" name = "id"  value="${product.id }"/>
<table>

	<tr>
		<th>商品名称 </th>
		<td> <input type="text" name="name" value="${product.name}" />  </td>
	</tr>	
	<tr>
		<th>商品信息 </th>
		<td>  <input type="text" name="detail" value=" ${product.detail}" /></td>
		
	</tr>	
	<tr>
		<th>商品图片 </th>
		<td> <input type="text" name="image" value="${product.image}" />  </td>
	</tr>	
	<tr>
		<th>商品库存 </th>
		<td><input type="text" name="stock" value="${product.stock} " /> </td>
	</tr>	
	<tr>
		<th>商品价格 </th>
		<td><input type="text" name="price" value=" ${product.price}" /> </td>
	</tr>	
	<tr>
			<td><input type="submit" value="修改商品"/></td>
	</tr>

</table>
</form>
</body>
</html>