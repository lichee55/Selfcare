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

@WebServlet(name = "mainController", urlPatterns = "/main/*")
public class MainController extends HttpServlet {

	private Map<String, Controller> controllerMap = new HashMap<>();

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
		if (com.equals("/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			dispatcher.forward(request, response);
		} else {
			String[] tokens = com.split("/");
			String domain = tokens[1];
			Controller controller = controllerMap.get(domain);
			if (controller == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			ModelAndView mv = controller.process(request, response, com);
			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/" + viewName + ".jsp";
	}
}