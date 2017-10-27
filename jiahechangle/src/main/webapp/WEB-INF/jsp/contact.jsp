<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="${sessionScope.lang}">
<head>
  <title><spring:message key="contact_us" /></title>
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/public.css">
  <style>
    .body-l>.companyN{
      padding-left: 10px;
      font-size: 1.6em;
      color: #808080;
      font-weight: 500;
    }
    .body-l>.contact{
      padding-left: 10px;
      font-size: 1.2em;
      color: #808080;
      font-weight: 500;
    }
  </style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>
<div class="container">
  <div class="left-d">
    <h2 class="titH2"><spring:message key="contact_us" /><span class="size-s">Contact Us</span></h2>
    <div class="body-l">
      <p class="companyN"><spring:message key="company_name" /></p>
      <p class="contact">
        <spring:message key="contact_phone" />:0591-87319160  0591-83626780
        <br>
        <spring:message key="fax" />:0591-83626780
        <br>
        <spring:message key="E-mail" />:504461569@qq.com
        <br>
        <spring:message key="Office_address" />
      </p>
      <div>
        <img src="/static/images/map.png">
      </div>
    </div>


  </div>
  <div class="rightDiv">
    <div class="titH3">
      <h3><spring:message key="contact_us" /><span class="size-s" style="<spring:message key="english_show" />">Contact Us</span></h3>
    </div>
    <ul class="newsT">
      <li>
        <a href="/changle/contact?lang=${currentLocale}"><spring:message key="contact_us" /> <span style="<spring:message key="english_show" />">Contact Us</span></a>
      </li>
      <li>
        <a style="text-decoration: underline;color: #2b669a" href="/changle/comment?lang=${currentLocale}"><spring:message key="Feedback" /> <span style="<spring:message key="english_show" />">FeedBack</span></a>
      </li>
    </ul>
  </div>

</div>
<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>
</body>
</html>
