<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${memberId == null }">
		<textarea class="form-control" placeholder="회원 로그인 이후에 이용하세요" rows="5" id="comment" name="replyContent" disabled="disabled" ></textarea>
		<div class="contact-submit">
			<input type="submit" class="form-control" id="submit"	value="Submit a comment">
		</div>
	</c:when>
	<c:when test="${memberId != null }">
		<textarea class="form-control" placeholder="Comment" rows="5" id="comment" name="replyContent" required></textarea>
		<div class="contact-submit">
		<input type="submit" class="form-control" id="submit"	value="Submit a comment">
		</div>
	</c:when>
</c:choose>