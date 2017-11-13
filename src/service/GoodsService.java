package service;

import java.util.List;
import java.util.Map;

import model.Brand;
import model.Category;
import model.Goods;
import dao.BrandDao;
import dao.CategoryDao;
import dao.GoodsDao;

public class GoodsService {

	private GoodsDao goodsDao = new GoodsDao();
	private BrandDao brandDao = new BrandDao();
	private CategoryDao categoryDao = new CategoryDao();

	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll(){
		List<Map<String, Object>> result = (List<Map<String, Object>>)goodsDao.getAll();
		for (int i = 0; i < result.size(); i++) {
			result.get(i).put("brand", brandDao.getBrand((int)result.get(i).get("brand_id")));
			result.get(i).put("category", categoryDao.getCategory((int)result.get(i).get("category_id")));
		}
		return result;
	}

	//���
	public boolean add(Goods goods) {
		return goodsDao.add(goods);
	}
	
	//ɾ��
	public boolean delete(Goods goods){
		return goodsDao.delete(goods.getId());
	}
	
	//�޸�
	public boolean update(Goods goods){
		return goodsDao.update(goods);
	}
	
	//����id��ȡ��Ϣ
	public Map<String, Object> getGoods(Goods goods) {
		Map<String, Object> result = goodsDao.getGoods(goods.getId());
		result.put("brand", brandDao.getBrand((int)result.get("brand_id")));
		result.put("category", categoryDao.getCategory((int)result.get("category_id")));
		return result;
	}

	//�������ȡ��Ʒ
	public List<Map<String, Object>> getGoods(Category category) {
		List<Map<String, Object>> result = goodsDao.getGoods(category);
		for (int i = 0; i < result.size(); i++) {
			result.get(i).put("brand", brandDao.getBrand((int)result.get(i).get("brand_id")));
			result.get(i).put("category", categoryDao.getCategory((int)result.get(i).get("category_id")));
		}
		return result;
	}

	//��Ʒ�ƻ�ȡ��Ʒ
	public List<Map<String, Object>> getGoods(Brand brand) {
		List<Map<String, Object>> result = goodsDao.getGoods(brand);
		for (int i = 0; i < result.size(); i++) {
			result.get(i).put("brand", brandDao.getBrand((int)result.get(i).get("brand_id")));
			result.get(i).put("category", categoryDao.getCategory((int)result.get(i).get("category_id")));
		}
		return result;
	}

	//������Ʒ����ȡ��Ʒ��Ϣ
	public List<Map<String, Object>> getGoods(String goodstr) {
		return goodsDao.getGoods(goodstr);
	}

}
