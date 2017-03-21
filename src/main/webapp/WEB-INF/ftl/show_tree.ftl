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
<div id="tree"></div>
<script type="text/javascript">
    $(function () {
        function getTree() {
            // var data = '';
//            $.ajax({
//                url: ctx + '/tree/init',
//                type: 'post',
//                success: function (res) {
//                    data = res;
//                }
//            });
            var data = [{
                text: "p1",
                nodes: [
                    {text: "p1-1", id: '00001', nodeId: '00001'},
                    {text: "p1-2", id: '00002'},
                    {text: "p1-3", id: '00003'},
                    {
                        text: "p1-4", id: '00004',
                        nodes: [
                            {text: 'p1-4-1', id: '00005'},
                            {text: 'p1-4-2', id: '00005'}
                            ]
                    }]
            }]


            return data;
        }

        $('#tree').treeview({
            data: getTree()
        });
    })
</script>
</body>
</html>
