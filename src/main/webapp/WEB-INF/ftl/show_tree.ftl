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
    <button id="btn-expand-all" class="btn btn-info">全部展开</button>
    <button id="btn-collapse-all" class="btn btn-success">全部折叠</button>

    <div class="col-lg-2">
        <div id="tree"></div>
    </div>
    <div class="col-lg-10">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        // 异步请求TreeData
        $.ajax({
            url: ctx + '/tree/init',
            type: 'post',
            success: function (res) {
                initTree(res);
            }
        });

        /**
         * 初始化Tree
         * @param tree
         */
        function initTree(tree) {
            $('#tree').treeview({
                data: tree,
                showIcon: true,
                showTags: true,
                color: "#428bca",
                expandIcon: 'glyphicon glyphicon-chevron-right',
                collapseIcon: 'glyphicon glyphicon-chevron-down',
                nodeIcon: 'glyphicon glyphicon-bookmark',
                levels: 1
            });
        };

        //
        $('#btn-expand-all').on('click', function (e) {
            $('#tree').treeview('expandAll', {silent: $('#chk-expand-silent').is(':checked')});
        });

        $('#btn-collapse-all').on('click', function (e) {
            $('#tree').treeview('collapseAll', {silent: $('#chk-expand-silent').is(':checked')});
        });
    })
</script>
</body>
</html>
