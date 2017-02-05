<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="#" alt="image" style="width:100%;height:300px"/>
        </div>
        <div class="col-md-5">
            <h2>Product Information</h2>
            <p>Prouct Image</p>
            <p>ProductName:${product.productName}</p>
            <p>productCategory</p>
            <p>productDescription</p>
            <p>productPrice</p>
            <p>productCondition</p>
            <p>productStatus</p>
            <p>unitInStock</p>
		<c:set var="role" scope="page" value="${param.role}"></c:set>
		<c:set var="url" scope="page" value="/productList"></c:set>
		<c:if test="${role='admin'}">
			<c:set var="url" scope="page" value="/admin/productInventory"></c:set>
		</c:if>
		
		<p ng-controller="cartCtrl">
			<a href='<c:url value="${url}"/>' class="btn btn-default">Back</a>
			<a href='#' class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-remove"></span>Order Now</a>
			<a href='<c:url value="/cart"/>' class="btn btn-warning btn-large"><span class="glyphicon glyphicon-remove"></span>View Cart</a>
		</p>
        </div>

    </div>

</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
<script src="<c:url value='/resources/js/controller.js'/>"></script>

