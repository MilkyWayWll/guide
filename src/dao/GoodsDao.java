package dao;

import java.util.List;
import java.util.Map;

import util.DBUtil;
import model.Brand;
import model.Category;
import model.Goods;

public class GoodsDao {

	//获取所有信息
	public List<Map<String, Object>> getAll(){
		String sql = "select * from goods";
		return DBUtil.queryForList(sql, null);
	}
	
	//添加
	public boolean add(Goods goods) {
		String sql = "insert into goods(name,photo,intro,price,place,category_id,brand_id) values(?,?,?,?,?,?,?)";
		DBUtil.execute(sql, new Object[]{goods.getName(),goods.getPhoto(),goods.getIntro(),goods.getPrice(),goods.getPlace(),goods.getCategory().getId(),goods.getBrand().getId()});
		return false;
	}
	
	//删除
	public boolean delete(int id){
		String sql = "delete from goods where id = ?";
		return DBUtil.execute(sql, new Integer[]{id});
	}
	
	//修改
	public boolean update(Goods goods){
		String sql = "update goods set name=?,photo=?,intro=?,price=?,place=?,category_id=?,brand_id=? where id=?";
		return DBUtil.execute(sql, new Object[]{goods.getName(),goods.getPhoto(),goods.getIntro(),goods.getPrice(),goods.getPlace(),goods.getCategory().getId(),goods.getBrand().getId(),goods.getId()});
	}

	//根据id获取信息
	public Map<String, Object> getGoods(int id) {
		String sql = "select * from goods where id = ?";
		return DBUtil.queryForMap(sql, new Integer[]{id});
	}

	//按分类获取商品
	public List<Map<String, Object>> getGoods(Category category) {
		String sql = "select * from goods where category_id=?";
		return DBUtil.queryForList(sql, new Integer[]{category.getId()});
	}

	//按品牌获取商品
	public List<Map<String, Object>> getGoods(Brand brand) {
		String sql = "select * from goods where brand_id=?";
		return DBUtil.queryForList(sql, new Integer[]{brand.getId()});
	}

	//根据商品名获取商品信息(模糊查询)
	public List<Map<String, Object>> getGoods(String goodstr) {
		String sql = "select * from goods where name like '%"+goodstr+"%'";
		return DBUtil.queryForList(sql, null);
	}

}
