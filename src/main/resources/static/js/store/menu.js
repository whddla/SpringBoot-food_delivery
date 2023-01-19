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
    td[0].innerHTML = `<label for="uploadImg">
                            <img id="img`+no+`" src="`+document.getElementById('img'+no).src+`" style="width: 100px;height: 100px; cursor: pointer">
                       </label>
                       <input style="display: none" type="file" id="uploadImg">
                       `
    td[3].innerHTML = `<td>
                         <button onclick="saveMenu(`+no+`)">저장</button>
                         <button onclick="showMenuList(`+no+`)">취소</button>
                     </td>`
}

function saveMenu(no) {
    var decodeUri = decodeURI(document.getElementById("img"+no).src)
    var idx =  decodeUri.indexOf("img")
    decodeUri = decodeUri.substring(idx-1)
    console.log(decodeUri)
    // console.log(decodeUri)
    var json = {
        "no" : no,
        "img": document.getElementById("img"+no).src,
        "foodName":document.getElementById("fn"+no).value,
        "price": parseInt(document.getElementById("price"+no).value)
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

