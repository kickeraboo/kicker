<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>

<div class="container col-sm-6">

	<br />
	<ul class="list-group" id="itemList" name="itemList">
		<a href="#" class="list-group-item  col-sm-12 active"
			style="text-align: center"><b>Bucket Name</b></a>
	</ul>


</div>

<script>
	function getItems(bucketId) {
		$("#itemList").children().not("a").remove();
		
		$.get(
				"${pageContext.request.contextPath}/ItemServlet?action=getitems&bucketID="
						+ bucketId,

				function(r) {
					
					var json = JSON.parse(r);
					if (json.length > 0) {

						for (var i = 0; i < json.length; i++) {
							$("#itemList").append(
									"<li class='list-group-item'><b>"
											+ json[i].itemName + ": </b>"
											+ json[i].description + "</li>");
						}
					}
				});
	}
</script>