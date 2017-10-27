<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="${pageContext.response.locale}">
<head>
  <title><spring:message key="product"/></title>
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/public.css">
  <link rel="stylesheet" href="/static/styles/product.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>

<%-- 产品展示列表 --%>

<div class="container">
  <div class="left-d">
    <h2 class="titH2"><spring:message key="product_show"/><span class="size-s"
                                                                style="<spring:message key="english_show" />">Product Show</span>
    </h2>
    <div class="body-l">
      <ul>
        <c:choose>
          <c:when test="${pageContext.response.locale == 'zh'}">
            <c:forEach var="product" items="${res.products}">
              <li class="product-li" data-goods="${product.productId}">
                <div class="img" style="background-image: url('${product.productImg}')">
                </div>
                <div class="imgTit">
                    ${product.productName}
                </div>
              </li>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <c:forEach var="product" items="${res.products}">
              <li class="product-li" data-goods="${product.productId}">
                <div class="img" style="background-image: url('${product.productImg}')">
                </div>
                <div class="imgTit">
                    ${product.productNameEn}
                </div>
              </li>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
    <div class="pageD">
      <jsp:include page="components/pagenation.jsp"/>
    </div>
  </div>

  <%-- 产品展示详情 --%>
  <div class="rightDiv">
    <div class="titH3">
      <h3><spring:message key="product_show"/><span class="size-s" style="<spring:message key="english_show" />">Product Show</span>
      </h3>
    </div>
    <c:choose>
      <c:when test="${pageContext.response.locale == 'zh'}">
        <c:forEach var="product" items="${res.products}">
          <div class="product-detail" data-goods="${product.productId}">
              ${product.productDescription}
          </div>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <c:forEach var="product" items="${res.products}">
          <div class="product-detail" data-goods="${product.productId}">
              ${product.productDescriptionEn}
          </div>
        </c:forEach>
      </c:otherwise>
    </c:choose>
  </div>

</div>
<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>

<script src="/static/lib/jQuery-2.2.0.min.js"></script>

<script>
  $(function () {

    $('.product-detail').eq(0).show()

    $('.product-li').click(function () {
      var goods = $(this).attr('data-goods');
      $('.product-detail').each(function () {
        if ($(this).attr('data-goods') === goods) {
          $(this).show(100);
        } else {
          $(this).hide();
        }
      })
    })
  })
</script>
</body>
</html>
