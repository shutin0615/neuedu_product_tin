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
<h1>修改购物车信息</h1>
<form action="CartServlet" methed="get">
	<input type="hidden" name = "operation"  value="4" />
	<input type="hidden" name = "id"  value="${cart.id }" />
	<table>
		<tr>
			<td>购物车商品数量</td>
			<td><input type="text" name="num" value="${cart.num }" /></td>		
		</tr>
					
		<tr>
			<td><input type="submit" value="修改"/></td>
		</tr>
	
	</table>
	</form>

</body>
</html>