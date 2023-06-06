package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO implements MemberDAO_interface {

	@Override
	public void insert(MemberVO memberVO) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(null);

			String sql = "INSERT INTO MEMBERS (MEM_ID, MEM_CLASSIFY, MEM_NAME, MEM_ACCOUNT, MEM_PASSWORD, "
					+ "MEM_GENDER, MEM_PHONE, MEM_EMAIL, MEM_ADDRES, MEM_BIRTHDAY, MEM_STATUS, MEM_REGIS_TIME) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, memberVO.getMemberId());
			statement.setInt(2, memberVO.getMemberClassify());
			statement.setString(3, memberVO.getMemberName());
			statement.setString(4, memberVO.getMemberAccount());
			statement.setString(5, memberVO.getMemberPassword());
			statement.setString(6, String.valueOf(memberVO.getMemberGender()));
			statement.setString(7, memberVO.getMemberPhone());
			statement.setString(8, memberVO.getMemberEmail());
			statement.setString(9, memberVO.getMemberAddress());
			statement.setDate(10, new java.sql.Date(memberVO.getMemberBirthday().getTime()));
			statement.setInt(11, memberVO.getMemberStatus());
			statement.setTimestamp(12, new java.sql.Timestamp(memberVO.getMemberRegistrationTime().getTime()));

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer memberID) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberID) {
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		String FIND_BY_PRIMARY_KEY = "SELECT * FROM MEMBERS WHERE MEM_ID = ?";

		MemberVO member = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(FIND_BY_PRIMARY_KEY);
			pstmt.setInt(1, memberID);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new MemberVO();
					member.setMemberId(rs.getInt("MEM_ID"));
					member.setMemberClassify(rs.getInt("MEM_CLASSIFY"));
					member.setMemberName(rs.getString("MEM_NAME"));
					member.setMemberAccount(rs.getString("MEM_ACCOUNT"));
					member.setMemberPassword(rs.getString("MEM_PASSWORD"));
					member.setMemberGender(rs.getString("MEM_GENDER").charAt(0));
					member.setMemberPhone(rs.getString("MEM_PHONE"));
					member.setMemberEmail(rs.getString("MEM_EMAIL"));
					member.setMemberAddress(rs.getString("MEM_ADDRES"));
					member.setMemberBirthday(rs.getDate("MEM_BIRTHDAY"));
					member.setMemberStatus(rs.getInt("MEM_STATUS"));
					member.setMemberRegistrationTime(rs.getDate("MEM_REGIS_TIME"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> resultList = new ArrayList<>();
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		String FIND_BY_PRIMARY_KEY = "SELECT * FROM MEMBERS";

		MemberVO member = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(FIND_BY_PRIMARY_KEY);
			try (ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					member = new MemberVO();
					member.setMemberId(rs.getInt("MEM_ID"));
					member.setMemberClassify(rs.getInt("MEM_CLASSIFY"));
					member.setMemberName(rs.getString("MEM_NAME"));
					member.setMemberAccount(rs.getString("MEM_ACCOUNT"));
					member.setMemberPassword(rs.getString("MEM_PASSWORD"));
					member.setMemberGender(rs.getString("MEM_GENDER").charAt(0));
					member.setMemberPhone(rs.getString("MEM_PHONE"));
					member.setMemberEmail(rs.getString("MEM_EMAIL"));
					member.setMemberAddress(rs.getString("MEM_ADDRES"));
					member.setMemberBirthday(rs.getDate("MEM_BIRTHDAY"));
					member.setMemberStatus(rs.getInt("MEM_STATUS"));
					member.setMemberRegistrationTime(rs.getDate("MEM_REGIS_TIME"));
					resultList.add(member);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
