package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;

public class CategoryDao {

	//获取所有信息
	public List<Map<String, Object>> getAll() {
		String sql = "select * from category";
		return DBUtil.queryForList(sql, null);
	}

	public boolean delete(int id) {
		String sql = "delete from category where id = ?";
		return DBUtil.execute(sql, new Integer[]{id});
	}

	//添加
	public boolean add(String name) {
		String sql = "insert into category(name) values(?)";
		return DBUtil.execute(sql, new String[]{name});
	}

	//修改
	public boolean update(int id, String name) {
		String sql = "update category set name = ? where id = ?";
		return DBUtil.execute(sql, new Object[]{name , id});
	}

	//根据id获取类别
	public Map<String, Object> getCategory(int id) {
		String sql = "select * from category where id=?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}
	
	
}
