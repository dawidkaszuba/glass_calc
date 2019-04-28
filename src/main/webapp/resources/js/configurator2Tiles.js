$(function(){

    doAjaxExtTile();
    doAjaxFrame();
    doAjaxIntTile();
    changeDimensions();
    updateName();
    doAjaxGroupTiles();

    var selectedExTile = document.getElementById('externalTile');
    selectedExTile.addEventListener("change", function(){
        doAjaxExtTile();
    });

    var selectedIntTile = document.getElementById('internalTile');
    selectedIntTile.addEventListener("change", function(){
        doAjaxIntTile();
    });

    var selectedFrame= document.getElementById('frame');
    selectedFrame.addEventListener("change", function(){
        doAjaxFrame();
    });

    var width = document.getElementById('width');
    var height = document.getElementById('height');

    width.addEventListener("change",changeDimensions);
    height.addEventListener("change",changeDimensions);

    var exTileName = document.getElementById('exTileName');
    var exTilePopup = document.getElementById('exTilePopup');
    exTileName.addEventListener("click", function(){
        exTilePopup.style.display='inline';
    });

    var tilesGroup = document.getElementById('tilesGroup');
    tilesGroup.addEventListener('change',doAjaxGroupTiles);

    var name = document.getElementById('externalTile');
    exTileName.innerText = name.options[name.selectedIndex].text;

    var close = document.getElementById('close');
    close.addEventListener('click',function () {
        var exTilePopup = document.getElementById('exTilePopup');
        exTilePopup.style.display='none';
    })


    function updateName(){

        var exTileName = document.getElementById('exTileName');
        var name = document.getElementById('externalTile');
        name.addEventListener("change", function(){
            exTileName.innerText = this.options[this.selectedIndex].text

        })

    }


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

    function doAjaxGroupTiles(){
        var id = document.getElementById('tilesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var externalTile = document.getElementById('externalTile');

            for(var i = 0; i < externalTile.options.length; i++){
                externalTile.options[i].style.display='none';
            }


            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                externalTile.appendChild(option);
            }


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
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

    function doAjaxFrame(){
        var id = document.getElementById('frame').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/"+id,
            dataType: "json",
        }).done(function(result) {

            var frame = document.getElementById('glassFrame');
            var svgFrame = document.getElementById('svgFrame');
            var frameBottom =document.getElementById('frameBottom')
            svgFrame.setAttribute("width",result["thickness"] * 4);
            frame.setAttribute("width",result["thickness"] * 4);
            frameBottom.setAttribute("width",result["thickness"] * 4);


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }
});

