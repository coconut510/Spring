package org.kh.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class LoginController implements Controller{

	@Override
	public String hadlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 입력값 저장
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		
		// 비즈니스 로직처리
		Member m  = new MemberService().selectOneMember(vo);
		
		
		// 4. view 페이지 리턴
		if(m!=null)
		{
			return "loginSuccess";
		}
		else
		{
			return "loginFailed";
		}
	}


}
