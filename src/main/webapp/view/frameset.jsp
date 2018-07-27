<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

	<frameset rows="15%,70%,15%" border="2px">
		<frame src="view/header.jsp" noresize="noresize" />
		
		<frameset cols="20%,*">
			
			<frame src="view/menu.jsp" noresize="noresize"/>
			<frame src="view/content.jsp" name="show"/>
		</frameset>
		

	</frameset>
	

</html>