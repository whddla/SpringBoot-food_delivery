// 메뉴별로 id를 다르게 하기위함
cnt = -1
pMoney = document.getElementById("pay_food")
tMoney = document.getElementById("total_money")
// 담기
function select(id) {
    var name = id
    var money = document.getElementsByName(id)[0].innerText
    var plusMoney = document.getElementById(""+name+"money")
    // id를 구분하기 위한 cnt, 추가메뉴 증가면 늘어남
    cnt += 1
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
                        <a class="delete-btn" id="`+cnt+`" onclick='deleteDiv(this.id)' style="cursor: pointer;">
                            <span class="xbtn">X</span>
                            <span id="`+name+`money">`+ money +`</span><span>원</span>
                        </a>
                        <div class="text-right"><input type="button" onclick="fnCalCount('m',this);" value="-"><input type="button" name="cnt" value="1"><input type="button" onclick="fnCalCount('p',this);" value="+"></div>
                    </div>
                </div>
            </li>`
    }
    else{
        var getFoodName = "food_" + name
        // 수량, 담기 버튼 누를시 수량 카운트
        var fCnt = document.getElementById(getFoodName).nextElementSibling.getElementsByTagName("input")[1]
        fCnt.value = parseInt(fCnt.value) + 1

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


// 주문표에서 삭제
function deleteDiv(id) {
    // 삭제버튼의 상위 엘리먼트
    const div = document.getElementById(id).parentElement.parentElement.parentElement;
    // 삭제한 음식의 추가된 금액
    var money = document.getElementById(id).getElementsByTagName("span")[1].innerText
    // 삭제된 만큼 차감해야할 input

    pMoney.value = parseInt(pMoney.value) - parseInt(money)
    tMoney.value = parseInt(tMoney.value) - parseInt(money)
    div.remove();
}

// 개수 버튼
function fnCalCount(type, e) {
    var pinp = $(e).siblings("input")[1];
    var minp = $(e).siblings("input")[0];
    var foodName = $(e).parents("div").find(".item-name")[0].innerText
    var money = document.getElementsByName(foodName).item(0)
    var orderMoney = $(e).parents("div").siblings("a").find("span")[1]
    // plus눌렀을때 count
    var pCount = parseInt(pinp.value);
    // minus눌렀을때 count
    var mCount = parseInt(minp.value);

    // int로 변환한 돈
    var cMoney = parseInt(money.innerText)

    if(type=='p'){
        pinp.value = pCount + 1
        orderMoney.innerText =  parseInt(orderMoney.innerText) + cMoney
        pMoney.value = parseInt(pMoney.value) + cMoney
        tMoney.value = parseInt(tMoney.value) + cMoney
    }else if(mCount <= 1){
        minp.value = 1
        orderMoney.innerText =  parseInt(orderMoney.innerText)
    }
    else{
        minp.value = mCount - 1
        orderMoney.innerText = parseInt(orderMoney.innerText) - cMoney
        pMoney.value = parseInt(pMoney.value) - cMoney
        tMoney.value = parseInt(tMoney.value) - cMoney
    }


}
