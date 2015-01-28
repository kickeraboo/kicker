<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
   uri="http://claudiushauptmann.com/jsp-decorator/"%>
<decorator:decorate filename='template.jsp'>
   <decorator:content placeholder="header">
   </decorator:content>
   <decorator:content placeholder='title'>Create Bucket</decorator:content>
   <decorator:content placeholder='content'>
      <div>
         <div class="modal fade">
            <div class="modal-dialog modal-lg">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">&times;</button>
                     <h4 class="modal-title">Create Bucket</h4>
                  </div>
                  <div class="modal-body">
                     <form class="createBucket" method="POST"
                        action="${pageContext.request.contextPath}/BucketServlet?action=create">
                        <div class="row">
                           <label for="bucketName"
                              class="col-lg-2 control-label">Name</label>
                           <div class="col-lg-6">
                              <input type="text" class="form-control"
                                 name="txtBucketName" id="txtBucketName"
                                 placeholder="Bucket Name">
                           </div>
                        </div>

                        <br />
                        <div class="row top-buffer">
                           <label for="state"
                              class="col-lg-2 control-label">State</label>
                           <div class="col-lg-4">
                              <select class="form-control"
                                 id="selectState" name="selectState">
                                 <option value="-1"></option>
                              </select>
                           </div>
                        </div>
                        <br />
                        <div class="row top-buffer">
                           <label for="city"
                              class="col-lg-2 control-label">City</label>
                           <div class="col-lg-4" id="divCity">
                              <select class="form-control"
                                 id="selectCity" name="selectCity">
                                 <option value="-1">Select</option>
                              </select>
                           </div>
                           <div class="loading"></div>
                        </div>

                        <br /> <br />
                        <div class="row top-buffer">
                           <label for="bucketDescription"
                              class="col-lg-2 control-label">Description</label>
                           <div class="col-lg-6">
                              <span class="help-block">Describe
                                 your bucket in 140 characters or less.</span>
                              <textarea class="form-control" rows="6"
                                 maxlength="140" id="txtDescription" name="txtDescription"></textarea>
                           </div>
                        </div>

                        <div class="modal-footer">
                           <button type="button" class="btn btn-default"
                              data-dismiss="modal">Cancel</button>
                           <button type="submit" class="btn btn-primary">Create
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
							$(function()
							{

								$(".modal").modal("show");
								$("#txtBucketName").focus();

								getStates();
								function getStates()
								{
									$.get("${pageContext.request.contextPath}/StateServlet?action=getall", function(r)
									{
										var json = JSON.parse(r);
										if (json.length > 0)
										{
											for (var i = 0; i < json.length; i++)
											{
												$("#selectState").append("<option value='" + json[i].stateID + "'>" + json[i].name + "</option>");
											}
										}
									});
								}

								$("#selectState").on("change", function()
								{
									var stateId = $(this, "option: selected").val();
									$("#selectCity").find('option:not(:first)').remove();

									if (stateId != -1)
									{
										bindCities(stateId);
									}
									else
									{

									}
								});

								function bindCities(stateId)
								{
									$(".loading").html("<img src='${pageContext.request.contextPath}/images/loading.gif' />");
									$.get("${pageContext.request.contextPath}/CityServlet?action=getcitiesbystateid&stateid=" + stateId, function(r)
									{
										var json = JSON.parse(r);
										if (json.length > 0)
										{
											for (var i = 0; i < json.length; i++)
											{
												$("#selectCity").append("<option value='" + json[i].cityID + "'>" + json[i].name + "</option>");
											}
										}
										$(".loading").html("");
									});
								}
							});
						</script>
   </decorator:content>
</decorator:decorate>