let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
let regExpId = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
let regId = /^[a-z]+[a-z0-9]{5,19}$/g;

$('#id').keyup(function() {
	if (regExpId.test($('#id').val())) {
		$('#id_check').html('아이디 형식에 일치합니다.');
	} else {
		$('#id_check').html('');
	}
});

$('#id').focusout(function() {
	
	$.ajax({
		url : 'idCheck',
		type: 'post',
		charset: "UTF-8",
		data: {id:$('#id').val()},
		success: function(result) {
			if (result == 1) {
				$('#id').focus();
				$('#id_check').html('이미 사용 중인 아이디 입니다.').css({color:"red"});
			} else if (result == 0) {
				$('#id_check').html("사용 가능한 아이디입니다.").css({color:"blue"});
			}
		},
		error: (rej)=>{
			console.log(rej);
		}
	});
})

$('#password').keyup(function() {
	$('#pw_check').css({
		color: 'red',
	});
	if ($(this).val().length > 8 && regExpId.test($(this).val())) {
		$('#pw_check').html('비밀번호 형식에 일치 합니다.').css({
			color: '#3333ff',
		});
		$('#password_re').removeAttr('readonly');
	} else {
		$('#pw_check').html('영문 및 특수문자, 숫자 8자리 이상 입력하세요.').css({
			color: 'red',
		});
		$('#password_re').attr('readonly', 'readonly');
	}
});

$('#password_re').keyup(function() {
	if ($(this).val() === $('#password').val()) {
		$('#pw_re_check').html('비밀번호가 일치합니다');
		$('#password').attr('readonly', 'readonly');
	} else {
		$('#pw_re_check').html('');
		$('#password').removeAttr('readonly');
	}
});

$('#email').keyup(function() {
	if ($(this).val().length > 5) {
		$('#email_check').html('이메일 형식에 일치합니다.');
	} else {
		$('#email_check').html('');
	}
});

$('#birthday').keyup(function() {
	if ($(this).val().length === 6) {
		$('#birthd_check').html('생년월일 형식에 일치합니다.');
	} else {
		$('#birthd_check').html('');
	}
});


$('#submit_btn').click(() => {
	var formData = {
		id: $('#id').val(),
		password: $('#password').val(),
		password_re: $('#password_re').val(),
		email: encodeURIComponent($('#email').val() + '@' + $('#com option:selected').attr('value')),
		nick_name: $('#nick_name').val(),
		birth: $('#birth').val(),
		gender: $('input[name = "gender"]:checked').val(),
		color: $('#color option:selected').attr('value'),
	}
	$.ajax({
		url: 'join',
		type: 'POST',
		charset: "UTF-8",
		data: formData,
		success: ((result) => {
		}),
		error: ((err) => {
			id.focus();
		})
	});
});
