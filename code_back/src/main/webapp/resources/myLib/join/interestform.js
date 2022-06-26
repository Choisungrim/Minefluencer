/**
 * 
 */

$('.save').click(function(){
		var chk_arr = $("input[name=check]");

        var chk_data = [];
        for( var i=0; i<chk_arr.length; i++ ) {
            if( chk_arr[i].checked == true ) {
                chk_data.push(chk_arr[i].value);
            }
        }
        console.log(chk_data);
	});