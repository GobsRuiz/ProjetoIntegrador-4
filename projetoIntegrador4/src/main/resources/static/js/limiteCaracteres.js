// Página notícias
var noticias_texto = document.querySelectorAll(".noticia-slider-card-texto");

noticias_texto.forEach(element => {
    if(screen.width > 1024){
        element.innerHTML = element.innerHTML.substr(0, 120) + "...";
    }
    else if(screen.width < 1024){
        element.innerHTML = element.innerHTML.substr(0, 80) + "...";
    }
});



// Dashboard - Notícias
var dashNoticias_texto = document.querySelectorAll(".dashNoticiaTexto");

dashNoticias_texto.forEach(element => {
    if(screen.width > 1024){
        if(element.innerHTML.length > 200){
            element.innerHTML = element.innerHTML.substr(0, 400) + "...";
        }
    }
    else if(screen.width < 1024){
        element.innerHTML = element.innerHTML.substr(0, 80) + "...";
    }
});
