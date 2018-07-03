package org.kh.tv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.tv.model.vo.BeanFactory;
import org.kh.tv.model.vo.SamsungTV;
import org.kh.tv.model.vo.TV;
import org.kh.tv.model.vo.TVmgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class Dependency1Servlet
 */
public class Dependency1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependency1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//xml ���Ͽ� �ִ� Bean ��ü�� �������� ���� �۾�
		// 1. xml ������ �о� �鿩�� ��
		AbstractApplicationContext cntx  = new GenericXmlApplicationContext("/applicationContext.xml");
		
		TV tv = cntx.getBean("tvMgr", TVmgr.class).getTv();
				//  (�α���)�� ��ȯ ���൵ �ȴ� -> ((TVmgr)cntx.getBean("tvMgr")).getTv();
		
		
//		TV tv = (TV)BeanFactory.getBean(request.getParameter("beanName"));
		tv.powerOn();	// ������ ��
		tv.volumeUp();	// �Ҹ��� �ø�
		tv.volumeDown();// �Ҹ��� ����
		tv.powerOff();	// ������ ��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
