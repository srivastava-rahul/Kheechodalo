	$(document).ready(function() {
		
		/* Get iframe src attribute value i.e. YouTube video url and store it in a variable */
		var url = $("#cartoonVideo").attr('src');

		/* Assign empty url value to the iframe src attribute when
		modal hide, which stop the video playing */
		$('.close').click(function(e) {
			
			$("#cartoonVideo").attr('src', '');
		});

		/* Assign the initially stored url back to the iframe src
		attribute when modal is displayed again */
		$('#myBtn').click(function(e) {
			
			$("#cartoonVideo").attr('src', url);
		});
	});
	

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