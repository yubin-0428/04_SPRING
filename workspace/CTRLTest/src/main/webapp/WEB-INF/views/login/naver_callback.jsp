<%--
/**
        Class Name:
        Description:
        Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 23.        최초작성 
    
    author ehr 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 네이버api -->
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="com.pcwk.ctrl.naver.controller.MemberProfile" %>
<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES"    value="${CP}${resources}" />
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <title>네이버 로그인</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
    <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/jquery.bootpag.js"></script>
   
    </script>
</head>
<body>
    <%
	    String clientId = "SFHYYlRp9uGKqdsmMrqu";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "VLZrBQXQtb";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8081/ctrl/login/callback.do", "UTF-8");
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
	        System.out.println(res.toString()); //res.toString(): json형식
	         String obj = res.toString();
	        
	        JsonParser jsonParser = new JsonParser();
	        
	        JsonObject jsonObject = (JsonObject)jsonParser.parse(obj);
	        System.out.println(jsonObject.get("access_token"));
	        
// 	        여기부터 access_token 가져오기위한 작업
// 			while ((inputLine = br.readLine()) != null) {
// 			    res.append(inputLine);
// 			}
// 			 br.close();
// 			if(responseCode==200) {
// 			    System.out.println(res.toString());
// 			    JsonParser parsing = new JsonParser();
// 			    Object obj = parsing.parse(res.toString());
// 			    JsonObject jsonObj = (JsonObject)obj;
			                
// 			    access_token = (String)jsonObj.get("access_token");
// 			    refresh_token = (String)jsonObj.get("refresh_token");
// 			}	        
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    %>
	    <%
// 	    회원프로필 조회
// 	    public static void main(String[] args) {
// //	        "AAAAOp-0uiUysOy3BesOjX92vMUA7Uvd3F7twMpeg9ieXz656n9PCYlByDk6CzocQz4HQnS9KF8JIXIOonZjBvoWZXQ"; // 네이버 로그인 접근 토큰;
// 	        String token = "AAAAOp-0uiUysOy3BesOjX92vMUA7Uvd3F7twMpeg9ieXz656n9PCYlByDk6CzocQz4HQnS9KF8JIXIOonZjBvoWZXQ";
// 	        String header = "Bearer " + token; // Bearer 다음에 공백 추가


// 	        String apiURL = "https://openapi.naver.com/v1/nid/me";


// 	        Map<String, String> requestHeaders = new HashMap<>();
// 	        requestHeaders.put("Authorization", header);
// 	        String responseBody = get(apiURL,requestHeaders);

// 	        System.out.println(responseBody);
// 	    }


// 	    private static String get(String apiUrl, Map<String, String> requestHeaders){
// 	        HttpURLConnection con = connect(apiUrl);
// 	        try {
// 	            con.setRequestMethod("GET");
// 	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
// 	                con.setRequestProperty(header.getKey(), header.getValue());
// 	            }


// 	            int responseCode = con.getResponseCode();
// 	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
// 	                return readBody(con.getInputStream());
// 	            } else { // 에러 발생
// 	                return readBody(con.getErrorStream());
// 	            }
// 	        } catch (IOException e) {
// 	            throw new RuntimeException("API 요청과 응답 실패", e);
// 	        } finally {
// 	            con.disconnect();
// 	        }
// 	    }


// 	    private static HttpURLConnection connect(String apiUrl){
// 	        try {
// 	            URL url = new URL(apiUrl);
// 	            return (HttpURLConnection)url.openConnection();
// 	        } catch (MalformedURLException e) {
// 	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
// 	        } catch (IOException e) {
// 	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
// 	        }
// 	    }


// 	    private static String readBody(InputStream body){
// 	        InputStreamReader streamReader = new InputStreamReader(body);


// 	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
// 	            StringBuilder responseBody = new StringBuilder();


// 	            String line;
// 	            while ((line = lineReader.readLine()) != null) {
// 	                responseBody.append(line);
// 	            }


// 	            return responseBody.toString();
// 	        } catch (IOException e) {
// 	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
// 	        }
// 	    }
	    
	    
	    
	    %>
	  
<!--     접근토큰 삭제요청 url(한 번 동의한 정보제공 항목에 대한 재동의를 위해서 필요), access_token부분을 매번 바꿔줘야함 -->
<!--   https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=SFHYYlRp9uGKqdsmMrqu&client_secret=VLZrBQXQtb&access_token=AAAAOaxe-zZ9jRkpiOXAtF0sqZ1IR6zUhurRgT_TV_E6wTEoxN6rXrZQXzzt6uErUY_Hvj6CBEeSILlzVUGoY-iWT8c&service_provider=NAVER  -->
</body>
</html>