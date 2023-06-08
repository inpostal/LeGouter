package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO implements IMemberDAO {

	@Override
	public void insert(MemberVO memberVO) {
		String insert = "INSERT INTO MEMBERS (MEM_CLASSIFY, MEM_NAME, MEM_ACCOUNT, MEM_PASSWORD, "
				+ "MEM_GENDER, MEM_PHONE, MEM_EMAIL, MEM_ADDRES, MEM_BIRTHDAY, MEM_STATUS) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(insert);

			pstmt.setInt(1, memberVO.getMemberClassify());
			pstmt.setString(2, memberVO.getMemberName());
			pstmt.setString(3, memberVO.getMemberAccount());
			pstmt.setString(4, memberVO.getMemberPassword());
			pstmt.setString(5, String.valueOf(memberVO.getMemberGender()));
			pstmt.setString(6, memberVO.getMemberPhone());
			pstmt.setString(7, memberVO.getMemberEmail());
			pstmt.setString(8, memberVO.getMemberAddress());
			pstmt.setDate(9, new java.sql.Date(memberVO.getMemberBirthday().getTime()));
			pstmt.setInt(10, memberVO.getMemberStatus());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(MemberVO memberVO) {
		String updateQuery = "UPDATE MEMBERS SET MEM_CLASSIFY = ?, MEM_NAME = ?, MEM_ACCOUNT = ?, MEM_PASSWORD = ?, "
				+ "MEM_GENDER = ?, MEM_PHONE = ?, MEM_EMAIL = ?, MEM_ADDRES = ?, MEM_BIRTHDAY = ?, MEM_STATUS = ? "
				+ "WHERE MEM_ID = ?";
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setInt(1, memberVO.getMemberClassify());
			pstmt.setString(2, memberVO.getMemberName());
			pstmt.setString(3, memberVO.getMemberAccount());
			pstmt.setString(4, memberVO.getMemberPassword());
			pstmt.setString(5, String.valueOf(memberVO.getMemberGender()));
			pstmt.setString(6, memberVO.getMemberPhone());
			pstmt.setString(7, memberVO.getMemberEmail());
			pstmt.setString(8, memberVO.getMemberAddress());
			pstmt.setDate(9, memberVO.getMemberBirthday());
			pstmt.setInt(10, memberVO.getMemberStatus());
			pstmt.setInt(11, memberVO.getMemberId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Integer memberID) {
		String deleteQuery = "DELETE FROM MEMBERS WHERE MEM_ID = ?";
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(deleteQuery);
			pstmt.setInt(1, memberID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberID) {
		String findByPk = "SELECT * FROM MEMBERS WHERE MEM_ID = ?";
		MemberVO member = null;
		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(findByPk);
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

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> resultList = new ArrayList<>();
		String FIND_BY_PRIMARY_KEY = "SELECT * FROM MEMBERS";

		MemberVO member = null;

		InitialContext context = null;
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(FIND_BY_PRIMARY_KEY);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
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
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

}
