<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>二维码</title>
<%@ include file="../common/header.jsp"%>

</head>
<body style="padding: 0px; margin: 0px">
	<img alt="" src="<%=request.getContextPath()%>/qrCode/getQRCode.do?text=http://www.baidu.com&height=800&width=700">
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
</body>
</html>
