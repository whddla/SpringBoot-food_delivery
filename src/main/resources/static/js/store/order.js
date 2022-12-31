function menuCount() {
    var orderNo = document.getElementsByClassName("select-menu")

    for(var i=0;i<orderNo.length;i++){
        var menu = orderNo.item(i).getElementsByTagName("span")
        menuCount = menu.length
        menu.item(0).innerText = '메뉴 ' + menuCount +'개'
    }
}

menuCount();

