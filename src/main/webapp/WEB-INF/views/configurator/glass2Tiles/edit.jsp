<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>edit glass</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body style="background-color: lightblue";>
    <div class="container">
        <h1>edit glass</h1>
            <div class="row">
                <form:form method="post" modelAttribute="glass2" action="/configurator2Tiles/saveEdited">

                    <form:input path="id" value="${glass2.id}" type="hidden"/>

                    <label>External tile</label>
                    <form:select path="externalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>

                    <label>Frame</label>
                    <form:select path="frame" items="${frames}" itemValue="id" itemLabel="name" class="form-control"/>

                    <label>Internal tile</label>
                    <form:select path="internalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>

                    <label>Gas</label>
                    <form:select path="gas" items="${gasses}" itemValue="id" itemLabel="name" class="form-control"/>

                    <input type="submit" value="Next">

                    <c:forEach var="error" items="${errors}">
                        <div>${error.message}</div>
                    </c:forEach>

                    <div><form:errors path="*"/></div>
                </form:form>
            </div>
        <div>tu ma byc grafika szyby</div>
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
