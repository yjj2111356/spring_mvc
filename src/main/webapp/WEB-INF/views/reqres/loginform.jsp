<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인하기</title>
</head>
<body>

<!-- action은 목적지(해당 폼의 데이터를 어디로 보낼지)
     method는 전송 방법: get은 url 뒤에 붙여서, post는 req body에 보냄 -->
    <form action="/reqres/login" method="post">
        <!-- input은 폼 내부에서 데이터 전송 시 사용
        name은 어떤 변수에 데이터를 담아서 보낼지 결정 -->
        <input type="text" name="id"><br>
        <input type="password" name="pw"><br>

        <button>로그인하기</button>
    </form>
</body>
</html>