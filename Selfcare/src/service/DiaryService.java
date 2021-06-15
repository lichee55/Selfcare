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
	public ArrayList<Diary> findBoards(int pageNum, String memberId) {
        return diaryRepository.findDiaryByPage(pageNum, memberId);
    }
	public Diary findById(int input) {
        return diaryRepository.findDiaryById(input);
    }
	public int findNum() {
        return diaryRepository.findNum();
    }
}
