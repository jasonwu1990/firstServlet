<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload file here</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
	<label for="myFile">upload your file</label>
	文件:<input type="file" name="myFile"/>
	<input type="submit" value="upload"/>
</form>
</body>
</html>