function addHandlers() {
	$('#btn_submit').click(function(data, status) {
		var searchWord = $("#inp_field").value;
		$.get('/gql/find', function(data) {
			$('#res_div').append(data);
		});
	});
};

$(document).ready(function() {
	console.log("jQuery loaded doc!");
	addHandlers();
});