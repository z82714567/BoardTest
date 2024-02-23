const box = document.querySelector("tbody");

function load(){
	$.ajax ({
		type : "get",
		url : "/board/test/select-all",
		success : function(data){
			if(data != ""){
				innerHtmlEvent(data);
			}
		},
		error : function(){
			alert("에러!!!");
		}
	});
}

// 리스트 출력
function innerHtmlEvent(data){
	let inner1 = "";
	for(let i = 0; i <data.length; i ++){ //i = 인덱스번호
		inner1 += `
			<tr class="page-click" id="${data[i].id}">
              <td>${data[i].id}</td>
              <td>${data[i].title}</td>
              <td>${data[i].create_date}</td>
              <td>5</td>
            </tr>
            `;
	}// for()
	box.innerHTML = inner1;
	
	// 상세보기 위한 클릭 이벤트
	const pageClick = document.querySelectorAll(".page-click");
	for(let i = 0; i < pageClick.length; i++){
		pageClick[i].onclick = () => {
			window.location.href = "/board/test/detail/" + pageClick[i].id;
		}
	}// for()
}


load(); // 함수 실행