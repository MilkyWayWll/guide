package service;

import java.util.List;
import java.util.Map;

import model.Position;
import model.User;
import dao.UserDao;

public class UserService {

	UserDao userDao = new UserDao();

	//�û��Ƿ����
	public boolean isUser(User user) {
		if (userDao.getUser(user.getUsername())!=null) {
			return true;
		}return false;
	}
	
	//�û����������Ƿ���ȷ
	public boolean isValidate(User user){
		if (userDao.getUser(user.getUsername(), user.getPassword())!=null) {
			return true;
		}
		return false;
	}
	
	//��ȡ�����û�
	public List<Map<String, Object>> getAllUser(){
		List<Map<String, Object>> result = userDao.getAll();
		for (int i = 0; i < result.size(); i++) {
			result.get(i).put("position", userDao.getPosition(result.get(i).get("username").toString()));
		}return result;
	}
	
	//����id��ȡ�û���Ϣ
	public Map<String, Object> getUser(User user) {
		Map<String, Object> result = userDao.getUser(user.getId());
		result.put("position", userDao.getPosition(result.get("username").toString()));
		return result;
	}
	
	//����û�
	public boolean addUser(User user){
		return userDao.addUser(user);
	}
	
	//ɾ���û�
	public boolean deleteUser(User user){
		return userDao.deleteUser(user);
	}
	
	//�����û�
	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}

	//��ȡ�û���ɫ
	public Position getPosition(User user) {
		Map<String, Object> result =userDao.getPosition(user.getUsername());
		Position position = new Position();
		position.setName(result.get("name").toString());
		return position;
	}

	//��ȡ���н�ɫ
	public List<Map<String, Object>> getPositions() {
		return userDao.getPositions();
	}


}
