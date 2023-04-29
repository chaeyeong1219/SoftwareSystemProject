package com.app.Dto;

import java.sql.Date;

public class ItemDto {
	
	private int item_id, itemCategory_id, item_state, like_count, item_stock;
	private String item_name, item_detail;
	private Date item_date;
	
	public int getItem_state() {
		return item_state;
	}

	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getItemCategory_id() {
		return itemCategory_id;
	}

	public void setItemCategory_id(int itemCategory_id) {
		this.itemCategory_id = itemCategory_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public String getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}

	public Date getItem_date() {
		return item_date;
	}

	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}
	
	

}
