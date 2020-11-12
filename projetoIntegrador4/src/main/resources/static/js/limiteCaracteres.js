var texto = document.querySelectorAll(".noticia-slider-card-texto");

texto.forEach(element => {
    if(screen.width > 1200){
        element.innerHTML = element.innerHTML.substr(0, 120) + "...";
    }
    else if(screen.width < 1200){
        element.innerHTML = element.innerHTML.substr(0, 80) + "...";
    }
});
