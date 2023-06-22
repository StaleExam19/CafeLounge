package com.syntaxerror.cafelounge.service;

import org.springframework.stereotype.Service;

@Service
public class ViewService {
	private int pageViews = 0;
	
	public int getPageViews() {
		return this.pageViews;
	}
	
	public void updatePageViews() {
		this.pageViews += 1;
	}
}
