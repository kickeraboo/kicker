<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<div>
	<div class="modal fade" id="itemModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Create New Item</h4>
				</div>
				<div class="modal-body">
					<form class="createItem" method="POST"
						action="${pageContext.request.contextPath}/ItemServlet?action=create">
						<div class="row">
							<label for="itemName" class="col-lg-2 control-label">Name</label>
							<div class="col-lg-6">
								<input type="text" class="form-control" name="txtItemName"
									id="txtItemName" placeholder="Item Name">
							</div>
						</div>

						<br />

						<div class="row top-buffer">
							<label for="itemDescription" class="col-lg-2 control-label">Description</label>
							<div class="col-lg-6">
								<span class="help-block">Describe your item in 140
									characters or less.</span>
								<textarea class="form-control" rows="6" maxlength="140"
									id="txtDescription" name="txtDescription"></textarea>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-primary">Create
								Item</button>
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

<script>
	function showCreateItem() {
		$("#itemModal").modal("show");
		$("#txtItemName").focus();
	}
</script>

<decorator:content placeholder="bottom">

</decorator:content>
