function validateNumerical(value) {
    if (value.trim() !== "") {
        var rule = /^[0-9]+$/;
        if (!(value.match(rule))) {
            alert("Permitido somente números");
            disableSave();
            return false;
        } else {
            ableSave();
            return true;
        }
    }
}

function validateLetters(value){
    if (value.trim() !== "") {
        var rule = /^[0-9]+$/;
        if ((value.match(rule))) {
            alert("Permitido somente letras");
            disableSave();
            return false;
        } else {
            ableSave();
            return true;
        }
    }
}

function validatePhoneNumber(value){
    validateNumerical(value);
    if (value.length > 11){
        alert("Telefone incorreto. \nInsira somente o DDD, dígito (se houver) e o número.");
        disableSave();
        return false;
    } else {
        ableSave();
        return true;
    }
}

function validateCPF(value) {
    var numbers, digits, sum, i, result, samedigits;
    samedigits = 1;
    value = value.toString();
    
    validateNumerical(value);
    
    if(value.length < 11){
        alert("O CPF precisa conter 11 dígitos");
        disableSave();
        return false;
    }
    for (i = 0; i < value.length - 1; i++){
        if(value.charAt(i) != value.charAt(i+1)){
            samedigits = 0;
            break;
        }else{
            alert("CPF inválido");
            disableSave();
            return false;
        }
    }
    
    if(!samedigits) {
        numbers = value.substring(0,9);
        digits = value.substring(9);
        sum = 0;
        for (i = 10; i > 1; i--){
            sum += numbers.charAt(10 - i) * i;
        }
        result = (sum*10)%11;
                     
        if((result == 10) || (result == 11)){
            result = 0;
        }
        if(result != digits.charAt(0)){
            alert("CPF inválido");
            disableSave();
            return false;
        }
            
        numbers = value.substring(0,10);
        sum = 0;
        for (i = 11; i > 1; i--){
            sum += numbers.charAt(11 - i) * i;
        }
        result = (sum*10)%11;
            
        if((result == 10) || (result == 11)){
            result = 0;
        }
        if(result != digits.charAt(1)){
            alert("CPF inválido");
            disableSave();
            return false;
        }
            ableSave();
            return true;
    }
}

function validateAgeUser(value){
    value = value.toString();
    var birthDay = value.substring(0,2);
    var birthMonth = value.substring(3,5);
    var birthYear = value.substring(6,10);
    var yearsOld;
    
    if ((birthDay <= 00) || (birthDay > 31) ){
        alert("Dia "+birthDay+" inválido");
        disableSave();
        return false;
    }
    if ((birthMonth <= 00)||(birthMonth > 12)){
        alert("Mês "+birthMonth+" inválido");
        disableSave();
        return false;
    }
    
    var today = new Date();
    var day = today.getDate();
    var month = today.getMonth() + 1;
    var year = today.getFullYear();
    
    if(birthYear > year){
        alert("Ano "+birthYear+" inválido");
        disableSave();
        return false;
    }
    
    yearsOld = year - birthYear;
    
    if ((month < birthMonth) || ((month == birthMonth) && (birthDay > day))) {
        yearsOld--;
    }

    if (yearsOld < 18){
        alert("Idade do usuário deve ser maior ou igual a 18 anos");
        disableSave();
        return false;
    } else {
        ableSave();
        return true;
    }
}

function validateAgeJogo(value){
    value = value.toString();
    var birthDay = value.substring(0,2);
    var birthMonth = value.substring(3,5);
    var birthYear = value.substring(6,10);
    var yearsOld;
    
    if ((birthDay <= 00) || (birthDay > 31) ){
        alert("Dia "+birthDay+" inválido");
        disableSave();
        return false;
    }
    if ((birthMonth <= 00)||(birthMonth > 12)){
        alert("Mês "+birthMonth+" inválido");
        disableSave();
        return false;
    }
    
    var today = new Date();
    var day = today.getDate();
    var month = today.getMonth() + 1;
    var year = today.getFullYear();
    
    if(birthYear > year){
        alert("Ano "+birthYear+" inválido");
        disableSave();
        return false;
    }
    
    yearsOld = year - birthYear;
    
    if ((month < birthMonth) || ((month == birthMonth) && (birthDay > day))) {
        yearsOld--;
    }

    if (yearsOld < 16){
        alert("Idade do jogoe deve ser maior ou igual a 16 anos");
        disableSave();
        return false;
    } else {
        ableSave();
        return true;
    }
}

function validateEmail(value){
    var user = value.substring(0, value.indexOf("@"));
    var domain = value.substring(value.indexOf("@")+ 1, value.length); 
 
    if ((user.length >=1) &&
        (domain.length >=3) && 
        (user.search("@")==-1) && 
        (domain.search("@")==-1) &&
        (user.search(" ")==-1) && 
        (domain.search(" ")==-1) &&
        (domain.search(".")!=-1) &&      
        (domain.indexOf(".") >=1)&& 
        (domain.lastIndexOf(".") < domain.length - 1)) {
        
        ableSave();
        return true;
    }else{
        alert("E-mail inválido");
        disableSave();
        return false;
    }
}

function disableSave(){
    document.getElementById('formulario:botaoSalvar').disabled = true;
}

function ableSave(){
    document.getElementById('formulario:botaoSalvar').disabled = false;
}