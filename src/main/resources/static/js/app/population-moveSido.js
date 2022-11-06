const main = {
    init : function() {
        const _this = this;
        $("header a[href='/stat/search']").addClass("active");
        $("#sidebarMenu a[href='/population/moveSido']").addClass("active");

        //이벤트 셋팅
        $('#btn-select').on('click', function () {
            _this.selList();
        });
		const statInfo = common.selMaxYyyymm('03' ,(maxYyyymm)=>{
			$('#yyyymm').val(maxYyyymm);
        	_this.selList();
		});
    },
    selList : function() {
		const _this = this;
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
            url: '/population/moveSidoList',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(response => {
			const template = $('#mp_template').html();
			const data = {'data' : response.data};
			const rendered = Mustache.render(template,data);
			$('#target').html(rendered);
		}).fail(response => {
			console.log(response);
		});
	},
}
main.init();
