<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>petmily</title>
<script type="text/javascript" src="/petmily/resources/js/common/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="/petmily/resources/js/main/banner_scroll.js"></script>
<link rel="stylesheet" href="/petmily/resources/css/main/banner.css">

</head>
<body>
<section>
<%@ include file="views/common/main.jsp" %>
</section>

<div class="banner-container" style="height: 750px">
  <div class="banner">
    <div data-index=1><img src="/petmily/resources/images/mainbanner/882.jpg"></div>
    <div data-index=2><img src="/petmily/resources/images/mainbanner/883.jpg"></div>
    <div data-index=3><img src="/petmily/resources/images/mainbanner/884.jpg"></div>
    <div data-index=4><img src="/petmily/resources/images/mainbanner/885.jpg"></div>
  </div>
</div>
<div class="list-button">
  <span class="list-button-item active"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
  <span class="list-button-item"></span> 
</div>
<%-- <%
    String clientId = "Y4aSWVB6n8GBIwdvF73u";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "oWbuQ2K3Ut";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http:"+"//"+"localhost:8080/petmily/", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
        out.println(res.toString());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  %> --%>
</body>
</html>