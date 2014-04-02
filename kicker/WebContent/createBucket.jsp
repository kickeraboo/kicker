<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<decorator:decorate filename='template.jsp'>
	<decorator:content placeholder='title'>Create Bucket</decorator:content>
	<decorator:content placeholder='content'>

		<!-- SIDE MENU BAR BEGIN -->
		<div class="span2">
			<div id="wrapper">
				<div id="sidebar-wrapper">
					<ul class="sidebar-nav" id="bucketList">
						<li class="sidebar-brand"><a href="#">My Buckets</a></li>
					</ul>
				</div>
			</div>
			<a id="menu-toggle" href="#" class="btn btn-primary"><i
				class="icon-reorder">></i></a>


		</div>

		<p>This is a paragraph</p>

		<div class="content">
			<button class="btn btn-primary" data-toggle="modal"
				data-target=".bs-example-modal-lg">Large modal</button>

			<!-- Modal -->
			<div class="modal fade bs-example-modal-lg" tabindex="-1"
				role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">

						<!-- Panel -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">New Bucket</h3>
							</div>

							<!-- Create Bucket Form -->
							<div class="panel-body">
								<form class="createBucket" method="POST" action="${pageContext.request.contextPath}/BucketServlet?action=create">
									<div class="row">
										<label for="bucketName" class="col-lg-2 control-label">Name</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" name="name"
												placeholder="Bucket Name">
										</div>
									</div>

									<br />

									<div class="row top-buffer">
										<label for="city" class="col-lg-2 control-label">City</label>
										<div class="col-lg-2">
											<select class="form-control" name="city">
												<option value="1">Boise</option>
												<option value="2">Idaho Falls</option>
												<option value="3">Meridian</option>
												<option value="4">Pocatello</option>
												<option value="5">Rexburg</option>
												<option value="6">Twin Falls</option>
											</select>
										</div>
									</div>

									<br />

									<div class="row top-buffer">
										<label for="state" class="col-lg-2 control-label">State</label>
										<div class="col-lg-2">
											<select class="form-control" id="state">
												<option>ID</option>
											</select>
										</div>
									</div>

									<br />
									<div class="row top-buffer">
										<label for="bucketDescription" class="col-lg-2 control-label">Description</label>
										<div class="col-lg-6">
											<span class="help-block">Describe your bucket in 140
												characters or less.</span>
											<textarea class="form-control" rows="6" maxlength="140"
												id="bucketDescription"></textarea>
										</div>
									</div>

									<br />

									<div class="row top-buffer">
										<div class="col-lg-6 col-lg-offset-2">
											<button class="btn btn-default">Cancel</button>
											<button type="submit" class="btn btn-primary">Create
												Bucket</button>
										</div>
									</div>
								</form>
							</div>
							<!-- /Create Bucket Form -->
						</div>
						<!-- /Panel -->
					</div>
				</div>
			</div>
			<!-- /Modal -->
		</div>
		<!-- SIDE MENU BAR END -->
	</decorator:content>

	<decorator:content placeholder="bottom">
		<script>
			$(function() {
				getBuckets(); //calls the method

				//gets a list of buckets for the logged in user
				function getBuckets() {
					$.get("${pageContext.request.contextPath}/BucketServlet",
							function(r) {
								var json = JSON.parse(r);
								if (json.length > 0) {
									for (var i = 0; i < json.length; i++) {
										$("#bucketList").append(
												"<li><a href='#'>"
														+ json[i].bucketName
														+ "</a></li>");
									}
								}
							});
				}
			});

			$("#menu-toggle").click(function(e) {
				e.preventDefault();
				$("#wrapper").toggleClass("active");
			});
		</script>
	</decorator:content>
</decorator:decorate>