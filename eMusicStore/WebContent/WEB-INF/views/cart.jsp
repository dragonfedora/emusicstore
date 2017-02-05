<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-wrapper">
	<div class="container">
		<section >
		<div class="jumbotron">
			<div class="container">
					<p> Cart </p>
					<p> All the selected product in your cart </p>
			</div>
		</div>			
		</section>
		
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCart('${cartId}')">
			<div >
					
			<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
			</div>
			<table class="table table-hover">
				<tr>
					<td>Product</td>
					<td>Unit Price</td>
					<td>Quantity</td>
					<td>Price</td>
					<td>Action</td>
				
				</tr>
				<tr ng-repeat= "item in cart.cartItems">
					<td>{{item.product.productName}}</td>
					<td>{{item.product.productPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.quantity}}</td>
					<td><a href="#" class="label label-danger" ng-click="removeToCart(item.product.productId)"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
					
				</tr>
				<tr>
					<td>Product</td>
					<td>Unit Price</td>
					<td>Grand Total</td>
					<td>{{cart.grantTotal}}</td>
					<td></td>
				
				</tr>
			
			</table>
			<a href="<spring:url value="/productList" />"  class="btn, btn-default">Continue Shipping</a>
			</div>
		</section>
	</div>
</div>

<script src="<c:url value='/resources/js/controller.js'/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>