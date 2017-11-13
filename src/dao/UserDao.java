package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;
import model.User;

public class UserDao {

	//�����û��������û�
	public Map<String, Object> getUser(String username) {
		String sql = "select * from user where username=?";
		return DBUtil.queryForMap(sql, new String[]{username});
	}
	
	//�����û�������������û�
	public Map<String, Object> getUser(String username, String password) {
		String sql = "select * from user where username=? and password=?";
		return DBUtil.queryForMap(sql, new String[]{username,password});
	}

	//��ȡ�����û�
	public List<Map<String, Object>> getAll(){
		String sql = "select * from user";
		return DBUtil.queryForList(sql, null);
	}
	
	//���
	public boolean addUser(User user) {
		String sql = "insert into user(username,password,position_id) values(?,?,?)";
		DBUtil.execute(sql, new Object[]{user.getUsername(),user.getPassword(),user.getPosition().getId()});
		return false;
	}
	
	//ɾ��
	public boolean deleteUser(User user){
		String sql = "delete from user where id = ?";
		return DBUtil.execute(sql, new Integer[]{user.getId()});
	}
	
	//�޸�
	public boolean updateUser(User user){
		String sql = "update user set username=?,password=?,position_id=? where id=?";
		return DBUtil.execute(sql, new Object[]{user.getUsername(),user.getPassword(),user.getPosition().getId(),user.getId()});
	}

	//����id��ȡ��Ϣ
	public Map<String, Object> getUser(int id) {
		String sql = "select * from user where id = ?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}


	//��ȡ�û���ɫ
	public Map<String, Object> getPosition(String username) {
		String sql = "select p.id,name from position p join user  u on p.id = u.position_id where u.username = ?";
		return DBUtil.queryForMap(sql, new String[]{username});
	}

	//��ȡ���н�ɫ
	public List<Map<String, Object>> getPositions() {
		String sql = "select * from position";
		return DBUtil.queryForList(sql, null);
	}
}
