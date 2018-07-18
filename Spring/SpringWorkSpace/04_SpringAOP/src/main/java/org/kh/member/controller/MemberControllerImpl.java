package org.kh.member.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControllerImpl implements MemberController {
	@Autowired
	@Qualifier(value="memberService")
	private MemberServiceImpl memberService;
	
//	@RequestMapping(value="/login.do")
	@Override
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		//1. 값 추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		
		return null;
	}
	@RequestMapping(value="/login.do")
	public String selectOneMember(HttpServletRequest request,
			@RequestParam String userId, @RequestParam String userPw) {
	
		System.out.println( " 아이피 접근 " + request.getRemoteAddr() + " 접근 IP " + request.getLocalAddr());
		//1. 값 추출
		Member vo = new Member();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
	
		//2. 비즈니스 로직 처리
		Member m = memberService.selectOneMember(vo);
		
		
		//3. viewName 리턴
		// viewName을 처리할대 주의할점
		// viewName읅 DispatcherServlet에게 돌려줄때
		// 처리되도록 만들지만! DispatcherServlet에서는
		// 처리할때 무조건 forward방식만을 사용함
		// (sendRedirect 는 사용하지 않음)
		
		HttpSession session = request.getSession();
		if(m!=null)
		{
			session.setAttribute("member", m);
			session.setAttribute("loc", "member/loginSuccess");
			return "member/loginSuccess";
		}
		else
		{
			session.setAttribute("loc", "member/loginFailed");
			return "member/loginFailed";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logoutMember(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("아이피 접근 " + request.getRemoteAddr() + " 접근 IP " + request.getLocalAddr());
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		Member resultM = memberService.selectOneMember(m);
		
		if(m!=null)
		{                      
			session.removeAttribute("member");
			session.invalidate();
			return "redirect:/index.jsp";// viewResolver 관여 없이 경로를 직접 설정해 줄때.
//			return "member/logoutSuccess";
		}
		else return "member/logoutFailed";	
	}
	
	@RequestMapping(value="/myInfo.do")
	public Object myInfo(HttpSession session,HttpServletRequest request)
	{
		System.out.println("아이피 접근 " + request.getRemoteAddr() + " 접근 IP " + request.getLocalAddr());
		// session을 바로 받을수 있다.
		Member m = (Member)session.getAttribute("member");
		ModelAndView view = new ModelAndView();
		if(m!=null) {
			Member resultM = memberService.selectOneMember(m);
			
			if(m!=resultM)
			{
				view.addObject("member", m);
				view.setViewName("member/myPage");
//				request.setAttribute("myInfo", resultM);
//				return "member/myPage";
				return view;
			}
			else
			{
				view.setViewName("member/myPageError");
				return view;
			}
		}
		else
		{
			view.setViewName("member/wrongAccess");
			return view;
		}
	}
	@RequestMapping(value="/enroll.do")
	public String insertMember(HttpSession session, Member vo) {
		int result  = memberService.insertMember(vo);
		if(result>0) return "member/enrollSuccess";
		else return "member/enrollFail";
	}
	
	@RequestMapping(value="/mUpdate.do")
	public String memberUpdate(HttpSession session,Member vo)
	{
		int result = memberService.updateMember(vo);
		ModelAndView view = new ModelAndView();
		if(result>0) {
			session.setAttribute("member", vo);
			return "member/mUpdateSuccess";
		}
		else
		{
			return "member/mUpdateFail";
		}
	}
	
	@RequestMapping(value="/enrollPage.do")
	public String enrollPage()
	{
		return "member/enroll";
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteMember(HttpSession session)
	{
		Member vo = (Member) session.getAttribute("member");
		
		int result = memberService.deleteMember(vo);
		if(result>0)
		{
			session.invalidate();
			return "member/deleteSuccess";
		}
		else return "member/deleteFail";
	}
	
	@RequestMapping(value="/selectAllMember.do")
	public Object selectAllMember()
	{
		ArrayList<Member> list = memberService.selectAllMember();
		ModelAndView view = new ModelAndView();
		view.addObject("allMember", list);
		view.setViewName("member/selectAllMember");
		return view;
	}
}
