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
        var data = {
            startYyyymm: $('#startYyyymm').val() ,
            endYyyymm: $('#endYyyymm').val() ,
        };

        $.ajax({
            type: 'POST',
            url: '/population/loadStatPopulationTrendSido',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(response){
			var data = JSON.parse(response).data;
			console.log(data);
            alert('정상처리되었습니다.' + ' : ' + data);            
            //window.location.href = '/';
        }).fail(function(response) {
            var error = JSON.parse(response.responseText);
            alert(error.code + ' : ' + error.message);
        });
    },
    save2 : function () {
        var data = {
            startYyyymm: $('#startYyyymm').val() ,
            endYyyymm: $('#endYyyymm').val() ,
        };

        $.ajax({
            type: 'POST',
            url: '/population/loadStatPopulationMoveSido',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(response){
			var data = JSON.parse(response).data;
			console.log(data);
            alert('정상처리되었습니다.' + ' : ' + data);            
            //window.location.href = '/';
        }).fail(function(response) {
            var error = JSON.parse(response.responseText);
            alert(error.code + ' : ' + error.message);
        });
    }

}

main.init();