var main = {
    init : function (){
        var _this = this;
        $('#btn-save1').on('click', function () {
            _this.save1();
        });        
        
        $('#btn-save2').on('click', function () {
            _this.save2();
        });        

    },
    save1 : function () {
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
            //window.location.href = '/';
        }).fail(function(response) {
			$('#loadingbar').css('display','none');
			$('#btn-save1').removeClass('disabled');
            var error = JSON.parse(response.responseText);
            alert(error.code + ' : ' + error.message);
        });
    },

}

main.init();