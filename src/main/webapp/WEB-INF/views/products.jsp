<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3">
				<div class="thumbnail">
					<img src="<c:url value="/img/${product.productId}.png"></c:url>"
						alt="image" style="width: 200px;height:200px;" />
					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>$${product.price}</p>
						<p>Available ${product.seatAvailable} seats available in class</p>
						<p>
							<a
								href=" <spring:url value="/market/product?id=${product.productId}" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
