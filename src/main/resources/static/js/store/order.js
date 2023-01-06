
function modal() {
    const modal = document.getElementById("modal")
    function modalOn() {
        modal.style.display = "flex"
    }
    function isModalOn() {
        return modal.style.display === "flex"
    }
    function modalOff() {
        modal.style.display = "none"
    }
    const btnModal = document.getElementById("btn-modal")
    btnModal.addEventListener("click", e => {
        modalOn()
    })
    const closeBtn = modal.querySelector(".close-area")
    closeBtn.addEventListener("click", e => {
        modalOff()
    })
    modal.addEventListener("click", e => {
        const evTarget = e.target
        if(evTarget.classList.contains("modal-overlay")) {
            modalOff()
        }
    })
    window.addEventListener("keyup", e => {
        if(isModalOn() && e.key === "Escape") {
            modalOff()
        }
    })
}

function menuCount() {
    var orderNo = document.getElementsByClassName("select-menu")

    for(var i=0;i<orderNo.length;i++){
        var menu = orderNo.item(i).getElementsByTagName("span")
        menuCount = menu.length
        menu.item(0).innerText = '메뉴 ' + menuCount +'개'
    }
}
menuCount();

// 접수
function receipt() {
    var no = document.getElementById("orderNum").innerText
    var delieveryTime = document.getElementsByName('cnt')[0].value;
    var state = '주문대기'
    if(confirm("접수하시겠습니까?")){
        location.href = `/updateState/`+state+`/`+no+`/`+delieveryTime;
    }else{
        return false;
    }
}
// 거부
function refuse() {
    var no = document.getElementById("orderNum").innerText;
    document.getElementById("reason").innerText = "주문거부 사유를 선택해주세요.";
    document.getElementById("title").innerText = "주문거부";
    modal();
}

// 완료처리
function completion() {
    var no = document.getElementById("orderNum").innerText
}

// 취소
function cancel() {
    var no = document.getElementById("orderNum").innerText
    document.getElementById("reason").innerText = "주문취소 사유를 선택해주세요.";
    document.getElementById("title").innerText = "주문취소";
    modal();
}


function requestBtns(e){
    var orderNo = document.getElementById("orderNum").innerText
    var state = this.document.getElementById("title").innerText
    var reason = e.innerText
    if(state == "주문거부"){
        location.href = "/order/refuse/" + reason +"/"+ orderNo
    }else{
        location.href = "/order/cancel/" + reason + "/" + orderNo
    }
}