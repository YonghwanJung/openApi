const common = {
	getYYYYMM : function(cnt) {
		const adjustDate = common.addMonths(cnt);
		const yyyy = adjustDate.getFullYear().toString();
		const mm = (adjustDate.getMonth() + 1).toString().padStart(2,0);
		return yyyy.concat('-').concat(mm);
	},
	addMonths : function (cnt, date = new Date()){
		date.setMonth(date.getMonth() + cnt);
		return date;
	},
	selMaxYyyymm : function( statId, callback ) {
	    $.ajax({
            type: 'GET',
            url: '/population/uploadStatList',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(response => {
			console.log(response);
			let maxYyyymm = '';
			for(let i = 0; i< response.data.length ; i++) {
				if(response.data[i].statId == statId) {
					maxYyyymm = response.data[i].endYyyymm;
				}
			}
			console.log(`maxYyyymm : ${maxYyyymm}`);
			callback(maxYyyymm);
		}).fail(response => {
			console.log(response);
		});
	},
}