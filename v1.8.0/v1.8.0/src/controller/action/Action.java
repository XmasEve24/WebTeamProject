package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;

public interface Action {
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
