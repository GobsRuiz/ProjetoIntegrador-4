var bandeiras = document.querySelectorAll('.bandeiras-bandeira');
var legendas = document.querySelectorAll('.bandeiras-legenda');
var tituloIdioma = document.querySelectorAll('.tituloIdioma');
var textoIdioma = document.querySelectorAll('.textoIdioma');
var brTituloIdioma = [
    "A Rádio",
    "Entreterimento",
    "Estrutura física",
    "Perfil personalizado",
    "Pioneira em tecnologia"
]
var enTituloIdioma = [
    "title1",
    "title2",
    "title3",
    "title4",
    "title5"
]
var brTextoIdioma = [
    "A Rádio CANAL UM FM 93,7 está situada à Avenida Francisco Area Leão, nº 1200, Nova Prudente, Taquaritinga-SP, entrou no ar aos 10 minutos do dia 22 de setembro de 1988, oito meses depois de outorgada, um recorde nacional até agora não superado. Rádio que hoje, com 35.000 Watts (classe A1), leva seu nome para 180 cidades do estado de São Paulo pelas ondas do rádio no Brasil e mundo pela internet.",
    "O perfil da emissora se notabiliza pelo Jornalismo autêntico, sério e responsável e com uma programação diversificada atinge todos os gêneros musicais. As promoções criativas, associadas à fidelidade dos nossos ouvintes e anunciantes, crescem a cada dia e o entrelaçamento destas parcerias sempre nos abre os caminhos do sucesso.",
    "O perfil da emissora se notabiliza pelo Jornalismo autêntico, sério e responsável e com uma programação diversificada atinge todos os gêneros musicais. As promoções criativas, associadas à fidelidade dos nossos ouvintes e anunciantes, crescem a cada dia e o entrelaçamento destas parcerias sempre nos abre os caminhos do sucesso.",
    "O perfil da emissora se notabiliza pelo Jornalismo autêntico, sério e responsável e com uma programação diversificada atinge todos os gêneros musicais. As promoções criativas, associadas à fidelidade dos nossos ouvintes e anunciantes, crescem a cada dia e o entrelaçamento destas parcerias sempre nos abre os caminhos do sucesso.",
    "A Rádio CANAL UM FM 93,7 opera com o sistema Audio-Vault Digital, com capacidade para operar 72 horas automaticamente. Esse SISTEMA COMPUTADORIZADO, melhora a altíssima definição de áudio, já que o seu grau de distorção não passa de 0,001%. Neste Sistema a Emissora utiliza todos os programas musicais facilitando a área jornalística a trabalhar diretamente com a INTERNET em computadores ligados ao estúdio. Em abril de 1995, tornou-se a pioneira também ao transmitir no SISTEMA “RDS” (que demonstra no display do aparelho receptor o nome da rádio e futuramente os nomes das músicas executadas), recurso que só agora está equipando os receptores automotivos e domésticos.",
]
var enTextoIdioma = [
    "txt en1",
    "txt en2",
    "txt en3",
    "tittxt en4",
    "txt en5"
]
var index = 0;




bandeiras[1].style.display = 'none';
legendas[1].style.display = 'none';

function mostrarLegenda() {
    bandeiras.forEach(element => {
        element.addEventListener('mouseover', function() {
            legendas[index].style.opacity = "1";
        })

        element.addEventListener('mouseout', function() {
            legendas[index].style.opacity = "0";
        })
    });
}mostrarLegenda()

function mudardIdioma() {
    bandeiras.forEach(element => {
        element.addEventListener('click', function() {
            if(index === 0){
                mudarBandeiraLegenda()
                mudarTexto()
                index = 1;
            }else if(index === 1){
                mudarBandeiraLegenda()
                mudarTexto()
                index = 0;
            }
        })
    });
}mudardIdioma()

function mudarBandeiraLegenda() {
    if(index === 0){
        bandeiras[0].style.display = 'none';
        legendas[0].style.display = 'none';
        bandeiras[1].style.display = 'block';
        legendas[1].style.display = 'block';
    }else if(index === 1){
        bandeiras[0].style.display = 'block';
        legendas[0].style.display = 'block';
        bandeiras[1].style.display = 'none';
        legendas[1].style.display = 'none';
    }
}

function mudarTexto() {
    if(index === 0){
        for (let i = 0; i < enTituloIdioma.length; i++) {
            tituloIdioma[i].innerHTML = enTituloIdioma[i];
            textoIdioma[i].innerHTML = enTextoIdioma[i];
        }
    }else if(index === 1){
        for (let i = 0; i < brTituloIdioma.length; i++) {
            tituloIdioma[i].innerHTML = brTituloIdioma[i];
            textoIdioma[i].innerHTML = brTextoIdioma[i];
        }
    }
}

