const main = {
    init : function (){
        const _this = this;
        $("a[href='/population/trendSido']").addClass("active");
        $("#sidebarMenu a[href='/population/trendSido']").addClass("active");
        //이벤트 셋팅
        $('#btn-select').on('click', function () {
            _this.selList();
        });

		const statInfo = common.selMaxYyyymm('02' ,(maxYyyymm)=>{
			$('#yyyymm').val(maxYyyymm);
        	_this.selList();
		});
    },

    selList : function() {
		const yyyymm =  $('#yyyymm').val().replace('-','');

        if(yyyymm.length != 6) {
	        alert("조회년월이 부적합합니다.");
	        return;
		}

		var data = {
            startYyyymm: yyyymm ,
            endYyyymm: yyyymm
        };

	    $.ajax({
            type: 'POST',
            url: '/population/trendSidoList',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(response => {
			console.log(response);
			const template = $('#mp_template').html();
			const data = {'data' : response.data};
			console.log(`data : ${data}`);
			const rendered = Mustache.render(template,data);
			console.log(`rendered : ${rendered}`);
			$('#target').html(rendered);
		}).fail(response => {
			console.log(response);
		});
	},
}

main.init();