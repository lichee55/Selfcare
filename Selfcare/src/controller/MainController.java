package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Member;
import service.MemberService;

@WebServlet(name = "mainController", urlPatterns = "/main/*")
public class MainController extends HttpServlet {

	private final MemberService memberService = new MemberService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath += "/main";
		String com = uri.substring(conPath.length());
		System.out.println("=========MainController==========");
		System.out.println("uri " + uri);
		System.out.println("conPath " + conPath);
		System.out.println("com " + com);

		if (com.equals("/index")) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			String viewPath = viewResolver(mv.getViewName());
			System.out.println(viewPath);
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);
		} else if (com.equals("/login")) {
			if (request.getMethod().equals("GET")) {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("login");
				String viewPath = viewResolver(mv.getViewName());
				System.out.println(viewPath);
				View view = new View(viewPath);
				view.render(mv.getModel(), request, response);
			} else {
				String mem_id = request.getParameter("mem_id");
				String passwd = request.getParameter("password");
				Member member = new Member(mem_id, null, passwd);
				boolean login = memberService.logIn(member);
				if (!login) {
					System.out.println("로그인 실패");
					response.sendRedirect("/main/login");
					return;
				}
				Member mem = memberService.findMemberById(mem_id);
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("member", mem);
				httpsession.setAttribute("isLogin", true);
				response.sendRedirect("/main/index");
			}
		} else if (com.equals("/logout")) {
			HttpSession httpsession = request.getSession();
			httpsession.removeAttribute("member");
			response.sendRedirect("/main/index");
		} else {
			response.sendRedirect("/main/index");
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/" + viewName + ".jsp";
	}
}