/**
 * Created by Nikita Tkachuk on 24.02.2015.
 */

function showScript()
{
    var elem=document.getElementById("toChange");
    var x=0;
    if(x==1)
        clearInterval(t);
    x += 0.05;
    elem.style.opacity = x;
    elem.style.filter="alpha(opacity=" + (x * 100) + ")";
    var t = setInterval(moreVisible, 25);

}
function showAddSiteDialog() {
    $(function () {
        $('.addSiteDialog').show();
        $('html,body').css('overflow', 'hidden');
        //$(".addSiteDialog").dialog();
    });
}

function closeAddSiteDialog()
{
    $('.addSiteDialog').hide();
}

function addSite()
{
    var siteUrl = $('#newSiteURL').val();
   // var json = {"url" : siteUrl } ;
    $.ajax({
        url: '/user/addSite',
        type: 'GET',
        data : ({
            url: siteUrl
        }),
        success: function(data) {
            closeAddSiteDialog();
            alert('Site has been added');

        },
        error: function(xhr, status, error) {
            //var err = eval("(" + xhr.responseText + ")");
            alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });
}

    //$("html,body").css("overflow","auto");
    //$('html').scrollTop(scrollPos);
    /*$('[class*=popup-link]').click(function(e) {

        *//* Предотвращаем действия по умолчанию *//*
        e.preventDefault();
        e.stopPropagation();

        *//* Получаем id (последний номер в имени класса ссылки) *//*
        var name = $(this).attr('class');
        var id = name[name.length - 1];
        var scrollPos = $(window).scrollTop();

        *//* Корректный вывод popup окна, накрытие тенью, предотвращение скроллинга *//*
        $('#popup-box-'+id).show();
        $('#blackout').show();
        $('html,body').css('overflow', 'hidden');

        *//* Убираем баг в Firefox *//*
        $('html').scrollTop(scrollPos);
    });

    $('[class*=popup-box]').click(function(e) {
        *//* Предотвращаем работу ссылки, если она являеться нашим popup окном *//*
        e.stopPropagation();
    });
    $('html').click(function() {
        var scrollPos = $(window).scrollTop();
        *//* Скрыть окно, когда кликаем вне его области *//*
        $('[id^=popup-box-]').hide();
        $('#blackout').hide();
        $("html,body").css("overflow","auto");
        $('html').scrollTop(scrollPos);
    });
    $('.close').click(function() {
        var scrollPos = $(window).scrollTop();
        *//* Скрываем тень и окно, когда пользователь кликнул по X *//*
        $('[id^=popup-box-]').hide();
        $('#blackout').hide();
        $("html,body").css("overflow","auto");
        $('html').scrollTop(scrollPos);
    });*/


