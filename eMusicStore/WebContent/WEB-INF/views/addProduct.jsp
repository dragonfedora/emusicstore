<%@taglib prefix="spring-form"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Product Page</h1>
			<p1 class="lead">Please add produt information here</p1>
		</div>
		<spring-form:form action="#" method="post" commandName="product">
			<div class="form-group">
				<label for="name">Name</label>
				<spring-form:input path="productName" id="name" class="form-control" />
			</div>

		</spring-form:form>
	</div>
</div>	
	<%@include file="/WEB-INF/views/template/footer.jsp"%>