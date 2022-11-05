var main = {
	init: function() {
		var _this = this;
		$("header a[href='/']").addClass("active");
		$("#btn").on('click', function() {
			var template = $("#mp_template").html();
			console.log(template);
			//console.log(data);
			var text = Mustache.render(template, main.repos);
			console.log(text);
			$("#mypanel").html(text);

		});
	}
}

main.init();