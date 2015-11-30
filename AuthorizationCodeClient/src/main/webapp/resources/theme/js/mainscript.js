/**
 * 
 */


$(document).ready(function (){
	$('#login').click(function() {
		loginFromServer();
	});
	
	$('#login-button').click(function() {
		opendiaLog();
	});
	
	
});

function opendiaLog() {
	var login_url = "http://localhost:8888/AuthorizationCodeServer/oauth/authorize" +
					"?response_type=code" +
					"&client_id=trusted_client"+
					"&redirect_uri=http://springapp-hirte.rhcloud.com/AuthorizationCodeClient/home";

	var $dialog = $('<div></div>')
	               .html('<iframe style="border: 0px; " src="' + login_url + '" width="100%" height="100%"></iframe>')
	               .dialog({
	                   autoOpen: false,
	                   modal: true,
	                   height: 625,
	                   width: 500,
	                   title: "Some title"
	               });
	$dialog.dialog('open');
}

function loginFromServer() {
	
	var login_url = "http://localhost:8888/AuthorizationCodeServer/oauth/authorize" +
									"?response_type=code" +
									"&client_id=trusted_client"+
									"&redirect_uri=http://springapp-hirte.rhcloud.com/AuthorizationCodeClient/home";
	$.ajax({
		url: login_url,
		success: function(result) {
			var $dialog =	$('#login-load-form').html(result).dialog({
                autoOpen: false,
                modal: true,
                height: 625,
                width: 500,
                title: "Some title"
            });
			$dialog.dialog('open');
			console.log(result)
		},
		error: function(xhr,status,error) {
			alert("Cannot connect to server");
			console.log(status + ": " + error)
		}
		
		
	})
	
}