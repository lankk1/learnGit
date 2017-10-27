<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/31
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="${sessionScope.lang}">
<head>
  <title><spring:message key="Feedback" /></title>
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/public.css">
  <style>
    .form{
      padding-left: 40px;
    }
    .form label{
      font-family: "Microsoft YaHei UI";
      font-weight: 500;
      color: #333;
      vertical-align: top;
      width: 6em;
      text-align: right;
    }
    .form li{padding: 10px}
    .form li input{
      width: 15em;
    }
    .form li textarea{
      width: 25em;
      height: 10em;
    }
    .form label>span{
      color: red
    }
    .form .submit-div{
      padding-left: 6em;
    }
  </style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>
<div class="container">
  <div class="left-d">
    <h2 class="titH2"><spring:message key="contact_us" /><span class="size-s" style="<spring:message key="english_show" />">Contact Us</span></h2>
    <div class="body-l">
      <form class="form" action="/changle/comment" method="post">
        <ul>
          <li>
            <label><spring:message key="Feedbackcontent" /><span>*</span></label>
            <textarea name="commentContent"></textarea>
          </li>
          <li>
            <label><spring:message key="FeedbackName" /><span>*</span></label>
            <input type="text" name="commentUser">
          </li>
          <li>
            <label><spring:message key="FeedbackEmail" /><span>*</span></label>
            <input type="text" name="commentEmail">
          </li>
          <li>
            <label><spring:message key="FeedbackAddress" /><span>*</span></label>
            <input type="text" name="commentAddress">
          </li>
          <li>
            <label><spring:message key="FeedbackPhone" /><span>*</span></label>
            <input type="text" name="commentTel">
          </li>
          <li>
            <div class="submit-div">
              <button type="submit" class="btn btn-sm btn-primary"><spring:message key="leaveMessage" /></button>
            </div>
          </li>
        </ul>
      </form>
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
    </ul>
  </div>

</div>
<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>
</body>
</html>
