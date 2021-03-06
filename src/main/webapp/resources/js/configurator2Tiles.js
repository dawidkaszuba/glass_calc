$(function(){

    doAjaxExtTile();
    doAjaxFrame();
    doAjaxIntTile();
    changeDimensions();

    doAjaxGroup('tilesGroup','externalTile',"http://localhost:8080/tile/allByGroupId/");
    doAjaxGroup('intTilesGroup','internalTile',"http://localhost:8080/tile/allByGroupId/");
    doAjaxGroup('framesGroup','frame',"http://localhost:8080/frame/allByGroupId/");
    updateName('intTileName','internalTile');
    updateName('exTileName', 'externalTile');
    updateName('frameName', 'frame');

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

    var intTileName = document.getElementById('intTileName');
    var intTilePopup = document.getElementById('intTilePopup');
    intTileName.addEventListener("click", function(){
        intTilePopup.style.display='inline';
    });

    var frameName = document.getElementById('frameName');
    var framePopup = document.getElementById('framePopup');
    frameName.addEventListener("click", function(){
        framePopup.style.display='inline';
    });

    var tilesGroup = document.getElementById('tilesGroup');
    tilesGroup.addEventListener('change',function () {
        doAjaxGroup('tilesGroup','externalTile',"http://localhost:8080/tile/allByGroupId/");

    });

    var intTilesGroup = document.getElementById('intTilesGroup');
    intTilesGroup.addEventListener('change',function () {
        doAjaxGroup('intTilesGroup','internalTile',"http://localhost:8080/tile/allByGroupId/");
    });

    var frameGroup = document.getElementById('framesGroup');
    frameGroup.addEventListener('change', function () {
        doAjaxGroup('framesGroup','frame',"http://localhost:8080/frame/allByGroupId/")
    });

    var extTileButton = document.getElementById('externalTile');
    exTileName.innerText = extTileButton.options[extTileButton.selectedIndex].text;

    var intTileButton = document.getElementById('internalTile');
    intTileName.innerText = intTileButton.options[intTileButton.selectedIndex].text;

    var frameButton = document.getElementById('frame');
    frameName.innerText = frameButton.options[frameButton.selectedIndex].text;



    var close = document.getElementById('close');
    close.addEventListener('click',function () {
        var exTilePopup = document.getElementById('exTilePopup');
        exTilePopup.style.display='none';
    });

    var intTilePopupClose = document.getElementById('intTilePopupClose');
    intTilePopupClose.addEventListener('click',function () {
        var intTilePopup = document.getElementById('intTilePopup');
        intTilePopup.style.display='none';
    });

    var framePopupClose = document.getElementById('framePopupClose');
    framePopupClose.addEventListener('click',function () {
        var frameTilePopup = document.getElementById('framePopup');
        frameTilePopup.style.display='none';
    });

    function updateName(div,element){

        var divName = document.getElementById(div);
        var name = document.getElementById(element);
        name.addEventListener("change", function(){
            divName.innerText = this.options[this.selectedIndex].text;
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

    function doAjaxGroup(group, element, url){

       var id = document.getElementById(group).value;
          $.ajax({
            type:"GET",
            url:url+id,
            dataType: "json",
        }).done(function(result) {

            var tiles = document.getElementById(element);

            for(var i = 0; i < tiles.options.length; i++){
                tiles.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                tiles.appendChild(option);
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
            $('#exTile').siblings().remove();

            if(result.foil !==null){

                for(var i = 0; i < result.quantityOfFoils; i++) {
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class", "extFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - (result.quantityOfFoils*1.5 - i*3)));
                    svgExTile.appendChild(foil);
                }
            }else{
                for(var l=0; l<$('.extFoil').size;l++) {
                    this.remove();
                }

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
            var coating = document.getElementById("svgCoatingInt");
            svgintTile.setAttribute("width",result["thickness"] * 4);
            intTile.setAttribute("width",result["thickness"] * 4);


            if(result.coating.lowEmisly){

                coating.setAttribute("display","inline");
            }else {
                coating.setAttribute("display","none");
            }
            if(result.isTempered){
                intTile.setAttribute("style","fill:rgb(0,0,102);stroke-width:3;stroke:rgb(0,0,0)")
            }else{
                intTile.setAttribute("style","fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)")
            }
             $('#intTile').siblings().remove();

            if(result.foil != null){


                for(var j = 0; j < result.quantityOfFoils; j++) {
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class",".intFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - (result.quantityOfFoils*1.5 - j*3)));
                    svgintTile.appendChild(foil);
                }
            }else{
                for(var l=0; l<$('.intFoil').size;l++) {
                    this.remove();
                }

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
            var frameBottom = document.getElementById('frameBottom')
            svgFrame.setAttribute("width",result["thickness"] * 4);
            frame.setAttribute("width",result["thickness"] * 4);
            frameBottom.setAttribute("width",result["thickness"] * 4);

        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }
});

