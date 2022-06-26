/**
 * id check ajax 입니다.
 */
$('.input_id').focusout(function(){
	let userId = $('.input_id').val();
	
	$.ajax({
		url : "idCheck",
		type : "post",
		data : {userid : userId},
		dataType : 'json',
		success : function(result) {
			if(result == 0) { //입력한 id가 서버에 있다면 1, 없으면 0으로 받았습니다.
				$('#idcheck').html('사용할 수 없는 id 입니다.');
				$('#idcheck').attr('color', 'red');
			}else {
				$('#idcheck').html('사용 가능한 id 입니다.');
				$('#idcheck').attr('color', 'green');	
			}
		},
		error : function(){
			alert("서버요청에 실패했습니다.");
		}
		});//idCheck_ajax
	});