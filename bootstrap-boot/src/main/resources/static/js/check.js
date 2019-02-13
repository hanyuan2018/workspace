// 电话号码check
function checkPhone(phone) {
    var dhhmPhone = /^1[3|4|5|7|8]\d{9}/;
    return dhhmPhone.test(phone);
}

function checkTel(tel) {
    var dhhmTel = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/;
    return dhhmTel.test(tel);
    
}

// 数字型check
function checkNumberic(tel) {
    var checkNumberic = /^[0-9]+$/;
    return checkNumberic.test(tel);
}

// 姓名检查
function checkXm(tel) {
    var checkXm = /^[a-zA-Z0-9\u4E00-\u9FA5]{2,10}$/;
    return checkXm.test(tel);
}

