package action;

import model.Brand;
import model.Category;
import model.Goods;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import service.BrandService;
import service.CategoryService;
import service.GoodsService;

@Action("front")
@Results({
	@Result(name="index",location="/guide/index.jsp"),
	@Result(name="intro",location="/guide/intro.jsp"),
	@Result(name="reindex",type="redirect",location="front!index.action")
})
public class FrontAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private GoodsService goodsService = new GoodsService();
	private BrandService brandService = new BrandService();
	private CategoryService categoryService = new CategoryService();
	private Goods goods;
	private Brand brand;
	private Category category;
	private String goodstr;
	
	//主页
	public String index(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		getRequest().put("goods", goodsService.getAll());
		return "index";
	}
	
	//介绍
	public String intro(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		getRequest().put("goods", goodsService.getGoods(goods));
		return "intro";
	}
	
	//查询商品
	public String query(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		getRequest().put("goods", goodsService.getGoods(goodstr));
		return "index";
	}
	
	//按分类显示
	public String category(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		getRequest().put("goods", goodsService.getGoods(category));
		return "index";
	}
	
	//按品牌显示
	public String brand(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		getRequest().put("goods", goodsService.getGoods(brand));
		return "index";
	}
	
	//退出登录
	public String exit(){
		getSession().remove("user");
		return "reindex";
	}

	
	
	
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getGoodstr() {
		return goodstr;
	}

	public void setGoodstr(String goodstr) {
		this.goodstr = goodstr;
	}
	

	
}
