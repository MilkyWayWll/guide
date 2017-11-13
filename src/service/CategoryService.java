package service;

import java.util.List;
import java.util.Map;

import model.Category;
import dao.CategoryDao;

public class CategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	

	//获取所有信息
	public List<Map<String, Object>> getAll(){
		return categoryDao.getAll();
	}

	//添加
	public boolean add(Category category) {
		return categoryDao.add(category.getName());
	}
	
	//删除
	public boolean delete(Category category){
		return categoryDao.delete(category.getId());
	}
	
	//修改
	public boolean update(Category category){
		return categoryDao.update(category.getId(), category.getName());
	}

	//根据id获取类别
	public Map<String, Object> getCategory(int id) {
		return categoryDao.getCategory(id);
	}

	
}
