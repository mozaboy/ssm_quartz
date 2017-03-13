<html>
<head>
    <title>${page_title}FTL</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <!-- jQuery -->
    <script type="text/javascript" src="${ctx}/library/jquery/jquery.min.js"></script>
    <!-- bootstrap -->
    <script type="text/javascript" src="${ctx}/library/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/library/bootstrap/css/bootstrap.min.css"/>
    <!--[if lt IE 9]>
    <script src="${ctx}/library/bootstrap/plugins/ie/html5shiv.js"></script>
    <script src="${ctx}/library/bootstrap/plugins/ie/respond.js"></script>
    <![endif]-->
    <!--[if lt IE 8]>
    <script src="${ctx}/library/bootstrap/plugins/ie/json2.js"></script>
    <![endif]-->
    <!-- font-awesome -->
    <link rel="stylesheet" type="text/css" href="${ctx}/library/fontAwesome/css/font-awesome.min.css"/>
    <!-- datatable -->
    <link rel="stylesheet" type="text/css" href="${ctx}/library/datatable/media/css/dataTables.bootstrap.min.css"/>
    <script src="${ctx}/library/datatable/media/js/jquery.dataTables.js"></script>
    <script src="${ctx}/library/datatable/media/js/dataTables.bootstrap.min.js"></script>
    <!-- layer -->
    <script src="${ctx}/library/lay/layer/layer.js"></script>
    <!-- base -->
    <link rel="stylesheet" type="text/css" href="${ctx}/css/base.css"/>
    <script src="${ctx}/js/base.js"></script>
    <script type="text/javascript">
        var ctx = "${ctx}";
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="searchBox">
        <label for="name">用户名称：</label>
        <input id="name" type="text"/>
        <button id="search" class="btn btn-info btn-sm" type="button">
            <span class="glyphicon glyphicon-search"></span>
            查询
        </button>
        <button id="clear" class="btn btn-danger btn-sm" type="button">
            清空条件
        </button>
    </div>

    <div class="searchBox">
        <button id="btn_add" class="btn btn-info btn-sm" data-target="#addAndEdit" data-toggle="modal" type="button">
            <span class="glyphicon glyphicon-plus"></span>
            添加
        </button>
    </div>

    <table id="tasks" class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>任务编号</th>
            <th>任务名</th>
            <th>任务组</th>
            <th>触发器组</th>
            <th>触发器名</th>
            <th>执行代码的类名</th>
            <th>是否禁用</th>
            <th>触发器表达式</th>
            <th>任务状态</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th>任务编号</th>
            <th>任务名</th>
            <th>任务组</th>
            <th>触发器组</th>
            <th>触发器名</th>
            <th>执行代码的类名</th>
            <th>是否禁用</th>
            <th>触发器表达式</th>
            <th>任务状态</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        </tfoot>
    </table>

    <!-- 新增或修改模态框 -->
    <div id="addAndEdit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addAndEditLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="addAndUpdateLabel">新增任务信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="txt_type" class="form-control" id="txt_type" placeholder="操作类型">
                    <input type="hidden" name="txt_id" class="form-control" id="txt_id" placeholder="编号">
                    <div class="form-group">
                        <label for="txt_name">名称</label>
                        <input type="text" name="txt_name" class="form-control" id="txt_name" placeholder="名称"
                               autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label class="control-label">性别</label>
                        <div class="controls">
                            <input id="p_man" type="radio" name="sex" value="1" checked/>
                            <label for="p_man" style="margin-right: 30px;">男</label>
                            <input id="p_woman" type="radio" name="sex" value="0"/>
                            <label for="p_woman">女</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txt_pwd">密码</label>
                        <input type="password" name="txt_pwd" class="form-control" id="txt_pwd" placeholder="密码"
                               autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="txt_email">邮箱</label>
                        <input type="text" name="txt_email" class="form-control" id="txt_email" placeholder="邮箱">
                    </div>
                    <div class="form-group">
                        <label for="txt_phone">手机</label>
                        <input type="text" name="txt_phone" class="form-control" id="txt_phone" placeholder="名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
                    </button>
                    <button type="button" id="btn_add_and_edit_submit" class="btn btn-primary btn-sm"
                            data-dismiss="modal">
                        <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var table;
    $(function () {
        //初始化Table
        table = $("#tasks").dataTable({
            // 汉化
            oLanguage: {
                "sProcessing": "加载数据中...",
                "sLengthMenu": "显示_MENU_条 ",
                "sZeroRecords": "没有您要搜索的内容",
                "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_  条)",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": " 上一页 ",
                    "sNext": " 下一页 ",
                    "sLast": " 尾页 "
                }
            },
            bFilter: false,
            // 分页按钮
            bPaginate: true,
            // 每行显示记录数
            bLengthChange: true,
            // 每页显示行数
            iDisplayLength: 10,
            bSort: false,
            bInfo: true,
            bWidth: true,
            bAutoWidth: true,
            bScrollCollapse: true,
            aLengthMenu: [[10, 25, 50], [10, 25, 50]],
            sPaginationType: "full_numbers",
            processing: true,
            serverSide: true,
            bDestroy: true,
            bSortCellsTop: true,
            aoColumns: [
                {data: "jobId"},
                {data: "jobName"},
                {data: "jobGroup"},
                {data: "triggerName"},
                {data: "triggerGroup"},
                {data: "className"},
                {
                    data: "enableStatus",
                    render: function (data, type, row) {
                        if (data == 0) {
                            return "<span style='color: #f00'>禁用</span>";
                        } else {
                            return "<span style='color: #17c455'>已启用</span>";
                        }
                    }
                },
                {data: "triggerCron"},
                {
                    data: "triggerStatus",
                    render: function (data, type, row) {
                        if (data == 0) {
                            return "<span style='color: #f00'>关闭</span>";
                        } else if (data == 1) {
                            return "<span style='color: #17c455'>运行中</span>";
                        } else {
                            return "<span style='color: #ff0'>暂停</span>";
                        }
                    }
                },
                {data: "crateTime"},
                {data: "updateTime"},
                {data: "descRipt"}
            ],
            columnDefs: [
                {
                    // 表示具体需要操作的目标列，下标从0开始
                    "targets": [12],
                    // 表示我们需要的某一列数据对应的属性名
                    "data": "jobId",
                    // data， 之前属性定义中对应的属性值
                    // type， 未知
                    // full,    全部数据值可以通过属性列名获取
                    "render": function (data, type, full) {
                        return "<div class='btn-group'>" +
                                "<button id='btn_edit' onclick='edit()' type='button' class='btn btn-info btn-sm' data-target='#addAndEdit' data-toggle='modal' data-id='" + data + "'>修改</button>" +
                                "<button id='btn_del' type='button' class='btn btn-danger btn-sm'>删除</button>" +
                                "<button id='btn_pause' onclick='pause(this)' type='button' class='btn btn-danger btn-sm' data-json='" + JSON.stringify(full) + "'>暂停</button>" +
                                "<button id='btn_pause' onclick='resume(this)' type='button' class='btn btn-danger btn-sm' data-json='" + JSON.stringify(full) + "'>恢复</button>" +
                                "</div>"
                    }
                }
            ],
            fnServerData: function (sSource, aoData, fnCallback) {
                $.ajax({
                    "type": 'get',
                    "url": ctx + '/task/show',
                    "dataType": "json",
                    "dataSrc": "param",
                    "data": {
                        param: JSON.stringify(aoData)
                    },
                    "success": function (res) {
                        if (res.code == 500) {
                            layer.open({
                                type: 1,
                                title: "异常信息",
                                skin: 'layui-layer-rim', //加上边框
                                area: ['1100px', '540px'], //宽高
                                shade: 0.3,
                                shadeClose: true,
                                content: "异常类型：<br/>" + res.exType +
                                "异常详细信息：<br/>" + res.exMsg
                            });
                        }
                        fnCallback(res);
                    }
                });
            }
        });
    });

    //重绘表格方法
    function drawTable() {
        table.DataTable().draw(true);
    }

    //修改按钮点击事件
    $("#btn_edit").on("click", function () {
        $('#addAndEditLabel').text("修改用户信息");
        $('#txt_type').val("add");
    });


    //暂停按钮点击事件
    function pause(obj) {
        var json = $(obj).attr("data-json");
        var data = JSON.parse(json);
        $.ajax({
            url: ctx + '/task/pause/' + data.jobId,
            type: 'post',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: json,
            success: function (msg) {
                if (msg.code == 500) {
                    layer.open({
                        type: 1,
                        title: "异常信息",
                        skin: 'layui-layer-rim', //加上边框
                        area: ['1200px', '540px'], //宽高
                        shade: 0.3,
                        shadeClose: true,
                        content: "异常类型：<br/>" + msg.exType +
                        "异常详细信息：<br/>" + msg.exMsg
                    });
                } else if (msg.code == 200) {
                    layer.msg(msg.message, {icon: 1, time: 1500});
                } else {
                    layer.msg(msg.message, {icon: 2, time: 1500});
                }
                drawTable();
            }
        })
    }

    //恢复按钮点击事件
    function resume(obj) {
        var json = $(obj).attr("data-json");
        var data = JSON.parse(json);
        $.ajax({
            url: ctx + '/task/resume/' + data.jobId,
            type: 'post',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: json,
            success: function (msg) {
                if (msg.code == 500) {
                    layer.open({
                        type: 1,
                        title: "异常信息",
                        skin: 'layui-layer-rim', //加上边框
                        area: ['1200px', '540px'], //宽高
                        shade: 0.3,
                        shadeClose: true,
                        content: "异常类型：<br/>" + msg.exType +
                        "异常详细信息：<br/>" + msg.exMsg
                    });
                } else if (msg.code == 200) {
                    layer.msg(msg.message, {icon: 1, time: 1500});
                } else {
                    layer.msg(msg.message, {icon: 2, time: 1500});
                }
                drawTable();
            }
        })
    }


    //清除弹窗原数据
    $("#addAndEdit").on("show.bs.modal", function () {
        $('#txt_name').val("");
        $('#txt_pwd').val("");
        $('#txt_email').val("");
        $('#txt_phone').val("");
        document.getElementById('p_man').checked = true;
    });
</script>
</body>
</html>
