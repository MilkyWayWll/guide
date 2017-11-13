package service;

import java.util.List;
import java.util.Map;

import model.Position;
import model.User;
import dao.UserDao;

public class UserService {

	UserDao userDao = new UserDao();

	//用户是否存在
	public boolean isUser(User user) {
		if (userDao.getUser(user.getUsername())!=null) {
			return true;
		}return false;
	}
	
	//用户名和密码是否正确
	public boolean isValidate(User user){
		if (userDao.getUser(user.getUsername(), user.getPassword())!=null) {
			return true;
		}
		return false;
	}
	
	//获取所有用户
	public List<Map<String, Object>> getAllUser(){
		List<Map<String, Object>> result = userDao.getAll();
		for (int i = 0; i < result.size(); i++) {
			result.get(i).put("position", userDao.getPosition(result.get(i).get("username").toString()));
		}return result;
	}
	
	//根据id获取用户信息
	public Map<String, Object> getUser(User user) {
		Map<String, Object> result = userDao.getUser(user.getId());
		result.put("position", userDao.getPosition(result.get("username").toString()));
		return result;
	}
	
	//添加用户
	public boolean addUser(User user){
		return userDao.addUser(user);
	}
	
	//删除用户
	public boolean deleteUser(User user){
		return userDao.deleteUser(user);
	}
	
	//跟新用户
	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}

	//获取用户角色
	public Position getPosition(User user) {
		Map<String, Object> result =userDao.getPosition(user.getUsername());
		Position position = new Position();
		position.setName(result.get("name").toString());
		return position;
	}

	//获取所有角色
	public List<Map<String, Object>> getPositions() {
		return userDao.getPositions();
	}


}
