package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import domain.Task;
import service.TaskService;

@WebServlet(name = "taskController", urlPatterns = "/task/*")
public class TaskController extends HttpServlet {

	private final TaskService taskService = new TaskService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath += "/task";
		String com = uri.substring(conPath.length());
		System.out.println("============TaskController=============");
		System.out.println("uri " + uri);
		System.out.println("conPath " + conPath);
		System.out.println("com " + com);

		if (com.equals("/")) {
			HttpSession httpsession = request.getSession();
			Member member = (Member) httpsession.getAttribute("member");

			int during_i;
			String during = request.getParameter("during");
			if (during == null) {
				during_i = 2;
			} else {
				during_i = Integer.parseInt(during);
			}
			LocalDateTime time = LocalDateTime.now();
			ArrayList<ArrayList<Task>> tasks = taskService.findTaskByDate(time, during_i, member);
			System.out.println(tasks.size());
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");

			mv.getModel().put("task0", tasks.get(0));
			mv.getModel().put("task1", tasks.get(1));
			mv.getModel().put("task2", tasks.get(2));
			mv.getModel().put("task3", tasks.get(3));
			mv.getModel().put("task4", tasks.get(4));

			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/task/" + viewName + ".jsp";
	}
}
