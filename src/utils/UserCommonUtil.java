package utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserCommonUtil {

	public static int getcount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		String sql = "select max(u_id) from user";
		try {
			conn = JdbcUtils_C3P0.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.wasNull()){
				BigDecimal lastIdBd = rs.getBigDecimal(1);
			    id = lastIdBd.intValue();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, ps, rs);
		}
		return id;
	}
}
