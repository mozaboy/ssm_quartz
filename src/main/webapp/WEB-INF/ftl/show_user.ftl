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
        <input id="name" type="text" autocomplete="off"/>
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

    <table id="users" class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>用户编号</th>
            <th>用户名称</th>
            <th>用户邮箱</th>
            <th>手机号</th>
            <th>加密后密码</th>
            <th>性别</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>是否有效</th>
            <th>操作</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th>用户编号</th>
            <th>用户名称</th>
            <th>用户邮箱</th>
            <th>手机号</th>
            <th>加密后密码</th>
            <th>性别</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>是否有效</th>
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
                    <h4 class="modal-title" id="addAndEditLabel">新增用户信息</h4>
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
                    <div id="onEdit" class="form-group">
                        <label class="control-label">是否有效</label>
                        <div class="controls">
                            <input id="p_valid" type="radio" name="state" value="1" checked/>
                            <label for="p_valid" style="margin-right: 30px;">有效</label>
                            <input id="p_invalid" type="radio" name="state" value="0"/>
                            <label for="p_invalid">无效</label>
                        </div>
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
        //提示信息
        var lang = {
            "sProcessing": "处理中...",
            "sLengthMenu": "每页_MENU_项",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
            "sInfoFiltered": "(全部记录数 _MAX_ 条)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "没有匹配结果",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页",
                "sJump": "跳转"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        };

        //初始化Table
        table = $("#users").dataTable({
            // 汉化
            oLanguage: lang,
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
                {data: "id"},
                {data: "userName"},
                {data: "userEmail"},
                {data: "userPhone"},
                {data: "userPwd"},
                {
                    data: "userSex",
                    render: function (data, type, row) {
                        if (data == 0) {
                            return "<i class='fa fa-female fa-2x' style='color: #faf;'></i>";
                        } else {
                            return "<i class='fa fa-male fa-2x' style='color: #0cf;'></i>";
                        }
                    }
                },
                {data: "createTime"},
                {data: "modifyTime"},
                {
                    data: "state",
                    render: function (data, type, row) {
                        if (data == 0) {
                            return "<span style='color: #f00'>无效</span>";
                        } else {
                            return "<span style='color: #17c455'>有效</span>";
                        }
                    }
                }
            ],
            columnDefs: [
                {
                    // 表示具体需要操作的目标列，下标从0开始
                    targets: 9,
                    // 禁用排序
                    orderable: false,
                    // 表示我们需要的某一列数据对应的属性名
                    data: "id",
                    width: "8%",
                    // data， 之前属性定义中对应的属性值
                    // type， 未知
                    // full,    全部数据值可以通过属性列名获取
                    render: function (data, type, full) {
                        return "<div class='btn-group'>" +
                                "<button id='btn_edit' onclick='editUser(this)' type='button' class='btn btn-info btn-sm' data-json='" + JSON.stringify(full) + "'><i class='fa fa-pencil'></i>修改</button>" +
                                "<button id='btn_del' onclick='deleteUser(this)' type='button' class='btn btn-danger btn-sm' data-id='" + data + "'><i class='fa fa-trash-o'></i>删除</button>" +
                                "</div>"
                    }
                }
            ],
            fnServerData: function (sSource, aoData, fnCallback) {
                aoData = params.getCondition(aoData);
                $.ajax({
                    type: 'get',
                    url: ctx + '/user/show',
                    dataType: "json",
                    data: {
                        param: JSON.stringify(aoData)
                    },
                    success: function (res) {
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

    //js捕获全局回车事件
    document.onkeydown = function (e) {
        var currKey = 0, e = e || event;
        //支持IE、FF
        currKey = e.keyCode || e.which || e.charCode;
        if (currKey == 13) {
            if (event) {
                e.returnValue = false;
            } else {
                e.preventDefault();
            }
            drawTable();
        }
    }

    //获取并添加额外条件参数
    var params = {
        getCondition: function (data) {
            data.push({"name": "userName", "value": $("#name").val()});
            return data;
        }
    };

    //查询按钮点击事件
    $("#search").on("click", function () {
        drawTable();
    })

    //清空查询条件
    $("#clear").on("click", function () {
        $("#name").val("");
        drawTable();
    })

    //重绘表格方法
    function drawTable() {
        table.DataTable().draw(true);
    }

    //新增按钮点击事件
    $("#btn_add").on("click", function () {
        clearData();
        $('#addAndEditLabel').text("新增用户信息");
        $('#txt_type').val("add");
        $('#onEdit').hide();
    });

    //删除按钮点击事件
    function deleteUser(obj) {
        var id = $(obj).attr("data-id");
        layer.confirm('你确定删除这条用户数据吗？', {
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                url: ctx + '/user/' + id,
                type: 'delete',
                contentType: 'application/json;charset=utf-8',
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
                        layer.msg(msg.message, {icon: 1, time: 1000});
                    } else {
                        layer.msg(msg.message, {icon: 2, time: 1000});
                    }
                    drawTable();
                }
            });
        }, function () {
            layer.msg('你已取消删除操作！', {icon: 0, time: 1000});
        });
    }

    //修改按钮点击事件
    function editUser(obj) {
        $('#onEdit').show();

        //向模态框中传值
        var data = JSON.parse($(obj).attr("data-json"));
        $('#addAndEditLabel').text("修改用户信息");
        $('#txt_type').val("edit");
        $('#txt_id').val(data.id);
        $('#txt_name').val(data.userName);
        $('#txt_pwd').val(data.userPwd);
        $('#txt_email').val(data.userEmail);
        $('#txt_phone').val(data.userPhone);
        if (data.userSex == 0) {
            document.getElementById('p_woman').checked = true;
        } else {
            document.getElementById('p_man').checked = true;
        }
        if (data.state == 0) {
            document.getElementById('p_invalid').checked = true;
        } else {
            document.getElementById('p_valid').checked = true;
        }

        $('#addAndEdit').modal();
    }

    //清除弹窗原数据
    function clearData() {
        $('#txt_id').val("");
        $('#txt_name').val("");
        $('#txt_pwd').val("");
        $('#txt_email').val("");
        $('#txt_phone').val("");
        document.getElementById('p_man').checked = true;
        document.getElementById('p_valid').checked = true;
    }

    //弹框保存按钮点击事件
    $('#btn_add_and_edit_submit').off().on('click', function () {
        var id = $('#txt_id').val(),
                name = $('#txt_name').val(),
                sex = $('input:radio[name="sex"]:checked').val(),
                pwd = $('#txt_pwd').val(),
                email = $('#txt_email').val(),
                phone = $('#txt_phone').val(),
                state = $('input:radio[name="state"]:checked').val(),
                type = $('#txt_type').val(),
                url = '',
                method = '';

        //验证数据
        if (!name) {
            layer.msg('请填写名称!', {icon: 2, time: 1500});
            return false;
        }
        if (!pwd) {
            layer.msg('请填写密码!', {icon: 2, time: 1500});
            return false;
        }
        if (!email) {
            layer.msg('请填写邮箱!', {icon: 2, time: 1500});
            return false;
        }
        if (!phone) {
            layer.msg('请填写手机!', {icon: 2, time: 1500});
            return false;
        }

        var userInfo = {
            id: id,
            userName: name,
            userSex: sex,
            userPwd: pwd,
            userEmail: email,
            userPhone: phone,
            state: state
        }

        if ('edit' == type) {
            url = ctx + '/user/' + id;
            method = 'put'
        } else {
            url = ctx + '/user/' + type;
            method = 'post'
        }

        $.ajax({
            url: url,
            type: method,
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(userInfo),
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
    });
</script>
</body>
</html>
