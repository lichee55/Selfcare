package service;

import java.util.ArrayList;

import domain.Board;
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
}
