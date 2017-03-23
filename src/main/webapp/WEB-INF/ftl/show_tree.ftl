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
    <!-- layer -->
    <script src="${ctx}/library/lay/layer/layer.js"></script>
    <!-- bootstrap-treeview -->
    <link rel="stylesheet" type="text/css" href="${ctx}/library/bootstrap/plugins/tree/css/bootstrap-treeview.css"/>
    <script src="${ctx}/library/bootstrap/plugins/tree/js/bootstrap-treeview.js"></script>
    <!-- bootstrap-treeview -->
    <link rel="stylesheet" type="text/css" href="${ctx}/library/bootstrap/plugins/table/1.11.1/bootstrap-table.css"/>
    <script src="${ctx}/library/bootstrap/plugins/table/1.11.1/bootstrap-table.js"></script>
    <script src="${ctx}/library/bootstrap/plugins/table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>
    <!-- base -->
    <link rel="stylesheet" type="text/css" href="${ctx}/css/base.css"/>
    <script src="${ctx}/js/base.js"></script>
    <script type="text/javascript">
        var ctx = "${ctx}";

        /**
         * 单击菜单展开和折叠
         * note：修改过源码 691行代码
         */
        function itemOnclick(target) {
            var tree = $('#tree');
            //找到当前节点id
            var nodeid = $(target).attr('data-nodeid');
            //获取当前节点对象
            var node = tree.treeview('getNode', nodeid);

            if (node.state.expanded) {
                //处于展开状态则折叠
                tree.treeview('collapseNode', node.nodeId);
            } else {
                //展开
                tree.treeview('expandNode', node.nodeId);
            }
        }
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
        <table id="tree_table"></table>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        // 异步请求TreeData
        $.ajax({
            url: ctx + '/tree/init',
            type: 'post',
            beforeSend: beforeSend, //发送请求
            success: function (res) {
                $("#tree").html('');
                initTree(res);
            }
        });

        // 发送请求之前
        function beforeSend() {
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
                showIcon: true,
                showTags: true,
                // 文字颜色
                color: "#4289ca",
                // 背景颜色
                backColor: '#eee',
                // 悬浮颜色
                onhoverColor: "#e2e2e2",
                // 选中背景颜色
                selectedBackColor: "#8d9ccc",
                // 启用Link
                enableLinks: false,
                // 是否显示边框
                showBorder: true,
                // 是否显示复选框
                showCheckbox: true,
                // 是否高亮选中
                highlightSelected: true,
                // 节点上的图标
                nodeIcon: 'glyphicon glyphicon-globe',
                // 选中时的图标
                selectedIcon: "glyphicon glyphicon-stop",
                // 折叠图标
                expandIcon: "glyphicon glyphicon-plus",
                // 展开图标
                collapseIcon: "glyphicon glyphicon-minus",
                // 取消选中时
                onNodeSelected: function (event, node) {
                    //alert(JSON.stringify(node, null, 4));
                    tableInit(node.nodeId);
                },
                // 取消选中时
                onNodeUnselected: function (event, node) {
                    //alert(JSON.stringify(node, null, 4));
                },
                // 复选框选中时
                onNodeChecked: function (event, node) {
                    // 获取所有子节点
                    var selectNodes = getNodeIdArr(node);
                    // 子节点不为空，则选中所有子节点
                    if (selectNodes) {
                        $('#tree').treeview('checkNode', [selectNodes, {silent: true}]);
                    }
                },
                // 复选框取消选中时
                onNodeUnchecked: function (event, node) {
                    // 获取所有子节点
                    var selectNodes = getNodeIdArr(node);
                    // 子节点不为空，则取消选中所有子节点
                    if (selectNodes) {
                        $('#tree').treeview('uncheckNode', [selectNodes, {silent: true}]);
                    }
                },
                error: function () {
                    $("#tree").append('<div>Tree加载失败!<div>');
                    //layer.msg("Tree加载失败!", {icon: 2, time: 2000});
                }
            });
        };

        /**
         * 递归获取所有的节点id
         *
         * 引用Link：http://www.augsky.com/992.html
         * @param node
         * @returns {Array}
         */
        function getNodeIdArr(node) {
            var ts = [];
            if (node.nodes) {
                for (x in node.nodes) {
                    ts.push(node.nodes[x].nodeId)
                    if (node.nodes[x].nodes) {
                        var getNodeDieDai = getNodeIdArr(node.nodes[x]);
                        for (j in getNodeDieDai) {
                            ts.push(getNodeDieDai[j]);
                        }
                    }
                }
            } else {
                ts.push(node.nodeId);
            }
            return ts;
        }


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
<script src="${ctx}/js/bt-table.js"></script>
</body>
</html>
