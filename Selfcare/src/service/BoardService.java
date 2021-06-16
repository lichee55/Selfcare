package service;

import java.util.ArrayList;

import domain.Board;
import domain.Comment;
import persistence.BoardRepository;

public class BoardService {
	private final BoardRepository boardRepository = BoardRepository.getInstacne();

	public BoardService() {

	}

	public void insert(Board board) {
		boardRepository.insert(board);
	}

	public void update(Board board) {
		boardRepository.update(board);
	}

	public void delete(Board board) {
		boardRepository.delete(board);
	}

	public ArrayList<Board> findBoards(int pageNum) {
		return boardRepository.findBoardByPage(pageNum);
	}

	public Board findById(int input) {
		boardRepository.updateHit(input);
		return boardRepository.findById(input);
	}

	public int findNum() {
		return boardRepository.findNum();
	}

	public void insertComment(Comment comment) {
		boardRepository.insertComment(comment);
	}

	public void deleteComment(Comment comment) {
		boardRepository.deleteComment(comment);
	}

	public ArrayList<Comment> findCommentByBoardId(Board board) {
		return boardRepository.findCommentByBoardId(board);
	}

}
