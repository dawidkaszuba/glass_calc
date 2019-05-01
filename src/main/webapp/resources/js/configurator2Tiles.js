$(function(){

    doAjaxExtTile();
    doAjaxFrame();
    doAjaxIntTile();
    changeDimensions();

    doAjaxGroupTiles('tilesGroup','externalTile');
    doAjaxIntTilesGroup();
    updateName('intTileName','internalTile');
    updateName('exTileName', 'externalTile');
    updateName('frameName', 'frame');
    doAjaxGroupsFrame();

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
    tilesGroup.addEventListener('change',doAjaxGroupTiles);

    var intTilesGroup = document.getElementById('intTilesGroup');
    intTilesGroup.addEventListener('change',doAjaxIntTilesGroup);

     var frameGroup = document.getElementById('framesGroup');
    frameGroup.addEventListener('change', doAjaxGroupsFrame);

    var name1 = document.getElementById('externalTile');
    exTileName.innerText = name1.options[name1.selectedIndex].text;

    var name2 = document.getElementById('internalTile');
    intTileName.innerText = name2.options[name2.selectedIndex].text;

    var name3 = document.getElementById('frame');
    frameName.innerText = name3.options[name3.selectedIndex].text;



    var close = document.getElementById('close');
    close.addEventListener('click',function () {
        var exTilePopup = document.getElementById('exTilePopup');
        exTilePopup.style.display='none';
    })

    var intTilePopupClose = document.getElementById('intTilePopupClose');
    intTilePopupClose.addEventListener('click',function () {
        var intTilePopup = document.getElementById('intTilePopup');
        intTilePopup.style.display='none';
    })

    var framePopupClose = document.getElementById('framePopupClose');
    framePopupClose.addEventListener('click',function () {
        var frameTilePopup = document.getElementById('framePopup');
        frameTilePopup.style.display='none';
    })

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

    function doAjaxGroupTiles(group, tile){

        //var id = document.getElementById(group).value;
        var id = document.getElementById('tilesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

           var tiles = document.getElementById('externalTile');
           // var tiles = document.getElementById(tile);

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

    function doAjaxGroupsFrame(){


        var id = document.getElementById('framesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var frames = document.getElementById('frame');

            for(var i = 0; i < frames.options.length; i++){
                frames.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                frames.appendChild(option);
            }


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxIntTilesGroup(){
        var id = document.getElementById('intTilesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var internalTile = document.getElementById('internalTile');

            for(var i = 0; i < internalTile.options.length; i++){
                internalTile.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                internalTile.appendChild(option);
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
                    var foilThickness = i * 3;
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class", "extFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - 2)+foilThickness);
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
                    var foilThickness = j * 3;
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class",".intFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - 2)+foilThickness);
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

