$(document).ready(function(){
    $("label[for='second']").text("이메일")
})

function fnRadioName(){
    var second = document.getElementById('second')
    var listVar = $('input[name=radio]:checked').val();
    if(listVar == "email"){
        console.log("hi")
        $("label[for='second']").text("이메일")
    }else{
        console.log("h2")
        $("label[for='second']").text("휴대폰 번호")
    }
}