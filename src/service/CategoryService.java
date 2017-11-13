package service;

import java.util.List;
import java.util.Map;

import model.Category;
import dao.CategoryDao;

public class CategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	

	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll(){
		return categoryDao.getAll();
	}

	//���
	public boolean add(Category category) {
		return categoryDao.add(category.getName());
	}
	
	//ɾ��
	public boolean delete(Category category){
		return categoryDao.delete(category.getId());
	}
	
	//�޸�
	public boolean update(Category category){
		return categoryDao.update(category.getId(), category.getName());
	}

	//����id��ȡ���
	public Map<String, Object> getCategory(int id) {
		return categoryDao.getCategory(id);
	}

	
}
