<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>

<%@ include file="include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">

    <!-- Main Header -->
    <%@ include file="include/main_header.jsp"%>

    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                메인페이지
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <p>메인페이지입니다....</p>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="include/main_footer.jsp"%>

    <!-- Control Sidebar -->
    <%@ include file="include/control_sidebar.jsp"%>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<%@ include file="include/plugin_js.jsp"%>

</body>
</html>