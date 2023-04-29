package com.app.Dto;

import java.sql.Date;

public class GroupItemDto {
	
	private int groupItem_id, groupItem_stock, groupItem_rate, group_num, groupItem_state, like_count;
	private double groupItem_price;
	private String groupItem_name, groupItem_detail;
	private Date groupItem_createDate, groupItem_closeDate;
	
	public int getGroupItem_id() {
		return groupItem_id;
	}
	public void setGroupItem_id(int groupItem_id) {
		this.groupItem_id = groupItem_id;
	}
	public int getGroupItem_stock() {
		return groupItem_stock;
	}
	public void setGroupItem_stock(int groupItem_stock) {
		this.groupItem_stock = groupItem_stock;
	}
	public int getGroupItem_rate() {
		return groupItem_rate;
	}
	public void setGroupItem_rate(int groupItem_rate) {
		this.groupItem_rate = groupItem_rate;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	public int getGroupItem_state() {
		return groupItem_state;
	}
	public void setGroupItem_state(int groupItem_state) {
		this.groupItem_state = groupItem_state;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public double getGroupItem_price() {
		return groupItem_price;
	}
	public void setGroupItem_price(double groupItem_price) {
		this.groupItem_price = groupItem_price;
	}
	public String getGroupItem_name() {
		return groupItem_name;
	}
	public void setGroupItem_name(String groupItem_name) {
		this.groupItem_name = groupItem_name;
	}
	public String getGroupItem_detail() {
		return groupItem_detail;
	}
	public void setGroupItem_detail(String groupItem_detail) {
		this.groupItem_detail = groupItem_detail;
	}
	public Date getGroupItem_createDate() {
		return groupItem_createDate;
	}
	public void setGroupItem_createDate(Date groupItem_createDate) {
		this.groupItem_createDate = groupItem_createDate;
	}
	public Date getGroupItem_closeDate() {
		return groupItem_closeDate;
	}
	public void setGroupItem_closeDate(Date groupItem_closeDate) {
		this.groupItem_closeDate = groupItem_closeDate;
	}
	

}
