var pageii = null;

$(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();
});

// 初始化表格对象
var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tablePage').bootstrapTable({
			url : rootPath + '/demo/getListInfo', // 请求后台的URL（*）
			method : 'POST', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 20, 30, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'name',
				title : '名称'
			}, {
				field : 'price',
				title : '价格'
			}, {
				field : 'column1',
				title : '列一'
			}, {
				field : 'column2',
				title : '列二'
			},{
				field : 'column3',
				title : '列三'
			}, {
				field : 'column4',
				title : '列四'
			} ]
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		// 表单参数序列化
		var searchParams = $("#formSearch").serializeJson();
		searchParams.pageNow = params.offset; // 页码
		searchParams.pageSize = params.limit; // 页面大小
		return searchParams;
	};

	return oTableInit;
}

// 初始化按钮绑定事件的对象
var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};

	oInit.Init = function() {// 初始化页面上面的按钮事件
		// 搜索
		$("#btn_query").click(function() {
			$("#tablePage").bootstrapTable('refresh');
		});

		// 新增
		$("#btn_add").click(function() {
			// 新增方法
			addFun();
		});

		// 编辑
		$("#btn_edit").click(function() {
			// 编辑方法
			editFun();
		});

		// 删除
		$("#btn_delete").click(function() {
			// 删除方法
			deleteFun();
		});
	};

	return oInit;
};

// 新增方法
function addFun() {
	//layer.alert("新增方法");
	pageii = layer.open({
		type : 2, // Layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）,
		shade : 0.1, // 遮罩层透明度
		area : [ '850px', '500px' ], // 弹出层宽高
		title : '材料库',// 弹出层标题
		content : rootPath + '/demo/addUI' // 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	});

}

// 编辑方法
function editFun() {
	//layer.alert("编辑方法");
	pageii = layer.open({
		type : 2, // Layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）,
		shade : 0.1, // 遮罩层透明度
		area : [ '850px', '500px' ], // 弹出层宽高
		title : '材料库',// 弹出层标题
		content : rootPath + '/demo/editUI' // 这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	});
}

// 删除方法
function deleteFun() {
	//layui.layer.alert("删除方法");
}