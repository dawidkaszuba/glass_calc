$(function(){

    doAjaxExtTile();
    doAjaxFirstFrame();
    doAjaxSecondFrame();
    doAjaxIntTile();
    doAjaxMidTile();
    changeDimensions();

    doAjaxIntTilesGroup();
    doAjaxGroupTiles();
    doAjaxMidTilesGroup();
    updateName('intTileName','internalTile');
    updateName('exTileName', 'externalTile');
    updateName('midTileName', 'middleTile');
    updateName('firstFrameName', 'firstFrame');
    updateName('secondFrameName', 'secondFrame');
    doAjaxGroupsFirstFrame();
    doAjaxGroupsSecondFrame();

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

    var midTileName = document.getElementById('midTileName');
    var midTilePopup = document.getElementById('midTilePopup');
    midTileName.addEventListener("click", function(){
        midTilePopup.style.display='inline';
    });

    var firstFrameName = document.getElementById('firstFrameName');
    var firstFramePopup = document.getElementById('firstFramePopup');
    firstFrameName.addEventListener("click", function(){
        firstFramePopup.style.display='inline';
    });

    var secondFrameName = document.getElementById('secondFrameName');
    var secondFramePopup = document.getElementById('secondFramePopup');
    secondFrameName.addEventListener("click", function(){
        secondFramePopup.style.display='inline';
    });

    var name1 = document.getElementById('externalTile');
    exTileName.innerText = name1.options[name1.selectedIndex].text;

    var name2 = document.getElementById('internalTile');
    intTileName.innerText = name2.options[name2.selectedIndex].text;

    var name3 = document.getElementById('middleTile');
    midTileName.innerText = name3.options[name3.selectedIndex].text;

    var name4 = document.getElementById('firstFrame');
    firstFrameName.innerText = name4.options[name4.selectedIndex].text;

    var name5 = document.getElementById('firstFrame');
    secondFrameName.innerText = name5.options[name5.selectedIndex].text;

    var tilesGroup = document.getElementById('tilesGroup');
    tilesGroup.addEventListener('change',doAjaxGroupTiles);

    var intTilesGroup = document.getElementById('intTilesGroup');
    intTilesGroup.addEventListener('change',doAjaxIntTilesGroup);

    var midTilesGroup = document.getElementById('midTilesGroup');
    midTilesGroup.addEventListener('change',doAjaxMidTilesGroup);

    var firstFrameGroup = document.getElementById('firstFramesGroup');
    firstFrameGroup.addEventListener('change',doAjaxGroupsFirstFrame);

    var secondFrameGroup = document.getElementById('secondFramesGroup');
    secondFrameGroup.addEventListener('change',doAjaxGroupsSecondFrame);

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

    var midTilePopupClose = document.getElementById('midTilePopupClose');
    midTilePopupClose.addEventListener('click',function () {
        var midTilePopup = document.getElementById('midTilePopup');
        midTilePopup.style.display='none';
    });

    var firstFramePopupClose = document.getElementById('firstFramePopupClose');
    firstFramePopupClose.addEventListener('click',function () {
        var firstFrameTilePopup = document.getElementById('firstFramePopup');
        firstFrameTilePopup.style.display='none';
    });

    var secondFramePopupClose = document.getElementById('secondFramePopupClose');
    secondFramePopupClose.addEventListener('click',function () {
        var secondFrameTilePopup = document.getElementById('secondFramePopup');
        secondFrameTilePopup.style.display='none';
    });



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

    function updateName(div,element){

        var divName = document.getElementById(div);
        var name = document.getElementById(element);
        name.addEventListener("change", function(){
            divName.innerText = this.options[this.selectedIndex].text;
        })
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
            var coating = document.getElementById("svgCoatingExt");
            if(result.coating.lowEmisly){

                coating.setAttribute("display","inline");
            }else {

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

            $('#midTile').siblings().remove();

            if(result.foil !==null){

                for(var i = 0; i < result.quantityOfFoils; i++) {
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class", "midFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - (result.quantityOfFoils*1.5 - i*3)));
                    svgMidTile.appendChild(foil);
                }
            }else{
                for(var l=0; l<$('.midFoil').size;l++) {
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
            $('#intTile').siblings().remove();

            if(result.foil !==null){

                for(var i = 0; i < result.quantityOfFoils; i++) {
                    var foil = document.createElementNS("http://www.w3.org/2000/svg", "rect");
                    foil.setAttribute("class", "intFoil");
                    foil.setAttribute("width", "3");
                    foil.setAttribute("height", "300");
                    foil.setAttribute("style", "fill:rgb(127,255,0);stroke:rgb(0,0,0)");
                    foil.setAttribute("x", (((result.thickness * 4) / 2) - (result.quantityOfFoils*1.5 - i*3)));
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

    function doAjaxMidTilesGroup(){
        var id = document.getElementById('midTilesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/tile/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var middleTile = document.getElementById('middleTile');

            for(var i = 0; i < middleTile.options.length; i++){
                middleTile.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                middleTile.appendChild(option);
            }


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxGroupsFirstFrame(){


        var id = document.getElementById('firstFramesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var firstFrames = document.getElementById('firstFrame');

            for(var i = 0; i < firstFrames.options.length; i++){
                firstFrames.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                firstFrames.appendChild(option);
            }


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }

    function doAjaxGroupsSecondFrame(){


        var id = document.getElementById('secondFramesGroup').value;
        $.ajax({
            type:"GET",
            url:"http://localhost:8080/frame/allByGroupId/"+id,
            dataType: "json",
        }).done(function(result) {

            var secondFrames = document.getElementById('secondFrame');

            for(var i = 0; i < secondFrames.options.length; i++){
                secondFrames.options[i].style.display='none';
            }

            for(var j = 0; j < result.length; j++) {

                var option = document.createElement("OPTION");
                option.innerText = result[j]['name'];
                option.value = result[j]['id'];
                secondFrames.appendChild(option);
            }


        }).fail(function(xhr,status,err){
        }).always(function(xhr,status){

        });
    }
});

