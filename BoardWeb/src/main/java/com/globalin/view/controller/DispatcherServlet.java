package com.globalin.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.biz.user.UserVO;
import com.globalin.biz.user.impl.UserDAO;

//@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {

		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.Client의 요청 path 정보를 추출함.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//System.out.println(path);

		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색함.
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행함
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해서 viewName에 해당하는 화면을 검색함.
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동함.
		response.sendRedirect(view);
		
		
	}
}
