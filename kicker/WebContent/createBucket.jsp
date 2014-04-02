<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<decorator:decorate filename='template.jsp'>
	<decorator:content placeholder="header">
		<!--  		<link
			href="${pageContext.request.contextPath}/bootstrap/css/cupertino/jquery-ui-1.10.4.custom.min.css"
			rel="stylesheet">-->


		<style>
</style>
	</decorator:content>
	<decorator:content placeholder='title'>Create Bucket</decorator:content>
	<decorator:content placeholder='content'>
		<div>
			<div class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Create Bucket</h4>
						</div>
						<div class="modal-body">
							<form class="createBucket" method="POST"
								action="${pageContext.request.contextPath}/BucketServlet?action=create">
								<div class="row">
									<label for="bucketName" class="col-lg-2 control-label">Name</label>
									<div class="col-lg-6">
										<input type="text" class="form-control" name="name"
											placeholder="Bucket Name">
									</div>
								</div>

								<br />
								<div class="row top-buffer">
									<label for="state" class="col-lg-2 control-label">State</label>
									<div class="col-lg-2">
										<select class="form-control" id="selectState">
											<option value="-1">Choose One</option>
										</select>
									</div>
								</div>
								<br />
								<div class="row top-buffer">
									<label for="city" class="col-lg-2 control-label">City</label>
									<div class="col-lg-2 ui-front" id="divCity">
										<input name="city" class="form-control" type="text"
											placeholder="City in this State." id="txtCity">
									</div>
								</div>

								<br /> <br />
								<div class="row top-buffer">
									<label for="bucketDescription" class="col-lg-2 control-label">Description</label>
									<div class="col-lg-6">
										<span class="help-block">Describe your bucket in 140
											characters or less.</span>
										<textarea class="form-control" rows="6" maxlength="140"
											id="bucketDescription"></textarea>
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<button type="button" class="btn btn-primary">Create
										Bucket</button>
								</div>
							</form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
	</decorator:content>

	<decorator:content placeholder="bottom">
		<script>
			$(function() {
				$("#txtCity").autocomplete({
					appendTo : "#divCity"
				});

				$(".modal").modal("show");
				getStates();
				function getStates() {
					$
							.get(
									"${pageContext.request.contextPath}/StateServlet?action=getall",
									function(r) {
										var json = JSON.parse(r);
										if (json.length > 0) {
											for (var i = 0; i < json.length; i++) {
												$("#selectState").append(
														"<option value='" + json[i].stateID + "'>"
																+ json[i].name
																+ "</option>");
											}
										}
									});
				}

				$("#selectState").on("change", function() {
					var stateId = $(this, "option: selected").val();
					if (stateId != -1) {
						bindCities(stateId);

					} else {

					}
				});
				function bindCities(stateId) {
					//${pageContext.request.contextPath}/CityServlet?action=getcitiesbystateid&stateid="
					+ stateId,
				}
			});
		</script>
	</decorator:content>
</decorator:decorate>