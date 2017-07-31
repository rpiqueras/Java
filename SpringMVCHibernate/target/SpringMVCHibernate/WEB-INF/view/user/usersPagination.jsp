<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="jumbotron">
				<h1>Choose pagination</h1>
			</div>
			
			<sf:form method="post" modelAttribute="paginationCriteria" action="/SpringMVCHibernate/users/paginated">
				<div class="form-group">
					<label for="number">Number of records</label>
					<sf:input path="number" class="form-control" placeholder="Number"/>
				</div>
				<div class="checkbox">
			    	<label><sf:checkbox path="isAscending"/>Asc/Desc</label>
			  	</div>
				<sf:button class="btn btn-primary pull-right">Search</sf:button>
			</sf:form>
	</tiles:putAttribute>
</tiles:insertDefinition>