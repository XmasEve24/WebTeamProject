<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${memberId == null }">
		<input type="text" class="form-control" placeholder="Name" name="memberId" disabled="disabled" value="로그인후에  작성이 가능합니다!">
		<input type="email" class="form-control" placeholder="Email" name="memberEmail" disabled="disabled" value="로그인후에  작성이 가능합니다!">
		<textarea class="form-control" placeholder="Comment" rows="5" name="Your Comments" id="comment" name="comment" disabled="disabled" value="로그인후에  작성이 가능합니다!"></textarea>
		<div class="contact-submit">
			<input name="submit" type="submit" class="form-control" id="submit"	value="Submit a comment">
		</div>
	</c:when>
	<c:when test="${memberId != null }">
		<input type="text" class="form-control" placeholder="Name" name="memberId" required>
		<input type="email" class="form-control" placeholder="Email" name="memberEmail" required>
		<textarea class="form-control" placeholder="Comment" rows="5" name="Your Comments" id="comment" name="comment" required></textarea>
		<div class="contact-submit">
			<input name="submit" type="submit" class="form-control" id="submit"	value="Submit a comment">
		</div>
	</c:when>
</c:choose>