<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${adminId != null}">
      <form>
      	<a href="write.jsp">write</a>
      </form>
   </c:when>
   <c:otherwise/>
</c:choose>