<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<script>
var ctx = "${pageContext.request.contextPath}";
var editURL = ctx + "/admin/productInventory/editProduct/";
</script>

<div class="container-wrapper">
    <div class="container" id="mainDiv">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p1 class="lead">You can view Product here</p1>
        </div>
        <table class="table table-striped table-hover">
            <caption><h2>List of products</h2></caption>
            <thread>
                <tr>
                    <th>Prouct Image</th>
                    <th>productName</th>
                    <th>productCategory</th>
                    <th>productDescription</th>
                    <th>productPrice</th>
                    <th>productCondition</th>
                    <th>productStatus</th>
                    <th>unitInStock</th>
                </tr>
            </thread>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>
                    	<img src="<c:url value="/resources/images/${product.productId}.png"/>" width="100" height="100"/>
                    </td>
                    <td>${product.productName} </td>
                    <td>${product.productCategory} </td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice} Rs.</td>
                    <td>${product.productCondition} </td>
                    <td>${product.productStatus} </td>
                    <td>${product.unitInStock} </td>
                    <td>
                        <a href="<spring:url value="/productList/viewProduct/${product.productId}" />"
                        >
                        <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}" />"
                        >
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a>
                        
                        <span class="glyphicon glyphicon-pencil" data-id="${product.productId}" aria-hidden="true"></span>
                                                
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>
    	<a href=" <c:url value="/admin/productInventory/addProduct"/> " class="btn btn-primary btn-lg active"> Add Product</a>
    </h3>
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
    
</div>    

<script type="text/javascript">
	$(document).ready(function(){
	    $(".glyphicon-pencil").click(this,function(){
	    	alert(ctx);
	    	$.ajax({url: ctx + "/admin/productInventory/editProduct/"+ $(this).data("id"), success: function(result){
	            $("#mainDiv").html(result);
	            $("#product").attr("action", editURL);
	        }});
	    });
	});
</script>
