<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/31/2017
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="currentLocale" value="${pageContext.response.locale}" scope="session"/>

<nav aria-label="navigation">
  <ul class="pagination">
    <c:if test="${sessionScope.pageNum >= 2}">
      <li>
        <a href="${sessionScope.pageNum - 1}?lang=${currentLocale}" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
    </c:if>

    <c:forEach var="pageNum" begin="1" end="${res.total/sessionScope.pageSize + 1}">
      <li><a href="${pageNum}?lang=${currentLocale}">${pageNum}</a></li>
    </c:forEach>

    <c:if test="${sessionScope.pageNum <= res.total/sessionScope.pageSize}">
      <li>
        <a href="${sessionScope.pageNum + 1}?lang=${currentLocale}" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </c:if>
  </ul>
</nav>
