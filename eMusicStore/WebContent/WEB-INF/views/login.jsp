<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div id="loginBox">
			<h2> Login Form</h2>
			<c:if test="${not empty logout} }">
				<div class="msg">${msg}</div> 
			</c:if>
			<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
				<c:if test="${not empty error} }">
					<div class="error">${error}</div> 
				</c:if>
				<div class="form-group">
					<label for="username"> User:</label>
					<input type="text" id="username" name="username" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="password"> Password:</label>
					<input type="text" id="password" name="password" class="form-control"/>
				</div>
				<input type="Submit" value="Submit" class="btn btn-default"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
			</form>
		</div>
	</div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>