
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