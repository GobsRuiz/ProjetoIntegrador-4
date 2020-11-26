// Página notícias
var noticias_texto = document.querySelectorAll(".noticia-slider-card-texto");
var noticias_titulo = document.querySelectorAll(".noticia-slider-card-titulo");


noticias_texto.forEach(element => {
    console.log(element)
    if(screen.width > 1024){
        if(element.innerText.length >= 150){
            element.innerText = element.innerText.substr(0, 130) + "...";
        }
    }
});
noticias_titulo.forEach(element => {
    console.log(element)
    if(screen.width > 1024){
        if(element.innerText.length >= 45){
            element.innerText = element.innerText.substr(0, 40) + "...";
        }
    }
});



// Dashboard - Notícias
var dashNoticias_texto = document.querySelectorAll(".dashNoticiaTexto");

dashNoticias_texto.forEach(element => {
    if(screen.width > 1024){
        if(element.innerText.length >= 150){
            element.innerText = element.innerText.substr(0, 150) + "...";
        }
    }
    else if(screen.width < 1024){
        if(element.innerText.length > 150){
            element.innerText = element.innerText.substr(0, 150) + "...";
        }
    }
});
