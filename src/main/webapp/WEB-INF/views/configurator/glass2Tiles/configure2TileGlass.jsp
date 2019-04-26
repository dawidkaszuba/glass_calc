<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Configurator</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body style="background-color: lightblue">
<div class="container">
    <jsp:include page="/WEB-INF/views/fragments/headerConfigurator.jsp"/>
    <h1>two tiles glass</h1>
    <div class="row"/>

        <div class="col-md-4">
            <form:form method="post" modelAttribute="glass2">
                <label>External tiles</label>
                <form:select path="externalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>
                <label>Frame</label>
                <form:select path="frame" items="${frames}" itemValue="id" itemLabel="name" class="form-control"/>

                <label>Internal tile</label>
                <form:select path="internalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>

                <label>Gas</label>
                <form:select path="gas" items="${gasses}" itemValue="id" itemLabel="name" class="form-control"/>

                <label>width</label>
                <form:input path="width" type="number" min="30" class="form-control"/>

                <label>height</label>
                <form:input path="height" type="number" min="30" class="form-control"/>

                <input type="submit" value="Next">

                <c:forEach var="error" items="${errors}">
                    <div>${error.message}</div>
                </c:forEach>

                <div><form:errors path="*"/></div>
            </form:form>
        </div>

        <div class="col-md-8">
            <svg width="40" height="300" class="svg">
                <rect width="45" height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
            <svg width="160" height="300" class="svg">
                <rect width="160" height="300" style="fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
            <svg width="40" height="300" class="svg">
                <rect width="40" height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
        </div>
        </div>


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

</body>
</html>
