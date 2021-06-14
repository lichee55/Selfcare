package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// map -> 1. "members", members(ArrayList) 
//        2. "auth", int auth
public class View {
	private String viewPath;
	public View(String viewPath) {
		this.viewPath = viewPath;
	}
	public void render(Map<String, Object> model, 
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		model.forEach((key, value) -> request.setAttribute(key, value));
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
