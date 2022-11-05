const main = {
    init : function (){
        const _this = this;
        $("header a[href='/stat/search']").addClass("active");
        $("#sidebarMenu a[href='/stat/search']").addClass("active");
    },
}

main.init();