const userTag = document.querySelector(".user");
//document.querySelector("") 안에는 태그명, 아이디, 클래스가 들어올 수 있다.
//태그명을 넣을 때 ("태그명")
//아이디를 넣을 때 ("#id명")
//클래스를 넣을 때 (".클래스명")
// 예) <input type="text" class="user" id="username1" name="username" value="abc"/>
//태그명("input"), 클래스(".user"), 아이디("#username1")
//document.querySelector()는 html태그 1개를 선택해준다. 위에서부터 랜더링되니까 여러개 부를 경우 1개만 가져와줌
//document.querySelectorAll()은 괄호 안의 00명에 해당하는 모든 태그를 가져온다.




function load(){
	//ajax는 무조건 컨트롤러에서 값을 리턴 받아야만 한다.
	$.ajax({
		type : "post",
		url : "/user/get-session", // 컨트롤러로 감
		//data : {username : "홍길동"},  회원가입 등 데이터를 넘겨줘야 할 때 
		success : function(data){ // 무조건 200번대 http상태코드가 리턴되어야만 한다.
			if(data == ""){ // 데이터가 없으면 
				userTag.textContent = "홈화면 입니다.";
			}else{
				console.log("유저아이디", data.username);
				userTag.textContent = `${data.username}님 반갑습니다.`; //자바스크립트에서 ${}표현식을 쓰려면 ""쌍따옴표가 아니라 ``백틱 안에 써야 함.
			}
		},
		error : function(){ // http상태코드가 400(무조건 컨트롤러 에러),500(무조건 서버 로직 에러)번대가 리턴됐을 때 실행된다.(서버 오류)
			alert("error!!");
		}
	});
} // 함수 선언문
load(); // 실행문 