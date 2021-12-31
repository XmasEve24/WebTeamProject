<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${adminId != null }">
      <form method="post" action="write.do">
      	write
      </form>
   </c:when>
  
</c:choose>