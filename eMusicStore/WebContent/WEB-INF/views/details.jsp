<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
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

        </div>

    </div>

</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
