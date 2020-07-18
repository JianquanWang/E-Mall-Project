package tech.oldwang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tech.oldwang.dao.ProductDao;
import tech.oldwang.domain.Category;
import tech.oldwang.domain.Product;
import tech.oldwang.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT * FROM product p, category c WHERE p.cid = c.cid";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setDescription(rs.getString("description"));
				product.setAuthor(rs.getString("author"));
				product.setFilename(rs.getString("filename"));
				product.setPath(rs.getString("path"));
				product.setPrice(rs.getFloat("price"));
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCdesc(rs.getString("cdesc"));
				category.setCname(rs.getString("cname"));
				product.setCategory(category);
				list.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		return list;
	}

}
