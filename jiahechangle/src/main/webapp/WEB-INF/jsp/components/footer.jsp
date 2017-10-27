<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<footer>
  <div class="container clearfix">
    <div class="foot-logo col-xs-2">
      <img src="/static/images/footer-logo.png" alt="foot-logo">
    </div>
    <address class="col-xs-9">
      <p><spring:message key="copy_right" /> &nbsp;&nbsp;&nbsp;&nbsp;<spring:message key="Office_address" /></p>
      <p><spring:message key="Switchboard" />:0591-87319160 &nbsp;&nbsp;&nbsp;&nbsp;<spring:message key="fax" />:0591-83626780</p>
    </address>
  </div>
</footer>
