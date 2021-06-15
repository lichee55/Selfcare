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
			if (Integer.parseInt(boardPage) < 1) {
				System.out.println("invalid page param");
				response.sendRedirect("/board/list?page=1");
				return;
			}
			ArrayList<Board> boards = boardService.findBoards(Integer.parseInt(boardPage));
			int number = boardService.findNum();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");
			mv.getModel().put("boards", boards);
			mv.getModel().put("totalPage", number);
			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);

		} else if (com.equals("/insert")) {
			if (request.getMethod().equals("GET")) {
				System.out.println("insert get method in");
				ModelAndView mv = new ModelAndView();
				mv.setViewName("insert");
				String viewPath = viewResolver(mv.getViewName());
				View view = new View(viewPath);
				view.render(mv.getModel(), request, response);
			} else {
				System.out.println("insert post method in");
				Board board = new Board();
				board.setTitle(request.getParameter("title"));
				board.setMem_id(request.getParameter("mem_id"));
				board.setContents(request.getParameter("contents"));
				boardService.insert(board);
				System.out.println("[Insert] board");
				response.sendRedirect("/board/list?page=1");
			}
		} else if (com.equals("/update")) {
			if (request.getMethod().equals("GET")) {
				System.out.println("update get method in");
				ModelAndView mv = new ModelAndView();
				mv.setViewName("update");
				Board board = boardService.findById(Integer.parseInt(request.getParameter("board_id")));
				mv.getModel().put("board", board);
				String viewPath = viewResolver(mv.getViewName());
				View view = new View(viewPath);
				view.render(mv.getModel(), request, response);
			} else {
				System.out.println("update post method in");
				Board board = new Board();
				board.setBoard_Id(Integer.parseInt(request.getParameter("board_id")));
				board.setTitle(request.getParameter("title"));
				board.setMem_id(request.getParameter("mem_id"));
				board.setContents(request.getParameter("contents"));
				boardService.update(board);
				System.out.println("[Update] board");
				response.sendRedirect("/board/list?page=1");
			}
		} else if (com.equals("/delete")) {
			if (request.getMethod().equals("POST")) {
				int board_id = Integer.parseInt(request.getParameter("board_id"));
				Board board = new Board();
				board.setBoard_Id(board_id);
				boardService.delete(board);
				System.out.println("[Delete] board");
				response.sendRedirect("/board/list?page=1");
			}
		} else if (com.equals("/detail")) {
			int board_id = Integer.parseInt(request.getParameter("id"));
			Board board = boardService.findById(board_id);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("detail");
			mv.getModel().put("board", board);
			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/board/" + viewName + ".jsp";
	}
}