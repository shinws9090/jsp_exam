<%@ page import="jsp_exam.util.jdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테스트</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body >
${jdbcUtil.getConnection()}
	
</body>
</html>