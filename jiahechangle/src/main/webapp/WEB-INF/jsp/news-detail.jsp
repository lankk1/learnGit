<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="${sessionScope.lang}">
<head>
  <title>新闻中心</title>
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/public.css">
  <link rel="stylesheet" href="/static/styles/news.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>
<div class="container">
  <div class="left-d">
    <h2 class="titH2"><spring:message key="news_center"/><span class="size-s" style="<spring:message key="english_show" />">News center</span></h2>
    <div class="body-l">
      <c:choose>
        <c:when test="${pageContext.response.locale=='zh'}">
          ${newsDetail.newsContent}
        </c:when>
        <c:otherwise>
          ${newsDetail.newsContentEn}
        </c:otherwise>
      </c:choose>
    </div>
  </div>
  <div class="rightDiv">
    <div class="titH3">
      <h3><spring:message key="news_center"/><span class="size-s" style="<spring:message key="english_show" />">News center</span></h3>
    </div>
    <li>
      <a><spring:message key="company_news"/> <span style="<spring:message key="english_show" />">Company news</span></a>
    </li>
    <li>
      <a><spring:message key="Industry_news"/> <span style="<spring:message key="english_show" />">Industry news</span></a>
    </li>
    </ul>
  </div>

</div>
<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>
</body>
</html>
