<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Product</h1>
            <p class="lead">Checkout all the awesome products</p>
        </div>
        <table class="table table-striped table-hover">
            <caption><h2>List of products</h2></caption>
            <thread>
                <tr>
                    <th>Product Image</th>
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
                    	<img src="<c:url value="C:\Users\DRAGON\Downloads\apache-tomcat-8.5.9\apache-tomcat-8.5.9\images\${product.productImage}"/>"/>
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
                    </td>
                </tr>
            </c:forEach>
        </table>
         <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
  </div>
   

