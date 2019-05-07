$(function(){

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
        }, 10)
    }

    var submit = document.getElementById('submit');
    submit.addEventListener("click", function(){
        progressbar.style.display='inline'
        myLoop();


    })


});

