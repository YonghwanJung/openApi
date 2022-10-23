const main = {
    init : function (){
        const _this = this;
        //이벤트 셋팅
        $('#btn-save1').on('click', function () {
            _this.upload();
        });        
        
		$('#selStatic').on('change' , () => {
			const cnt = $('#selStatic option:selected').data("adjustmonth");
			const yyyymm = common.getYYYYMM(cnt);
			$('#startYyyymm').val(yyyymm);
			$('#endYyyymm').val(yyyymm);
		});
		$('#selStatic').trigger('change');
		
		_this.selList();
    },
    upload : function () {
        const staticId = $('#selStatic option:selected').val();
        const staticText = $('#selStatic option:selected').text();
        const startYyyymm =  $('#startYyyymm').val().replace('-','');
        const endYyyymm =  $('#endYyyymm').val().replace('-','');
        
        if(startYyyymm.length != 6
        || endYyyymm.length != 6
        ) {
	        alert("시작년월, 종료년월이 부적합합니다.");
	        return;
		}
        const chkMessage = staticText + " " 
        + startYyyymm + "~"
        + endYyyymm + " 적재하시겠습니까?";
        const chk = confirm(chkMessage);
        
        if(chk == false) return;
        
        var data = {
            startYyyymm: startYyyymm ,
            endYyyymm: endYyyymm ,
        };
		
		const prcUrl = '/population/'+ staticId;
		$('#btn-save1').addClass('disabled');
		$('#loadingbar').css('display','block');
        $.ajax({
            type: 'POST',
            url: prcUrl,
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(response){
			$('#loadingbar').css('display','none');
			$('#btn-save1').removeClass('disabled');
			var data = JSON.parse(response).data;
			console.log(data);
            alert('정상처리되었습니다.' + ' : ' + data);
            _this.selList();            
            //window.location.href = '/';
        }).fail(function(response) {
			$('#loadingbar').css('display','none');
			$('#btn-save1').removeClass('disabled');
            var error = JSON.parse(response.responseText);
            alert(error.code + ' : ' + error.message);
        });
    },
    selList : () => {
	        $.ajax({
            type: 'GET',
            url: '/population/uploadStatList',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(response => {
			console.log(response);
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