function readMultipleImage(input) {
    const multipleContainer = document.getElementById('multipleContainer')

    if(input.files) {
        console.log(input.files)
        const fileArr = Array.from(input.files)
        const $colDiv1 = document.createElement('div')
        const $colDiv2 = document.createElement('div')
        $colDiv1.classList.add('column')
        $colDiv2.classList.add('column')
        fileArr.forEach((file, index) => {
            const reader = new FileReader()
            const $imgDiv = document.createElement('div')
            const $img = document.createElement('img')
            $img.classList.add('image')
            const $label = document.createElement('label')
            $label.classList.add('image-label')
            $label.textContent = file.name
            $imgDiv.appendChild($img)
            $imgDiv.appendChild($label)
            reader.onload = e => {
                $img.src = e.target.result

                //$imgDiv.style.width = ($img.naturalWidth) * 0.2 + "px"
                //$imgDiv.style.height = ($img.naturalHeight) * 0.2 + "px"
            }

            console.log(file.name)
            if(index % 2 == 0) {
                $colDiv1.appendChild($imgDiv)
            } else {
                $colDiv2.appendChild($imgDiv)
            }

            reader.readAsDataURL(file)
        })
        multipleContainer.appendChild($colDiv1)
        multipleContainer.appendChild($colDiv2)
    }
}
// 이벤트 리스너
document.getElementById('inputMultipleImage').addEventListener('change', (e) => {
    readMultipleImage(e.target);
})


function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("img"+no)
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
const inputImage = document.getElementById("uploadImg")
inputImage.addEventListener("change", e => {
    readImage(e.target)
})