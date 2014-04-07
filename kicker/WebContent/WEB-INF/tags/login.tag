<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

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
                        id="login-username" type="text"
                        class="form-control" name="username" value=""
                        placeholder="username or email">
                  </div>

                  <div style="margin-bottom: 25px" class="input-group">
                     <span class="input-group-addon"><i
                        class="glyphicon glyphicon-lock"></i></span> <input
                        id="login-password" type="password"
                        class="form-control" name="password"
                        placeholder="password">
                  </div>



                  <div class="input-group">
                     <div class="checkbox">
                        <label> <input id="login-remember"
                           type="checkbox" name="remember" value="1">
                           Remember me
                        </label>
                     </div>
                  </div>


                  <div style="margin-top: 10px" class="form-group">
                     <!-- Button -->

                     <div class="col-sm-12 controls">
                        <a id="btn-login" href="#"
                           class="btn btn-success"
                           onclick="alert('Coming soon... Please Login or Register using Facebook.'); return false;">Login
                        </a> <a id="btn-fblogin" href="signin?action=signin"
                           class="btn btn-primary">Login with
                           Facebook</a>
                     </div>
                  </div>
                  <div class="form-group">
                     <div class="col-md-12 control">
                        <div
                           style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
                           Don't have an account? <a href="#"
                              id="btnSignUp"> Sign Up Here! </a>
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
                  <a id="btnSignIn" href="#">Sign In</a>
               </div>
            </div>
            <div class="panel-body">
               <form id="signupform" class="form-horizontal" role="form"
                  method="post" action="">
                  <tag:futureuser>
                     <div id="signupalert" style="display: none"
                        class="alert alert-danger">
                        <p>Error:</p>
                        <span></span>
                     </div>
                     <div class="form-group">
                        <label for="email"
                           class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                           <input type="text" class="form-control"
                              name="email"
                              value="${FutureUser.getUsername() }"
                              placeholder="Username">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="email"
                           class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                           <input type="text" class="form-control"
                              name="txtFullName" placeholder="Full Name"
                              value="${FutureUser.getEmail() }">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="firstname"
                           class="col-md-3 control-label">Full
                           Name</label>
                        <div class="col-md-9">
                           <input type="text" class="form-control"
                              name="txtFullName" placeholder="Full Name"
                              value="${FutureUser.getFullname() }">
                        </div>
                     </div>
                     <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                           <input id="btn-signup" type="submit"
                              class="btn btn-info" value="&nbsp Sign Up" />
                           <span style="margin-left: 8px;">or</span>
                        </div>
                     </div>

                  </tag:futureuser>
                  <div
                     style="border-top: 1px solid #999; padding-top: 20px"
                     class="form-group">
                     <div class="col-md-offset-3 col-md-9">
                        <a id="btn-fbsignup" href="signin?action=signup"
                           class="btn btn-primary"> <i
                           class="icon-facebook"></i>Sign Up using
                           Facebook
                        </a>
                     </div>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>