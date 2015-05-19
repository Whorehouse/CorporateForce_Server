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


//-------------

schModules = 0;
countModules = $(".modules input[type=hidden]").length;
repeatCount = 3;

function modulesLogin(el) {
	if ($(el).hasClass('btn-success')) {
		//Login logic
		$(".modules input[type=hidden]").each(function(index){
			var moduleURL = $(this).val()+"/login";
			sendAjaxLogin(moduleURL, 0);
		});
	} else {
		//Register logic
		$("#hdnSignIn").click();
	}
}

function modulesLogout(){
	$(".modules input[type=hidden]").each(function(index){
		var moduleURL = $(this).val()+"/logout";
		sendAjaxLogout(moduleURL, 0);
	});
	window.location.href="login";
}

function sendAjaxLogin(moduleURL, repeat) {
	$.ajax(
		moduleURL,
		{
			type: "POST",
			data: {
				"login":$(".field-username").val(),
				"password":$(".field-password").val()
			},
			success: function(data, textStatus, jqXHR ) {
				schModules++;
				checkLogin();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				if (repeat>repeatCount) {
					schModules++;
					checkLogin();
				} else {
					sendAjaxLogin(moduleURL,repeat+1);
				}
			},
			complete: function(jqXHR, textStatus) {
				console.log(moduleURL+" : "+textStatus);
			}
		}
	);
}

function sendAjaxLogout(moduleURL, repeat) {
	$.ajax(
		moduleURL,
		{
			type: "GET",
			success: function(data, textStatus, jqXHR ) {
				schModules++;
				checkLogout();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				if (repeat>repeatCount) {
					schModules++;
					checkLogout();
				} else {
					sendAjaxLogout(moduleURL,repeat+1);
				}
			},
			complete: function(jqXHR, textStatus) {
				console.log(moduleURL+" : "+textStatus);
			}
		}
	);
}

function checkLogin() {
	if (schModules>=countModules) {
		$("#hdnSignIn").click();
	}
}

function checkLogout() {
	if (schModules>=countModules) {
		$("#hdnSignOut").click();
	}
}