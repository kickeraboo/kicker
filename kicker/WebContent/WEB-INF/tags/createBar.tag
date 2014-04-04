<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>

<div class="navbar default pull-right">

	<button type="button" id="createBucket" class="btn btn-success">
		<span class="glyphicon glyphicon-plus"></span>Bucket
	</button>
	<button type="button" id="createItem" class="btn btn-success">
		<span class="glyphicon glyphicon-plus"></span>Item
	</button>

</div>
<script>
	$(function() {
		$("#createBucket").on("click", function() {
			showCreateBucket();

		});

		$("#createItem").on("click", function() {
			showCreateItem();

		});
	});
</script>