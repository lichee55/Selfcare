package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException;
}
