package org.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
    public void init() throws ServletException{
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이곳에 매핑을 위한 작업
		// 1. 클라이언트의 요청 path 정보를 추출
		String uri = request.getRequestURI();// 전체 uri 정보를 추출
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri);
		System.out.println(path);
		
		// 2. HandlerMapping 을 통해 path에 해당하는 Controller 를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller 를 실행
		String viewName = ctrl.hadlerRequest(request, response);
		
		// 4. 컨트롤러에서 리턴한 viewName을 가지고 ViewResolver를 통해 view를 검색
		String view = null;
		if(!viewName.contains(".do")) {// 일반 뷰를 호출할때.
			view = viewResolver.getView(viewName);
		}
		else  // 또다시 컨트롤러를 호출해야할때.
		{
			view = viewName;
		}
		
		// 5. 검색한 화면으로 이동
		response.sendRedirect(view);
	}

}
