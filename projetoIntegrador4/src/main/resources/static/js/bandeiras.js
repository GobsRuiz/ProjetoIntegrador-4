var bandeiras = document.querySelectorAll('.bandeiras-bandeira');
var legendas = document.querySelectorAll('.bandeiras-legenda');
var tituloIdioma = document.querySelectorAll('.tituloIdioma');
var textoIdioma = document.querySelectorAll('.textoIdioma');
var brTituloIdioma = [
    "A Rádio",
    "Entretenimento",
    "Estrutura física",
    "Perfil personalizado",
    "Pioneira em tecnologia"
]
var enTituloIdioma = [
    "About us",
    "Entertainment",
    "Physical structure",
    "Custom profile",
    "Technology pioneer"
]
var brTextoIdioma = [
    "A Rádio CANAL UM FM 93,7 está situada à Avenida Francisco Area Leão, nº 1200, Nova Prudente, Taquaritinga-SP, entrou no ar aos 10 minutos do dia 22 de setembro de 1988, oito meses depois de outorgada, um recorde nacional até agora não superado. Rádio que hoje, com 35.000 Watts (classe A1), leva seu nome para 180 cidades do estado de São Paulo pelas ondas do rádio no Brasil e mundo pela internet.",
    "A fama de ser a melhor Rádio regional não veio à toa. Além da qualidade musical e comercial para os ouvintes, a rádio CANAL UM sempre se preocupou em agradar o seu público fiel, através de shows e promoções, já trouxe inumeros artistas renomados e fez grandes festa e eventos para agradar os seu clientes, fãs e ouvintes.",
    "Considerada pelos profissionais da área como uma das rádios mais bem equipadas e bonitas do Brasil, a CANAL UM fornece uma excelente estrutura de trabalho para seus funcionários e clientes, sempre visando o melhor atendimento e qualidade desde 1988.",
    "O perfil da emissora se notabiliza pelo Jornalismo autêntico, sério e responsável e com uma programação diversificada atinge todos os gêneros musicais. As promoções criativas, associadas à fidelidade dos nossos ouvintes e anunciantes, crescem a cada dia e o entrelaçamento destas parcerias sempre nos abre os caminhos do sucesso.",
    "A Rádio CANAL UM FM 93,7 opera com o sistema Audio-Vault Digital, com capacidade para operar 72 horas automaticamente. Esse SISTEMA COMPUTADORIZADO, melhora a altíssima definição de áudio, já que o seu grau de distorção não passa de 0,001%. Neste Sistema a Emissora utiliza todos os programas musicais facilitando a área jornalística a trabalhar diretamente com a INTERNET em computadores ligados ao estúdio. Em abril de 1995, tornou-se a pioneira também ao transmitir no SISTEMA “RDS” (que demonstra no display do aparelho receptor o nome da rádio e futuramente os nomes das músicas executadas), recurso que só agora está equipando os receptores automotivos e domésticos.",
]
var enTextoIdioma = [
    "Our Radio CANAL UM FM 93.7 is located at Francisco Area Leão Avenue, nº 1200, Nova Prudente, Taquaritinga-SP, frist went on in September 22nd of 1988, eight months after being granted, a national record until now not overcomed. Nowadays, with 35,000 Watts (class A1), it’s know in up to 180 cities in the state of São Paulo and also is know worldwide all over the internet.",
    "The reputation of being the best regional radio did not come for nothing. In addition to the musical and commercial quality for listeners, the radio CANAL UM has always been concerned with pleasing its loyal audience, through shows and promotions, it has already brought countless renowned artists and made great parties and events to please its customers, fans and listeners",
    "Considered by professionals in the field as one of the best equipped and most beautiful radios in Brazil, CANAL UM provides an excellent working structure for its employees and customers, always aiming for the best service and quality since 1988.",
    "The broadcaster's profile stands out for its authentic, serious and responsible journalism and with a diversified program reaches all musical genres. Creative promotions, associated with the loyalty of our listeners and advertisers, are growing every day and the intertwining of these partnerships always opens the way for us to succeed.",
    "Our Radio CANAL UM FM 93.7 operates with the Audio-Vault Digital system, with the capacity to operate 72 hours automatically. This COMPUTERIZED SYSTEM improves the very high definition of audio, since its degree of distortion is only 0.001%. In this system, the broadcaster uses all musical programs, facilitating a journalistic area to work directly with the INTERNET on computers connected to the studio. In April 1995, it also became a pioneer by transmitting in the SYSTEM “RDS” (which shows the name of the radio on the display of the receiving device and in the future the names of the songs played), a feature that is only now being used in automotive and domestic receivers."
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

