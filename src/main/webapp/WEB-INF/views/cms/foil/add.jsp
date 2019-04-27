<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>add new foil</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body class="bg-dark text-light">
<div class="container">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h1>add new foil</h1>
    <div class="row">

        <form:form method="post" modelAttribute="foil">
            <label>name</label>
            <form:input path="name" type="text" class="form-control"/>
            <label>thickness</label>
            <form:input path="thickness" type="number" min="0.01" step="0.01" class="form-control"/>
            <label>Is it mat?</label>
            <div><form:radiobutton  path="isMat" value="true"/> YES
                <form:radiobutton  path="isMat" value="false"/> NO</div>
            <label>Is it acustic?</label>
            <div><form:radiobutton  path="isAcustic" value="true"/> YES
                <form:radiobutton  path="isAcustic" value="false"/> NO</div>
            <label>price</label>
            <form:input path="price" type="number" min="0" step="0.01" class="form-control"/>
            <label>delivery time</label>
            <form:input path="deliveryTime" type="number" min="0" class="form-control"/>
            <input type="submit" value="Save">
            <div><form:errors path="*"/></div>
        </form:form>

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
