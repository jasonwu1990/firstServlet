<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>servlet Test</title>
</head>
<body>
	<h2>test jsp</h2>
	<ul>
		<li>
		Current Time: <%=new java.util.Date() %>
		</li>
		<li>
		Server:<%=application.getServerInfo() %>
		</li>
		<li>
		Session Id:<%=session.getId() %>
		</li>
		<li>
		Parameter:<%=request.getParameter("name") %>
		</li>
		
	</ul>
	
</body>
</html>