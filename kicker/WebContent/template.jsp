<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><decorator:placeholder name='title' /></title>
<link href="bootstrap/css/flatly.css" rel="stylesheet" media="screen">
<link href="bootstrap/css/buckets.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<decorator:placeholder name='header' />
</head>
<body>
	<!-- WRAPPER -->
	<div id="main">
		<!-- NAVIGATION BAR -->
		<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<tag:loggedin>
						<li><a href="#">${LoggedUser.getFullname() }</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" title="Settings"><i
								class="glyphicon glyphicon-cog"></i><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Manage Account</a></li>
								<li><a href="#">Privacy Settings</a></li>
								<li><a href="#">About</a></li>
								<li class="divider"></li>
								<li><a href="signout">Logout</a></li>
							</ul></li>
					</tag:loggedin>
					<tag:notloggedin>
						<li><a href="login.jsp">Sign In</a></li>
					</tag:notloggedin>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		<!-- END NAVIGATION BAR -->
		<decorator:placeholder name="content"></decorator:placeholder>
		<!-- END WRAPPER -->
	</div>
	<decorator:placeholder name="bottom"></decorator:placeholder>
</body>
</html>
