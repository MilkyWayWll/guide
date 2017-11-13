package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;
import model.Brand;
import model.Category;
import model.Goods;

public class GoodsDao {

	//��ȡ������Ϣ
	public List<Map<String, Object>> getAll(){
		String sql = "select * from goods";
		return DBUtil.queryForList(sql, null);
	}
	
	//���
	public boolean add(Goods goods) {
		String sql = "insert into goods(name,photo,intro,price,place,category_id,brand_id) values(?,?,?,?,?,?,?)";
		DBUtil.execute(sql, new Object[]{goods.getName(),goods.getPhoto(),goods.getIntro(),goods.getPrice(),goods.getPlace(),goods.getCategory().getId(),goods.getBrand().getId()});
		return false;
	}
	
	//ɾ��
	public boolean delete(int id){
		String sql = "delete from goods where id = ?";
		return DBUtil.execute(sql, new Integer[]{id});
	}
	
	//�޸�
	public boolean update(Goods goods){
		String sql = "update goods set name=?,photo=?,intro=?,price=?,place=?,category_id=?,brand_id=? where id=?";
		return DBUtil.execute(sql, new Object[]{goods.getName(),goods.getPhoto(),goods.getIntro(),goods.getPrice(),goods.getPlace(),goods.getCategory().getId(),goods.getBrand().getId(),goods.getId()});
	}

	//����id��ȡ��Ϣ
	public Map<String, Object> getGoods(int id) {
		String sql = "select * from goods where id = ?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}

	//�������ȡ��Ʒ
	public List<Map<String, Object>> getGoods(Category category) {
		String sql = "select * from goods where category_id=?";
		return DBUtil.queryForList(sql, new Integer[]{category.getId()});
	}

	//��Ʒ�ƻ�ȡ��Ʒ
	public List<Map<String, Object>> getGoods(Brand brand) {
		String sql = "select * from goods where brand_id=?";
		return DBUtil.queryForList(sql, new Integer[]{brand.getId()});
	}

	//������Ʒ����ȡ��Ʒ��Ϣ(ģ����ѯ)
	public List<Map<String, Object>> getGoods(String goodstr) {
		String sql = "select * from goods where name like '%"+goodstr+"%'";
		return DBUtil.queryForList(sql, null);
	}

}
