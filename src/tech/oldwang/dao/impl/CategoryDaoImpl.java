package tech.oldwang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tech.oldwang.dao.CategoryDao;
import tech.oldwang.domain.Category;
import tech.oldwang.utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Category> list = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT * FROM category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Category>();
			while(rs.next()) {
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				category.setCdesc(rs.getString("cdesc"));
				list.add(category);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void save(Category category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "INSERT INTO category VALUES (NULL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getCname());
			pstmt.setString(2, category.getCdesc());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
		
	}

	@Override
	public Category findOne(Integer cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT * FROM category where cid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				category.setCdesc(rs.getString("cdesc"));
				return category;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public void update(Category category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "UPDATE category SET cname = ?, cdesc = ? where cid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getCname());
			pstmt.setString(2, category.getCdesc());
			pstmt.setInt(3, category.getCid());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
		
	}

	@Override
	public void delete(Integer cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "DELETE FROM category where cid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}

}
