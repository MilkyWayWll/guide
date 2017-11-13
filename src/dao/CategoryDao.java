package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;

public class CategoryDao {

	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll() {
		String sql = "select * from category";
		return DBUtil.queryForList(sql, null);
	}

	public boolean delete(int id) {
		String sql = "delete from category where id = ?";
		return DBUtil.execute(sql, new Integer[]{id});
	}

	//���
	public boolean add(String name) {
		String sql = "insert into category(name) values(?)";
		return DBUtil.execute(sql, new String[]{name});
	}

	//�޸�
	public boolean update(int id, String name) {
		String sql = "update category set name = ? where id = ?";
		return DBUtil.execute(sql, new Object[]{name , id});
	}

	//����id��ȡ���
	public Map<String, Object> getCategory(int id) {
		String sql = "select * from category where id=?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}
	
	
}
