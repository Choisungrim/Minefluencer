<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="resources/myLib/reset.css" />
		<link rel="stylesheet" href="resources/myLib/login/login.css" />
		<title>로그인</title>
	</head>
	<body>
		<div class="container">
			<div class="login">
				<h1><img src="resources/image/logo.svg" alt="로그인 페이지"/></h1>
				<div class="login_box">
					<div>
						<h1>로그인</h1>
					</div>
					<form action="login" method="post">
						<div class="id_box">
							<label for="id"><span>아이디</span></label>
							<input type="text" placeholder="아이디를 입력해주세요." id="id" name="id" />
							<p id="id_errer"></p>
						</div>
						<div class="pw_box">
							<label for="pw"><span>비밀번호</span></label>
							<input type="password" placeholder="비밀번호를 입력해주세요." id="pw" name="pw" />
							<p id="id_errer"></p>
						</div>
						<div class="find">
							<span><a href="id_pw_getf">비밀번호찾기</a></span>
							<span>|</span>
							<span><a href="id_pw_getf">아이디찾기</a></span>
						</div>
						<div class="submit_btn">
							<button>로그인</button>
						</div>
						<div class="join">
							<h5>혹시 회원이 아니신가요? <a href="joinf">회원가입</a></h5>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
