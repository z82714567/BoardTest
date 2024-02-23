<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/detail.css">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <div class="main-div">
        <div class="header">
            <span>상세보기</span>
        </div>
        <div class="body">
            <div class="title-bar">
                <span>제목 :</span>
                <span>내용 :</span>
            </div>
            <div class="content-bar">
                <input type="text" readonly="readonly">
                <textarea readonly="readonly"></textarea>
            </div>

        </div>
        <div class="btn-area">
            <button>수정하기</button>
            <button id="delete">삭제하기</button>
        </div>
    </div>
    <script src="/js/detail.js"></script>
</body>
</html>
