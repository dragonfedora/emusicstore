<%@taglib prefix="spring-form"
	uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<div class="page-header">
			<h1>Add Product Page</h1>
			<p class="lead">Please add product information here</p>
		</div>
		<spring-form:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" commandName="product" enctype="multipart/form-data">
			<spring-form:hidden path="productId" value="${product.productId}"/>
			<div class="form-group">
				<label for="name">Name</label>
				<spring-form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
			</div>

			<div class="form-group">
				<label for="category">Product Category</label> <label
					class="checkbox-inline"> <spring-form:radiobutton
						path="productCategory" id="category" value="Instrument"
						class="form-control" /> Instrument
				</label> <label class="checkbox-inline"> <spring-form:radiobutton
						path="productCategory" id="category" value="Accessory"
						class="form-control" /> Accessory
				</label> <label class="checkbox-inline"> <spring-form:radiobutton
						path="productCategory" id="category" value="Record"
						class="form-control" /> Record
				</label>
			</div>

			<div class="form-group">
				<label for="description">Product Description</label>
				<spring-form:input path="productDescription" id="description"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="price">Product Price</label>
				<spring-form:input path="productPrice" id="price"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for=condition>Product Condition</label> <label
					class="checkbox-inline"> <spring-form:radiobutton
						path="productCondition" id="condition" value="new"
						class="form-control" /> New
				</label> <label class="checkbox-inline"> <spring-form:radiobutton
						path="productCondition" id="category" value="use"
						class="form-control" /> Used
				</label>
			</div>

			<div class="form-group">
				<label for="status">Product Status</label> <label
					class="checkbox-inline"> <spring-form:radiobutton
						path="productStatus" id="status" value="active"
						class="form-control" /> Active
				</label> <label class="checkbox-inline"> <spring-form:radiobutton
						path="productStatus" id="status" value="inactive"
						class="form-control" /> Inactive
				</label>
			</div>

			<div class="form-group">
				<label for="unit">UnitInStock</label>
				<spring-form:input path="unitInStock" id="unit" class="form-control" />
			</div>

			<div class="form-group">
				<label for="image">Upload Image</label>
				<spring-form:input type="file" path="productImage" id="image"
					class="form-control" />
			</div>

			<div class="form-group">
				<input type="submit" value="submit"
					class="btn btn-primary btn-lg active">
			</div>



		</spring-form:form>
<script type="text/javascript">
	$(".form-group").css("width","40%");
</script>
