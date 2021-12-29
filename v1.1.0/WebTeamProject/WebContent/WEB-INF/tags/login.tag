<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${adminId != null || memberId != null}">
   <!--  관리자 로그인시에도 Login버튼이 안 뜨도록 조건추가 -->
   	  <!-- 지금 adminId라는 값 자체를 못가져오는것 같다  -->
   	  <form action="logout.do">
   	  	<c:if test="${adminId != null }">
      		${adminName }님 환영합니다.
      	</c:if>
      	<c:if test="${memberId != null }">
      		${memberName }님 환영합니다.
      	</c:if>
      <input type="submit" value="LOGOUT">
      </form>
     
   </c:when>
   <c:otherwise>
     
       <form action="login.jsp">
      	<input type="submit" value="LOGIN">
      </form>
      
   </c:otherwise>
</c:choose>