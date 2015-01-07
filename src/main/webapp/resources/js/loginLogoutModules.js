function modulesLogout(){
	$(".moduleURL").each(function(index){
		var moduleURL = $(this).attr("title")+"view/logout.jsf";
		$.ajax(
			moduleURL,
			{
				type: "GET",
				complete: function(jqXHR, textStatus) {
					console.log(moduleURL+" : "+textStatus);
				}
			}
		);
	});
	window.location.href="login.jsf";
}

function modulesLogin() {
	$(".moduleURL").each(function(index){
		var moduleURL = $(this).attr("title")+"view/login.jsf";
		$.ajax(
				moduleURL,
				{
					type: "POST",
					data: {
						"login":$(".inputLogin").val(),
						"password":$(".inputPassword").val()
					},
					complete: function(jqXHR, textStatus) {
						console.log(moduleURL+" : "+textStatus);
					}
				}
			);
	});
}