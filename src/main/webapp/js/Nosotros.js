/**
 * 
 */
 
 //Carrusel
var imagenes = new Array("img/nosotros1.png", "img/nosotros2.png");
var contador = 0;
function carrusel(){
    contador++;
    if(contador >= 2) contador=0;
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