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
            <span>수정 할 상세보기</span>
        </div>
        <div class="body">
            <div class="title-bar">
                <span>제목 :</span>
                <span>내용 :</span>
            </div>
            <div class="content-bar">
                <input type="text" name="title" >
                <textarea name="content"></textarea>
            </div>

        </div>
        <div class="btn-area">
            <button>수정완료</button>
        </div>
    </div>
    <script src="/js/update.js"></script>
</body>
</html>
