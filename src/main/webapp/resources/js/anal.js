
(function () {

    var iterator,
        asyncTracker,
        win = window,
        doc = document,
        math = Math,
        decodeWrapper = window.decodeURIComponent,
        encodeWrapper = window.encodeURIComponent;


    if (typeof _paq !== 'object') {
        _paq = [];
    }

    function isObject(property) {
        return typeof property === 'object';
    }

    function isString(property) {
        return typeof property === 'string' || property instanceof String;
    }

    function apply() {
        var i, f, parameterArray;

        for (i = 0; i < arguments.length; i += 1) {
            parameterArray = arguments[i];
            f = parameterArray.shift();

            if (isString(f)) {
                asyncTracker[f].apply(asyncTracker, parameterArray);
            } else {
                f.apply(asyncTracker, parameterArray);
            }
        }
    }

    for (iterator = 0; iterator < _paq.length; iterator++) {
        var methodName = _paq[iterator][0];
        alert(methodName);
        if (applyFirst[methodName]) {
            apply(_paq[iterator]);
            delete _paq[iterator];

            if (applyFirst[methodName] > 1) {
                if (console !== undefined && console && console.error) {
                    console.error('The method ' + methodName + ' is registered more than once in "_paq" variable. Only the last call has an effect. Please have a look at the multiple Piwik trackers documentation: http://developer.piwik.org/guides/tracking-javascript-guide#multiple-piwik-trackers');
                }
            }

            applyFirst[methodName]++;
        }
    }
    function Tracker(url, siteGuid) {
        var
            configuredSiteGuid = siteGuid || '',
            visitorUUID = '';

        function loadVisitorIdCookie() {
            var now = new Date(),
                nowTs = Math.round(now.getTime() / 1000),
                visitorIdCookieName = getCookieName('id'),
                id = getCookie(visitorIdCookieName),
                cookieValue,
                uuid;

            // Visitor ID cookie found
            if (id) {
                cookieValue = id.split('.');

                // returning visitor flag
                cookieValue.unshift('0');

                if (visitorUUID.length) {
                    cookieValue[1] = visitorUUID;
                }
                return cookieValue;
            }

            if (visitorUUID.length) {
                uuid = visitorUUID;
            } else {
                var utm = parseGET();
                uuid = utm[namekey];
            }

            // No visitor ID cookie, let's create a new one
            cookieValue = [
                // new visitor
                '1',

                // userGuid
                uuid,

                // creation timestamp - seconds since Unix epoch
                nowTs,

                // visitCount - 0 = no previous visit
                0,

                // current visit timestamp
                nowTs,

                // last visit timestamp - blank = no previous visit
                '',

                // last ecommerce order timestamp
                ''
            ];

            return cookieValue;
        }

        function getCookieName(baseName) {
            // NOTE: If the cookie name is changed, we must also update the PiwikTracker.php which
            // will attempt to discover first party cookies. eg. See the PHP Client method getVisitorId()
            //return configCookieNamePrefix + baseName + '.' + configTrackerSiteId + '.' + domainHash;
            return baseName;
        }

        function getValuesFromVisitorIdCookie() {

            var cookieVisitorIdValue = loadVisitorIdCookie(),
                newVisitor = cookieVisitorIdValue[0],
                userGuid = cookieVisitorIdValue[1],
                createTs = cookieVisitorIdValue[2],
                visitCount = cookieVisitorIdValue[3],
                currentVisitTs = cookieVisitorIdValue[4],
                lastVisitTs = cookieVisitorIdValue[5];
            //if (!isDefined(cookieVisitorIdValue[6])) {
                cookieVisitorIdValue[6] = "";
            //}


            var lastEcommerceOrderTs = cookieVisitorIdValue[6];
            return {
                newVisitor: newVisitor,
                userGuid: userGuid,
                createTs: createTs,
                visitCount: visitCount,
                currentVisitTs: currentVisitTs,
                lastVisitTs: lastVisitTs,
                lastEcommerceOrderTs: lastEcommerceOrderTs
            };
        }

        function getCookie(cookieName) {
            var cookiePattern = new RegExp('(^|;)[ ]*' + cookieName + '=([^;]*)'),
                cookieMatch = cookiePattern.exec(doc.cookie);

            return cookieMatch ? decodeWrapper(cookieMatch[2]) : 0;
        }


        function setVisitorIdCookie(visitorIdCookieValues) {
            if (!configuredSiteGuid) {
                return;
            }

            var now = new Date(),
                nowTs = math.round(now.getTime() / 1000);

            //if (!isDefined(visitorIdCookieValues)) {
                visitorIdCookieValues = getValuesFromVisitorIdCookie();
            //}

            var cookieValue = visitorIdCookieValues.userGuid + '.' +
                visitorIdCookieValues.createTs + '.' +
                visitorIdCookieValues.visitCount + '.' +
                nowTs + '.' +
                visitorIdCookieValues.lastVisitTs + '.' +
                visitorIdCookieValues.lastEcommerceOrderTs;

            setCookie(getCookieName('id'), cookieValue, null, null, null);
        }

        function setCookie(cookieName, value, msToExpire, path, domain, secure) {
            var expiryDate;

            // relative time to expire in milliseconds
            if (msToExpire) {
                expiryDate = new Date();
                expiryDate.setTime(expiryDate.getTime() + msToExpire);
            }

            doc.cookie = cookieName + '=' + encodeWrapper(value) +
            (msToExpire ? ';expires=' + expiryDate.toGMTString() : '') +
            ';path=' + (path || '/') +
            (domain ? ';domain=' + domain : '') +
            (secure ? ';secure' : '');
        }

        var namekey = 'utm_content';

        function parseGET(url) {
            if (!url || url == '') url = decodeURI(win.document.location.search);
            if (url.indexOf('?') < 0) return Array();

            url = url.split('?');
            url = url[1];

            var GET = [],
                params = [],
                key = [];

            if (url.indexOf('#') != -1) {
                url = url.substr(0, url.indexOf('#'));
            }
            if (url.indexOf('&') > -1) {
                params = url.split('&');
            } else {
                params[0] = url;
            }

            for (cookie = 0; cookie < params.length; cookie++) {
                for (prototype = 0; prototype < namekey.length; prototype++) {
                    if (params[cookie].indexOf(namekey[prototype] + '=') > -1) {
                        if (params[cookie].indexOf('=') > -1) {
                            key = params[cookie].split('=');
                            GET[key[0]] = key[1];
                        }
                    }
                }
            }
            return (GET);
        }

         function sendXmlHttpRequest(request, callback, fallbackToGet) {
            $.ajax({
                url: 'http://localhost:8080/sitestat',
                type: 'POST',
                data: (request),
                success: function (data) {
                },
                error: function (xhr, status, error) {
                    //var err = eval("(" + xhr.responseText + ")");
                    //alert(xhr.responseText + " " + error + " " + status + " ");
                }
            });
        }

        /*{
            var utm = parseGET();
            var value = utm[namekey];
            var json = {
                siteGuid: "11998d56-5f96-44b0-8dd1-22c2058272c2",
                userGuid: value
            };



        }*/
        return{
            sendData: function(request, callback, fallbackToGet)
            {return sendXmlHttpRequest(request, callback, fallbackToGet)},
            url:parseGET()[namekey],
            siteGuid:siteGuid,
            setCookie:function ()
            {
                var utm = parseGET();
                var value = utm[namekey];
                return setVisitorIdCookie(url);
            },
            getCookie:function()
            {
                return getValuesFromVisitorIdCookie();
            }
        }
    }
    new Tracker(decodeURI(window.document.location.search), "opopo");
    //tracker.setCookie();
    //var cookieVisitorIdValues = tracker.getCookie();
    //var userGuid = cookieVisitorIdValues.userGuid;
    //alert(userGuid);
    //if(userGuid)
    //{
    //    var json = {"siteGuid" : "11998d56-5f96-44b0-8dd1-22c2058272c2", "userGuid": userGuid, "isCookie" : "1"};
    //}
    //tracker.sendData(json, null, null);
})(window);
