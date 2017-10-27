<%--
  Created by IntelliJ IDEA.
  User: slipkinem
  Date: 8/30/2017
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="${sessionScope.lang}">
<head>
  <title><spring:message key="about_us" /></title>
  <jsp:include page="/WEB-INF/jsp/components/source.jsp"/>
  <link rel="stylesheet" href="/static/styles/about.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/components/front.jsp"/>

<div class="about-container">
  <div class="img-list">
    <img src="/static/images/imglist.jpg" alt="imglist" width="100%">
  </div>
  <div class="intro">
    <span style="<spring:message key="english_show" />">
    <p>
      长乐嘉禾源水产品有限公司于2012年成立，是一家具有对外贸易经营权，集研发、生产和贸易于一体的水产加工型企业。产品经由网络分销全球，远销美国、以色列、印度尼西亚、马来西亚、菲律宾、泰国、越南、新加坡、韩国、日本、澳大利亚、新西兰、智利和秘鲁等60多个国家和地区。在境外建立以荷兰鹿特丹港为中心的欧洲配送中心，及以美国长滩港为中心的美洲配送中心。国内市场营销及市场网络推广遍布全国，在中国建立长三角地区，环渤海地区，中原地区，海峡西岸及西部地区六个大区管理中心。
    </p>
    <p>公司产品资源完整：产品细分为3大类（冻鱼，冻软体类，冻贝壳类）五十小类，共计250单品（冻罗非鱼，冻鲈鱼，冻鱿鱼，冻鲭鱼，冻鲶鱼等），基本满足国内批发，全球出口的要求。</p>
    <p>
      目前我司斥资18亿元，分期规划在印尼中爪哇地区初步建成3.5万亩自然混合淡海水鱼类、对虾生态养殖产业链，包括利用现代生物科技生物科技技术年培育防蜕变优质高端鱼苗60亿尾、优质对虾100亿尾，以及建设年生产各类对虾、鱼类生物颗粒饲料20万吨，建设投产精深加工产业化生产基地，年可生产及精深加工各类海产品18万吨。目前该项目一期建设已经投产，收到了良好的经济效益与社会效益，被印尼当地政府列为支持当地经济发展及东盟-中国海上合作的重点示范项目，是中国企业积极参与印尼海洋渔业发展的典范。</p>
    </span>
      <p>CHANGLE JIAHE YUAN AQUATIC PRODUCT CO.,LTD founded in 2012， is a seafood-processed company that has right to
      operate foreign trade, research and development. Our seafood is distributed and exported to United States, Israel,
      Indonesia, Malaysia, Philippines, Thailand, Vietnam, Singapore, Korea, Japan, Australia, New Zealand, Chile, Peru,
      more than 60 countries and regions. We have built distribution centers at the port of Rotterdam in Netherlands and
      the port of Long Beach in the United States. We also have set up domestic sales and marketing network in China,
      east China, southern China, the central region, north region, northwest territories, northeast China as major
      management center. We can fully meet the requirements of domestic wholesale and global export. </p>
    <p>Our Products are divided into three kinds ,frozen fish, frozen molluscs, frozen shellfish which are subdivided
      into 250 products ,frozen tilapia、seabass、squid、pacific mackerel、catfish, etc.</p>
    <p>At present the company has invested 1.8billion RMB in Jawa Tengah in Indonesia, planning to create ecological
      offshore aquaculture industry chain in several phases. 6 billion anti-degenerate fish fries and 10billion shrimp
      seeds of high quality will be propagated each year. Production base has been constructed which will be capable of
      providing 200,000tons of biological fish and shrimp food, meanwhile fine processing all kings of marine products
      of 180,000tons. The first phase has already went into operation and obtained healthy economic and social benefit,
      therefore been labeled as demonstrative project by Indonesia government, and been high praised as a good example
      of Chinese enterprise participating marine fishery development in Indonesia.</p>
  </div>
</div>

<jsp:include page="/WEB-INF/jsp/components/footer.jsp"/>
</body>
</html>
