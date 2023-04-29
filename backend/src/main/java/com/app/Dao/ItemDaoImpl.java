package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.Dto.ItemDto;

public class ItemDaoImpl {
	
	private Connection conn;
	
	// 데이터베이스 연결 담당 메소드
	public Connection connection()
	{
		//conn = DBConn.getConnection();
		return conn;
	}
	
	// 생필품 추가
	public int insertItem(ItemDto dto) throws SQLException
	{
		int result = 0;
		String sql = "INSERT INTO Item(ITEM_ID, ITEMCATEGORY_ID, ITEM_NAME, ITEM_STOCK, ITEM_DETAIL, ITEM_DATE, ITEM_STATE, LIKE_COUNT)"
				   + " VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getItem_id());
		pstmt.setInt(2, dto.getItemCategory_id());
		pstmt.setString(3, dto.getItem_name());
		pstmt.setInt(4, dto.getItem_stock());
		pstmt.setString(5, dto.getItem_detail());
		pstmt.setDate(6, dto.getItem_date());
		pstmt.setInt(7, dto.getItem_state());
		pstmt.setInt(8, dto.getLike_count());
				
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	// 생필품 리스트 전체 출력
	public ArrayList<ItemDto> lists() throws SQLException
	{
		ArrayList<ItemDto> result = new ArrayList<ItemDto>();
		String sql = "SELECT ITEM_ID, ITEMCATEGORY_ID, ITEM_NAME, ITEM_STOCK, ITEM_DETAIL, ITEM_DATE, ITEM_STATE, LIKE_COUNT FROM ITEM ORDER BY ITEM_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			ItemDto item = new ItemDto();
			item.setItem_id(rs.getInt("ITEM_ID"));
			item.setItemCategory_id(rs.getInt("ITEMCATEGORY_ID"));
			item.setItem_name(rs.getString("ITEM_NAME"));
			item.setItem_stock(rs.getInt("ITEM_STOCK"));
			item.setItem_detail(rs.getString("ITEM_DETAIL"));
			item.setItem_date(rs.getDate("ITEM_DATE"));
			item.setItem_stock(rs.getInt("ITEM_STATE"));
			item.setItem_stock(rs.getInt("LIKE_COUNT"));
			
			result.add(item);
		}
		rs.close();
		pstmt.close();
		return result;
	}
	
	// 생필품 정보 수정
	public int updateItem(ItemDto dto) throws SQLException
	{
		int result = 0;
		String sql = "UPDATE Item SET ITEMCATEGORY_ID=?, ITEM_NAME=?, ITEM_PRICE=?, ITEM_STOCK=?, ITEM_DETAIL=?, ITEM_DATE=?, ITEM_STATE=?, LIKE_COUNT";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getItemCategory_id());
		pstmt.setString(2, dto.getItem_name());
		pstmt.setInt(3, dto.getItem_stock());
		pstmt.setString(4, dto.getItem_detail());
		pstmt.setDate(5, dto.getItem_date());
		pstmt.setInt(6, dto.getItem_state());
		pstmt.setInt(7, dto.getLike_count());
		
		result = pstmt.executeUpdate();
		
		return result;
	}

	// 생필품 정보 삭제
	public int deleteItem(String item_id) throws SQLException
	{
		ItemDto dto = new ItemDto();

		int result = 0;
		String sql = "DELETE FROM ITEM WHERE ITEM_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, item_id);
		result = pstmt.executeUpdate();
		return result;
	}	
}