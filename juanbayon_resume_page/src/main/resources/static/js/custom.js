(function ($) {

    // COLOR MODE
    $('.color-mode').click(function(){
        $('body').toggleClass('dark-mode')
    });

    // FIELD FOCUS
    $('.form-control').focus(function(){
        $(this).parent().addClass('is-focused')
    });

        //SHOW BURGER MENU
    $(document).ready(function() {
        $('.burger-menu').click(function(){
                $('body').toggleClass('menu-shown');
        });
    });

    //BURGER MENU ICON OPEN/CLOSEn
    $(document).ready(function() {
        $('.nav-icon').click(function(){
            $(this).toggleClass('open');
        });
    });

})(jQuery);


