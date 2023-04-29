package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.Dto.GroupItemDto;

public class GroupItemDaoImpl {
	
	private Connection conn;
	
	// 데이터베이스 연결 담당 메소드
	public Connection connection()
	{
		//conn = DBConn.getConnection();
		return conn;
	}
	
	// 공동구매상품 추가
	public int insertGroupItem(GroupItemDto dto) throws SQLException
	{
		int result = 0;
		String sql = "INSERT INTO GROUPITEM(GROUPITEM_ID, GROUPITEM_NAME, GROUPITEM_DETAIL, GROUPITEM_STOCK, GROUPITEM_PRICE, GROUPITEM_RATE, GROUP_NUM, GROUPITEM_STATE, GROUPITEM_CREATEDDATE, GROUPITEM_CLOSEDATE, LIKE_COUNT)"
				   + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getGroupItem_id());
		pstmt.setString(2, dto.getGroupItem_name());
		pstmt.setString(3, dto.getGroupItem_detail());
		pstmt.setInt(4, dto.getGroupItem_stock());
		pstmt.setDouble(5, dto.getGroupItem_price());
		pstmt.setInt(6, dto.getGroupItem_rate());
		pstmt.setInt(7, dto.getGroup_num());
		pstmt.setInt(8, dto.getGroupItem_state());
		pstmt.setDate(9, dto.getGroupItem_createDate());
		pstmt.setDate(10, dto.getGroupItem_closeDate());
		pstmt.setInt(11, dto.getLike_count());
				
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	// 공동구매 상품 리스트 전체 출력
	public ArrayList<GroupItemDto> lists() throws SQLException
	{
		ArrayList<GroupItemDto> result = new ArrayList<GroupItemDto>();
		String sql = "SELECT GROUPITEM_ID, GROUPITEM_NAME, GROUPITEM_DETAIL, GROUPITEM_STOCK, GROUPITEM_PRICE, GROUPITEM_RATE, GROUP_NUM, GROUPITEM_STATE, GROUPITEM_CREATEDDATE, GROUPITEM_CLOSEDATE, LIKE_COUNT FROM GROUPITEM ORDER BY GROUPITEM_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			GroupItemDto groupItem = new GroupItemDto();
			groupItem.setGroupItem_id(rs.getInt("GROUPITEM_ID"));
			groupItem.setGroupItem_name(rs.getString("GROUPITEM_NAME"));
			groupItem.setGroupItem_detail(rs.getString("GROUPITEM_DETAIL"));
			groupItem.setGroupItem_stock(rs.getInt("GROUPITEM_STOCK"));
			groupItem.setGroupItem_price(rs.getInt("GROUPITEM_PRICE"));
			groupItem.setGroupItem_rate(rs.getInt("GROUPITEM_RATE"));
			groupItem.setGroup_num(rs.getInt("GROUP_NUM"));
			groupItem.setGroupItem_state(rs.getInt("GROUPITEM_STATE"));
			groupItem.setGroupItem_createDate(rs.getDate("GROUPITEM_CREATEDATE"));
			groupItem.setGroupItem_closeDate(rs.getDate("GROUPITEM_CLOSEDATE"));
			groupItem.setLike_count(rs.getInt("LIKE_COUNT"));
	
			result.add(groupItem);
		}
		rs.close();
		pstmt.close();
		return result;
	}
	
	// 공동구매상품 정보 수정
	public int updateDonation(GroupItemDto dto) throws SQLException
	{
		int result = 0;
		String sql = "UPDATE GROUPITEM SET GROUPITEM_ID=?, GROUPITEM_NAME=?, GROUPITEM_DETAIL=?, GROUPITEM_STOCK=?, GROUP_NUM=?, GROUPITEM_STATE=?, GROUPITEM_CREATEDDATE=?, GROUPITEM_CLOSEDATE=?, LIKE_COUNT=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getGroupItem_id());
		pstmt.setString(2, dto.getGroupItem_name());
		pstmt.setString(3, dto.getGroupItem_detail());
		pstmt.setInt(4, dto.getGroupItem_stock());
		pstmt.setInt(5, dto.getGroup_num());
		pstmt.setInt(6, dto.getGroupItem_state());
		pstmt.setDate(7, dto.getGroupItem_createDate());
		pstmt.setDate(8, dto.getGroupItem_closeDate());
		pstmt.setInt(5, dto.getLike_count());
		
		result = pstmt.executeUpdate();
		
		return result;
	}

	// 공동구매 상품 삭제
	public int deleteGroupItem(String groupItem_id) throws SQLException
	{
		GroupItemDto dto = new GroupItemDto();

		int result = 0;
		String sql = "DELETE FROM GROUPITEM WHERE GROUPITEM_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, groupItem_id);
		result = pstmt.executeUpdate();
		return result;
	}	
}