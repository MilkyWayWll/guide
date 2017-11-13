package service;

import java.util.List;
import java.util.Map;

import model.Brand;
import dao.BrandDao;

public class BrandService {

	private BrandDao brandDao = new BrandDao();
	Brand brand = new Brand();
	
	//获取所有信息
	public List<Map<String, Object>> getAll() {
		return brandDao.getAll();
	}
	
	//删除
	public boolean delete(Brand brand) {
		return brandDao.delete(brand.getId());
	}

	//添加
	public boolean add(Brand brand) {
		return brandDao.add(brand.getName());
	}

	//修改
	public boolean update(Brand brand) {
		return brandDao.update(brand.getId(),brand.getName());	
	}

	//根据id获取品牌
	public Map<String, Object> getBrand(int id) {
		return brandDao.getBrand(id);
	}
	
}
