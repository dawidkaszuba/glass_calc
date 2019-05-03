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
    <style>
        #progressbar{
            display: none;
            position: fixed;
            left:35%;
            top:85%;
            z-index: 1;
        }
    </style>
</head>
<body class="bg-dark text-light">
<div class="container">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <h1>compose</h1>

        <form method="post" action="/mail/send">
            <div class="row">
                <div class="col-md-6">
                    <label>recipient/s</label>
                    <select class="form-control" name="mailTo" multiple>
                        <c:forEach items="${recipients}" var="recipient">
                            <option  class="form-control" value="${recipient.email}">
                                    ${recipient.name} ${recipient.lastName}: ${recipient.email}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label>subject</label>
                    <input type="text" name="sub" value="GlassCalc newsletter" class="form-control">
                    <label>message</label>
                    <textarea name="message" cols="30" rows="10" class="form-control"></textarea>
                    <input id ="submit" type="submit" value="Send">
                </div>
            </div>
        </form>
        <div class="row">
            <div id="progressbar">

                <svg width="500" height="20">
                    <rect width="500" height="20" style="fill:#343a40!important;"></rect>
                    <rect id="progres" width="0" height="20" style="fill:rgb(0,0,255); stroke-width:1; stroke:rgb(0,0,0)"></rect>
                </svg>

            </div>
        </div>



    <script>
        var i=1;
        var progres = document.getElementById('progres');
        var progressbar = document.getElementById('progressbar');

        function myLoop () {
            setTimeout(function () {
                progres.setAttribute("width",i);;
                i++;
                if (i < 501) {
                    myLoop();
                }
            }, 1)
        }

        var submit = document.getElementById('submit');
        submit.addEventListener("click", function(){
            progressbar.style.display='inline'
            myLoop();


        })

    </script>


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
