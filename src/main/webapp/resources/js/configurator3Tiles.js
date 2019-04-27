$(function(){

    doAjaxExtTile();
    doAjaxFirstFrame();
    doAjaxSecondFrame();
    doAjaxIntTile();
    doAjaxMidTile();
    changeDimensions();

    var selectedExTile = document.getElementById('externalTile');
    selectedExTile.addEventListener("change", function(){
        doAjaxExtTile();
    });

    var selectedIntTile = document.getElementById('internalTile');
    selectedIntTile.addEventListener("change", function(){
        doAjaxIntTile();
    });
    var selectedMidTile = document.getElementById('middleTile');
    selectedMidTile.addEventListener("change", function(){
        doAjaxMidTile();
    });

    var selectedFirstFrame= document.getElementById('firstFrame');
    selectedFirstFrame.addEventListener("change", function(){
        doAjaxFirstFrame();
    });
    var selectedSecondFrame= document.getElementById('secondFrame');
    selectedSecondFrame.addEventListener("change", function(){
        doAjaxSecondFrame();
    });

    var width = document.getElementById('width');
    var height = document.getElementById('height');

    width.addEventListener("change",changeDimensions);
    height.addEventListener("change",changeDimensions);



    function changeDimensions() {
        var svgGlass = document.getElementById('svgGlass');
        var glass = document.getElementById('glass');
        var width = document.getElementById('width');
        var height = document.getElementById('height');
        var textWidth = document.getElementById('textWidth');
        var textHeight = document.getElementById('textHeight');


        svgGlass.setAttribute('width',width.value / 6);
        glass.setAttribute('width',width.value / 6);
        svgGlass.setAttribute('height',height.value / 6);
        glass.setAttribute('height',height.value / 6);
        textHeight.innerHTML = height.value + " [mm]";
        textWidth.innerHTML = width.value + " [mm]";


    }

    function doAjaxExtTile(){
        var id = document.getElementById('externalTile').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/"+id,
            dataType: "json",
        }).done(function(result) {


            var exTile = document.getElementById('exTile');
            var svgExTile = document.getElementById('svgExTile');
            svgExTile.setAttribute("width",result["thickness"] * 4);
            exTile.setAttribute("width",result["thickness"] * 4);
            if(result.coating.lowEmisly){
                var coating = document.getElementById("svgCoatingExt");
                coating.setAttribute("display","inline");
            }else {
                var coating = document.getElementById("svgCoatingExt");
                coating.setAttribute("display","none");
            }

            if(result.isTempered){
                exTile.setAttribute("style","fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)")
            }else{
                exTile.setAttribute("style","fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)")
            }

        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxMidTile(){
        var id = document.getElementById('middleTile').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/"+id,
            dataType: "json",
        }).done(function(result) {


            var midTile = document.getElementById('midTile');
            var svgMidTile = document.getElementById('svgMidTile');
            svgMidTile.setAttribute("width",result["thickness"] * 4);
            midTile.setAttribute("width",result["thickness"] * 4);
            if(result.coating.lowEmisly){
                var coating = document.getElementById("svgCoatingMid");
                coating.setAttribute("display","inline");
            }else {
                var coating = document.getElementById("svgCoatingMid");
                coating.setAttribute("display","none");
            }

            if(result.isTempered){
                midTile.setAttribute("style","fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)")
            }else{
                midTile.setAttribute("style","fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)")
            }

        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxIntTile(){
        var id = document.getElementById('internalTile').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/"+id,
            dataType: "json",
        }).done(function(result) {


            var intTile = document.getElementById('intTile');
            var svgintTile = document.getElementById('svgIntTile');
            svgintTile.setAttribute("width",result["thickness"] * 4);
            intTile.setAttribute("width",result["thickness"] * 4);


            if(result.coating.lowEmisly){
                var coating = document.getElementById("svgCoatingInt");
                coating.setAttribute("display","inline");
            }else {
                var coating = document.getElementById("svgCoatingInt");
                coating.setAttribute("display","none");
            }
            if(result.isTempered){
                intTile.setAttribute("style","fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)")
            }else{
                intTile.setAttribute("style","fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)")
            }

        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxFirstFrame(){
        var id = document.getElementById('firstFrame').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/"+id,
            dataType: "json",
        }).done(function(result) {

            var firstFrame = document.getElementById('firstFrameSvg');
            var svgFirstFrame = document.getElementById('svgFirstFrame');
            var firstFrameBottom = document.getElementById('firstFrameBottom')
            svgFirstFrame.setAttribute("width",result["thickness"] * 4);
            firstFrame.setAttribute("width",result["thickness"] * 4);
            firstFrameBottom.setAttribute("width",result["thickness"] * 4);


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxSecondFrame(){
        var id = document.getElementById('secondFrame').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/"+id,
            dataType: "json",
        }).done(function(result) {

            var secondframe = document.getElementById('secondFrameSvg');
            var svgSecondFrame = document.getElementById('svgSecondFrame');
            var secondFrameBottom =document.getElementById('secondFrameBottom')
            secondframe.setAttribute("width",result["thickness"] * 4);
            svgSecondFrame.setAttribute("width",result["thickness"] * 4);
            secondFrameBottom.setAttribute("width",result["thickness"] * 4);


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }
});

