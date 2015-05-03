var loginContainer;

$(document).ready(function() {
	loginContainer = $("#loginContainer");
	updateLoginContainerPosition();
	loginContainer.animate({ opacity: "show" }, 500);
});

window.onresize = function(event) {
	updateLoginContainerPosition();
};

function updateLoginContainerPosition() {
	loginContainer.css("left", ($(document).width() - loginContainer.width()) / 2 + "px");
	var top = $(document).height() > loginContainer.height() ? ($(document).height() - loginContainer.height()) / 2 : 0;
	loginContainer.css("top", top + "px");	
}