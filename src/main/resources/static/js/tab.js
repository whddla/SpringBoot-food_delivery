function tabopen(evt, contentName){
    var i, tabcontent, tab_btn;
    
    tabcontent = document.getElementsByClassName("content");
    for(i = 0; i<tabcontent.length; i++){ //내용을 나열
        tabcontent[i].style.display = "none";
    }
    
    tab_btn = document.getElementsByClassName("tabs");
    for(i = 0; i<tab_btn.length; i++){ // 탭 버튼 나열
        //탭 버튼을 눌렀을 때 기존 탭 class 삭제
        tab_btn[i].className = tab_btn[i].className.replace(" active",""); 
    }
    //탭을 눌렀을 때 해당 id의 내용을 출력

    // 모든탭에 지도가 등장하기 때문에 info 탭을 눌렀을 때만 등장하게함.
    if(document.getElementById(contentName).getAttribute("id")=="info-tab"){
        document.getElementById("map").style.visibility = "visible";
        document.getElementById("map").style.height = "350px";
    }
    else if(document.getElementById(contentName).getAttribute("id")=="review-tab"){
        // 지도가 위에 위치하기 때문에 지도크기를 0으로 줌.
        document.getElementById("map").style.height = "0px";
    }
    else{
        document.getElementById("map").style.visibility = "hidden";
        document.getElementById("map").style.height = "350px";
    }
    document.getElementById(contentName).style.display = "block";
    //class 생성 이벤트 발생
    evt.currentTarget.className += " active";
}
	