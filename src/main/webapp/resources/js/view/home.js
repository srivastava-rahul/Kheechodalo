openNav=function() {
    document.getElementById("mySidenav").style.width = "270px";
  // document.getElementById("main").style.marginRight = "250px";
   // document.getElementById("logoutbutton").style.marginLeft = "250px";
   // document.getElementById("dp").style.display = "none";
	
  }

closeNav=function () {
	//document.getElementById("dp").style.display = "block";
    document.getElementById("mySidenav").style.width = "0";
//  document.getElementById("main").style.marginRight= "0";
//	document.getElementById("logoutbutton").style.marginRight= "0";
	
}


//----------------------------------

// Get the modal
									var modal = document.getElementById('feedbackpopup');
                                   // Get the button that opens the modal
									var btn = document.getElementById("fdbckpopup");
									
									// Get the <span> element that closes the modal
									var span = document.getElementsByClassName("close")[0];

									// When the user clicks the button, open the modal 
									btn.onclick = function() {
										modal.style.display = "block";
									}

									// When the user clicks on <span> (x), close the modal
									span.onclick = function() {
										modal.style.display = "none";
									}

									// When the user clicks anywhere outside of the modal, close it
									window.onclick = function(event) {
										if (event.target == modal) {
											modal.style.display = "none";
										}
									}