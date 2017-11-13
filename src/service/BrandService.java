package service;

import java.util.List;
import java.util.Map;

import model.Brand;
import dao.BrandDao;

public class BrandService {

	private BrandDao brandDao = new BrandDao();
	Brand brand = new Brand();
	
	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll() {
		return brandDao.getAll();
	}
	
	//ɾ��
	public boolean delete(Brand brand) {
		return brandDao.delete(brand.getId());
	}

	//���
	public boolean add(Brand brand) {
		return brandDao.add(brand.getName());
	}

	//�޸�
	public boolean update(Brand brand) {
		return brandDao.update(brand.getId(),brand.getName());	
	}

	//����id��ȡƷ��
	public Map<String, Object> getBrand(int id) {
		return brandDao.getBrand(id);
	}
	
}
