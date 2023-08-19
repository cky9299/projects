// let the user to insert their profile picture
function changepic(){
    const reader = new FileReader();
    const choosedFile = document.getElementById('addProfilePic').files[0];

    reader.readAsDataURL(choosedFile);
    reader.onload = function(){
        document.getElementById('proPic').src = this.result;
        document.getElementById('proPic').style.borderRadius = "8px";
        document.getElementById('proPic').style.width = "85px";
        document.getElementById('proPic').style.height = "85px";
        document.getElementById('proPic').style.position = "relative";
        document.getElementById('proPic').style.left = "12px";
    }
}

// show the tick icon id=f the input is valid
function showTick(){
    const input_Name = document.getElementById('signupName');
    const input_Password = document.getElementById('signupPsw');
    const input_Email = document.getElementById('email');
    const input_Phone = document.getElementById('phone');
    const input_Term = document.getElementById('term');

    if(input_Name.checkValidity()){
        document.getElementById('tick1').style.display = "inline-block";
    }
    if(!input_Name.checkValidity()){
        document.getElementById('tick1').style.display = "none";
    }

    if(input_Password.checkValidity()){
        document.getElementById('tick2').style.display = "inline-block";
    }
    if(!input_Password.checkValidity()){
        document.getElementById('tick2').style.display = "none";
    }

    if(input_Email.checkValidity()){
        document.getElementById('tick4').style.display = "inline-block";
    }
    if(!input_Email.checkValidity()){
        document.getElementById('tick4').style.display = "none";
    }

    if(input_Phone.checkValidity()){
        document.getElementById('tick5').style.display = "inline-block";
    }
    if(!input_Phone.checkValidity()){
        document.getElementById('tick5').style.display = "none";
    }

    if(!document.getElementById('day').checkValidity() || !document.getElementById('month').checkValidity() || !document.getElementById('year').checkValidity()){
        document.getElementById('tick6').style.display = "none";
    }
    if(document.getElementById('day').checkValidity() && document.getElementById('month').checkValidity() && document.getElementById('year').checkValidity()){
        document.getElementById('tick6').style.display = "inline-block";
    }


    //only all input valid then able to submit
    if(!input_Name.checkValidity() || !input_Password.checkValidity() || !input_Email.checkValidity() || !input_Phone.checkValidity() || !input_Term.checked){
        document.getElementById('submitBtn').disabled = true;
        document.getElementById('submitBtn').style.cursor = "not-allowed";
    }
    if(input_Name.checkValidity() && input_Password.checkValidity() && input_Email.checkValidity() && input_Phone.checkValidity() && input_Term.checked){
        document.getElementById('submitBtn').disabled = false;
        document.getElementById('submitBtn').style.cursor = "pointer";
    }
}

//check confirm password same or not
function checkpsw(){
    var psw1 = document.getElementById('signupPsw').value;
    var psw2 = document.getElementById('confirmPsw').value;

    if(psw1 == psw2){
        document.getElementById('tick3').style.display = "inline-block";
        document.getElementById('confirmPsw').style.backgroundColor = "rgb(228, 253, 235)";
    }
    else{
        document.getElementById('tick3').style.display = "none";
        document.getElementById('confirmPsw').style.backgroundColor = "white";
    }
}

// clear button to reset all info
function resetform(){
    document.getElementById('proPic').src = "../accPic/addImg.png";
    document.getElementById('tick1').style.display = "none";
    document.getElementById('tick2').style.display = "none";
    document.getElementById('tick3').style.display = "none";
    document.getElementById('tick4').style.display = "none";
    document.getElementById('tick5').style.display = "none";
    document.getElementById('tick6').style.display = "none";

    document.getElementById('submitBtn').style.cursor = "not-allowed";
    document.getElementById('submitBtn').style.backgroundColor = "mediumpurple";
    document.getElementById('submitBtn').style.opacity = "60%";
}


//alert to ask user to confirm submission
function signUpConfirm(){
    var confirmation = confirm("Do you want to submit the sign up form?");
    if(confirmation == true){
        this.form.submit();
    }
    else{
        document.getElementById('submitBtn').disabled = true;
        document.getElementById('submitBtn').style.cursor = "not-allowed";
        document.getElementById('term').checked = false;
    }
}