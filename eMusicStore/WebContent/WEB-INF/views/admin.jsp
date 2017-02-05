<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Administrater Page</h1>
			<c:if test="${pageContext.request.userPrincipal.name != null }">
			<h2>
				Welcome: ${pageContext.request.userPrincipal.name != null } | <a href="<c:url value="/j_spring_security_logout"/>"> Logout</a>
			</h2>
			
			</c:if>
			<p1 class="lead">Checkout all the awesome products</p1>
		</div>
		<h3>
		<a href="<c:url value="/admin/productInventory" />"> Product Inventory </a>
		</h3>
		
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>
	</div>
	