package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;

@WebServlet(name = "boardController", urlPatterns = "/board/*")
public class BoardController extends HttpServlet {
	
	private final BoardService boardService = new BoardService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath+="/board";
		String com = uri.substring(conPath.length());
		System.out.println("============BoardController=============");
		System.out.println("uri "+ uri);
		System.out.println("conPath "+ conPath);
		System.out.println("com "+ com);
		
		if(com.equals("/")) {
			ArrayList<Board> boards=boardService
		}
	}
}