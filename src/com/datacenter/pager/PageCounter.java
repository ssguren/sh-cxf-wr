package com.datacenter.pager;

import org.apache.log4j.Logger;

public class PageCounter {

	private static final Logger log = Logger.getLogger(PageCounter.class);

	private static final int PAGE_SIZE_DEFAULT = 15;

	private int totalItem;

	private int currentItem;

	private int pageNum;

	private int pageSize;

	private int pageTotal;

	public PageCounter(int totalItem) {
		this.totalItem = totalItem;
		this.currentItem = 1;
		this.pageNum = 1;
		this.pageSize = PAGE_SIZE_DEFAULT;
		this.pageTotal = (int) Math.ceil((double) this.totalItem
				/ this.pageSize);
	}

	public PageCounter(int totalItem, int pageSize) {
		this.totalItem = totalItem;
		this.currentItem = 1;
		this.pageNum = 1;
		this.pageSize = pageSize;
		this.pageTotal = (int) Math.ceil((double) this.totalItem
				/ this.pageSize);
	}

	public void pageTo(int pageNum) {
		if (0 >= pageNum) {
			this.pageNum = 1;
			this.currentItem = 1;
		} else if (this.pageTotal < pageNum) {
			this.pageNum = this.pageTotal;
			this.currentItem = (this.pageNum - 1) * this.pageSize;
		} else {
			this.pageNum = pageNum;
			this.currentItem = (this.pageNum - 1) * this.pageSize;
		}
	}

	public void refresh(int totalItem) {
		this.totalItem = totalItem;
		this.currentItem = 1;
		this.pageNum = 1;
		this.pageTotal = (int) Math.ceil((double) this.totalItem
				/ this.pageSize);
	}

	public int getTotalItem() {
		return totalItem;
	}

	public int getCurrentItem() {
		return currentItem;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public static void main(String[] args) {
		PageCounter pc = new PageCounter(121);
		log.info(pc.getPageTotal());
		pc.pageTo(3);
		log.info(pc.getCurrentItem());
	}

}
