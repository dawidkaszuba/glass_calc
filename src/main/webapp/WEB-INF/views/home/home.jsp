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
            background-color: dodgerblue;
            border: 1px solid black;
            margin: auto;
            margin-top: 10px;
            height: 120px;
            width: 180px;
            border-radius: 10px;
            color: black;

        }
        body{
            background-color:#1fc8db;
            background-image: linear-gradient(141deg, #9fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);
            text-align: center;
            margin:auto;
            color:#f3f3f3;
            font-size:30px;
            font-weight:550;
            padding-top:105px;;
        }
        h1{
            font-size:100px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>GlassCalc</h1>
      <div class="row">
            <div class="col-md-6">
                <a href="/configurator2Tiles/add">
                    <svg width="120" height="300" class="svg">
                        <rect width="20" height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="80" height="300" x="21" style="fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect y="275" width="80" height="25" x="21" style="fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="20" height="300" x="101" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="3" height="300" x="101" style="fill:rgb(255,0,0)"></rect>
                    </svg>
                </a>
            </div>
            <div class="col-md-6">
                <a href="/configurator3Tiles/add">
                    <svg width="220" height="300" class="svg">
                        <rect width="20" height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="4" height="300" x="16" style="fill:rgb(255,0,0)"></rect>
                        <rect width="80" height="300" x="20" style="fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect y="275" width="80" height="25" x="21" style="fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="20" height="300" x="101" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="80" height="300" x="121" style="fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect y="275" width="80" height="25" x="121" style="fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="20" height="300" x="200" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                        <rect width="3" height="300" x="200" style="fill:rgb(255,0,0)"></rect>
                    </svg>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6"><a href="/configurator2Tiles/list"><div class="menuButton"><span>My two-tiles glass</span></div></a></div>
            <div class="col-md-6"><a href="/configurator3Tiles/list"><div class="menuButton"><span>My three-tiles glass</span></div></a></div>
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
