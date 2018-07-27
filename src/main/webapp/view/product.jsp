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
<h1>查看商品</h1>

<h4><a href="addproduct.jsp">添加商品</a></h4>
<table border="2" cellspacing="0" cellpadding="5" style="width: 700px;">
	<tr>
		<th>商品id</th>
		<th>商品名字</th>
		<th>商品信息</th>
		<th>商品价格</th>
		<th>商品图片</th>
		<th>商品库存</th>
	</tr>
	<c:forEach items="${pageModel.data}" var="product">
	
	<tr>
		<td>${product.id}</td> 
		<td>${product.name}</td>
		<td>${product.detail}</td>
		<td>${product.price }</td>
		<td>${product.image }</td>
		<td>${product.stock }</td>
		<td><a href="product?id=${product.id}&operation=4">删除</a></td>
		<td><a href="product?id=${product.id}&operation=6">修改</a></td>
		
	</tr>
	</c:forEach>

</table>

<c:forEach var="pageNo" begin="1" end="${pageModel.totalpage}"  step="1">
<c:choose>
<c:when test="${pageModel.currentPage==pageNo}">
<a style="color:red" href="product?pageNo=${pageNo}&operation=2">${pageNo }</a>
</c:when>
<c:when test="${pageModel.currentPage!= pageNo}">
<a href="product?pageNo=${pageNo}&operation=2">${pageNo }</a>
</c:when>
</c:choose>
</c:forEach> 


<form action="product" methed="get">
	<input type="hidden" name = "operation"  value="5" />
	<table>
		<tr>
			<td>请输入想查看的商品ID</td>
			<td><input type="text" name="id" /></td>		
		</tr>
							
		<tr>
			<td><input style="width: 150px; height: 25px;" type="submit" value="提交"/></td>
		</tr>
	
	</table>
	</form>


</body>
</html>