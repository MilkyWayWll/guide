package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 简单封装数据库工具类
 * 查询返回结果有数组, List, Map
 * 其他类型语句都调用execute
 * @author YJ
 */
public class DBUtil {
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(getProperties().getProperty("driver"));
			conn = DriverManager.getConnection(getProperties().getProperty("url"), 
					getProperties().getProperty("username"), getProperties().getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 读取配置文件信息
	 * @return
	 */
	private static Properties getProperties(){
		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 查询返回String二维数组
	 * @param sql
	 * @param args
	 * @return
	 */
	public static String[][] queryForArray(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String[][] result = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					stmt.setObject(i + 1, args[i]);
				}
			}
			rs = stmt.executeQuery();
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			result = new String[rows+1][cols];
			for (int i = 0; i < cols; i++) {
				result[0][i] = rsmd.getColumnName(i + 1);
			}
			int currentRow = 1;
			while (rs.next()) {
				for (int i = 0; i < cols; i++) {
					result[currentRow][i] = rs.getObject(i + 1).toString();
				}
				currentRow++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 查询返回List类型
	 * @param sql
	 * @param args
	 * @return 多条记录的List集合
	 */
	public static List<Map<String, Object>> queryForList(String sql,
			Object[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					stmt.setObject(i + 1, args[i]);
				}
			}
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData(); 
			int cols = rsmd.getColumnCount();
			String[] colNames = new String[cols];
			for (int i = 0; i < cols; i++) {
				colNames[i] = rsmd.getColumnName(i + 1);
			}
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<String, Object>();
				for (int i = 0; i < cols; i++) {
					row.put(colNames[i], rs.getObject(i + 1));
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 查询返回Map类型 当确定返回结果唯一时调用
	 * @param sql
	 * @param args
	 * @return 一条记录的Map
	 */
	public static Map<String, Object> queryForMap(String sql, Object[] args) {
		List<Map<String, Object>> result = queryForList(sql, args);
		Map<String, Object> row = null;
		if (result.size() == 1) {
			row = result.get(0);
			return row;
		} else {
			return null;
		}
	}

	/**
	 * 执行除查询外(增加/删除/修改)
	 * @param sql
	 * @param args
	 * @return 是否执行成功
	 */
	public static boolean execute(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean result = true;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					stmt.setObject(i + 1, args[i]);
				}
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
