<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="currentLocale" value="${pageContext.response.locale}" scope="session"/>

<%-- top-bar --%>
<div class="top-bar"></div>
<%-- header --%>
<header>
  <a href="/changle/front?lang=${currentLocale}">
    <img src="/static/images/logo.jpg" alt="logo">
  </a>
  <form class="search form-inline" action="/product/search?lang=${currentLocale}" method="post">
    <input type="text" name="keyword" class="form-control input-sm" placeholder="<spring:message key="searchPlaceholder" />">
    <button type="submit" class="btn btn-sm btn-success"><spring:message key="searchbtn" /></button>
  </form>
</header>
<%-- banner --%>
<div class="banner">
  <div class="nav-container">
    <nav>
      <ul>
        <li>
          <a href="/changle/front?lang=${currentLocale}">
            <spring:message key="home" />
            <span style="<spring:message key="english_show" />"><br/>HOME</span>
          </a>
        </li>
        <li>
          <a href="/changle/about?lang=${currentLocale}">
            <spring:message key="about_us" />
            <span style="<spring:message key="english_show" />"><br/>ABOUT US</span>
          </a>
        </li>
        <li>
          <a href="/changle/product/1?lang=${currentLocale}">
            <spring:message key="product" />
            <span style="<spring:message key="english_show" />"><br/>PRODUCT</span>
          </a>
        </li>
        <li>
          <a href="/changle/news/1?lang=${currentLocale}">
            <spring:message key="news_center" />
            <span style="<spring:message key="english_show" />"><br/>NEWS CENTER</span>
          </a>
        </li>
        <li>
          <a href="/changle/contact?lang=${currentLocale}">
            <spring:message key="contact_us" />
            <span style="<spring:message key="english_show" />"><br/>CONTACT US</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
  <img src="/static/images/banner.jpg" alt="banner">
</div>
