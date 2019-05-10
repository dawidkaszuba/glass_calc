<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Compose</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script
            src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous">
    </script>
    <link href="<c:url value="/resources/css/styleConfigurator.css"/>" rel="stylesheet" />

</head>
<body class="bg-dark text-light">
<div class="container">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h1>compose</h1>

        <form:form method="post" action="/mail/send" modelAttribute="mail">
            <div class="row">
                <div class="col-md-6">
                    <label>recipient/s</label>
                    <form:select class="form-control" items="${recipients}"
                                 itemLabel="mailNameAndLastName" path="mailTo" itemValue="email" multiple="true"/>
                </div>
                <div class="col-md-6">
                    <label>subject</label>
                    <form:input type="text" path="subject" class="form-control" value="GlassCalc notification"/>
                    <label>message</label>
                    <form:textarea path="message" cols="30" rows="10" class="form-control"/>
                    <input type="submit" id="submit" value="Send">
                </div>
            </div>
            <div><form:errors path="*"/></div>
        </form:form>
        <div class="row">
            <div id="progressbar">

                <svg width="500" height="20">
                    <rect width="500" height="20" style="fill:#343a40!important;"></rect>
                    <rect id="progres" width="0" height="20" style="fill:rgb(0,0,255); stroke-width:1; stroke:rgb(0,0,0)"></rect>
                </svg>

            </div>
        </div>

    <script src="<c:url value="/resources/js/composeMail.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
