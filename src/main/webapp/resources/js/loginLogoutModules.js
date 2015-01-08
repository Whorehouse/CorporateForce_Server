function modulesLogout(){
	$(".moduleURL").each(function(index){
		var moduleURL = $(this).attr("title")+"logout";
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
	window.location.href="login";
}

function modulesLogin() {
	$(".moduleURL").each(function(index){
		var moduleURL = $(this).attr("title")+"login";
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