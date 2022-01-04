<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${memberId == replyNum || adminId !=null}">
	<a href="deleteReply.do?replyNum=${r.replyNum}">[DELETE]</a>
</c:if>