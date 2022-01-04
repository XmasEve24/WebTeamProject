<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${memberId == replyNum}">
	<a href="deleteReply.do">DELETE</a>
</c:if>