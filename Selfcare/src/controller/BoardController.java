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
import service.BoardService;

@WebServlet(name = "boardController", urlPatterns = "/board/*")
public class BoardController extends HttpServlet {

	private final BoardService boardService = new BoardService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath += "/board";
		String com = uri.substring(conPath.length());
		System.out.println("============BoardController=============");
		System.out.println("uri " + uri);
		System.out.println("conPath " + conPath);
		System.out.println("com " + com);

		if (com.equals("/list")) {
			String boardPage = request.getParameter("page");
			if (boardPage == null) {
				System.out.println("no page param");
				response.sendRedirect("/board/list?page=1");
				return;
			}
			if(Integer.parseInt(boardPage)<1) {
				System.out.println("invalid page param");
				response.sendRedirect("/board/list?page=1");
				return;
			}
			ArrayList<Board> boards = boardService.findBoards(Integer.parseInt(boardPage));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");
			mv.getModel().put("boards", boards);
			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);
			
		}else if(com.equals("/insert")) {
			if(request.getMethod().equals("GET")) {
				System.out.println("insert get method in");
				ModelAndView mv = new ModelAndView();
				mv.setViewName("insert");
				String viewPath = viewResolver(mv.getViewName());
				View view = new View(viewPath);
				view.render(mv.getModel(), request, response);
			}else {
				System.out.println("insert post method in");
				Board board = new Board();
				board.setTitle(request.getParameter("title"));
				board.setMem_id(request.getParameter("mem_id"));
				board.setContents(request.getParameter("contents"));
				boardService.insert(board);
				System.out.println("[Add] new board");
				response.sendRedirect("/board/list?page=1");
			}
		}else if(com.equals("/update")) {
			
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/board/" + viewName + ".jsp";
	}
}