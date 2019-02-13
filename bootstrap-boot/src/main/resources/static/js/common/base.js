//项目根路径参数
var rootPath = "";
$(function() {
	// 初始化获取项目的根路径信息
	getRootPath();
})

// 获取项目的根路径信息方法
function getRootPath() {
	var info = window.document.location;
	var pos = info.href.indexOf(info.pathname);
	rootPath = info.href.substring(0, pos) 
			 + info.pathname.substring(0, info.pathname.substr(1).indexOf('/') + 1)
}