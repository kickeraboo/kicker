<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
   <%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
   
<decorator:decorate filename='template.jsp'>
	<decorator:content placeholder='title'>Welcome</decorator:content>
	<decorator:content placeholder='content'>
		<tag:createBar></tag:createBar>
		Hello world!
		<tag:createBucket></tag:createBucket>
		<tag:createItem></tag:createItem>
	</decorator:content>
</decorator:decorate>