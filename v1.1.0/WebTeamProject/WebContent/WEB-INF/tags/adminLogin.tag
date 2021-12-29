<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${mid == null}">
      <form method="post" action="login.mem">
      Login
      </form>
   </c:when>
   <c:otherwise>
      <form method="post" action="logout.mem">
      Logout
      </form>
   </c:otherwise>
</c:choose>