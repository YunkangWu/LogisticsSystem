/**
 * Created by Yunkang Wu
 * 用户表头新增修改删除事件
 */
$(document).ready(function () {
    // 当前页面的地址
    var href = window.location.href;

    // 新增按钮
    $(".nav_add").click(function () {
        window.location.href = href.replace(/list$/, "addUI");
    });

    // 修改按钮
    $(".modify").click(function () {
        var selectedRow = $(".tablelist").find(":checkbox[name='id']:checked");
        if (selectedRow.length == 0) {
            alert("没有选择记录！");
            return false;
        } else if (selectedRow.length > 1) {
            alert("只能选择一条记录进行修改！");
            return false;
        } else {
            var id = $(".tablelist").find(":checkbox[name='id']:checked")[0].value;
            window.location.href = href.replace(/list$/, "edit") + "?id=" + id;
        }
    });

    // 删除按钮
    $(".del").click(function () {
        var selectedRow = $(".tablelist").find(":checkbox[name='id']:checked");
        if (selectedRow.length == 0) {
            alert("没有选择记录！");
            return false;
        } else {
            if (window.confirm("确认要删除" + selectedRow.length + "条记录吗?")) {
                // alert(selectedRow.serialize());
                window.location.href = href.replace(/list$/, "delete") + "?" + selectedRow.serialize();
            }
        }
    });

    // 行双击事件: 双击修改
    $(".tablelist").each(function () {
        var table = $(this);
        var tbody_tr = table.find("tr:gt(0)");
        tbody_tr.dblclick(function () {
            var id = $(this).find("[name='id']")[0].value;
            window.location.href = href.replace(/list$/, "edit") + "?id=" + id;
        });
    });
});
