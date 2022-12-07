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
    document.getElementById(contentName).style.display = "block";
    //class 생성 이벤트 발생
    evt.currentTarget.className += " active"; 
}
	