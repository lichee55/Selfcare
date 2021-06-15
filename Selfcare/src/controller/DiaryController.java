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
import javax.servlet.http.HttpSession;

import domain.Board;
import domain.Diary;
import domain.Member;
import service.DiaryService;

@WebServlet(name = "diaryController", urlPatterns = "/diary/*")
public class DiaryController extends HttpServlet {

	private final DiaryService diaryService = new DiaryService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath += "/board";
		String com = uri.substring(conPath.length());
		System.out.println("============DiaryController=============");
		System.out.println("uri " + uri);
		System.out.println("conPath " + conPath);
		System.out.println("com " + com);

		if (com.equals("/list")) {
			String diaryPage = request.getParameter("page");
			if (diaryPage == null) {
				System.out.println("no page param");
				response.sendRedirect("/diary/list?page=1");
				return;
			}
			if (Integer.parseInt(diaryPage) < 1) {
				System.out.println("invalid page param");
				response.sendRedirect("/diary/list?page=1");
				return;
			}
			HttpSession httpsession = request.getSession();
			Member member = (Member) httpsession.getAttribute("member");
			ArrayList<Diary> diarys = diaryService.findBoards(Integer.parseInt(diaryPage), member.getMem_Id());
			int number = diaryService.findNum(member.getMem_Id());
			number = number / 10;
			number++;
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");
			mv.getModel().put("diarys", diarys);
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
				HttpSession httpsession = request.getSession();
				Member member = (Member) httpsession.getAttribute("member");
				Diary diary = new Diary();
				diary.setMem_Id(member.getMem_Id());
				diary.setContent(request.getParameter("contents"));
				diaryService.insert(diary);
				System.out.println("[Insert] diary");
				response.sendRedirect("/diary/list?page=1");
			}
		} else if (com.equals("/update")) {
			if (request.getMethod().equals("GET")) {
				System.out.println("update get method in");
				ModelAndView mv = new ModelAndView();
				mv.setViewName("update");
				Diary diary = diaryService.findById(Integer.parseInt(request.getParameter("id")));
				mv.getModel().put("diary", diary);
				String viewPath = viewResolver(mv.getViewName());
				View view = new View(viewPath);
				view.render(mv.getModel(), request, response);
			} else {
				System.out.println("update post method in");
				Diary diary = new Diary();
				diary.setDiary_Id(Integer.parseInt(request.getParameter("diary_id")));
				diary.setContent(request.getParameter("contents"));
				diaryService.update(diary);
				System.out.println("[Update] diary");
				response.sendRedirect("/diary/list?page=1");
			}
		} else if (com.equals("/delete")) {
			if (request.getMethod().equals("POST")) {
				int board_id = Integer.parseInt(request.getParameter("diary_id"));
				Diary diary = new Diary();
				diary.setDiary_Id(board_id);
				diaryService.delete(diary);
				System.out.println("[Delete] board");
				response.sendRedirect("/diary/list?page=1");
			}
		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/diary/" + viewName + ".jsp";
	}
}
