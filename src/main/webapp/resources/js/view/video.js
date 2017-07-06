// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
console.log(btn);
// Get the <span> element that closes the modal

var span = document.getElementsByClassName("close")[0];


// When the user clicks the button, open the modal 
btn.onclick = function() {
	console.log(modal);
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	 	 modal.style.display = "none";
	}
 
$(document).ready(function() {
	/*alert();
	$(function(){
	    $('#myModal').modal({
	        show: false
	    }).on('hidden.bs.modal', function(){
	        $(this).find('myVideoPlay')[0].pause();
	    });
	});
	*/
 /*$('.close').click(function() {
	 alert();
      $('.modal').fadeOut();
        $('#myVideoPlay')[0].pause();
    });*/
});
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}