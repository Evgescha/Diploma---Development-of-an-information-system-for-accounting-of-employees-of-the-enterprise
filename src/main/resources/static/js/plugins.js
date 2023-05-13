"use strict";
function toggleMobileMenu() {
    var menuIcon = jQuery('.main-menu-icon');
    jQuery(menuIcon).toggleClass('menu-opened');
    if(jQuery(menuIcon).hasClass('menu-opened')) {
        jQuery('#mainmenu').css({'display' : 'block'}).animate({height: 300, opacity: 1}, 350);
    } else {
        jQuery('#mainmenu').animate({height: 0, opacity: 0}, 400, function() {
            jQuery(this).css({'display' : 'none'});
        });
    }
}



jQuery(document).ready(function() {

    // 2/3/4th level menu  offscreen fix
    var MainWindowWidth = jQuery(window).width();
    jQuery(window).resize(function(){
        MainWindowWidth = jQuery(window).width();
    });        
    jQuery('.sf-menu ul li').mouseover(function(){
        // checks if third level menu exist         
        var subMenuExist = jQuery(this).find('.dropdown-menu').length;            
        if( subMenuExist > 0){
            var subMenuWidth = jQuery(this).find('.dropdown-menu').width();
            var subMenuOffset = jQuery(this).find('.dropdown-menu').parent().offset().left + subMenuWidth;
            // if sub menu is off screen, give new position
            if((subMenuOffset + subMenuWidth) > MainWindowWidth){                  
                var newSubMenuPosition = subMenuWidth + 80;
                $(this).find('.dropdown-menu').first().css({
                    left: -newSubMenuPosition,
                });
            }
        }
    });

    //mobile menu
    jQuery('.main-menu-icon').on('click', toggleMobileMenu);

});

