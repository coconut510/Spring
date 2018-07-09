package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public interface Controller {
	String hadlerRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException;
}
