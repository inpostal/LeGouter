package com.group.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GroupProductDAO implements GroupProductDAO_interface {

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/LeGouterDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO group_product (GROUP_PRODUCT_NAME,GROUP_PRODUCT_CONTENT,GROUP_PRODUCT_PRICE,GROUP_PRODUCT_STARDATE,GROUP_PRODUCT_STATUS) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT GROUP_PRODUCT_ID,GROUP_PRODUCT_NAME,GROUP_PRODUCT_CONTENT,GROUP_PRODUCT_PRICE,GROUP_PRODUCT_STARDATE,GROUP_PRODUCT_ENDDATE,GROUP_PRODUCT_STATUS FROM group_product order by GROUP_PRODUCT_ID";
	private static final String GET_ONE_STMT = 
		"SELECT GROUP_PRODUCT_ID,GROUP_PRODUCT_NAME,GROUP_PRODUCT_CONTENT,GROUP_PRODUCT_PRICE,GROUP_PRODUCT_STARDATE FROM group_product where GROUP_PRODUCT_ID = ?";
	private static final String DELETE = 
		"DELETE FROM group_product where GROUP_PRODUCT_ID = ?";
	private static final String UPDATE = 
		"UPDATE group_product set GROUP_PRODUCT_NAME=?, GROUP_PRODUCT_CONTENT=?, GROUP_PRODUCT_PRICE=?, GROUP_PRODUCT_STATUS=? where GROUP_PRODUCT_ID = ?";

	@Override
	public void insert(GroupProductVO GroupProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, GroupProductVO.getGroupProductName());
			pstmt.setString(2, GroupProductVO.getGroupProductContent());
			pstmt.setInt(3, GroupProductVO.getGroupProductPrice());
			pstmt.setString(4, GroupProductVO.getGroupProductStardate());
			pstmt.setInt(5, GroupProductVO.getGroupProductStatus());			

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(GroupProductVO GroupProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, GroupProductVO.getGroupProductName());
			pstmt.setString(2, GroupProductVO.getGroupProductContent());
			pstmt.setInt(3, GroupProductVO.getGroupProductPrice());
			pstmt.setInt(4, GroupProductVO.getGroupProductStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer GroupProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, GroupProductVO);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public GroupProductVO findByPrimaryKey(Integer GroupProductVO) {

		GroupProductVO groupProductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, GroupProductVO);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				groupProductVO = new GroupProductVO();
				groupProductVO.setGroupProductId(rs.getInt("GROUP_PRODUCT_ID"));
				groupProductVO.setGroupProductName(rs.getString("GROUP_PRODUCT_NAME"));
				groupProductVO.setGroupProductContent(rs.getString("GROUP_PRODUCT_CONTENT"));
				groupProductVO.setGroupProductPrice(rs.getInt("GROUP_PRODUCT_PRICE"));
				groupProductVO.setGroupProductStardate(rs.getString("GROUP_PRODUCT_STARDATE"));
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return groupProductVO;
	}

	@Override
	public List<GroupProductVO> getAll() {
		List<GroupProductVO> list = new ArrayList<GroupProductVO>();
		GroupProductVO groupProductVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				groupProductVO = new GroupProductVO();
				groupProductVO.setGroupProductId(rs.getInt("GROUP_PRODUCT_ID"));
				groupProductVO.setGroupProductName(rs.getString("GROUP_PRODUCT_NAME"));
				groupProductVO.setGroupProductContent(rs.getString("GROUP_PRODUCT_CONTENT"));
				groupProductVO.setGroupProductPrice(rs.getInt("GROUP_PRODUCT_PRICE"));
				groupProductVO.setGroupProductStardate(rs.getString("GROUP_PRODUCT_STARDATE"));
				groupProductVO.setGroupProductEnddate(rs.getString("GROUP_PRODUCT_ENDDATE"));
				groupProductVO.setGroupProductStatus(rs.getInt("GROUP_PRODUCT_STATUS"));
				list.add(groupProductVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}
