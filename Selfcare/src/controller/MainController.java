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

@WebServlet(name="mainController", urlPatterns = "/main/*")
public class MainController extends HttpServlet{

	private Map<String, Controller> controllerMap = new HashMap<>();

	public MainController() {
	}
	
}
