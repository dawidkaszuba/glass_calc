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
    <script
            src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous"></script>
    <style>
        .error{
            color:red;
        }
        #exTilePopup, #intTilePopup, #framePopup{
            width: 300px;
            height: 180px;
            display: none;
            position: fixed;
            left:35%;
            background-color: white;
            z-index:1;
            border: 1px solid;
            padding: 10px;
            box-shadow: 5px 10px #888888;
        }

        #close,#intTilePopupClose, #framePopupClose{
            position: absolute;
            top:0;
            right:14px;
            font-size: 42px;
            transform: rotate(45deg);
        }
        .select{
            width:200px;
        }
        .elementName{
            font-weight: bold;
            background-color: dodgerblue;
            border-radius: 5px;
            text-align: center;
        }

    </style>

</head>
<body style="background-color: lightblue">
<div class="container">
    <jsp:include page="/WEB-INF/views/fragments/headerConfigurator.jsp"/>
    <h1>Glass - two tiles</h1>
    <div class="row"/>

        <div class="col-md-2">
            <form:form method="post" modelAttribute="glass2">
                <div>External tile</div>
                <div id="exTileName" class="elementName">External tile</div>
                <div id="exTilePopup">

                    <div class="select">
                        <label>select group</label>
                        <select class="form-control" id="tilesGroup" name="groups">
                             <c:forEach items="${tilesGroups}" var="group">
                                <option value="${group.id}">${group.name}</option>
                             </c:forEach>
                        </select>

                            <label>select tile</label>
                            <form:select path="externalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>
                    </div>
                    <div id="close">+</div>
                </div>
                <div>Frame</div>
                <div id="frameName" class="elementName">Frame</div>
                <div id="framePopup">

                    <div class="select">
                        <label>select group</label>
                        <select class="form-control" id="framesGroup" name="groups">
                            <c:forEach items="${frameGroups}" var="group">
                                <option value="${group.id}">${group.name}</option>
                            </c:forEach>
                        </select>

                        <label>Frame</label>
                        <form:select path="frame" items="${frames}" itemValue="id" itemLabel="name" class="form-control"/>

                    </div>
                    <div id="framePopupClose">+</div>

                </div>


                <div>Internal tile</div>
                <div id="intTileName" class="elementName">Internal tile</div>
                <div id="intTilePopup">

                    <div class="select">
                        <label>select group</label>
                        <select class="form-control" id="intTilesGroup" name="groups">
                            <c:forEach items="${tilesGroups}" var="group">
                                <option value="${group.id}">${group.name}</option>
                            </c:forEach>
                        </select>

                        <label>select tile</label>
                        <form:select path="internalTile" items="${tiles}" itemValue="id" itemLabel="name" class="form-control"/>
                    </div>
                    <div id="intTilePopupClose">+</div>


                </div>
                <label>Gas</label>
                <form:select path="gas" items="${gasses}" itemValue="id" itemLabel="name" class="form-control"/>

                <label>width</label>
                <form:input path="width" type="number" min="30" class="form-control" value="1000"/>

                <label>height</label>
                <form:input path="height" type="number" min="30" class="form-control" value="1000"/>

                <input type="submit" value="Next">
            </form:form>
        </div>

        <div class="col-md-3">
            <svg id="svgExTile" width="16" height="300" class="svg">
                <rect id="exTile" width="16"  height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
            <svg id="svgCoatingExt" display="none" width="3" height="300" class="svg">
                <rect id="coatingExt" width="3" height="300" style="fill:rgb(255,0,0)"></rect>
            </svg>
            <svg id="svgFrame" width="64" height="300" class="svg">
                <rect id="glassFrame" width="64" height="300" style="fill:rgb(255,255,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
                <rect id="frameBottom" y="260" width="160" height="40" style="fill:rgb(220,220,220);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
            <svg id="svgCoatingInt" width="3" display="none" height="300" class="svg">
                <rect id="coatingInt" width="3" height="300" style="fill:rgb(255,0,0)"></rect>
            </svg>
            <svg id="svgIntTile" width="16" height="300" class="svg">
                <rect id="intTile"width="16" height="300" style="fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
        </div>

        <div class="col-md-7">
            <svg height="150" width="20" style="float: left">
                <text id="textHeight" x="0" y="0" fill="black" transform="rotate(90,2,3)">height</text>
            </svg>
            <svg id="svgGlass" width="100" height="100" class="svg" display="block">
                <rect id="glass" width="100" height="100" style="fill:rgb(240,255,240);stroke-width:3;stroke:rgb(0,0,0)"></rect>
            </svg>
            <svg height="30" width="200">
                <text id="textWidth" x="20" y="15" fill="black">width</text>
            </svg>
        </div>
    </div>
            <div class="row">
                <c:forEach var="error" items="${errors}">
                    <div class="error">${error.message}&nbsp</div>
                </c:forEach>
            </div>
    </div>
    <script src="<c:url value="/resources/js/configurator2Tiles.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>


</body>
</html>
