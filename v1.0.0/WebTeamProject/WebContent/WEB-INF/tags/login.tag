<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${memberID == null}">
   <!--  관리자 로그인시에도 Login버튼이 안 뜨도록 조건추가 -->
   	 <form method="post" action="login.jsp">
      <input type="submit" value="LOGIN">
      </form>
   </c:when>
   <c:otherwise>
      <form method="post" action="logout.do">
      <input type="submit" value="LOGOUT">
      </form>
   </c:otherwise>
</c:choose>