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
            <button type="button" class="navbar-toggle"
               data-toggle="collapse"
               data-target="#bs-example-navbar-collapse-1">
               <span class="sr-only">Toggle navigation</span> <span
                  class="icon-bar"></span> <span class="icon-bar"></span>
               <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Home</a>
         </div>

         <!-- Collect the nav links, forms, and other content for toggling -->
         <div class="collapse navbar-collapse"
            id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
               <li class="active"><a href="#">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
               <tag:loggedin>
                  <li><a href="#"><i
                        class="glyphicon glyphicon-user"></i>${LoggedUser.getFullname() }</a></li>
                  <li class="dropdown"><a href="#"
                     class="dropdown-toggle" data-toggle="dropdown"
                     title="Settings"><i
                        class="glyphicon glyphicon-cog"></i><b
                        class="caret"></b></a>
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
         <div class="container">
            <div class="col-md-12">
               <div class="row">
                  <!-- SIDE MENU BAR BEGIN -->
                  <div class="col-md-2">
                     <div id="wrapper">
                        <div id="sidebar-wrapper">
                           <ul class="sidebar-nav" id="bucketList">
                              <li class="sidebar-brand"><a href="#">My
                                    Buckets</a></li>
                           </ul>
                        </div>
                     </div>
                     <a id="menu-toggle" href="#"
                        class="btn btn-primary"><i
                        class="icon-reorder">></i></a>
                  </div>
                  <!-- SIDE MENU BAR END -->
                  <div class="col-md-10">
                     <decorator:placeholder name="content"></decorator:placeholder>
                  </div>
               </div>
            </div>
         </div>
      </tag:loggedin>
      <tag:notloggedin>
         <!-- REGISTRATION/LOGIN FORMS BEGIN -->
         <tag:login></tag:login>
      </tag:notloggedin>
      <!-- END WRAPPER -->
   </div>
   <decorator:placeholder name="bottom"></decorator:placeholder>
   <tag:notloggedin>
      <script>
							$(function()
							{
								$("#btnSignUp").on("click", function()
								{
									$('#loginbox').hide();
									$('#signupbox').show();
								});

								$("#btnSignIn").on("click", function()
								{
									$('#signupbox').hide();
									$('#loginbox').show()
								});
							});
						</script>
   </tag:notloggedin>
   <tag:loggedin>
      <script>
							//this will run only when the user is logged in
							$(function()
							{
								getBuckets(); //calls the method

								//gets a list of buckets for the logged in user
								function getBuckets()
								{
									$.get("${pageContext.request.contextPath}/BucketServlet", function(r)
									{
										var json = JSON.parse(r);
										if (json.length > 0)
										{
											for (var i = 0; i < json.length; i++)
											{
												$("#bucketList").append("<li><a href='#'>" + json[i].bucketName + "</a></li>");
											}
										}
									});
								}
							});

							$("#menu-toggle").click(function(e)
							{
								e.preventDefault();
								$("#wrapper").toggleClass("active");
							});
						</script>
   </tag:loggedin>
   <tag:futureuser>
      <script>
							$(function()
							{
								//this gets called if the user is registering
								$('#loginbox').hide();
                                $('#signupbox').show();
							});
						</script>
   </tag:futureuser>
</body>
</html>
