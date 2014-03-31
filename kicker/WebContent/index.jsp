<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<decorator:decorate filename='template.jsp'>
	<decorator:content placeholder='title'>Welcome</decorator:content>
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
			<!-- SIDE MENU BAR END -->
		</div>
	</decorator:content>

	<decorator:content placeholder="bottom">
		<script>
			$(function() {
				getBuckets(); //calls the method

				//gets a list of buckets for the logged in user
				function getBuckets() {
					$.get("${pageContext.request.contextPath}/BucketServlet", function(r) {
						var json = JSON.parse(r);
						if (json.length > 0) {
							for (var i = 0; i < json.length; i++) {
								$("#bucketList").append(
										"<li><a href='#'>" + json[i].bucketName
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