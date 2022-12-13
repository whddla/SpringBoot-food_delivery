function select(id) {
    var name = id
    var money = document.getElementsByName(id)[0].innerText
    var pMoney = document.getElementById("pay_food")
    var tMoney = document.getElementById("total_money")
    var plusMoney = document.getElementById(""+name+"money")
    if(document.getElementById("food_"+name+"") ==null){
        pMoney.value = parseInt(pMoney.value) + parseInt(money)
        var sumMoney = tMoney.value
        tMoney.value = parseInt(sumMoney) + parseInt(money)
        // 주문표 표시

        document.getElementsByClassName("order-wrap")[0].innerHTML += `
            <li class="item-list" id="order-li">
                <div>
                    <div class="item-name" id="food_`+name+`">`+name+`</div>
                    <div class="pull-left">
                        <a class="delete-btn" id="`+name+`delete" onclick='deleteDiv(this.id)' style="cursor: pointer;">
                            삭제
                            <span id="`+name+`money">`+ money +`</span><span>원</span>
                        </a>
                        <div class="text-right"><input type="button" value="-"><input type="button" value="1"><input type="button" value="+"></div>
                    </div>
                </div>
            </li>`
    }
    else{
        console.log("두번째")
        var sMoney = parseInt(plusMoney.innerText)
        sMoney += parseInt(money)
        // 담기 두번 이상 눌렀을때 기존 금액에 추가
        plusMoney.innerText = sMoney
        // 결제 금액에 추가
        // 음식비
        pMoney.value = parseInt(pMoney.value) + parseInt(money)
        // 총 금액
        tMoney.value = parseInt(tMoney.value) + parseInt(money)
    }
}

function deleteDiv(id) {
    const div = document.getElementById('order-li');
    console.log( document.getElementsByClassName('item-list'))
    // div.remove();
}