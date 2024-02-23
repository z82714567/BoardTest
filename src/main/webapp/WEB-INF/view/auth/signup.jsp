<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/signup.css">
</head>
<body>

	<form action="/user/signup" method="post">
    <div class="main-div">
        <div class="header">
            <span>게시판</span>
        </div>
        <div class="body">
            <div class="input-box">
                <span>아이디</span>
                <input type="text" name="username">
            </div>
            <div class="input-box">
                <span>이름</span>
                <input type="text" name="name">
            </div>
            <div class="input-box">
                <span>비밀번호</span>
                <input type="password" name="password">
            </div>
            <div class="input-box">
                <span>비밀번호 확인</span>
                <input type="password" >
            </div>
            <div class="input-box">
                <span>전화번호</span>
                <input type="number" name="phone">
            </div>
        </div>
        <div class="btn-area">
            <button type="submit">회원가입</button>
        </div>
    </div>
    </form>
    
    <script src="/js/signUp.js"></script>
    
</body>
</html>