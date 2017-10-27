<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentLocale" value="${pageContext.response.locale}" scope="session"/>

<html lang="${currentLocale}">
<head>
  <title><spring:message key="index"/></title>
  <meta charset="UTF-8">
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/index.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>

<div class="intro text-center">
  <img src="<spring:message key="intro" />" alt="intro">
</div>

<div class="recommend">
  <div class="recommend-container text-center">
    <h3 class="title"><spring:message key="newArrivals" /><br/>--</h3>
    <ul>
      <li>
        <img src="/static/images/product/Seabass_Fillet.jpg" alt="<spring:message key="Seabass_Fillet" />">
        <p><spring:message key="Seabass_Fillet" /></p>
      </li>
      <li>
        <img src="/static/images/product/Cut_Crab.jpg" alt="<spring:message key="Cut_Crab" />">
        <p><spring:message key="Cut_Crab" /></p>
      </li>
      <li>
        <img src="/static/images/product/Squid_Series.jpg" alt="<spring:message key="Squid_Series" />">
        <p><spring:message key="Squid_Series" /></p>
      </li>
      <li>
        <img src="/static/images/product/Mahi_mahi_Fillet.jpg" alt="<spring:message key="Mahi_mahi_Fillet" />">
        <p><spring:message key="Mahi_mahi_Fillet" /></p>
      </li>
    </ul>
    <a href="/changle/product/1?lang=${currentLocale}" class="more btn btn-primary btn-sm"> <spring:message key="More" />> </a>
  </div>
</div>

<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>
</body>
</html>
