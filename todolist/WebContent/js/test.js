
//DOM이 완전히 로드된 후 실행
document.addEventListener("DOMContentLoaded", () => {

	//요소 참조(폼, 입력창, 목록 리스트)
	const form = document.getElementById("addTodoForm");
	const input = document.getElementById("newTodo");
	const ul = document.getElementById("todoList");
	
	//폼 제출 시(추가 버튼 클릭 또는 enter 입력 시)
	form.addEventListener("submit", e => {
		e.preventDefault();
		
		//입력된 text 양쪽 공백 제거해서 가져오기
		const todoText = input.value.trim();
		
		//아무것도 입력 안했으면 종료
		if(todoText === "") return;
		
		//새로운 <li> 요소 생성
		const li = document.createElement("li");
		li.classList.add("todo-item");
		
		li.innerHTML = `
			<span class="todo">${todoText}</span>
			(<span class="status">미완료</span>)
		`;
		
		//리스트에 추가
		ul.appendChild(li);
		
		//입력창 비우기
		input.value = "";
	});
	
	//동적으로 추가된 <li>도 클릭 처리되도록 ul에 이벤트 위임(버블링)
	ul.addEventListener("click", e => {
		
		//클릭한 요소가 포함된 <li> 찾기(closest)
		const li = e.target.closest("li");
		
		//<li>가 아닌 다른 곳을 클릭했다면 무시
		if(!li) return;
		
		//완료 상태 토글(클릭할 때마다 <li>요소에 "completed" 클래스를 켜고 끄는 역할)		
		li.classList.toggle("completed");
		
		//상태 텍스트 변경(.status 클래스를 가진 요소를 <li> 내부에서 찾음)
		const statusSpan = li.querySelector(".status");
		
		//statusSpan이 존재할 때만 실행(null(false) 이면 실행 X)
		if(statusSpan) {
			const current = statusSpan.textContent.trim();
			statusSpan.textContent = current === "미완료" ? "완료" : "미완료";
		}
		console.log("li 클릭");
	});
});