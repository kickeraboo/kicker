<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://claudiushauptmann.com/jsp-decorator/"%>
<decorator:decorate filename='template.jsp'>
	<decorator:content placeholder='title'>Welcome</decorator:content>
	<decorator:content placeholder='content'>
		Hello world!
	</decorator:content>
</decorator:decorate>