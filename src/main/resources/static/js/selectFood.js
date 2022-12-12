function select(id) {
    var name = id
    var money = document.getElementsByName(id)[0].innerText
    if(document.getElementById("food_"+name+"") ==null){
        // 결제금액 추가
        document.getElementById("pay_food").value = parseInt(money)
        var tMoney = document.getElementById("total_money").value
        tMoney = parseInt(tMoney) + parseInt(money)
        document.getElementById("total_money").value = tMoney
        // 주문표 표시
        document.getElementsByClassName("order-wrap")[0].innerHTML += `
            <li class="item-list">
                <div>
                    <div class="item-name" id="food_`+name+`">`+name+`</div>
                    <div class="pull-left">
                        <a class="delete-btn" href="">
                            삭제
                            <span id="`+name+`money">`+ money +`</span><span>원</span>
                        </a>
                        <div class="text-right">- 1 +</div>
                    </div>
                </div>
            </li>`
    }
    else{
        console.log("두번째")
        var pMoney = document.getElementById(""+name+"money").innerText
        pMoney = parseInt(pMoney)
        pMoney += parseInt(money)
        // 담기 두번 이상 눌렀을때 기존 금액에 추가
        document.getElementById(""+name+"money").innerText = pMoney
        // 결제 금액에 추가
        var t1Money = document.getElementById("pay_food").value
        t1Money = parseInt(t1Money) + parseInt(money)
        document.getElementById("pay_food").value = t1Money
        var t2Money = document.getElementById("total_money").value
        t2Money = parseInt(t2Money) + parseInt(money)
        document.getElementById("total_money").value = t2Money
    }
}