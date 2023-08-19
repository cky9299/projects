var rating;

// only rate the star then able to submit
function ableSubmit(){
    document.getElementById('submitBtn3').disabled = false;
}

// click the star will rate
function starfunction1(){
    if(document.getElementById('star1').onclick){
        document.getElementById('star1').innerHTML = "&#9733";
        document.getElementById('star2').innerHTML = "&#9734";
        document.getElementById('star3').innerHTML = "&#9734";
        document.getElementById('star4').innerHTML = "&#9734";
        document.getElementById('star5').innerHTML = "&#9734";
    }
}

function starfunction2(){
    if(document.getElementById('star2').onclick){
        document.getElementById('star1').innerHTML = "&#9733";
        document.getElementById('star2').innerHTML = "&#9733";
        document.getElementById('star3').innerHTML = "&#9734";
        document.getElementById('star4').innerHTML = "&#9734";
        document.getElementById('star5').innerHTML = "&#9734";
    }
}

function starfunction3(){
    if(document.getElementById('star3').onclick){
        document.getElementById('star1').innerHTML = "&#9733";
        document.getElementById('star2').innerHTML = "&#9733";
        document.getElementById('star3').innerHTML = "&#9733";
        document.getElementById('star4').innerHTML = "&#9734";
        document.getElementById('star5').innerHTML = "&#9734";
    }
}

function starfunction4(){
    if(document.getElementById('star4').onclick){
        document.getElementById('star1').innerHTML = "&#9733";
        document.getElementById('star2').innerHTML = "&#9733";
        document.getElementById('star3').innerHTML = "&#9733";
        document.getElementById('star4').innerHTML = "&#9733";
        document.getElementById('star5').innerHTML = "&#9734";
    }
}

function starfunction5(){
    if(document.getElementById('star5').onclick){
        document.getElementById('star1').innerHTML = "&#9733";
        document.getElementById('star2').innerHTML = "&#9733";
        document.getElementById('star3').innerHTML = "&#9733";
        document.getElementById('star4').innerHTML = "&#9733";
        document.getElementById('star5').innerHTML = "&#9733";
    }
}

// count amount of letter had typed at the textarea
function countWord(){
    var wordlength = document.getElementById('textarea').value.length;

    document.getElementById('textCount').innerHTML = wordlength + "/300";
    document.getElementById('textCount').style.color = "dimgray";
}

function thanks(){
    alert("Thanks for the feedback!");
}
