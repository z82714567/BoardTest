const title = document.querySelector("input"); // 태그명
const content = document.querySelector("textarea"); // 태그명
const button = document.querySelector("button"); // 태그명


let addressNum = window.location.pathname.split("/")[4]; // 업데이트 페이지에도 쓰기 위해서 위로 올림

function load(){
// 상세보기	
	$.ajax({
		type : "post",
		url : "/board/test/detailview",
		data : {
			id : Number(addressNum) // 문자를 숫자로 변환하는 함수 
		},
		success : function(data){
			title.value = data.title;
			content.value = data.content;
		},
		error : function(){
			alert("error!!!");
		}
	});
	
}

// 수정하기 (디테일페이지에서 클릭하면 업데이트페이지로 이동함)
button.onclick = () => {
	$.ajax({
		type : "post",
		url : "/board/test/update/" + addressNum, // detailveiw에서 pk값인 id잡아서 같이 넘겨준다
		data : {
			title : title.value,
			content : content.value,
		}, // ajax로 컨트롤러에 값을 들고 요청함
		success : function(data){
			if(data == true){
				window.location.href = "/board/test/select"
			}else{
				window.location.href = "/error";
			}
		},
		error : function(){
			alert("실패");
		}
	});
}

load();// 실행