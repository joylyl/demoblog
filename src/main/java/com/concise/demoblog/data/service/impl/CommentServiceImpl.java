package com.concise.demoblog.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.Comment;
import com.concise.demoblog.data.persistence.CommentMapper;
import com.concise.demoblog.data.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	public boolean add(Comment comment) {
		return commentMapper.add(comment) == 0 ? false : true ;
	}

	public boolean delete(Integer id) {
		return commentMapper.delete(id) == 0 ? false : true ;
	}

	public boolean update(Comment comment) {
		return commentMapper.update(comment) == 0 ? false : true ;
	}

	public List<Comment> getCommentsByArrticleId(Integer id) {
		return commentMapper.getCommentsByArrticleId(id);
	}

	
}
