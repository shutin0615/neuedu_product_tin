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

<table>
	<tr>
		<th>订单明细ID</th>
		<th>订单明细编号</th>
		<th>用户id</th>
		<th>商品id</th>
		<th>商品名字</th>
		<th>商品图片</th>
		<th>生成订单时的价格</th>
		<th>商品数量</th>
		<th>总价</th>
		<th>创建时间</th>
		<th>更新时间</th>
		<th>操作</th>
	</tr>
	
	
<c:forEach items="${items}" var="item">   
		
	<tr>
		<td>${item.id}</td>
		<td>${item.order_no}</td>
		<td>${item.user_id }</td>
		<td>${item.product_id}</td>
		<td>${item.product_name }</td>
		<td>${item.product_image}</td>
		<td>${item.current_unit_price}</td>
		<td>${item.quantity}</td>
		<td>${item.total_price}</td>
		<td>${item.create_time}</td>
		<td>${item.update_time}</td>
		<td><a href="#">删除</a></td>
		<td><a href="#">修改</a></td>
	</tr>
	
</c:forEach>
</table>
</body>
</html>