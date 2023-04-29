package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.Dto.DonationDto;

public class DonationDaoImpl {
	
	private Connection conn;
	
	// 데이터베이스 연결 담당 메소드
	public Connection connection()
	{
		//conn = DBConn.getConnection();
		return conn;
	}
	
	// 기부 상품 추가
	public int insertDonation(DonationDto dto) throws SQLException
	{
		int result = 0;
		String sql = "INSERT INTO Donation(DONATION_ID, DONATION_NAME, TOTALDONATIONPRICE, DONATION_CLOSEDATE, DONATION_DETAIL, LIKE_COUNT, DONATION_CLOSESTATE)"
				   + " VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getDonation_id());
		pstmt.setString(2, dto.getDonation_name());
		pstmt.setDouble(3, dto.getTotalDonationPrice());
		pstmt.setDate(4, dto.getDonation_closeDate());
		pstmt.setString(5, dto.getDonation_detail());
		pstmt.setInt(6, dto.getLike_count());
		pstmt.setInt(7, dto.getDonation_closeState());
				
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	// 기부 상품 리스트 전체 출력
	public ArrayList<DonationDto> lists() throws SQLException
	{
		ArrayList<DonationDto> result = new ArrayList<DonationDto>();
		String sql = "SELECT DONATION_ID, DONATION_NAME, TOTALDONATIONPRICE, DONATION_CLOSEDATE, DONATION_DETAIL, LIKE_COUNT, DONATION_CLOSESTATE FROM DONATION ORDER BY DONATION_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			DonationDto donation = new DonationDto();
			donation.setDonation_id(rs.getInt("Donation_ID"));
			donation.setDonation_name(rs.getString("DONATION_NAME"));
			donation.setTotalDonationPrice(rs.getDouble("TOTALDONATIONPRICE"));
			donation.setDonation_closeDate(rs.getDate("DONATION_CLOSEDATE"));
			donation.setDonation_detail(rs.getString("DONATION_DETAIL"));
			donation.setLike_count(rs.getInt("LIKE_COUNT"));
			donation.setDonation_closeState(rs.getInt("DONATION_CLOSESTATE"));
			
			result.add(donation);
		}
		rs.close();
		pstmt.close();
		return result;
	}
	
	// 기부상품 정보 수정
	public int updateDonation(DonationDto dto) throws SQLException
	{
		int result = 0;
		String sql = "UPDATE DONATION SET DONATION_NAME=?, TOTALDONATIONPRICE=?, DONATION_CLOSEDATE=?, DONATION_DETAIL=?, LIKE_COUNT=?, DONATION_CLOSESTATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getDonation_name());
		pstmt.setDouble(2, dto.getTotalDonationPrice());
		pstmt.setDate(3, dto.getDonation_closeDate());
		pstmt.setString(4, dto.getDonation_detail());
		pstmt.setInt(5, dto.getLike_count());
		pstmt.setInt(6, dto.getDonation_closeState());
		
		result = pstmt.executeUpdate();
		
		return result;
	}

	// 기부 상품 삭제
	public int deleteDonation(String donation_id) throws SQLException
	{
		DonationDto dto = new DonationDto();

		int result = 0;
		String sql = "DELETE FROM DONATION WHERE DONATION_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, donation_id);
		result = pstmt.executeUpdate();
		return result;
	}	
}