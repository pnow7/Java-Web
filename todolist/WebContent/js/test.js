document.querySelectorAll("#todoList li").forEach(function(item) {
	item.addEventListener("click", function() {
		item.classList.toggle("completed");
		
        // 상태 변경
        const statusSpan = item.querySelector(".status");
        const currentStatus = statusSpan.textContent.trim();
		
        if (currentStatus === "미완료") {
            statusSpan.textContent = "완료";
        } else {
            statusSpan.textContent = "미완료";
        }
    });
});