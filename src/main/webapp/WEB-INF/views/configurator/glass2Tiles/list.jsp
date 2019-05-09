<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>My glasses</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <style>
        .boldSpan{
            font-weight: bold;
        }
    </style>

</head>
<body style="background-color: lightblue";>
    <div class="container">
        <jsp:include page="/WEB-INF/views/fragments/headerConfigurator.jsp"/>
        <h1>My single-chamber glasses</h1>
        <div class="row">
            <div class="col-md-3">
                <span class="boldSpan">specification</span>
            </div>
            <div class="col-md-2">
                <span class="boldSpan">price</span>
            </div>
            <div class="col-md-1">
                <span class="boldSpan">thickness</span>
            </div>
            <div class="col-md-2">
                <span class="boldSpan">dimension [w,h]</span>
            </div>
            <div class="col-md-2">
                <span class="boldSpan">delivery time [days]</span>
            </div>
            <div class="col-md-2">
                <span class="boldSpan">&nbsp</span>
            </div>

        </div>

        <div class="row">
            <c:forEach items="${glasses2}" var="glass">
                <div class="col-md-3">
                    <div><p><span>${glass.name}</span></p></div>
                </div>
                <div class="col-md-2">
                    <div><p><span>${glass.price} zł</span></p></div>
                </div>
                <div class="col-md-1">
                    <div><p><span>${glass.thickness} mm</span></p></div>
                </div>
                <div class="col-md-2">
                    <div><p><span>${glass.width} x ${glass.height} [mm]</span></p></div>
                </div>
                <div class="col-md-2">
                    <div><p><span>${glass.deliveryTime}</span></p></div>
                </div>
                <div class="col-md-2">
                    <span><a href="/configurator2Tiles/edit/${glass.id}">edit</a> /
                        <a href="/configurator2Tiles/delete/${glass.id}">delete</a> /
                        <a href="/pdfreport2/${glass.id}">PDF</a></span>
                </div>
            </c:forEach>


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
    </div>
</body>
</html>
