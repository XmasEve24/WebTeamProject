<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${adminId != null}">
      <form>
      	<a href="contactMsg.do">contactMsg</a>
      </form>
   </c:when>
   <c:when test="${memberId != null }">
      <form>
      	<a href="contact.do">Contact</a>
      </form>
	</c:when>
</c:choose>