// Slider
var noticiaSlider_all = document.querySelectorAll(".noticia-slider");
var noticiaSlider_width = document.querySelector(".noticia-slider").clientWidth;
// Content
var noticiaSliderNoticias = document.querySelectorAll(".noticia-slider-noticias");
// Buttons
var noticiaSliderNextBtn = document.querySelectorAll(".noticia-slider-nextBtn");
var noticiaSliderPrevBtn = document.querySelectorAll(".noticia-slider-prevBtn");
// Cards
var noticiaSliderCard_all = document.querySelectorAll(".noticia-slider-card");
var noticiaSliderCard_height = document.querySelector(".noticia-slider-card").clientHeight;

var heightSlider = noticiaSliderCard_height * 2 + 100;
var widthCard = noticiaSlider_width / 3 - 80;

var indexs = []
var translatexs = []

// Functions
// Height slider
function setHeightSlider() {
    noticiaSlider_all.forEach(element => {
        element.style.height = heightSlider + "px";
    });
}setHeightSlider()

// Width cards
function setWidthCards() {
    noticiaSliderCard_all.forEach(element => {
        element.style.width = widthCard + "px";

    });
}setWidthCards()


// Get indexs and translatexs
function getIndexTranslatexs() {
    for(i = 0; i < noticiaSlider_all.length; i++){
        indexs[i] = 1;
    }

    for(i = 0; i < noticiaSlider_all.length; i++){
        translatexs[i] = 0;
    }
}getIndexTranslatexs()


// Buttons
function nextBtn(){
    noticiaSliderNextBtn.forEach(element => {
        element.addEventListener('click', event => {
            var btnPosition = 0;
            var children = 0;

            btnPosition = nextBtnPosition(event.target.id);
            children = noticiaSliderNoticias[btnPosition].children;

            if(indexs[btnPosition] < children.length){
                indexs[btnPosition] += 1;
                translatexs[btnPosition] -= noticiaSlider_width;
                slider(btnPosition)
            }else{
                indexs[btnPosition] = 1;
                translatexs[btnPosition] = 0;
                slider(btnPosition)
            }

            
        })
    });
}nextBtn()
function prevBtn(){
    noticiaSliderPrevBtn.forEach(element => {
        element.addEventListener('click', event => {
            var btnPosition = 0;
            var children = 0;

            btnPosition = prevBtnPosition(event.target.id);
            children = noticiaSliderNoticias[btnPosition].children;

            if(indexs[btnPosition] > 1){
                indexs[btnPosition] -= 1;
                translatexs[btnPosition] += noticiaSlider_width;
                slider(btnPosition)
            }else{
                indexs[btnPosition] = 2;
                translatexs[btnPosition] = -noticiaSlider_width * (children.length -1);
                slider(btnPosition)
            }

            
        })
    });
}prevBtn()


// Get button position
function nextBtnPosition(btnId){
    var positionBtn = 0
    for(i = 0; i < noticiaSliderNextBtn.length; i++){
        if(btnId == noticiaSliderNextBtn[i].id){
            positionBtn = i;
        }
    }
    return positionBtn;
}
function prevBtnPosition(btnId){
    var positionBtn = 0
    for(i = 0; i < noticiaSliderPrevBtn.length; i++){
        if(btnId == noticiaSliderPrevBtn[i].id){
            positionBtn = i;
        }
    }
    return positionBtn;
}


// Slider
function slider(btnPosition) {
    noticiaSliderNoticias[btnPosition].style.transform = `translateX(${translatexs[btnPosition]}px)`;
}