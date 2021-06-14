package service;

import java.util.ArrayList;

import domain.Board;
import domain.Diary;
import persistence.BoardRepository;
import persistence.DiaryRepository;

public class DiaryService {
	private final DiaryRepository diaryRepository = DiaryRepository.getInstacne();
	public DiaryService() {
		
	}
	public void insert(Diary diary) {		
		diaryRepository.insert(diary);
	}
	public void update(Diary diary) {		
		diaryRepository.update(diary);
	}
	public void delete(Diary diary) {		
		diaryRepository.delete(diary);
	}
	public ArrayList<Board> findBoards(int pageNum) {
        return diaryRepository.findDiaryByPage(pageNum);
    }
	public Board findById(int input) {
        return diaryRepository.findById(input);
    }
}
