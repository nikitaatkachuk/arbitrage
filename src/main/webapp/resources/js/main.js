/**
 * Created by Nikita Tkachuk on 24.02.2015.
 */


function closeDialog()
{
    $('.close').click();
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
            closeDialog();
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
            //closeDialog();
            //$(".sites_table").append("<tr><td class='info'><a href= /site/" + data.id + ">" + data.url + "</a></td><td></td></tr>");
        },
        error: function(xhr, status, error) {
            //var err = eval("(" + xhr.responseText + ")");
            alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });
}

function addGoal()
{
    var pageUrlPattern = $('#pageUrlPattern').val();
    var isEndPoint = document.getElementById('isEndPoint').checked;
    // var json = {"url" : siteUrl } ;
    $.ajax({
        url: 'goal/register',
        type: 'POST',
        data : ({
            pageUrlPattern: pageUrlPattern,
            endPoint: isEndPoint
        }),
        success: function(data) {
            closeDialog();
            //$(".sites_table").append("<tr><td class='info'><a href= /site/" + data.id + ">" + data.url + "</a></td><td></td></tr>");
        },
        error: function(xhr, status, error) {
            closeDialog();
            //var err = eval("(" + xhr.responseText + ")");
            //alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });
}
function date2string(date) {
    return date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2)
}
function getStatistic()
{
    var statisticRestMethod;
    if(document.getElementById('statistic_type_user').checked)
    {
        statisticRestMethod = '/byusername';
    }
    else if(document.getElementById('statistic_type_site').checked)
    {
        statisticRestMethod = '/bysite';
    }
    else if(document.getElementById('statistic_type_group').checked)
    {
        statisticRestMethod = '/bygroupname';
    }
    else
    {
        alert("Please, select statistic type!");
        return;
    }
    var statisticTargetName =  $('#statistic_target_name').val();
    $.ajax({
        url: 'statistic' + statisticRestMethod,
        type: 'POST',
        data : ({
            name: statisticTargetName
        }),
        success: function(data) {
            $('#detail_statistic_table').append("<tr><td>data.firstVisits</td><td>data.secondVisits</td><td>data.completedGoals</td></tr>");
        },
        error: function(xhr, status, error) {
            var err = eval("(" + xhr.responseText + ")");
            alert(xhr.responseText + " " + error + " " + status + " ");
        }
    });

}





