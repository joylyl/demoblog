package com.concise.demoblog.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.Link;
import com.concise.demoblog.data.persistence.LinkMapper;
import com.concise.demoblog.data.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	private LinkMapper linkMapper;
	
	public boolean add(Link link) {
		return linkMapper.add(link) == 0 ? false : true ;
	}

	public boolean delete(Integer id) {
		return linkMapper.delete(id) == 0 ? false : true ;
	}

	public boolean update(Link link) {
		return linkMapper.update(link) == 0 ? false : true ;
	}

	public List<Link> getLinksByRandom(Integer random) {
		return linkMapper.getLinksByRandom(random);
	}

}
