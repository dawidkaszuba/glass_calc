<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <style>
        .menuButton{
            background-color: yellowgreen;
            border: 1px solid black;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-right: 10px;
            margin-left: 10px;
            height: 50px;
            border-radius: 10px;
        }
    </style>
</head>
<body style="background-color: lightblue";>
<div class="container">
    <h1>GlassCalc</h1>

        <div class="row">
            <div class="col-md-6"><a href="/configurator2Tiles/add"><img border="0" alt="two tiles glass" src="<c:url value="/resources/images/2tiles.jpg"/>" width="200" height="200"></a></div>
            <div class="col-md-6"><a href="/configurator3Tiles/add"><img border="0" alt="two tiles glass" src="<c:url value="/resources/images/3tiles.jpg"/>" width="200" height="200"></a></div>
        </div>
        <div class="row">
            <div class="col-md-6"><a href="/configurator2Tiles/list"><div class="menuButton"><span>My 2-tiles glass</span></div></a></div>
            <div class="col-md-6"><a href="/configurator3Tiles/list"><div class="menuButton"><span>My 3-tiles glass</span></div></a></div>
        </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
