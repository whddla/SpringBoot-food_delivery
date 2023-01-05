
const rightBtnWait = `
<button class="submit" id="btn-modal" onclick="refuse(this)">거부</button>
<div id="inpList">
    <input type="button" onclick="Count('m',this);" value="-"><input name="cnt" value="60">분<input type="button" onclick="Count('p',this);" value="+">
</div>
<button class="submit" onclick="receipt(this)">접수</button>`

const rightBtnProg = `
<button class="waitBtn" id="btn-modal" onclick="cancel(this)">취소</button>
<button class="waitBtn" onclick="completion(this)">완료처리</button>`



$(document).ready(function () {
    document.getElementById("default").style.display = "block";
});

function orderNo(orderNo) {
    var menuDiv = document.getElementsByClassName("select-menu")
    for(var i=0;i<menuDiv.length;i++){
        menuDiv[i].classList.remove("view")
    }
    var modalDiv = document.getElementById("modal")
    document.getElementById(orderNo+"Class").classList.add('view');
    document.getElementById("default").style.display = "none";
    document.getElementById("showMenu").style.display = "block";

    var json = {
        orderNo : orderNo
    }
    $.ajax({
        url:"/orderNo",
        type:"POST",
        data:JSON.stringify(json),
        dataType:'json',
        contentType: "application/json; charset=UTF-8",
        success : function (data) {
            var menuCount = data[0].length;
            var div = document.getElementById("menu")
            var btnDiv = document.getElementById("rightBtns")
            div.innerHTML = "";
            for(var i = 0; i<menuCount;i++){
                div.innerHTML +=
                `
                   <tr>
                       <td>`+data[0][i].foodName +`</td>
                       <td>`+data[0][i].num +`개</td>
                       <td>`+data[0][i].menuPrice +`원</td>
                   </tr>

                `;
            }
            div.innerHTML += `
                <tr>
                    <td>배달팁</td>
                    <td></td>
                    <td>`+data[1].tip+`원</td>
                </tr>
                <tr>
                    <td></td>
                    <td>`+menuCount+`개</td>
                    <td>`+data[1].totalMoney+`원</td>
                </tr>
            `;

            document.getElementById("orderNum").innerText = data[1].orderNo;
            document.getElementById("orderNum1").innerText = data[1].orderNo;
            document.getElementById("count").innerText = menuCount;
            document.getElementById("forCeo").value = data[1].forCeo;
            document.getElementById("forRider").value = data[1].forRider;
            document.getElementById("address").innerText = data[1].location;
            document.getElementById("phone").innerText = data[1].phone;
            document.getElementById("orderTime").innerText = data[1].orderDate;
            document.getElementById("storeName").innerText = data[1].storeName;
            document.getElementById("money").innerText = data[1].totalMoney;
            document.getElementById("delTime").innerText = data[1].deliveryTime +'분';
            if(data[1].state == '주문대기'){
                document.getElementById("delTime").parentElement.style.display = "none";
                btnDiv.innerHTML = rightBtnWait
            }else{
                document.getElementById("delTime").parentElement.style.display = "contents";
                btnDiv.innerHTML = rightBtnProg
            }
        }
    })

}

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

