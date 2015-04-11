package com.concise.demoblog.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.Category;
import com.concise.demoblog.data.persistence.CategoryMapper;
import com.concise.demoblog.data.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public boolean add(Category category) {
		return categoryMapper.add(category)==0?false :true ;
	}

	public boolean delete(Integer id) {
		return categoryMapper.delete(id)==0?false :true ;
	}

	public boolean update(Category category) {
		return categoryMapper.update(category)==0?false :true ;
	}

	public Category getById(Integer id) {
		return categoryMapper.getById(id);
	}

	public List<Category> getByKeyword(String keyword) {
		return categoryMapper.getByKeyword(keyword);
	}

	public int getIdByName(String name) {
		return categoryMapper.getIdByName(name);
	}

}
