
// function updateMenu(e){
//     const menuList = e.parentElement.parentElement.getElementsByTagName("td")
//     console.log(e)
//     console.log(e.nextElementSibling)
//     console.log(e.parentElement.parentElement.getElementsByTagName("td")[0].children)
//     menuList[0].innerHTML = `<div></div>`
//     for(var i=1;i<3;i++){
//         menuList[i].children[0].removeAttribute("disabled")
//         menuList[i].children[0].style.border = "2px solid"
//     }
//     menuList[2].children[0].value.replace("원",'')
// }

function showMenuList() {

}

function updateMenu(no) {
    var json = {"no":no}
    $.ajax({
        url:"/updateMenu",
        type:"POST",
        data:JSON.stringify(json),
        dataType:'json',
        contentType: "application/json; charset=UTF-8",
        success: function (result) {
            console.log(result)
            var htmls = ""
            htmls = `<tr>
                <td><img style="width: 100px;height: 100px;" src="`+result.img+`"></td>
                <td><input style="width: 100px;border: 2px solid;background-color: white;" type="text" name="" value="`+result.foodName+`"></td>
                <td><input style="width: 100px;border: 2px solid;background-color: white;" type="text" name="" value="`+result.price+`"></td>
                <td>
                    <button onclick="saveMenu(`+result.no+`)">저장</button>
                    <button onclick="showMenuList(`+result.no+`)">취소</button>
                </td>
             </tr>`
            $("#"+no)[0].innerHTML = htmls;
        }, error: function(error){
            console.log("에러 : " + error);
        }
    })
}

function deleteMenu(){
    console.log("hi")
}

