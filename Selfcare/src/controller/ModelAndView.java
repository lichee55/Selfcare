package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
	
	private String viewName;
	
	private Map<String, Object> model = new HashMap<>();
	private int status;
	
	public ModelAndView() {
		status = HttpServletResponse.SC_OK;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
