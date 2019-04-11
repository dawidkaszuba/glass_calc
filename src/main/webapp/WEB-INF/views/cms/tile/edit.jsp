<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>edit tile</title>
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
    <h1>edit tile</h1>
    <div class="row">

        <form:form method="post" modelAttribute="tile" action="/tile/saveEdited">
            <form:input path="id" value="${tile.id}" type="hidden"/>
            <label>name</label>
            <form:input path="name" type="text" class="form-control"/>
            <label>thickness</label>
            <form:input path="thickness" type="number" min="1" step="0.01" class="form-control"/>
            <label>group</label>
            <form:select path="group" items="${tileGroups}" itemValue="id" itemLabel="name" class="form-control"/>
            <label>Is it tempered?</label>
            <div><form:radiobutton  path="isTempered" value="true"/> YES
                <form:radiobutton  path="isTempered" value="false"/> NO</div>
            <label>coating</label>
            <form:select path="coating" items="${coatings}" itemValue="id" itemLabel="name" class="form-control"/>
            <label>price</label>
            <form:input path="price" type="number" min="0" step="0.01" class="form-control"/>
            <input type="submit" value="Save changes">
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
