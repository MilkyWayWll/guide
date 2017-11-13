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
 * �򵥷�װ���ݿ⹤����
 * ��ѯ���ؽ��������, List, Map
 * ����������䶼����execute
 * @author YJ
 */
public class DBUtil {
	
	/**
	 * ������ݿ�����
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
	 * ��ȡ�����ļ���Ϣ
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
	 * ��ѯ����String��ά����
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
	 * ��ѯ����List����
	 * @param sql
	 * @param args
	 * @return ������¼��List����
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
	 * ��ѯ����Map���� ��ȷ�����ؽ��Ψһʱ����
	 * @param sql
	 * @param args
	 * @return һ����¼��Map
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
	 * ִ�г���ѯ��(����/ɾ��/�޸�)
	 * @param sql
	 * @param args
	 * @return �Ƿ�ִ�гɹ�
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
