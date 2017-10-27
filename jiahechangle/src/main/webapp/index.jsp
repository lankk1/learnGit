<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/31/2017
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title><</title>
  <meta http-equiv = "X-UA-Compatible" content = "IE=edge"/>
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    .language-body{
      width: 100%;
      height: 100%;
    }
    .language-img{
      width: 100%
    }
    .language-img img{
      width: 100%;
      height: 100%;
    }
    .language-text{
      position: fixed;
      top: 25%;
      left: 10%;
      color: white;
    }
    .language-text-title{
      font-size: 2.5em;
      text-align: center;
      padding-bottom: 10px;
    }
    .language-text-button{
      margin-top: 20px;
      text-align: center;
    }
    .language-text-english{
      font-size: 1.2em;
    }
    .language-text-button a{
      text-decoration: none;
      display: inline-block;
      text-align: center;
      width: 5em;
      margin: 20px;
      padding: 5px;
      border-radius: 20px;
      background: #9199AC;
      color: black;
    }
  </style>
</head>
<body>
<div class="language-body">
  <div class="language-img">
    <img src="/static/images/bg.jpg">
  </div>
  <div class="language-text">
    <p class="language-text-title">
      长乐嘉禾源水产品有限公司
    </p>
    <p class="language-text-english">
      CHANGLE JIA HE YUAN AQUATIC PRODUCT CO.LTD
    </p>
    <div class="language-text-button"><a href="/changle/front?lang=zh">中文版</a><a href="/changle/front?lang=en">English</a></div>
  </div>
</div>
</body>
</html>
