<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Administrater Page</h1>
			<p1 class="lead">Checkout all the awesome products</p1>
		</div>
		<h3>
		<a href="<c:url value="/admin/productInventory" />"> Product Inventory </a>
		</h3>
		
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</div>
	