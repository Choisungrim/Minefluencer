const result = document.getElementById('result');


$.ajax({
	url : "alllist",
	type : "get",
	success : (list)=>{
		console.log(list)
		for(let i = 0; i<list.list.length; i++)
		var card = `<div class="card">
		<div class="card_left">
		    <img src="${list.list[i].image}" alt="유튜버 이미지" />
		    <div class="about_youtuber">
		        <h1>${list.list[i].name}</h1>
		        <!--이름-->
		        <h3>구독자 ${list.list[i].subscribe} 명</h3>
		        <!-- 구독자 -->
		        <span id="interest">#${list.list[i].job}</span>
		        <!-- 관심사 -->
		    </div>
		</div>
		<div class="card_right">
		    <img src="resources/image/ic_heart-1.svg" alt="좋아요" />
		    <a href="#">더 보기</a>
		</div>
		</div>`;
		result.innerHTML = card;
	}
})

