/**
 * Created by zxk175 on 2017/3/22.
 */
/**
 * Created by zxk175 on 16/12/2.
 */

var $table = $('#tree_table');

//防止表头与表格不对齐
$(window).resize(function () {
    $table.bootstrapTable('resetView');
});

$(function () {
    //使用严格模式
    "use strict";

    tableInit();
    $table.bootstrapTable('hideLoading');
})

//初始化Table
function tableInit() {
    //先销毁表格
    $table.bootstrapTable('destroy');

    $table.bootstrapTable({
        //请求地址
        url: ctx + '/tree/show/10000/singe',
        //请求方式
        method: 'post',
        //请求内容类型
        contentType: "application/x-www-form-urlencoded",
        //数据类型
        dataType: "json",
        //table高度
        height: 482,
        //是否显示行间隔色
        striped: true,
        //是否启用排序
        sortable: false,
        //排序方式
        sortOrder: "asc",
        //是否使用缓存
        cache: false,
        //每行的唯一标识
        uniqueId: "id",
        //显示隐藏列
        showColumns: false,
        //显示刷新按钮
        showRefresh: false,
        //切换显示样式
        showToggle: false,
        //显示Table脚部
        showFooter: true,
        //是否显示分页
        pagination: true,
        //是否显示分页按钮
        showPaginationSwitch: false,
        //是否启用点击选中行
        clickToSelect: false,
        //最少要显示的列数
        minimumCountColumns: 2,
        //cell没有值时显示
        undefinedText: '-',
        //分页方式：client客户端分页，server服务端分页
        sidePagination: "server",
        //每页的记录行数
        pageSize: 10,
        //初始化加载第1页，默认第1页
        pageNumber: 1,
        //可供选择的每页的行数
        pageList: "[10, 20, 50, 80, 100]",
        paginationFirstText: "首页",
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        paginationLastText: "末页",
        buttonsClass: 'default',
        iconsPrefix: 'glyphicon',
        queryParams: queryParams,
        icons: {
            paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
            paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
            refresh: 'glyphicon-refresh icon-refresh',
            toggle: 'glyphicon-list-alt icon-list-alt',
            columns: 'glyphicon-th icon-th',
            detailOpen: 'glyphicon-plus icon-plus',
            detailClose: 'glyphicon-minus icon-minus'
        }, columns: [{
            title: '序号',
            field: 'index',
            align: 'center',
            valign: 'middle',
            formatter: genderIndex
        }, {
            title: '城市Id',
            field: 'cityId',
            align: 'center',
            valign: 'middle'
        }, {
            title: '城市名字',
            field: 'cityName',
            align: 'center',
            valign: 'middle'
        }, {
            title: '父Id',
            field: 'parentId',
            align: 'center',
            valign: 'middle'
        }],
        responseHandler: function (res) {
            if (res.status == 0) {
                var obj = {
                    "total": res.total,
                    "rows": res.records,
                };
            } else {
                var obj = {
                    "total": 0,
                    "rows": [],
                }
            }
            return obj;
        }, onLoadSuccess: function () {
            //加载成功时执行
            console.log("加载成功!");
        }, onLoadError: function () {
            //加载失败时执行
            layer.msg("加载失败!", {icon: 2, time: 2000});
        }, formatLoadingMessage: function () {
            //正在加载
            return "请稍等，正在加载中...";
        }, formatNoMatches: function () {
            //没有匹配的结果
            return '无符合条件的记录';
        }
    })
}

//生成序号
function genderIndex(value, row, index) {
    return index + 1;
}

//查询条件与分页数据
function queryParams(params) {
    //排序方式
    params.order = "modify_time desc";
    //第几页
    params.nowPage = this.pageNumber;
    //name
    params.name = $("#name").val();
    //sex
    params.sex = $('#sex option:selected').val();
    return params;
}
