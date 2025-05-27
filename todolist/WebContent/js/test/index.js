//현재 선택된 필터 상태를 저장
let currentFilter = 'all';

//DOM 요소 참조 : 할 일 추가 폼, 입력 필드, 우선순위 선택, 할 일 목록 UL
const form = document.getElementById("addTodoForm");
const input = document.getElementById("newTodo");
const prioritySelect = document.getElementById("priority");
const ul = document.getElementById("todoList");

//폼 제출 시 새로운 할 일 추가
form.addEventListener("submit", e => {

	//새로 고침 동작
	e.preventDefault();

	//입력된 텍스트 값 공백제거 한 후 todoText에 가져오기
	const todoText = input.value.trim();

	//선택된 우선순위 값 priority에 가져오기
	const priority = prioritySelect.value;

	//입력값 비어 있으면 무시
	if (todoText === "") return;

	//새 <li> 요소 생성 및 클래스, 속성 설정
	const li = document.createElement("li");
	li.classList.add("todo-item");
	li.setAttribute("data-priority", priority);

	//li 안에 HTML 구조 정의
	li.innerHTML = `
	    <span class="todo">${todoText}</span>
	    <span class="priority">(${priority})</span>
	    <span class="status">(미완료)</span>
	    <button class="important-btn">★</button>
	    <button class="delete-btn">삭제</button>
	`;

	//생성된 li 요소를 UL에 추가
	ul.appendChild(li);

	//li 추가 끝났으니 입력창 초기화
	input.value = "";
});

//할 일 목록에서 클릭 이벤트 위임(삭제, 중요 표시, 토글) - 버블링
ul.addEventListener("click", e => {

	//클릭된 버튼 li 요소 찾기
	const li = e.target.closest("li");
	if (!li) return;

	//삭제
	if (e.target.classList.contains("delete-btn")) {
		li.remove();
		console.log(li + "삭제");
		return;
	}

	//중요 버튼 클릭 시 important 클래스 토글
	if (e.target.classList.contains("star-btn")) {
		li.classList.toggle("important");
		e.target.classList.toggle("active");

		//필터 적용
		applyFilter();
		console.log(li + "중요");
		return;
	}

	//중요, 삭제 외 다른 영역 클릭 시 완료 상태 토글
	li.classList.toggle("completed");

	//상태 텍스트 '미완료' < - > '완료'로 변경하기
	const statusSpan = li.querySelector(".status");
	if (statusSpan) {
		const current = statusSpan.textContent.trim();
		statusSpan.textContent = current === "미완료" ? "완료" : "미완료";
	}
});

//필터 버튼 클릭 시 실행될 함수
function setFilter(filter) {
	currentFilter = filter;
	applyFilter();

	//모든 버튼에서 active 클래스 제거
	document.querySelectorAll(".filters button").forEach(btn => {
		btn.classList.remove("active");
	});

	//현재 필터 텍스트에 맞는 버튼만 active 클래스 추가
	const buttonMap = {
		all: "전체",
		active: "미완료",
		completed: "완료",
		important: "중요"
	};

	const activeButton = [...document.querySelectorAll(".filters button")].find(
		btn => btn.textContent.trim() === buttonMap[filter]
	);

	if (activeButton) {
		activeButton.classList.add("active");
	}
}

//필터 조건에 맞춰 할 일 항목 표시, 숨김
function applyFilter() {
	document.querySelectorAll('#todoList li').forEach(li => {

		//완료 여부 확인하기
		const isCompleted = li.classList.contains("completed");

		//중요 여부 확인하기
		const isImportant = li.classList.contains("important");

		//현재 필터 조건과 일치하는 항목만 표시, 나머지는 숨김
		if (
			currentFilter === 'all'
			|| (currentFilter === 'completed' && isCompleted)
			|| (currentFilter === 'active' && !isCompleted)
			|| (currentFilter === 'important' && isImportant)
		) {
			//보이게 설정
			li.style.display = '';
		}
		else {
			//숨김 처리
			li.style.display = 'none';
		}
	});
}