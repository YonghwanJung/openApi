var main = {
    init : function (){
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            yyyymm: $('#yyyymm').val()
        };

        $.ajax({
            type: 'POST',
            url: '/imsi/loadStatPopulationTrendSido',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('정상처리되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert('에러');
            alert(JSON.stringify(error));
        });
    }
}

main.init();