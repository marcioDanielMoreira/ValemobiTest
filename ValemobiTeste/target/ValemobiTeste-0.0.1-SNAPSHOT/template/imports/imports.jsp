<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	/* Setando na sessão o caminho do WebContent */
	request.getSession().setAttribute( "rootWeb", request.getContextPath() );
%>

<!-- Bootstrap Core CSS -->
<link href="${rootWeb}/assets/sbadmin2/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${rootWeb}/assets/sbadmin2/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${rootWeb}/assets/sbadmin2/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${rootWeb}/assets/sbadmin2/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">




<!-- jQuery -->
<script src="${rootWeb}/assets/sbadmin2/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${rootWeb}/assets/sbadmin2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${rootWeb}/assets/sbadmin2/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${rootWeb}/assets/sbadmin2/dist/js/sb-admin-2.js"></script>

<!-- MASCARAS -->
<script src="${rootWeb}/assets/jQuery-Mask-Plugin-master/dist/jquery.mask.min.js"></script>