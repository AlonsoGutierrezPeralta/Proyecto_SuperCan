/**
 * 
 */
 
 //Carrusel
var imagenes = new Array("img/1.jpg","img/2.jpg","img/3.jpg","img/4.jpg");
var contador = 0;
function carrusel(){
    contador++;
    if(contador >= 4) contador=0;
    document.getElementById("imgcab").setAttribute("src",imagenes[contador]); 
    setTimeout("carrusel()",2000);
}

/*NAV FIJO*/ 
var elementTop = $('.nav').offset().top;

$(window).scroll(function(){
    if( $(window).scrollTop() >= elementTop){
        $('body').addClass('nav_fixed');
    }
    else{
        $('body').removeClass('nav_fixed');
    }
});

document.body.setAttribute("onload","carrusel()");