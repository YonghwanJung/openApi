var main = {
	mp_template: `Date: {{ date }} <br> 
	Time: {{ time }} <br> 
	Unix time: {{ milliseconds_since_epoch }}`,
	repos: {
  		"repos": []
	},
	init: function() {
		var _this = this;
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