package com.concise.demoblog.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.Tag;
import com.concise.demoblog.data.persistence.TagMapper;
import com.concise.demoblog.data.service.TagService;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
	private TagMapper tagMapper;
	
	public boolean add(Tag tag) {
		return tagMapper.add(tag) == 0 ? false : true ;
	}

	public boolean delete(Integer id) {
		return tagMapper.delete(id) == 0 ? false : true ;
	}

	public boolean update(Tag tag) {
		return tagMapper.update(tag) == 0 ? false : true ;
	}

	public List<Tag> getTags() {
		return tagMapper.getTags();
	}

	public Tag getById(Integer id) {
		return tagMapper.getById(id);
	}

	public List<Tag> getTagsByKeyword(String keyword) {
		return tagMapper.getTagsByKeyword(keyword);
	}

	
}
