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
<c:set var="currentLocale" value="${pageContext.response.locale}" scope="session"/>

<html lang="${sessionScope.lang}">
<head>
  <title><spring:message key="news_center"/></title>
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
      <ul>
        <c:forEach var="item" items="${res.news}">
          <li class="news-li">
            <a href="/changle/news/detail/${item.newsId}?lang=${currentLocale}"><img class="listImg" src="${item.newsUrl}"></a>
            <div class="listRight">
              <div class="listTitle"><a href="/changle/news/detail/${item.newsId}?lang=${currentLocale}">${item.newsTitle}</a></div>
              <p class="content">
                  ${item.newsSubtitle}
              </p>
            </div>
          </li>
        </c:forEach>
      </ul>
    </div>
    <div class="pageD">
      <jsp:include page="/WEB-INF/jsp/components/pagenation.jsp"/>
    </div>
  </div>
  <div class="rightDiv">
    <div class="titH3">
      <h3><spring:message key="news_center"/><span class="size-s" style="<spring:message key="english_show" />">News center</span></h3>
    </div>
    <ul class="newsT">
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
