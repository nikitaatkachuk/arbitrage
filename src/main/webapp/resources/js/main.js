/**
 * Created by Nikita Tkachuk on 24.02.2015.
 */


function closeAddSiteDialog()
{
    $('.addSiteDialog').hide();
}

function addSite()
{
    var siteUrl = $('#newSiteURL').val();
   // var json = {"url" : siteUrl } ;
    $.ajax({
        url: 'user/addSite',
        type: 'POST',
        data : ({
            url: siteUrl
        }),
        success: function(data) {
            closeAddSiteDialog();
            $(".sites_table").append("<tr><td class='info'><a href= /site/" + data.id + ">" + data.url + "</a></td><td></td></tr>");
        },
        error: function(xhr, status, error) {
            //var err = eval("(" + xhr.responseText + ")");
            alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });
}

function registerVisit()
{
    //var siteUrl = $('#newSiteURL').val();
    // var json = {"url" : siteUrl } ;
    $.ajax({
        url: 'order/register',
        type: 'POST',
        data : ({
            orderTime: new Date().getTime(),
            orderData: "azaza",
            secondVisit:true
        }),
        success: function(data) {
            //closeAddSiteDialog();
            //$(".sites_table").append("<tr><td class='info'><a href= /site/" + data.id + ">" + data.url + "</a></td><td></td></tr>");
        },
        error: function(xhr, status, error) {
            //var err = eval("(" + xhr.responseText + ")");
            alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });
}





