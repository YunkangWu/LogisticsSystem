/**
 * 用于给所有的表格加上全选事件, 全选不选事件
 */
$(function(){
	$(".tablelist").each(function() {
		// 表格
		var table = $(this);
		// 全选按钮
		var checkAll = table.find("tr:eq(0) :checkbox:eq(0)");
		// tbody的tr
		var tbody_tr = table.find("tr:gt(0)");
		// 包含form的table
		var form = table.parents("form:eq(0)");

		// 全选按钮的点击事件
		checkAll.click(function() {
			tbody_tr.each(function() {
    			$(this).find(":checkbox:eq(0)").prop("checked", checkAll[0].checked);
    		});
			if(this.checked) {
				tbody_tr.addClass("active");
			} else {
				tbody_tr.removeClass("active");
			}
		});

    	// tbody_tr的点击事件
		tbody_tr.click(function(event) {
    		// 去掉注释就只允许单选
    		$(this).siblings("tr").each(function() {
    			$(this).find(":checkbox:eq(0)").prop("checked", false);
    		});
    		$(this).siblings("tr").removeClass("active");

    		$(this).toggleClass("active");
    		$(this).find(":checkbox:eq(0)").prop("checked", !$(this).find(":checkbox:eq(0)").prop("checked"));
    		// checkAll.prop("checked", tbody_tr.length==table.find(".active").length);
    		checkAll[0].checked = tbody_tr.length==table.find(".active").length;
    		event.stopPropagation();
    	});

    	// checkbox点击事件
		tbody_tr.each(function(){
	    	$(this).find(":checkbox:eq(0)").click(function(event) {
	    		$(this).parents("tr:eq(0)").toggleClass("active");
	    		// checkAll.prop("checked", tbody_tr.length==table.find(".active").length);
	    		checkAll[0].checked = tbody_tr.length==table.find(".active").length;
	    		event.stopPropagation();
	    	});
    	});
	});

});
