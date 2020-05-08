// quando il DOM è ready -> la funzione verrà chiamata da jQuery quando il DOM ha finito di caricarsi
$(() => {
    console.log(' ho finito di caricare il DOM');
    // DOM: Document Object Model: è la rappresetnazione in memoria (nel contesto di esecuzione JS del browser) di tutti gli
    // elementi presenti in dato momento nella pagina (nel documento html); il DOM può essere letto/alterato da JS nella 
    // sua totalità. In questo sta lo sviluppo della UI web: nella manipolazione del DOM per rapppresentare una situazione
    // del notro programma
    // il DOM è caricato, posso

    caricaPersone();

    $('#btn-indietro').click(() => {
        $('#tbl-persone').toggle();
        $('#dettaglio').toggle();
        caricaPersone();
    });

});

function caricaPersone() {
    $.ajax({
        url: 'http://localhost:8080/prima-rest-api/persone',
        method: 'get',
    }).done((persone) => {
        // la chimata ajax si è conclusa in modo positivo (eg. httpstatus = 200)
        console.log('tutto ok', persone);

        // ` (alt + 96) è il delimitatore per attivare l'interpolazione delle stringhe
        $('#tbl-persone > tbody').empty();
        persone.forEach(persona => {
            $('#tbl-persone > tbody').append(`<tr>
                <td>${persona.nome}</td>
                <td>${persona.cognome}</td>
                <td>${persona.email}</td>
                <td>
                   <button class="btn btn-secondary" onclick="apriDettaglio('${persona.nome}', '${persona.cognome}', '${persona.email}')">Apri dettagli</button>
                   <button class="btn btn-secondary" onclick="caricaDettaglio('${persona.email}')">Ricarica dettagli</button>
                </td>
            </tr>`);
        });
    }).fail(() => {
        // la chimata ajax si è conclusa in modo negativo (eg. httpstatus = 500)
        console.warn('qualcosa è andato storto');
    });
}

function apriDettaglio(nome, cognome, email) {
    $('#tbl-persone').toggle();
    $('#dettaglio').toggle();
    console.log(nome, cognome, email);
    $('#lbl-nome').text(nome);
    $('#lbl-cognome').text(cognome);
    $('#lbl-email').text(email);
}

function caricaDettaglio(email) {
    $.ajax({
        url: `http://localhost:8080/prima-rest-api/persone?email=${email}`,
        method: 'get',
    }).done((persona) => {
        $('#tbl-persone').toggle();
        $('#dettaglio').toggle();
        $('#lbl-nome').text(persona.nome);
        $('#lbl-cognome').text(persona.cognome);
        $('#lbl-email').text(persona.email);
    });
}






// JS ha un type system dinamico (non come Java che ha un TS statico)
var a = 10;
var b = 'testo';
var c = {
    nome: 'Andrea',
    cognome: 'Colleoni'
}
var d = [
    1, 4, 8, 10, 14
]
a = 'ciccio';

// defnisco la funzione f
function f() {
    console.log('ciao io sono f()');
}

// con le paretesi tonde faccio una call alla funzione f()
f();

var g = function() {
    console.log('ciao io sono g()');
}

g();

// definizione di una funzione h() usando la contrazione sintattica detta lambda expression
var h = () => console.log('ciao io sono h()');

h();