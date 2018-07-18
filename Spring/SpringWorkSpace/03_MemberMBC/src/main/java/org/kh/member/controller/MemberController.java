package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.vo.Member;
public interface MemberController {
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response);
	public Object myInfo(HttpSession session,HttpServletRequest request);
	public String logoutMember(HttpServletRequest request,HttpServletResponse response);
	public String memberUpdate(HttpSession session,Member vo);
	public String insertMember(HttpSession session, Member vo);
}
