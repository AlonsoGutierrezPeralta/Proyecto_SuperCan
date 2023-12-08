/**
 * 
 */
 
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
//carrusel
var imagenes = new Array("img/felicidad1.jpg","img/felicidad2.jpg",
"img/felicidad3.jpg","img/felicidad4.jpg");
var texto = new Array("Compartenos tu felicidad con tu mascota",
"Los perros no son toda tu vida, pero hacen tu vida completa",
"Un perro mueve la cola... con su corazon","Tu mascota es tu Familia");
var contador = 0;
var contador2=0;
function carrusel(){
    contador++;
    if(contador >= 4) contador=0;
    document.getElementById("imgcab").setAttribute("src",imagenes[contador]); 
    document.getElementById("pruebita").innerHTML =   texto[contador];
    

    setTimeout("carrusel()",3000);
}

document.body.setAttribute("onload","carrusel()");
//Validar formulario
//validar el nombre
document.querySelector("input[name='nombres']").addEventListener("keypress", function(event){
    var longitud = document.querySelector("input[name='nombres']").value.length;

    if(longitud >= 25) {
        alert("estimado usuario usted ha ingresado mas de 25 digitos")
        window.event.preventDefault();
        return;
    } 
    var ascci = event.keycode || event.which;
    if(ascci>=48 && ascci<=57) {
        alert ("Estimado usuario, usted ha ingresado un valor que no es una letra");
        window.event.preventDefault();
        return;
    }
});
//Validar el apellido
document.querySelector("input[name='apellidos']").addEventListener("keypress", function(event){
    var longitud = document.querySelector("input[name='apellidos']").value.length;
    if(longitud >= 50) {
        alert("estimado usuario usted ha ingresado mas de 50 digitos")
        window.event.preventDefault();
        return;
    } 
    var ascci = event.keycode || event.which;
    if(ascci>=48 && ascci<=57) {
        alert ("Estimado usuario, usted ha ingresado un valor que no es una letra");
        window.event.preventDefault();
        return;
    }
});
//validar telefono
document.querySelector("input[name='telefono']").addEventListener("keypress", function(event){
    var longitud = document.querySelector("input[name='telefono']").value.length;
    if(longitud >= 9) {
        
        window.event.preventDefault();
        return;
    }

    var ascci = event.keycode || event.which;
    if(ascci<48 || ascci>57) {
        alert ("Estimado usuario, ingrese su número telefónico");
        window.event.preventDefault();
        return;
    }
});


function nuevo (frm) {
    //validar  campo apellido
    test = /^\s*$/;
    if(test.test(frm.apellidos.value)){
        window.event.preventDefault();
        alert("Estimado Usuario, ingrese el nombre"); 
        return;
    }
    //Validar  campo nombre
    test = /^\s*$/;
    if(test.test(frm.nombres.value)){
        window.event.preventDefault();
        alert("Estimado Usuario, ingrese el nombre"); 
        return;
    }
    //Validar correo electronico
    test = /^([a-zA-Z0-9 ._%])+[@]([a-z])+[.][a-z]{2,3}$/;
    if(!test.test(frm.correo.value)){
        window.event.preventDefault();
        alert("Estimado Usuario, el correo electronico es incorrecto "); 
        return;
    }
    //validar numero telefonico
    test = /^[2-9][0-9]{7,9}$/;
    if(!test.test(frm.telefono.value)){
        window.event.preventDefault();
        alert("Estimado Usuario, el telefono debe tener de 9 digitos"); 
        return;
    }
    alert ("Su información fue registrada satisfactoriamente")
}


//Funcionamiento del formulario


    const $form = document.querySelector('#form')
    const $buttonMailto = document.querySelector('#trucazo')
    const $image = document.querySelector('#image')
    const $file = document.querySelector('#file')
    function renderImage(formData) {
      const file = formData.get('image')
      const image = URL.createObjectURL(file)
      $image.setAttribute('src', image)
    }

    const $username = document.querySelector('#nombres')
    function renderUsername(formData) {
      const username = formData.get('nombres')
      $username.textContent = username
    }

    $file.addEventListener('change', (event) => {
      const formData = new FormData($form)
      renderImage(formData)
    })

    $form.addEventListener('submit', (event) => {
      event.preventDefault()
      const formData = new FormData(event.currentTarget)
      renderUsername(formData)
    
      })

    

    $form.addEventListener('submit', handleSubmit)

    function handleSubmit(event) {
      event.preventDefault()
      const form = new FormData(this)
      $buttonMailto.setAttribute('href', `mailto:alonsogutierrezperalta@gmail.com?subject=nombre y apellidos: ${form.get('nombres')} ${form.get('apellidos')} correo:${form.get('correo')} 
      telefono: ${form.get('telefono')} &body=${form.get('message')} imagen:${form.get('image')} `)
      $buttonMailto.click()
    }

