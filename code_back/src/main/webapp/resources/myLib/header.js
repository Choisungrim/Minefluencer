let container = document.getElementById('container');
let header = document.querySelector('.nav');

window.addEventListener('scroll', event => {
	let scrollY = this.scrollY;

	if (scrollY != 0) {
		header.classList.add('nav_active');
	} else {
		header.classList.remove('nav_active');
	}
});

$(document).ready(function () {
	let flag = true;
	$(".hamIcon").click(function () {
		if(flag) {
			flag = false;
			$("#hamMenu").addClass("open");
		}else {
			flag = true;
			$("#hamMenu").removeClass("open");
		}
	    
	});
	
var burger = $('.hamIcon');

burger.each(function(index){
  var $this = $(this);
  
  $this.on('click', function(e){
    e.preventDefault();
    $(this).toggleClass('active-' + (index+1));
  })
});
});