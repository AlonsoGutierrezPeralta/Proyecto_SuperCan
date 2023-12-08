/**
 * 
 */
 
 let mostrador = document.getElementById("mostrador")
let seleccion = document.getElementById("seleccion")
let imgSeleccionada = document.getElementById("img")
let modeloSeleccionado = document.getElementById("modelo")
let descripSeleccionada = document.getElementById("descripcion")
let precioSellecionado = document.getElementById("precio")

//funcion que carga  la info del item seleccionado
function cargar(items){
    
    mostrador.style.width = "60%";
    seleccion.style.width = "40%";
    seleccion.style.opacity = "1";
    
    
    imgSeleccionada.src = items.getElementsByTagName("img")[0].src;
    modeloSeleccionado.innerHTML = items.getElementsByTagName("p")[0].innerHTML;
    descripSeleccionada.innerHTML = "Descripcion del modelo";
    precioSellecionado.innerHTML = items.getElementsByTagName("span")[0].innerHTML;

}



function cerrar(){
    mostrador.style.width = "60%";
    seleccion.style.width = "0";
    seleccion.style.opacity = "0";
    quitarBordes();
}
