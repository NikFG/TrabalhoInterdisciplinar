function sair() {
    window.location.href = "index.xhtml";
}

function verificard(){
    var c = document.getElementById('form:datanasc');
    data = c.value;
    var date = new Date(data);
    var hoje = new Date();
    hoje.setDate(hoje.getDate());
    
    var linha = document.getElementById('clinha');
    var campo = document.getElementById('form:caviso');
        
    v = getAge(data);
    
    if(invalidDate(data)){
        c.value="";
        linha.style.display = 'table-cell';
        campo.innerHTML = "Data inválida!";
    } else if (hoje < date) {
        c.value="";
        linha.style.display = 'table-cell';
        campo.innerHTML = "Data inválida!";
    } else if(v<18) {
        c.value="";
        linha.style.display = 'table-cell';
        campo.innerHTML = "Você precisa ter mais de 18 anos!";        
    } else {
        linha.style.display = 'none';
        campo.innerHTML = "Campo correto!";
        if(data.length !== 10){
            res = data.split('/');
            if(res[2]<hoje.getYear()-99){
                datax = res[0] + '/' + res[1] + '/20' + res[2];
            } else {
                datax = res[0] + '/' + res[1] + '/19' + res[2];
            }
            c.value=datax;
        }        
    }
    
}

function verificar1(aux) {
    var c1 = document.getElementById('escolha:entrada');
    var c2 = document.getElementById('escolha:saida');
    data = c1.value;
    res = data.split('/');
    data01 = res[1] + '/' + res[0] + '/' + res[2];
    var data1 = new Date(data01);
    data = c2.value;
    res = data.split('/');
    data02 = res[1] + '/' + res[0] + '/' + res[2];
    var data2 = new Date(data02);
    var hoje = new Date();
    hoje.setDate(hoje.getDate() - 1);
    var alerta = document.getElementById('escolha:alert');
    var campo = document.getElementById('escolha:aviso');
    if (aux == 1) {
        x = invalidDate(data01);
        var c3 = c1;
    } else {
        x = invalidDate(data02);
        var c3 = c2;
    }

    if (x) {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Data inválida!";
        c3.value = "";
    } else if (data1 < hoje) {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Data no passado!";
        c1.value = "";
    } else if (data2 < hoje) {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Data no passado!";
        c2.value = "";
    } else if (data1 > data2) {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Data de entrada após a data de saída!";
        c2.value = "";
    } else if (data1.getTime() === data2.getTime()) {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Data de entrada igual a data de saída!";
        c2.value = "";
    } else {
        alerta.style.visibility = 'hidden';
        campo.innerHTML = "Alerta!";
    }
}

function invalidDate(text) {

    var comp = text.split("/");

    if (text.length != 8 && text.length != 10) {
        return true;
    } else if (comp.length !== 3) {
        return true;
    } else if (comp[0] < 1 || comp[0] > 12) {
        return true;
    } else {
        return false;
    }
}

function verificar2() {
    var sel = document.getElementById('escolha:tipoInner').value;
    var alerta = document.getElementById('escolha:alert2');
    var campo = document.getElementById('escolha:aviso2');

    if (sel == "") {
        alerta.style.visibility = 'visible';
        campo.innerHTML = "Selecione o tipo de quarto!";
    } else {
        alerta.style.visibility = 'hidden';
        campo.innerHTML = "Alerta!";
    }
}

function getAge(dateString) {
    var today = new Date();
    var birthDate = new Date(dateString);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}