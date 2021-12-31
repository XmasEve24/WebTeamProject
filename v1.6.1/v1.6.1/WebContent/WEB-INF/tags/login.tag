<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${adminId != null || memberId != null}">
   	  <form action="logout.do">
	   	  <c:choose>
	   	  	<c:when test="${adminId != null}">
	      		관리자 ${adminName } 님 환영합니다.
	      	</c:when>
	      	<c:otherwise>
	      		회원 ${memberName } 님 환영합니다. 
	      	</c:otherwise>
	      </c:choose>
      <input type="submit" value="LOGOUT">
      </form>
   </c:when>
   <c:otherwise>
       <form action="login.jsp">
      	<input type="submit" value="LOGIN">
      </form>
   </c:otherwise>
</c:choose>