package tech.oldwang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tech.oldwang.dao.UserDao;
import tech.oldwang.domain.User;
import tech.oldwang.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// get connection
			conn = JDBCUtils.getConnection();
			// organize SQL
			String sql = "select * from user where username = ? and password = ?";
			// pre-compile SQL
			pstmt = conn.prepareStatement(sql);
			// set SQL parameter
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			// execute SQL
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User existUser = new User();
				existUser.setUid(rs.getInt("uid"));
				existUser.setUsername(rs.getString("username"));
				existUser.setPassword(rs.getString("password"));
				return existUser;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}
		return null;
	}
	
}
