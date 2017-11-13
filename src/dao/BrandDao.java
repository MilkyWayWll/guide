package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;

public class BrandDao {

	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll() {
		String sql = "select * from brand";
		return DBUtil.queryForList(sql, null);
	}

	public boolean delete(int id) {
		String sql = "delete from brand where id = ?";
		return DBUtil.execute(sql, new Integer[]{id});
	}

	//���
	public boolean add(String name) {
		String sql = "insert into brand(name) values(?)";
		return DBUtil.execute(sql, new String[]{name});
	}

	//�޸�
	public boolean update(int id, String name) {
		String sql = "update brand set name = ? where id = ?";
		return DBUtil.execute(sql, new Object[]{name , id});
	}

	//����id��ȡƷ��
	public Map<String, Object> getBrand(int id) {
		String sql = "select * from brand where id=?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}

}
