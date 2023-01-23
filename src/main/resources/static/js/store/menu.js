// 가게 이름 찾아오기
var decodeUri = document.getElementById("menuList").children[1].getElementsByTagName("td")[0].children[0].getAttribute("src")
var idx =  decodeUri.indexOf("d/")
decodeUri = decodeUri.substring(idx+2)
var storeName = decodeUri.substring(0,decodeUri.indexOf("/"))


function showMenuList(no) {
    var json = {"no":no}
    $.ajax({
        url:"/updateMenu",
        type:"POST",
        data:JSON.stringify(json),
        dataType:'json',
        contentType: "application/json; charset=UTF-8",
        success: function (result) {
            var htmls = ""
            htmls = `<tr>
                <td><img id="img`+no+`" style="width: 100px;height: 100px;" src="`+result.img+`"></td>
                <td><input id="fn`+no+`" style="width: 150px;border: none;background-color: white;" disabled type="text" name="" value="`+result.foodName+`"></td>
                <td><input id="price`+no+`" style="width: 150px;border: none;background-color: white;" disabled type="text" name="" value="`+result.price.toLocaleString()+`원"></td>
                <td>
                    <button onclick="updateMenu(`+result.no+`)">수정</button>
                    <button onclick="deleteMenu(`+result.no+`)">삭제</button>
                </td>
             </tr>`
            $("#"+no)[0].innerHTML = htmls;
        }, error: function(error){
            console.log("에러 : " + error);
        }
    })
}

function updateMenu(no) {
    var td = $("#"+no)[0].children;
    for(var i=1;i<3;i++){
        td[i].children[0].removeAttribute("disabled")
        td[i].children[0].style.border = "1px solid"
    }
    td[2].children[0].value = td[2].children[0].value.replace(",","").replace("원","")
    td[3].innerHTML = `<td>
                         <button onclick="saveMenu(`+no+`)">저장</button>
                         <button onclick="showMenuList(`+no+`)">취소</button>
                     </td>`
}


function saveMenu(no) {
    var json = {
        "no" : no,
        "foodName":document.getElementById("fn"+no).value,
        "price": parseInt(document.getElementById("price"+no).value),
    }
    if(!confirm("메뉴를 저장하시겠습니까?")){
        alert("취소됐습니다.")
    }else{
        $.ajax({
            url:"/saveMenu",
            type:"POST",
            data:JSON.stringify(json),
            dataType:'json',
            contentType: "application/json; charset=UTF-8",
            success: function (result) {
                console.log(result)
            },error: function (err) {
                console.log(err)
            }
        })
        showMenuList(no)
    }
}


function deleteMenu(no){
    var json = {
        "no" : no
    }
    if(!confirm("메뉴를 삭제하시겠습니까?")){
        alert("취소됐습니다.")
    }else{
        $.ajax({
            url:"/deleteMenu",
            type:"POST",
            data:JSON.stringify(json),
            dataType:'json',
            contentType: "application/json; charset=UTF-8",
            success: function (result) {
                console.log(result)
            },error: function (err) {
                console.log(err)
            }
        })
    }
}


function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}

var cnt = 0;


function addMenu() {
    cnt += 1;
    if(cnt ==1){
        var htmls = "";
        htmls += `<tr>`
        htmls += `<td>`
        htmls += `<label for="input-image"><img id="preview-image" src="/img/etc/upload.png" style="width: 100px;height: 100px"></label>`
        htmls += `<input id="input-image" style="display: none" type="file" accept="image/jpeg">`
        htmls += `</td>`
        htmls += `<td><input style="width: 150px" type="text" name="foodName"></td>`
        htmls += `<td><input style="width: 150px" type="text" name="price"></td>`
        htmls += `<td><form action="uploadMenu"><button onclick="uploadMenu()">추가</button></form>
                    <button onclick="cancelMenu()">삭제</button>
                  </td>`
        htmls += `</tr>`
        $("#menuList > tbody:last").append(htmls);
    }else{
        alert("추가중인 메뉴가 있습니다.")
        return false;
    }
    // input file에 change 이벤트 부여
    const inputImage = document.getElementById("input-image")
    inputImage.addEventListener("change", e => {
        readImage(e.target)
    })
}

function uploadMenu() {
    cnt = 0

}

function cancelMenu() {
    cnt = 0
    $("#menuList > tbody:last > tr:last").remove();
}
