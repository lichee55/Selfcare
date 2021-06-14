package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import domain.Comment;
import persistence.CommentRepository;

public class CommentService {
	private final CommentRepository commentRepository = CommentRepository.getInstance();
	public CommentService() {}
	public void write(Comment comment) {
		commentRepository.save(comment);
	}
	public void update(Comment comment) {
		commentRepository.update(comment);
	}
	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}
	public ArrayList<Comment> findComments(Comment comment){
		return commentRepository.findAll(comment);
	}
}
