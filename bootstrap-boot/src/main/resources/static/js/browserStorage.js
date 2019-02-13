var BrowserStorage = function () {
    /**
     * 设置页面cookie值
     * @param name
     * @param value 天
     */
    function setCookie(name, value, exdays){
        var date = new Date();
        if(exdays == undefined){
            exdays = 1;
        }
        date.setTime(date.getTime() + exdays*24*3600*1000);
        document.cookie = name + "="+ decodeURI(value)+"; expire=" + date.toGMTString();
    }
    /**
     * 获取浏览器中的cookie值
     * @param name
     * @returns
     */
    function getCookie(name){
        var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
        if(arr != null) return decodeURIComponent(arr[2]); return null;

    }
    /**
     * 删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
     * @param objName
     */
    function clearCookie(objName) {
        setCookie(objName, "", -1);
    }
    /**
     *添加localStorage
     */ 
    function addLocalStorage(name, value) {
        localStorage.setItem(name, value);
    }

    /**
     *获取cookie
     */
    function getLocalStorage(name) {
        if (localStorage.getItem(name) == null) {
            return "";
        } else {
            return localStorage.getItem(name);
        }
    }

    /**
     *删除cookie
     */
    function deleteLocalStorage(name) {
        localStorage.removeItem(name);
    }
    /**
     *添加sessionStorage
     */
    function addSessionStorage(key, value) {
        sessionStorage.setItem(key, value);
    }
    /**
     *获取sessionStorage
     */
    function getSessionStorage(key) {
         return sessionStorage.getItem(key);
    }
    /**
     *删除某个sessionStorage
     */
    function delSessionStorage(key) {
        sessionStorage.removeItem(key);
    }
    /**
     * 清除所有sessionStorage
     */
    function clearSessionStorage() {
        sessionStorage.clear();
    }
    
    return {
        setCookie:function(name, value, exdays){
            setCookie(name, value, exdays);
        },
        getCookie:function(name){
            return getCookie(name);
        },
        clearCookie:function(objName){
            clearCookie(objName);
        },
        addLocalStorage:function(name, value){
            addLocalStorage(name, value);
        },
        getLocalStorage:function(name){
            return getLocalStorage(name);
        },
        deleteLocalStorage:function(name){
            deleteLocalStorage(name);
        },
        addSessionStorage:function(key, value){
            addSessionStorage(key, value);
        },
        getSessionStorage:function(key){
            return getSessionStorage(key);
        },
        delSessionStorage:function(key){
            delSessionStorage(key);
        },
        clearSessionStorage:function(){
            clearSessionStorage();
        }
    };
}();