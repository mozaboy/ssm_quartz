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

    <link rel="stylesheet" type="text/css" href="${ctx}/library/bootstrap/plugins/tree/css/bootstrap-treeview.css"/>
    <script src="${ctx}/library/bootstrap/plugins/tree/js/bootstrap-treeview.js"></script>
    <script src="${ctx}/js/base.js"></script>
    <script type="text/javascript">
        var ctx = "${ctx}";
    </script>
</head>
<body>
<div class="container-fluid">


    <div class="col-lg-2">
        <button id="btn-expand-all" class="btn btn-sm btn-info">全部展开</button>
        <button id="btn-collapse-all" class="btn btn-sm btn-success">全部折叠</button>
        <button id="btn-check-all" class="btn btn-sm btn-info">全选</button>
        <button id="btn-uncheck-all" class="btn btn-sm btn-success">取消全选</button>


        <div id="tree"></div>
    </div>
    <div class="col-lg-8">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        // 异步请求TreeData
        $.ajax({
            url: ctx + '/tree/init',
            type: 'post',
            beforeSend:beforeSend, //发送请求
            success: function (res) {
                $("#tree").html('');
                initTree(res);
            }
        });

        // 发送请求之前
        function  beforeSend() {
            $("#tree").append("<div>加载ing......<div>");
        }

        /**
         * 初始化Tree
         * @param tree
         */
        function initTree(tree) {
            $('#tree').treeview({
                data: tree,
                levels: 1,
                showIcon: false,
                showTags: true,
                // 文字颜色
                color: "#4289ca",
                // 背景颜色
                backColor: '#eee',
                // 悬浮颜色
                onhoverColor: "#E8E8E8",
                // 启用Link
                enableLinks: false,
                // 是否显示边框
                showBorder: false,
                // 是否显示复选框
                showCheckbox: true,
                // 是否高亮选中
                highlightSelected: true,
                // 节点上的图标
                nodeIcon: 'glyphicon glyphicon-globe',
                // 折叠图标
                expandIcon: "glyphicon glyphicon-plus",
                // 展开图标
                collapseIcon: "glyphicon glyphicon-minus",
                // 选中时
                onNodeChecked: function (event, node) {
                    if (node.nodes.length > 0) {
                        alert(JSON.stringify(node, null, '\t'));
                    }
                },
                // 取消选中时
                onNodeUnchecked: function (event, node) {
                    //alert(JSON.stringify(node));
                }
            });
        };

        // 全部展开
        $('#btn-expand-all').on('click', function (e) {
            $('#tree').treeview('expandAll', {silent: $('#chk-expand-silent').is(':checked')});
        });

        // 全部折叠
        $('#btn-collapse-all').on('click', function (e) {
            $('#tree').treeview('collapseAll', {silent: $('#chk-expand-silent').is(':checked')});
        });

        // 全选
        $('#btn-check-all').on('click', function (e) {
            $('#tree').treeview('checkAll', {silent: $('#chk-check-silent').is(':checked')});
        });

        // 取消全选
        $('#btn-uncheck-all').on('click', function (e) {
            $('#tree').treeview('uncheckAll', {silent: $('#chk-check-silent').is(':checked')});
        });
    })
</script>
</body>
</html>
