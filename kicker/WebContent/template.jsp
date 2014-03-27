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
						<li><a href="#"><i
								class="glyphicon glyphicon-user
						"></i>
								${LoggedUser.getFullname() }</a></li>
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
		<tag:loggedin>
			<decorator:placeholder name="content"></decorator:placeholder>
		</tag:loggedin>
		<tag:notloggedin>
			<!-- REGISTRATION/LOGIN FORMS BEGIN -->
			<div id="login">
				<div class="container">
					<div id="loginbox" style="margin-top: 50px;"
						class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="panel-title">Sign In</div>
								<div
									style="float: right; font-size: 80%; position: relative; top: -10px">
									<a href="#">Forgot password?</a>
								</div>
							</div>

							<div style="padding-top: 30px" class="panel-body">

								<div style="display: none" id="login-alert"
									class="alert alert-danger col-sm-12"></div>

								<form id="loginform" class="form-horizontal" role="form">

									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <input
											id="login-username" type="text" class="form-control"
											name="username" value="" placeholder="username or email">
									</div>

									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-lock"></i></span> <input
											id="login-password" type="password" class="form-control"
											name="password" placeholder="password">
									</div>



									<div class="input-group">
										<div class="checkbox">
											<label> <input id="login-remember" type="checkbox"
												name="remember" value="1"> Remember me
											</label>
										</div>
									</div>


									<div style="margin-top: 10px" class="form-group">
										<!-- Button -->

										<div class="col-sm-12 controls">
											<a id="btn-login" href="#" class="btn btn-success">Login
											</a> <a id="btn-fblogin" href="signin" class="btn btn-primary">Login
												with Facebook</a>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12 control">
											<div
												style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
												Don't have an account? <a href="#"
													onClick="$('#loginbox').hide(); $('#signupbox').show()">
													Sign Up Here! </a>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div id="signupbox" style="display: none; margin-top: 50px"
						class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="panel-title">Sign Up</div>
								<div
									style="float: right; font-size: 85%; position: relative; top: -10px">
									<a id="signinlink" href="#"
										onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign
										In</a>
								</div>
							</div>
							<div class="panel-body">
								<form id="signupform" class="form-horizontal" role="form">
									<div id="signupalert" style="display: none"
										class="alert alert-danger">
										<p>Error:</p>
										<span></span>
									</div>
									<div class="form-group">
										<label for="email" class="col-md-3 control-label">Email</label>
										<div class="col-md-9">
											<input type="text" class="form-control" name="email"
												placeholder="Email Address">
										</div>
									</div>

									<div class="form-group">
										<label for="firstname" class="col-md-3 control-label">First
											Name</label>
										<div class="col-md-9">
											<input type="text" class="form-control" name="firstname"
												placeholder="First Name">
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-md-3 control-label">Last
											Name</label>
										<div class="col-md-9">
											<input type="text" class="form-control" name="lastname"
												placeholder="Last Name">
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-3 control-label">Password</label>
										<div class="col-md-9">
											<input type="password" class="form-control" name="passwd"
												placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<!-- Button -->
										<div class="col-md-offset-3 col-md-9">
											<button id="btn-signup" type="button" class="btn btn-info">
												<i class="icon-hand-right"></i> &nbsp Sign Up
											</button>
											<span style="margin-left: 8px;">or</span>
										</div>
									</div>

									<div style="border-top: 1px solid #999; padding-top: 20px"
										class="form-group">
										<div class="col-md-offset-3 col-md-9">
											<button id="btn-fbsignup" type="button"
												class="btn btn-primary">
												<i class="icon-facebook"></i>   Sign Up with Facebook
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</tag:notloggedin>
		<!-- END WRAPPER -->
	</div>
	<decorator:placeholder name="bottom"></decorator:placeholder>
</body>
</html>
