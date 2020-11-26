// Página notícias
var noticias_texto = document.querySelectorAll(".noticia-slider-card-texto");


noticias_texto.forEach(element => {
    console.log(element)
    if(screen.width > 1024){
        if(element.innerText.length >= 150){
            element.innerText = element.innerText.substr(0, 130) + "...";
        }
    }
});



// Dashboard - Notícias
var dashNoticias_texto = document.querySelectorAll(".dashNoticiaTexto");

dashNoticias_texto.forEach(element => {
    if(screen.width > 1024){
        if(element.innerText.length >= 150){
            element.innerText = element.innerText.substr(0, 130) + "...";
        }
    }
    else if(screen.width < 1024){
        if(element.innerText.length > 10){
            element.innerText = element.innerText.substr(0, 50) + "...";
        }
    }
});
